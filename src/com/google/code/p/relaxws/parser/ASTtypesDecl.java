/* Generated By:JJTree: Do not edit this line. ASTtypesDecl.java */

package com.google.code.p.relaxws.parser;

import com.google.code.p.relaxws.parser.SimpleNode;
import com.google.code.p.relaxws.parser.RelaxWizParser;
import com.google.code.p.relaxws.parser.ASTrnc;

public class ASTtypesDecl extends SimpleNode {
    public ASTtypesDecl(int id) {
        super(id);
    }

    public ASTtypesDecl(RelaxWizParser p, int id) {
        super(p, id);
    }

    public String getRnc() {
        if (children.length > 0) {
            return ((ASTrnc) children[0].jjtGetChild(0)).getRnc();
        }
        return null;
    }

}
