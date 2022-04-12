package com.qa.opencart.util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	private WebDriver driver;
	public ElementUtil(WebDriver driver)
	{
		this.driver=driver;
	}
    public By getby(String locatorType,String locatorValue)
	{
		By locator=null;
		switch(locatorType.toLowerCase()) {
		case "id":
			locator=By.id(locatorValue);
			break;
		case "name":
			locator=By.name(locatorValue);
			break;
		case "classname":
			locator=By.className(locatorValue);
			break;
		case "xpath":
			locator=By.xpath(locatorValue);
			break;
		case "cssselectior":
			locator=By.cssSelector(locatorValue);
			break;
		case "linktext":
			locator=By.linkText(locatorValue);
			break;
		case "partiallinktext":
			locator=By.partialLinkText(locatorValue);
			break;
		case "tagname":
			locator=By.tagName(locatorValue);
			break;
			
			
		default:
			break;
		}
		return locator;
	}
	public  WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public  List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	public  void doSendkeys(By locator,String value)
	{
		WebElement ele=getElement(locator);
		ele.clear();
		ele.sendKeys(value);
	}
	public void doclick(By locator)
	{
		getElement(locator).click();
	}
	public String doElementgettext(By locator) 
	{
		return getElement(locator).getText();
	}
	public boolean isElementPresent(By locator)
	{
		if(getElements(locator).size()>0) {
			return true;
		}
		return false;
		}
	
	public boolean doIsdisplayed(By locator)
	{
		return getElement(locator).isDisplayed();
	}
	public boolean doIsenabled(By locator)
	{
		return getElement(locator).isEnabled();
	}
	
	
	public  List<String> getLinksTextLinks(By locator)
	{
	     List<WebElement> eleList=getElements(locator);
	     List<String> eleTextList=new ArrayList<String>();
	     for(WebElement e:eleList)
	 		{
	 		String text=e.getText();
	 		if(!text.isEmpty()) {
	 		eleTextList.add(text);
	 		}
	}
	     return eleTextList;
    }
	
	public  List<String> getElementAttributeList(By locator,String attrName)
	{
		List<WebElement> elelist=getElements(locator);
		List<String> eleAttrList =new ArrayList<String>();
		for(WebElement e:elelist)
		{
			String attrval=e.getAttribute(attrName);
			System.out.println(attrval);
			eleAttrList.add(attrval);
		}
		return eleAttrList;
	}
		//*****************DROPDOWN UTILS*****************//
	 public void doSelectVisibleText(By locator,String text)
     {
  	   Select select=new Select(getElement(locator));
  	   select.selectByVisibleText(text);
     }
     public void doSelectIndex(By locator,int index)
     {
  	   Select select=new Select(getElement(locator));
  	   select.selectByIndex(index);
     }
     public void doSelectValue(By locator,String value)
     {
  	   Select select=new Select(getElement(locator));
  	   select.selectByValue(value);
     }
     
     public List<String> doGetDropDownOptions(By locator) {
 		
 		Select select=new Select(getElement(locator));
 		List<WebElement> optionsList=select.getOptions();
 		List<String> optionsValueList=new ArrayList<String>();
 		System.out.println(optionsList.size());
 		 for(WebElement e:optionsList)
 		 {
 			String text= e.getText();
 		    //System.out.println(text);
 			optionsValueList.add(text);
 	    }
 		 return optionsValueList;
 	}
     public void doSelectDropDownValue(By locator,String value)
 	{
 		 Select select=new Select(getElement(locator));
 		 List<WebElement> countryList=select.getOptions();
 		 for(WebElement e:countryList)
 		 {
 			 String text=e.getText();
 			 if(text.equals(value))
 			 {
 				 e.click();
 			 break;
 				 
 			 }
 		 }
 		
 	}
 	public  void dropDownWithoutSelect(By locator,String value)
 	{
 	
 		 List<WebElement> countryList=getElements(locator);
 		 for(WebElement e:countryList)
 		 {
 			 String text=e.getText();
 			 if(text.equals(value))
 			 {
 				 e.click();
 			 break;
 				 
 			 }

 	     }
 	}
 	public  void printSuggestionList(By locator)
 	 {
 		List<WebElement> suggList=getElements(locator);
 		for(WebElement e:suggList)
 			{
 			    String text=e.getText();
 				System.out.println(text);
 		
 	        }
 	 }
 // *******************Actions Utils ************************//
 	public void selectSubMenu(By parentMenu, By childMenu) throws InterruptedException {
 		Actions act = new Actions(driver);
 		act.moveToElement(getElement(parentMenu)).perform();
 		Thread.sleep(2000);
 		getElement(childMenu).click();
 	}

 	public void selectSubMenu(By parentMenu, By childMenu, By subChildMenu) throws InterruptedException {
 		Actions act = new Actions(driver);
 		act.moveToElement(getElement(parentMenu)).perform();
 		Thread.sleep(2000);
 		act.moveToElement(getElement(childMenu)).perform();
 		Thread.sleep(2000);
 		getElement(subChildMenu).click();
 	}

 	public void selectSubMenu(By parentMenu, By childMenu1, By subChildMenu2, By subChildMenu3)
 			throws InterruptedException {
 		Actions act = new Actions(driver);
 		act.moveToElement(getElement(parentMenu)).perform();
 		Thread.sleep(2000);
 		act.moveToElement(getElement(childMenu1)).perform();
 		Thread.sleep(2000);
 		act.moveToElement(getElement(subChildMenu2)).perform();
 		Thread.sleep(2000);
 		getElement(subChildMenu3).click();
 	}

 	
 	public void doContextClick(By locator) {
 		Actions act = new Actions(driver);
 		act.contextClick(getElement(locator)).perform();
 	}
 	
 	public int getRightClickOptionsCount(By rightClick, By rightClickOptions) {
 		return getRightClickOptionsList(rightClick, rightClickOptions).size();
 	}

 	public List<String> getRightClickOptionsList(By rightClick, By rightClickOptions) {
 		List<String> rightClickItems = new ArrayList<String>();
 		doContextClick(rightClick);
 		List<WebElement> itemsList = getElements(rightClickOptions);
 		System.out.println(itemsList.size());

 		for (WebElement e : itemsList) {
 			String text = e.getText();
 			//System.out.println(text);
 			rightClickItems.add(text);
 		}
 		return rightClickItems;
 	}

 	public void selectRightClickMenu(By rightClick, By rightClickOptions, String value) {
 		doContextClick(rightClick);
 		List<WebElement> itemsList = getElements(rightClickOptions);
 		System.out.println(itemsList.size());
 		for (WebElement e : itemsList) {
 			String text = e.getText();
 			//System.out.println(text);
 			if (text.equals(value)) {
 				e.click();
 				break;
 			}
 		}

 	}
 	
 	/**
 	 * Clicks in the middle of the given element. Equivalent to: Actions.moveToElement(onElement).click()
 	 * @param locator
 	 */
 	public void doActionsClick(By locator) {
 		Actions act = new Actions(driver);
 		act.click(getElement(locator)).perform();
 	}
 	
 	/**
 	 * Equivalent to calling: Actions.click(element).sendKeys(keysToSend).
 	 * @param locator
 	 * @param value
 	 */
 	public void doActionsSendKeys(By locator, String value) {
 		Actions act = new Actions(driver);
 		act.sendKeys(getElement(locator), value).perform();
 	}
 	/**
 	 * An expectation for checking that an element is present on the DOM of a page.
 	 *  This does notnecessarily mean that the element is visible.
 	 *  polling time 500milliseconds by default
 	 * @param locator
 	 * @param timeout
 	 * @return
 	 */
 		public WebElement waitForElementPresent(By locator,int timeout)
 	       {
 		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
 		 return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
 	       }
 	/**
 	 * An expectation for checking that an element is present on the DOM of a page and visible.
 	 * Visibility means that the element is not only displayed but also has a height and width that isgreater than 0.
 	 * polling time 500milliseconds by default
 	 * @param sucessMessg
 	 * @param timeout
 	 * @return
 	 */
 		public  WebElement waitForElementToBeVisisble(By locator,int timeout)
 		{
 		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
 		 return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
 	    }
 		/**
 		 * An expectation for checking that an element is present on the DOM of a page.
 		 *  This does notnecessarily mean that the element is visible.
 		 * @param locator
 		 * @param timeout
 		 * @param pollingtime
 		 * @return
 		 */
 			public WebElement waitForElementPresent(By locator,int timeout,long pollingtime)
 		       {
 			 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout),Duration.ofMillis(pollingtime));
 			 return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
 		       }
 		/**
 		 * An expectation for checking that an element is present on the DOM of a page and visible.
 		 * Visibility means that the element is not only displayed but also has a height and width that isgreater than 0.
 		 * @param locator
 		 * @param timeout
 		 * @param pollingtime
 		 * @return
 		 */
 			public WebElement waitForElementToBeVisisble(By locator,int timeout,long pollingtime)
 			{
 			 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout),Duration.ofMillis(pollingtime));
 			 return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
 		    }
 			
 			public  Alert waitForAlert(int timeout)
 			{
 				 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
 		         return wait.until(ExpectedConditions.alertIsPresent());
 			     
 			}
 			public  void acceptAlert(int timeout)
 			{
 				waitForAlert(timeout).accept();
 				
 			}
 			public  void dismissAlert(int timeout)
 			{
 				waitForAlert(timeout).dismiss();
 				
 			}
 			public  String getAlertText(int timeout)
 			{
 				return waitForAlert(timeout).getText();
 				
 			}
 			public String waitforUrl(int timeout,String urlFraction)
 			{
 				 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
 					if( wait.until(ExpectedConditions.urlContains(urlFraction)))
 					{
 						return driver.getCurrentUrl();
 					}
 					return null;
 				
 			}
 			public String waitforUrlToBe(int timeout,String urlVal)
 			{
 				 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
 					if( wait.until(ExpectedConditions.urlToBe(urlVal)))
 					{
 						return driver.getCurrentUrl();
 					}
 					return null;
 				
 			}
 			public String waitForTitleContains(int timeout,String titleFraction)
 			{
 				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
 				if(wait.until(ExpectedConditions.titleContains(titleFraction)))
 						{
 					return driver.getTitle();
 						}
 				else{
 					System.out.println("title is not correct");
 					return null;
 				}
 			
 			}
 			public String waitForTitleIs(int timeout,String titleVal)
 			{
 				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
 				if(wait.until(ExpectedConditions.titleIs(titleVal)))
 						{
 					return driver.getTitle();
 						}
 				else{
 					System.out.println("title is not correct");
 					return null;
 				}
 			}
 			public WebDriver waitForFrameByElement(int timeout,WebElement frameElement)
 			{
 				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
 				return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
 			}
 			public WebDriver waitForFrameByString(int timeout,String frameLocator)
 			{
 				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
 				return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
 			}
 			public  WebDriver waitForFrameByIndex(int timeout,int frameIndex)
 			{
 				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
 				return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
 			}
 			public WebDriver waitForFrameByLocator(int timeout,By frameLocator)
 			{
 				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
 				return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
 			}
 			public void clickWhenReady(By locator,int timeout)
 			  {
 			      WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));  
 			      wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
 			  }
 			  public  void clickElementWhenReady(By locator,int timeout)
 			  {
 			      WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));  
 			      wait.until(ExpectedConditions.elementToBeClickable(getElement(locator))).click();
 			  }

 			 public  void printAllElementsText(By locator,int timeout)
 			{
 				List<WebElement>footerList=waitForElementsToBeVisible(locator,timeout);
 				for(WebElement e:footerList)
 				{
 					System.out.println(e.getText());
 				}
 			}
 			public  List<String> getElementsTextListWithWait(By locator,int timeout)
 			{
 				List<WebElement>footerList=waitForElementsToBeVisible(locator,timeout);
 				List<String> footerTextList=new ArrayList<String>();
 				for(WebElement e:footerList)
 				{
 					String text=e.getText();
 					footerTextList.add(text);
 				}
 				return footerTextList;
 			}
 			
 			public  List<WebElement> waitForElementsToBeVisible(By locator,int timeout)
 			{
 				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
 			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
 			}
			
}


		
	




