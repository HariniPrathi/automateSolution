package com.automateSolution.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
	WebDriver driver=null;
	By header=By.xpath("//h2[@class=\"complete-header\"]");
	
	public  ConfirmationPage(WebDriver driver)
	{
		this.driver=driver;		
	}
	
	public String GetHeaderMessage() {
		
		return this.driver.findElement(header).getText();
	}
}
