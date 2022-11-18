package com.automateSolution.testcases;

import static org.testng.Assert.assertEquals;



import java.util.List;


import org.testng.annotations.Test;

import com.automateSolution.pages.CheckOutOverviewPage;
import com.automateSolution.pages.ConfirmationPage;
import com.automateSolution.pages.HomePage;
import com.automateSolution.pages.LoginPage;
import com.automateSolution.pages.YourCheckOutInformationPage;
import com.automateSolution.pages.YourCheckOutPage;
import com.automateSolution.utility.Product;
import com.automateSolution.utility.TestSetUp;

public class CheckOutTest extends TestSetUp {
	@Test
	public void login() throws InterruptedException
	{	
		
		driver.get("https://www.saucedemo.com");		
		LoginPage loginPg=new LoginPage(driver);
		loginPg.Login("standard_user","secret_sauce");
		Thread.sleep(2000);
		
		HomePage homepg=new HomePage(driver);
		List<Product> expectedproducts= homepg.AddTwoProductsToCart();
		homepg.ClickOnCheckOutButton();
		
		YourCheckOutPage yourCheckOutPg=new YourCheckOutPage(driver);
		List<Product> actualproducts= yourCheckOutPg.GetProducts();
		yourCheckOutPg.ClickOnCheckOutButton();
		
		//Validating products , name, price in cart
		int count=0;
		for(Product actprd : actualproducts) {
			for(Product expprd:expectedproducts) {
				
				if(actprd.ProductName.equals(expprd.ProductName))
				{
					assertEquals(actprd.ProductPrice, expprd.ProductPrice);
					count++;
				}
				
			}
		}
		assertEquals(count, 2);
		
		YourCheckOutInformationPage yourCheckOutInfoPg=new YourCheckOutInformationPage(driver);
		yourCheckOutInfoPg.EnterPersonalDetails("myFirstName", "MyLastName", "99");
		
		CheckOutOverviewPage checkOutOvrPg=new CheckOutOverviewPage(driver);
		String[] arr=checkOutOvrPg.ReturnSubTotal().split(" ");
		Float actualSubTotal= Float.parseFloat(arr[arr.length-1].replace('$', ' '));
		Float expectedSubTotal=GetSubTotal(actualproducts);
		
		//validating price total
		assertEquals(actualSubTotal, expectedSubTotal);
		
		checkOutOvrPg.ClickOnFinishButton();
		
		ConfirmationPage confirmPg=new ConfirmationPage(driver);
		String title=confirmPg.GetHeaderMessage();
		
		//validating confirmation message 
		assertEquals(title, "THANK YOU FOR YOUR ORDER");
		
	}
	
	Float GetSubTotal(List<Product> products)
	{
		Float subtotal= (float) 0;
		for (Product product : products) {
			subtotal=subtotal+product.ProductPrice;
		}		
		return subtotal;
	}

}
