package Test_Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Utilities extends TestBase
{
	public static void getScreenShot()
	{
		
	}
	public static void waitFor(int seconds)
	{
		
	}
	public static void JavaScriptsClick(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	public static void ScrollIntoView(WebElement elemenet)
	{
		
	}

}
