import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKartExtended {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		String[] itemsNeeded = { "Brocolli-1Kg", "Cabbage-2Kg", "Tomato-3Kg" };
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		List<String> items=Arrays.asList(itemsNeeded);
		 for(int i=0;i<products.size();i++) {
			 //Brocolli - 1 Kg
			 String[] veggie=products.get(i).getText().split("-");
			 //Brocolli_    _1_Kg
			 String vegname=veggie[0].trim();
			 String test1="25";
			 int test=Integer.valueOf(test1);
			 System.out.println(test);
			 veggie[1].trim();
			 System.out.println((veggie[1].split(" "))[0]);
			 int quantity=Integer.parseInt((veggie[1].split(" "))[0]);
			//(veggie[1].split(" "))[0]);
			 if(items.contains(vegname)) {
				 
				 String vegrequired=items.get(i).split("-")[1];
				 int quantityrequired=vegrequired.charAt(0);
//				 AddVeggies(driver,vegname,quantity,vegrequired,quantityrequired);
				 int n=quantityrequired/quantity;
				 for(int j=0;j<n;j++) {
					 driver.findElements(By.className("increment")).get(i).click();
				 }
				 driver.findElements(By.xpath("//div[@class='product-action']/button[@type='button']")).get(i).click();
			 }
		 }
		 

	}

	
}
