package com.gamewolf.util.ui;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

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
		UserInterfaceBuilder.buildUIMapping(UserInterfaceBuilder.class); 
	}

}
