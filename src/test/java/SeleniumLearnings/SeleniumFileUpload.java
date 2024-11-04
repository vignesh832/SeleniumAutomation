package seleniumlearnings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFileUpload {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		String dir= System.getProperty("user.dir");
		System.out.println(dir);
		
		//single file upload
		driver.findElement(By.xpath("//input[@name=\"filesToUpload\"]")).sendKeys(dir+"\\src\\test\\mtfile.txt");
		Thread.sleep(3000);
		
		//multiple files upload
		driver.findElement(By.xpath("//input[@name=\"filesToUpload\"]")).sendKeys(dir+"\\src\\test\\mtfile.txt" +"\n" + dir+"\\src\\test\\mtfile2.txt");
		Thread.sleep(3000);
		driver.quit();
	}
}
