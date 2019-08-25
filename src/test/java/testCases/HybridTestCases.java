package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import operations.AbsClass;
import operations.ReadObject;
import operations.UIOperation;

public class HybridTestCases extends AbsClass{
	@Test(dataProvider="HybridData")
	public void ApplicationUnderTest(String testcaseID, String testcaseName, String keyword, String objectName, String objectType, String data) throws Exception {
		ReadObject object=new ReadObject();
		Properties allObject=object.getObjectRepository();
		UIOperation operation=new UIOperation(driver);
		operation.KeyWordPerform(allObject, keyword, objectName, objectType, data);
	}
	@DataProvider(name="HybridData")
	public Object[][] getDataFromDataProvider() throws IOException{
		
		Object[][] obj=null;
		 File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Data","TestCase.xlsx");
		
		 FileInputStream fis=new FileInputStream(f);
		    
			Workbook wb =  new XSSFWorkbook(fis);
		    Sheet ws = wb.getSheet("Data3");
		    
		    int rowCount = ws.getLastRowNum()- ws.getFirstRowNum();
		    int ColCount=6;
		    obj = new Object[rowCount][ColCount];
		    for (int i = 0; i <rowCount; i++) {
		        
		        Row row = ws.getRow(i+1);
		        
		        for (int j = 0; j < row.getLastCellNum(); j++) {
		            
		            obj[i][j] = row.getCell(j).toString();
		        }
		   }
		    	
		    	return obj;    
	    }
		
	}
	
	


