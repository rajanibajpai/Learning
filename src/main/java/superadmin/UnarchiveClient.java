package superadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UnarchiveClient {

	public static void main(String[] args) throws InterruptedException {
		//Unarchive all the clients from the list
				System.setProperty("webdriver.chrome.driver","/Users/rajani/Desktop/selenium-automation/chromedriver");
				WebDriver driver = new ChromeDriver();
				driver.get("https://execlaunchpadstaging.ithands.net/login");
				driver.findElement(By.name("email")).sendKeys("janet.rajani@ithands.net");
				driver.findElement(By.name("password")).sendKeys("Rubi@123");
				//Hit submit button on login page
				driver.findElement(By.className("btn-lg")).click();
				Thread.sleep(4000);
				//Hit the "CLIENTS" menu item
				driver.findElement(By.linkText("CLIENTS")).click();
				//Hit the "Archived clients" menu link
				driver.findElement(By.partialLinkText("Archived Clients")).click();
				Thread.sleep(2000);
				
				//Unarchive i no of  clients
				for(int i = 1; i <=50; i++ )
			    {		//Hit dot icons	    
					driver.findElement(By.xpath("//*[@id=\"navbarDropdownMenuLink\"]/i")).click();
					Thread.sleep(2000);
					driver.findElement(By.linkText("Unarchive")).click();
					//hit the unarchive button in popup
					driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/button[1]")).click();
					System.out.println(i);
					Thread.sleep(3000);
			    }
				Thread.sleep(3000);	
				driver.quit();

	}

}
