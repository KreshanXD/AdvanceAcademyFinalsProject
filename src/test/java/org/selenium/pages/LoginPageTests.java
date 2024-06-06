package org.selenium.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageTests extends BasePageTests {

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = ".error-message-container")
    private WebElement errorMessageContainer;


    @Step("Set username")
    public void setUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    @Step("Set password")
    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @Step("Click login")
    public void clickLoginButton() {
        loginButton.click();
    }

    public void loginAs(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLoginButton();
    }

    public String getErrorMessage() {
        return errorMessageContainer.getText();
    }
}