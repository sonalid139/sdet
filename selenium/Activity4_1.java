package SeleniumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/* Activity 4_1
Create a Class and a main() method
Create a WebDriver instance, named driver, with the FirefoxDriver().
Open a browser with https://www.training-support.net
Get the title of the page using driver.getTitle() and print out the title.
Use findElement() with xpath() to find and click the "About Us" link on the page.
Print the title of the new page that open when the link is clicked
*/

public class Activity4_1 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
				
		//Open the browser & URL
		driver.get("https://www.training-support.net");
				
		//Find the page title and print it
		System.out.println("Page Title is: " +driver.getTitle());
		
		//Find the "Get Started!" link and click it
        driver.findElement(By.xpath("/html/body/div/div/div/a")).click();
 
        //Print title of new page
        System.out.println("Heading is: " + driver.getTitle());	
        Thread.sleep(5000);
        
        driver.navigate().back();
        
        Thread.sleep(5000);
        //close the browser
        driver.close();

	}

}
