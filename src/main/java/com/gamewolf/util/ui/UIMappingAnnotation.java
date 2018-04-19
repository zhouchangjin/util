package com.gamewolf.util.ui;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface UIMappingAnnotation {
	
	String name();
	String label();
	String descpt();
	InterfaceType type() default InterfaceType.TextInput;

}
