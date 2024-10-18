package SeleniumLearnings;

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
			/* implicit wait
			 * explicit wait
			 * fluent wait(a type of explicit wait)
			 */
		WebDriver driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//explicit wait
		WebDriverWait eWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement img= eWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img")));
		
		if(img!=null) {
			System.out.println("element present");
			System.out.println(img.toString());
		}
		
		//fluent wait
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
