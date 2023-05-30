package post_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class ProjeDeneme {

    @Test
    public void proje01(){

//        Set the URL
        String url = "http://209.38.244.227/guestUser/register";

//        Set the expected data
        //{
        //  "birthDay": "yyyy-MM-dd",
        //  "birthPlace": "string",
        //  "gender": "MALE",
        //  "name": "string",
        //  "password": "string",
        //  "phoneNumber": "string",
        //  "ssn": "string",
        //  "surname": "string",
        //  "username": "string"
        //}

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("birthDay", "1965-03-05");
        expectedData.put("birthPlace", "Antalya");
        expectedData.put("gender", "MALE");
        expectedData.put("name", "hasan");
        expectedData.put("password", "12345678");
        expectedData.put("phoneNumber", "421-441-3658");
        expectedData.put("ssn", "821-25-7845");
        expectedData.put("surname", "yilmaz");
        expectedData.put("username", "hasan74170736");

        //System.out.println("expectedData = " + expectedData);

//        Send the request and get the response
        Response response = given().contentType(ContentType.JSON).when().body(expectedData).post(url);
        response.prettyPrint();

//        Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());//Status Code
        assertEquals(expectedData.get("birthDay"), actualData.get("birthDay"));
        assertEquals(expectedData.get("birthPlace"), actualData.get("birthPlace"));
        assertEquals(expectedData.get("gender"), actualData.get("gender"));
        assertEquals(expectedData.get("name"), actualData.get("name"));
        assertEquals(expectedData.get("password"), actualData.get("password"));
        assertEquals(expectedData.get("phoneNumber"), actualData.get("phoneNumber"));
        assertEquals(expectedData.get("ssn"), actualData.get("ssn"));
        assertEquals(expectedData.get("surname"), actualData.get("surname"));
        assertEquals(expectedData.get("username"), actualData.get("username"));
    }
}
