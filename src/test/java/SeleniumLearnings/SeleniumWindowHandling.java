package SeleniumLearnings;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.facebook.com/");
		
		//getting current window
		String window=driver.getWindowHandle();
		
		System.out.println("Current window: "+window);
		
		//switching to another window
		Set<String> windows= driver.getWindowHandles();
		
		for(String window1:windows) {
			if(driver.switchTo().window(window1).getTitle().equals("Automation Testing Practice")) {
				break;
			}
		}
		System.out.println("Switched to: "+driver.getCurrentUrl());
		
		//closing one of the unwanted windows
		for(String window1:windows) {
			if(driver.switchTo().window(window1).getTitle().equals("Facebook – log in or sign up")) {
				driver.close();
				break;
			}
		}
		Thread.sleep(Duration.ofSeconds(3));
		driver.quit();
	}

}
