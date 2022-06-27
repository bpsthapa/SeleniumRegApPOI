package Flow;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Others.Login;

public class Referral_flow extends Login
{
	
	public void switch_control_new_tab() 
	{
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		// Close old tab
		driver.close();
		// Switch to new tab.
		driver.switchTo().window(tabs.get(1));
	}
	
	@Test
	public void Report_summary() throws InterruptedException
	{
		String Ref = "0452-219105";
		
		driver.findElement(By.xpath("//div[@class='col-xs-6']//a//img")).click();
		
		driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Referral')]")).click();   //Referral menu
		driver.findElement(By.xpath("//a[contains(text(),'View Referrals')]")).click();   //view referrals
		driver.findElement(By.xpath("//a[contains(text(),'here')]")).click();             // click on pending referrals
		
		driver.findElement(By.xpath("//input[@id='AllReferralList_DXFREditorcol2_I']")).sendKeys(Ref,Keys.ENTER);     //enter ref# and enter
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@title='Report Summary']")).click();   //click on report summary;
	}
	
	@Test
	public void Addreport() throws InterruptedException 
	{
		String product_type=driver.findElement(By.xpath("//div//div//div//div//div//div[2]//div[4]//div[1]//span[1]")).getText();
		
		switch (product_type) 
		{
		case "TCM":
			
			//adding rtw report
			driver.findElement(By.xpath("//body/div/div/div/form/div/div/div/a[2]")).click();
			switch_control_new_tab();
			Select Repo_service= new Select(driver.findElement(By.id("service_id")));
			Repo_service.selectByValue("RTW/Off-Site Transitional Duty");   
			driver.findElement(By.id("reportObj_0__summary")).sendKeys("summary for RTW reports");
			driver.findElement(By.id("reportObj_0__introduction")).sendKeys("introduciton for RTW report");
			jsex.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			driver.findElement(By.id("reportObj_0__recommendation")).sendKeys("Recommendation for rtw report");
			driver.findElement(By.id("btnSave")).click();
			Thread.sleep(1000);
			
			
			//adding TCM report
			driver.findElement(By.xpath("//body//div//div//div//div//div//div//a[3]")).click();
			switch_control_new_tab();
			Select Repo_service1= new Select(driver.findElement(By.id("service_id")));
			Repo_service1.selectByIndex(1);  
			//driver.findElement(By.id("reportObj_0__summary")).sendKeys("report's summary");
			driver.findElement(By.id("reportObj_0__introduction")).sendKeys("introduciton");
			jsex.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			driver.findElement(By.id("reportObj_0__recommendation")).sendKeys("Report Recommendation");
			driver.findElement(By.id("btnSave")).click();
			Thread.sleep(1000);
			break;
			
		case "IME":
			
			break;
			
		case "FCM":
			
			break;

		default:
			System.out.println("unable to add reports");
			break;
		}	
	}
	
	@Test
	public void addBaf_submit()
	{
		WebElement Element1=driver.findElement(By.xpath("//body/div/div/div/form/div[6]/div[2]"));
		jsex.executeScript("arguments[0].scrollIntoView();", Element1);
		
		driver.findElement(By.xpath("(//span[@class='glyphicon glyphicon-edit'])[3]")).click();
		
		
		
	}
	
	
}
