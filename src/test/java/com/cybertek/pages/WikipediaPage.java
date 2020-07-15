package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaPage {
    public WikipediaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "search")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;

    @FindBy(id = "firstHeading")
    public WebElement header;

    @FindBy(xpath = "//div[@class='fn']")
    public WebElement imageHeader;
}
