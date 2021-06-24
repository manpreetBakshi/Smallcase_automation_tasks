/**
 * 
 */
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author manpreetkaur
 *
 */
public class HomePage {

	WebDriver driver;
	
	//Constructor that will be called automatically
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	//----------------------------------------------FLIPKART LOCATORS--------------------------------------------------------------------
	
	//Locator for popup
	By popup = By.cssSelector("button[class='_2KpZ6l _2doB4z']");
	
	//Locator for Search Bar
	By searchBar = By.name("q");
	
	//Locator for search buttom
	By searchButton = By.cssSelector("button[class='L0Z3Pu']");
	
	//Method to close popup
	public void closePopup() {
		if(driver.findElement(popup) != null) {
			driver.findElement(popup).click();
		
		}
	}
	
	//----------------------------------------------AMAZON LOCATORS--------------------------------------------------------------------
	By amazonSearchBar = By.xpath("//input[@id='twotabsearchtextbox']");
	
	By amazonSearchButton = By.xpath("//input[@id='nav-search-submit-button']");
	//----------------------------------------------FLIPKART METHODS--------------------------------------------------------------------
	
	//Method to search for an item
	public void searchForItemFK() {
		 driver.findElement(searchBar).sendKeys("toys");  
		 driver.findElement(searchButton).click();
	}

	public void searchForOlay() {
		driver.findElement(searchBar).sendKeys("Olay Retinol Cream");  
		 driver.findElement(searchButton).click();
	}
	
	//----------------------------------------------AMAZON METHODS--------------------------------------------------------------------
	public void searchForItemAmzn() {
		driver.findElement(amazonSearchBar).sendKeys("Olay Retinol Cream");  
		 driver.findElement(amazonSearchButton).click();
	}
	
}
