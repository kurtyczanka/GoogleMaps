package org.testing.GoogleMaps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class LocalizationStepTest {
    WebDriver driver;

    @Before
    public void driverSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Given("Site maps.google.pl is opened")
    public void site_maps_google_pl_is_opened() throws Throwable {
        driver.navigate().to("https://www.google.com/maps");

    }

    @When("I enter {string}")
    public void i_enter_localization(String localization) throws Throwable {
        GmMainPage mainPage = new GmMainPage(driver);
        mainPage.enterLocalization(localization);

    }

    @Then("I should see  {string}  on map")
    public void i_should_see_localization_on_map(String localization) throws Throwable {
        GmLocalizationPage localizationPage = new GmLocalizationPage(driver);

        Assertions.assertTrue(localizationPage.getText().contains(localization), "Localization wasn't display");
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
