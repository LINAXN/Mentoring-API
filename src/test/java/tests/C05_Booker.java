package tests;

import base_urls.TodoUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class C05_Booker extends TodoUrl {
    //    Given
//    https://restful-booker.herokuapp.com/booking/32
//    When
//    User sends GET request
//    Then
//    Status Code: 200
//    And
//    Content Type: application/json
//            And
//    firstname: "Josh"
//    lastname: "Allen"
//    totalprice: 111
    @Test
    void GooryTest() {
        Response response = given(spec).get("/booking/1224");

//    User sends GET request
        response.prettyPrint();

        // Assertions
        JsonPath jsonPath = response.jsonPath();
        assertEquals(response.statusCode(), 200);
        assertEquals(jsonPath.getString("firstname"), "Josh");
        assertEquals(jsonPath.getString("lastname"), "Allen");
        assertEquals(jsonPath.getInt("totalprice"), 111);
        assertEquals(response.contentType(), "application/json; charset=utf-8");
    }
}
