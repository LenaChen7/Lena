package Data_Collection;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utility.Keywords;

public class Excel {

	public static void exportAmazonSearchResults(String searchTerm, List<Amazon_Search_Result_Pojo> results)
			throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(searchTerm);

		XSSFRow headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Price");
		headerRow.createCell(2).setCellValue("Title");

		double firstResultPrice = results.get(0).price;
		double min = firstResultPrice;
		double max = firstResultPrice;
		double avg = 0.0;
		double sum = 0;
		int minIndex = -1;
		int maxIndex = -1;

		for (int index = 0; index < results.size(); index++) {
			XSSFRow row = sheet.createRow(index + 1);
			Amazon_Search_Result_Pojo result = results.get(index);
			row.createCell(0).setCellValue(result.id);
			row.createCell(1).setCellValue(result.price);
			row.createCell(2).setCellValue(result.title);

			if (result.price > max) {

				max = result.price;
				maxIndex = index;

			}

			if (result.price < min) {
				min = result.price;
				minIndex = index;

			}

			sum += result.price;

		}
		avg = sum / results.size();

		XSSFRow minRow = sheet.createRow(results.size() + 2);
		XSSFRow maxRow = sheet.createRow(results.size() + 3);
		XSSFRow avgRow = sheet.createRow(results.size() + 4);

		minRow.createCell(0).setCellValue("Min");
		minRow.createCell(2).setCellValue("Product ID:");
		maxRow.createCell(0).setCellValue("Max");
		maxRow.createCell(2).setCellValue("Product ID:");
		avgRow.createCell(0).setCellValue("Avg");

		minRow.createCell(1).setCellValue(min);
		minRow.createCell(3).setCellValue(results.get(minIndex).id);
		maxRow.createCell(1).setCellValue(max);
		maxRow.createCell(3).setCellValue(results.get(maxIndex).id);

		avgRow.createCell(1).setCellValue(avg);

		// write the data , output the data
		FileOutputStream fos = new FileOutputStream("target/ASR-" + Keywords.getTimestamp() + ".xlsx");
		workbook.write(fos);
		workbook.close();
		fos.close();

	}

}
