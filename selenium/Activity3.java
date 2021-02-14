package SeleniumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/* Activity 3 
Create a Class with a main() method.
Create a WebDriver instance, named driver, with the FirefoxDriver().
Open a browser with https://training-support.net/selenium/simple-form
Get the title of the page using driver.getTitle() and print out the title.
Use findElement() with name() to find the text fields - firstname and lastname.
Use WebElement.sendKeys() to type in those text fields.
Similarly, find and type into the email and contact number fields.
Finally, submit the form by clicking the Submit button.
Close the browser with driver.close()
When adding Thread.sleep(), make sure the main() function throws InterruptedException.
*/

public class Activity3 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		
		//Open the browser & URL
		driver.get("https://training-support.net/selenium/simple-form");
		
		//Find the page title and print it
		System.out.println("Page Title is: " +driver.getTitle());
		
		//Find the input fields
		WebElement fname = driver.findElement(By.id("firstName"));
		WebElement lname = driver.findElement(By.id("lastName"));
		WebElement email = driver.findElement(By.id("email"));
		//WebElement message = driver.findElement(By.xpath(//*[textarea]
				
		//print the placeholders displayed for each field
		System.out.println("Placeholders are: ");
		System.out.println(fname.getAttribute("placeholder"));
		System.out.println(lname.getAttribute("placeholder"));
		System.out.println(email.getAttribute("placeholder"));
		System.out.println(driver.findElement(By.id("number")).getAttribute("placeholder"));
				
		//enter data in fields
		fname.sendKeys("Test_FN1");
		lname.sendKeys("Test_LN1");
		email.sendKeys("Test1@xyz.com");
		driver.findElement(By.id("number")).sendKeys("1234567890");
		//Enter message
		driver.findElement(By.xpath("//textarea")).sendKeys("This is Test message");
		
		//click Submit
		driver.findElement(By.cssSelector(".ui.green.button")).click();
		
		//driver.findElement(By.xpath("//input[contains(@class, 'green')]")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
				
		System.out.println("Clicked Submit button");
		Thread.sleep(2000);

		//close the browser
        //driver.close();
	}
}
