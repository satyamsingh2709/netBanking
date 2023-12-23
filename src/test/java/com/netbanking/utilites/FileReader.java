package com.netbanking.utilites;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileReader {
	
	static FileInputStream fis;
	static XSSFWorkbook wb; 
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	static FileOutputStream fos;
	
	
	public static int getRowCount(String filePath, String sheetName) throws IOException {
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;

		
	}
	
	public static int getCellCount(String filePath, String sheetName,int rowNum) throws IOException {
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		int sheetCount = sheet.getRow(rowNum).getLastCellNum();
		wb.close();
		fis.close();
		return sheetCount;
	}
	
	
	public static String readCellData(String filePath, String sheetName, int rowNum, int colNum) throws IOException {

		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		String data;
		
		try {
			DataFormatter formatter = new DataFormatter(Locale.UK);
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		}catch(Exception e) {
			data = "";
		}
		wb.close();
		fis.close();
		return data;

	}
	
	public static void setData(String filePath, String sheetName, int rowNum, int colNum, String data) throws IOException {
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.createCell(colNum);
		cell.setCellValue(data);
		fos = new FileOutputStream(filePath);
		wb.write(fos);
		wb.close();
		fos.close();
		fis.close();
		
	}

}






//	int rowCount = sheet.getLastRowNum();
//int cellCount = sheet.getRow(1).getLastCellNum();
//for(int i=0;i<=rowCount;i++) {
//	row = sheet.getRow(i);
//	for(int j=0;j<cellCount;j++) {
//		cell = row.getCell(j);
//		switch(cell.getCellType()) {
//			case STRING: System.out.print(cell.getStringCellValue()); break;
//			case NUMERIC: System.out.print(cell.getNumericCellValue()); break;
//		}
//		System.out.print(" ");
//	}
//	System.out.println();
//}
