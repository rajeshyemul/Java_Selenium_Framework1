package com.rajesh.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.rajesh.utils.DataProviderUtils;

public class AnnotationTransformer implements IAnnotationTransformer{
	
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setDataProvider("getData");
		annotation.setRetryAnalyzer(RetryFailedTests.class);
		annotation.setDataProviderClass(DataProviderUtils.class);
	}
}
