package superadmin;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddLPSponsor {

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
		
		Thread.sleep(4000);
		
			int i =0;
			for( i=214; i<252; i++) {
				driver.get("https://execlaunchpadstaging.ithands.net/editlaunchplan/"+i+"/1");
				
				driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/section[2]/div/div[1]/button")).click();
				Thread.sleep(2000);
				//Select sponsor name from the drop-down
				Select sponsorName = new Select(driver.findElement(By.name("facilitators")));
				sponsorName.selectByValue("97");
				Thread.sleep(2000);
				//Hit the add button on popup
				driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div[2]/button[1]")).click();
				Thread.sleep(2000);
								
			}
		
		driver.quit();
	}
}
