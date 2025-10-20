package tests;

import base_urls.FakeStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C10_CreateProudectString extends FakeStoreBaseUrl {
    @Test
    void createProductTest() {
// Set the expected data as a JSON string
        String payload = """
{
    "title": "Book",
    "price": 5,
    "description": "History of the human beings",
    "category": "History",
    "image": "http://example.com"
}
""";

// Send the request
        Response response = given(spec)
                .header("Content-Type", "application/json")
                .body(payload)
                .post("/products");

        response.prettyPrint();

// Convert the response to a Map for easy assertions
        Map<String, Object> actualData = response.as(Map.class);

// Do assertions
        assertEquals(201, response.statusCode());
        assertEquals("Book", actualData.get("title"));
        assertEquals(5, actualData.get("price"));
        assertEquals("History of the human beings", actualData.get("description"));
        assertEquals("http://example.com", actualData.get("image"));
        assertEquals("History", actualData.get("category"));

    }
}
