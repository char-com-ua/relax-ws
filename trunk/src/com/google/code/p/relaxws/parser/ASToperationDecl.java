/* Generated By:JJTree: Do not edit this line. ASToperationDecl.java */

package com.google.code.p.relaxws.parser;

import com.google.code.p.relaxws.parser.SimpleNode;
import com.google.code.p.relaxws.parser.RelaxWizParser;

public class ASToperationDecl extends SimpleNode {

    private String name;

  public ASToperationDecl(int id) {
    super(id);
  }

  public ASToperationDecl(RelaxWizParser p, int id) {
    super(p, id);
  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    private String documentation=null;
    public void setDocumentation(String documentation) {
    	if(documentation!=null && documentation.length()>0)this.documentation = documentation;
    }
    public String getDocumentation() {
        return documentation;
    }
}
