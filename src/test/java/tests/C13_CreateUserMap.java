package tests;

import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C13_CreateUserMap extends ReqresBaseUrl {
    @Test
    void createuserMao(){
        Map<String,String> expectedData = new HashMap<>();
        expectedData.put("name","morpheus");
        expectedData.put("job","leader");

        Response response = given(spec)
                .header("Content-Type", "application/json")
                .body(expectedData)
                .post("/api/users");

        response.prettyPrint();

        Map actualData = response.as(Map.class);
        System.out.println(actualData);
        // Do assertions
        assertEquals(201, response.getStatusCode());
        assertEquals(expectedData.get("name"), actualData.get("name"));
        assertEquals(expectedData.get("job"), actualData.get("job"));


    }
}
