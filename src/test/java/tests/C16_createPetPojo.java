package tests;

import POJO.pet_store.PetPojo;
import base_urls.PetStoreUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static json_data.PetStoreData.PET_BODY;
import static org.testng.AssertJUnit.assertEquals;

public class C16_createPetPojo extends PetStoreUrl {
//    Reference the API documentation at
//    https://petstore.swagger.io/
//    Create a POJO class representing a Pet object with properties like:
//    id
//            name
//    category
//            photoUrls
//    status
//            tags
    @Test
    void test() throws JsonProcessingException {
        PetPojo payload = new ObjectMapper().readValue(PET_BODY, PetPojo.class);
        System.out.println("payload = " + payload);


        Response response = given(spec).body(payload) .contentType(ContentType.JSON)
        .post("/v2/pet");
        response.prettyPrint();

//
//        PetPojo actualData = response.as(PetPojo.class);
//        System.out.println("actualData" + actualData);
//        assertEquals(response.statusCode(),200);
//        assertEquals(actualData.getCategory(),payload.getCategory().getId());
        //Do assertion
        PetPojo actualData = response.as(PetPojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getId(), payload.getId());
        assertEquals(actualData.getCategory().getId(), payload.getCategory().getId());
        assertEquals(actualData.getCategory().getName(), payload.getCategory().getName());
        assertEquals(actualData.getName(), payload.getName());
        assertEquals(actualData.getPhotoUrls().getFirst(), payload.getPhotoUrls().getFirst());
        assertEquals(actualData.getPhotoUrls().getLast(), payload.getPhotoUrls().getLast());
        assertEquals(actualData.getTags().getFirst().getId(), payload.getTags().getFirst().getId());
        assertEquals(actualData.getTags().getFirst().getName(), payload.getTags().getFirst().getName());
        assertEquals(actualData.getTags().getLast().getId(), payload.getTags().getLast().getId());
        assertEquals(actualData.getTags().getLast().getName(), payload.getTags().getLast().getName());
        assertEquals(actualData.getStatus(), payload.getStatus());

    }
}
