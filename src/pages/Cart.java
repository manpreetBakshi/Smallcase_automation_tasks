package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {
	WebDriver driver;
	
	//Constructor
		public Cart(WebDriver driver) {
			this.driver = driver;
		}
	// ------------------------------------------------FLIPKART LOCATORS ------------------------------------------------------
	//Locator for Plus button
		By increaseQuantity = By.xpath("//button[text()='+']");
		
	//Locator for final price
		By cartPrice = By.xpath("//div[@class='_1dqRvU']");
		
		// ------------------------------------------------AMAZON LOCATORS ------------------------------------------------------
		
		By amazonCartPrice = By.xpath("//span[@id='sc-subtotal-amount-buybox']");
		
		// ------------------------------------------------FLIPKART METHODS ------------------------------------------------------

	//wait until plus button is enabled and click it to increase quantity
	public void clickToIncreaseQuantity() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(increaseQuantity)).click();
	}
	
	//Get Final Price from the cart
	public String getCartPrice() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		return wait.until(ExpectedConditions.presenceOfElementLocated(cartPrice)).getText();
	}
	
	public double convertStringToDouble(String price) {
		return Double.parseDouble(price.replaceAll("[^\\d.]", ""));
	}
	// ------------------------------------------------AMAZON METHODS ------------------------------------------------------

	public String getAmazonCartPrice() {
		return driver.findElement(amazonCartPrice).getText();
	}
	
	
	

}
