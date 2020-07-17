package com.cybertek.step_definitions;


import com.cybertek.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before(order = 2)
    public void setUpScenario() {
        System.out.println("-----> Before annotation: Setting up browser");
    }

    @Before(value = "@db", order = 1)
    public void setUpDatabaseConnection() {
        System.out.println("-----> Before annotation: DB connection created <-----");
    }

    @After(order = 1)
    public void tearDownScenario(Scenario scenario) {
//        System.out.println("-----> After annotation: Closing browser");
//        System.out.println("scenario.getName() = " + scenario.getName());
//        System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
//        System.out.println("scenario.isFailed() = " + scenario.isFailed());

        // #1 we need to take a screenshot using Selenium
        byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        // #2 we are going to attach it into our report
        scenario.attach(screenshot, "image/png", scenario.getName());

    }

    @After(value = "@db", order = 2)
    public void tearDownDatabaseConnections() {
        System.out.println("-----> After Annotation: DB connection closed <-----");
    }

    @BeforeStep
    public void setUpStep() {
        System.out.println("=====> BeforeStep: Taking Screenshot <=====");
    }

    @AfterStep
    public void tearDownStep() {
        System.out.println("=====> AfterStep: Taking Screenshot <=====");
    }


}
