/**
 * @author Saquib Kazi
 * 
 * Test Case to check Saved Addresses section
 * on My Account Page
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

public class tc5_SavedAddress {
	
	// Initializing Required PageObjects
	MyAccount account = new MyAccount();
	
	// Initializing WebDriver
	WebDriver driver;
	
	// InitializingBrowser
	@Before("@Address")
	public void launchDriver() {
		this.driver = account.launchBrowser();
	}
	
	// Screenshot Functionality After Each Step
	@AfterStep("@Address")
	public void addScreenshot(Scenario scenario){

	      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	      scenario.attach(screenshot, "image/png", "image");
	}
	
	@Given("User is in My Accounts Page")
	public void user_is_in_my_accounts_page() throws InterruptedException, EncryptedDocumentException, IOException {
		// Waiting 5 Seconds to load Page Elements
		Thread.sleep(5000);
		// Verify if HomePage is loaded correctly
		Assert.assertTrue(account.verifyLoginAndSignUp());
		account.MyAccountPreCondition();
		Thread.sleep(5000);
		// Verify if Element is displayed
		Assert.assertTrue(account.verifyMyAccount());
		account.clickMyAccount();
		Thread.sleep(3000);
		
	}
	
	@When("Clicked on Saved Addresses hyperlink")
	public void clicked_on_saved_addresses_hyperlink() throws InterruptedException {
		// Verify if Element is displayed
		Assert.assertTrue(driver.findElement(account.savedAddress).isDisplayed());
		account.clickAddresse();
		Thread.sleep(2000);
	}
	
	@Then("User is redirected to Saved Addresses page")
	public void user_is_redirected_to_saved_addresses_page() throws InterruptedException {
		String checkText = account.checkPage();
		Assert.assertTrue(checkText.matches("Saved Addresses"));
		Thread.sleep(2000);
	}
	
	// Exit Browser
	@After("@Address")
	public void closeBrowser() {
		account.exitBrowser();
	}
}
