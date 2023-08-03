package week4day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetRows {
	public static void main(String[] args) {
		ChromeDriver  driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://html.com/tags/table/");
		WebElement rows = driver.findElement(By.xpath("//div[@class='related-pages']"));
		List<WebElement> row = rows.findElements(By.cssSelector(" tr"));
		int size = row.size();
		System.out.println("Rowsize is  : "+size);
		
		List<WebElement> col= rows.findElements(By.cssSelector("td"));
		int size1 = row.size();
		System.out.println("Column size is  : "+size);

}
}