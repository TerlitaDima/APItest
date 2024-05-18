package tests;

import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static utils.Steps.GET;
import static utils.Steps.isStatusValid;

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


}
