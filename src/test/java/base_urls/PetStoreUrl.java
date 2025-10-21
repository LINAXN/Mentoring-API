package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

public class PetStoreUrl {
    protected RequestSpecification spec;
//    Map<String,String> apiKey= new HashMap<>();

    @BeforeMethod
    public void setSpec() {
//        apiKey.put("api_key","2eeebe74d17da380e718f9066997a62a");
        spec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io")
//                .addQueryParam("status", "sold")
//                .queryParams("api_key","2eeebe74d17da380e718f9066997a62a");
                .build();
    }

}

