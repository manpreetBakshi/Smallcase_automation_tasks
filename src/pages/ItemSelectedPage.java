/**
 * 
 */
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * @author manpreetkaur
 *
 */
public class ItemSelectedPage {
	
	WebDriver driver;
	
	//Constructor
	public ItemSelectedPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//----------------------------------------------FLIPKART LOCATORS--------------------------------------------------------------------

	
	//Locator for price
	By priceBeforeCart = By.cssSelector("div._25b18c > div:nth-child(1)");
	//Locator for add to cart button
	
	By addToCartButton = By.xpath("//button[text()='ADD TO CART']");
	
	//----------------------------------------------AMAZON LOCATORS--------------------------------------------------------------------

	By priceBeforeCartAmazon = By.xpath("//span[@id='priceblock_ourprice']");
	
	//By addToCartButtonAmazon = By.xpath("//input[@id='add-to-cart-button']");
	By addToCartButtonAmazon = By.id("add-to-cart-button");
	
	
	By cart = By.xpath("//div[@id='nav-cart-count-container']");
	
	//----------------------------------------------FLIPKART METHODS--------------------------------------------------------------------

	//Method for waiting
	public void waitUntilPageLoads() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.presenceOfElementLocated(priceBeforeCart));
	}
	
	//Method for clicking add to cart
	public void clickAddToCart() {
		driver.findElement(addToCartButton).click();
	}
	
	//method for getting price
	public String getPrice() {
		return driver.findElement(priceBeforeCart).getText();
		
	}
	
	//----------------------------------------------AMAZON METHODS--------------------------------------------------------------------

	//Method for waiting
	public void waitUntilPageLoadsAmazon() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButtonAmazon));
		
	}
	
	//Method for clicking add to cart
	public void clickAddToCartAmazon() {
		driver.findElement(addToCartButtonAmazon).click();
		
	}
	
	//method for getting price
	public String getPriceAmazon() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		return wait.until(ExpectedConditions.presenceOfElementLocated(priceBeforeCartAmazon)).getText();
//		WebDriverWait wait = new WebDriverWait(driver, 60);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(priceBeforeCartAmazon));
//		return driver.findElement(priceBeforeCartAmazon).getText();
	}
	
	//Method for going to cart
	public void goToCart(){
		driver.findElement(cart).click();
	}
	
}
