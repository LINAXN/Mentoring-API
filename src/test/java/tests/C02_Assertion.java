package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class C02_Assertion {

    @Test
    void assertionTest() {

        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/100");
        response.prettyPrint();


    }

}
