package SeleniumLearnings;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDatePickerCalender {
	static HashMap<String,Integer> months;
	static {
		months = new HashMap<String,Integer>();
		months.put("January", 1);
		months.put("February", 2);
		months.put("March", 3);
		months.put("April", 4);
		months.put("May", 5);
		months.put("June", 6);
		months.put("July", 7);
		months.put("August", 8);
		months.put("September", 9);
		months.put("October", 10);
		months.put("November", 11);
		months.put("December", 12);
	}
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]")));
		
		
		//direct simple input
		//driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).sendKeys("03/08/2000");
		
		//using calender
		int date = 8;
		int year = 2020;
		String month = "March";
		datepicker(driver, year, month, date );
		
		Thread.sleep(3000);
		driver.quit();

	}
	
	//reusable method
	public static void datepicker(WebDriver driver,int year,String month,int date ) {
		driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).click();
		
		System.out.println(Integer.parseInt(driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText()));
		//year iteration
		while(year != Integer.parseInt(driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText())) {
			if(year > Integer.parseInt(driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText())) {
				driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-e\"]")).click();
			}
			else if(year < Integer.parseInt(driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText())) {
				driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-w\"]")).click();	
			}else if(year == Integer.parseInt(driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText())) {
				break;
			}
		}
		//month iteration
		while(!month.equals(driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText())) {
			if(months.get(month) > months.get(driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText())) {
				driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-e\"]")).click();
			}
			else if(months.get(month) < months.get(driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText())) {
				driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-w\"]")).click();	
			}
			else if(months.get(month) == months.get(driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText())) {
				break;
			}
		}
		
		//date picker
		driver.findElement(By.xpath("//td[@data-handler=\"selectDay\"]/a[@data-date=\""+date+"\"]")).click();
	}

}
