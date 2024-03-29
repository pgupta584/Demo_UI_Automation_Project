package Data_Reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel_Data {
	public static Map<String,  Map<String, String>> setMapData() throws IOException {
		   String path = "TestData/Test_Data.xlsx";   
		   FileInputStream fis = new FileInputStream(path); 
		   Workbook workbook = new XSSFWorkbook(fis);
		   Sheet sheet = workbook.getSheetAt(0);  
		   //Sheet sheet = workbook.getSheetAt(1);//we can iterate sheet also   
		   int lastRow = sheet.getLastRowNum();

		   Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String,String>>();	   
		   Map<String, String> dataMap = new HashMap<String, String>();
		   //Looping over entire row
		   for(int i=0; i<=lastRow; i++){ 
		   Row row = sheet.getRow(i); //we can make it by using column 
		   //1st Cell as Value
		   Cell valueCell = row.getCell(1);
		   //0th Cell as Key
		   Cell keyCell = row.getCell(0);
		   String value = valueCell.getStringCellValue().trim();
		   String key = keyCell.getStringCellValue().trim();
		   //Putting key & value in dataMap
		   dataMap.put(key, value);	   
		   //Putting dataMap to excelFileMap
		   excelFileMap.put("TestData", dataMap);
		   }   
		 //Returning excelFileMap
		 return excelFileMap;
		 }

	// Method to retrieve value
	public static String getMapData(String key) throws IOException {
		Map<String, String> m = setMapData().get("TestData");
		String value = m.get(key);
		return value;
	}

	public static void main(String[] args) throws IOException {
		ReadExcel_Data r = new ReadExcel_Data();
		String val = r.getMapData("User");
		System.out.println("Value of the keyword (search) is- " + val);
	}
}
