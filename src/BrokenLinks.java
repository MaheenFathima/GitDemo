import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
	
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		WebElement link=driver.findElement(By.cssSelector("li[class='gf-li'] a[href*='broken']"));
//		String url=link.getDomAttribute("href");
//		HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
//		conn.setRequestMethod("HEAD");
//		conn.connect();
//		int response=conn.getResponseCode();
//		if(response>400) {
//			System.out.println("The link "+url+" is broken");
//			Assert.assertTrue(false);
//			
//		}
		SoftAssert a=new SoftAssert();
		List<WebElement> links=driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		for (WebElement link : links) {
			String url=link.getDomAttribute("href");
			//System.out.println(url);
			
			HttpURLConnection conn=(HttpURLConnection)new URI(url).toURL().openConnection();

			conn.setRequestMethod("HEAD");
			
	        conn.connect();
			int responseCode = conn.getResponseCode();
			if (responseCode > 400)
			{
				a.assertTrue(false);
			
				System.out.println(url + "is broken due to responseCode "+ responseCode);
			}
		}
		a.assertAll();
		driver.close();
	}

	

}
