package superadmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddLPtoMultipleLeader {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/rajani/Desktop/selenium-automation/chromedriver");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Login to theo super admin
		driver.get("https://execlaunchpadstaging.ithands.net/login");
		driver.manage().window().fullscreen();
		driver.findElement(By.name("email")).sendKeys("janet.rajani@ithands.net");
		driver.findElement(By.name("password")).sendKeys("Rubi@123");
		//Hit submit button on login page
		driver.findElement(By.className("btn-lg")).click();
		//End Login
		
		Thread.sleep(5000);
		//Search client name with a keyword
		driver.findElement(By.id("searchFld")).sendKeys("hymn");
		//hit the search icon
		driver.findElement(By.className("search-btn")).click();
		
		Thread.sleep(3000);		
		//hit the client name
		driver.findElement(By.xpath("//*[@id=\"clientListHolder\"]/div[2]/div[2]/ul/li[1]/a")).click();

		int i =0;
		for( i=0; i<53; i++) {
			Thread.sleep(3000);
			//hit existing leader
			WebElement Element = driver.findElements(By.className("text-capitalize")).get(i);
			//move the window to the element (leader name position)
			js.executeScript("arguments[0].scrollIntoView();",Element );
			Element.click();
			System.out.println("I am here"+i);
			Thread.sleep(3000);	
			//Hit add new launch plan button
			//add launch plan details
			driver.findElement(By.className("btn-primary")).click();

	        //add launch plan name
	        driver.findElement(By.name("plan_name")).sendKeys("Testing Pagination for launch plans by Janet "+i);
	        //scroll down on the page
	        js.executeScript("window.scrollBy(0,1000)");
	        //select module name
	        Select drpCountry = new Select(driver.findElement(By.name("launch_type")));
			drpCountry.selectByVisibleText("Alignment");
			Thread.sleep(1000);	
			//checkbox selection
			List<WebElement> moduleboxList = driver.findElements(By.name("module"));
			int moduleListCount = moduleboxList.size();
			
			int j =0;
			for( j=1; j<moduleListCount; j++) {
				Thread.sleep(2000);	
				moduleboxList.get(j).click(); 

					break;
			}
			
			Thread.sleep(2000);	
			//hit the launch plan save button
			driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div/form/div/div/div[5]/button")).click();
			//Go back to all leaders list
			driver.get("https://execlaunchpadstaging.ithands.net/leaders/26");
			
			Thread.sleep(2000);
			//go to page number 2 in pagination
			driver.findElement(By.xpath("//*[@id=\"leaderListHolder\"]/div[2]/div[1]/ul/li[4]/a")).click();
			//End pagination 
	    }	
		Thread.sleep(3000);	
		driver.quit();

	}

}
