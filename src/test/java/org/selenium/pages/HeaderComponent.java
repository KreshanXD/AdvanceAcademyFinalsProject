package org.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends BasePageTests {

    @FindBy(css = ".shopping_cart_link")
    private WebElement catyIcon;

    public void openCartPageByIcon() {
        catyIcon.click();
    }
}