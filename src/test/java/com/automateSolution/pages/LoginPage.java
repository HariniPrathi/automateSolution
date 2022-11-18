package com.automateSolution.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automateSolution.utility.TestSetUp;



public class LoginPage extends TestSetUp{
	WebDriver driver=null;
	By userName=By.name("user-name");
	By password=By.name("password");
	By loginButton=By.name("login-button");
	
	public  LoginPage(WebDriver driver)
	{
		this.driver=driver;		
	}
	


	public static WebElement element=null;
	
	public void setUserName(String text)
	{		
		this.driver.findElement(userName).sendKeys(text);
	}

   public void setPassword(String text)
   {		
	 this.driver.findElement(password).sendKeys(text);
	}
   public void submitLogin()
   {
	   this.driver.findElement(loginButton).sendKeys(Keys.RETURN);
   }
   
   public void Login(String userName,String password)
   {
	   setUserName(userName);
	   setPassword(password);
	   submitLogin();
   }

}
