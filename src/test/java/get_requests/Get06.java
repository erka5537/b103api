package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class Get06 extends HerOkuAppBaseUrl {
    /*
       Given
           https://restful-booker.herokuapp.com/booking/23
       When
           User send a GET request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response content type is "application/json"
       And
           Response body should be like;
{
   "firstname": "Josh",
   "lastname": "Allen",
   "totalprice": 111,
   "depositpaid": true,
   "bookingdates": {
       "checkin": "2018-01-01",
       "checkout": "2019-01-01"
   },
   "additionalneeds": "midnight snack"
}
     */
    @Test
    public void get06(){
        //Set the URL
        spec.pathParams("first","booking","second",23);

        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();


        //Do Assertion
        //1. Yol:
//        response.then().
//                statusCode(200).
//                contentType(ContentType.JSON).
//                body("firstname",equalTo("John"),
//                        "lastname",equalTo("Smith"),
//                        "totalprice", equalTo(111),
//                        "depositpaid",equalTo(true),
//                        "bookingdates.checkin",equalTo("2018-01-01"),
//                        "bookingdates.checkout",equalTo("2019-01-01"),
//                        "additionalneeds",equalTo( "Breakfast")
//                );
        //2. Yol: JsonPath ile
        JsonPath jsonPath = response.jsonPath();
//        Assert.assertEquals("Josh", jsonPath.getString("firstname"));
//        Assert.assertEquals("Allen", jsonPath.getString("lastname"));
//        Assert.assertEquals(111, jsonPath.getInt("totalprice"));
//        Assert.assertTrue(jsonPath.getBoolean("depositpaid"));
//        Assert.assertEquals("2018-01-01", jsonPath.getString("bookingdates.checkin"));
//        Assert.assertEquals("2019-01-01", jsonPath.getString("bookingdates.checkout"));
//        Assert.assertEquals("super bowls", jsonPath.getString("additionalneeds"));

        //3. Yol: TestNG Soft Assert
        //1. SoftAssert objesi oluştur
        SoftAssert softAssert = new SoftAssert();

        //2. Assertion
        softAssert.assertEquals(jsonPath.getString("firstname"), "Josh", "firstname uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("lastname"), "Allen", "lastname uyuşmadı");
        softAssert.assertEquals(jsonPath.getInt("totalprice"), 111, "totalprice uyuşmadı");
        softAssert.assertEquals(jsonPath.getBoolean("depositpaid"), true, "depositpaid uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkin"), "2018-01-01", "checkin uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkout"), "2019-01-01", "checkout uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("additionalneeds"), "midnight snack", "additionalneeds uyuşmadı");

        //3. softAssert.assertAll() diyerek doğrulamayı kontrol et. Aksi takdirde test hep "PASS" olur.
        softAssert.assertAll();
    }
}