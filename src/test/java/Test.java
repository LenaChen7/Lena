import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.microsoft.com/en-us/microsoft-365/outlook/log-in");
			System.out.println("Test Pass");
		} catch (Exception e) {
			System.out.println("Test Fail");
			e.printStackTrace();
		}finally {
			driver.close();
			driver.quit();
		}

	}

}
