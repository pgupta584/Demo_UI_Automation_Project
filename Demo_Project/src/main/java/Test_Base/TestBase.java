package Test_Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import Data_Reader.ReadExcel_Data;

public class TestBase{
	public static WebDriver driver;
	public static Properties OR;
	public static Properties Project;
	public void init() throws IOException
	{
		InitializePropertiesFiles();
		ReadExcel_Data.setMapData();//Initialize the Excel file
	}
	@BeforeTest
	public void preCondition() throws IOException, InterruptedException
	{
		init();
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Project.getProperty("URL"));
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get(ReadConfig_File.getProperty_Data("URL"));
	}
	@AfterTest
	public void postConditoin()
	{
		driver.close();
	}

	public static void InitializePropertiesFiles() throws IOException 
	{//Initializing all the Properties file
			try {
				File Xpathfile=new File("src/main/java/Config_File/Project.properties");
				FileInputStream fis=new FileInputStream(Xpathfile);
				Project=new Properties();
				Project.load(fis);
				File ORfile=new File("src/main/java/Config_File/OR.properties");
				FileInputStream fis2=new FileInputStream(ORfile);
				OR=new Properties();
				OR.load(fis2);
				}
				catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
		}
	// enhance this function to handle multiple locators like xpath, css, name
	public static WebElement getWebelement(String method) {
		try{
		
		String[] methods = method.split("_");
		String strLocator = methods[methods.length - 1].toString();

		if (strLocator.contentEquals("xpath")) {
			return driver.findElement(By.xpath(OR.getProperty(method)));
		} else if (strLocator.contentEquals("css")) {
			return driver.findElement(By.cssSelector(OR.getProperty(method)));
		} else if (strLocator.contentEquals("id")) {
			return driver.findElement(By.id(OR.getProperty(method)));
		} else if (strLocator.contentEquals("name")) {
			return driver.findElement(By.name(OR.getProperty(method)));
		} else if (strLocator.contentEquals("linkText")) {
			return driver.findElement(By.linkText(OR.getProperty(method)));
		} else if (strLocator.contentEquals("partialLinkText")) {
			return driver.findElement(By.partialLinkText(OR.getProperty(method)));
		} else if (strLocator.toUpperCase().equals("TAGNAME")) {
			return driver.findElement(By.tagName(OR.getProperty(method)));
		} else if (strLocator.toUpperCase().equals("CLASSNAME")) {
			return driver.findElement(By.className(OR.getProperty(method)));
		} else {
			System.out.println("The specified locator not handled in framework");
			return null;
		}
	}
		catch(NoSuchElementException e)
		{
		System.out.println("Unable to find the element "+" " + method);
		return null;		
		}
	}
	//Getting SCreenShots
}
