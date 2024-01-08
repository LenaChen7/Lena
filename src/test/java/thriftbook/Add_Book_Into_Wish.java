package thriftbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.Keywords;

public class Add_Book_Into_Wish {

	public static void main(String[] args) {
		WebDriver localDriver = Keywords.driverFactory();

		try {
			Search_A_Book.search_For_item("Little Women");
			// find the first one click to the detail page
			Keywords.wait(2);
			localDriver.findElement(By.xpath("(//div[@class='AllEditionsItem-tileTitle'])[1]")).click();
			// click add to wish list
			localDriver.findElement(By.xpath("//*[text() = 'Add to Wish List']")).click();
			Keywords.wait(2);
			// Validation the alert message
			String expectedAlert = "Added to your wish list!";
			String actualAlert = localDriver.findElement(By.xpath("//div[@class=\"GlobalMessenger\"]")).getText();

			if (!actualAlert.equals(expectedAlert)) {
				throw new Exception(
						"Alert Message doesn't match." + "\nExpected: " + expectedAlert + "\nActual: " + actualAlert);
			}

			System.out.println("Test Pass");
		} catch (Exception e) {
			System.out.println("Test Failll");
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		} finally {
			localDriver.close();
			localDriver.quit();
		}

	}

}
