package com.netshoes.e2e.steps;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import com.netshoes.e2e.ApplicationConfiguration;
import com.netshoes.e2e.SetupWebDriver;
import com.netshoes.e2e.util.ObjectStore;
import com.netshoes.e2e.util.TakeScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

@SpringApplicationConfiguration(classes = ApplicationConfiguration.class)
public class BaseSteps {

  @Autowired
  private SetupWebDriver webDriver;

  @Autowired
  private TakeScreenshot takeScreenshot;

  @Autowired
  private ObjectStore objectStore;

  @Before
  public void setup() {
    webDriver.setup();
    takeScreenshot.initializeTestSuite();
    takeScreenshot.initializeTest();
    webDriver.getWebDriver().manage().window().maximize();
    webDriver.getWebDriver().manage().deleteAllCookies();
    webDriver.getWebDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    webDriver.getWebDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

    objectStore.clear();
  }

  @After
  public void tearDownScenario(Scenario scenario) {
    if (scenario.isFailed()) {
      takeScreenshot.execute();
    }
  }
}
