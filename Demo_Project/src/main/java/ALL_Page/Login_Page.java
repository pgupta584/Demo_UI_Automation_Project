package ALL_Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Test_Base.TestBase;

public class Login_Page extends TestBase
{
	WebDriver driver;
	public Login_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void LoginToHome(String user,String Pass)
	{
		getWebelement("Username_Text_id").sendKeys(user);
		getWebelement("Password_Text_id").sendKeys(Pass);
		getWebelement("Login_Button_xpath").click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
}
