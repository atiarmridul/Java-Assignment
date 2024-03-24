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


        Response response = RestAssured.get("/posts/1");


        Assert.assertEquals(response.getStatusCode(), 200);


        Assert.assertTrue(response.getBody().asString().contains("userId"));
    }

    @Test
    public void testPostRequest() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";


        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body("{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }")
                .when()
                .post("/posts");


        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test
    public void testPutRequest() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";


        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body("{ \"id\": 1, \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }")
                .when()
                .put("/posts/1");


        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
