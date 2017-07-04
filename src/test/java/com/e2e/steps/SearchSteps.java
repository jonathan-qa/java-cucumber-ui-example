package com.e2e.steps;

import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import com.e2e.ApplicationConfiguration;
import com.e2e.page.GooglePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SpringApplicationConfiguration(classes = ApplicationConfiguration.class)
public class SearchSteps {

  @Autowired
  private GooglePage googlePage;

  @Given("^I want to search \"([^\"]*)\" at Google$")
  public void i_want_to_search_at_Google(String keyword) throws Throwable {
    googlePage.openPage();
    googlePage.getSearchTextField().sendKeys(keyword);

  }

  @When("^I choose option Search$")
  public void i_choose_option_Search() throws Throwable {
    googlePage.getSearchButton().click();
  }

  @Then("^results must be returned$")
  public void results_must_be_returned() throws Throwable {
    assertTrue(googlePage.getResultQuantityLabel().getText() != null);
  }

}

