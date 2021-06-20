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
public class ScenarioA {

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
		 driver.findElement(By.name("q")).sendKeys("toys");  
		 
		 // click search
		 driver.findElement(By.cssSelector("button[class='L0Z3Pu']")).click();
		 
		 
		 //wait until all the search results show up
		 WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div._1anD2T")));
		
		 
	      
		 //click on the first item
		 driver.findElement(By.cssSelector("div._13oc-S > div:nth-child(1)")).click();
		 
		 //Get the price
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div._25b18c > div:nth-child(1)")));
	      
		 String price = driver.findElement(By.cssSelector("div._25b18c > div:nth-child(1)")).getText();
		
		//Print the price (single item)
		System.out.println("Price of One Item"+": "+price);
		
		

		//switch to new window
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
		   driver.switchTo().window(winHandle);
		}
		
		//Add one more item to cart
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		
		
		// wait until + button is clickable / loaded and click the button
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='+']"))).click();
	
		
		//refresh the page
		driver.navigate().refresh();
		
		//Get the price of 2 items
		
		String finalPrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='_1dqRvU']"))).getText();
		
		//Print the Final price.
		System.out.println("FINAL PRICE: "+ " :" + finalPrice);
		
	}
	
	
	
	

}
