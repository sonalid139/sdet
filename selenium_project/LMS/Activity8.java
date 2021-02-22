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

/* Activity 8:
Contact the admin
Goal: Navigate to the “Contact Us” page and complete the form.
a. Open a browser.
b. Navigate to ‘ https://alchemy.hguy.co/lms ’.
c. Find the navigation bar.
d. Select the menu item that says “Contact” and click it.
e. Find the contact form fields (Full Name, email, etc.)
f. Fill in the information and leave a message.
g. Click submit.
h. Read and print the message displayed after submission.
i. Close the browser.
*/

public class Activity8 
{
	WebDriver driver;
	WebDriverWait wait;
	String PageTitle,CTitle,Message;
	WebElement MenuC;
	
	@Test
public void f()
	{
		//get page title
		PageTitle = driver.getTitle();
		System.out.println("Page Title is: " +PageTitle);
		
		//Find the navigation bar,Select the menu item that says “Contact”
		MenuC = driver.findElement(By.linkText("Contact"));
			
		//click Contact
		MenuC.click();
		PageTitle = driver.getTitle();
		System.out.println("Page Title is: " +PageTitle);
		
		//Make sure heading matches “Contact – Alchemy LMS” exactly. (actual,expected)
		Assert.assertEquals(PageTitle,"Contact – Alchemy LMS");
		System.out.println("Page Title of Contact page matches with Expected title");
		  
		//get the heading on Contact page
		//wait until page loads
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h1)[1]")));
						
		CTitle=driver.findElement(By.xpath("(//h1)[1]")).getText();
		System.out.println("Page Heading is: " +CTitle);
		//verify page heading
		Assert.assertEquals(CTitle, "Need Help?");
		System.out.println("Page heading of Contact matches with Expected heading");
				
		//enter fullname
		driver.findElement(By.xpath("//input[@id='wpforms-8-field_0']")).sendKeys("Abc");
				
		//enter email
		driver.findElement(By.xpath("//input[@id='wpforms-8-field_1']")).sendKeys("abc@xyz.com");
				
		//enter Subject
		driver.findElement(By.xpath("//input[@id='wpforms-8-field_3']")).sendKeys("Courses Information");
				
		//Enter message
		driver.findElement(By.xpath("//textarea[@id='wpforms-8-field_2']")).sendKeys("Need details about the courses that are held at your organization");
				
		//click Send Message button
		driver.findElement(By.xpath("//button[text()='Send Message']")).click();
						
		//verify message is displayed & wait until page loads
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='wpforms-confirmation-8']"))));
		Message = driver.findElement(By.xpath("//div[@id='wpforms-confirmation-8']")).getText();
		System.out.println("Confirmation message is: " +Message);
		
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
