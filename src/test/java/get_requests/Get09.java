package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

public class Get09 extends HerOkuAppBaseUrl {

    /*
      Given
          https://restful-booker.herokuapp.com/booking/2279
      When
          I send GET Request to the url
      Then
          Response body should be like that;
           {
            "firstname": "John",
            "lastname": "Smith",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2018-01-01",
                "checkout": "2019-01-01"
            },
            "additionalneeds": "Breakfast"
            }
    */

    @Test
    public void get09(){

//        Set the URL
        spec.pathParams("first", "booking","second",2279);

//        Setthe expected data
        Map<String, String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin", "2018-01-01");
        bookingdatesMap.put("checkout", "2019-01-01");

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "John");
        expectedData.put("lastname", "Smith");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingdatesMap);
        expectedData.put("additionalneeds", "Breakfast");

//        Send the request and get the response
        Response response = RestAssured.given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

//        Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        Assert.assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        Assert.assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        Assert.assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        Assert.assertEquals(bookingdatesMap.get("checkin"),((Map)(actualData.get("bookingdates"))).get("checkin"));
        Assert.assertEquals(bookingdatesMap.get("checkout"),((Map)(actualData.get("bookingdates"))).get("checkout"));
        Assert.assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));


    }

    @Test//Dinamik Yöntem
    public void get09b(){

//        Set the URL
        spec.pathParams("first", "booking","second",794);

//        Setthe expected data
        HerOkuAppTestData herOkuAppTestData = new HerOkuAppTestData();

        Map<String, String> bookingdatesMap = herOkuAppTestData.bookingdatesMapMethod("2018-01-01", "2019-01-01");

        Map<String, Object> expectedData = herOkuAppTestData.expectedDataMethod("John","Smith",111,true,bookingdatesMap,"Breakfast");

//        Send the reques and get the response
        Response response = RestAssured.given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

//        Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        Assert.assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        Assert.assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        Assert.assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        Assert.assertEquals(bookingdatesMap.get("checkin"),((Map)(actualData.get("bookingdates"))).get("checkin"));
        Assert.assertEquals(bookingdatesMap.get("checkout"),((Map)(actualData.get("bookingdates"))).get("checkout"));
        Assert.assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));


    }
}
