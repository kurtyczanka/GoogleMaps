package org.testing.GoogleMaps;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        features = "src/test/resources/Localization.feature",
        strict = true,
        tags = "@settingLocalization-feature")
public class CucumberRunner {

}