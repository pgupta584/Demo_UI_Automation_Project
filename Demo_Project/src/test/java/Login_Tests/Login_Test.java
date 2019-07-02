package Login_Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import ALL_Page.Login_Page;
import Data_Reader.ReadExcel_Data;
import Test_Base.TestBase;

public class Login_Test extends TestBase
{
	Login_Page lp;
	@Test
	public void LoginToHomePage() throws IOException
	{
		lp=new Login_Page(driver);
		lp.LoginToHome("938837779", "Testing@123", "0000");
		//Get Data from Excel
		//String user=ReadExcel_Data.getMapData("User");
		String pass=ReadExcel_Data.getMapData("Password");
		System.out.println("---------------------"+pass);
		//lp.LoginToHome(user,pass);
		String expectedValue="Help & Support";
		Assert.assertEquals(Login_Page.getLoginPage(), expectedValue);
		Reporter.log("Login is Success");
	}
	@Test
	public void InvalidLoginToHomePage()
	{
		//lp=new Login_Page(driver);
		//lp.loginPage("admin", "manager1");
		System.out.println("invalid Login Succes Verification");
	}
}
