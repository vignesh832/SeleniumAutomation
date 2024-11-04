package datadrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	// Excel File -> WorkBook -> Sheets -> Rows -> Cells
	
	//FileInputStream   => Reading the file
	//FileOutputStream  => Writing the file
	
	//XSSFWorkbook 	-> WorkBook
	//XSSFSheet		-> Sheets
	//XSSFRow		-> Row
	//XSSFCell		-> Cell
	
	private static FileInputStream inputStream;
	private static FileOutputStream outputStream;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	//private static XSSFRow row;
	//private static XSSFCell cell;
	
	public static String[][] readingData(String fileName, String sheetName) throws IOException {
		inputStream= new FileInputStream(fileName);
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(1).getLastCellNum();
		System.out.println(rowCount);
		System.out.println(columnCount);
		String[][] data = new String[rowCount+1][columnCount];
		for(int i= 0 ; i<= rowCount; i++) {
			for(int j= 0; j< columnCount; j++) {
				data[i][j]= sheet.getRow(i).getCell(j).toString();
			}
		}
		workbook.close();
		inputStream.close();
		return data;
	}
	
	public static boolean writingData(String fileName, String sheetName) throws IOException {
		inputStream = new FileInputStream(fileName);
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet(sheetName);
		int cellCount = sheet.getRow(0).getLastCellNum();
		int rowCount = sheet.getLastRowNum();
		for(int i=0; i<= rowCount;i++) {
			sheet.getRow(i).createCell(cellCount).setCellValue("data");
		}
		outputStream = new FileOutputStream(fileName);
		workbook.write(outputStream);
		workbook.close();
		inputStream.close();
		outputStream.close();
		return true;
	}
	
	
	
}
