import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		//System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
		driver.findElement(By.cssSelector("input[value='RoundTrip']")).click();
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("class"));
		System.out.println(driver.findElement(By.id("Div1")).getClass());
		if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
			
		driver.close();

	}

}
