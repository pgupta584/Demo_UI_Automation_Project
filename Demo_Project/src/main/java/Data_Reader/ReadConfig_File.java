package Data_Reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig_File {
	public static String getProperty_Data(String key) throws IOException
	{
		File file=new File("src/main/java/Config/Project.properties");
		FileInputStream fis=new FileInputStream(file);
		Properties p=new Properties();//Creating object of properties to access method
		p.load(fis);//It will load all the data from config file to p object
		//After loading we can access the data
		String value=p.getProperty(key);
		return value;
	}
	public static void main(String[] args) throws IOException {
		ReadConfig_File.getProperty_Data("URL");
		System.out.println(ReadConfig_File.getProperty_Data("URL"));
	}
}
