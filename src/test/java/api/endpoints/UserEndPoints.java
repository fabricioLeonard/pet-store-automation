package api.endpoints;


import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

//UserEndPoints.java
//Create for perform Create, Read, Update, Delete requests the user API.
public class UserEndPoints {

    public static Response createUser(User payload){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.createURL);
        return response;
    }

    public static Response readUser(String userName){
        Response response = given()
                .pathParam("username", userName)
                .when()
                .get(Routes.readURL);
        return response;
    }

    public static Response updateUser(User payload, String userName){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", userName)
                .body(payload)
                .when()
                .put(Routes.updateURL);
        return response;
    }

    public static Response deleteUser(String userName){
        Response response = given()
                .pathParam("username", userName)
                .when()
                .delete(Routes.deleteURL);
        return response;
    }
}
