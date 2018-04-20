package com.gamewolf.util.ui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

import com.gamewolf.util.datafile.XMLNode;
import com.gamewolf.util.datafile.XMLSchemaHeader;

public class UserInterfaceBuilder {
	
	public static ParameterUserInterfaceMapping buildUIMapping(
				@UIMappingAnnotation(label="类名", name = "class", descpt = "转化类")Class claz
			) {
		DefaultParameterUserInterfaceMappingImpl defaultInf=new DefaultParameterUserInterfaceMappingImpl();
		Method[] m=claz.getDeclaredMethods();
		for(Method method:m) {
			//Class clzs[]=method.getParameterTypes();
			Parameter p[]=method.getParameters();
			for(Parameter para:p) {
				Class clz=para.getType();
				UIMappingAnnotation antype=para.getAnnotation(UIMappingAnnotation.class);

				if(antype!=null) {
					InterfaceMapping inf=new InterfaceMapping();
					inf.setClassName(clz.getName());
					inf.setParameterName(antype.name());
					inf.setParameterLabel(antype.label());
					inf.setWidgetType(antype.type());
					defaultInf.addParameter(method.getName(), para.getName(), inf);
				}
			}
		}
		return defaultInf;
	}
	
	public static void BuildJavaFX(Class claz,String outputFile) {
		try {
		ParameterUserInterfaceMapping puim=UserInterfaceBuilder.buildUIMapping(claz);
		FileWriter fw=new FileWriter(new File(outputFile));
		BufferedWriter bw=new BufferedWriter(fw);
		bw.append(XMLSchemaHeader.header);
		bw.newLine();
		String importLine="<?import javafx.scene.control.*?>";
		String importLine2="<?import java.lang.*?>"; 
		String importLine3="<?import javafx.scene.layout.*?>";
		bw.append(importLine);
		bw.newLine();
		bw.append(importLine2);
		bw.newLine();
		bw.append(importLine3);
		bw.newLine();
		XMLNode node=new XMLNode("BorderPane");
		node.addAttribute("maxHeight", "-Infinity");
		node.addAttribute("maxWidth", "-Infinity");
		node.addAttribute("minHeight", "-Infinity");
		node.addAttribute("minWidth", "-Infinity");
		node.addAttribute("prefHeight", "400.0");
		node.addAttribute("prefWidth", "600.0");
		//node.addAttribute("tabClosingPolicy", "UNAVAILABLE");
		node.addAttribute("xmlns:fx", "http://javafx.com/fxml/1");
		node.addAttribute("xmlns", "http://javafx.com/javafx/8");
		XMLNode tabPane=node.createChild("center").createChild("TabPane");
		XMLNode tabsNode=new XMLNode();
		tabsNode.setName("tabs");
		tabPane.addNode("tabs", tabsNode);
		List<String> list=puim.getFunctionList();
		for(String name:list) {
			XMLNode tabNode=new XMLNode();
			tabNode.setName("Tab");
			tabNode.addAttribute("text", name);
			tabsNode.addNode("Tab", tabNode);
		}
		bw.append(node.toXML());
		bw.newLine();
		bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]) {
		//ParameterUserInterfaceMapping puim=UserInterfaceBuilder.buildUIMapping(UserInterfaceBuilder.class);
		UserInterfaceBuilder.BuildJavaFX(UserInterfaceBuilder.class, "c:/tes12.fxml");
		
	}

}
