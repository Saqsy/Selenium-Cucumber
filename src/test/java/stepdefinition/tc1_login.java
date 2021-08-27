/**
 * @author Saquib Kazi
 * 
 * Test Case to check login functionality with
 * valid credentials.
 *
 */

package stepdefinition;

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

public class tc1_login {
	
	// Initializing Required PageObjects
	HomePage home = new HomePage();
	
	// Initializing WebDriver
	WebDriver driver;
	
	// InitializingBrowser
	@Before("@Login")
	public void launchDriver() {
		this.driver = home.launchBrowser();
	} 
	
	// Screenshot Functionality After Each Step
	@AfterStep("@Login")
	public void addScreenshot(Scenario scenario){

	      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	      scenario.attach(screenshot, "image/png", "image");
	} 
	
	@Given("when the user is in the HomePage")
	public void when_the_user_is_in_the_home_page() throws InterruptedException {
	// Waiting 5 Seconds to load Page Elements
	Thread.sleep(5000);
	WebDriverWait wait = new WebDriverWait(driver,5);
	wait.until(ExpectedConditions.presenceOfElementLocated(home.LoginAndSignUp));
	Assert.assertTrue(home.verifyLoginAndSignUp());
	Thread.sleep(5000);
	}
	
	@When("The user clicks on Login\\/Sign Up link")
	public void the_user_clicks_on_login_sign_up_link() throws InterruptedException {
	    home.clickLoginAndSignUp();
	    Thread.sleep(5000);
	}
	
	@When("The user clicks Login Via Password option")
	public void the_user_clicks_login_via_password_option() throws InterruptedException {
		Assert.assertTrue(home.verifyLoginViaPassword());
		home.clickLoginViaPassword();
	    Thread.sleep(5000);
	}
	
	@When("The user enters valid username {string} and password {string}")
	public void the_user_enters_valid_username_and_password(String username, String password) throws InterruptedException {
		Assert.assertTrue(home.verifyusernameField());
		home.enterusername(username);
		Thread.sleep(2000);
		Assert.assertTrue(home.verifyPasswordField());
		home.enterPassword(password);
	    Thread.sleep(2000);
	    Assert.assertTrue(home.verifyLoginButton());
	    home.clickLogin();
	    Thread.sleep(5000);
	}
	
	// Verification of Test Case
	@Then("the system allows the user to login and navigate to the HOME page")
	public void the_system_allows_the_user_to_login_and_navigate_to_the_home_page() throws InterruptedException {
	    WebElement checkLogin = driver.findElement(home.MyAccount);
	    String ConvertToString = checkLogin.getText();
	    Assert.assertTrue(ConvertToString.matches("My Account"));
		System.out.println("Login Successful");
	    Thread.sleep(5000);
	}
	
	
	// Exit Browser
	@After("@Login")
	public void closeBrowser() {
		home.exitBrowser();
	}
}
