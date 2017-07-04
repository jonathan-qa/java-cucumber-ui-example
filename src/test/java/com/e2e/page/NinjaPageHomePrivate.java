package com.e2e.page;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by jonathans on 03/07/17.
 */

@Component
@Getter

public class NinjaPage extends CommonsPage {

    @Value("${ninja.url}")
    private String baseNinjaUrl;

    public void openNinjaPage() {
        getWebDriver().get(baseNinjaUrl + getResource());
        initElements();
    }

    @FindBys({ @FindBy(id = "login-with-password"),
               @FindBy(id = "email") })
    private WebElement emailField;

    @FindBys({ @FindBy(id = "login-with-password"),
               @FindBy(id = "password")})
    private WebElement passwordField;

    @FindBys({ @FindBy(id = "login-with-password"),
               @FindBy(className = "login-button")})
    private WebElement loginButton;

    @Override
    protected String getResource() {
        return "/";
    }
}
