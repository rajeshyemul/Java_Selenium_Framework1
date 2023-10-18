package com.rajesh.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.rajesh.constants.FrameworkConstants;
import com.rajesh.enums.ConfigProperties;
import com.rajesh.exceptions.FileReadException;

public final class PropertyUtils {
	
	private PropertyUtils() {
		
	}
	
	private static Properties property = new Properties();
	private static final Map<String,String> CONFIGMAP = new HashMap<String,String>();
	
	static {
		try {
			FileInputStream file = new FileInputStream(FrameworkConstants.getConfigfilepath());
			property.load(file);
			
			for(Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
			
			// java 8 way to handle the above loop
			// property.entrySet().forEach(entry->CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static String getValue(ConfigProperties key){
		if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new FileReadException("Proerty name " + key + " is not found. please check config.properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
}
