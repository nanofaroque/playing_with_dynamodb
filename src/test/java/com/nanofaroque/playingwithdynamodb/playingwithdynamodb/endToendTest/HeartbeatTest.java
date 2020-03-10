package com.nanofaroque.playingwithdynamodb.playingwithdynamodb.endToendTest;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

public class HeartbeatTest {
    @Test
    public void heartbeat_returns_200_with_expected_message() {

        String url="http://localhost:8080";
        when().
                get(url+"/heartbeat").
                then().
                statusCode(200)
                .body("id",equalTo("1"));
                //body("hello from heartbeat", equalTo("hello from heartbeat"));
    }

    @Test
    public void makeSureThatGoogleIsUp() {
        given().when().get("http://www.google.com").then().statusCode(200);
    }
}
