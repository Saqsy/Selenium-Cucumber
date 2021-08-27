/**
 * @author Saquib Kazi
 * 
 * This Class contains elements and functionalities required
 * to apply coupon through homepage.
 *
 */
package PageObjects;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.BrowserFactory;
import Helper.readexcel;


public class Offers {
	HomePage home = new HomePage();
	// Initialing WebDriver Element
	WebDriver driver;
		
	// Add button on first product
	By addFoodItem = By.xpath("//app-menu-item/div/div/div/app-price-section/div/div/button/span");

	// Add to Cart Button
	By addToCart = By.xpath("//div[3]/button[2]");

	// Offers Button on HomePage
	By homeOffers = By.xpath("//div[2]/div[2]/div");

	// Apply Coupon F200
	By coupon = By.id("applyText2012");

	// Promo Applied Successfully Message
	By couponApplied = By.xpath("/html/body/ngb-modal-window/div/div/app-alert-pop-up/div/div/div[2]/form/div/div");

	// Promo Applied Confirm Button
	By couponConfirm = By.xpath("//div[3]/button");
	
	// List of Code Available in the page
	By promoCodes = By.className("couponTitle");
	
	// Initiating WebDriver and passing it to testcase and PageObjects
	public WebDriver launchBrowser() {
		WebDriver driverInstance = BrowserFactory.startBrowser("chrome");
		this.driver = driverInstance;
		home.driver = driverInstance;
		return driverInstance;
	}
	
	// Login Precondition Method
	public void LoginPreCondition() throws InterruptedException, EncryptedDocumentException, IOException {
		
		// Driver will wait till the element is located
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(home.LoginAndSignUp));
		
		// Get Username And Password from excel		
		readexcel excel = new readexcel();
		String username = excel.getUsername();
		String password = excel.getPassword();
		
		// Precondition will start after element is loaded
		Thread.sleep(5000);
		home.clickLoginAndSignUp();
		Thread.sleep(5000);
		home.clickLoginViaPassword();
		Thread.sleep(5000);
		home.enterusername(username);
		Thread.sleep(5000);
		home.enterPassword(password);
		Thread.sleep(5000);
		home.clickLogin();
		Thread.sleep(5000);
	}
	
	// Verify Login / Sign Up Hyperlink
	public boolean verifyLoginAndSignUp() {
		return home.verifyLoginAndSignUp();
	}
	
	// Verify Add Button on HomePage
	public boolean verifyAddButton() {
		return driver.findElement(addFoodItem).isDisplayed();
	}
	
	// Click Add button
	public void addVisibleFood() {
		driver.findElement(addFoodItem).click();
	}
	
	// Verify Add to Cart button
	public boolean verifyAddtoCartButton() {
		return driver.findElement(addToCart).isDisplayed();
	}
	
	// Click Add to Cart Button
	public void clickAddtoCartButton() {
		driver.findElement(addToCart).click();
	}
	
	// Verify Offers Hyperlink is Displayed
	public boolean verifyOffersPageHyperlink() {
		return driver.findElement(homeOffers).isDisplayed();
	}
	
	// Click Offers Hyperlink
	public void clickOffersPage() {
		driver.findElement(homeOffers).click();
	}
	
	// Verify F200 Coupon Code is displayed
	public boolean verifyCouponCode() {
		return driver.findElement(coupon).isDisplayed();
	}
	
	// Apply Coupon Code
	public void applyCouponCode() {
		driver.findElement(coupon).click();
	}
	
	// Verify if coupon is applied or not
	public String verifyAppliedCoupon() {
		String sendCouponMsg = driver.findElement(couponApplied).getText();
		return sendCouponMsg;
	}
	
	// Click OK button of coupon code
	public void confirmButton() {
		driver.findElement(couponConfirm).click();
	}
	
	// Method to list PromoCodes displayed on the page
	public void verifyPromoCodes() throws FileNotFoundException, IOException {
		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet("Coupons");
		Row FirstRow = sheet.createRow(0);
		
		Cell FirstCell = FirstRow.createCell(0);
		FirstCell.setCellValue("Coupons Codes");
		
		List<WebElement> promoCodesList = driver.findElements(promoCodes);
		for(int i=0;i<promoCodesList.size();i++) {
			//System.out.println(promoCodesList.get(i).getText());
			Row row = sheet.createRow(i+1);
			Cell name = row.createCell(0);
			name.setCellValue(promoCodesList.get(i).getText());
			sheet.autoSizeColumn(i);
		}
		book.write(new FileOutputStream("src\\test\\resources\\Coupons.xlsx"));
		book.close();
	}
	
	
	// Exit Driver
	public void exitBrowser() {
		driver.quit();
	}
	
}
