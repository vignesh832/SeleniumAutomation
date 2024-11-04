package seleniumlearnings;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OptionsClassUsage {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		
		//headless mode
		options.addArguments("--headless=new");
		
		//for unseured apps that lead to warning page, can use this option.
		options.setAcceptInsecureCerts(true);
		
		// set and get browser version(get method will return the only if the browserversion is been set)
		options.setBrowserVersion("130.0.6723.70");
		System.out.println(options.getBrowserVersion());
		
		// used to allow the browser automation setting and hides the "automated browser notification"
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		
		// to perform test in incognito mode
		options.addArguments("--incognito");
		
		// add extension to the driver(won't work on incognito mode)
		options.addExtensions(new File(System.getProperty("user.dir")+"\\extensions\\uBlock-Origin-adblocker.crx"));
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		Thread.sleep(3000);
		
		driver.get("https://text-compare.com/");
		Thread.sleep(10000);
		driver.quit();
	}
}
