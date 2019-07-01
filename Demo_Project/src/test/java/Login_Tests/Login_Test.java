package Login_Tests;

import java.io.IOException;

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
		//lp.loginPage("admin", "manager");
		//Get Data from Excel
		String user=ReadExcel_Data.getMapData("User");
		String pass=ReadExcel_Data.getMapData("Password");
		System.out.println("---------------------"+pass);
		lp.LoginToHome(user,pass);
	}
	@Test
	public void InvalidLoginToHomePage()
	{
		//lp=new Login_Page(driver);
		//lp.loginPage("admin", "manager1");
		System.out.println("invalid Login Succes Verification");
	}
}
