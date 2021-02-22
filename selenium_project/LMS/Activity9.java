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

/* Activity 9:
Complete a simple lesson
Goal: Navigate to a particular lesson and complete it.
a. Open a browser.
b. Navigate to ‘ https://alchemy.hguy.co/lms ’.
c. Find the navigation bar.
d. Select the menu item that says “All Courses” and click it.
e. Select any course and open it.
f. Click on a lesson in the course. Verify the title of the course.
g. Click the Mark Complete button on the page (if available).
h. Close the browser.
*/

public class Activity9 
{
	WebDriver driver;
	WebDriverWait wait;
	String PageTitle,ACTitle;
	
	@Test
public void f() 
	{
		//get page title
		PageTitle = driver.getTitle();
		System.out.println("Page Title is: " +PageTitle);
		
		//Find the navigation bar,Select the menu item that says “My Account”
		driver.findElement(By.linkText("My Account")).click();
		//get page title
		PageTitle = driver.getTitle();
		System.out.println("Page Title is: " +PageTitle);
		
		//find Login link & click login
		driver.findElement(By.xpath("//a[@href='#login']")).click();
		
		//enter username
		driver.findElement(By.id("user_login")).sendKeys("root");
		//enter password
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		//click login button
		driver.findElement(By.id("wp-submit")).click();
						
		//verify logout is displayed & wait until page loads
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Logout')]"))));
		
		//Find the navigation bar,Select the menu item that says “All Courses” & click All Courses
		driver.findElement(By.linkText("All Courses")).click();
			
		//wait until page loads
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
		//get the heading on All Courses page
		ACTitle = driver.findElement(By.xpath("//h1")).getText();
		System.out.println("Page Heading is: " +ACTitle);
		//verify page heading
		Assert.assertEquals(ACTitle, "All Courses");
		System.out.println("Page heading of All Courses matches with Expected heading");
		
		//click 3rd course see more link
		driver.findElement(By.xpath("(//a[contains(text(),'See more...')])[3]")).click();

		//click on 1st lesson in the selected course
		driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/lms/lessons/effective-writing-promoting-your-content/']")).click();
		PageTitle= driver.getTitle();
		System.out.println("Page Title is: " +PageTitle);
		Assert.assertEquals(PageTitle, "Effective Writing & Promoting Your Content – Alchemy LMS");
		
		List<WebElement> MarkComplete = driver.findElements(By.xpath("//input[@value='Mark Complete']"));
		int size = MarkComplete.size();
		System.out.println("Size is: " +size);
			
		if (size==0)
		{
			System.out.println("Mark Complete is not displayed, Lesson is already completed");
		}
		else
		{
			System.out.println("Mark Complete is displayed, so marking lesson as Completed");
			//click Mark Complete
			driver.findElement(By.xpath("(//input[@value='Mark Complete'])[2]")).click();
			System.out.println("Marked Lesson as Completed successfully");
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
