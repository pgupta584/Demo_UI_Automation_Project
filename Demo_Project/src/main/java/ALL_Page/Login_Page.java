package ALL_Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import Test_Base.TestBase;

public class Login_Page extends TestBase
{
	WebDriver driver;
	public Login_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void LoginToHome(String user,String Pass,String OTP)
	{
		getWebelement("Username_Text_id").sendKeys(user);
		Reporter.log("Enter User Name Steps completed");
		getWebelement("Next_Button_xpath").click();
		Reporter.log("Clicked on Next Button Steps completed");
		getWebelement("OTP_Text_id").sendKeys(OTP);
		Reporter.log("Enter OTP Steps completed");
		getWebelement("Login_Button_Verify_xpath").click();
		Reporter.log("Verify OTP Steps completed");
		getWebelement("Password_Text_id").sendKeys(Pass);
		Reporter.log("Enter Password Steps completed");
		getWebelement("Login_Button_xpath").click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	public static String getLoginPage()
	{
		String value=getWebelement("Home_PageText_xpath").getText();
		Reporter.log("Capture the Home Page Steps completed");
		return value;
	}
}
