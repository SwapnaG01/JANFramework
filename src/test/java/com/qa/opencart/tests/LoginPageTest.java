package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.Base.BaseTest;
import com.qa.opencart.util.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 100-Design login page for open cart application..")
@Story("US 101-design login page features")
public class LoginPageTest extends BaseTest {
	
	
	@Test
	@Description("login Page Title Test..")
	@Severity(SeverityLevel.NORMAL)
	public void loginPageTitleTest() {
		String actTitle=loginPage.getLoginPageTitle();
	    System.out.println("page title:"+actTitle);
	    Assert.assertEquals(actTitle,Constants.LOGIN_PAGE_TITLE	);
	}
	
	@Test
	@Description("login Page Url Test..")
	@Severity(SeverityLevel.NORMAL)
	public void loginPageUrlTest()
	{
		String url=loginPage.getLoginPageUrl();
	    System.out.println("login url:"+url);
	    Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_FRACTION_URL));
	}
	
	@Test
	@Description("check forgot Pwd Link Test..")
	@Severity(SeverityLevel.CRITICAL)
	public void forgotPwdLinkTest()
	{
		
	    Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Test
	@Description("Login Test with correct username and correct password..")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest() {
		accPage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	    Assert.assertTrue(accPage.isAccountPageHeaderExist());
	}
	
    @Test
    @Description("Register link Exist..")
	@Severity(SeverityLevel.CRITICAL)
    public void isRegisterLinkExist()
    {
    	Assert.assertTrue(loginPage.isRegisterLinkExist());
    }
}
