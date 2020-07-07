package superadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ArchiveLeadersOfClient {

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
			//Hit the client name with keyword "sky"
			driver.findElement(By.partialLinkText("sky")).click();
			int i =0;
			//Archive multiple leaders under this client one by one
			for( i=1; i<30; i++) {
				
				Thread.sleep(3000);		
				//Click on the right side dots
				driver.findElement(By.cssSelector("ul.navbar-nav li.nav-item a#navbarDropdownMenuLink .fa-ellipsis-h.pull-right")).click();
				//Hit the archive link on popup
				driver.findElement(By.linkText("Archive")).click();
				//click on confirmation box
				driver.findElement(By.cssSelector(".custom-ui button.btn-primary")).click();
				//Click on Invite link
				//driver.findElement(By.cssSelector(".dropdown-menu.dropdown-menu-right.show .dropdown-item")).click();
		    }	
			driver.quit();
		}
	}
