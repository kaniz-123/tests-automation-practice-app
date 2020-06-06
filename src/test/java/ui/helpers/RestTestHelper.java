package ui.helpers;


import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestTestHelper {
    public static Response postClient(String username, String password, String url, String addEmployeeBody) {
        return given()
                .auth().basic(username, password)
                .contentType("application/json")
                .body(addEmployeeBody)
                .post(url)
                .then()
                .extract()
                .response();
    }

    public static Response getClient(String username, String password, String url) {
        return given()
                .auth().basic(username, password)
                .contentType("application/json")
                .get(url)
                .then()
                .extract()
                .response();
    }
}
