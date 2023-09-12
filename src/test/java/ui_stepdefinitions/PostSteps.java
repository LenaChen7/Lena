package ui_stepdefinitions;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utilities.DriverManager;
import utilities.Keywords;

public class PostSteps {
	private WebDriver driver = DriverManager.getInstance();

	@Given("user is logged in")
	public void user_is_logged_in(DataTable dataTable) throws InterruptedException {
		Map<String, String> credentials = dataTable.asMap();

		driver.get("https://boratech-practice-app.onrender.com/");
		driver.findElement(By.xpath("(//a[text()='Login'])[1]")).click();
		driver.findElement(By.name("email")).sendKeys(credentials.get("username"));
		driver.findElement(By.name("password")).sendKeys(credentials.get("password"));
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		Keywords.wait(1);
	}

	@When("user navigates to the Posts page")
	public void user_navigates_to_the_posts_page() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Posts']")).click();
		assertTrue(driver.getCurrentUrl().endsWith("/posts"));
		Keywords.wait(1);

	}

	@When("user enter the post content")
	public void user_enter_the_post_content(DataTable dataTable) throws InterruptedException {
		Map<String, String> data = dataTable.asMaps().get(0);
		String content = data.get("content");
		driver.findElement(By.xpath("//textarea[@name='text']"))
				.sendKeys(Keywords.getTimeStamp() + content + Keys.ENTER);
		Keywords.wait(1);
	}

	@When("user clicks on the submit button")
	public void user_clicks_on_the_submit_button() throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Keywords.wait(1);

	}

	@Then("user should see a success alert that says {string}")
	public void user_should_see_a_success_alert_that_says(String successAlertText) {
		String ExpectedSuccessAlertText = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		assertEquals(ExpectedSuccessAlertText, successAlertText);
	}

}
