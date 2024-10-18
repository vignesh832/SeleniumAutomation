package SeleniumLearnings;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		
		//WebDriver get Methods
		driver.get("https://testautomationpractice.blogspot.com/");
		String url = driver.getCurrentUrl();
			System.out.println(url);
			
		String title = driver.getTitle();
			System.out.println(title);
			
		String window=driver.getWindowHandle();
			System.out.println(window);
			
			driver.switchTo().newWindow(WindowType.TAB);	
		Set<String> windows=driver.getWindowHandles();
			for(String window1: windows) {
				System.out.println(window1);
			}
			driver.close();
			driver.switchTo().window(window);
		String pagesource= driver.getPageSource();
			System.out.println(pagesource);
			
		//Conditional Methods
			
		//used to check the element is displayed or not
		boolean bool=driver.findElement(By.xpath("//img")).isDisplayed();
		System.out.println(bool);
		//used to verify the element is interactable or in disabled state(not interactable)
		bool=driver.findElement(By.xpath("//input[@id=\"male\"]")).isEnabled();
		System.out.println(bool);
		//used to check the element is selected or not. ex: radio button, check box.
		bool=driver.findElement(By.xpath("//input[@id=\"male\"]")).isSelected();
		System.out.println(bool);
			
		//WebDriver flush Methods
		driver.close();	
		driver.quit();

	}

}
