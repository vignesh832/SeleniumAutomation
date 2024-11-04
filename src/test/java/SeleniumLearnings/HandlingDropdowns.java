package seleniumlearnings;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdowns {

	public static void main(String[] args) throws InterruptedException {
		
		//Types of Dropdown
		/*	select dropdown
		 * 	bootstrap dropdown
		 * 	hidden dropdown
		 */
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//1, Select dropdown(will have select tag which contains different dropdown selectable options)
		WebElement dropdown = driver.findElement(By.xpath("//select[@id=\"country\"]"));
		
		Select options= new Select(dropdown);
		options.selectByIndex(1);
		options.selectByValue("uk");
		options.selectByVisibleText(" Australia ");
		
		//capture all options from dropdown
		List<WebElement> list=options.getOptions();
		
		for(WebElement option:list) {
			System.out.println(option.getText());
		}
		
		//2, bootstrap dropdown (no special support from selenium, so have to use regular locators,actions to interact)
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.findElement(By.xpath("//button[contains(@class,\"multiselect dropdown\")]")).click();
		
		driver.findElement(By.xpath("//input[@value=\"Oracle\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Java\"]")).click();
		
		//capture all options from dropdown
		driver.findElement(By.xpath("//button[contains(@class,\"multiselect dropdown\")]")).click();
		List<WebElement> options1= driver.findElements(By.xpath("//ul[@class=\"multiselect-container dropdown-menu\"]//input"));
		
		for(WebElement option:options1) {
			System.out.println(option.getAttribute("value"));
		}
		
		//3, hidden dropdown (similar to bootstrap dropdown, options will be hidden)
		
		// choose the one visible option tag > go to Eventlisteners > blur > remove everything usder blur(for each dropdown have to use seperately, not applied for entire page).
		
		//login&navib=gating to target page
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		driver.findElement(By.xpath("//ul[@class=\"oxd-main-menu\"]/li[2]")).click();
		
		
		
		driver.findElements(By.xpath("//i[contains(@class,\"oxd-select-text--arrow\")]")).get(2).click();
		
		driver.findElement(By.xpath("//div/span[text()=\"Chief Financial Officer\"]")).click();
		
		//capture all options from dropdown
		driver.findElements(By.xpath("//i[contains(@class,\"oxd-select-text--arrow\")]")).get(2).click();
		
		List<WebElement> options3= driver.findElements(By.xpath("//div[@class=\"oxd-select-option\"]/span"));
		
		for(WebElement option:options3) {
			System.out.println(option.getText());
		}
		
		
		// Auto Suggested dropdown
		
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//textarea[@title=\"Search\"]")).sendKeys("selenium");
		
		//capture all options and select the required option
		
		List<WebElement> options4= driver.findElements(By.xpath("//li[@data-attrid=\"AutocompletePrediction\" and contains(@data-entityname,\"selenium\")]"));
		for(WebElement option:options4) {
			if(option.getAttribute("data-entityname").equalsIgnoreCase("Selenium")) {
				option.click();
				break;
			}
		}
		
		Thread.sleep(5000);
		driver.quit();
	}

}
