import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SSLCheck {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions op=new ChromeOptions();
		op.setAcceptInsecureCerts(true);
		op.addArguments("--incognito");
		WebDriver driver=new ChromeDriver(op);
		
		driver.get("https://expired.badssl.com/");
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.id("signInBtn")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(Duration.ofSeconds(3000));
		driver.manage().deleteCookieNamed("rahulshettyacademy_session");
		
	}

}
