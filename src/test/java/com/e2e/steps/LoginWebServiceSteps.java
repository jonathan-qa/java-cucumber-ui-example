package com.e2e.steps;

import com.e2e.ApplicationConfiguration;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.boot.test.SpringApplicationConfiguration;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by amanda on 25/05/17.
 */
@SpringApplicationConfiguration(classes = ApplicationConfiguration.class)
public class LoginWebServiceSteps {


    private String user;
    private RequestSpecification request;
    private String password;
    private Response response;


    @And("^a password \"([^\"]*)\"$")
    public void aPassword(String password) throws Throwable {
        request.body("{\n" +
                "\t\"Password\":\"" + password + "\",\n" +
                "\t\"Username\":\"" + user + "\"\n" +
                "}");
    }

    @Given("^I have an user \"([^\"]*)\"$")
    public void iHaveAnUser(String user) throws Throwable {
        this.request = given().baseUri("http://azul-tito.cit:81").contentType(ContentType.JSON);
        this.user = user;
    }

    @When("^I call login$")
    public void iCallLogin() throws Throwable {
        response = request.post("/TASBAccessLayer/Middleware/azul/security/logon");
    }

    @Then("^I expect HTTP Status (\\d+)$")
    public void iExpectHTTPStatus(int expectedStatus) throws Throwable {
        Assert.assertEquals(expectedStatus, response.getStatusCode());
    }

    @And("^I expect \"([^\"]*)\" as \"([^\"]*)\"$")
    public void iExpectAs(String field, String expectedValue) throws Throwable {
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(expectedValue, jsonPath.getString(field));
    }
}
