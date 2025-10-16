package tests;

import base_urls.PetStoreUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.core.AllOf;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C04_Petstore extends PetStoreUrl {
    @Test
    public void Pets() {

        Response response = given(spec)
                .queryParam("status", "sold")
                .get("/pet/findByStatus");
        response.prettyPrint();
//
        response.then()
                .contentType(ContentType.JSON)
                .body("status", hasItem("sold"))
                .body("name", hasItems("FluffyUpdated", "Pluto"))
                .body("name", hasItem(containsString("Fluffy")))
                .body("id", hasItem(greaterThan(1000)))
                .body("", hasSize(greaterThan(5)))
                .body("", instanceOf(List.class))
                .body("name", hasItem(startsWith("P")))
                .body("status", everyItem(equalTo("sold")))
                .body("findAll { it.name == 'Pluto' || it.id == 615849 }", hasSize(1));




    }
}
