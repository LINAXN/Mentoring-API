package tests;

import POJO.UserPojo;
import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class C12_CreateUserPOJO extends ReqresBaseUrl {
    /*
 Given: Base URL: https://reqres.in/api/users
 Request Body:
{
    "name": "morpheus",
    "job": "leader"
 }
 When: Send a POST request to the URL
 Then: Assert the status code is 201
 Verify the response body matches the structure:
 {
    "name": "morpheus",
    "job": "leader",
    "id": "496",
    "createdAt": "2022-10-04T15:18:56.372Z"
 }
 Note: Add authentication header: "x-api-key" with value "reqres-free-v1

     */
    @Test
    public void createUser() {


        UserPojo expectedData = new UserPojo("morpheus","leader") ;
        Response response = given(spec)
                .header("Content-Type", "application/json")
                .body(expectedData)
                .post("/api/users");

        response.prettyPrint();

        //
        UserPojo actualData = response.as(UserPojo.class);

        // Do assertions
        assertEquals(201, response.getStatusCode());
        assertEquals(expectedData.getName(), actualData.getName());
        assertEquals(expectedData.getJob(), actualData.getJob());

    }


}
