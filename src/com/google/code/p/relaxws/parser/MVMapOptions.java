package com.google.code.p.relaxws.parser;

public class MVMapOptions extends MVMap {
	/**
		String[][] keys={ 
				"name",          //name of the value
				"pattern",       //validator for the values
				Boolean.FALSE,   //multivalue
				Boolean.TRUE,    //unique. used only if multivalue is true
				"initial value"
		}
	*/
	static Object params [][]={
		{
			"fully-qualified",      //name of the value
			"^(true|false)$",       //validator for the values
			Boolean.FALSE,          //multivalue
			Boolean.TRUE,           //unique. used only if multivalue is true
			"true"
		},
		{
			"in-suffix",            //name of the value
			".*",                   //validator for the values
			Boolean.FALSE,          //multivalue
			Boolean.TRUE,           //unique. used only if multivalue is true
			"Request"
		},
		{
			"out-suffix",      //name of the value
			".*",              //validator for the values
			Boolean.FALSE,     //multivalue
			Boolean.TRUE,      //unique. used only if multivalue is true
			"Response"
		},
		{
			"fault-suffix",    //name of the value
			".*",              //validator for the values
			Boolean.FALSE,     //multivalue
			Boolean.TRUE,      //unique. used only if multivalue is true
			"Fault"
		}
	};
	
	public MVMapOptions(){
		super("options", params);
	}
}


