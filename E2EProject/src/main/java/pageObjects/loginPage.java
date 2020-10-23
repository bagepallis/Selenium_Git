package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	public WebDriver driver;
	//create a constructor with parameter
	
	
	By emailAddress = By.id("user_email");
	By password = By.cssSelector("input[id='user_password']");
	By submit = By.cssSelector("input[name='commit']");
	
	public loginPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver2;
	}


	public WebElement getEmail() {
		return driver.findElement(emailAddress);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLogin() {
		return driver.findElement(submit);
	}
}
