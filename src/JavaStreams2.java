import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaStreams2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Pagination scenarios to search the data using streams
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<String> price;
		String[] items = { "Banana", "Apple" };
		List<String> itemsList = Arrays.asList(items);
		int result = itemsList.size();

		do {
			List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
			price = elements.stream().filter(s -> itemsList.contains(s.getText())).map(s -> getPrice(s))
					.collect(Collectors.toList());
			price.forEach(s -> System.out.println(s));
			if (price.size() != result) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (price.size() != result);

	}

	private static String getPrice(WebElement s) {
		String amount = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return amount;
	}

}
