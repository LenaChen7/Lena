package ui_stepdefinitions;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import utilities.DriverManager;
import utilities.Keywords;

public class LoginSteps {

	private WebDriver driver = DriverManager.getInstance();

	@Given("user is on the boratech homepage")
	public void user_is_on_the_boratech_homepage() {
		driver.get("https://boratech-practice-app.onrender.com/");
		int loginElementsCount = driver.findElements(By.xpath("//a[text()='Login']")).size();
		assertEquals(2, loginElementsCount);

	}

	@When("user navigates to the Login page")
	public void user_navigates_to_the_login_page() {
		driver.findElement(By.linkText("Login")).click();
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.endsWith("/login"));

		String expectedTitleText = driver.findElement(By.xpath("//h1[@class = 'large text-primary']")).getText();
		String actualTitleText = "Sign In";
		assertEquals(expectedTitleText, actualTitleText);
	}

	@When("user enters the username - {string} and password - {string} and submit")
	public void user_enters_the_username_and_password_and_submit(String username, String password)
			throws InterruptedException {
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		Keywords.wait(1);
	}

	@Then("user should be on the Dashboard page")
	public void user_should_be_on_the_dashboard_page() {
		String url = driver.getCurrentUrl();
		assertTrue(url.endsWith("/dashboard"));

		String expectedTitleText = driver.findElement(By.xpath("//h1[@class = 'large text-primary']")).getText();
		String actualTitleText = "Dashboard";
		assertEquals(expectedTitleText, actualTitleText);

	}

}
