package com.e2e;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by amanda on 25/05/17.
 */
public class MeuPrimeiroTeste {


    @Test
    public void teste() {
        Response response = given().baseUri("http://azul-tito.cit:81")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\t\"Password\":\"Azul9393!\",\n" +
                        "\t\"Username\":\"495226907\"\n" +
                        "}")
                .when()
                .post("/TASBAccessLayer/Middleware/azul/security/logon");

        JsonPath jsonPath = new JsonPath(response.getBody().asString());
        String roles = jsonPath.getString("Roles");

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
        Assert.assertEquals("AIRM", roles);

    }

}
