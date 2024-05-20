package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static utils.Steps.*;

public class TestReqres {

    @BeforeSuite
    public void setUp(){
        baseURI = "https://reqres.in/api";
    }

    @Test
    public void testListUser(){

        String url = "users?page=2";

        Response response = GET(url);

        isStatusValid(response, 200);

    }
    @Test
    public void getSigleUser(){
        String url = "/users/2";

        Response response = GET(url);

        isStatusValid(response, 200);
}

    @Test
    public void testCreate(){

        String url = "/users";
        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        Response response = POST(body, url);

        isStatusValid(response, 201);

    }

//    public static void isBodyContains(Response response, String expectedData, String expectedField){
//        response.then().assertThat().body(actu, equalTo())
//
//    }


}
