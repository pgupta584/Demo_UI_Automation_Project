package ALL_Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import Test_Base.TestBase;

public class Add_User_Page extends TestBase
{
	WebDriver driver;
	public Add_User_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	//Dummy Page
	public void AddUserPage()
	{
		System.out.println("User Added Success");
	}

}
