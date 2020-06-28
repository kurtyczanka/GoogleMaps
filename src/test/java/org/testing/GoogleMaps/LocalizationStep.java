package org.testing.GoogleMaps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class LocalizationStep {


    WebDriver driver;
    WebDriverWait wait;


    @Given("I am on maps.google.pl")
    public void i_am_on_maps_google_pl() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.pl/maps");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
    }

    @When("I enter {string} in 'Search Google Maps' field")
    public void i_enter_localization_in_search_google_maps_field(String localization) throws Throwable {
        WebElement searchField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".tactile-searchbox-input")));
        searchField.sendKeys(localization);
        searchField.sendKeys(Keys.ENTER);

    }

    @Then("I should see  {string}  on map")
    public void i_should_see_localization_on_map(String localization) throws Throwable {
        wait.until(ExpectedConditions.urlContains(localization));
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains(localization), "Searched localization wasn't display");
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
