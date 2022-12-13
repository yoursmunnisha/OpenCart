package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	
	public Logger logger;// for log file
	
	public ResourceBundle rb; //for config file
	
	@BeforeClass(groups= {"Master","Sanity","Regression"})
	@Parameters("browser") //specify browser from xml sheet
	public void setUp(String br) {
		rb=ResourceBundle.getBundle("config"); // Loan config.properties file
		
		logger = LogManager.getLogger(this.getClass());
		
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
        //Launch browser
		if(br.equals("chrome")) 
		{
			driver= new ChromeDriver(options);	
		} else if(br.equals("edge"))
		{
			driver= new EdgeDriver();
		} else
		{
			driver= new FirefoxDriver();
		}
		//delete all browser specified cookies
		driver.manage().deleteAllCookies();
		//wait time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//open url in browser
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups= {"Master","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	//to generate random Strings
	public String randomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
	
	//to generate random numbers
	public String randomNumber() {
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return (generatedNumber);
	}
	
	//to generate random alpha numerics (String+num)
	public String randomAlphaNumeric() {
		String str=RandomStringUtils.randomAlphabetic(4);
		String num=RandomStringUtils.randomNumeric(3);
		return(str+"@"+num);
		
	}
	
	//to capture Screenshots
	public String captureScreen(String tname) throws IOException {
		/*SimpleDateFormat df= new SimpleDateFormat("yyyymmddhhmmss");
		Date date= new Date();
		String timeStamp=df.format(date); */
		
		String timeStamp=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+ ".\\screenshots" + tname + "_" +timeStamp + ".png";
		
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch(Exception e) {
			e.getMessage();
		}
				
		return destination;		
	}

}
