package tests;

import base_urls.DummyUrl;
import base_urls.TodoUrl;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.InputStream;

import static io.restassured.path.xml.XmlPath.given;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class C07_Test extends TodoUrl {
//    Given
//    https://dummy.restapiexample.com/api/v1/employees
//    When
//    User sends GET request
//    Then
//    Status code is 200
//    And
//    There are 24 employees
//            And
//"Tiger Nixon" and "Garrett Winters" are among them
//            And
//    Highest age = 66
//    And
//            Youngest = "Tatyana Fitzpatrick"
//    And
//    Total salary = 6,644,770

    @Test
    void petStoreAPITest() {

        Response response =  RestAssured.given(spec).get("/todos");

         response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        assertEquals(response.statusCode(), 200);

        System.out.println(jsonPath.getList("findAll{it.id>190}.id"));

        System.out.println(jsonPath.getList("findAll{it.userId<5}.userId"));

        assertTrue(jsonPath.getBoolean("any{it.title.contains('quis eius est sint explicabo')}"));
        int listname = jsonPath.getList("findAll{it.title=='quis eius est sint explicabo'}").size();










    }}
