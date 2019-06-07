package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import data.DataFile;

public class LoginPage {
	
	WebDriver driver;
	// we can not put this as logintest calls first objetof login page and when it comes to login page it calls the 
	// all the variables first. but it can not excute directly.
	/*
	 * WebElement email = driver.findElement(By.xpath(
	 * "(//div[@role='presentation']/div[1]/div[1]/div[1]/div[1]/input[1])[1]"));
	 * WebElement emailNext =
	 * driver.findElement(By.xpath("//span[contains(text(),'Next')]")); WebElement
	 * password = driver.findElement(By.xpath("//input[@name='password']"));
	 * WebElement passNext =
	 * driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
	 */
	@FindBy(id="identifierId")
	public static WebElement email;
	
	@FindBy(xpath ="//span[contains(text(),'Next')]")
	public static WebElement emailNext;
	
	@FindBy(xpath ="//input[@name='password']")
	public static WebElement password;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	public static WebElement passNext;
	
	@FindBy(xpath="//div[contains(text(),'Wrong password. Try again or click Forgot password to reset it.')]")
	public static WebElement passErrMsg;
	
	@FindBy(xpath="//div[@class='GQ8Pzc']")
	public static WebElement emailErrMsg;
			
	
	public void openBrowser() throws IOException {
		
		FileInputStream fs = new FileInputStream("C:\\\\Testing\\\\prop.properties");
		Properties prop = new Properties();
		prop.load(fs);
		
		String browser = prop.getProperty("browser"); //Chrome,IE

		
		if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:/SeleniumJars/geckodriver.exe");
			 driver = new FirefoxDriver();
			
		}
		else if(browser.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver","C:/SeleniumJars/chromedriver.exe");
			 driver= new ChromeDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver","C:/SeleniumJars/chromedriver.exe");
			 driver= new ChromeDriver();
		}
		
		PageFactory.initElements(driver, this);
	}
	
	public void openGmail() {
		
		driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&"
		 		+ "passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     driver.manage().window().maximize();
	  
	  
	}
	
    public void closeBrowser() {
    	driver.quit();
    	
    }
    
    public void enterEmail(String s) throws InterruptedException {
    	
    	
		
    	email.sendKeys(s);
	  emailNext.click();
	  Thread.sleep(1500);
    }
    
    
    public void enterPassword(String m) throws InterruptedException {
    	
       
  	  password.sendKeys(m);
  		
  	  passNext.click();
  		
        Thread.sleep(3000);
        
    }
    
    public void wrongEnterEmail() throws InterruptedException {
    	
    
  	  email.sendKeys("xyz@haji.com");
  	  emailNext.click();
        
        Thread.sleep(5000);
    }
    public String wrongPassworgMsg() {
    	 String actualerror = "Wrong password. Try again or click Forgot password to reset it.";
    	 System.out.println(actualerror);
    	 return actualerror;
    	 
    	 
    }
    
    public String wrongEmailMsg() {
    	
    	String actualError = "Couldn't find your Google Account";
    	System.out.println(actualError);
    	return actualError;
    	
    }
    
    
    
    
    
    
    
    
}

