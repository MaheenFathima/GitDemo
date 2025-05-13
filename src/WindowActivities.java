import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com");

		driver.navigate().back();
		driver.navigate().forward();

		//Thread.sleep(1000);
		driver.close();
		

	}

}
