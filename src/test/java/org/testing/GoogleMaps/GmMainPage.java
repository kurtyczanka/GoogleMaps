package org.testing.GoogleMaps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmMainPage {
    WebDriver driver;

    public GmMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".tactile-searchbox-input")
    private WebElement searchField;


    public void enterLocalization(String localization) {
        searchField.sendKeys(localization, Keys.ENTER);

    }

}


