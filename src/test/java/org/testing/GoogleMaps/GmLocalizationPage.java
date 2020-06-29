package org.testing.GoogleMaps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmLocalizationPage {
    WebDriver driver;

    public GmLocalizationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".section-hero-header-title-description")
    WebElement textWithLocalization;


    public String getText() {
        waitUntil(textWithLocalization);
        return textWithLocalization.getText();
    }

    public void waitUntil(WebElement element) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
    }
}