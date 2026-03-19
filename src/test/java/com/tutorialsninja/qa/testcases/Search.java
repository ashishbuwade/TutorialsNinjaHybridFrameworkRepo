package com.tutorialsninja.qa.testcases;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Search extends Base {

    public WebDriver driver;
    SearchPage searchPage;
    HomePage homePage;

    public Search(){
        super();
    }

    @BeforeMethod
    public void setup(){
        driver = initializeBrowserAndOpenAppURL(prop.getProperty("browserName"));
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void verifySearchWithValidProduct(){

//        driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
//        driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("validProduct"));
//        HomePage homePage = new HomePage(driver);
//        homePage.enterProductIntoSearchBoxField(dataProp.getProperty("validProduct"));
//        searchPage = homePage.clickOnSearchButton();

        searchPage = homePage.searchAProduct(dataProp.getProperty("invalidProduct"));

//        Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
//        SearchPage searchPage = new SearchPage(driver);
        Assert.assertTrue(searchPage.displayStatusOfValidHPProduct(),"Valid Product HP is not displayed in the search results");
    }

    @Test(priority = 2)
    public void verifySearchWithInvalidProduct(){
//        driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("invalidProduct"));
//        driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
//        HomePage homePage = new HomePage(driver);
//        homePage.enterProductIntoSearchBoxField(dataProp.getProperty("invalidProduct"));
//        searchPage = homePage.clickOnSearchButton();

        searchPage = homePage.searchAProduct(dataProp.getProperty("invalidProduct"));

//        String actualWarningMessage = driver.findElement(By.xpath("//div[@id='content']//h2[text()='Products meeting the search criteria']//following-sibling::p")).getText();
//        Assert.assertEquals(actualWarningMessage,dataProp.getProperty("noProductTextInSearchMsg"),"No product message in search results is not displayed");
//        SearchPage searchPage = new SearchPage(driver);
        Assert.assertEquals(searchPage.retreiveNoProductMessageText(),dataProp.getProperty("noProductTextInSearchMsg"),"No product message in search results is not displayed");

    }

    @Test(priority = 3, dependsOnMethods = {"verifySearchWithValidProduct","verifySearchWithInvalidProduct"})
    public void verfySearchWithoutAnyProduct(){

//        driver.findElement(By.name("search")).sendKeys("");
//        driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
//        HomePage homePage = new HomePage(driver);
//        homePage.enterProductIntoSearchBoxField("");
//        searchPage = homePage.clickOnSearchButton();

        searchPage = homePage.searchAProduct("");

//        String actualWarningMessage = driver.findElement(By.xpath("//div[@id='content']//h2[text()='Products meeting the search criteria']//following-sibling::p")).getText();
//        String actualWarningMessage = searchPage.retreiveNoProductMessageText();
        Assert.assertEquals(searchPage.retreiveNoProductMessageText(),dataProp.getProperty("noProductTextInSearchMsg"),"No product message in search results is not displayed");

    }


}

