package TestClasses;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
//import org.apache.commons.lang3.StringUtils;
import Utility.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import Pages.*;
import TestClasses.BaseClass;

//import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.codeborne.selenide.WebDriverRunner;
public class LoginTest {
	JSONReader jsonRead = new JSONReader();
	LoginPage loginPage = new LoginPage(driver);
	public static WebDriver driver  = null;
	@BeforeClass
	public void setup()
	{
		      driver = BaseClass.initilize();
	 }
	@Test
	public void test() throws FileNotFoundException, IOException, ParseException
	{
		WebDriverRunner.setWebDriver(driver);
		open(ConstantVariables.URl);
		loginPage.login(jsonRead.ReadJSONFile("username", "./Data/wsData.json"), jsonRead.ReadJSONFile("password", "./Data/wsData.json"));
		HomePage objHomePage = new HomePage(driver);
		Assert.assertTrue((objHomePage.getHomePageDashboardUserName().toLowerCase()).contains("manger id : mgr123"), "Logged in");
		close();
	}
	

}
