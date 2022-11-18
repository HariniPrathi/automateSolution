package com.automateSolution.utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestSetUp {
	protected WebDriver driver=null;
	 DesiredCapabilities capability;
	
	@BeforeTest
	public void Setup()
	{
		ChromeOptions options = new ChromeOptions();
     //options.merge(capability);
      //options.addArguments("headless");
      options.addArguments("window-size=1200x600");
		driver=new ChromeDriver(options);
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\chromedriver.exe");
	
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.close();
		driver.quit();
	}
	
}
