package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestPojo;

public class Get13 extends GoRestBaseUrl {

    /*
    Given
        https://gorest.co.in/public/v1/users/247158
    When
        User send GET Request to the URL
    Then
        Status Code should be 200
    And
        Response body should be like
      {
        "meta": null,
        "data": {
            "id": 247158,
            "name": "Chandak Dutta",
            "email": "dutta_chandak@bartoletti.name",
            "gender": "female",
            "status": "inactive"
        }
    }
*/

    @Test
    public void get13(){

        //        Set the URL
        spec.pathParams("first", "users", "second", 247152);

//        Set the expected data
        GoRestDataPojo goRestDataPojo = new GoRestDataPojo("Ujjwal Bandopadhyay", "ujjwal_bandopadhyay@mueller-schoen.net", "male", "active");
        GoRestPojo expectedData = new GoRestPojo(null, goRestDataPojo);

//        Send the request and get the response
        Response response = RestAssured.given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

//        Do assertion
        GoRestPojo actualData = response.as(GoRestPojo.class);
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expectedData.getData().getName(), actualData.getData().getName());
        Assert.assertEquals(expectedData.getData().getEmail(), actualData.getData().getEmail());
        Assert.assertEquals(expectedData.getData().getGender(), actualData.getData().getGender());
        Assert.assertEquals(expectedData.getData().getStatus(), actualData.getData().getStatus());
    }
}
