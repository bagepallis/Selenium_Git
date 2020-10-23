package CompleteIntegration;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;


import Resources.base;
import pageObjects.LandingPage;
import pageObjects.loginPage;

public class HomePage extends base{
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
    public void initialize() throws IOException {
    	// no need to define driver, as it is defined in base class with public access 
    			driver = initializeDriver(); 
    			
    }
    
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String user, String passwd, String text) throws IOException {
		// no need to define driver, as it is defined in base class with public access 
		//driver = initializeDriver(); 
		
		/*get(url) step cannot be in initialize method as the test 
		* needs to run for more than one set of data defined in getData below
		* starting from the home page.
		*/
		driver.get(prop.getProperty("url"));
		
		//2 ways to access methods of other classes
		//1-use inheritance or
		//2-create an object for that class and invoke the methods of that class
		LandingPage landpage = new LandingPage(driver);
		landpage.getLogin().click();
		loginPage logpage = new loginPage(driver);
		logpage.getEmail().sendKeys(user);
		logpage.getPassword().sendKeys(passwd);
		log.info(text);
		logpage.getLogin().click();
		
	}
	
	@DataProvider
	public Object[][] getData() {
		//row stands for how many diff data types 
		//column stands for how many values for each test
		Object[][] data = new Object[3][3];
		//array size should be the number of rows and columns in the array
		//0th row
		data[0][0] = "test@test.com";
		data[0][1] = "test123";
		data[0][2] = "non-restricted user";
		//1st row
		data[1][0] = "testrestrict@test.com";
		data[1][1] = "test123";
		data[1][2] = "restricted user";
		//1st row
		data[2][0] = "testrestrictnew@test.com";
		data[2][1] = "test123";
		data[2][2] = "restricted1 user";
		
		return data;
	}
	
 @AfterTest
	public void closewindow() {
		driver.close();
		driver=null; //set the driver to null to save the memory
	}
	
	
}
