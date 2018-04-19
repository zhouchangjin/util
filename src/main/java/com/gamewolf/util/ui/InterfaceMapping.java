package com.gamewolf.util.ui;

public class InterfaceMapping {
	
	InterfaceType widgetType;
	String className;
	String parameterName;
	String parameterLabel;
	public String getParameterLabel() {
		return parameterLabel;
	}
	public void setParameterLabel(String parameterLabel) {
		this.parameterLabel = parameterLabel;
	}

	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	public InterfaceType getWidgetType() {
		return widgetType;
	}
	public void setWidgetType(InterfaceType widgetType) {
		this.widgetType = widgetType;
	}
	

}
