package HelperClass;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class CommonMethods {

	
	//How to read excel files using Apache POI
			public void ReadExcel (String FileName) throws IOException{
	                        //I have placed an excel file 'Test.xlsx' in my D Driver 
				FileInputStream fis = new FileInputStream("\\cba\\src\\test\\resources\\Testdata\\Loan.xlsx");
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				XSSFSheet sheet = workbook.getSheetAt(0);
	                        //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
	                        //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
				Row row = sheet.getRow(0);
				Cell cell = row.getCell(0);
	                       	System.out.println(cell);
				System.out.println(sheet.getRow(0).getCell(0));
				//String cellval = cell.getStringCellValue();
				//System.out.println(cellval);
				
		}		
	}


  