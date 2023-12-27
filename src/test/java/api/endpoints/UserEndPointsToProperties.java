package api.endpoints;


import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

//UserEndPoints.java
//Create for perform Create, Read, Update, Delete requests the user API.
public class UserEndPointsToProperties {

    //methos create for getting URL's from properties file
    private static ResourceBundle getURL() {
        ResourceBundle routes = ResourceBundle.getBundle("routes"); //Load properties file
        return routes;
    }

    public static Response createUser(User payload) {

        String createURL= getURL().getString("post_url");

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(createURL);
        return response;
    }

    public static Response readUser(String userName) {
        String readURL= getURL().getString("get_url");
        Response response = given()
                .pathParam("username", userName)
                .when()
                .get(readURL);
        return response;
    }

    public static Response updateUser(User payload, String userName) {
        String updateURL= getURL().getString("update_url");
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", userName)
                .body(payload)
                .when()
                .put(updateURL);
        return response;
    }

    public static Response deleteUser(String userName) {
        String deleteURL= getURL().getString("delete_url");
        Response response = given()
                .pathParam("username", userName)
                .when()
                .delete(deleteURL);
        return response;
    }
}

