import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]/input")).click();
		String selectedOption=(driver.findElement(By.cssSelector("label[for='benz']")).getText());
		WebElement dropdownExample=driver.findElement(By.id("dropdown-class-example"));
		Select dropdown=new Select(dropdownExample);
		dropdown.selectByContainsVisibleText(selectedOption);
		driver.findElement(By.id("name")).sendKeys(selectedOption);
		driver.findElement(By.id("alertbtn")).click();
		String Message=driver.switchTo().alert().getText();
		if(Message.contains(selectedOption)) {
			System.out.println(Message);
			
		}
		

	}

}
