package patch_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

public class Patch01 extends JsonPlaceHolderBaseUrl {

    /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "title": "Wash the dishes"
               }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198
									    }
     */

    @Test
    public void patch01(){

//        Set the URL
        spec.pathParams("first", "todos", "second", 198);

//        Set the expected data
        JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();
        Map<String, Object> expectedData = jsonPlaceHolderTestData.expectedDataMethod(null,"Wash the dishes", null);

//        Send the request and get the response
        Response response = RestAssured.given().spec(spec).body(expectedData).patch("/{first}/{second}");
        response.prettyPrint();

//        Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expectedData.get("title"), actualData.get("title"));

        //Eğer tüm body assert edilecekse:
        Assert.assertEquals(10, actualData.get("userId"));
        Assert.assertEquals(true, actualData.get("completed"));
    }
}