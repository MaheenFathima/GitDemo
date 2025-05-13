import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditbox=driver.findElement(By.cssSelector("[name='name']"));
		//System.out.println(driver.findElement(By.xpath("//input[@name='name']/preceding-sibling::label")).getText());
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditbox)).getText());
		
		
		WebElement DOB=driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(DOB)).click();
		
		System.out.println(driver.findElement(with(By.tagName("label")).below(nameEditbox)).getText());
		
		//driver.close();
		
	}

	

}
