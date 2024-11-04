package seleniumlearnings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//Selenium Locators
		/*	id
		 * 	name
		 * 	linkText
		 * 	partialLinkText
		 * 	tagName
		 * 	className
		 * 	cssSelector
		 * 	xpath
		 */
		
		//id='male'
		driver.findElement(By.id("male")).click();
		//name="gender"
		driver.findElement(By.name("gender"));
		//<a>linktext</a>
		driver.findElement(By.linkText("linktext"));
		//<a>linktext</a>
		driver.findElement(By.partialLinkText("linktex"));
		
		//ex: a, input, div, table, tr, th, img, ect.,(will return many elements since the tagname will be used in many placeses in a webpage)
		driver.findElements(By.tagName("a"));
		//class="form-control" (may return number of elements if the class is used in different elements)
		driver.findElement(By.className("form-control"));
		
		
		//Customized Locators
		
		//CSS Selector 
		/* tag id					tag#id
		 * tag class				tag.classname
		 * tag attribute			tag[attribute='attributevalue']
		 * tag class attribute		tag.classname[attribute='attributevalue']
		 * 
		 * for chained css selector use ( tag > tag attribute > tag class attribute > tag class)
		 * ex: a > span[type='text'] > a.link[type='link'] > a.link
		 */
		//<input id="phone"/>
		driver.findElement(By.cssSelector("input#phone"));
		//<input class="phone"/>
		driver.findElement(By.cssSelector("input.phone"));
		//<input placeholder="Enter Phone"/>
		driver.findElement(By.cssSelector("input[placeholder=\"Enter Phone\"]"));
		//<input class="exclass" placeholder="Enter Phone"/>
		driver.findElement(By.cssSelector("input.exclass[placeholder=\"Enter Phone\"]"));
		
		//XPATH
		//A xpath is a adress used to locate a particular or set of particular group of elements/element to perform actions on it.
		driver.findElement(By.xpath(""));
		
		//Types of xpath
		/*
		 * absolute xpath(full xpath)
		 * 	Starts from html root node and goes till the element need to be located.
		 * 	ex: /html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div/div/div[1]/div[1]/div/div/div/div/div[2]/div[1]/input[2]
		 * 
		 * relative xpath(partial xpath)
		 * 	will jump to the particular fixed element and goes till the element need to be located
		 * 	ex: //input[@id="phone"]
		 */ 
		
		/*
		 * xpath contains many function which can be used to locate the elements. functions such as text(), contains(), starts-with(), ends-with()
		 *  ex: //a[text()="innertext"]
		 *  ex: //a[contains(text(),"innertex")]
		 * can use and or operators to add more attibutes
		 *  ex: //input[@id="phone" and @name="name"]
		 */
		
		//XPATH Axes
		
		/*	
		 * 	AxisName			Result
			ancestor			Selects all ancestors (parent, grandparent, etc.) of the current node
			ancestor-or-self	Selects all ancestors (parent, grandparent, etc.) of the current node and the current node itself
			descendant			Selects all descendants (children, grandchildren, etc.) of the current node
			descendant-or-self	Selects all descendants (children, grandchildren, etc.) of the current node and the current node itself
			parent				Selects the parent of the current node
			child				Selects all children of the current node
			following			Selects everything in the document after the closing tag of the current node
			following-sibling	Selects all siblings after the current node
			preceding			Selects all nodes that appear before the current node in the document, except ancestors, attribute nodes and namespace nodes
			preceding-sibling	Selects all siblings before the current node
			self				Selects the current node
		 * 
		 * 	Common XPath Axes
			child::: Selects children of the context node.
			Example: //div/child::span
			
			parent:: : Selects the parent of the context node.
			Example: //span/parent::div
			
			ancestor:: : Selects all ancestors (parents, grandparents, etc.) of the context node.
			Example: //span/ancestor::div
			
			descendant:: : Selects all descendants (children, grandchildren, etc.) of the context node.
			Example: //div/descendant::span
			
			following-sibling:: : Selects all siblings after the context node.
			Example: //h1/following-sibling::p
			
			preceding-sibling:: : Selects all siblings before the context node.
			Example: //h1/preceding-sibling::p
			
			following:: : Selects everything in the document after the context node.
			Example: //div/following::p
			
			preceding:: : Selects everything in the document before the context node.
			Example: //div/preceding::p
			
			self:: : Selects the context node itself.
			Example: //div/self::div
			
			descendant-or-self:: : Selects the context node and all its descendants.
			Example: //div/descendant-or-self::span
		 * 
		 * 	//input[@id="phone"]/AxisName::tagname or //input[@id="phone"]/AxisName::*
		 */
		
		driver.findElement(By.xpath(""));
		
		Thread.sleep(1000);
		driver.quit();

	}

}
