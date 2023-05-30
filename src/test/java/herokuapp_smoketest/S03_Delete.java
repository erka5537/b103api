package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static herokuapp_smoketest.S01_Post.bookingId;
import static util.AuthenticationHerOkuApp.generateToken;

public class S03_Delete extends HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/{id}
    When
        Send delete request
    And
        Body should be like "Created"
    */
    @Test
    public void delete01(){
//        Set the URL
        spec.pathParams("first", "booking", "second", bookingId);

//        Set the expected data
        String expectedData = "Created";
//        Send the request and get the response
        Response response = RestAssured.given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

//        Do assertion
        Assert.assertEquals(201, response.statusCode());
        Assert.assertEquals(expectedData, response.asString());
    }
}
