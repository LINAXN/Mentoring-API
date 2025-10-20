package tests;

import POJO.ProductPojo;
import base_urls.FakeStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C11_CreateProdectPOJO extends FakeStoreBaseUrl {
    @Test

    void createProductStringTest() {

        //Set the expected data
        ProductPojo expectedData = new ProductPojo("Book", 5, "History of the human beings", "History", "http://example.com");

        //Send the request
        Response response = given(spec).body(expectedData).post("/products");
        response.prettyPrint();

        //Do assertion
        ProductPojo actualData = response.as(ProductPojo.class);
        assertEquals(response.statusCode(), 201);
        assertEquals(actualData.getTitle(), expectedData.getTitle());
        assertEquals(actualData.getPrice(), expectedData.getPrice());
        assertEquals(actualData.getDescription(), expectedData.getDescription());
        assertEquals(actualData.getImage(), expectedData.getImage());
        assertEquals(actualData.getCategory(), expectedData.getCategory());
    }
}
