package com.gamewolf.util.ui;

import java.util.List;

public interface ParameterUserInterfaceMapping {
	
	public List<String> getParameterList(String functionName);
	
	public List<String> getFunctionList();
	
	
	public void addFunction(String functionName);
	
	public void addParameter(String functionName,String parameterName,InterfaceMapping map);
	

}
