import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		int rows=driver.findElements(By.cssSelector("table[name='courses'] tr")).size();
		int columns=driver.findElements(By.cssSelector("table[name='courses'] tr:nth-child(2) td")).size();
		System.out.println("Number of rows="+rows);
		System.out.println("Number of columns="+columns);
		for(int i=0;i<columns;i++) {
			System.out.println(driver.findElements(By.cssSelector("table[name='courses'] tr:nth-child(3) td")).get(i).getText());
		}
		

	}

}
