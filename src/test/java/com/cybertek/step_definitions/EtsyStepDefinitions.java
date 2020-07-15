package com.cybertek.step_definitions;

import com.cybertek.pages.EtsyPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;


public class EtsyStepDefinitions {
    EtsyPage etsyPage = new EtsyPage();

    @Given("User is on the Etsy home page")
    public void user_is_on_the_etsy_home_page() {
        Driver.getDriver().get("https://www.etsy.com");
    }

    @Then("User should see title is as expected")
    public void user_should_see_title_is_as_expected() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("User searches wooden spoon and click")
    public void userSearchesWoodenSpoonAndClick() {
        EtsyPage etsyPage = new EtsyPage();
        etsyPage.searchBox.sendKeys("wooden spoon");
        etsyPage.searchButton.click();
    }

    @Then("User should see  Wooden spoon in the title")
    public void userShouldSeeWoodenSpoonInTheTitle() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Wooden spoon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @When("User searches {string} and click")
    public void userSearchesAndClick(String searchvalue) {
        etsyPage.searchBox.sendKeys(searchvalue + Keys.ENTER);
    }


    @Then("User should see {string} in the Etsy title")
    public void userShouldSeeInTheEtsyTitle(String searchValue) {
        String expectedTitle = searchValue + " | Etsy";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

    }

}