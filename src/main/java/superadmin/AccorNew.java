package superadmin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.csvreader.CsvWriter;

public class AccorNew {

		public static void main(String[] args) throws IOException, InterruptedException {
			System.setProperty("webdriver.chrome.driver","/Users/rajani/Desktop/selenium-automation/chromedriver");
			WebDriver driver = new ChromeDriver();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			String csvOutputFile = "accordJobs4.csv";
			//check if file exist
	        boolean isFileExist = new File(csvOutputFile).exists();
	        
			int i =0;
			DecimalFormat twodigits = new DecimalFormat("00");
		    //System.out.println(twodigits.format(i));
			for( i=1; i<=2; i++) {
				        
		            try {
		            	driver.get("https://jobs.accor.com/job-vacancy/all-of-our-job-vacancies,s,0.html");
		            	Thread.sleep(6000);
		            	
		            	//Select sponsorName = new Select(driver.findElement(By.name("ctl00$ContentPlaceHolder1$UCSearchResults2$ddNumOfferByPage")));
						//sponsorName.selectByValue("100");
						
						//Thread.sleep(12000);
		            	//js.executeScript("window.scrollBy(0,1000)");
		            	
		            	//click on page 2 of pagination
		            	//driver.findElement(By.id("ctl00_ContentPlaceHolder1_UCSearchResults2_PaginationBar1_lnkGoToPage3")).click();
		            	
						//Thread.sleep(10000);
						
		            	driver.findElement(By.id("ctl00_ContentPlaceHolder1_UCSearchResults2_rptOfferList_ctl"+twodigits.format(i)+"_lnkOfferDetail1")).click();
		            	Thread.sleep(3000);
		                //create a FileWriter constructor to open a file in appending mode
		                CsvWriter testcases = new CsvWriter(new FileWriter(csvOutputFile, true), ',');
		                //write header column if the file did not already exist
		                if(!isFileExist)
		                {
		                	testcases.write("Record for");
		                	testcases.write("Hotel or Entity");
		                    testcases.write("Level of Education");
		                    testcases.write("Areas of study");
		                    testcases.write("Professional experiences");
		                    testcases.write("Languages essential");
		                    testcases.write("Optional languages");
		                    testcases.write("Job Level");
		                    testcases.write("Fixed-term contract");
		                    testcases.write("Duration of fixed-term contract (in months)");
		                    testcases.write("Status");
		                    testcases.write("Anticipated Start Date");
		                    testcases.write("Contact");
		                    testcases.write("Key Tasks");
		                    testcases.write("Essential and Optional");

		                    //end the record
		                    testcases.endRecord();
		                }
		               
		                if( driver.findElements(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbExactJobTitle")).size() > 0)
		                	testcases.write(driver.findElement(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbExactJobTitle")).getText());
		                else
		                	testcases.write("-");
		                
		                if( driver.findElements(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbEstablishment")).size() > 0)
		                	testcases.write(driver.findElement(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbEstablishment")).getText());
		                else
		                	testcases.write("-");
		                	
		                if( driver.findElements(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbEducationLevel")).size() > 0)
		                	testcases.write(driver.findElement(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbEducationLevel")).getText());
		                else
		                	testcases.write("-");
		                	
		                if( driver.findElements(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbStudyArea")).size() > 0)
		                	testcases.write(driver.findElement(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbStudyArea")).getText());
		                else
		                	testcases.write("-");
		                	
		                if( driver.findElements(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbExperienceLevel")).size() > 0)
		                	testcases.write(driver.findElement(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbExperienceLevel")).getText());
		                else
		                	testcases.write("-");
		                	
		                if( driver.findElements(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbLanguagesRequired")).size() > 0)
		                	testcases.write(driver.findElement(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbLanguagesRequired")).getText());
		                else
		                	testcases.write("-");
		                	
		                if( driver.findElements(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbLanguagesHoped")).size() > 0)
		                	testcases.write(driver.findElement(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbLanguagesHoped")).getText());
		                else
		                	testcases.write("-");
		                	
		                if( driver.findElements(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbContractType")).size() > 0)
		                	testcases.write(driver.findElement(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbContractType")).getText());
		                else
		                	testcases.write("-");
		                	
		                if( driver.findElements(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_litCDD")).size() > 0)
		                	testcases.write(driver.findElement(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_litCDD")).getText());
		                else
		                	testcases.write("-");
		                	
		                if( driver.findElements(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbDuration")).size() > 0)
		                	testcases.write(driver.findElement(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbDuration")).getText());
		                else
		                	testcases.write("-");
		                	
		                if( driver.findElements(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbJobType")).size() > 0)
		                	testcases.write(driver.findElement(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbJobType")).getText());
		                else
		                	testcases.write("-");
		                	
		                if( driver.findElements(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbDateStart")).size() > 0)
		                	testcases.write(driver.findElement(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_lbDateStart")).getText());
		                else
		                	testcases.write("-");
		                
		                if( driver.findElements(By.className("contact")).size() > 0)
		                	testcases.write(driver.findElement(By.className("contact")).getText());
		                else
		                	testcases.write("-");
		                			                	
		                if( driver.findElements(By.className("theMission")).size() > 0)
		                	testcases.write(driver.findElement(By.className("theMission")).getText());
		                else
		                	testcases.write("-");
		                	
		                if( driver.findElements(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_divMandatorySkills")).size() > 0)
		                	testcases.write(driver.findElement(By.id("ctl00_ContentPlaceHolder1_UCOfferDetail_divMandatorySkills")).getText());
		                else
		                	testcases.write("-");
		                
		                testcases.endRecord();
		                //close the file
		                testcases.close();

		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		            
		            
			}
		}

	}
