package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;

public class Get11 extends GoRestBaseUrl {

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
    public void get11(){
//        Set the URL
        spec.pathParam("first", "users");

//        Set the expected data

//        Send the request and get the response
        Response response = RestAssured.given().spec(spec).get("/{first}");
        response.prettyPrint();

//        Do assertion
        response.then().statusCode(200)
                .body("meta.pagination.limit", equalTo(10)
                ,"meta.pagination.links.current", equalTo("https://gorest.co.in/public/v1/users?page=1")
                ,"data", hasSize(10)
                ,"data.status", hasItem("active")
                ,"data.name", hasItems("Lal Mahajan", "Vaijayanti Khatri", "Charuvrat Kocchar V"));
//        Kadın ve erkek sayılarını karşılaştıralım
//        1. Yol:
        JsonPath jsonPath = response.jsonPath();
        List<String> genders = jsonPath.getList("data.gender");
        int kadinSayisi = 0;
        for(String w : genders){
            if(w.equals("female")){
                kadinSayisi++;
            }
        }
        Assert.assertTrue(kadinSayisi<=genders.size()-kadinSayisi);

//        2. Yol: Groovy / Kadın ve erkek sayılarını karşılaştıralım
        List<String> kadinList = jsonPath.getList("data.findAll{it.gender=='female'}.gender");
        List<String> erkekList = jsonPath.getList("data.findAll{it.gender=='male'}.gender");

        Assert.assertTrue(kadinList.size()<=erkekList.size());
    }
}
