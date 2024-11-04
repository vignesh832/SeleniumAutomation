package seleniumlearnings;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavigations {

	public static void main(String[] args) throws MalformedURLException {
		WebDriver driver = new ChromeDriver();
		
		//similar to driver.get() but this one accepts string format and URL object format.
		//internally wil call get method.
		
		@SuppressWarnings("deprecation")
		URL url = new URL("https://testautomationpractice.blogspot.com/");
		driver.navigate().to(url);
		driver.navigate().to("https://www.google.com/");
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		driver.navigate().refresh();
		
		driver.quit();
	}

}
