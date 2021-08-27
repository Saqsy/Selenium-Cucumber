/**
 * @author Saquib Kazi
 * 
 * Test Case to check login functionality with
 * valid credentials.
 *
 */

package stepdefinition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import PageObjects.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class tc3_InvalidLogin {
	
	// Initializing Required PageObjects
	HomePage home = new HomePage();
	
	// Initializing WebDriver
	WebDriver driver;
	
	// InitializingBrowser
	@Before("@InvalidLogin")
	public void launchDriver() {
		this.driver = home.launchBrowser();
	} 
	
	// Screenshot Functionality After Each Step
	@AfterStep("@InvalidLogin")
	public void addScreenshot(Scenario scenario){

	      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	      scenario.attach(screenshot, "image/png", "image");
	}
	
	@Given("when the user opens HomePage")
	public void when_the_user_opens_home_page() throws InterruptedException {
		
		// Waiting 5 Seconds to load Page Elements
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(home.LoginAndSignUp));
		Assert.assertTrue(home.verifyLoginAndSignUp());
	}
	
	@When("The User clicks on Login and Sign-Up link")
	public void the_user_clicks_on_login_and_sign_up_link() throws InterruptedException {
		home.clickLoginAndSignUp();
	    Thread.sleep(5000);
	}
	
	@When("The User clicks Login Via Password hyperlink")
	public void the_user_clicks_login_via_password_hyperlink() throws InterruptedException {
		Assert.assertTrue(home.verifyLoginViaPassword());
		home.clickLoginViaPassword();
	    Thread.sleep(5000);
	}
	
	@When("The User enters {string} {string} and {string} {string}")
	public void the_user_enters_and(String string, String username, String string2, String password) throws InterruptedException {
		Assert.assertTrue(home.verifyusernameField());
		home.enterusername(username);
		Thread.sleep(5000);
		Assert.assertTrue(home.verifyPasswordField());
		home.enterPassword(password);
	    Thread.sleep(5000);
	    Assert.assertTrue(home.verifyLoginButton());
	    home.clickLogin();
	    Thread.sleep(5000);
	}
	
	// Verification of Test Case
	@Then("The system throws a message saying invalid username\\/password")
	public void the_system_throws_a_message_saying_invalid_username_password() throws InterruptedException {
		WebElement CheckErrorMsg = driver.findElement(home.errorMsg);
	    String ConvertToString = CheckErrorMsg.getText();
	    System.out.println(ConvertToString);
	    Assert.assertTrue(ConvertToString.matches("Invalid username or password"));
	    Thread.sleep(5000);
	}
	
	// Exit Browser
	@After("@InvalidLogin")
	public void closeBrowser() {
		home.exitBrowser();
	}
}
