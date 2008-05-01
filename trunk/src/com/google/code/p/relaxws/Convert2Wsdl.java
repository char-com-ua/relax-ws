/*
 * Copyright 2008 Jason Sando
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.google.code.p.relaxws;

import com.thaiopensource.relaxng.edit.SchemaCollection;
import com.thaiopensource.relaxng.input.InputFailedException;
import com.thaiopensource.relaxng.input.InputFormat;
import com.thaiopensource.relaxng.input.parse.compact.CompactParseInputFormat;
import com.thaiopensource.relaxng.output.LocalOutputDirectory;
import com.thaiopensource.relaxng.output.OutputDirectory;
import com.thaiopensource.relaxng.output.OutputFormat;
import com.thaiopensource.relaxng.output.xsd.XsdOutputFormat;
import com.thaiopensource.xml.sax.ErrorHandlerImpl;
import com.google.code.p.relaxws.parser.*;

import java.io.*;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;


/**
 * Convert from relaxws-wiz to wsdl.
 *
 * 1. parse the input file
 * 2. append all rnc blocks into a single buffer, then convert to XSD, to be
 *    embedded in the wsdl.
 * 3. Output wsdl.
 */
public class Convert2Wsdl {

    private PrintWriter out;
    private ASTservice tree;

    private static void usage (String reason) {
        if (reason != null)
            System.err.println ("Command failed: " + reason);
        System.err.println ("\nUSAGE:");
        System.err.println("Convert2Wsdl [-d output-folder] <input.rws>");
        System.exit (1);
    }

    private static void fail (String reason) {
        if (reason != null)
            System.err.println ("Command failed: " + reason);
        System.exit (1);
    }

    private static String fileBase (String name) {
        int dot = name.lastIndexOf('.');
        if (dot != -1) {
            name = name.substring (0, dot);
        }
        return name;
    }

    public static void main(String[] args) throws Exception {

        String outputPath = null;
        String inputFilePath = null;

        int lastArg = args.length - 1;
        for (int i = 0; i < args.length; i++) {
            if ("-d".equals (args[i]) && (i < lastArg)) {
                outputPath = args[i + 1];
                i++;
            } else if (args[i].startsWith("-")) {
                usage("unrecognized option " + args[i]);                
            } else {
                if (inputFilePath != null) {
                    usage("Multiple input files specified: " + inputFilePath + "," + args[i]);
                }
                inputFilePath = args[i];
            }
        }

        if (inputFilePath == null) {
            usage(null);
        }

        File inputFile = new File (inputFilePath);
        if (!inputFile.exists()) {
            fail ("'" + inputFilePath + "' not found.");
        }
        if (outputPath == null) {
            outputPath = inputFile.getParent();
        }

        File outputFileDir = new File (outputPath);
        if (!outputFileDir.exists()) {
            if (!outputFileDir.mkdirs()) {
                fail ("failed to create output folder '" + outputPath + "'");
            }
        }

        BufferedReader rdr = new BufferedReader (new FileReader(inputFile));
        RelaxWizParser p = new RelaxWizParser (rdr);
        ASTservice tree = p.service ();

        File outputFile = new File(outputFileDir, fileBase(inputFile.getName()) + ".wsdl");
        System.err.println("Convert2Wsdl: processing '" + inputFile.getName() + "' to '" + outputFile.getPath());

        PrintWriter out = new PrintWriter(new FileWriter(outputFile));

        Convert2Wsdl converter = new Convert2Wsdl();
        converter.out = out;
        converter.tree = tree;
        converter.convert();

        out.close();
    }

    private void convert() throws Exception {

        if (tree.getNamespace() == null) {
            tree.setNamespace("http://tempuri.org/" + tree.getName());
        }
        String ns = tree.getNamespace();

        out.print ("<?xml version=\"1.0\"?>\n");
        out.print ("<definitions name=\"" + tree.getName() + "\"\n" +
                "             targetNamespace=\"" + ns + "\"\n" +
                "             xmlns:tns=\"" + ns + "\"\n" +
                "             xmlns:soap=\"http://schemas.xmlsoap.org/wsdl/soap/\"\n" +
                "             xmlns=\"http://schemas.xmlsoap.org/wsdl/\">\n" +
                "\n" +
                "  <types>\n");

        // Make a pass through and assign all message names, and build proper rnc block
        Set<String> messageNames = new HashSet<String>();
        StringBuffer rncBuff = new StringBuffer();
        rncBuff.append ("default namespace = \"" + ns + "\"\n");
//        rncBuff.append ("(\n");
        for (Node portNode: tree.getChildren()) {
            if (portNode instanceof ASTtypesDecl) {
                rncBuff.append(((ASTtypesDecl) portNode).getRnc());
                continue;
            }

            ASTportDecl port = (ASTportDecl) portNode;

            // patch up default name if not set.
            if (port.getName() == null) {
                port.setName (tree.getName() + "Port");
            }

            // enumerate operations in this port
            for (Node opNode: port.getChildren()) {
                ASToperationDecl op = (ASToperationDecl) opNode;

                // children of op node
                for (Node msgNode: op.getChildren()) {
                    ASTMessageDef message = (ASTMessageDef) msgNode;
                    message.setDefaultMessageName(op.getName());

                    if (messageNames.contains(message.getMessageName())) {
                        // todo: loop searching for unique name
                        message.setMessageName(message.getMessageName() + "1");
                    } else {
                        messageNames.add(message.getMessageName());
                    }

                    if (message.getName() == null) {
                        message.setDefaultName (op.getName());
                    }

                    rncBuff.append (message.getName() + " = ");
                    rncBuff.append ("element " + message.getName() + " {\n");
                    String s = message.getRnc();
                    if (s.trim().length() == 0) {
                        s = "text";
                    }
                    rncBuff.append (s);
                    rncBuff.append ("}\n");
                }
            }
        }
//        rncBuff.append (")");

        // convert rnc to xsd
        String xsdText = toXsd(rncBuff.toString());
        out.print (xsdText);

        out.print ("  </types>\n");

        // declare messages for each in and out of each operation for each port (must be unique)
        out.println ();
        for (Node portNode: tree.getChildren()) {

            if (portNode instanceof ASTtypesDecl) {
                continue;
            }

            ASTportDecl port = (ASTportDecl) portNode;

            // enumerate operations in this port
            for (Node opNode: port.getChildren()) {
                ASToperationDecl op = (ASToperationDecl) opNode;

                // children of op node
                for (Node msgNode: op.getChildren()) {
                    ASTMessageDef message = (ASTMessageDef) msgNode;
                    // declare message type
                    out.println ("  <message name=\"" + message.getMessageName() + "\">");
                    out.println ("    <part name=\"body\" element=\"tns:" + message.getName() + "\"/>");
                    out.println ("  </message>");
                }

            }

            out.println ();
            out.println ("  <portType name=\"" + port.getName() + "\">");
            for (Node opNode: port.getChildren()) {
                ASToperationDecl op = (ASToperationDecl) opNode;

                out.println ("    <operation name=\"" + op.getName() + "\">");

                // children of op node
                for (Node msgNode: op.getChildren()) {
                    ASTMessageDef message = (ASTMessageDef) msgNode;

                    switch (message.getType()) {
                        case In:
                            out.println ("      <input message=\"tns:" + message.getMessageName() + "\"/>");
                            break;

                        case Out:
                            out.println ("      <output message=\"tns:" + message.getMessageName() + "\"/>");
                            break;

                        case Fault:
                            out.println ("      <fault message=\"tns:" + message.getMessageName() + "\"/>");
                            break;
                    }
                }

                out.println ("    </operation>");
            }
            out.println ("  </portType>");

            // binding to soap
            out.println ();
            out.println ("  <binding name=\"" + port.getName() + "SoapBinding\" type=\"tns:" + port.getName() + "\">");
            out.println ("    <soap:binding style=\"document\" transport=\"http://schemas.xmlsoap.org/soap/http\"/>");
            for (Node opNode: port.getChildren()) {
                ASToperationDecl op = (ASToperationDecl) opNode;

                out.println ("    <operation name=\"" + op.getName() + "\">");
                out.println ("      <soap:operation soapAction=\"" + ns + "/" + port.getName() + "#" + op.getName() + "\"/>");
                out.println ("      <input>\n" +
                        "        <soap:body use=\"literal\"/>\n" +
                        "      </input>\n" +
                        "      <output>\n" +
                        "        <soap:body use=\"literal\"/>\n" +
                        "      </output>\n" +
                        "      <fault>\n" +
                        "        <soap:body use=\"literal\"/>\n" +
                        "      </fault>");
                out.println ("    </operation>");
            }
            out.println ("  </binding>");

            out.println();
            out.println ("  <service name=\"" + tree.getName() + port.getName() + "Service\">\n" +
                    "    <port name=\"" + port.getName() + "\" binding=\"tns:" + port.getName() + "SoapBinding\">\n" +
                    "      <soap:address location=\"http://example.com/" + tree.getName() + "\"/>\n" +
                    "    </port>\n" +
                    "  </service>");
        }


        out.print ("</definitions>\n");
    }

    private static String toXsd (String rnc) throws Exception {

        // write the rnc to a temp file
        File rncInput = File.createTempFile("relaxwiz", ".rnc");
        FileWriter fw = new FileWriter (rncInput);
        fw.write(rnc);
        fw.close();

        // Use Trang to convert to an XSD file
        InputFormat inFormat = new CompactParseInputFormat();
        ErrorHandlerImpl handler = new ErrorHandlerImpl();
        SchemaCollection sc = null;
        try {
            sc = inFormat.load(new URL("file", "", rncInput.getAbsolutePath()).toString(), new String[0], "xsd", handler);
        } catch (InputFailedException e) {
            System.err.println("Error in RNC preprocessor, source follows:");
            int line = 0;
            for (String s: rnc.split("\n")) {
                line++;
                System.err.printf("%3d: %s\n", line, s);
            }
            System.exit (1);
        }
        OutputFormat of = new XsdOutputFormat();
        File xsdOutput = File.createTempFile("relaxwiz", ".xsd");
        OutputDirectory od = new LocalOutputDirectory(sc.getMainUri(),
                                                      xsdOutput,
                                                      "xsd",
                                                      "UTF-8",
                                                      80,
                                                      2);
        String[] outParams = new String[]{new URL("file", "", xsdOutput.getAbsolutePath()).toString()};
        of.output(sc, od, new String[]{}, "rnc", handler);

        // read in file and return as string.
        BufferedReader reader = new BufferedReader(new FileReader (xsdOutput));
        String line;
        StringBuffer buf = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("<?xml")) {
                continue;
            }
            buf.append (line).append ('\n');
        }
        reader.close();
        return buf.toString();
    }

}
