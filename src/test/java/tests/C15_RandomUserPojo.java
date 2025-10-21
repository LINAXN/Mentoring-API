package tests;

import base_urls.RandomUserBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;



import POJO.random_user.*;

import static io.restassured.RestAssured.given;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class C15_RandomUserPojo extends RandomUserBaseUrl {
    @Test
    void test(){
        //Send the request
        Response response = given(spec).get("/api");
        response.prettyPrint();

        //Do assertion
        RandomUserPojo actualData = response.as(RandomUserPojo.class);
        assertEquals(response.statusCode(), 200);
//        Assert that the following fields are NOT null:
//        Email
        assertNotNull(actualData.getResults().getFirst().getEmail());
//        Username
        assertNotNull(actualData.getResults().getFirst().getLogin().getUsername());
//        Password
        assertNotNull(actualData.getResults().getFirst().getLogin().getPassword());
//        Medium picture URL
        assertNotNull(actualData.getResults().getFirst().getPicture().getMedium());

;    }
}
