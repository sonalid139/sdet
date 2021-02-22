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

/* Activity 2:
Verify the website heading
Goal: Read the heading of the website and verify the text
a. Open a browser.
b. Navigate to ‘https://alchemy.hguy.co/lms’.
c. Get the heading of the webpage.
d. Make sure it matches “Learn from Industry Experts” exactly.
e. If it matches, close the browser.
 */

public class Activity2 
{
	WebDriver driver;
	WebDriverWait wait;
	String PageTitle,heading;
	WebElement PageHeading;
	
	@Test
  public void f() 
	{
		//get page title
		PageTitle = driver.getTitle();
		System.out.println("Page Title is: " +PageTitle);
		
		//find heading
		PageHeading = driver.findElement(By.xpath("//h1"));
	
		//wait until page loads
		 wait.until(ExpectedConditions.visibilityOf(PageHeading));
		 
		//get the heading
		heading=PageHeading.getText();
		System.out.println("Page heading is: " +heading);
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
	  //Make sure heading matches “Learn from Industry Experts” exactly  
	  Assert.assertEquals(heading,"Learn from Industry Experts");
	  System.out.println("Page heading matches with Expected heading");
	  
	  //close the browser	  
	  driver.close();
  }

}
