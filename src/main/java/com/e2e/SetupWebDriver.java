package com.e2e;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SetupWebDriver {

  private static WebDriver webDriver;

  public void setup() {
    if (webDriver == null) {
      Capabilities caps = new DesiredCapabilities();
      ((DesiredCapabilities) caps).setJavascriptEnabled(true);
      ((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
      System.setProperty("webdriver.chrome.driver", "/media/jonathans/Data/test-guru99/chromedriver");
      webDriver = new ChromeDriver(caps);
    }

  }

  protected void tearDownTest() {
    getWebDriver().close();
    getWebDriver().quit();
  }

  public WebDriver getWebDriver() {
    return webDriver;
  }

}
