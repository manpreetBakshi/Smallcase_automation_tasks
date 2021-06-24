/**
 * 
 */
package test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
/**
 * @author manpreetkaur
 *
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Cart;
import pages.HomePage;
import pages.ItemSelectedPage;
import pages.SearchResults;
public class ScenarioA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//Define the chrome driver path 
		System.setProperty("webdriver.chrome.driver", "/Users/manpreetkaur/Downloads/chromedriver");  
		WebDriver driver=new ChromeDriver();  
		driver.manage().window().maximize();
		//Navigate to  www.flipkart.com
		driver.navigate().to("https://www.flipkart.com/"); 
		
		// define and instantiate objects from pages classes
		 HomePage homepage = new HomePage(driver);
		 SearchResults searchResults = new SearchResults(driver);
		 ItemSelectedPage itemSelected = new ItemSelectedPage(driver);
		 Cart cart = new Cart(driver);
		 
		 //Close login popup
		 homepage.closePopup();
		 
		 //search for an item
		 homepage.searchForItemFK();
		
		 //wait until all the search results show up
		 searchResults.waitUntilLastItemAppears();
		
		 //click on the first item
		 searchResults.clickFirstItem();
		 
		 //Get the price and print it
	
		//Print the price (single item)
		System.out.println("Price of One Item"+": "+itemSelected.getPrice());
		
		

		//switch to new window
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
		   driver.switchTo().window(winHandle);
		}
		
		//Click add to cart
		itemSelected.clickAddToCart();
		
		
		// wait until + button is clickable / loaded and click the button
		cart.clickToIncreaseQuantity();
	
		
		//refresh the page
		driver.navigate().refresh();
		
	
		//Print the Final price of two items
		System.out.println("FINAL PRICE: "+ " :" + cart.getCartPrice());
		
		driver.quit();
		
	}
	
	
	
	

}
