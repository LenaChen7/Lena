package ui_stepdefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;

public class LoginSteps {

	private WebDriver driver;

	@Given("user is on the boratech homepage")
	public void user_is_on_the_boratech_homepage() {
		driver.get("https://boratech-practice-app.onrender.com/");

	}

	@When("user navigates to the Login page")
	public void user_navigates_to_the_login_page() {
		driver.findElement(By.linkText("Login")).click();
	}

	@When("user enters the username - {string} and password - {string} and submit")
	public void user_enters_the_username_and_password_and_submit(String username, String password) {
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
	}

	@Then("user should be on the Dashboard page")
	public void user_should_be_on_the_dashboard_page() {
		String titleText = driver.findElement(By.xpath("//h1[text()='Dashboard']")).getText();
		System.out.println(titleText);
	}

}
