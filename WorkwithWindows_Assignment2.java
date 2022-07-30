package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkwithWindows_Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Launch leafground window page
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		
		// maximize
		driver.manage().window().maximize();
		
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Click on the button to open home page		
		driver.findElement(By.id("home")).click();
		
		// switch to the new window
		Set<String> windowHandle = driver.getWindowHandles();
		
		List<String> listWindows = new ArrayList<String>(windowHandle);
		String firstPage = listWindows.get(0);
		String secondPage = listWindows.get(1);
		driver.switchTo().window(secondPage);
		
		System.out.println("The title of the new window is " + driver.getTitle());
		driver.close();
		
		driver.switchTo().window(firstPage);
		
		// Click on Open multiple windows button
		driver.findElement(By.xpath("//button[@Onclick='openWindows()']")).click();
		
		// FInd the number of open windows
		Set<String> windowHandle1 = driver.getWindowHandles();
		int size = windowHandle1.size();
		System.out.println("The number of open windows are "+size);
//		List<String> listWindows2 = new ArrayList<String>(windowHandle1);
//		for (int i = 1; i < windowHandle1.size(); i++) {
//			driver.switchTo().window(listWindows2.get(i));
//			driver.close();
//		}
		
		// Click on do not close me
		//driver.switchTo().window(firstPage);
		driver.findElement(By.id("color")).click();
		Set<String> windowHandle2 = driver.getWindowHandles();
		List<String> listWindows1 = new ArrayList<String>(windowHandle2);
		for (int i = 1; i < windowHandle2.size(); i++) {
			driver.switchTo().window(listWindows1.get(i));
			driver.close();
		}
		
		// Click on Wait for 5 seconds button
		driver.switchTo().window(firstPage);
		driver.findElement(By.xpath("//button[@Onclick='openWindowsWithWait();']")).click();
		Set<String> windowHandle3 = driver.getWindowHandles();
		List<String> listWindows3 = new ArrayList<String>(windowHandle3);
		for (int i = 1; i < windowHandle3.size(); i++) {
			String title = driver.switchTo().window(listWindows3.get(i)).getTitle();
			System.out.println(title);
		}		
		
		
	}

}
