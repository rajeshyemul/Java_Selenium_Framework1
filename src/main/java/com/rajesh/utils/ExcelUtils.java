package com.rajesh.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.rajesh.constants.FrameworkConstants;
import com.rajesh.exceptions.ExcelSheetNotFoundException;
import com.rajesh.exceptions.InvalidFilePathException;

public final class ExcelUtils {
	
	private ExcelUtils() {
		
	}
	
	// try with resources
	
	public static List<Map<String, String>> getTestDetails(String sheetName) {
		List<Map<String, String>> list = null;
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(FrameworkConstants.getExcelfilepath());
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			System.out.println(sheetName);
			
			list = new ArrayList<Map<String, String>>();
			Map <String,String> map = null;
			int lastRowNum = sheet.getPhysicalNumberOfRows();
			int lastColNum = sheet.getRow(0).getLastCellNum();
			
			System.out.println(lastRowNum);
			System.out.println(lastColNum);
			
			
			for(int i=1; i<lastRowNum; i++) {
				map = new HashMap<String,String>();
				for(int j=0; j< lastColNum; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();	
					map.put(key, value);
				}
				list.add(map);
			}
			System.out.println(list);
		}
		catch (FileNotFoundException e) {
			/*
			StackTraceElement[] stackTrace = e.getStackTrace();
			stackTrace[0] = new  StackTraceElement("com.rajesh.utils.ExcelUnit", "getTestDetails", "ExcelUtils.java", 51);
			*/
			throw new ExcelSheetNotFoundException("Excel File You Are Trying to Read is not available");
		}
		
		catch (IOException e) {
			throw new InvalidFilePathException("Some IOException occurs");
		}
		finally {
			try {
				if(Objects.nonNull(fs))
					fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
}
