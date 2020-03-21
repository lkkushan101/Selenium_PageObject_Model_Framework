package TestClasses;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

import Pages.HomePage;
import Pages.LoginPage;
import TestClasses.BaseClass;
import Utility.ConstantVariables;
import Utility.ExcelRead;

public class LoginTest {
	WebDriver driver;
	@BeforeClass
	public void setup()
	{
		      driver = BaseClass.initilize();
	 }
	
	@Test
	public void testLogin() throws IOException {
		
		BaseClass.openurl(ConstantVariables.URl);

	    LoginPage objLogin;

	    HomePage objHomePage;
	    ExcelRead excel = new ExcelRead();
	  

        driver.get(excel.readExcel(1,0, ".\\Data\\data.xlsx","Sheet1"));
          
	    objLogin = new LoginPage(driver);

	    objLogin.loginToGuru99(excel.readExcel(1,1, ".\\Data\\data.xlsx","Sheet1"), excel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1"));
	 
	    
	    driver.close();
	}
   }