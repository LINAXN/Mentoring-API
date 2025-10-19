package tests;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C05_JsonPathReqres extends ReqresBaseUrl {

    /*

**1. URL:**
`https://reqres.in/api/unknown/3`

**2. Test Steps:**
* **Given:** The API endpoint URL.
* **When:** A `GET` request is sent to the URL.
* **Then:**(Assert just data)
{
    "data": {
        "id": 3,
        "name": "true red",
        "year": 2002,
        "color": "#BF1932",
        "pantone_value": "19-1664"
    },
    "support": {
        "url": "https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral",
        "text": "Tired of writing endless social media content? Let Content Caddy generate it for you."
    },
    "_meta": {
        "powered_by": "🚀 ReqRes - Deploy backends in 30 seconds",
        "upgrade_url": "https://app.reqres.in/upgrade",
        "docs_url": "https://reqres.in",
        "template_gallery": "https://app.reqres.in/templates",
        "message": "This API is powered by ReqRes. Deploy your own backend in 30 seconds!",
        "features": [
            "30 Second Backend Templates",
            "Custom API Endpoints",
            "Data Persistence",
            "Real-time Analytics"
        ],
        "upgrade_cta": "Upgrade to Pro for unlimited requests, custom endpoints, and data persistence"
    }
}
     */

    @Test
    void C05_JsonPathReqresTest() {

        //Send the request
        Response response = given(spec).get("https://reqres.in/api/users");
        response.prettyPrint();

        //Do assertion
        JsonPath jsonPath = response.jsonPath();

        String name = jsonPath.getString("data.name");
        int year = jsonPath.getInt("data.year");
        String color = jsonPath.getString("data.color");
        String pantone_value = jsonPath.getString("data.pantone_value");

        assertEquals(response.statusCode(), 200);
        assertEquals(name, "true red");
        assertEquals(year, 2002);
        assertEquals(color, "#BF1932");
        assertEquals(pantone_value, "19-1664");

    }
}
