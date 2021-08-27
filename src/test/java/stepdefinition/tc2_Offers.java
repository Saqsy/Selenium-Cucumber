/**
 * @author Saquib Kazi
 * 
 * Test Case to add food to cart and apply coupon
 * from offers page.
 *
 */
package stepdefinition;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import PageObjects.Offers;


public class tc2_Offers {
	
	// Initializing WebDriver
	WebDriver driver;
	
	// Initializing Required PageObjects
	Offers offers = new Offers();
	
	// InitializingBrowser
	@Before("@Offers")
	public void launchDriver() {
		this.driver = offers.launchBrowser();
	}
	
	// Screenshot Functionality After Each Step
	@AfterStep("@Offers")
	public void addScreenshot(Scenario scenario){

	      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	      scenario.attach(screenshot, "image/png", "image");
	} 
	
	@Given("^User is logged into the application$")
	public void user_is_logged_into_the_application() throws InterruptedException, EncryptedDocumentException, IOException {
		// Waiting 5 Seconds to load Page Elements
		Thread.sleep(5000);
		// Verify if HomePage is loaded correctly
		Assert.assertTrue(offers.verifyLoginAndSignUp());
		offers.LoginPreCondition();
		Thread.sleep(5000);
	}

	@When("^User has added food to the cart$")
	public void user_has_added_food_to_the_cart() throws InterruptedException {
		// Verify if Element is loaded correctly
		Assert.assertTrue(offers.verifyAddButton());
		offers.addVisibleFood();
		Thread.sleep(2000);
		// Verify if Element is loaded correctly
		Assert.assertTrue(offers.verifyAddtoCartButton());
		offers.clickAddtoCartButton();
		Thread.sleep(2000);
		
	}

	@When("^Clicked on Offers link$")
	public void clicked_on_Offers_link() throws InterruptedException {
		// Verify if Element is loaded correctly
		Assert.assertTrue(offers.verifyOffersPageHyperlink());
		offers.clickOffersPage();
		Thread.sleep(5000);
	}

	@When("^User chooses a Coupon Code and clicks Apply$")
	public void user_chooses_a_Coupon_Code_and_clicks_Apply() throws InterruptedException, FileNotFoundException, IOException {
		
		// List displayed Promo Codes on the Page and save in Coupons.xlsx
		offers.verifyPromoCodes();
		
		// Verify if Coupon is displayed
		Assert.assertTrue(offers.verifyCouponCode());
	    offers.applyCouponCode();
	    Thread.sleep(2000);
	}

	@Then("^Coupon Code is Successfully Applied$")
	public void coupon_Code_is_Successfully_Applied() throws InterruptedException {
		String checkCoupon = offers.verifyAppliedCoupon();
		Assert.assertTrue(checkCoupon.matches("Promo applied successfully"));
		offers.confirmButton();
		Thread.sleep(2000);
	}
	
	// Exit Browser
	@After("@Offers")
	public void closeBrowser() {
		offers.exitBrowser();
	}
	
}
