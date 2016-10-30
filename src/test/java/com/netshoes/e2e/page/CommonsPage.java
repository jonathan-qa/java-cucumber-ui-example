package com.netshoes.e2e.page;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.base.Function;
import com.netshoes.e2e.SetupWebDriver;
import com.netshoes.e2e.util.TakeScreenshot;

@Component
public abstract class CommonsPage {

  @Autowired
  private SetupWebDriver setupWebDriver;

  @Autowired
  private TakeScreenshot takeScreenshot;

  @Value("${front.url}")
  private String baseUrl;

  public void openPage() {
    getWebDriver().get(baseUrl + getResource());
    initElements();
  }

  public String getCookieValue(String cookieName) {
    explicitWait().until(new Function<WebDriver, Boolean>() {
      @Override
      public Boolean apply(WebDriver webDriver) {
        Cookie cookie = webDriver.manage().getCookieNamed(cookieName);
        return cookie != null;
      }
    });
    return getWebDriver().manage().getCookieNamed(cookieName).getValue();
  }

  public void initElements() {
    PageFactory.initElements(getWebDriver(), this);
  }

  protected abstract String getResource();

  protected WebDriver getWebDriver() {
    return setupWebDriver.getWebDriver();
  }

  protected TakeScreenshot getScreenshotManager() {
    return takeScreenshot;
  }

  public WebDriverWait explicitWait() {
    return new WebDriverWait(getWebDriver(), 30);
  }
}
