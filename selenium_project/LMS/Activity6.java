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

/* Activity 6:
Logging into the site
Goal: Open the website and log-in using the provided credentials.
a. Open a browser.
b. Navigate to ‘ https://alchemy.hguy.co/lms ’.
c. Find the navigation bar
d. Select the menu item that says “My Account” and click it.
e. Read the page title and verify that you are on the correct page.
f. Find the “Login” button on the page and click it.
g. Find the username field of the login form and enter the username=root into that field.
h. Find the password field of the login form and enter the password=pa$$w0rd into that field.
i. Find the login button and click it.
j. Verify that you have logged in.
k. Close the browser.
*/

public class Activity6 
{
	WebDriver driver;
	WebDriverWait wait;
	String PageTitle,MATitle;
	WebElement MenuMA,MAHead,Login,Logout;
	Boolean result;
	
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
		
		//Make sure heading matches “My Account – Alchemy LMS” exactly. (actual,expected)
		Assert.assertEquals(PageTitle,"My Account – Alchemy LMS");
		System.out.println("Page Title of My Account page matches with Expected title");
		  
		//get the heading on my account page
		MAHead = driver.findElement(By.xpath("(//h1)[1]"));
		//wait until page loads
		wait.until(ExpectedConditions.visibilityOf(MAHead));
		
		MATitle=MAHead.getText();
		System.out.println("Page Heading is: " +MATitle);
		//verify page heading
		Assert.assertEquals(MATitle, "My Account");
		System.out.println("Page heading of My Account matches with Expected heading");
		
		//find Login link
		Login=driver.findElement(By.xpath("//a[@href='#login']"));
		//click login
		Login.click();
		
		//enter username
		driver.findElement(By.id("user_login")).sendKeys("root");
		//enter password
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		//click login button
		driver.findElement(By.id("wp-submit")).click();
				
		//verify logout is displayed
		//wait until page loads
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Logout')]"))));
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
	//verify that logout is displayed
	result = driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).isDisplayed(); 
	if(result=true)
	{		
		System.out.println("User is successfully logged in, click Logout to logout from site");
	}
	//click logout
	driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	System.out.println("User is Logged out");
	
	//close the browser	  
	driver.close();
}

}
