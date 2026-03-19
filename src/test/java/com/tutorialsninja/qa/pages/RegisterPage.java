package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;

    @FindBy(id = "input-firstname")
    private WebElement firstNameField;

    @FindBy(id = "input-lastname")
    private WebElement lastNameField;

    @FindBy(id = "input-email")
    private WebElement emailField;

    @FindBy(id = "input-telephone")
    private WebElement telephoneField;

    @FindBy(id = "input-password")
    private WebElement passwordField;

    @FindBy(id = "input-confirm")
    private WebElement confirmPasswordField;

    @FindBy(name = "agree")
    private WebElement privacyField;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@name='newsletter'][@value='1']")
    private WebElement yesNewsLetterOption;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement duplicateEmailAddressWarning;

    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    private WebElement privacyPolicyWarning;

    @FindBy(xpath = "//input[@id='input-firstname']//following-sibling::div")
    private WebElement firstNameWarning;

    @FindBy(xpath = "//input[@id='input-lastname']//following-sibling::div")
    private WebElement lastNameWarning;

    @FindBy(xpath = "//input[@id='input-email']//following-sibling::div")
    private WebElement emailWarning;

    @FindBy(xpath = "//input[@id='input-telephone']//following-sibling::div")
    private WebElement telephoneWarning;

    @FindBy(xpath = "//input[@id='input-password']//following-sibling::div")
    private WebElement passwordWarning;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterFirstName(String firstNameText){
        firstNameField.sendKeys(firstNameText);
    }

    public void enterLastName(String lastNameText){
        lastNameField.sendKeys(lastNameText);
    }

    public void enterEmailAddress(String emailText){
        emailField.sendKeys(emailText);
    }

    public void enterTelephone(String telephoneText){
        telephoneField.sendKeys(telephoneText);
    }

    public void enterPassword(String passwordText){
        passwordField.sendKeys(passwordText);
    }

    public void enterConfirmPassword(String confirmPasswordText){
        confirmPasswordField.sendKeys(confirmPasswordText);
    }

    public void selectPrivacyPolicy(){
        privacyField.click();
    }

    public void selectYesNewsLetterOption(){
        yesNewsLetterOption.click();
    }

    public AccountSuccessPage clickOnContinueButton(){
        continueButton.click();
        return new AccountSuccessPage(driver);
    }

    public String retrieveDuplicateEmailAddressWarning(){
        String duplicateEmailAddressWarningText = duplicateEmailAddressWarning.getText();
        return duplicateEmailAddressWarningText;
    }

    public String retrievePrivacyPolicyWarning(){
        String privacyPolicyWarningText = privacyPolicyWarning.getText();
        return privacyPolicyWarningText;
    }

    public String retreiveFirstNameWarning(){
        String firstNameWarningText = firstNameWarning.getText();
        return firstNameWarningText;
    }

    public String retreiveLastNameWarning(){
        String lastNameWarningText = lastNameWarning.getText();
        return lastNameWarningText;
    }

    public String retreiveEmailWarning(){
        String emailWarningText = emailWarning.getText();
        return emailWarningText;
    }

    public String retreiveTelephoneWarning(){
        String telephoneWarningText = telephoneWarning.getText();
        return telephoneWarningText;
    }

    public String retreivePasswordWarning(){
        String passwordWarningText = passwordWarning.getText();
        return passwordWarningText;
    }

    public AccountSuccessPage registerWithMandatoryFields(String firstNameText, String lastNameText,String emailText,String telephoneText,String passwordText){
        firstNameField.sendKeys(firstNameText);
        lastNameField.sendKeys(lastNameText);
        emailField.sendKeys(emailText);
        telephoneField.sendKeys(telephoneText);
        passwordField.sendKeys(passwordText);
        confirmPasswordField.sendKeys(passwordText);
        privacyField.click();
        continueButton.click();
        return new AccountSuccessPage(driver);
    }

    public AccountSuccessPage registerWithAllFields(String firstNameText, String lastNameText,String emailText,String telephoneText,String passwordText){
        firstNameField.sendKeys(firstNameText);
        lastNameField.sendKeys(lastNameText);
        emailField.sendKeys(emailText);
        telephoneField.sendKeys(telephoneText);
        passwordField.sendKeys(passwordText);
        confirmPasswordField.sendKeys(passwordText);
        privacyField.click();
        yesNewsLetterOption.click();
        continueButton.click();
        return new AccountSuccessPage(driver);
    }

    public boolean displayStatusOfWarningMessages(String expectedPrivacyPolicyWarning, String expectedFirstNameWarning, String expectedLastNameWarning, String expectedEmailWarning, String expectedTelephoneWarning, String expectedPasswordWarning){
//        String actualPrivacyPolicyWarningText = privacyPolicyWarning.getText();
        boolean privacyPolicyWarningStatus = privacyPolicyWarning.getText().equals(expectedPrivacyPolicyWarning);

//        String actualFirstNameWarningText = firstNameWarning.getText();
        boolean firstNameWarningStatus = firstNameWarning.getText().equals(expectedFirstNameWarning);

//        String actualLastNameWarningText = lastNameWarning.getText();
        boolean lastNameWarningStatus = lastNameWarning.getText().equals(expectedLastNameWarning);

//        String actualEmailWarningText = emailWarning.getText();
        boolean emailWarningStatus = emailWarning.getText().equals(expectedEmailWarning);

//        String actualTelephoneWarningText = telephoneWarning.getText();
        boolean telephoneWarningStatus = telephoneWarning.getText().equals(expectedTelephoneWarning);

//        String actualPasswordWarningText = passwordWarning.getText();
        boolean passwordWarningStatus = passwordWarning.getText().equals(expectedPasswordWarning);

        return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus && telephoneWarningStatus && passwordWarningStatus;

    }

}
