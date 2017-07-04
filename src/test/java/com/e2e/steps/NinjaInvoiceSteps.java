package com.e2e.steps;

import com.e2e.ApplicationConfiguration;
import com.e2e.NinjaInvoiceTest;
import com.e2e.page.GooglePage;
import com.e2e.page.NinjaPage;
import com.e2e.page.NinjaPageHomePrivate;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import javax.validation.constraints.AssertTrue;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Created by jonathans on 03/07/17.
 */

@SpringApplicationConfiguration(classes = ApplicationConfiguration.class)

public class NinjaInvoiceSteps {

    @Autowired
    private NinjaPage ninjaPage;
    private NinjaPageHomePrivate ninjaPageHomePrivate;

    @Given("^I have an user with email \"([^\"]*)\"$")
    public void iHaveAnUserWithEmail(String email) throws Throwable {
        ninjaPage.openNinjaPage();
        ninjaPage.getEmailField().sendKeys(email);
    }

    @And("^an password \"([^\"]*)\"$")
    public void anPassword(String password) throws Throwable {
        ninjaPage.getPasswordField().sendKeys(password);
    }

    @When("^i click in the login button$")
    public void iClickInTheLoginButton() throws Throwable {
        ninjaPage.getLoginButton().click();

    }

    @Then("^the home private page is opened$")
    public void theHomePrivatePageIsOpened() throws Throwable {

    }
}
