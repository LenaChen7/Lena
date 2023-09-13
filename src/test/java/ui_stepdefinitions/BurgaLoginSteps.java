package ui_stepdefinitions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utilities.DriverManager;
import utilities.Keywords;

public class BurgaLoginSteps {

	private WebDriver driver = DriverManager.getInstance();

	@Given("user is on the Burga home page")
	public void user_is_on_the_burga_home_page() {
		driver.get("https://us.burga.com/");
		WebElement logo = driver.findElement(By.xpath("//a[@class='block-abc tac mh__logo']"));
		assertTrue(logo.isDisplayed());
	}

	@Then("user inputs credentials")
	public void user_inputs_credentials(DataTable dataTable) {
		driver.findElement(By.xpath("(//a[@href='/account'])[1]")).click();
		Map<String, String> data = dataTable.asMap();
		driver.findElement(By.id("CustomerEmail")).sendKeys(data.get("Email address") + Keys.ENTER);
		driver.findElement(By.id("CustomerPassword")).sendKeys(data.get("password") + Keys.ENTER);

	}

	@Then("user clicks LOG IN button")
	public void user_clicks_log_in_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='LOG IN']")).click();

	}

	@Then("user is on the Burga profile homepage")
	public void user_is_on_the_burga_profile_homepage() {
		assertTrue(driver.getCurrentUrl().endsWith("/profile"));
	}

}
