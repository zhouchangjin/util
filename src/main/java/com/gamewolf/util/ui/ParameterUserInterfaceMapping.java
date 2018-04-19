package com.gamewolf.util.ui;

import java.util.List;

public interface ParameterUserInterfaceMapping {
	
	public List<String> getParameterList(String functionName);
	
	public List<String> getFunctionList();
	
	public InterfaceMapping getParameter(String functionName,String parametername);
	
	public void addParameter(String functionName,String parameterName,InterfaceMapping map);
	

}
