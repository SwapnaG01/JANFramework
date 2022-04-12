package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.Base.BaseTest;
import com.qa.opencart.util.Constants;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup()
	{
		accPage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test
	public void accountsPageTitleTest()
	{
		String actAccountPageTitle=accPage.getAccountPageTitle();
	System.out.println(actAccountPageTitle);
	Assert.assertEquals(actAccountPageTitle,Constants.ACCOUNTS_PAGE_TITLE);
	}
	
    @Test
    public void accountPageHeaderTest()
    {
    	Assert.assertTrue(accPage.isAccountPageHeaderExist());
    }
    @Test
    public void searchExistTest()
    {
    	Assert.assertTrue(accPage.isSearchExist());
    }
    @Test
    public void accSectionsTest()
    {
    	List<String> actSecList=accPage.getAccountPageSectionsList();
   System.out.println("Accounts section list:"+actSecList);
   Assert.assertEquals(actSecList,Constants.ACCOUNTS_SECTIONS_LIST);
    
    }
    @Test
    public void searchTest()
    {
    	searchResultsPage=accPage.doSearch("Macbook");
        String actSearchHeader=searchResultsPage.getResultsPageHeaderValue();
        Assert.assertTrue(actSearchHeader.contains("Macbook"));
    } 
    @Test
    public void searchProductCountTest()
    {
    	searchResultsPage=accPage.doSearch("IMac");
        int actProductCount=searchResultsPage.getProductSearchCount();
        Assert.assertEquals(actProductCount,Constants.IMAC_PRODUCT_COUNT);
    }
    @Test
    public void getsearchProductListTest()
    {
    	searchResultsPage=accPage.doSearch("IMac");
        List<String> actProductList=searchResultsPage.getProductResultsList();
        System.out.println(actProductList);
    }
}