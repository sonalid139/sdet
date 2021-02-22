package SelenuimProject;

//import selenium packages
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import TestNG packages
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.Assert;

/* Activity 1:
Verify the website title
Goal: Read the title of the website and verify the text
a. Open a browser.
b. Navigate to ‘https://alchemy.hguy.co/lms’.
c. Get the title of the website.
d. Make sure it matches “Alchemy LMS – An LMS Application exactly.
e. If it matches, close the browser.
 */
public class Activity1 
{
	WebDriver driver;
	String PageTitle;
	
	@Test
	public void f() 
	{
		//get page title
		PageTitle = driver.getTitle();
		System.out.println("Page Title is: " +PageTitle);
	}
  
	@BeforeClass
  public void beforeClass() throws InterruptedException 
  {
	//open the browser
	driver = new FirefoxDriver();
	//Navigate to given URL
	String URL = "https://alchemy.hguy.co/lms";
	driver.get(URL);
	Thread.sleep(5000);
  }

  @AfterClass
  public void afterClass()
  {
	  //Make sure it matches “Alchemy LMS – An LMS Application exactly (actual,expected)
	  Assert.assertEquals(PageTitle,"Alchemy LMS – An LMS Application");
	  System.out.println("Page Tile matches with Expected title");
	  //close the browser
	  driver.close();
  }

}
