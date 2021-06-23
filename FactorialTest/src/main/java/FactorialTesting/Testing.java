package FactorialTesting;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class Testing extends BaseClass {

	/*
	 * Objective: To ensure the page contains all required elements for a
	 * successfull smoke test 
	 * Description: The Test case is designed to verify if
	 * the application homepage contains all the required elements Checks 
	 * Performed:
	 * Verifying Title, Verifying Headings, Verifying the presence of Input block,
	 * Verifying the presence of Submit button Verifying the presence of Terms and
	 * Conditions link, Verifying the presence of Privacy Link, Verifying presence
	 * of Qxf2 Services link 
	 * Inputs: None 
	 * Returns: None
	 */
	@Test
	public void checkingTheElementsOfThePage() {

		// Accessing the Home page of the factorial application
		String homeUrl = "https://qainterview.pythonanywhere.com/";// Assigning URL to a string
		driver.get(homeUrl);// Accessing the homepage of the factorial application

		// Checking the components of the displayed page
		// Page Title
		assertEquals("Factoriall", driver.getTitle());// Checking the Title of the page

		// Application Heading i.e. h1 tag
		WebElement pointer = driver.findElement(By.tagName("h1"));// Checking the Heading of the page using tag name
																	// (i.e. h1)
		assertEquals("The greatest factorial calculator!", pointer.getText());// Checking the correct text is displayed
																				// in heading

		// Presence of Terms and Conditions link
		pointer = driver.findElement(By.xpath("//a[contains(.,'Terms and Conditions')]"));// Terms and conditions
																							// element accessed using
																							// xPath.
		assertTrue(pointer.isDisplayed());// Checking if the element exists.

		// Presence of Privacy link
		pointer = driver.findElement(By.xpath("//a[2]"));// Privacy element position accessed using xPath
		assertTrue(pointer.isDisplayed());// Checking if privacy link exists on the page

		// Check if the number input box is present
		pointer = driver.findElement(By.id("number"));// Accessing the element by its ID
		assertTrue(pointer.isDisplayed());// Checking if the input box exists on the page

		// Checking if the Submit button (i.e. With Text "Calculate!") exists on the
		// page
		pointer = driver.findElement(By.id("getFactorial"));// Finding the element using the ID
		assertTrue(pointer.isDisplayed());// Checking if the button is displayed on the page
		assertEquals("Calculate!", pointer.getText());// Checking if the button displays text "Calculate!"

		// Checking the presence of link "Qxf2 Services"
		pointer = driver.findElement(By.linkText("Qxf2 Services"));// Finding the element using linked text
		assertTrue(pointer.isDisplayed());// Checking if the element is displayed on the screen
	}

	/*
	 * Objective: The test ensures that the basic functionality of the application
	 * works fine, as needed for the smoke test 
	 * Description: The test case performs
	 * the smoke test by checking the normal working of the application by checking
	 * the results for the values 0 and 170 (Boundary Value Analysis) 
	 * Inputs: None
	 * Returns: None
	 */
	@Test
	public void checkingTheWorkingOfTheApplication() throws Exception {
		// Accessing the Home page of the factorial application
		String inputNumber = null;
		String homeUrl = "https://qainterview.pythonanywhere.com/";// Assigning URL to a string
		driver.get(homeUrl);// Accessing the homepage of the factorial application

		// Checking the factorial of ZERO (0)
		// Giving input
		inputNumber = "0";
		WebElement pointer = driver.findElement(By.id("number"));// Accessing the input field by the ID
		pointer.sendKeys(inputNumber);// Sending number ZERO as input
		pointer = driver.findElement(By.id("getFactorial"));// Finding the Submit button
		pointer.click();// Clicking the submit button to get the results

		// Clearing the Input box for the next test
		driver.findElement(By.id("number")).clear();

		WebDriverWait wait = new WebDriverWait(driver, 10000);// Adding wait to the driver to

		// Checking Current Output
		pointer = driver.findElement(By.id("resultDiv"));// Finding the result statement using the ID
		assertEquals(pointer.getText(), "The factorial of " + inputNumber + " is: 1");// Checking the result of the
																						// input

		// Clearing the Input box for the next test
		driver.navigate().refresh();// Refreshing the page to ensure a clean start for next step

		// Checking the Factorial of 170 (Max possible number for which result is not
		// infinity)
		// Giving input
		inputNumber = "170";
		pointer = driver.findElement(By.id("number"));// Accessing the input field by the ID
		pointer.sendKeys(inputNumber);// Sending number ZERO as input
		pointer = driver.findElement(By.id("getFactorial"));// Finding the Submit button
		pointer.click();// Clicking the submit button to get the results

		// Clearing the Input box for the next test
		driver.findElement(By.id("number")).clear();// Clearing the text box
		wait = new WebDriverWait(driver, 10000);// Adding wait for allowing system to read the output correctly

		// Checking Current Output
		pointer = driver.findElement(By.id("resultDiv"));// Finding the result statement using the ID
		assertEquals(pointer.getText(), "The factorial of " + inputNumber + " is: 7.257415615307999e+306");// Checking
																											// the
																											// result of
																											// the input

		// Clearing the Input box for the next test
		driver.findElement(By.id("number")).clear();// Clearing the text box
		driver.navigate().refresh();// Refreshing the page

	}
}