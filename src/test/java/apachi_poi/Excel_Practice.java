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
		XSSFSheet sheet = workbook.createSheet("test");

		for (int i = 0; i < 10; i++) {
			XSSFRow row = sheet.createRow(i);
			XSSFCell cell = row.createCell(3);
		}
		
		FileOutputStream fos = new FileOutputStream("target/practice.xlsx");
		workbook.write(fos);
		workbook.close();
		fos.close();
	}

}
