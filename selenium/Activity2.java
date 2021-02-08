package SeleniumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
		String pageTitle = driver.getTitle();
		System.out.println("Page Title is: " +pageTitle);
		
		//Find the About Us link using id()
		WebElement idLocator = driver.findElement(By.id("about-link"));
		System.out.println("Text in WebElement is: " + idLocator.getText());
		
		//Find the About Us link using className()
        WebElement classNameLocator = driver.findElement(By.className("green"));
        System.out.println("Text in WebElement: " + classNameLocator.getText());
        
        //Find the About Us link using cssSelector()
        WebElement cssLocator = driver.findElement(By.cssSelector(".green"));
        System.out.println("Text in WebElement: " + cssLocator.getText());
        
        //Find the About Us link using linkText()
        WebElement linkTextLocator = driver.findElement(By.linkText("About Us"));
        System.out.println("Text in WebElement: " + linkTextLocator.getText());
		
        driver.close();
	}

}
