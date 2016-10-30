package com.netshoes.e2e;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber/", "json:target/cucumber/cucumber.json" }, features = { "src/test/resources/features/google.feature" }, tags = { "~@ignore" })
public class SearchTest {

  @Autowired
  private static SetupWebDriver webDriver = new SetupWebDriver();

  @AfterClass
  public static void tearDownTest() {
    webDriver.tearDownTest();
  }
}
