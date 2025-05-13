import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class WindowsScroll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scroll(0,250)");
		
		int count=driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[4]")).size();
		int sum=0;
		for(int i=0;i<count;i++) {
			String value=driver.findElements(By.xpath("//table[@id='product'] //td[4]")).get(i).getText();
			//CSS selector: table[id='product'] td:nth-child(4)
			sum=sum+ Integer.parseInt(value);
		}
		System.out.println(sum);
		int len=driver.findElement(By.className("totalAmount")).getText().length();
		int str= Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().substring(len-3,len));
		 
		Assert.assertEquals(str, sum);
		
	}

}
