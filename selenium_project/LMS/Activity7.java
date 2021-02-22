package SelenuimProject;

import java.util.List;

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

/* Activity 7:
Count the number of courses
Goal: Navigate to the “All Courses” page and count the number of courses.
a. Open a browser.
b. Navigate to ‘ https://alchemy.hguy.co/lms ’.
c. Find the navigation bar.
d. Select the menu item that says “All Courses” and click it.
e. Find all the courses on the page.
f. Print the number of courses on the page.
*/

public class Activity7 
{
	WebDriver driver;
	WebDriverWait wait;
	String PageTitle,ACTitle;
	WebElement AllCourses,ACHead;
		
	@Test
public void f() 
	{
		//get page title
		PageTitle = driver.getTitle();
		System.out.println("Page Title is: " +PageTitle);
		
		//Find the navigation bar,Select the menu item that says “All Courses”
		AllCourses = driver.findElement(By.linkText("All Courses"));
			
		//click All Courses
		AllCourses.click();
		PageTitle = driver.getTitle();
		System.out.println("Page Title is: " +PageTitle);
		
		//Make sure heading matches “All Courses – Alchemy LMS” exactly. (actual,expected)
		Assert.assertEquals(PageTitle,"All Courses – Alchemy LMS");
		System.out.println("Page Title of All Courses page matches with Expected title");
		  
		//get the heading on All Courses page
		ACHead = driver.findElement(By.xpath("//h1"));
		//wait until page loads
		wait.until(ExpectedConditions.visibilityOf(ACHead));
		
		ACTitle=ACHead.getText();
		System.out.println("Page Heading is: " +ACTitle);
		//verify page heading
		Assert.assertEquals(ACTitle, "All Courses");
		System.out.println("Page heading of All Courses matches with Expected heading");
		
		//Count number of courses
		List<WebElement> ListofCourses = driver.findElements(By.xpath("//h3[@class='entry-title']"));
		int count = ListofCourses.size();
		System.out.println("Number of courses are:" +count);
		System.out.println("Courses are:");
		for (int i=0;i<count;i++)
		{
			System.out.println(i+1 +". " +ListofCourses.get(i).getText());
		}
		
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
	//close the browser	  
	driver.close();
}

}
