package starter.Users;

import net.serenitybdd.rest.SerenityRest;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.equalTo;

public class GetUsersById {
    private String token;
    String base_url = "http://34.125.26.208/v1/";

    public String endpointGetUserById(String user_id){
        return base_url + "user/" + user_id;
    }

    public void requestGetUserById(String user_id) throws IOException {
        token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//tokens.json"), StandardCharsets.UTF_8);
        SerenityRest.given().header("Authorization", "Bearer " + token);
        SerenityRest.when().get(endpointGetUserById(user_id));
    }

    public void validateDataDetail(){
        SerenityRest.then().body("data.id", equalTo(11));
    }

    public void validateErrorMessage(String result){
        if (result.equals("not authorized")){
            SerenityRest.then().body("message",equalTo("DATA_NOT_FOUND"));
        } else if(result.equals("bad request")){
            SerenityRest.then().body("error",equalTo("Bad Request"));
        } else if(result.equals("method not allowed")){
            SerenityRest.then().body("error",equalTo("Method Not Allowed"));
        }

    }

    public void requestGetUserByIdwWithNoToken(String user_id) {
        SerenityRest.when().get(endpointGetUserById(user_id));
    }

    public void requestUserWithPostMethod(String user_id) throws IOException {
        token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//tokens.json"), StandardCharsets.UTF_8);
        SerenityRest.given().header("Authorization", "Bearer " + token);
        SerenityRest.when().post(endpointGetUserById(user_id));
    }

    public void validateMethodNotAllowed(){
        SerenityRest.then().body("error",equalTo("Method Not Allowed"));
    }



}
