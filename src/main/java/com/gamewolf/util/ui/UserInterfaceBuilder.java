package com.gamewolf.util.ui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import com.gamewolf.util.datafile.XMLNode;

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
	
	public static void main(String args[]) {
		ParameterUserInterfaceMapping puim=UserInterfaceBuilder.buildUIMapping(UserInterfaceBuilder.class);
		try {
			
			FileWriter fw=new FileWriter(new File("c:/tmp.fxml"));
			BufferedWriter bw=new BufferedWriter(fw);
			String line="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			String importLine="<?import javafx.scene.control.*?>";
			String importLine2="<?import java.lang.*?>"; 
			String importLine3="<?import javafx.scene.layout.*?>";
			String tabLine="<TabPane maxHeight=\"-Infinity\" maxWidth=\"-Infinity\" minHeight=\"-Infinity\" minWidth=\"-Infinity\" prefHeight=\"400.0\" prefWidth=\"600.0\" tabClosingPolicy=\"UNAVAILABLE\" xmlns:fx=\"http://javafx.com/fxml/1\" xmlns=\"http://javafx.com/javafx/8\">";
			String tabs="<tabs>";
			bw.append(line);
			bw.newLine();
			bw.append(importLine);
			bw.newLine();
			bw.append(importLine2);
			bw.newLine();
			bw.append(importLine3);
			bw.newLine();
			bw.append(tabLine);
			bw.newLine();
			bw.append(tabs);
			bw.newLine();
			//////////////////////////////////////////////
			XMLNode node=new XMLNode();
			node.setName("Tab");
			node.addAttribute("text", "tab1");
			XMLNode cnt=new XMLNode();
			cnt.setName("content");
			cnt.setValue("");
			//node.addNode("content", cnt);
			bw.append(node.toXML());
			bw.newLine();
			
			//////////////////////////////////////////////////
			
			bw.append("</tabs></TabPane>");
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
