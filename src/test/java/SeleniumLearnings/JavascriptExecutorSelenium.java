package seleniumlearnings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorSelenium {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/#");
		
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		//mostly JavascriptExecutor will be used when usual driver action returns "ElementInterepted Exception".
		
		WebElement element = driver.findElement(By.xpath("//button[@onclick=\"toggleButton(this)\"]"));
		// 1, click using Js script
		jse.executeScript("arguments[0].click()", element);
		
		// 2, Highlighting an Element
		//(This script highlights an element by changing its background color.)
		element = driver.findElement(By.xpath("//span[@class=\"separator\"]"));
		jse.executeScript("arguments[0].style.backgroundColor = 'yellow';", element);
		
		// 3, Scrolling to an Element
		//(This script scrolls the page to make a specific element visible.)
		element = driver.findElement(By.xpath("//button[@id=\"btn1\"]"));
		jse.executeScript("arguments[0].scrollIntoView();", element);
		
		// 4, Changing Element Text
		//(can change the text of an element directly using JavaScript.)
		Object[] obj= new Object[2];
		obj[0]= driver.findElement(By.xpath("//p[contains(text(),\"Network speed\")]"));
		obj[1] = "Net. Speed ";
		jse.executeScript("arguments[0].textContent = arguments[1];", obj);
		
		// 5, Getting Element Attribute
		//(This retrieves an attribute's value from an element.)
		obj[0] = driver.findElement(By.xpath("//input[@placeholder=\"Enter Name\"]"));
		obj[1] = "placeholder";
		String placeholder= (String) jse.executeScript("return arguments[0].getAttribute(arguments[1]);", obj);
		System.out.println(placeholder);
		
		// 6, Removing an Element
		//(If you need to remove an element from the DOM.)
		jse.executeScript("arguments[0].remove();", obj[0]);
		
		// 7, Creating a New Element
		//(You can create a new element and append it to the body or any other container.)
		obj[0]="New Element Created!";
		String script = " var newElement = document.createElement('div'); "
				+ "newElement.textContent = 'arguments[0]'; "
				+ "document.body.appendChild(newElement);";
		jse.executeScript(script, obj);
		
		// 8, setting page zoom level
		jse.executeScript("document.body.style.zoom='50%'", obj);
		Thread.sleep(5000);
		driver.quit();
	}

}
