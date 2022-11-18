package com.automateSolution.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automateSolution.utility.TestSetUp;

public class YourCheckOutInformationPage extends TestSetUp {

	WebDriver driver=null;
	By firstName=By.xpath("//input[@name=\"firstName\"]");
	By lastName=By.xpath("//input[@name=\"lastName\"]");
	By postalCode=By.xpath("//input[@name=\"postalCode\"]");
	By continueButton=By.xpath("//input[@name=\"continue\"]");
	
	
	public  YourCheckOutInformationPage(WebDriver driver)
	{
		this.driver=driver;		
	}
	
	public void EnterPersonalDetails(String firstName,String lastName,String postalCode)
	{
		this.driver.findElement(this.firstName).sendKeys(firstName);
		this.driver.findElement(this.lastName).sendKeys(lastName);
		this.driver.findElement(this.postalCode).sendKeys(postalCode);
		this.driver.findElement(this.continueButton).click();
	}
}
