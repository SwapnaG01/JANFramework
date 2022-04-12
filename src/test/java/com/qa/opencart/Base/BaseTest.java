package com.qa.opencart.Base;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.operncart.pages.AccountsPage;
import com.qa.operncart.pages.LoginPage;
import com.qa.operncart.pages.ProductInfoPage;
import com.qa.operncart.pages.RegistrationPage;
import com.qa.operncart.pages.SearchResultsPage;
public class BaseTest {
	public DriverFactory df;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginPage;
	public AccountsPage accPage;
	public SearchResultsPage searchResultsPage;
	public ProductInfoPage productInfoPage;
	public SoftAssert softAssert;
	public RegistrationPage registrationPage;
	
	@BeforeTest
	public void setup() {
		df=new DriverFactory();
		prop=df.init_prop();
		driver=df.init_driver(prop);
		loginPage=new LoginPage(driver);
		softAssert=new SoftAssert();
		
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
