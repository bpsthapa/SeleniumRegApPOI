package Referral;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.testng.annotations.Test;

import Others.Login;

public class Zero_out extends Login
{
	@Test
	public void zeroout() throws InterruptedException, AWTException
	{
		driver.navigate().to("https://gbcwstage.gallagherbassett.com/Invoice/ZerooutInvoice");
		driver.findElement(By.xpath("//input[@id='chkNote_id']")).sendKeys("529632");   //invoice#
		driver.findElement(By.xpath("//button[contains(text(),'Go')]")).click();        //Go
		
		
		//driver.findElement(By.cssSelector("button[name='submit']")).click();       //Confirmaton
		
		//driver.findElement(By.xpath("//button[@id='btnYesConfirmYesNoZero']")).click();   //destination
		
		Thread.sleep(11500);
		
		Robot robot = new Robot();
		robot.mouseMove(665, 211);
		
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		driver.findElement(By.xpath("//button[@id='btnYesConfirmYesNo']")).click();       //Confirmaton
		
		Thread.sleep(1500);
		//robot.mouseMove(665, 211);
		//robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		driver.findElement(By.id("btnNoConfirmYesNoZero")).click();
	}
}
