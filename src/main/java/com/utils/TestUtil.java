package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGELOAD_TIMEOUT = 50;
	public static long IMPLICIT_WAIT = 10;

	public static Workbook book;
	public static Sheet sheet;

	public static String EXCEL_SHEET = "C:\\Users\\Asus\\eclipse-workspace\\OrangeHRM_PF\\src\\main\\java\\com\\utils\\OrangeHRM.xlsx";

	public static Object[][] getReport(String sheetName) {
		FileInputStream file = null;

		try {
			file = new FileInputStream(EXCEL_SHEET);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}
}
