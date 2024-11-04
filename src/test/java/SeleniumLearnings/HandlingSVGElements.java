package SeleniumLearnings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingSVGElements {

	public static void main(String[] args) throws InterruptedException {
		
		//have to use name() method to locate a SVG element. standard xpath won't work on svg elements.
		//*[name()="tagname"]
		
		/* 	We have to use ‘*’ along with the double slash, i.e. //*
			name() method should be used for locating the ‘svg’ tag, i.e. //*[name()='svg']
			local-name() should be used for locating the subtags like ‘g’ or ‘path’ 
			We can use ‘and’ & ‘@’ for grouping the attributes.
			
			Example: //*[name()='svg']//*[local-name()='g' and @fill-rule='evenodd']
		*/
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://icons.getbootstrap.com/");
		//svg[attribute="value"] <<===== this won't work since the svg tagname won't work like other tags in xpath.
		//use this link for more info. -> https://blogs.terrificminds.com/how-to-handle-svg-elements-in-selenium-java#:~:text=The%20SVG%20element%20will%20not,at%20what%20SVG%20elements%20are.
		driver.findElement(By.xpath("//*[name()=\"svg\" and @class=\"d-block my-1\"]")).click();
		Thread.sleep(Duration.ofSeconds(5));
		
		driver.quit();
		
	}

}
