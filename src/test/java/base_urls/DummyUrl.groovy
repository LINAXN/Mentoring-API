package base_urls

import io.restassured.builder.RequestSpecBuilder
import io.restassured.specification.RequestSpecification
import org.testng.annotations.BeforeMethod

class DummyUrl {
    protected RequestSpecification spec;

    @BeforeMethod
    public void setSpec() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://dummy.restapiexample.com")
                .build();
    }
}
