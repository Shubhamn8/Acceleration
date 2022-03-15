package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void screenshot(WebDriver driver, String testID) throws IOException {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"); 
		TakesScreenshot g= (TakesScreenshot)driver;
		
		File source = g.getScreenshotAs(OutputType.FILE);
		
		File dest= new File("D:\\Software testing\\Automation Project\\ActiTime\\SS\\"+testID+" "+ dtf.format(LocalDateTime.now())+".jpg");
		
		FileHandler.copy(source, dest);

		
	}
	
	public static String getDataFromExcelSheet(String Sheet,int row,int cell ) throws EncryptedDocumentException, IOException {
        
		String path="D:\\Software testing\\Automation Project\\ActiTime\\Data.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		
        Sheet sheet1=WorkbookFactory.create(file).getSheet(Sheet);
    
        Row row1 = sheet1.getRow(row);
		
		Cell cell1=row1.getCell(cell);
		
		String data="";
		
		try {
			
	        data=cell1.getStringCellValue();
			
			System.out.print(data+"");
		}
		
		catch(Exception e) {
            double value =cell1.getNumericCellValue();
           
            data= value+"";
			
			System.out.print(data+"");
		}
		
		
		
		return data;
	}

}
