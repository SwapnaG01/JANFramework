package com.qa.operncart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class RegistrationPage {

	private WebDriver driver;
	private ElementUtil eleutil;

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");
	private By subscribeYes = By.xpath("//label[@class='radio-inline']//input[@type='radio' and @value = '1']");
	private By subscribeNo = By.xpath("//label[@class='radio-inline']//input[@type='radio' and @value = '0']");
	private By agreeCheckBox = By.name("agree");
	private By continueBtn = By.xpath("//input[@type='submit' and @value='Continue']");
	private By sucessMessg = By.cssSelector("div#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}

	public boolean accountRegistration(String firstName, String lastName, String email, String telephone,
			String password, String subscribe) {

		eleutil.waitForElementToBeVisisble(this.firstName, Constants.DEFAULT_TIME_OUT).sendKeys(firstName);
		eleutil.doSendkeys(this.lastName, lastName);
		eleutil.doSendkeys(this.email, email);
		eleutil.doSendkeys(this.telephone, telephone);
		eleutil.doSendkeys(this.password, password);
		eleutil.doSendkeys(this.confirmpassword, password);

		if (subscribe.equalsIgnoreCase("yes")) {
			eleutil.doclick(subscribeYes);
		} else {
			eleutil.doclick(subscribeNo);
		}
		eleutil.doclick(agreeCheckBox);
		eleutil.doclick(continueBtn);

		if (getAccountRegisterSuccessMessg().contains(Constants.REGISTER_SUCCESS_MESSG)) {
			goToRegisterPage();
			return true;
		}
		return false;
	}

	public String getAccountRegisterSuccessMessg() {
		return eleutil.waitForElementToBeVisisble(sucessMessg, Constants.DEFAULT_TIME_OUT).getText();
	}

	private void goToRegisterPage() {
		eleutil.doclick(logoutLink);
		eleutil.doclick(registerLink);

	}

}