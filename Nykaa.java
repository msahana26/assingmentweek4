package week4day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Nykaa {
			public static void main(String[] args) throws Throwable {
			ChromeDriver  driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.nykaa.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebElement bnd=driver.findElement(By.xpath("//a[text()='brands']"))	;
			Actions build =new Actions(driver) ;	
			build.moveToElement(bnd) .perform();
			driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
			driver.findElement(By.linkText("L'Oreal Paris")).click();
			driver.findElement(By.xpath("//div[@class='css-ar51ef']")).click();
			driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
			driver.findElement(By.xpath("//span[text()='Category']")).click();
			driver.findElement(By.xpath("//span[text()='Hair']")).click();
			driver.findElement(By.xpath("(//div[@class=' css-1nozswx'])[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='control-box css-9rrbqm'])[1]")).click();
			driver.findElement(By.xpath("//div[contains(@class,'filter-open css')]/span[text()='Concern']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
			driver.findElement(By.xpath("//div[@class='css-1rd7vky']")).click();
			 Set<String> windowHandles = driver.getWindowHandles();
			 List<String>list=new ArrayList<String>(windowHandles);
		      driver.switchTo().window(list.get(1));
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[text()='180ml']")).click();
			String mrp = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]")).getText();
			System.out.println("MRP             :"+mrp);
			driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
			driver.findElement(By.xpath("//button[@class='css-aesrxy']")).click();
			WebElement myframe = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
			driver.switchTo().frame(myframe);
			String grandtotal = driver.findElement(By.xpath("//span[@class='css-1um1mkq e171rb9k3']")).getText();
			System.out.println("Grand price     :"+grandtotal);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='css-15vhhhd e25lf6d4']")).click();
			driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
			driver.findElement(By.xpath("//div[@class='css-gecnnw eqr1d9n12']")).click();
			driver.findElement(By.xpath("(//span[@class='css-1b232xc ehes2bo3'])[2]")).click();
			String total = driver.findElement(By.xpath("(//p[@class='css-masf0q eka6zu20'])[2]")).getText();
			System.out.println("Total price      :"+total);
			if(grandtotal.equals(total)) {
				System.out.println("price are same");
				
			}
			else {
				System.out.println("price are not same");
			}
			
			driver.quit();
			}
			
}
