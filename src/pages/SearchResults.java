/**
 * 
 */
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author manpreetkaur
 *
 */
public class SearchResults {
	WebDriver driver;
	//Constructor that will be called automatically
		public SearchResults(WebDriver driver) {
			this.driver = driver;
		}
	// --------------------------FLIPKART LOCATORS ---------------------------------
		//Locator for last item on page
		
		By lastItem = By.cssSelector("div._1anD2T");
		//Locator for the first item
		By firstItem = By.cssSelector("div._13oc-S > div:nth-child(1)");
		
		// --------------------------AMAZON LOCATORS ---------------------------------
		
		By amazonFirstItem = By.xpath("//div[@data-index=1]");
		
		//----------------------------------------------FLIPKART METHODS--------------------------------------------------------------------

		 //Method to click on the first item
		public void clickFirstItem() {
			driver.findElement(firstItem).click();
		}
		 
		//Method to wait for the search results to load
		public void waitUntilLastItemAppears() {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			 wait.until(ExpectedConditions.presenceOfElementLocated(lastItem));
		}
		
		//----------------------------------------------AMAZON METHODS--------------------------------------------------------------------

		 //Method to click on the first item
		public void clickFirstItemAmazon() {
			driver.findElement(amazonFirstItem).click();
		}

}
