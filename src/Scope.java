import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerDriver=driver.findElement(By.id("gf-BIG"));
		int footer_links=footerDriver.findElements(By.tagName("a")).size();
		System.out.println(footer_links);
		WebElement firstColumn=footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int count=firstColumn.findElements(By.tagName("a")).size();
		System.out.println(count);
		
		//Testing footer links navigation
		//Method-1
//		for(int i=1;i<count;i++) {
//			driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul")).findElements(By.tagName("a")).get(i).click();
//			//Thread.sleep(3000);
//			driver.navigate().back();
//		}
		
		//Method-2
		
		for(int j=1;j<count;j++) {
			String clickLink=Keys.chord(Keys.COMMAND,Keys.ENTER);
			firstColumn.findElements(By.tagName("a")).get(j).sendKeys(clickLink);
			Thread.sleep(2000);
		}
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
	}

}
