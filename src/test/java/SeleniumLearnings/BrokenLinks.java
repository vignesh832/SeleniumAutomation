package seleniumlearnings;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement> elements=driver.findElements(By.tagName("a"));
		int brokenLinkCount=0;
		for(WebElement element:elements) {
			if(element.getAttribute("href").contains("http")) {
				brokenLinkCount++;
				@SuppressWarnings("deprecation")
				URL url = new URL(element.getAttribute("href"));
				HttpURLConnection connection = null;
				try {
					connection =(HttpURLConnection) url.openConnection();
					connection.connect();
					if(connection.getResponseCode() >= 400) {
						System.out.println(url.toString() +"  " +connection.getResponseCode() + "<==== \"Broken Link\"");
					}else {
						System.out.println(url.toString() +"  " +connection.getResponseCode());
					}
				}
				catch(Exception e) {
					System.out.println(url.toString() +"  " +  "<====== Exception");
				}
			}
		}
		System.out.println("No. of broken links = "+brokenLinkCount);
		driver.quit();

	}

}
