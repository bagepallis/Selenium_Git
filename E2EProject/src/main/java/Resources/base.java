package Resources;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public static WebDriver driver; // create a global variable
	public Properties prop;
	private Date date = new Date();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
	
public WebDriver initializeDriver() throws IOException {
	
	
	prop = new Properties();
	FileInputStream fileStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/Resources/data.properties");
	prop.load(fileStream);
	
	//mvn test -Dbrowser=chrome ==> maven considers -D options as sys property  
	// sending parameters thru maven command
	String browserName = System.getProperty("browser");
	System.out.println(browserName);
	
	//String browserName = prop.getProperty("browser");
	
	if (browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/Resources/chromedriver");
		System.out.println(System.getProperty("user.dir"));
		//here chromeDriver class is implementing WebDriver Interface
		driver = new ChromeDriver();
			
	} else if (browserName.equals("firefox")) {
	
		System.setProperty("webdriver.gecko.driver","Write Path_of_Firefox_Driver"); // Setting system properties of FirefoxDriver
		driver = new FirefoxDriver(); //Creating an object of FirefoxDriver
	
	} else if (browserName.equals("IE")) {
		
		// Defining System Property for the IEDriver 
		System.setProperty("webdriver.ie.driver", "Write Path for IE Driver ServerIEDriverServer.exe"); 
		// Instantiate a IEDriver class. 
		driver=new InternetExplorerDriver();
	
	}
	
	// wait for 10 seconds for the page to load
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
    
	return driver;

}
	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    //copy this into a local file 
		//FileUtils.copyFile(src,new File("/Users/user1/Desktop/testScreenShots/"+ result+"screenshot.png"));
		FileUtils.copyFile(src,new File(System.getProperty("user.dir")+ "/test-output/screenshots/"+ result + "_"+ dateFormat.format(date) +"screenshot.png"));
		
	}

}
