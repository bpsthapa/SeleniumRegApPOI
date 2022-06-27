package Others;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import org.testng.annotations.Test;

public class GetCellData_Randomly extends Login
{
	public static int rowcount=0;
	
	public String datafromxl(String fieldname) throws IOException
	{
		String tabname=prop.getProperty("SheetTab");
		Poi_XlData xlobj=new Poi_XlData();
		ArrayList<String> data=xlobj.readData(fieldname, tabname);
		String cellvalue;
		cellvalue=(String) data.get(RandomNum_xl());
		return cellvalue;
	}
	
	  public String datafromxl(String fieldname1, int address_index) throws IOException 
	  {
		 String tabname1=prop.getProperty("SheetTab"); 
		 Poi_XlData xlobj1=new Poi_XlData(); 
		 ArrayList<String> data1=xlobj1.readData(fieldname1, tabname1);
		 String cellvalue1; 
		 cellvalue1=(String) data1.get(address_index); 
		 return cellvalue1;
	  }
	  
	  @Test
	  public void fda() throws IOException
	  {
		  System.out.println(datafromxl("cl Fname"));
	  }
	
	public int RandomNum_xl()
	{
		Random r = new Random();
		int low = 1;
		int high = rowcount-1;
		int result = r.nextInt(high-low) + low;
		return result;
	}
	
	
}
