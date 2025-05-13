import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(2000);
		//driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		//driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		List<WebElement> options=driver.findElements(By.cssSelector(".ui-menu-item"));
		for(int i=0;i<options.size();i++) {
			if(options.get(i).getText().equalsIgnoreCase("India")) {
				Actions a=new Actions(driver);
				a.moveToElement(options.get(i)).click().build().perform();
				break;
			}
		}
		System.out.println(driver.findElement(By.id("autocomplete")).getText());

	}

}
