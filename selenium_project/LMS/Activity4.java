package SelenuimProject;

//import selenium packages
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import TestNG packages
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

/* Activity 4:
Goal: Read the title of the second most popular course on the website and verify the
text
a. Open a browser.
b. Navigate to ‘ https://alchemy.hguy.co/lms ’.
c. Get the title of the second most popular course.
d. Make sure it matches “Email Marketing Strategies” exactly.
e. If it matches, close the browser.
*/

public class Activity4 
{
	WebDriver driver;
	WebDriverWait wait;
	String PageTitle,SMPCTitle;
	WebElement SMPC;
	
	@Test
public void f() 
	{
		//get page title
		PageTitle = driver.getTitle();
		System.out.println("Page Title is: " +PageTitle);
		
		//find second most popular course title
		SMPC = driver.findElement(By.xpath("(//h3[@class='entry-title'])[2]"));
		//wait until page loads
		wait.until(ExpectedConditions.visibilityOf(SMPC));
		  
		//get the heading
		SMPCTitle=SMPC.getText();
		System.out.println("Title of second most popular course: " +SMPCTitle);
		  	
	}

	@BeforeClass
public void beforeClass() 
{
	//open the browser
	driver = new FirefoxDriver();
	//Navigate to given URL
	driver.get("https://alchemy.hguy.co/lms");
	wait = new WebDriverWait(driver,20);
}

@AfterClass
public void afterClass()

{
	  //Make sure heading matches “Learn from Industry Experts” exactly. (actual,expected)
	  Assert.assertEquals(SMPCTitle,"Email Marketing Strategies");
	  System.out.println("Title of the second most popular course matches with Expected title");
	  
	  //close the browser	  
	  driver.close();
}

}
