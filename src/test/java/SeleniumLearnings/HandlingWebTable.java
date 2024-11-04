package seleniumlearnings;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWebTable {

	public static void main(String[] args) {
		
		//Different Tables
		/*	Static tables (fixed rows)
		 * 	Dynamic tables
		 * 	Pagination tables
		 */
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		// 1,Static table
		
		// counting the rows and columns to iterate through the table.
		int rowCount = driver.findElements(By.xpath("//table[@name=\"BookTable\"]/tbody/tr")).size();
		int columnCount = driver.findElements(By.xpath("//table[@name=\"BookTable\"]/tbody/tr/th")).size();
		
		// getting all table data
		for(int i = 1; i <= rowCount;i++ ) {
			for(int j= 1; j <= columnCount; j++) {
				if(i==1) {
					System.out.print(driver.findElement(By.xpath("//table[@name=\"BookTable\"]/tbody/tr["+i+"]/th["+j+"]")).getText()+ " | ");
				}
				else {
					System.out.print(driver.findElement(By.xpath("//table[@name=\"BookTable\"]/tbody/tr["+i+"]/td["+j+"]")).getText()+ " | ");
				}
			}
			System.out.println();
		}
		
		// 2, dynamic table (dynamic table is same as static one, but row count will increase)
		
		// 3, Pagination table
		
		int rowCount1 = driver.findElements(By.xpath("//table[@id=\"productTable\"]/tbody/tr")).size();
		int columnCount1 = driver.findElements(By.xpath("//table[@id=\"productTable\"]/thead/tr/th")).size();
		List<WebElement> pages= driver.findElements(By.xpath("//ul[@id=\"pagination\"]/li/a"));
		
		// getting all table data
		for(int p=1; p <= pages.size(); p++) {
			for(int i = 1; i <= rowCount1;i++ ) {
				
				if(i==1 && p==1) {
					for(int j=1; j<= columnCount1 -1 ; j++) {
						System.out.print(driver.findElement(By.xpath("//table[@id=\"productTable\"]/thead/tr["+i+"]/th["+j+"]")).getText()+ " | ");
					}	
					System.out.println();
				}
				for(int j= 1; j <= columnCount1 -1 ; j++) {
					
					System.out.print(driver.findElement(By.xpath("//table[@id=\"productTable\"]/tbody/tr["+i+"]/td["+j+"]")).getText()+ " | ");

				}
				System.out.println();
			}
			if(p != pages.size()) {
				pages.get(p).click();
			}
				
		}
		
		driver.quit();
		
		
	}

}
