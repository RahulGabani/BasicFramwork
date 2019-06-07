package tests;

import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTestp  {
	
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
	
	
  @Test
  public void loginWithWrongPasswordTest() throws InterruptedException {
	  
	  lp.enterEmail(df.correctEmail);
	  lp.enterPassword(df.password);
		
	  Assert.assertEquals(df.passwordErr, LoginPage.passErrMsg.getText());
	  
	  
  }
  
  @Test
  public void loginWithWrongEmail() throws InterruptedException {
	  
	  lp.enterEmail(df.wrongEmail);
		
      Assert.assertEquals(df.emailErr, LoginPage.emailErrMsg.getText());
	  
	  
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	 lp.openBrowser();
	 lp.openGmail();
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	 lp.closeBrowser();
  }
  
  

}
