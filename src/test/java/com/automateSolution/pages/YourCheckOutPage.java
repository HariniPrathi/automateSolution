package com.automateSolution.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automateSolution.utility.Product;
import com.automateSolution.utility.TestSetUp;

public class YourCheckOutPage extends TestSetUp {
	WebDriver driver=null;
	By checkOutButton=By.xpath("//button[@id=\"checkout\"]");
	
	public  YourCheckOutPage(WebDriver driver)
	{
		this.driver=driver;		
	}
	
	public List<Product> GetProducts()
	{
		List<Product> products=new ArrayList<Product>();
		List<WebElement> productElements=GetProductElements();
		for (WebElement webElement : productElements) {
			Product prd=new Product();
			prd.ProductName=GetName(webElement);
			prd.ProductPrice=Float.parseFloat(GetPrice(webElement).replace('$', ' '));
			products.add(prd);
		}
		return products;
	}
	
	public void ClickOnCheckOutButton()
	{
		this.driver.findElement(checkOutButton).click();
	}
	
	List<WebElement> GetProductElements()
	{
		return this.driver.findElements(By.xpath("//div[@class=\"cart_item\"]"));
	}
	
	String GetName(WebElement prd)
	{
		return prd.findElement(By.xpath(".//div[@class=\"inventory_item_name\"]")).getText();
	}
	String GetPrice(WebElement prd)
	{
		return prd.findElement(By.xpath(".//div[@class=\"inventory_item_price\"]")).getText();
	}
}
