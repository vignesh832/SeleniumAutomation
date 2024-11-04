package seleniumlearnings;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaits {

	public static void main(String[] args) {
		//Selenium Waits
			/* implicit wait(default wait for the whole driver, used for frequnt polling)
			 * explicit wait
			 * fluent wait(a type of explicit wait)
			 */
		WebDriver driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//implicit wait
		
		/* Sets a default wait time for the entire WebDriver instance. If the element is not found immediately, 
		 * it will poll the DOM for the specified time before throwing a NoSuchElementException.
		 * 
		 * When to Use: Use implicit waits when you want a simple, global wait time for all elements. 
		 * It's good for general scenarios where elements may load at different times.
		 */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//explicit wait
		
		/* Allows you to wait for a specific condition to occur before proceeding. 
		 * You define the condition, and WebDriver will wait until that condition is met or the timeout expires.
		 * 
		 * When to Use: Use explicit waits when you need to wait for specific elements or conditions 
		 * (e.g., visibility of an element, element to be clickable). This is more flexible than implicit waits.
		 */
		WebDriverWait eWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement img= eWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img")));
		
		if(img!=null) {
			System.out.println("element present");
			System.out.println(img.toString());
		}
		
		//fluent wait
		
		/* Similar to explicit waits, but allows you to set the polling interval and ignore specific exceptions 
		 * (like NoSuchElementException) while waiting for a condition.
		 * 
		 * When to Use: Use fluent waits when you need more control over the wait time and conditions, 
		 * especially in scenarios where elements may appear and disappear multiple times.
		 */
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.pollingEvery(Duration.ofMillis(500))
				.withTimeout(Duration.ofSeconds(15))
				.ignoring(NoSuchElementException.class);
		
		WebElement we=fluentWait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//img"));
			}
		});
		if(we!=null) {
			System.out.println("element present");
			System.out.println(we.toString());
		}
		driver.quit();
	}

}
