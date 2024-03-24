package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class HttpTests {

    @Test
    public void testGetRequest() {
        // Define base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send GET request
        Response response = RestAssured.get("/posts/1");

        // Verify status code
        Assert.assertEquals(response.getStatusCode(), 200);

        // Verify response body
        Assert.assertTrue(response.getBody().asString().contains("userId"));
    }

    @Test
    public void testPostRequest() {
        // Define base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send POST request
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body("{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }")
                .when()
                .post("/posts");

        // Verify status code
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test
    public void testPutRequest() {
        // Define base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send PUT request
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body("{ \"id\": 1, \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }")
                .when()
                .put("/posts/1");

        // Verify status code
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
