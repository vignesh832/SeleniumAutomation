package seleniumlearnings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/#");
		
		//mouse actions
		/*	Click
		 * 	Right Click
		 * 	Double Click
		 * 	Mouse Hover
		 * 	Drag and Drop
		 * 	Scroll
		 * 	Mouse Move
		 */
		
		Actions actions = new Actions(driver);
		//build() method builds the actions, need to use perform() method to perform the ations.
		//perform() method internally builds and performs the actions.
		
		// Click
		WebElement element = driver.findElement(By.xpath("//button[@onclick=\"toggleButton(this)\"]"));
		actions.click(element).build().perform(); //dynamic button
		actions.click(element).perform();

		// Double Click
		element = driver.findElement(By.xpath("//button[text()=\"Copy Text\"]"));
		actions.doubleClick(element).perform();

		// Right Click
		//actions.contextClick(element).perform();

		// Mouse Hover
		element = driver.findElement(By.xpath("//button[@class=\"dropbtn\"]"));
		actions.moveToElement(element).perform();

		// Drag and Drop
		
		WebElement source = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
		WebElement target = driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
		actions.dragAndDrop(source, target).perform();
		
		// Click and Hold
		actions.clickAndHold(element).perform();
		actions.pause(Duration.ofSeconds(4)).perform();
		actions.release().perform();
		
		// Mouse Move
		element = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
		actions.moveToElement(element).perform();
		//actions.moveByOffset(0, 0).perform();
		//actions.moveToLocation(0, 0).perform();
		
		// Mouse Scroll
		element = driver.findElement(By.xpath("//input[@id =\"singleFileInput\" ]"));
		actions.scrollToElement(element).perform();
		Thread.sleep(3000);
		actions.scrollByAmount(0,-300).perform();
		
		
		// slider handling using x and y axis position
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		//pointer a
		element  = driver.findElement(By.xpath("//div[@id=\"slider-range\"]/span[1]"));
		actions.dragAndDropBy(element, 100, 0).perform();
		//pointer b
		element= driver.findElement(By.xpath("//div[@id=\"slider-range\"]/span[2]"));
		actions.clickAndHold(element).moveByOffset(-100, 0).release().perform();
		
		int xposition1 = element.getLocation().getX();
		int yposition1 = element.getLocation().getY();
		actions.clickAndHold(element).moveToLocation(xposition1-100,yposition1).perform();
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
