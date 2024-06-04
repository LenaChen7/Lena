package apachi_poi;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Practice {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Shampoo Results");
		XSSFRow row = sheet.createRow(0);
		XSSFCell row1Cell1 = row.createCell(0);
		row1Cell1.setCellValue("Hello World!");

		// write the data , output the data
		FileOutputStream fos = new FileOutputStream("target/practice.xlsx");
		workbook.write(fos);
		workbook.close();

	}

}
