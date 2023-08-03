package week4day2;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintLibraries {
	public static void main(String[] args) {
		ChromeDriver  driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://html.com/tags/table/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement render = driver.findElement(By.xpath("//div[@class='render']"));
		List<WebElement> market = render.findElements(By.xpath("//div[@class='render']//tbody/tr[1]"));
		for (int i = 0; i < market.size(); i++) {
			System.out.println(market.get(i).getText());
		}
		List<WebElement> absolute = render.findElements(By.xpath("//div[@class='render']//tbody/tr[2]"));
		for (int i = 0; i < absolute.size(); i++) {
			System.out.println(absolute .get(i).getText());
		}
	}
}
