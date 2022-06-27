//Working fine

package Others;

import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;



public class Add_Referral extends Login
{
	public static String prod;
	public static int addressrowcount;
	
	@BeforeClass
	public void AddReferralPage() throws InterruptedException 
	{
		Thread.sleep(1500);
		driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Referral')]")).click();
		//driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Referral')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Add Referral')]")).click();
	}
	
	public int RandomNum(int a, int b)
	{
		Random r = new Random();
		int low = a;
		int high = b;
		int result = r.nextInt(high-low) + low;
		return result;
	}
	
	@Parameters("product")  
	@Test
	public void Enter_Mandatory_Data(String product) throws IOException, InterruptedException 
	{
		
		//AddReferralPage();
		
		prod=product;
		
		
		
		//Select drpproduct= new Select(driver.findElement(By.id("RefDetailObj_product_id")));
		//Thread.sleep(1500);
		/*
		 * switch(product) { case "FCM": drpproduct.selectByVisibleText("FCM");
		 * 
		 * for(int i=0;i<6;i++) { Thread.sleep(500); int x=RandomNum(0, 11);
		 * driver.findElement(By.id("gvServices_LBI"+x+"T1")).click(); } break;
		 * case "TCM": drpproduct.selectByVisibleText("TCM"); for(int i=0;i<4;i++) {
		 * Thread.sleep(500); int x=RandomNum(0, 4);
		 * driver.findElement(By.id("gvServices_LBI"+x+"T1")).click(); }
		 * driver.findElement(By.id("gvServices_LBI5T1")).click(); //rtw offside
		 * transitional break;
		 * case "IME": drpproduct.selectByVisibleText("IME"); for(int i=0;i<4;i++) { int
		 * x=RandomNum(0, 9); Thread.sleep(500);
		 * driver.findElement(By.id("gvServices_LBI"+x+"T1")).click(); } Select drpCM=
		 * new Select(driver.findElement(By.id("priCaseManager")));
		 * drpCM.selectByIndex(RandomNum(1, 3)); //ime cm only break;
		 * default: System.out.println("unable to select product type select manually");
		 * }
		 */
		 
		Select drpmanager= new Select(driver.findElement(By.id("RefObj_marketer_id")));
		drpmanager.selectByIndex(RandomNum(1, 15));                              //manager
		
		Select drpsupervisor= new Select(driver.findElement(By.id("ddl_id_CM")));
		drpsupervisor.selectByIndex(RandomNum(1, 20));                              //supervisor
		
		Select drpintake= new Select(driver.findElement(By.id("RefObj_intake_user")));
		drpintake.selectByIndex(RandomNum(1, 20));                                  //intake
		
		if(!product.equals("FCM")||!product.equals("TCM"))
		{
			Select drpSecCM= new Select(driver.findElement(By.id("secCaseManager")));
			drpSecCM.selectByIndex(RandomNum(0, 250));  					       //Sec CM
			
			if(!product.equals("FCM")||!product.equals("TCM")||!product.equals("IME"))
			{
				Select drpCM1= new Select(driver.findElement(By.id("priCaseManager")));
				drpCM1.selectByIndex(RandomNum(0, 20));                          	  	//CM
			}	
		}
		Thread.sleep(2000);
		driver.findElement(By.id("RefDetailObj_source_fname")).sendKeys("Test Automation");
		
		
		//__________________________lower section________________________________//
		
		
		////////////////////////////////////////Claimant Info//////////////////////////////////////////////////
		
		GetCellData_Randomly xlobj=new GetCellData_Randomly();      //object to access function
	
		
		jsex.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		Thread.sleep(2000);
		driver.findElement(By.id("ClmntFName")).sendKeys(xlobj.datafromxl("cl fname"));
		driver.findElement(By.id("ClaimantInfoObj_MiddleInitial")).sendKeys(xlobj.datafromxl("cl mname"));
		driver.findElement(By.id("ClmntLName")).sendKeys(xlobj.datafromxl("cl lname"));
		Thread.sleep(2000);
		
		int address_index=RandomNum(0, addressrowcount-1);
		  driver.findElement(By.id("txtClaimantAddress")).sendKeys(xlobj.datafromxl("address",address_index)); //address
		  Thread.sleep(2000);
		  driver.findElement(By.id("txtClaimantCity")).sendKeys(xlobj.datafromxl("city",address_index)); //city
		  driver.findElement(By.id("ddlClaimantState")).sendKeys(xlobj.datafromxl("state", address_index)); //state
		  driver.findElement(By.id("txtClaimantZip")).sendKeys(xlobj.datafromxl("zip", address_index)); //zip
		driver.findElement(By.id("ClaimantInfoObj.doi_I")).sendKeys("2/2/2020"); //doi
		driver.findElement(By.id("ddlClaimantjurisdiction")).sendKeys(xlobj.datafromxl("state")); //jur
		
		
		
		/*-------------------------account----------------------------*/
		driver.findElement(By.xpath("//ul[@id='tabs']//a[contains(text(),'Account')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("AdjusterTier1Obj.account_id_I")).sendKeys(xlobj.datafromxl("account"),Keys.ARROW_UP,Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.id("AccountAdFName")).sendKeys(xlobj.datafromxl("Fname")); //adjuster Fnam
		driver.findElement(By.id("AccountAdLName")).sendKeys(xlobj.datafromxl("Lname")); //jur adjuster Lnam
		driver.findElement(By.id("AdjusterTier1Obj_adjusterEmail")).sendKeys(xlobj.datafromxl("email")); //email
		driver.findElement(By.id("AdjusterTier1Obj_claimno")).sendKeys(xlobj.datafromxl("claim#")); //claim number
	}
	
	@Test
	@Parameters("product")  
	public void select_product(String product) throws InterruptedException
	{
		//AddReferralPage();
		
		jsex.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		prod=product;
		Select drpproduct= new Select(driver.findElement(By.id("RefDetailObj_product_id")));
		Thread.sleep(1500);
		
		switch(product)
		{
			case "FCM":
				drpproduct.selectByVisibleText("FCM");
				
				for(int i=0;i<6;i++)
				{
					Thread.sleep(500);
					int x=RandomNum(0, 11);
					driver.findElement(By.id("gvServices_LBI"+x+"T1")).click();
				}
			break;	
			
			case "TCM":
				drpproduct.selectByVisibleText("TCM");
				for(int i=0;i<4;i++)
				{
					Thread.sleep(500);
					int x=RandomNum(0, 4);
					driver.findElement(By.id("gvServices_LBI"+x+"T1")).click();
				}
				driver.findElement(By.id("gvServices_LBI5T1")).click();      //rtw offside transitional
			break;	
				
			case "IME":
				drpproduct.selectByVisibleText("IME");
				for(int i=0;i<4;i++)
				{
					int x=RandomNum(0, 9);
					Thread.sleep(500);
					driver.findElement(By.id("gvServices_LBI"+x+"T1")).click();
				}
				Select drpCM= new Select(driver.findElement(By.id("priCaseManager")));
				drpCM.selectByIndex(RandomNum(1, 3));          //ime cm only
			break;
			
			default:
				System.out.println("unable to select product type select manually");
		}
	}
	
	@Test
	public void savebutton() throws InterruptedException
	{
		jsex.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.id("saveClose")).click(); //click save and continue
		Thread.sleep(2000);
		String ref=driver.getCurrentUrl();	
		System.out.println("Added "+prod+" Refferal id# " +ref.substring(ref.length()-6));
	}
	
}
