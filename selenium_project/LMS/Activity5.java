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

/* Activity 5:
Goal: Navigate to the “My Account” page on the site.
a. Open a browser.
b. Navigate to ‘ https://alchemy.hguy.co/lms ’.
c. Find the navigation bar.
d. Select the menu item that says “My Account” and click it.
e. Read the page title and verify that you are on the correct page.
f. Close the browser.
*/

public class Activity5 
{
	WebDriver driver;
	WebDriverWait wait;
	String PageTitle,MATitle;
	WebElement MenuMA,MAHead;
	
	@Test
public void f() 
	{
		//get page title
		PageTitle = driver.getTitle();
		System.out.println("Page Title is: " +PageTitle);
		
		//Find the navigation bar,Select the menu item that says “My Account”
		MenuMA = driver.findElement(By.linkText("My Account"));
			
		//click My Account
		MenuMA.click();
		PageTitle = driver.getTitle();
		System.out.println("Page Title is: " +PageTitle);
		
		//get the heading on my account page
		MAHead = driver.findElement(By.xpath("(//h1)[1]"));
		//wait until page loads
		wait.until(ExpectedConditions.visibilityOf(MAHead));
		
		MATitle=MAHead.getText();
		System.out.println("Page Heading is: " +MATitle);
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
	  //Make sure heading matches “My Account – Alchemy LMS” exactly. (actual,expected)
	  Assert.assertEquals(PageTitle,"My Account – Alchemy LMS");
	  System.out.println("Page Title of My Account page matches with Expected title");
	  
	  //verify page heading
	  Assert.assertEquals(MATitle, "My Account");
	  System.out.println("Page heading of My Account matches with Expected heading");
	  
	  //close the browser	  
	  driver.close();
}

}
