/**
 * 
 */
package test;

import java.util.List;
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
public class ScenarioB {

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
				 
		//check if popup is there and close the popup
		homepage.closePopup();
		
		//navigate to search bar and search for olay cream
		homepage.searchForOlay();
		 
		 //wait until all the search results show up
		searchResults.waitUntilLastItemAppears();
		 
	      
		//click on the first item
		searchResults.clickFirstItem();
		 
		 //wait until iteam is displayed 
		 itemSelected.waitUntilPageLoads();
		 
		 //Get the price
		 //String priceOnFlipkart = driver.findElement(By.cssSelector("div._25b18c > div:nth-child(1)")).getText();
		
		//Print the price (single item)
		System.out.println("=====================================================");
		System.out.println("Price on Flipkart before cart"+": "+itemSelected.getPrice());
		
		
		//switch to new window
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
		   driver.switchTo().window(winHandle);
		}
		
		//Add item to the cart
		itemSelected.clickAddToCart();
		
		//wait for few seconds
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//		//Print the Final price.
		System.out.println("Final price on Flipkart price: "+ " :" + cart.getCartPrice());
		System.out.println("=====================================================");
		
		//Convert the price to double
		double finalFlipKartPrice = cart.convertStringToDouble(cart.getCartPrice());
		
		//navigate to amazon
		driver.navigate().to("https://www.amazon.in/"); 
		
		//search the item on amazon
		homepage.searchForItemAmzn();
		
		//wait until page loads and click on the item
		searchResults.clickFirstItemAmazon();
		
		String winHandleBeforeB = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
		   driver.switchTo().window(winHandle);
		}
		
//		//get the price of the  item before adding to the cart
//		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		

		System.out.println("Amazon Price Before adding to the cart" + " : " + itemSelected.getPriceAmazon());
		
		//wait
		itemSelected.waitUntilPageLoadsAmazon();
//		
		//Amazon - add to cart
		itemSelected.clickAddToCartAmazon();
		
		//open the cart
		itemSelected.goToCart();
		
		//get the price
		
		System.out.println("Final price on Amazon" + ":" + cart.getAmazonCartPrice());
		System.out.println("=====================================================");
		
		//Convert price to double 
		cart.convertStringToDouble(cart.getAmazonCartPrice());
		
		//print the results
		double creamPriceOnAmazon = cart.convertStringToDouble(cart.getAmazonCartPrice());
		
		if(finalFlipKartPrice < creamPriceOnAmazon) {
			double difference = creamPriceOnAmazon - finalFlipKartPrice;
			System.out.println("Flipkart has better price by "+difference);
		}else {
			double difference =  finalFlipKartPrice - creamPriceOnAmazon;
			System.out.println("Amazon has better price by "+difference);
		}
		
		driver.quit();
	
	}

}
