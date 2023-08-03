package week4day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Amazon {
				public static void main(String[] args) throws InterruptedException, IOException {
					 ChromeDriver  driver=new ChromeDriver();
				     driver.manage().window().maximize();
				     driver.get("https://www.amazon.in/");	
				     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					 driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(" oneplus 9 pro ");
					 driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
					 List<WebElement> price = driver.findElements(By.xpath("(//span[text()='45,999'])[1]"));
					 for (int i = 0; i < price.size(); i++) {
						String text=price.get(i).getText();
						System.out.println("Price           :"+text);	
					 }
					 List<WebElement> rating = driver.findElements(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]"));
					 for (int i = 0; i < rating.size(); i++) {
						String rate=rating.get(i).getText();	
						System.out.println("Rating          : "+rate);
					 }
					 Thread.sleep(3000);
					driver.findElement(By.xpath("(//a[@class='a-popover-trigger a-declarative'])[1]")).click();
					String percent = driver.findElement(By.xpath("(//span[@class='a-size-base'][1]/a)[2]")).getText();
					System.out.println("5 star percent  :"+percent);
					driver.findElement(By.xpath("(//div[@class='aok-relative']/span[@class='rush-component'])[1]")).click();
					Set<String> windowHandles = driver.getWindowHandles();
					List<String> image =new ArrayList<String>(windowHandles);
					driver.switchTo().window(image.get(1));
					WebElement snap = driver.findElement(By.xpath("//div[@class='wireless en_IN']"));
					File scrshot = driver.getScreenshotAs(OutputType.FILE);
					File output = new File("./snapshot/img.png");
					FileHandler.copy(scrshot, output);
					driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
					Thread.sleep(7000);
					String total = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
						System.out.println("Subtotal price  :"+total);
					driver.quit();
					}
					
					}
				
				

