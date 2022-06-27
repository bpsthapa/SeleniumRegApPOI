package Others;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Parameters;

public class Login extends Value
	{
		private void Implicitwait()
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		public void gotohome()
		{
			driver.get(prop.getProperty("urlhome"));
			
			WebDriverWait waitload=new WebDriverWait(driver, Duration.ofSeconds(20));	
			waitload.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("#spinner"))));
			
		}
		
		@BeforeSuite (alwaysRun = true)
		public void GBcareLogin() throws IOException
		{
			FileInputStream fis = new FileInputStream(".\\config.properties");
			prop.load(fis);
			
			//options.addArguments("--headless");			
			
			
			System.out.println(prop.getProperty("url"));
			driver.get(prop.getProperty("url"));
			
			Implicitwait();
			
			Alert alert = driver.switchTo().alert();
			alert.accept();
			
			driver.manage().window().maximize();
			
			driver.findElement(By.id("myusername")).sendKeys(prop.getProperty("username"));
			driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			gotohome();			
		}
		
	}
