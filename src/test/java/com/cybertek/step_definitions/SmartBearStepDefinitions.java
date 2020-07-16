package com.cybertek.step_definitions;

import com.cybertek.pages.SmartBearPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class SmartBearStepDefinitions {

    SmartBearPage smartBearPage = new SmartBearPage();

    @Given("User is on the SmartBear login page")
    public void userIsOnTheSmartBearLoginPage() {
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        Driver.getDriver().manage().window().maximize();
    }

    @When("User enters credentials")
    public void userEntersCredentials() {
        smartBearPage.usernameInput.sendKeys("Tester");
        smartBearPage.passwordInput.sendKeys("test");
    }

    @Then("User logs in successfully")
    public void userLogsInSuccessfully() {
        smartBearPage.loginButton.click();
    }

    @Given("User is on the SmartBear Home page")
    public void userIsOnTheSmartBearHomePage() {
        smartBearPage.orderPage.click();
    }

    @Then("User selects {string} from  product dropdown")
    public void userSelectsFromProductDropdown(String arg0) {
        Select productDropdown = new Select(smartBearPage.product);
        productDropdown.selectByVisibleText(arg0);
    }

    @And("User enters {int} to quantity")
    public void userEntersToQuantity(int arg0) {
        smartBearPage.quantity.sendKeys("" + arg0);
    }

    @And("User enters {string} to customer name")
    public void userEntersToCustomerName(String arg0) {
        smartBearPage.customerName.sendKeys(arg0);
    }

    @And("User enters {string} to street")
    public void userEntersToStreet(String arg0) {
        smartBearPage.street.sendKeys(arg0);
    }

    @And("User enters {string} to city")
    public void userEntersToCity(String arg0) {
        smartBearPage.city.sendKeys(arg0);
    }

    @And("User enters {string} to state")
    public void userEntersToState(String arg0) {
        smartBearPage.state.sendKeys(arg0);
    }

    @And("User  enters {string} zipcode")
    public void userEntersZipcode(String arg0) {
        smartBearPage.zipCode.sendKeys(arg0);
    }

    @And("User selects {string} as card type")
    public void userSelectsAsCardType(String arg0) {
        smartBearPage.visa.click();
    }

    @And("enters {string} to card number")
    public void entersToCardNumber(String arg0) {
        smartBearPage.cardNumber.sendKeys(arg0);
    }

    @And("User enters {string} to expiration date")
    public void userEntersToExpirationDate(String arg0) {
        smartBearPage.expirationDate.sendKeys(arg0);
    }

    @And("User clicks process button")
    public void userClicksProcessButton() {
        smartBearPage.processButton.click();
    }

    @And("User goes to View all orders page")
    public void userGoesToViewAllOrdersPage() {
        smartBearPage.viewAllOrdersPage.click();
    }

    @And("User verifies {string} is in the list")
    public void userVerifiesIsInTheList(String arg0) {
        Assert.assertEquals(arg0, smartBearPage.customerNameTable.getText());
    }


}
