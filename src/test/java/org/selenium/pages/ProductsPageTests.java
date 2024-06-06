package org.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPageTests extends BasePageTests {
    // Assuming there's an element to verify on the Products page, like a header
    @FindBy(className = "title")
    private WebElement pageTitle;


    public String getPageTitle() {
        return pageTitle.getText();
    }

    public HeaderComponent header (){
        return new HeaderComponent();
    }
}