package com.automateSolution.pages;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automateSolution.utility.Product;
import com.automateSolution.utility.TestSetUp;



public class HomePage extends TestSetUp {
	WebDriver driver=null;
	By checkOutButton=By.xpath("//a[@class='shopping_cart_link']");
	
	public  HomePage(WebDriver driver)
	{
		this.driver=driver;		
	}
	
	public List<Product> AddTwoProductsToCart() throws InterruptedException
	{
		List<Product> products=new ArrayList<Product>();
		Product prd1=AddProduct(0);
		Product prd2=AddProduct(1);
		products.add(prd1);
		products.add(prd2);
		return products;
	}
	
	public Product AddProduct(int i) throws InterruptedException {
		Product product=new Product();
		
		WebElement prd=GetProductByIndex(i);
		
		product.ProductName=GetName(prd);
	
		product.ProductPrice=Float.parseFloat(GetPrice(prd).replace('$', ' '));
		
		ClickAddToCartButton(prd);
		
		return product;
	}
	
	public void ClickOnCheckOutButton()
	{
		this.driver.findElement(checkOutButton).click();
	}
	
	WebElement GetProductByIndex(int index)
	{
		
		List<WebElement> elements= driver.findElements(By.xpath("//div[@class='inventory_item']"));
		System.out.print(index);
		WebElement ele= elements.get(index);
		return ele;
		
	}
	
	String GetName(WebElement product)
	{
		return  product.findElement(By.xpath(".//div[@class='inventory_item_name']")).getText();
	}
	
	String GetPrice(WebElement product)
	{
		return  product.findElement(By.xpath(".//div[@class='inventory_item_price']")).getText();
	}
	
	 void ClickAddToCartButton(WebElement product)
	{
		 product.findElement(By.xpath(".//div[@class=\"inventory_item_price\"]/following-sibling::button")).click();
	}
	
	

}
