package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsyPage {
    public EtsyPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "search_query")
    public WebElement searchBox;

    @FindBy(xpath = "(//button[@class='wt-input-btn-group__btn'])[1]")
    public WebElement searchButton;
}
