package get_requests;


import io.restassured.RestAssured;
import static io.restassured.RestAssured.get;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RequestResponse {
    /*
    1) Postman manuel API testi için kullanılır.
    2) API otomasyonu için Rest Assured Library
    3) Otomasyon kodlarının yazımı için şu adımları izliyoruz:
        a) Gereksinimleri anlama
        b) Test Case'i yazma:
            -Test Case'i yazmak için "Gherkin Language" kullanıyoruz.
            x) Given: Ön Koşullar --> Endpoint, body
            y) When: İşlemler --> Get, Put, Delete ...
            z) Then: Dönütler --> Assert
            t) And: Çoklu işlemlerin art arda yazılacağı yerlerde kullanılır.
        c) Test kodunu yazarken şu adımları izleriz:
            i)    Set the URL
            ii)   Set the expected data
            iii)  Send the request and get the response
            iv)   Do assertion
    */

    public static void main(String[] args) {

//        Get request nasıl yapılır:
        String url = "https://restful-booker.herokuapp.com/booking/55";
        Response response = get(url);
        response.prettyPrint();//prettyPrint() methodu response datayı yazdırır.

//        Status Code nasıl yazdırılır:
        System.out.println("Status Code: " + response.getStatusCode());

//        Content Type nasıl yazdırılır:
        System.out.println("Content Type: " + response.contentType());

//        Status Line nasıl yazdırılır:
        System.out.println("Status Line: " + response.statusLine());

//        Header nasıl yazdırılır:
        System.out.println(response.header("Connection"));
        System.out.println(response.header("Server"));

//        Headers nasıl yazdırılır:
        System.out.println(response.headers());

//        Time nasıl yazdırılır:
        System.out.println("Time: " + response.getTime());
    }
}
