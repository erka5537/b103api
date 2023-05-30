package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.Map;

public class Get10 extends GoRestBaseUrl {
    /*

        Given
            https://gorest.co.in/public/v1/users/128529
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
            /*
 {
    "meta": null,
    "data": {
        "id": 128529,
        "name": "Anamika Joshi",
        "email": "anamika_joshi@corkery-ritchie.info",
        "gender": "male",
        "status": "active"
    }
}
     */

    @Test
    public void get10(){

//        Set the URL
        spec.pathParams("first","users", "second", 128529);

//        Send expected data
        GoRestTestData goRestTestData = new GoRestTestData();
        Map<String, String> dataMap = goRestTestData.dataMap("Anamika Joshi", "anamika_joshi@corkery-ritchie.info", "male", "active");
        Map<String, Object> expectedData = goRestTestData.expectedDataMethod(null, dataMap);

//        Send the request and get the response
        Response response = RestAssured.given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();



    }
}