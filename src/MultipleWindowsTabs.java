import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsTabs {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 1.Open https://rahulshettyacademy.com/angularpractice/
		// 2.Open https://rahulshettyacademy.com/#/index in new tab or new window
		// 3. Get the first course name in 2nd link and paste in the name field of first
		// link
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://rahulshettyacademy.com/#/index");
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		String text = driver.findElement(By.xpath("(//a[contains(@href,'https://courses.rahulshettyacademy.com/p')])[2]"))
				.getText();
		System.out.println(text);
		driver.switchTo().window(parentId);
		WebElement element=driver.findElement(By.cssSelector("[name='name']"));
		element.sendKeys(text);
		//File src=((TakesScreenshot)element).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src, new File("output.png"));
		
		int h=element.getRect().getDimension().getHeight();
		int w=element.getRect().getDimension().getWidth();
		System.out.println(h+" "+w);
		driver.close();

	}

}
