import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class CalendarDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		String year="2026";
		String month="8";
		String date="29";
		String[] expectedDate= {month,date,year};
		driver.findElement(By.cssSelector(".react-date-picker__calendar-button.react-date-picker__button")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText--from")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.tagName("abbr")).get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		List<WebElement> selectedDate=driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int i=0;i<3;i++) {
			System.out.println(selectedDate.get(i).getDomAttribute("value"));
			Assert.assertEquals(selectedDate.get(i).getDomAttribute("value"), expectedDate[i]);
			
		}
		
		
		
		
		
		
//		List<WebElement> yearsCal=driver.findElements(By.cssSelector(".react-calendar__decade-view__years button"));
//		for(int i=0;i<10;i++) {
//			String currentyear=yearsCal.get(i).getText();
//			if(currentyear.equalsIgnoreCase(year)) {
//				yearsCal.get(i).click();
//				break;
//			}
//		}
//		Thread.sleep(2000);
//		WebElement monthsCal=driver.findElement(By.xpath("//div[@class='react-calendar__year-view__months']"));
//		for(int j=0;j<12;j++) {
//			if(monthsCal.findElements(By.xpath("button/abbr")).get(j).getText().equalsIgnoreCase(month)) {
//				monthsCal.findElements(By.xpath("button")).get(j).click();
//				break;
//			}
//		}
//		monthsCal.findElement(By.xpath("button[monthNumber]")).click();
//		Thread.sleep(2000);
//		List<WebElement> daysCal=driver.findElements(By.cssSelector(".react-calendar__month-view__days button"));
//		for(int k=0;k<31;k++) {
//			if(daysCal.get(k).getText().equalsIgnoreCase(date)) {
//				daysCal.get(k).click();
//				break;
//			}
//		}
//		String result=driver.findElement(By.xpath("//input[@name='date']")).getDomAttribute("value");
//		System.out.println(result);
		

	}

}
