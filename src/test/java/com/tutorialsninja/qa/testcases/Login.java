package com.tutorialsninja.qa.testcases;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login extends Base {

    public WebDriver driver;
    LoginPage loginPage;

    public Login(){
        super();
    }

    @BeforeMethod
    public void setup(){
        driver = initializeBrowserAndOpenAppURL(prop.getProperty("browserName"));

//        driver.findElement(By.xpath("//a[@title='My Account']")).click();
//        driver.findElement(By.linkText("Login")).click();
        HomePage homePage = new HomePage(driver);
//        homePage.clickOnMyAccount();
//        loginPage = homePage.selectLoginOption();
        loginPage = homePage.navigateToLoginPage();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @DataProvider(name="validCredentialSupplier")
    public Object[][] supplyTestData(){
        Object[][] data = Utilities.getTestDataFromExcel("LoginPage");
        return data;
    }

    @Test(priority=5,dataProvider="validCredentialSupplier")
    public void verifyLoginWithValidCredentials(String email, String password){

//        driver.findElement(By.id("input-email")).sendKeys(email);
//        driver.findElement(By.id("input-password")).sendKeys(password);
//        driver.findElement(By.xpath("//input[@value='Login']")).click();

        loginPage = new LoginPage(driver);
//        loginPage.enterEmailAddress(email);
//        loginPage.enterPassword(password);
//        AccountPage accountPage = loginPage.clickOnLoginButton();

        AccountPage accountPage = loginPage.login(email,password);

//        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='My Account']")).isDisplayed(),"Logged In Failed");
//        AccountPage accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.getDisplayStatusOfMyAccount(),"Logged In Failed");
    }

    @Test(priority=1)
    public void verifyLoginWithInvalidCredentials(){

//        driver.findElement(By.id("input-email")).sendKeys(Utilities.randomEmailGenerator());
//        driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
//        driver.findElement(By.xpath("//input[@value='Login']")).click();


//        loginPage.enterEmailAddress(Utilities.randomEmailGenerator());
//        loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
//        loginPage.clickOnLoginButton();

        loginPage.login(Utilities.randomEmailGenerator(),dataProp.getProperty("invalidPassword"));

//        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
//        String actualWarningMessage = loginPage.retriveemailPasswordNotMatchingWarningMessageText();
//        String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
        Assert.assertEquals(loginPage.retriveemailPasswordNotMatchingWarningMessageText(),dataProp.getProperty("emailPasswordNoMatchWarning"),"Expected warning message is not displayed");

    }

    @Test(priority=2)
    public void verifyLoginWithInvalidEmailAndValidPass(){

//        driver.findElement(By.id("input-email")).sendKeys(Utilities.randomEmailGenerator());
//        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//        driver.findElement(By.xpath("//input[@value='Login']")).click();

//        loginPage.enterEmailAddress(Utilities.randomEmailGenerator());
//        loginPage.enterPassword(prop.getProperty("validPassword"));
//        loginPage.clickOnLoginButton();

        loginPage.login(Utilities.randomEmailGenerator(),prop.getProperty("validPassword"));

//        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
//        String actualWarningMessage = loginPage.retriveemailPasswordNotMatchingWarningMessageText();
//        String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
        Assert.assertEquals(loginPage.retriveemailPasswordNotMatchingWarningMessageText(),dataProp.getProperty("emailPasswordNoMatchWarning"),"Expected warning message is not displayed");

    }

    @Test(priority=3)
    public void verifyLoginWithValidEmailAndInValidPass(){


//        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
//        driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
//        driver.findElement(By.xpath("//input[@value='Login']")).click();

//        loginPage.enterEmailAddress(prop.getProperty("validEmail"));
//        loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
//        loginPage.clickOnLoginButton();

        loginPage.login(prop.getProperty("validEmail"),dataProp.getProperty("invalidPassword"));

//        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
//        String actualWarningMessage = loginPage.retriveemailPasswordNotMatchingWarningMessageText();
//        String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
        Assert.assertEquals(loginPage.retriveemailPasswordNotMatchingWarningMessageText(),dataProp.getProperty("emailPasswordNoMatchWarning"),"Expected warning message is not displayed");

    }

    @Test(priority=4)
    public void verifyLoginWithoutProvidingCredentials(){

//        driver.findElement(By.xpath("//input[@value='Login']")).click();
        loginPage.clickOnLoginButton();

//        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();

//        String actualWarningMessage = loginPage.retriveemailPasswordNotMatchingWarningMessageText();
//        String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
        Assert.assertEquals(loginPage.retriveemailPasswordNotMatchingWarningMessageText(),dataProp.getProperty("emailPasswordNoMatchWarning"),"Expected warning message is not displayed");

    }

}
