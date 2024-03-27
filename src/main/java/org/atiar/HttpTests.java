package org.atiar;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class HttpTests {

    @Test
    public void testGetRequest() {

        // Define base url
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send GET request
        Response response = RestAssured.get("/posts/1");

        // Verify status code
        Assert.assertEquals(response.getStatusCode(), 200);

        // Verify response body
        Assert.assertTrue(response.getBody().asString().contains("userId"));

    }

    @Test
    public void testGetRequestNotFound() {

        // Define base url
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send GET request to a non-existent resource
        Response response = RestAssured.get("/posts/1000");

        // Verify status code for resource not found
        Assert.assertEquals(response.getStatusCode(), 404);
    }

    @Test
    public void testPostRequest() {

        // Define base url
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send a POST request
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body("{ \"title\": \"Md. Atiar\", \"body\": \"bar\", \"userId\": 1 }")
                .when()
                .post("/posts");

        // Verify status code
        Assert.assertEquals(response.getStatusCode(), 201);

    }
    @Test
    public void testPutRequest() {

        // Define base url
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send a PUT request
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body("{ \"id\": 1, \"title\": \"Mridul\", \"body\": \"bar\", \"userId\": 1 }")
                .when()
                .put("/posts/1");

        // Verify status code
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}

