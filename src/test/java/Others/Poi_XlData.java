package Others;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

public class Poi_XlData {
	

	public ArrayList<String> readData(String title, String xl_tabname) throws IOException {

		// ArrayList<String>
		
		ArrayList<String> Coloum_list = new ArrayList<String>();
		
		FileInputStream fis = new FileInputStream(".\\src\\main\\reources\\datademo.xlsx"); // tell where the files is
		XSSFWorkbook workbook = new XSSFWorkbook(fis); // without this object we cannot do nothing paramter of file
														// object

		int sheets = workbook.getNumberOfSheets(); // this gives the number of sheet's tab
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(xl_tabname)) // tab name got acess to this
																						// tab
			{
				XSSFSheet sheet = workbook.getSheetAt(i); // same for all the project
				Iterator<Row> rows = sheet.iterator(); // iterate all the rows of the sheet
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator(); // iterate all the cells of the sheet
				int k = 0;
				int coloumn_numbers = 0;
				while (ce.hasNext()) 
				{
					Cell cvalue = ce.next();
					if (cvalue.getStringCellValue().equalsIgnoreCase(title)) 
					{
						coloumn_numbers = k;
						//System.out.println("you are in " + cvalue.getStringCellValue());
					}
					k++;   //171
				} // end of while

				//System.out.println(" Total number of coloumn present: " +k);

				int Row_numbers=0;
				while(rows.hasNext())
				{
					Row rvalue=rows.next();
					//String ab=rvalue.getCell(coloumn_numbers).getStringCellValue();
					
					
					String cell_value=null;
					try 
					{
						cell_value=rvalue.getCell(coloumn_numbers).getStringCellValue();
					}
					
					catch (Exception e) 
					{
						double donum=rvalue.getCell(coloumn_numbers).getNumericCellValue();
						int intnum = 	(int) donum;
						cell_value=String.valueOf(intnum);  
					}
					
					Coloum_list.add(cell_value);
					Row_numbers++;
					
				}
				GetCellData_Randomly.rowcount=Row_numbers;         //passing higest number on random number
				Add_Referral.addressrowcount=Row_numbers;          //passing higest number on addresrandom number
				
				
				//test.rowcoun=Row_numbers;
				//System.out.println("Total number of rows present: " +Row_numbers);
				//System.out.println(Coloum_list.get(2));
			} // end of if
		} // end of for loop
		return Coloum_list;
	} // end of function
} // end of class