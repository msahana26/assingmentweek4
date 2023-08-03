package week4day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buythevalue {
	public static void main(String[] args) throws Throwable {
		 ChromeDriver  driver=new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.get("https://buythevalue.in/");  
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	      
	     driver.findElement(By.xpath("//a[@class='grid-image'][1]")).click();
	     
	     driver.findElement(By.xpath("//input[@id='wk_zipcode']")).sendKeys("600002");
	     driver.findElement(By.xpath("//div[@class='wk_zipfinder_btn']")).click();
	     Thread.sleep(5000);
	     driver.findElement(By.xpath("//button[@id='product-add-to-cart']")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("(//a[text()='View Cart'])[2]")).click();
	     Thread.sleep(2000);
 
	     driver.findElement(By.id("agree")).click();
	     Thread.sleep(4000);
	     driver.findElement(By.xpath("//input[@id='checkout']")).click();
	     driver.close();
}
}