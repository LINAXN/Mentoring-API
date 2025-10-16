package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

public class C01_SendRequestGetResponse {
    public static void main(String[] args) {
        Response respons =  RestAssured.get("https://restful-booker.herokuapp.com/booking/100");
        String responsPretty = respons.prettyPrint();
        int Status = respons.statusCode();
        System.out.println("Status code : "+Status);

        System.out.println(respons.headers());


        respons
                .then()
                .statusCode(200)
                .body("totalprice",equalTo(111));
    }
}
