package week4day2;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class chittorgarh1 {
		public static void main(String[] args) {
			ChromeDriver  driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.chittorgarh.com/");	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.findElement(By.id("navbtn_stockmarket")).click();
			driver.findElement(By.linkText("NSE Bulk Deals")).click();
			List <WebElement> table= driver.findElements(By.xpath("//table[contains(@class,'table table-bordered table-')]//td/a"));
			List<String>table1=new ArrayList<String>();
			for (int i = 0; i < table.size(); i++) {
				table1.add(table.get(i).getText());
			}
			System.out.println(table1);
			Set<String>set= new LinkedHashSet<String>(table1);
			if(set==table1)
			{
			System.out.println("no duplicates name");
			}
			else {
				System.out.println("duplicates name ");
			}
			
		}
}
