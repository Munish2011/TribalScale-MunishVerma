package FactorialTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	protected static WebDriver driver = null;//WebDriver Declaration

	//Setup to run before test
	@BeforeTest
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");//Adding chrome driver path
		driver = new ChromeDriver();//Chrome driver object creation
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

	}

	//Setup to run after test
	@AfterTest
	public static void teardown() {
		driver.close();//Driver close
		driver.quit();//Driver Quit
	}
}
