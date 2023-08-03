package week4day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Myntra {
		public static void main(String[] args) throws InterruptedException, IOException {
			 ChromeDriver  driver=new ChromeDriver();
		     driver.manage().window().maximize();
		     driver.get("https://www.myntra.com/");
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		     WebElement men = driver.findElement(By.xpath("(//a[text()='Men'])[1]"));
		     Actions build=new Actions(driver);
		     build.moveToElement(men).perform();
		     driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
		     String count = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		     System.out.println("Total count    ="+count);
		     List<WebElement> total = driver.findElements(By.xpath("//div[contains(@class,'vertical-filters-filters categorie')]"));
		     List<String>size=new ArrayList<String>();
		     for (int i = 0; i <total.size(); i++) {
				size.add(total.get(i).getText());
				System.out.println("Category total  ="+size);
			}
		   driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[1]")).click(); 
		   driver.findElement(By.xpath("//div[@class='brand-more']")).click();  
		   driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");  
		   driver.findElement(By.xpath("(//label[@class=' common-customCheckbox']/div)[1]")).click();
		   driver.findElement(By.xpath("//span[contains(@class,'FilterDirectory-close sprites-remove')]")).click(); 
		   Thread.sleep(2000);
		   List<WebElement> coat = driver.findElements(By.xpath("//div[contains(@class,'search-searchProducts')]"));
		   List<String>cnfrm=new ArrayList<String>();
		   for (WebElement brand : coat) {
			String text=brand.getText();
			cnfrm.add(text);
		}
		  System.out.println(cnfrm);  
		  WebElement sort = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		  Actions sortby=new Actions(driver);
		  build.moveToElement(sort).perform();
		  String price = driver.findElement(By.xpath("(//span[contains(@class,'product-discountedPrice')])[1]")).getText();
	      System.out.println("Better Discount   :"+price);
		  driver.findElement(By.xpath("//h4[text()='Pocket Detail Bomber Jacket']")).click();
		  Set<String> product1 = driver.getWindowHandles();
		  List<String>first=new ArrayList<String>(product1);
	      driver.switchTo().window(first.get(1));
	      File scrshot = driver.getScreenshotAs(OutputType.FILE);
		  File output = new File("./snapshot/myntra.png");
		  FileHandler.copy(scrshot, output);
		  driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
	      driver.quit();

		  
		  
		  
		}

}
