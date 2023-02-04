package utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadMyExcel {

	@DataProvider (name = "product")
	public static String[][] productdata() throws IOException {

		String File = "C:\\Users\\Arunachalam\\git\\Myproject\\decthlon\\src\\test\\resources\\testdata\\search.xlsx";

		XSSFWorkbook wbook = new XSSFWorkbook(File);
		XSSFSheet sheet = wbook.getSheetAt(0);
		
		int lastrow = sheet.getLastRowNum();
		int lastrowp = sheet.getPhysicalNumberOfRows();
		
		System.out.println("No.of.rows :"+lastrow);
		System.out.println("Include header row :"+lastrowp);
		
		short lastcell = sheet.getRow(0).getLastCellNum();
		System.out.println("No.of.cells :"+lastcell);
		
		String [][] testdata = new String[lastrow][lastcell];
		
		for (int i = 1; i <=lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			
			for (int j = 0; j <lastcell; j++) {
				XSSFCell cell = row.getCell(j);
				
				DataFormatter dft = new DataFormatter();
				String value = dft.formatCellValue(cell);
//				System.out.println(value);
				testdata[i-1][j]=value;
			} 
		}
		
		wbook.close();
		return testdata;

	}

}
