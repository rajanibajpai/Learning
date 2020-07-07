package superadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class inviteUsers {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/rajani/Desktop/selenium-automation/chromedriver");
		WebDriver driver = new ChromeDriver();
		//Login
		driver.get("https://execlaunchpadstaging.ithands.net/login");
		driver.manage().window().fullscreen();
		driver.findElement(By.name("email")).sendKeys("janet.rajani@ithands.net");
		driver.findElement(By.name("password")).sendKeys("Rubi@123");
		//Hit submit button on login page
		driver.findElement(By.className("btn-lg")).click();
		//End Login
		
		Thread.sleep(3000);
		//Search client with a particular name
		driver.findElement(By.id("searchFld")).sendKeys("sky");
		driver.findElement(By.className("search-btn")).click();
		
		Thread.sleep(2000);		
		
		driver.findElement(By.partialLinkText("sky")).click();
		int i =0;
		for( i=1; i<20; i++) {
			
			Thread.sleep(3000);		
			driver.findElement(By.cssSelector("ul.col-12 li.dropdown .nav-link.dropdown-toggle")).click();
			driver.findElement(By.linkText("Not Yet Invited")).click();
			//Click on the right side dots
			driver.findElement(By.cssSelector("a.nav-link .fa-ellipsis-h")).click();
			//Click on Invite link
			driver.findElement(By.cssSelector(".dropdown-menu.dropdown-menu-right.show .dropdown-item")).click();
	    }	
		driver.quit();
	}
}
