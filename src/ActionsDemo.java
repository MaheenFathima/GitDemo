import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// ChromeOptions chOptions=new ChromeOptions();
		// chOptions.addArguments("--incognito");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.className("gh-my-ebay"))).contextClick().build().perform();
		WebElement search=driver.findElement(By.id("gh-ac"));
		actions.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("Hello").build().perform();
		
	}

}
