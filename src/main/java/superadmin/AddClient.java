package superadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddClient {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/Users/rajani/Desktop/selenium-automation/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://execlaunchpadstaging.ithands.net/login");
		driver.findElement(By.name("email")).sendKeys("janet.rajani@ithands.net");
		driver.findElement(By.name("password")).sendKeys("Rubi@123");
		//Hit submit button on login page
		driver.findElement(By.className("btn-lg")).click();
		Thread.sleep(5000);
		//Hit the "Add new client" button
		driver.findElement(By.xpath("//*[@id=\"clientListHolder\"]/div[1]/div[2]/button")).click();
		Thread.sleep(3000);		
		//We will be redirected to add client form where we only have to add a unique client name
		for(char alphabet = 'a'; alphabet <='z'; alphabet++ )
		    {
				//Each time the value is set to blank
				String output = "";
		        output += alphabet;
		        //System.out.println(output);
		        //As client name should be unique, create a unique name for your client
		        driver.findElement(By.id("client_name")).sendKeys("Client "+output+output+output+" Janet");
		        //save client name
				driver.findElement(By.id("btnSubmit")).click();
				//open the menu to go back to the client list
				driver.findElement(By.linkText("CLIENTS")).click();
				//hit all clients hit all client under the menu link
				driver.findElement(By.linkText("All Clients")).click();
				//Again add a new client
				driver.findElement(By.xpath("//*[@id=\"clientListHolder\"]/div[1]/div[2]/button")).click();
				
		    }		
		driver.quit();

	}

}
