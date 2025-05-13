import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//Implicit Wait 
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Explicit Wait
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		String[] itemsNeeded = { "Musk Melon", "Water Melon", "Pista" };
		Thread.sleep(3000);
		//GreenKart obj = new GreenKart();
		//obj.additems(driver,itemsNeeded);
		addItems(driver, itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='cart-preview active'] //button[@type='button']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		System.out.println(driver.findElement(By.className("promoInfo")).getText());

	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		List<String> veggiesRequired = Arrays.asList(itemsNeeded);
		int itemsAdded = 0;
		for (int i = 0; i < products.size(); i++) {
			String[] veggies = products.get(i).getText().split("-");
			String veggie = veggies[0].trim();
			if (veggiesRequired.contains(veggie)) {
				itemsAdded++;
				driver.findElements(By.xpath("//div[@class='product-action']/button[@type='button']")).get(i).click();
				if (itemsAdded == veggiesRequired.size()) {
					break;
				}
			}

		}
		
		
	}
}
