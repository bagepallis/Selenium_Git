package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LandingPage {
	
	public WebDriver driver;
	//create a constructor with parameter
	
	//every variable/method should have access modifier
	//private var/method are hidden from the child class that inherits it.
	// private var/method can only be accessed in this class
	//variables should be marked as private - as a good practice
	
	private By signIn = By.cssSelector("a[href*='sign_in']");
	private By title = By.cssSelector(".text-center>h2");
	private By navBar = By.xpath("//*[@id='homepage']/header/div[2]/div/nav/ul");
	
	public LandingPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver2;
	}


	public WebElement getLogin() {
		return driver.findElement(signIn);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}

}
