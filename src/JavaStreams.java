import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaStreams {
	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub

		// Webtable Sorting using Java Stream
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originalList = elements.stream().map(s -> s.getText()).collect(Collectors.toList());
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));

		// Build Custom Selenium Methods using Java Streams
		//List<WebElement> elementsList = driver.findElements(By.xpath("tr/td[1]"));
		List<String> price=elements.stream().filter(s -> s.getText().contains("Apple")).map(s -> getPrice(s)).collect(Collectors.toList());
		price.forEach(s->System.out.println(s));

	}

	private static String getPrice(WebElement s) {
		// TODO Auto-generated method stub
		String amount=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return amount;
	}

}
