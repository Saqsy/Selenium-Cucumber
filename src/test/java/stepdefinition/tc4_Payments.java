/**
 * @author Saquib Kazi
 * 
 * Test Case to check Payments Section
 * My Account Page
 *
 */

package stepdefinition;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import PageObjects.MyAccount;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class tc4_Payments {
	
	// Initializing Required PageObjects
	MyAccount account = new MyAccount();
	
	// Initializing WebDriver
	WebDriver driver;
	
	// InitializingBrowser
	@Before("@Payments")
	public void launchDriver() {
		this.driver = account.launchBrowser();
	}
	
	// Screenshot Functionality After Each Step
	@AfterStep("@Payments")
	public void addScreenshot(Scenario scenario){

	      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	      scenario.attach(screenshot, "image/png", "image");
	}
	
	@Given("The User is logged in the application")
	public void the_user_is_logged_in_the_application() throws InterruptedException, EncryptedDocumentException, IOException {
		// Waiting 5 Seconds to load Page Elements
		Thread.sleep(5000);
		// Verify if HomePage is loaded correctly
		Assert.assertTrue(account.verifyLoginAndSignUp());
	    account.MyAccountPreCondition();
	    Thread.sleep(5000);
	}
	@When("Clicked on My Account hyperlink")
	public void clicked_on_my_account_hyperlink() throws InterruptedException {
		// Verify if Element is displayed
		Assert.assertTrue(account.verifyMyAccount());
		account.clickMyAccount();
		Thread.sleep(2000);
	}
	@When("Clicked on Payments hyperlink")
	public void clicked_on_payments_hyperlink() throws InterruptedException {
		// Verify if Element is displayed
		Assert.assertTrue(driver.findElement(account.Payments).isDisplayed());
		account.clickPayments();
		Thread.sleep(2000);
	}
	@Then("User is redirected to Payments Page")
	public void user_is_redirected_to_payments_page() throws InterruptedException {
		String checkText = account.checkPage();
		Assert.assertTrue(checkText.matches("Payments"));
		Thread.sleep(2000);
	}
	
	// Exit Browser
	@After("@Payments")
	public void closeBrowser() {
		account.exitBrowser();
	}
}
