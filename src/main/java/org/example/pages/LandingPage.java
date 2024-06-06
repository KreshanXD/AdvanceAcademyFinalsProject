package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

    @FindBy(css = "#product")
    private WebElement productButtonLink;

    @FindBy(css = "#solutions")
    private WebElement solutionsButtonLink;

    @FindBy(css = "#open-source")
    private WebElement openSourceButtonLink;

    @FindBy(css = "#enterprise")
    private WebElement enterpriseButtonLink;

    @FindBy(css = "#pricing")
    private WebElement pricingButtonLink;

    @FindBy(css = "input.header-search-input")
    private WebElement searchBar;

    @FindBy(css = ".HeaderMenu-link--sign-in")
    private WebElement signInButtonLink;

    @FindBy(css = ".HeaderMenu-link--sign-up")
    private WebElement signUpButtonLink;

    @Step
    public SignUpPage clickButtonSignUp() {
        signUpButtonLink.click();
        return new SignUpPage();
    }

}
