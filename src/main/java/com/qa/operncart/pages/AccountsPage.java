package com.qa.operncart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
private	By search=By.name("search");
private By searchBtn=By.cssSelector("div#search button");	
private	By header=By.cssSelector("div#logo a");
private	By accSecList=By.cssSelector("div#content h2");

   public AccountsPage(WebDriver driver)
   {
	   this.driver=driver;
	   eleUtil=new ElementUtil(driver);
   }
   public String getAccountPageTitle()
   {
	   //return driver.getTitle();
	   return eleUtil.waitForTitleIs(Constants.DEFAULT_TIME_OUT,Constants.ACCOUNTS_PAGE_TITLE);
   }
   public boolean isAccountPageHeaderExist()
   {
	   //return driver.findElement(search).isDisplayed();
	   return eleUtil.doIsdisplayed(header);
   }
   public boolean isSearchExist()
   {
	   //return driver.findElement(search).isDisplayed();
	   return eleUtil.doIsdisplayed(search);
   }
   public SearchResultsPage doSearch(String productName)
   {
	   if(isSearchExist()) {
	   eleUtil.doSendkeys(search, productName);
	   eleUtil.doclick(searchBtn);
	   return new SearchResultsPage(driver);
   }
	   return null;
   }
   public List<String> getAccountPageSectionsList()
   {
	   List<WebElement> secList=driver.findElements(accSecList);
	   List<String> accSecValList=new ArrayList<String>();
	   for(WebElement e:secList) {
		   String text=e.getText();
		   accSecValList.add(text);
	   }
	   return accSecValList;
   }


}
