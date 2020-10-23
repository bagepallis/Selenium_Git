package CompleteIntegration;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import Resources.base;
import pageObjects.LandingPage;


public class ValidateTitle extends base{
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
    public void initialize() throws IOException {
    	// no need to define driver, as it is defined in base class with public access 
    			driver = initializeDriver(); 
    			log.info("driver is initialized");
    			
    			driver.get(prop.getProperty("url"));
                log.info("navigating to the website");
	}
    
	@Test
	public void PageTitle() throws IOException {
		
		//2 ways to access methods of other classes
		//1-use inheritance or
		//2-create an object for that class and invoke the methods of that class
		LandingPage landpage = new LandingPage(driver);
		//compare text from browser, if not script should fail
		Assert.assertEquals(landpage.getTitle().getText(), "FEATURED COURSES777");
		log.info("Validated the title");
		
		
	}
	
	@AfterTest
	public void closewindow() {
		driver.close();
		driver=null; //helps save memory and not keep the object alive when other tests are running
	}
	
}
