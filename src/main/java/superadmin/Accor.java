package superadmin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//This all is useless
public class Accor {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/rajani/Desktop/selenium-automation/chromedriver");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String csvOutputFile = "accordJobs4.csv";
		//check if file exist
        boolean isFileExist = new File(csvOutputFile).exists();
        
		int i =0;
		for( i=1; i<2; i++) {
			
			        
	            try {
	            	driver.get("https://jobs.accor.com/job-vacancy/all-of-our-job-vacancies,s,0.html");
	            	Thread.sleep(12000);
	            	js.executeScript("window.scrollBy(0,1000)");
	            	driver.findElement(By.id("ctl00_ContentPlaceHolder1_UCSearchResults2_rptOfferList_ctl0"+i+"_lnkOfferDetail1")).click();
	        		Thread.sleep(3000);
	                //create a FileWriter constructor to open a file in appending mode
	                CsvWriter testcases = new CsvWriter(new FileWriter(csvOutputFile, true), ',');
	                //write header column if the file did not already exist
	                if(!isFileExist)
	                {
	                    testcases.write("Skills");
	                    testcases.write("CONTRACT");
	                    testcases.write("CONTACT");
	                    
	                    testcases.write("KEY TASKS");
	                    
	                    //end the record
	                    testcases.endRecord();
	                }
	             //add record to the file
	                testcases.write(driver.findElement(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_dlSkills")).getText());
	                testcases.write(driver.findElement(By.className("tableTerms")).getText());
	                testcases.write(driver.findElement(By.className("contact")).getText());
	                testcases.write(driver.findElement(By.className("theMission")).getText());
	                
	                //end the record
	                testcases.endRecord();
	               // System.out.print("222");
	                //close the file
	                testcases.close();

	            } catch (IOException e) {
	                e.printStackTrace();
	            }
		}
	}


}
