package com.gamewolf.util.datafile;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLReader {
	
	
	public static XMLNode loadXMLFile(String file) {
		XMLNode root=null;
		  SAXReader reader = new SAXReader();
	      try {
			Document document = reader.read(new File(file));
			String rootName=document.getRootElement().getName();
			root=parseElement(document.getRootElement());
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return root;
		
	}
	
	private static XMLNode parseElement(Element e) {
		XMLNode node=new XMLNode();
		String name=e.getName();
		String text=e.getText();
		if(text.replace("\n", "").length()==0) {
			text="";
		}
		node.setName(name);
		node.setValue(text);
		for(int i=0;i<e.attributeCount();i++) {
			Attribute a=e.attribute(i);
			String attrName=a.getName();
			String attrValue=a.getValue();
			node.addAttribute(attrName, attrValue);
		}
		Iterator<Element> it=e.elementIterator();
		while(it.hasNext()) {
			Element ele=it.next();
			node.addNode(ele.getName(), parseElement(ele));
		}
		
		return node;
	}

	
	
	public static void main(String args[]) {
		
		System.out.println(loadXMLFile("c:/sitemaps.xml").toString());
		
	}


}
