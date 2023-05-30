package post_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ProjeDeneme2 {

    @Test
    public void proje02(){

//        Set the URL
        String url = "http://209.38.244.227/guestUser/register";

//        Set the expected data
        //{
        //  "date": "yyyy-MM-dd",
        //  "description": "string",
        //  "startTime": "HH:mm",
        //  "stopTime": "HH:mm",
        //  "studentIds": [
        //    0
        //  ]
        //}

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("date", "2023-05-06");
        expectedData.put("description", "planlama toplantisi");
        expectedData.put("startTime", "03:00");
        expectedData.put("stopTime", "05:00");
        expectedData.put("studentIds", "0");

        //System.out.println("expectedData = " + expectedData);

//        Send the request and get the response
        Response response = given().contentType(ContentType.JSON).when().body(expectedData).post(url);
        response.prettyPrint();


    }
}
