package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows_SalesforceCustomerservice_Assignement3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Setup the chromedriver
		WebDriverManager.chromedriver().setup();
		
		//Launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		//Open Leaftaps
		driver.get("https://login.salesforce.com/");
		
		//Maximise the browser
		driver.manage().window().maximize();
		
		//implicitwait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Enter the username as " ramkumar.ramaiah@testleaf.com "
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		
		// Enter the password as " Password$123 "
		driver.findElement(By.id("password")).sendKeys("Password$123");
		
		// click on the login button
		driver.findElement(By.id("Login")).click();
		
		// click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("(//span[@dir='ltr'])[2]")).click();
		
		// Switch to the next window using Windowhandles
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> handles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(handles.get(1));
		
		// click on the confirm button in the redirecting page
		driver.findElement(By.xpath("//button[@onclick='goAhead()']")).click();
		
		// Get the title
		String title = driver.getTitle();
		System.out.println(title);
		
		
		// Get back to the parent window
		driver.switchTo().window(handles.get(0));
		
		// Close the browser
		driver.quit();
	}

	

}
