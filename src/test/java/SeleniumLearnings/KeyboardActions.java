package SeleniumLearnings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://text-compare.com/");
		
		WebElement element = driver.findElement(By.xpath("//textarea[@name=\"text1\"]"));
		element.sendKeys("Hello!");
		
		Actions actions= new Actions(driver);
		
		// copy pasting a text from one text area to another using keyboard shortcuts. 
		actions.keyDown(Keys.CONTROL).sendKeys("AC").keyUp(Keys.CONTROL).perform();
		actions.keyDown(Keys.TAB).keyUp(Keys.TAB).keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
		Thread.sleep(3000);
		driver.quit();
	}
}
