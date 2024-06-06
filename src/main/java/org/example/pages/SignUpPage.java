package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

// Gathers all the elements we would use for each Sign-Up test in the project

public class SignUpPage extends BasePage {

    @FindBy(xpath = "/html/body/div[1]/div[4]/main/div[1]/div[2]/div/div/div[2]/div[2]/form/div/button")
    private WebElement signUpButton;

    @FindBy(css = "#email-err")
    private WebElement emailErrorText;

    @FindBy(css = "#email")
    private WebElement emailFormField;

    @FindBy(css = "[data-continue-to='password-container']")
    private WebElement continuePassButton;

    @FindBy(css = "#password")
    private WebElement passFormField;

    @FindBy(css = "#password-err")
    private WebElement passErrorPills;

    @FindBy(css = ".password-validity-summary")
    private WebElement passErrorText;

    @FindBy(css = "[data-continue-to='username-container']")
    private WebElement continueUsernameButton;

    @FindBy(css = "#login")
    private WebElement userFormField;

    @FindBy(css = "#login-err")
    private WebElement userErorrText;

    @FindBy(css = "[data-continue-to='opt-in-container']")
    private WebElement continueSignUp;

    @FindBy(css = "#opt_in")
    private WebElement checkBoxForm;

    @FindBy(css = "[data-continue-to='captcha-and-submit-container']")
    private WebElement finishSignUpButton;


    @Step
    public void invalidEmailSetup(String email) {
        waitForElementToBeVisible(emailFormField);
        emailFormField.click();
        emailFormField.sendKeys(email);
    }

    @Step
    public void validEmailSetup(String email) {
        waitForElementToBeVisible(emailFormField);
        emailFormField.click();
        emailFormField.sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(continuePassButton));
        continuePassButton.click();
    }

    @Step
    public String emailErrorMessage() {
        waitForElementToBeVisible(emailErrorText);
        return emailErrorText.getText();
    }

    @Step
    public void invalidPassSetup(String pass) {
        passFormField.click();
        passFormField.sendKeys(pass);
    }

    @Step
    public void validPassSetup(String pass) {
        waitForElementToBeVisible(passFormField);
        passFormField.click();
        passFormField.sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(continueUsernameButton));
        continueUsernameButton.click();
    }

    @Step
    public String passErrorMessage() {
        waitForElementToBeVisible(passErrorText);
        return passErrorText.getText();
    }

    @Step
    public void invalidUserSetup(String user) {
        userFormField.click();
        userFormField.sendKeys(user);
    }

    @Step
    public String userErrorMessage() {
        waitForElementToBeVisible(userErorrText);
        return userErorrText.getText();
    }

    @Step
    public void validUserSetup(String user) {
        waitForElementToBeVisible(userFormField);
        userFormField.click();
        userFormField.sendKeys(user);
        wait.until(ExpectedConditions.elementToBeClickable(continueSignUp));
        continueSignUp.click();
    }

    @Step
    public void finishSignUp (String email, String pass, String user) throws InterruptedException {
        validEmailSetup(email);
        validPassSetup(pass);
        validUserSetup(user);
        wait.until(ExpectedConditions.elementToBeClickable(finishSignUpButton));
        finishSignUpButton.click();
    }

    @Step
    public Boolean checkBoxTick() {
        waitForElementToBeVisible(checkBoxForm);
        checkBoxForm.click();
        return checkBoxForm.isSelected();
    }
}
