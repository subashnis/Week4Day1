package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows_Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//  1. Launch URL "http://leaftaps.com/opentaps/control/login"
		//Setup the chromedriver
		WebDriverManager.chromedriver().setup();
		
		//Launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		//Open Leaftaps
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//Maximise the browser
		driver.manage().window().maximize();
		
		//implicitwait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		// Click on Contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		
		// Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		// Click on Widget of From Contact
		driver.findElement(By.xpath("//span[@class='requiredField']/following::input/following::img")).click();
		
		// Switch to the new window
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		
		List<String> listWindows = new ArrayList<String>(windowHandles);
		String firstWindow = listWindows.get(0);
		String secondWindow = listWindows.get(1);
		System.out.println(secondWindow);
		
		driver.switchTo().window(secondWindow);
		
		// Click on First Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
		// switch to first window
		driver.switchTo().window(firstWindow);
		
		// Click on Widget of To Contact
		driver.findElement(By.xpath("//input[@id='ComboBox_partyIdTo']/following::img")).click();
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		System.out.println(windowHandles1.size());
		
	    List<String> listWindows1 = new ArrayList<String>(windowHandles1);
		String firstWindow1 = listWindows1.get(0);
		String thirdWindow = listWindows1.get(1);
		
		// switch to second window
		driver.switchTo().window(thirdWindow);
		
		// Click on Second Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		
		// switch to first window
		driver.switchTo().window(firstWindow1);
		
		// Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		// Accept the Alert
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		
		// Verify the title of the page
		System.out.println(driver.getTitle());
		
		
		
		
	
	}

}
