package com.qa.operncart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class RegistrationPage {
	public WebDriver driver;
	private ElementUtil eleUtil;
	
	private By firstName=By.id("input-firstname");
	private By lastName=By.id("input-lastname");
	private By email=By.id("input-email");
	private By telephone=By.id("input-telephone");
	private By password=By.id("input-password");
	private By confirmpassword=By.id("input-confirm");
	private By subscribeYes=By.xpath("//label[@class='radio-inline']//input[@type='radio'and @value='0']");
	private By subscribeNo=By.xpath("//label[@class='radio-inline']//input[@type='radio'and @value='1']");
	private By agreeCheckbox=By.name("agree");
	private By continueBtn=By.xpath("//input[@type='submit' and @value='Continue']");
	private By successMessg=By.cssSelector("div#content h1");
	private By logoutLink=By.linkText("Logout");
	private By registerLink=By.linkText("Register");
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}

    public boolean accountRegistration(String firstName,
    		String lastName,String email,
    		String telephone,String password,
    		String subscribe)
    {
     eleUtil.waitForElementToBeVisisble(this.firstName,Constants.DEFAULT_TIME_OUT).sendKeys(firstName);
     eleUtil.doSendkeys(this.lastName,lastName);
     eleUtil.doSendkeys(this.email,email);
     eleUtil.doSendkeys(this.telephone, telephone);
     eleUtil.doSendkeys(this.password, password);
     eleUtil.doSendkeys(this.confirmpassword,password);
     if (subscribe.equalsIgnoreCase("yes")) {
			eleUtil.doclick(subscribeYes);
		} else {
			eleUtil.doclick(subscribeNo);
		}
		eleUtil.doclick(agreeCheckbox);
		eleUtil.doclick(continueBtn);

		if (getAccountRegisterSuccessMessg().contains(Constants.REGISTER_SUCCESS_MESSG)) {
			goToRegisterPage();
			return true;
		}
		return false;
	}

	public String getAccountRegisterSuccessMessg() {
		
		return eleUtil.waitForElementToBeVisisble(successMessg, Constants.DEFAULT_TIME_OUT).getText();
	}

	private void goToRegisterPage() {
		eleUtil.doclick(logoutLink);
		eleUtil.doclick(registerLink);

	}

}
