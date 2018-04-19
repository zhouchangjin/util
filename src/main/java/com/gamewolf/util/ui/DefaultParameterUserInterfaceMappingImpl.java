package com.gamewolf.util.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DefaultParameterUserInterfaceMappingImpl implements ParameterUserInterfaceMapping {
	
	List<String> functionList;
	HashMap<String,List<String>> functionMap;
	HashMap<String,InterfaceMapping> interfaceMapping;
	
	public DefaultParameterUserInterfaceMappingImpl() {
		functionList=new ArrayList<String>();
		functionMap=new HashMap<String,List<String>>();
		interfaceMapping=new HashMap<String,InterfaceMapping>();
	}

	public List<String> getParameterList(String functionName) {
		// TODO Auto-generated method stub
		return functionMap.get(functionName);
	}

	public List<String> getFunctionList() {
		// TODO Auto-generated method stub
		return functionList;
	}

	public InterfaceMapping getParameter(String functionName, String parametername) {
		// TODO Auto-generated method stub
		return this.interfaceMapping.get(functionName+"."+parametername);
	}



	public void addParameter(String functionName, String parameterName, InterfaceMapping map) {
		// TODO Auto-generated method stub
	    if(!functionList.contains(functionName)) {
	    	functionList.add(functionName);
	    }
	    
	    if(!functionMap.containsKey(functionName)) {
	    	List<String> paras=new ArrayList<String>();
	    	functionMap.put(functionName,paras);
	    }
	    
	    functionMap.get(functionName).add(parameterName);
	    interfaceMapping.put(functionName+"."+parameterName, map);
	    
	}

}
