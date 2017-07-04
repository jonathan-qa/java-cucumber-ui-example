package com.e2e;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import lombok.Getter;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber/", "json:target/cucumber/cucumber.json"},
                 features = {"src/test/resources/features/ninjaInvoice.feature"})
@Getter
public class NinjaInvoiceTest {

    @Autowired
    private static SetupWebDriver webDriver = new SetupWebDriver();

    @AfterClass
    public static void tearDownTest() {
        webDriver.tearDownTest();
    }

}
