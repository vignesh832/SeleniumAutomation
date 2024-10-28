package SeleniumLearnings;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTakeScreenshot {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//using TakesScreenshot interface getScreenshotAs() method (Full visible page SS)
		TakesScreenshot Screenshot= (TakesScreenshot)driver;
		
		File takenScreenshot = Screenshot.getScreenshotAs(OutputType.FILE);
		String dir = System.getProperty("user.dir");
		File SSpath = new File(dir + "\\Screenshot\\fullvisiblepageSS.png");
		takenScreenshot.renameTo(SSpath);
		
		//using WebElement class (WebElement SS)
		WebElement element = driver.findElement(By.xpath("//div[@id=\"HTML1\"]"));
		
		takenScreenshot = element.getScreenshotAs(OutputType.FILE);
		
		SSpath = new File(dir + "\\Screenshot\\setionalSS.png");
		takenScreenshot.renameTo(SSpath);
		
		driver.quit();
	}
}
