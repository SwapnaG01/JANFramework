package com.qa.operncart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;
import com.qa.opencart.util.Errors;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleutil;

	// 1. private by locators:
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwd = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	private By logout = By.linkText("Logout");

	private By loginErrorMessg = By.cssSelector("div.alert.alert-danger.alert-dismissible");


	// 2. public page const....
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}

	// 3. public page actions:
	@Step("getting login page title.....")
	public String getLoginPageTitle() {
		return eleutil.waitForTitleIs(Constants.DEFAULT_TIME_OUT, Constants.LOGIN_PAGE_TITLE);
	}

	@Step("getting login url title.....")
	public String getLoginPageUrl() {
		return eleutil.waitforUrlToBe(Constants.DEFAULT_TIME_OUT, Constants.LOGIN_PAGE_FRACTION_URL);
	}

	@Step("checking that forgot pwd link is displayed or not.....")
	public boolean isForgotPwdLinkExist() {
		return eleutil.doIsdisplayed(forgotPwd);
	}

	@Step("login to application with correct username {0} and password {1}")
	public AccountsPage doLogin(String un, String pwd) {
		eleutil.waitForElementToBeVisisble(emailId, Constants.DEFAULT_TIME_OUT).sendKeys(un);
		eleutil.doSendkeys(password, pwd);
		eleutil.doclick(loginBtn);
		return new AccountsPage(driver);
	}
	
	@Step("login to application with correct username {0} and password {1}")
	public boolean doInvalidLogin(String un, String pwd) {
		WebElement email_ele = eleutil.waitForElementToBeVisisble(emailId, Constants.DEFAULT_TIME_OUT);
		email_ele.clear();
		email_ele.sendKeys(un);
		eleutil.doSendkeys(password, pwd);
		eleutil.doclick(loginBtn);
		String actualErrorMesg = eleutil.doElementgettext(loginErrorMessg);
		System.out.println(actualErrorMesg);
			if(actualErrorMesg.contains(Errors.LOGIN_PAGE_ERROR_MESSG)) {
				return true;
			}
			return false;
	}
	
	
	@Step("checking that register link is exist or not.....")
	public boolean isRegisterLinkExist() {
		return eleutil.waitForElementToBeVisisble(registerLink, Constants.DEFAULT_TIME_OUT).isDisplayed();

	}
	
	@Step("navigating to register page.....")
	public RegistrationPage navigateToRegisterPage() {
		if(isRegisterLinkExist()) {
			eleutil.doclick(registerLink);
			return new RegistrationPage(driver);
		}
		return null;
	}
	

}