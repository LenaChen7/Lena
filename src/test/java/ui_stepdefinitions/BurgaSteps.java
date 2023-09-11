package ui_stepdefinitions;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.*;
import utilities.DriverManager;

public class BurgaSteps {

	private WebDriver driver = DriverManager.getInstance();

	@Given("user is on the Burga homepage")
	public void user_is_on_the_burga_homepage() {
		driver.get("https://us.burga.com/");
		WebElement logo = driver.findElement(By.xpath("//a[@class='block-abc tac mh__logo']"));
		assertTrue(logo.isDisplayed());

	}

	@Given("user clicks a product type on the top bar")
	public void user_clicks_a_product_type_on_the_top_bar() {
		driver.findElement(By.xpath("(//a[@href='/collections/all'])[2]")).click();
		String actualText = "PHONE CASES";
		String expectedText = driver.findElement(By.xpath("//h1[text()='Phone Cases']")).getText();
		assertEquals(expectedText, actualText);

	}

	@Given("user adds one item - {string} into the shopping cart")
	public void user_adds_one_item_into_the_shopping_cart(String item) {
		driver.findElement(By.xpath("//li [@data-product-id='7232213811373']"));
		driver.findElement(By.xpath("(//button[@aria-label='Add to cart'])[1]")).click();
		String expectedText = driver
				.findElement(By.xpath("//div[@class='cart-item__content cell-l']//h3[text()='Almond Latte ']"))
				.getText();
		String actualText = "Almond Latte";
		assertEquals(expectedText, actualText);

	}

	@Then("user views cart")
	public void user_views_cart() {
		driver.findElement(By.xpath("//button[@class=\"btn btn--s btn--green block-12/12 js-atc-modal-show-cart\"]"))
				.click();
		WebElement checkOutbutton = driver.findElement(By.xpath("//button[@name='checkout']"));
		assertTrue(checkOutbutton.isDisplayed(), "counld't find the button");

	}
}
