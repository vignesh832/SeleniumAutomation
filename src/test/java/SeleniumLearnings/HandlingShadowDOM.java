package seleniumlearnings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingShadowDOM {

	public static void main(String[] args) throws InterruptedException {
		// Shadow DOM and SVG elemts handling video -> https://youtu.be/Lr4C-rExdKU?list=PLUDwpEzHYYLtQzEEEldbjPAR-gnStv4sR&t=2742
		
		// SHADOW DOM
			
		/* Shadow DOM attaches a hidden Document Object Model (DOM) to an element, called the Shadow Host. 
		 * The hidden DOM is called the Shadow DOM, and the element it's attached to is called the Shadow Host. 
		 * 
		 * Benefits Shadow DOM allows developers to:
		 * Encapsulate style and markup: Developers can define styles that are separate from the document. 
		 * Protect components: Developers can protect components from being manipulated by other HTML, CSS, and JavaScript. 
		 * Create reusable components: Developers can create self-contained components that can integrate into existing applications.
		 */
		
		// Xpath or any other locator except cssSelector won't work on shadow DOM, 
		//and reguar selenium action method like click and sendKeys() won't work unless JavascriptExecutor is used.
		
		//There are two main ways to locate element inside shadow DOM,
			/*	1, using CSS selector and selenium.
			 * 	2, using JavascriptExecutor and DOM manipulation script. https://www.youtube.com/watch?v=Gqc8Rq3KdPM
			 */
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://dev.automationtesting.in/shadow-dom");
		
		// 1, using css selector and selenium(can't perform any actions like click without using Javascript Executor)
		
		SearchContext shadowRoot= driver.findElement(By.id("shadow-root")).getShadowRoot();
		String ShadowElement = shadowRoot.findElement(By.cssSelector("#shadow-element")).getText();
		System.out.println(ShadowElement);
		
		//inner shadowDom
		
		SearchContext innerShadowRoot = shadowRoot.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		String innerShadowElement = innerShadowRoot.findElement(By.cssSelector("#nested-shadow-element")).getText();
		System.out.println(innerShadowElement);
		
		//Nested shadowDom
		SearchContext nestedShadowRoot = innerShadowRoot.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
		String nestedShadowElement = nestedShadowRoot.findElement(By.cssSelector("#multi-nested-shadow-element")).getText();
		System.out.println(nestedShadowElement);
		
		// 2, using JavascriptExecutor
		driver.get("https://testautomationpractice.blogspot.com/#");
		
		SearchContext shadowRoot1 = driver.findElement(By.cssSelector("#shadow_host")).getShadowRoot();	
		WebElement element =shadowRoot1.findElement(By.cssSelector("a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		
		//(or) (either way, have to use JavascriptExecutor to perform actions)
		
		driver.navigate().back();
		//can write JS path using dev tools console or use devtools provided copy JS path option on partucular element.
		element = (WebElement)((JavascriptExecutor)driver).executeScript("return document.querySelector('#shadow_host').shadowRoot.querySelector('input[type=\\'text\\']')");
		element.sendKeys("Input");
		
		Thread.sleep(5000);
		driver.quit();
	}

}
