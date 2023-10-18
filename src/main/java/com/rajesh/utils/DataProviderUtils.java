package com.rajesh.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

public final class DataProviderUtils {

	@DataProvider(parallel = true)
	public static Object[] getData(Method m) {
		String testName = m.getName();
		List<Map<String,String>> list = ExcelUtils.getTestDetails("Sheet1");
		List<Map<String,String>> smallList = new ArrayList<Map<String,String>>();;

		for(int i=0; i<list.size(); i++) {
			if( (list.get(i).get("testname").equalsIgnoreCase(testName)) && (list.get(i).get("execute").equalsIgnoreCase("yes")) ){
				smallList.add(list.get(i));
			}
		}
		return smallList.toArray();
	}
}
