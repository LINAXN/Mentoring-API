package tests;

import POJO.ActivityPojo;
import base_urls.FakerApiUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C14_CRUD extends FakerApiUrl {
    /*
 Task: Write code that performs all CRUD operations on "activities"
using the Fake REST API at https://fakerestapi.azurewebsites.net
 Requirements:
 1. Use POJO classes for all operations
 2. Implement CREATE (POST) - Add new activity
 3. Implement READ (GET) - Retrieve activity details
 4. Implement UPDATE (PUT) - Modify existing activity
 5. Implement DELETE - Remove activity
 6. Add appropriate assertions for each operation
 */
    @Test
    void CRUDTest(){
        ActivityPojo createActivity = new ActivityPojo(1001, "Learn RestAssured", "2025-10-20T13:33:55.009Z", true);

        Response postResponse = given(spec)
                .header("Content-Type", "application/json")
                .body(createActivity)
                .post("/Activities");
        postResponse.prettyPrint();
    }
}
