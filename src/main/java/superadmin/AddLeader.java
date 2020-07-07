package superadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddLeader {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/rajani/Desktop/selenium-automation/chromedriver");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Login
		driver.get("https://execlaunchpadstaging.ithands.net/login");
		driver.manage().window().fullscreen();
		driver.findElement(By.name("email")).sendKeys("janet.rajani@ithands.net");
		driver.findElement(By.name("password")).sendKeys("Rubi@123");
		//Hit submit button on login page
		driver.findElement(By.className("btn-lg")).click();
		//End Login
		
		Thread.sleep(5000);
		//Search client with a particular name
		driver.findElement(By.id("searchFld")).sendKeys("sky");
		driver.findElement(By.className("search-btn")).click();
		
		Thread.sleep(3000);		
		
		driver.findElement(By.xpath("//*[@id=\"clientListHolder\"]/div[2]/div[2]/ul/li[1]/a")).click();
		int i =51;
		for(char alphabet = 'a'; alphabet <='z'; alphabet++ )
	    {
			Thread.sleep(2000);
			String output = "";
	        output += alphabet;
			//Hit add new leader button
			driver.findElement(By.xpath("//*[@id=\"leaderListHolder\"]/div[1]/div[3]/button")).click();
			driver.findElement(By.name("title")).sendKeys("Dr.");
			driver.findElement(By.name("first_name")).sendKeys("Janet");
			js.executeScript("window.scrollBy(0,1000)");
			driver.findElement(By.name("last_name")).sendKeys(output+output+output);
			driver.findElement(By.name("suffix")).sendKeys("SQA");
			driver.findElement(By.name("job_title")).sendKeys("SQA");
			driver.findElement(By.name("email")).sendKeys("janet.rajani+"+i+"@ithands.net");
			
			Select userType = new Select(driver.findElement(By.name("user_type")));
			userType.selectByValue("3");
			Thread.sleep(1000);
			//Save leader details
			driver.findElement(By.xpath("//*[@id=\"leaderInfoHolder\"]/div[1]/div/form/div/div/div[9]/button")).click();
			//27 is the client ID based on this URL the system can directly go to leader list
			driver.get("https://execlaunchpadstaging.ithands.net/leaders/27");
			i++;
	    }
		driver.quit();
	}

}
