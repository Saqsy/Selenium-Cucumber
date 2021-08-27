/**
 * @author Saquib Kazi
 * 
 * Test Case to check functionality of HelpCenter Page
 *
 */

package stepdefinition;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import PageObjects.HelpCenter;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class tc7_HelpCenter {
	// Initializing Required PageObjects
	HelpCenter helpCenter = new HelpCenter();
	
	// Initializing WebDriver
	WebDriver driver;
	
	// InitializingBrowser
	@Before("@HelpCenter")
	public void launchDriver() {
		this.driver = helpCenter.launchBrowser();
	} 
	
	// Screenshot Functionality After Each Step
	@AfterStep("@HelpCenter")
	public void addScreenshot(Scenario scenario){

	      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	      scenario.attach(screenshot, "image/png", "image");
	}
	
	
	@Given("Open HomePage and Enter Credentials")
	public void open_home_page_and_enter_credentials() throws InterruptedException, EncryptedDocumentException, IOException {
		// Waiting 5 Seconds to load Page Elements
		Thread.sleep(5000);
		// Verify if HomePage is loaded correctly
		Assert.assertTrue(helpCenter.verifyLoginAndSignUp());
		helpCenter.LoginPreCondition();
		Thread.sleep(5000);
	}
	
	@When("I click on My Account Page")
	public void i_click_on_my_account_page() throws InterruptedException {
		Assert.assertTrue(helpCenter.verifyMyAccount());
		helpCenter.clickMyAccount();
		Thread.sleep(5000);
	}
	
	@Then("I should be on My Account Page")
	public void i_should_be_on_my_account_page() throws InterruptedException {
	   Thread.sleep(2000);
	   WebElement checkLogin = driver.findElement(helpCenter.checkMyAccount);
	   checkLogin.isDisplayed();
	   System.out.println("Login Successful");
	   Thread.sleep(2000);
	}
	
	@When("User click the Help Center hyperlink in My Account")
	public void user_click_the_help_center_hyperlink_in_my_account() throws InterruptedException {
		// Verify if Element is displayed
		Assert.assertTrue(driver.findElement(helpCenter.HelpCenter).isDisplayed());
		helpCenter.clickHelpCenter();
	    Thread.sleep(5000);
	    System.out.println("In Help Center Page");
	}
	
	@Then("User is able to choose previous orders for query")
	public void user_is_able_to_choose_previous_orders_for_query() {
	    String verifyPage = helpCenter.orderHelpPage();
	    System.out.println(verifyPage);
	    Assert.assertTrue(verifyPage.matches("Order History"));
	}
	
	@When("User clicks on General Queries hyperlink")
	public void user_clicks_on_general_queries_hyperlink() throws InterruptedException {
		// Verify if Element is displayed
		Assert.assertTrue(driver.findElement(helpCenter.HelpCenter).isDisplayed());
		helpCenter.clickHelpCenter();
	    Thread.sleep(3000);
	    // Verify if Element is displayed
	 	Assert.assertTrue(driver.findElement(helpCenter.Queries).isDisplayed());
	    helpCenter.clickGeneralQueries();
	    Thread.sleep(3000);
	    
	}
	
	@Then("List of frequent queries and answers appear on the page")
	public void list_of_frequent_queries_and_answers_appear_on_the_page() {
	    String queries = helpCenter.checkPageText();
	    Assert.assertTrue(queries.matches("I have a query related to placing an order"));
	}
	
	@When("User clicks on Legel hyperlink")
	public void user_clicks_on_legel_hyperlink() throws InterruptedException {
		// Verify if Element is displayed
		Assert.assertTrue(driver.findElement(helpCenter.HelpCenter).isDisplayed());
		helpCenter.clickHelpCenter();
	    Thread.sleep(3000);
	    // Verify if Element is displayed
	 	Assert.assertTrue(driver.findElement(helpCenter.legal).isDisplayed());
	    helpCenter.clickLegal();
	    Thread.sleep(3000);
	}
	
	@Then("Term & Conditions and Privacy Policy are visible to the user")
	public void term_conditions_and_privacy_policy_are_visible_to_the_user() {
		String LegalText = helpCenter.checkPageText();
	    Assert.assertTrue(LegalText.matches("Terms & Conditions"));
	}
	
	@When("User clicks on FAQS hyperlink")
	public void user_clicks_on_faqs_hyperlink() throws InterruptedException {
		// Verify if Element is displayed
		Assert.assertTrue(driver.findElement(helpCenter.HelpCenter).isDisplayed());
		helpCenter.clickHelpCenter();
	    Thread.sleep(3000);
	    // Verify if Element is displayed
	 	Assert.assertTrue(driver.findElement(helpCenter.faqs).isDisplayed());
	    helpCenter.clickFAQS();
	    Thread.sleep(3000);
	}
	
	@Then("Frequently asked questions are visible to the user")
	public void frequently_asked_questions_are_visible_to_the_user() {
		String faqs = helpCenter.checkPageText();
	    Assert.assertTrue(faqs.matches("I want to explore career opportunities with McDonalds"));
	}
	
	@When("User click on Feedback hyperlink")
	public void user_click_on_feedback_hyperlink() throws InterruptedException {
		// Verify if Element is displayed
		Assert.assertTrue(driver.findElement(helpCenter.HelpCenter).isDisplayed());
		helpCenter.clickHelpCenter();
	    Thread.sleep(3000);
	    // Verify if Element is displayed
	 	Assert.assertTrue(driver.findElement(helpCenter.feedback).isDisplayed());
	    helpCenter.clickFeedback();
	    Thread.sleep(3000);
	}
	
	@Then("User is redirected to Feedback page")
	public void user_is_redirected_to_feedback_page() {
		String checkFeedback = helpCenter.checkFeedBackPage();
	    Assert.assertTrue(checkFeedback.matches("Your Feedback"));
	}
	
	//Exit Browser
	@After("@HelpCenter")
	public void closeBrowser() {
		helpCenter.exitBrowser();
	}
	
}
