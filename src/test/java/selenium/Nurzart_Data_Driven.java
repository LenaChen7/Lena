package selenium;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Nurzart_Data_Driven {
	
	public static void main(String[] args) {
		HashMap<String, String> test_1 = new HashMap<>();
		test_1.put("firstName", "John");
		submitForm(test_1);	
	
	}

	public static void submitForm(HashMap<String, String> formdata) {
		WebDriver localDriver = driverFactory();
		localDriver.get("https://demoqa.com/automation-practice-form");
		localDriver.findElement(By.id("firstName")).sendKeys(formdata.get("firstName"));
		localDriver.findElement(By.id("lastName")).sendKeys(formdata.get("lastName"));
		localDriver.findElement(By.id("userEmail")).sendKeys(formdata.get("email"));
		localDriver.close();
		localDriver.quit ();
		
	}
	
	
	
	public static WebDriver driverFactory() {
		WebDriver driver = new ChromeDriver();
		return driver;
	}
}


