package com.automateSolution.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutOverviewPage {

	WebDriver driver=null;
	By subTotal=By.xpath("//div[@class=\"summary_subtotal_label\"]");
	By finishButton=By.id("finish");
	public  CheckOutOverviewPage(WebDriver driver)
	{
		this.driver=driver;		
	}
	public String ReturnSubTotal()
	{
		return this.driver.findElement(subTotal).getText();
	}
	
	public void ClickOnFinishButton() {
		
		 this.driver.findElement(finishButton).click();
	}
}
