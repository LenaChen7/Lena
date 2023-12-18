package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import utility.Keywords;

public class ApplicationForm {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		String url = "https://boratech-practice-app.onrender.com/";
		String firstName = "Lena";
		String lastName = "Chen";
		String dob = "07/01/1995";
		String gender = "female";
		String email = "chenlena@outlook.com";
		String phoneNumber = "5714430267";

		String firstNameXpath = "//input[@placeholder='* First Name']";
		String lastNameXpath = "//input[@name='lastname']";
		String dobXpath = "//input[@name='dob']";
		String genderXpath = "//input[@name ='gender'][@value = '" + gender + "']";
		String emailXpath = "//input[@name = 'email']";
		String phoneNumberXpath = "//input[@name = 'phonenumber']";

		try {
			driver.get(url);
			driver.findElement(By.linkText("Apply Now")).click();
			Keywords.wait(2);

			driver.findElement(By.xpath(firstNameXpath)).sendKeys(firstName);
			driver.findElement(By.xpath(lastNameXpath)).sendKeys(lastName);
			driver.findElement(By.xpath(dobXpath)).sendKeys(dob);
			driver.findElement(By.xpath(genderXpath)).click();
			driver.findElement(By.xpath(emailXpath)).sendKeys(email);
			driver.findElement(By.xpath(phoneNumberXpath)).sendKeys(phoneNumber);

			Select course = new Select(driver.findElement(By.xpath("//select[@name = 'course']")));
			course.selectByValue("aws");

			Select source = new Select(driver.findElement(By.xpath("//select[@name = 'source']")));
			source.selectByValue("internalreferral");

			WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
			if (submitButton.isEnabled()) {
				throw new Exception("Submit button should be disabled");
			}

			driver.findElement(By.xpath("//input[@name='notarobot']")).click();
			if (!submitButton.isEnabled()) {
				throw new Exception("Submit button should be enabled ");
			}

			submitButton.click();
			Keywords.wait(2);
			
			String expectedAlerttext = "Your application is submitted!";
			String actuallAlertmessage = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
			if (!actuallAlertmessage.equals(expectedAlerttext)) {
				throw new Exception("Success Alert Text Mismatch. \n" + "Expected: " + expectedAlerttext + "\nActuall: "
						+ actuallAlertmessage);
			}

//			// 1. Validate URL has /apply at the end
//			String actualUrl = driver.getCurrentUrl();
//			if (!actualUrl.endsWith("/apply")) {
//				throw new Exception("Expected to have '/apply' in the url." + "\nCurrent: " + actualUrl);
//			}

			// 2. Validate Title Text
//			String expectedTitleText = "Application Form";
//			String actualTitleText = driver.findElement(By.xpath("//h1[@class='large text-primary']")).getText();
//			if (!actualTitleText.equals(expectedTitleText)) {
//				throw new Exception("Title Text doesn't match.\n" + "Expected: " + expectedTitleText + "\nActual: "
//						+ actualTitleText);
//			}

			System.out.println("Test Passed");
		} catch (Exception e) {
			System.out.println("Test Failed");
			System.out.println(e.getMessage());
			e.getStackTrace();

		} finally {
			driver.close();
			driver.quit();
		}
	}

}
