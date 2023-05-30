package post_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

public class Post02 extends HerOkuAppBaseUrl {

    /*
        Given
            1) https://restful-booker.herokuapp.com/booking
            2) {
                 "firstname": "John",
                 "lastname": "Doe",
                 "totalprice": 11111,
                 "depositpaid": true,
                 "bookingdates": {
                     "checkin": "2021-09-09",
                     "checkout": "2021-09-21"
                  }
               }
        When
            I send POST Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                                "bookingid": 5315,
                                                "booking": {
                                                    "firstname": "John",
                                                    "lastname": "Doe",
                                                    "totalprice": 11111,
                                                    "depositpaid": true,
                                                    "bookingdates": {
                                                        "checkin": "2021-09-09",
                                                        "checkout": "2021-09-21"
                                                    }
                                                }
                                             }
     */

    @Test
    public void post04(){

//        Set the URL
        spec.pathParam("first", "booking");

//        Set the expected data
        HerOkuAppTestData herOkuAppTestData = new HerOkuAppTestData();
        Map<String, String> bookingDatesMap = herOkuAppTestData.bookingdatesMapMethod("2021-09-09", "2021-09-21");
        Map<String, Object> expectedData = herOkuAppTestData.expectedDataMethod(
                                            "John"
                                            , "Doe"
                                            ,11111
                                            ,true
                                            ,bookingDatesMap
                                            ,null);

//        Send request and get the response
        Response response = RestAssured.given().spec(spec).body(expectedData).post("{first}");
        response.prettyPrint();

//        Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expectedData.get("firstname"), ((Map)actualData.get("booking")).get("firstname"));
        Assert.assertEquals(expectedData.get("lastname"), ((Map)actualData.get("booking")).get("lastname"));
        Assert.assertEquals(expectedData.get("totalprice"), ((Map)actualData.get("booking")).get("totalprice"));
        Assert.assertEquals(expectedData.get("depositpaid"), ((Map)actualData.get("booking")).get("depositpaid"));
        Assert.assertEquals(bookingDatesMap.get("checkin"), ((Map)(((Map)actualData.get("booking")).get("bookingdates"))).get("checkin"));
        Assert.assertEquals(bookingDatesMap.get("checkout"), ((Map)(((Map)actualData.get("booking")).get("bookingdates"))).get("checkout"));

    }
}