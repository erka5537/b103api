package put_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiResponseBodyPojo;
import util.ObjectMapperUtils;

public class Put02 extends DummyRestApiBaseUrl {

    /*
        URL: https://dummy.restapiexample.com/api/v1/update/21
       HTTP Request Method: PUT Request
       Request body: {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }
     */

    @Test
    public void put02(){

//        Set the URL
        spec.pathParams("first", "update", "second", 21);

//        Set the expected data
        DummyRestApiDataPojo expectedData = new DummyRestApiDataPojo("Ali Can", 111111, 23, "Perfect image");
        DummyRestApiResponseBodyPojo expectedBodyPojo = new DummyRestApiResponseBodyPojo("success", expectedData, "Successfully! Record has been updated.");
//        expectedBodyPojo objesini actualData ile karşılaştırarak assetion yapmak için oluşturduk

//        Send the request and get the response
        Response response = RestAssured.given().spec(spec).when().body(expectedData).put("/{first}/{second}");
        response.prettyPrint();

//        Do assertion
        DummyRestApiResponseBodyPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), DummyRestApiResponseBodyPojo.class);
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expectedBodyPojo.getStatus(), actualData.getStatus());
        Assert.assertEquals(expectedBodyPojo.getMessage(), actualData.getMessage());

        Assert.assertEquals(expectedData.getEmployee_name(), actualData.getData().getEmployee_name());
        Assert.assertEquals(expectedData.getEmployee_salary(), actualData.getData().getEmployee_salary());
        Assert.assertEquals(expectedData.getEmployee_age(), actualData.getData().getEmployee_age());
        Assert.assertEquals(expectedData.getProfile_image(), actualData.getData().getProfile_image());
    }
}
