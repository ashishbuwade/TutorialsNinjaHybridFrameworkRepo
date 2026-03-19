package com.tutorialsninja.qa.testcases;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class Register extends Base {

    public WebDriver driver;
    RegisterPage registerPage;
    AccountSuccessPage accountSuccessPage;

    public Register(){
        super();
    }

    @BeforeMethod
    public void setup(){
        driver = initializeBrowserAndOpenAppURL(prop.getProperty("browserName"));
//        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        HomePage homePage = new HomePage(driver);
//        homePage.clickOnMyAccount();



//        driver.findElement(By.linkText("Register")).click();
//        registerPage = homePage.selectRegisterOption();

        registerPage = homePage.navigateToRegisterPage();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void verifyRegisteringAnAccountWithMandatoryFields(){

//        driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
//        driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
//        driver.findElement(By.id("input-email")).sendKeys(Utilities.randomEmailGenerator());
//        driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephone"));
//        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
//        driver.findElement(By.name("agree")).click();
//        driver.findElement(By.xpath("//input[@value='Continue']")).click();

//        RegisterPage registerPage = new RegisterPage(driver);

//        registerPage.enterFirstName(dataProp.getProperty("firstName"));
//        registerPage.enterLastName(dataProp.getProperty("lastName"));
//        registerPage.enterEmailAddress(Utilities.randomEmailGenerator());
//        registerPage.enterTelephone(dataProp.getProperty("telephone"));
//        registerPage.enterPassword(prop.getProperty("validPassword"));
//        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
//        registerPage.selectPrivacyPolicy();
//        accountSuccessPage = registerPage.clickOnContinueButton();

        accountSuccessPage = registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),Utilities.randomEmailGenerator(),dataProp.getProperty("telephone"),prop.getProperty("validPassword"));

//        String actualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']//h1")).getText();

//        AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
//        String actualSuccessHeading = accountSuccessPage.retrieveAccountSuccessPageHeading();
        Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(),dataProp.getProperty("accountSuccessHeading"),"Account not registered successfully");

    }

    @Test(priority = 2)
    public void verifyRegisteringAccountByProvidingAllFields(){

//        driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
//        driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
//        driver.findElement(By.id("input-email")).sendKeys(Utilities.randomEmailGenerator());
//        driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephone"));
//        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
//        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
//        driver.findElement(By.name("agree")).click();
//        driver.findElement(By.xpath("//input[@value='Continue']")).click();

//        RegisterPage registerPage = new RegisterPage(driver);

//        registerPage.enterFirstName(dataProp.getProperty("firstName"));
//        registerPage.enterLastName(dataProp.getProperty("lastName"));
//        registerPage.enterEmailAddress(Utilities.randomEmailGenerator());
//        registerPage.enterTelephone(dataProp.getProperty("telephone"));
//        registerPage.enterPassword(prop.getProperty("validPassword"));
//        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
//        registerPage.selectYesNewsLetterOption();
//        registerPage.selectPrivacyPolicy();
//        accountSuccessPage = registerPage.clickOnContinueButton();

        accountSuccessPage = registerPage.registerWithAllFields(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),Utilities.randomEmailGenerator(),dataProp.getProperty("telephone"),prop.getProperty("validPassword"));

//        String actualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']//h1")).getText();

//        AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
//        String actualSuccessHeading = accountSuccessPage.retrieveAccountSuccessPageHeading();
        Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(),dataProp.getProperty("accountSuccessHeading"),"Account not registered successfully");

    }

    @Test(priority = 3)
    public void verifyRegisteringAccountWithExistingEmailAddress(){

//        driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
//        driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
//        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
//        driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephone"));
//        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
//        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
//        driver.findElement(By.name("agree")).click();
//        driver.findElement(By.xpath("//input[@value='Continue']")).click();

//        RegisterPage registerPage = new RegisterPage(driver);

//        registerPage.enterFirstName(dataProp.getProperty("firstName"));
//        registerPage.enterLastName(dataProp.getProperty("lastName"));
//        registerPage.enterEmailAddress(prop.getProperty("validEmail"));
//        registerPage.enterTelephone(dataProp.getProperty("telephone"));
//        registerPage.enterPassword(prop.getProperty("validPassword"));
//        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
//        registerPage.selectYesNewsLetterOption();
//        registerPage.selectPrivacyPolicy();
//        registerPage.clickOnContinueButton();

        registerPage.registerWithAllFields(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),prop.getProperty("validEmail"),dataProp.getProperty("telephone"),prop.getProperty("validPassword"));

//        String actualWarning = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
//        String actualWarning = registerPage.retrieveDuplicateEmailAddressWarning();
        Assert.assertEquals(registerPage.retrieveDuplicateEmailAddressWarning(),dataProp.getProperty("duplicateEmailWarning"),"E-Mail Address is already registered.");

    }

    @Test(priority = 4)
    public void verifyRegisteringAccountWithoutFillingAnyDetails(){

//        driver.findElement(By.xpath("//input[@value='Continue']")).click();

//        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickOnContinueButton();

//        String actualPrivacyPolicyWarning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
//        String actualPrivacyPolicyWarning = registerPage.retrievePrivacyPolicyWarning();
//        Assert.assertEquals(registerPage.retrievePrivacyPolicyWarning(),dataProp.getProperty("privacyPolicyWarning"),"Privacy Policy Warning message is not displayed");


//        String actualFirstNameWarning = driver.findElement(By.xpath("//input[@id='input-firstname']//following-sibling::div")).getText();
//        String actualFirstNameWarning = registerPage.retreiveFirstNameWarning();
//        Assert.assertEquals(registerPage.retreiveFirstNameWarning(),dataProp.getProperty("firstNameWarning"),"First Name Warning message not displayed");

//        String actualLastNameWarning = driver.findElement(By.xpath("//input[@id='input-lastname']//following-sibling::div")).getText();
//        String actualLastNameWarning = registerPage.retreiveLastNameWarning();
//        Assert.assertEquals(registerPage.retreiveLastNameWarning(),dataProp.getProperty("lastNameWarning"),"Last Name must be between 1 and 32 characters!");

//        String actualEmailAddressWarning = driver.findElement(By.xpath("//input[@id='input-email']//following-sibling::div")).getText();
//        String actualEmailAddressWarning = registerPage.retreiveEmailWarning();
//        Assert.assertEquals(registerPage.retreiveEmailWarning(),dataProp.getProperty("emailWarning"),"E-Mail Address Warning message not displayed");

//        String actualTelephoneWarning = driver.findElement(By.xpath("//input[@id='input-telephone']//following-sibling::div")).getText();
//        String actualTelephoneWarning = registerPage.retreiveTelephoneWarning();
//        Assert.assertEquals(registerPage.retreiveTelephoneWarning(),dataProp.getProperty("telephoneWarning"),"Telephone Warning message not displayed");

//        String actualPasswordWarning = driver.findElement(By.xpath("//input[@id='input-password']//following-sibling::div")).getText();
//        String actualPasswordWarning = registerPage.retreivePasswordWarning();
//        Assert.assertEquals(registerPage.retreivePasswordWarning(),dataProp.getProperty("passwordWarning"),"Password Warning message not displayed");


        Assert.assertTrue(registerPage.displayStatusOfWarningMessages(dataProp.getProperty("privacyPolicyWarning"),dataProp.getProperty("firstNameWarning"),dataProp.getProperty("lastNameWarning"),dataProp.getProperty("emailWarning"),dataProp.getProperty("telephoneWarning"),dataProp.getProperty("passwordWarning")));
    }

}