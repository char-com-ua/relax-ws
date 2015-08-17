package com.google.code.p.relaxws.trang;

import com.thaiopensource.xml.util.EncodingMap;
import com.thaiopensource.xml.out.CharRepertoire;
import com.thaiopensource.relaxng.output.OutputDirectory;

import java.io.IOException;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.HashMap;

public class SingleFileOutputDirectory implements OutputDirectory {
  private final File mainOutputFile;
  private final String mainSourceUri;
  private final String lineSeparator;
  private final String outputExtension;
  private String defaultEncoding;
  private boolean alwaysUseDefaultEncoding;
  private final int lineLength;
  // maps URIs to filenames
  private final Map<String, String> uriMap = new HashMap<String, String>();
  private final String mainInputExtension;
  private int indent;
  
  //private OutputDirectory.Stream stream;

  public SingleFileOutputDirectory(String mainSourceUri, File mainOutputFile, String extension,
                              String encoding, int lineLength, int indent) {
    this.mainOutputFile = mainOutputFile;
	this.mainSourceUri = mainSourceUri;
    this.outputExtension = extension;
    this.defaultEncoding = encoding;
    this.lineSeparator = System.getProperty("line.separator");
    this.lineLength = lineLength;
    this.indent = indent;
    this.uriMap.put(mainSourceUri, mainOutputFile.getName());
	//this.stream=null;
    int slashOff = mainSourceUri.lastIndexOf('/');
    int dotOff = mainSourceUri.lastIndexOf('.');
    this.mainInputExtension = dotOff > 0 && dotOff > slashOff ? mainSourceUri.substring(dotOff) : "";
  }

  public void setEncoding(String encoding) {
    defaultEncoding = encoding;
    alwaysUseDefaultEncoding = true;
  }

  public OutputDirectory.Stream open(String sourceUri, String encoding) throws IOException {
    OutputDirectory.Stream stream;
	
		if (encoding == null || alwaysUseDefaultEncoding)
		  encoding = defaultEncoding;
		String javaEncoding = EncodingMap.getJavaName(encoding);
		File file = mainOutputFile;
		stream = new OutputDirectory.Stream(
							new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file,true)), javaEncoding),
							encoding,
							CharRepertoire.getInstance(javaEncoding)
						);
	return stream;
  }

  public String reference(String fromSourceUri, String toSourceUri) {
    return this.uriMap.get( this.mainSourceUri ); //always the same file
  }

  public String getLineSeparator() {
    return lineSeparator;
  }

  public int getLineLength() {
    return lineLength;
  }

  public int getIndent() {
    return indent;
  }

  public void setIndent(int indent) {
    this.indent = indent;
  }
}
