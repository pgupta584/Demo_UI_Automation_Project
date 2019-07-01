package Login_Tests;

import org.testng.annotations.Test;

import ALL_Page.Add_User_Page;
import Test_Base.TestBase;

public class Add_User_Test extends TestBase
{
	Add_User_Page au=new Add_User_Page(driver);
	
	@Test
	public void Add_Business_User_Test()
	{
		au.AddUserPage();
	}

}
