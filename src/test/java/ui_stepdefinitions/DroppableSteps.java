package ui_stepdefinitions;

import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.java.en.*;
import utilities.DriverManager;

public class DroppableSteps {

	private WebDriver driver = DriverManager.getInstance();

	@Given("user is on the JqueryUI homepage")
	public void user_is_on_the_jquery_ui_homepage() {
		driver.get("https://jqueryui.com/");
		WebElement Logo = driver.findElement(By.xpath("//a[@href='/']"));
		assertTrue(Logo.isDisplayed());

	}

	@Given("user choose {string} and click")
	public void user_choose_and_click(String function) {
		driver.findElement(By.xpath("//a[text()='Droppable']")).click();
		driver.switchTo().frame(0);

	}

	@Then("user hold and drag the square to the position")
	public void user_hold_and_drag_the_square_to_the_position() {
		String expectedText = "Dropped!";
		Actions ac = new Actions(driver);
		ac.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build()
				.perform();

		String actuallText = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
		assertEquals(expectedText, actuallText);
	}

}
