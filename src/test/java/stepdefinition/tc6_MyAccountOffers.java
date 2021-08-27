/**
 * @author Saquib Kazi
 * 
 * Test Case to check Offers Page Hyperlink
 * from My Account Page
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

public class tc6_MyAccountOffers {
	
	// Initializing Required PageObjects
	MyAccount account = new MyAccount();
	
	// Initializing WebDriver
	WebDriver driver;
	
	// InitializingBrowser
	@Before("@MyAccountOffer")
	public void launchDriver() {
		this.driver = account.launchBrowser();
	}
	
	// Screenshot Functionality After Each Step
	@AfterStep("@MyAccountOffer")
	public void addScreenshot(Scenario scenario){

	      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	      scenario.attach(screenshot, "image/png", "image");
	}
	
	@Given("User had navigated to My Accounts Page")
	public void user_had_navigated_to_my_accounts_page() throws InterruptedException, EncryptedDocumentException, IOException {
		// Waiting 5 Seconds to load Page Elements
		Thread.sleep(5000);
		// Verify if HomePage is loaded correctly
		Assert.assertTrue(account.verifyLoginAndSignUp());
		account.MyAccountPreCondition();
		Thread.sleep(5000);
		// Verify if Element is displayed
		Assert.assertTrue(account.verifyMyAccount());
		account.clickMyAccount();
		Thread.sleep(2000);
	}
	@When("Click on Offers hyperLink")
	public void click_on_offers_hyper_link() throws InterruptedException {
		// Verify if Element is displayed
		Assert.assertTrue(driver.findElement(account.offersLink).isDisplayed());
		account.clickOffersLink();
		Thread.sleep(2000);
	}
	@Then("User is redirected to Offer Page")
	public void user_is_redirected_to_offer_page() throws InterruptedException {
	    String checkText = account.checkPromoText();
	    Assert.assertTrue(checkText.matches("Promo Codes"));
	}
	
	@After("@MyAccountOffer")
	public void closeBrowser() {
		account.exitBrowser();
	}
}
