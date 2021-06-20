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
public class ScenarioB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Define the chrome driver path 
		System.setProperty("webdriver.chrome.driver", "/Users/manpreetkaur/Downloads/chromedriver");  
		WebDriver driver=new ChromeDriver();  
		
		//Navigate to  www.flipkart.com
		driver.navigate().to("https://www.flipkart.com/"); 
		
		//check if popup is there and close the popup
		if(driver.findElement(By.cssSelector("button[class='_2KpZ6l _2doB4z']")) != null) {
			driver.findElement(By.cssSelector("button[class='_2KpZ6l _2doB4z']")).click();
			
		}
		
		//navigate to search bar and type an item in the seach bar
		 driver.findElement(By.name("q")).sendKeys("Olay Retinol Cream");  
		 
		 
		 // click search
		 driver.findElement(By.cssSelector("button[class='L0Z3Pu']")).click();
		 
		 
		 //wait until all the search results show up
		 WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div._1anD2T")));
		
		 
	      
		 //click on the first item
		 driver.findElement(By.cssSelector("div._13oc-S > div:nth-child(1)")).click();
		 
		 //wait until iteam is displayed and Get the price
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div._25b18c > div:nth-child(1)")));
	      
		 String priceOnFlipkart = driver.findElement(By.cssSelector("div._25b18c > div:nth-child(1)")).getText();
		
		//Print the price (single item)
		System.out.println("=====================================================");
		System.out.println("Price on Flipkart before cart"+": "+priceOnFlipkart);
		
		
		//switch to new window
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
		   driver.switchTo().window(winHandle);
		}
		
		//Add item to the cart
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		
		//wait for few seconds
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//		//Get the price after adding to cart
		String finalPriceFlipkart = driver.findElement(By.xpath("//span[contains(@class,'_1WpvJ7')]")).getText();
//		
//		//Print the Final price.
		System.out.println("Final price on Flipkart price: "+ " :" + finalPriceFlipkart);
		
		System.out.println("=====================================================");
		
		//Convert the price to double
		double creamPriceOnFlipkart = Double.parseDouble(finalPriceFlipkart.replaceAll("[^\\d.]", ""));
		
		//navigate to amazon
		driver.navigate().to("https://www.amazon.in/"); 
		
		//search the item
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Olay Retinol Cream");
		
		//click search
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		//wait until page loads and click on the item
		driver.findElement(By.xpath("//div[@class='_multi-card-creative-desktop_DesktopGridColumn_gridColumn__2Jfab']")).click();
		
		//get the price of the  item before adding to the cart
		String amazonPriceBeforeCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='priceblock_ourprice']"))).getText();
		System.out.println("Amazon Price Before adding to the cart" + " : " + amazonPriceBeforeCart);
		//Amazon - add to cart
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='add-to-cart-button']"))).click();
		
		
		//open the cart
		driver.findElement(By.xpath("//div[@id='nav-cart-count-container']")).click();
		
		//get the price
		String amazonPrice = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-buybox']")).getText();
		System.out.println("Final price on Amazon" + ":" + amazonPrice);
		System.out.println("=====================================================");
		
		//print the results
		double creamPriceOnAmazon = Double.parseDouble(amazonPrice.replaceAll("[^\\d.]", ""));
		
		if(creamPriceOnFlipkart < creamPriceOnAmazon) {
			double difference = creamPriceOnAmazon - creamPriceOnFlipkart;
			System.out.println("Flipkart has better price by "+difference);
		}else {
			double difference =  creamPriceOnFlipkart - creamPriceOnAmazon;
			System.out.println("Amazon has better price by "+difference);
		}
		
		 
		
	
	}

}
