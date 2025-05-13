import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] num= {1,2,3,5,5};
		Integer[] num3= {2,2,4,6,5};
		ArrayList<Integer> numbers=new ArrayList<>(Arrays.asList(num));
		Collections.addAll(numbers,num);
		
		ArrayList<Integer> numbers1=new ArrayList<>(Arrays.asList(num3));
		
		
		List<Integer> numbers2= numbers.stream().distinct().collect(Collectors.toList());
		System.out.println(numbers2);
		
		 numbers1.stream().distinct().map(s->(s/2)).collect(Collectors.toList()).forEach(s1->System.out.print(s1+"\s"));
		
				
		
		
		
		
		
		
		

	}

}
