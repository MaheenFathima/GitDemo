import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Using Incognito mode to avoid Chrome password popup
		ChromeOptions choptions = new ChromeOptions();
		choptions.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(choptions);
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']/following-sibling::span")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn-success")));
		driver.findElement(By.className("btn-success")).click();
		WebElement option = driver.findElement(By.cssSelector("select[class=\"form-control\"]"));
		Select options = new Select(option);
		options.selectByValue("consult");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		AddItems(driver, w);
		driver.findElement(By.className("btn-primary")).click();

	}

	public static void AddItems(WebDriver driver, WebDriverWait w) throws InterruptedException {
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("card")));
		List<WebElement> items = driver.findElements(By.className("card"));
		for (int i = 0; i < items.size(); i++) {

			driver.findElements(By.className("btn-info")).get(i).click();
		}

	}

}
