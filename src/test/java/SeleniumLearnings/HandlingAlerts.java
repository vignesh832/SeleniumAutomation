package SeleniumLearnings;

import java.time.Duration;

import javax.print.DocFlavor.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingAlerts {

	public static void main(String[] args) throws InterruptedException {
		//Types of Alerts
			/* normal alert
			 * confirmation alert
			 * prompt alert
			 * 
			 * Alert alert= driver.switchTo.alert();
			 * alert.sendText();
			 * alert.getText();
			 * alert.accept();
			 * alert.dismiss();
			 */
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//normal alert
		driver.findElement(By.xpath("//button[text()=\"Click for JS Alert\"]")).click();
		Alert normalAlert = driver.switchTo().alert();
		System.out.println("normalAlert message:" + normalAlert.getText());
		normalAlert.accept(); // normal alert contains just one action to click ok(accept) nothing else.
		Thread.sleep(Duration.ofSeconds(3));
		
		//confirmation alert
		driver.findElement(By.xpath("//button[text()=\"Click for JS Confirm\"]")).click();
		
		Alert confirmationAlert = driver.switchTo().alert();
		System.out.println("confirmationAlert message:" + confirmationAlert.getText());
		//confirmationAlert.accept();
		confirmationAlert.dismiss(); // confirmation alert will have two buttons(ok,cancle)
		Thread.sleep(Duration.ofSeconds(3));
		
		//prompt alert
		driver.findElement(By.xpath("//button[text()=\"Click for JS Prompt\"]")).click();
		
		Alert promptAlert= driver.switchTo().alert();
		promptAlert.sendKeys("Hello!");
		System.out.println("promptAlert message:" + promptAlert.getText());
		promptAlert.accept();
		//promptAlert.dismiss();
		Thread.sleep(Duration.ofSeconds(3));
		
		
		
		// Handling alert using explicit wait and without using switching
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[text()=\"Click for JS Alert\"]")).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
		//Handling Authentication alert
		/*Auth alerts can be handled by injecting the auth data like username and password in the URL. 
		 * selenium doesn't support this auth alert.
		 */
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		Thread.sleep(1000);
		//https://username:password@the-internet.herokuapp.com/basic_auth
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth"); //username and password injected
		
		driver.quit();
		
	}

}
