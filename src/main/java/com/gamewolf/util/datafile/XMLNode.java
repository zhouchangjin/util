package com.gamewolf.util.datafile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class XMLNode {
	
	String nodeName;
	HashMap<String, List<XMLNode>> children;
	String value="";
	HashMap<String,Object> attributes;
	
	public XMLNode() {
		children=new HashMap<String,List<XMLNode>>();
		attributes=new HashMap<String,Object>();
	}
	
	
	public void setName(String name) {
		this.nodeName=name;
	}
	
	public void setValue(String text) {
		this.value=text;
	}
	
	public String getName() {
		return nodeName;
	}
	
	public String getValue() {
		return value;
	}
	
	public void addAttribute(String key,Object value) {
		attributes.put(key, value);
	}
	
	public Object getAttribute(String key) {
		return attributes.get(key);
	}
	
	public void addNode(String nodeName,XMLNode node) {
		if(children.containsKey(nodeName)) {
			children.get(nodeName).add(node);
		}else {
			List<XMLNode> list=new ArrayList<XMLNode>();
			list.add(node);
			children.put(nodeName, list);
		}
	}
	
	public List<XMLNode> getNodes(String nodeName) {
		return children.get(nodeName);
	}
	
	public XMLNode getNode(String nodeName) {
		if(children.containsKey(nodeName)) {
			return children.get(nodeName).get(0);
		}else {
			return null;
		}
		
	}
	public String toXML() {
		StringBuffer sb=new StringBuffer();
		String intro="<"+this.getName();
		Iterator<String> keyIt=this.attributes.keySet().iterator();
		while(keyIt.hasNext()) {
			String key=keyIt.next();
			String value=this.attributes.get(key).toString();
			intro+=" "+key+"='"+value+"'";
		}
		intro+=">";
		String end="</"+this.getName()+">";
		sb.append(intro);
		String innerText=""+System.lineSeparator();
		if(this.children.keySet().isEmpty()) {
			innerText=this.value;
		}else {
			Iterator<String> it=this.children.keySet().iterator();
			while(it.hasNext()) {
				String key=it.next();
				List<XMLNode> nodes=this.children.get(key);
				for(XMLNode node:nodes) {
					innerText+=node.toXML();
					innerText+=System.lineSeparator();
				}
			}
		}
		sb.append(innerText);
		sb.append(end);
		
		
		return sb.toString();
		
	}
	
	public String toString() {
		StringBuffer sb=new StringBuffer();
		String line1=this.getName()+"( value="+this.getValue()+" ,";
		Iterator<String> keyIt=attributes.keySet().iterator();
		while(keyIt.hasNext()) {
			String name=keyIt.next();
			String value=attributes.get(name).toString();
			String lineTemp=" "+name+"="+value+" ,";
			line1+=lineTemp;
		}
		sb.append(line1);
		//sb.append("\n");
		keyIt=children.keySet().iterator();
		while(keyIt.hasNext()) {
			String key=keyIt.next();
			List<XMLNode> node=children.get(key);
			for(int i=0;i<node.size();i++) {
				sb.append(node.get(i).toString());
			}
		}
		sb.append(")");
		return sb.toString();
		
	}

}
