import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class SeleniumIntro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WebDriver driver=new ChromeDriver();
		//driver.get("https://rahulshettyacademy.com/ ");
		
		String[] str = {"Maheen","Fathima"};
		String str2= str.toString();
		
	    for(String s:str)
	    {
	    	System.out.println(str);
	    }
	    {
	    	System.out.println(str);
	    }
	    
		//SeleniumIntro.getData(str);
		
		
		

	}
	
	public  static void getData(String[] str) {
		// TODO Auto-generated method stub
		
		String str2= str.toString();
		System.out.println(str2);
		 getData1();
		
	}
	
	 public  static void getData1() {
			// TODO Auto-generated method stub
			 System.out.println("Hello Jaanu");
			
		}
	 public SeleniumIntro()
	 {
		 System.out.println("Hello Jaanu");
	 }
}
