/**
 * 
 */
package com.rajesh.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.rajesh.enums.AuthorType;
import com.rajesh.enums.CategoryType;

@Retention(RUNTIME)
@Target(METHOD)
/**
 * @author rajesh.yemul
 *
 */
public @interface FrameworkAnnotation {
	
	// public String author() default "";

	public AuthorType author();

	public CategoryType[] category();
}
