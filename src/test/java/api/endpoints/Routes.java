package api.endpoints;

/*
 * Swagger URI --> https://petstore.swagger.io
 *
 * Create user (Post): https://petstore.swager.io/v2/user
 * Get user (Get): https://petstore.swager.io/v2/user/{username}
 * Update user (Put): https://petstore.swager.io/v2/user/{username}
 * Delete user (Delete): https://petstore.swager.io/v2/user/{username}
 *
*/

public class Routes {

    public static String baseUrl = "https://petstore.swagger.io/v2";

    //User module
    public static String createURL = baseUrl + "/user";
    public static String readURL = baseUrl + "/user/{username}";
    public static String updateURL = baseUrl + "/user/{username}";
    public static String deleteURL = baseUrl + "/user/{username}";

    //Store module
        //Here you will create Store module URL's
    //Pet module
        //Here you will create Pet module URL's


}
