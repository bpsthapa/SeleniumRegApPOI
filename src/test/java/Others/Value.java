package Others;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Value 
{
	/*
	 * public static String url="https://newtest.medinsightscw.com"; public String
	 * urlhome="https://newtest.medinsightscw.com/home"; public String
	 * billurl="https://newtest.medinsightscw.com/BillingApp"; public String
	 * username="admin", password="ECS30!";
 	 */
	
	/*
	 * public static String urlhome = "https://ng.medinsightscw.com/home"; public
	 * String url = "https://ng.medinsightscw.com"; public String billurl =
	 * "https:https://ng.medinsightscw.com/Billing"; public String username =
	 * "admin", password = "Ecs30!30";
	 */
	 	
	/*
	 * public static String urlhome = "https://medinsightscw.com/home"; public
	 * String url = "https://medinsightscw.com"; public String billurl =
	 * "https://medinsightscw.com/Billing"; public String username = "admin",
	 * password = "admin80652";
	 */
	  	 
	  public static String path = System.setProperty("webdriver.chrome.driver",".\\src\\main\\reources\\chromedriver.exe");
	  //public static ChromeOptions options =new ChromeOptions();
	  
	  public static WebDriver driver = new ChromeDriver();
	  public static WebDriverWait wait = new WebDriverWait(driver, 40);
	  public static JavascriptExecutor jsex = (JavascriptExecutor) driver;
	  
	  public static Properties prop = new Properties();
	  
	 
	  //public static String CSV_file=".\\src\\main\\reources\\Testdata.CSV";
	
	  
	  
	  
	  

}
