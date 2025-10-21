package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class FakerApiUrl {
    protected RequestSpecification spec;
    @BeforeMethod
    public void setSpec() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://fakerestapi.azurewebsites.net/api/v1")
                .build();
    }
}
