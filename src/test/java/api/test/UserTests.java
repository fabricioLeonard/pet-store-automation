package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {

    Faker fakerUser;
    User userPayload;

    public Logger logger;

    @BeforeClass
    public void setupData(){
        fakerUser = new Faker();
        userPayload = new User();
        userPayload.setId(fakerUser.idNumber().hashCode());
        userPayload.setUsername(fakerUser.name().username());
        userPayload.setFirstName(fakerUser.name().firstName());
        userPayload.setLastName(fakerUser.name().lastName());
        userPayload.setEmail(fakerUser.internet().safeEmailAddress());
        userPayload.setPassword(fakerUser.internet().password(5,10));
        userPayload.setPhone(fakerUser.phoneNumber().cellPhone());

        //logs
        logger = LogManager.getLogger(this.getClass());
        logger.debug("debugging...");
    }

    @Test(priority = 1)
    public void testCreateUser() {
        logger.info("-> Creating User");
        Response response = UserEndPoints.createUser(userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("-> User is created");
    }

    @Test(priority = 2)
    public void testReadUserByName(){
        logger.info("-> Reading User Info");
        String userName = userPayload.getUsername();

        Response response = UserEndPoints.readUser(userName);
        response.then().log().all();
        logger.info("-> User is update ");
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 3)
    public void testUpdateUser() {
        logger.info("-> Updating User ");
        String userName = userPayload.getUsername();
        //Update data usgin payload
        userPayload.setFirstName(fakerUser.name().firstName());
        userPayload.setLastName(fakerUser.name().lastName());
        userPayload.setEmail(fakerUser.internet().safeEmailAddress());

        Response response = UserEndPoints.updateUser(userPayload, userName);
        response.then().log().body();
        logger.info("-> User  updated");
        Assert.assertEquals(response.getStatusCode(), 200);

        //Checking data after update
        Response responseAfterUpdate = UserEndPoints.readUser(userName);
        responseAfterUpdate.then().log().body();

        Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void testDeleteUserByName(){
        logger.info("-> Deleting User ");
        String userName = userPayload.getUsername();
        Response response = UserEndPoints.deleteUser(userName);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("-> User deleted");
    }

}
