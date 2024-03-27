
# CHEQ Assignment

A simple task containing HTTP method testing, API error handling & content validation.

## Technology Used
**Programming Language:** JAVA

**Build Tool:** Maven

**IDE:** IntelliJ IDEA


## Prerequisite
Must have the following dependencies in the Maven build file. 
    
 - TestNG
 - Rest Assured 


## Project Summary

I have executed 4 simple tests, they are following:

- **testGetRequestSuccess:** 
Sends a GET request to retrieve a specific resource and asserts that the response status code is 200 and that the response body contains a specific string.

```bash
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
```


- **testGetRequestNotFound:**
Sends a GET request to retrieve a resource that does not exist and asserts that the response status code is 404 (Not Found).

```bash
    public void testGetRequestNotFound() {

        // Define base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send a GET request to a non-existent resource
        Response response = RestAssured.get("/posts/1000");

        // Verify status code for resource not found
        Assert.assertEquals(response.getStatusCode(), 404);
    }

```


- **testPostRequest:**
Sends a POST request to create a new resource and asserts that the response status code is 201 (Created).

```bash
    public void testPostRequest() {

    
        // Define base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send POST request
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body("{ \"title\": \"Md.Atiar\", \"body\": \"bar\", \"userId\": 1 }")
                .when()
                .post("/posts");

        // Verify status code
        Assert.assertEquals(response.getStatusCode(), 201);

    }

```

- **testPutRequest:**
Sends a PUT request to update an existing resource and asserts that the response status code is 200 (OK).

```bash
    public void testPutRequest() {
        // Define base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send PUT request
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body("{ \"id\": 1, \"title\": \"Mridul\", \"body\": \"bar\", \"userId\": 1 }")
                .when()
                .put("/posts/1");

        // Verify status code
        Assert.assertEquals(response.getStatusCode(), 200);
    }

```




