package com.gamewolf.util.ui;

public enum InterfaceType {

	TextInput("Text Input","文本输入"),
	FileInput("File Input","文件输入"),
	FolderInput("Folder Input","目录输入"),
	DateInput("Date Input","日期输入"),
	SelectInput("Select Input","单选输入"),
	RadioInput("Radio Input","Radio输入");
	
	private final String name;
	private final String cnName;
	
	
	InterfaceType(String text,String cnText){
		this.name=text;
		this.cnName=cnText;
	}
	
	public String getName(){
		return name;
	}
	
	public String getCNName() {
		return cnName;
	}

}
