package superadmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddMultipleLPOneLeader {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.gecko.driver","/Users/rajani/Desktop/selenium-automation/geckodriver");
		//WebDriver driver = new FirefoxDriver();
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
		//Search client with a keyword
		driver.findElement(By.id("searchFld")).sendKeys("sky");
		driver.findElement(By.className("search-btn")).click();
		
		Thread.sleep(3000);		
		
		driver.findElement(By.xpath("//*[@id=\"clientListHolder\"]/div[2]/div[2]/ul/li[1]/a")).click();
		
		//add new leader
		//driver.findElement(By.partialLinkText("Add New Leader")).click();
		
		for(char alphabet = 'a'; alphabet <='z'; alphabet++ )
	    {
			Thread.sleep(3000);
			System.out.println("I am in for loop");
			//hit existing leader
			driver.findElement(By.className("text-capitalize")).click();
			Thread.sleep(4000);	
			//Hit add new launch plan button
			//add launch plan details
			driver.findElement(By.className("btn-primary")).click();
			//Each time the value is set to blank
			String output = "";
	        output += alphabet;
	        //add launch plan name
	        driver.findElement(By.name("plan_name")).sendKeys("Testing Pagination for launch plans by Janet "+output);
	        //scroll down on the page
	        js.executeScript("window.scrollBy(0,1000)");
	        //select module name
	        Select drpCountry = new Select(driver.findElement(By.name("launch_type")));
			drpCountry.selectByVisibleText("Alignment");
			
			//checkbox selection
			List<WebElement> moduleboxList = driver.findElements(By.name("module"));
			int moduleListCount = moduleboxList.size();
			
			Thread.sleep(3000);	
			int i =0;
			for( i=1; i<moduleListCount; i++) {
				String moduleValue = moduleboxList.get(i).getAttribute("value");
				Thread.sleep(2000);	
				moduleboxList.get(i).click(); 

					break;
			}

			//End checkbox selection
			//select first module in checkbox list
			//driver.findElement(By.name("module")).click();
			//hit save button
			Thread.sleep(4000);	
			driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div/form/div/div/div[5]/button")).click();
			Thread.sleep(2000);	
			driver.navigate().back();
			
	    }	
		Thread.sleep(3000);	
		driver.quit();
	}

}
