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

/* Activity 3:
Verify the title of the first info box
Goal: Read the title of the first info box on the website and verify the text
a. Open a browser.
b. Navigate to ‘ https://alchemy.hguy.co/lms ’.
c. Get the title of the first info box
d. Make sure it matches “Actionable Training” exactly.
e. If it matches, close the browser.
*/

public class Activity3 
{
	WebDriver driver;
	WebDriverWait wait;
	String PageTitle,FBoxTitle;
	WebElement FBox;
	
	@Test
public void f() 
	{
		//get page title
		PageTitle = driver.getTitle();
		System.out.println("Page Title is: " +PageTitle);
		
		//find first info box title
		FBox = driver.findElement(By.xpath("(//h3[@class='uagb-ifb-title'])[1]"));
		
		//wait until page loads
		wait.until(ExpectedConditions.visibilityOf(FBox));
		  
		//get the heading
		FBoxTitle=FBox.getText();
		System.out.println("Title of the first info box: " +FBoxTitle);
		  	
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
	  Assert.assertEquals(FBoxTitle,"Actionable Training");
	  System.out.println("Title of the first info box matches with Expected title");
	  
	  //close the browser	  
	  driver.close();
}

}
