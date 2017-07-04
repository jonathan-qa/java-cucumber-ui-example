package com.e2e.page;

import lombok.Getter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter

public class GooglePage extends CommonsPage {

  @Value("${front.url}")
  private String baseUrl;

  public void openPage() {
    getWebDriver().get(baseUrl + getResource());
    initElements();
  }

  @FindBy(id = "lst-ib")
  private WebElement searchTextField;

  // Field using chained search for web element
  //@FindBys({ @FindBy(id = "sblsbb"), @FindBy(className = "lsb") })
  //private WebElement searchButton;

  // Field using chained search for web element
  @FindBys({ @FindBy(className = "sbibod"), @FindBy(id = "_fZl") })
  private WebElement searchButton;

  @FindBy(id = "resultStats")
  private WebElement resultQuantityLabel;

  @Override
  protected String getResource() {
    return "/";
  }

}
