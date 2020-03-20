package TestClasses ;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Utility.ConstantVariables;

public class BaseClass {
	  public static WebDriver driver  = null;
	  
	public static WebDriver initilize()
	   {

	      //Use Of Singleton Concept and Initilize webDriver
	      if(driver == null)
	      {
	         if(ConstantVariables.browserName.equalsIgnoreCase("chrome"))
	         {
	            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver76\\chromedriver.exe");
	             driver =new ChromeDriver();
	         }
	         else if(ConstantVariables.browserName.equalsIgnoreCase("Firefox"))
	         {
	            System.setProperty("webdriver.gecko.driver", "D:\\chrdrv\\geckodriver.exe");
	            driver=new FirefoxDriver();
	         }
	         else if(ConstantVariables.browserName.equalsIgnoreCase("IE"))
	         {
	            System.setProperty("webdriver.edge.driver", "D:\\chrdrv\\MicrosoftWebDriver.exe");
	            driver=new EdgeDriver();
	         }
	        
	      }
	      
	      //Perform Basic Operations
	      driver.manage().deleteAllCookies();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	      return driver;
	   }
	   public static void quit()
	   {
	      driver.quit();
	      driver=null; // we destroy the driver object after quit operation
	   }
	   public static void close()
	   {
	      driver.close();
	      driver=null;  // we destroy the driver object after quit operation
	   }   
	   public  static void openurl(String URL)
	   {
	      driver.get(URL);
	   }


}
