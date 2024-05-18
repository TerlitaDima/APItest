package utils;

import io.qameta.allure.Allure;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;

public class Steps {

    public static Response GET(String endpoint){

        Allure.addAttachment("URL", baseURI + endpoint);

        Response response =  get(endpoint);

        Allure.addAttachment("Response body", response.body().prettyPrint());

        Allure.addAttachment("Status Code", String.valueOf(response.statusCode()));

        return response;
    }

    public static void isStatusValid(Response response, int expectedStaus){
        response.then().assertThat().statusCode(expectedStaus);
    }

}
