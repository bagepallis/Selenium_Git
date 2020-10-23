package CompleteIntegration;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import java.io.IOException;
import Resources.base;
import pageObjects.LandingPage;


public class ValidateNavigationBar extends base{
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
    public void initialize() throws IOException {
    	// no need to define driver, as it is defined in base class with public access 
    			driver = initializeDriver(); 
    			driver.get(prop.getProperty("url"));
    }
    
	@Test
	public void PageNavigation() throws IOException {
		
		//2 ways to access methods of other classes
		//1-use inheritance or
		//2-create an object for that class and invoke the methods of that class
		LandingPage landpage = new LandingPage(driver);
		Assert.assertTrue(landpage.getNavBar().isDisplayed());
		log.error("Navigation bar exists");
	}
	
	@AfterTest
	public void closewindow() {
		driver.close();
		driver=null;
	}
}
