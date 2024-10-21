package SeleniumLearnings;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandingFrames {

	public static void main(String[] args) throws InterruptedException {
		
		//There are three switching methods available for different Elements such as frame, window, alert.
		
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		//switching to frame
		//frame1
		WebElement frame = driver.findElement(By.xpath("//frame[@src=\"frame_1.html\"]"));
		
		//driver.switchTo().frame(0); //index(prefered only when the page contains 1 or 2 frames)
		//driver.switchTo().frame("name");
		driver.switchTo().frame(frame);	//WebElement
		
		driver.findElement(By.xpath("//input[@name=\"mytext1\"]")).sendKeys("Hello!");
		
		driver.switchTo().defaultContent(); //switching back to default page from frame.
		
		//frame2 - inner frame
		WebElement outerFrame= driver.findElement(By.xpath("//frame[@src=\"frame_3.html\"]"));
		driver.switchTo().frame(outerFrame);//outer frame
		driver.switchTo().frame(0);//inner frame
		
		//driver.findElement(By.xpath("//div[@id=\"i5\"]")).click();
		
		JavascriptExecutor jsExe= (JavascriptExecutor)driver; 
		jsExe.executeScript("arguments[0].click()", driver.findElement(By.xpath("//div[@id=\"i5\"]")));
		
		Thread.sleep(Duration.ofSeconds(3));
		driver.quit();
	}

}
