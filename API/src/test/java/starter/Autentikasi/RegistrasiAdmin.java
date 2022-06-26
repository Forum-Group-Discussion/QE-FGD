package starter.Autentikasi;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import utils.General;

import java.io.FileWriter;
import java.io.IOException;

import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;

public class RegistrasiAdmin{
    String email;
    String name;
    String password;

    General general = new General();

    String base_url = "http://34.125.26.208/v1/";

    public String endpointAdminRegister(){
        return base_url + "auth/register";
    }

    public void requestDataRegisterAdmin(String name, String email ,String password, String adminStatus){
        Boolean.parseBoolean("true");
        JSONObject requestData = new JSONObject();

        if (name.equals("same")){
            this.name = "aduhaihsan";
        }else{
            this.name = name;
        }

        if (email.equals("same")){
            this.email = "real_akun@gmail.com";
        } else if(email.equals("adminfound@gmail.com")){
            this.email = general.randomEmail();
            try (FileWriter file = new FileWriter("src//test//resources//filejson//email.json")) {
                file.write(this.email);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(email.equals("adminfound")){
            this.email = email;
        }else{
            this.email = email;
        }



        if (password.equals("same")) {
            this.password = "aduhaIhsan1511";
        }else {
            this.password=password;
        }


        requestData.put("name", this.name);
        requestData.put("email", this.email);
        requestData.put("password", this.password);
        requestData.put("adminStatus",adminStatus);

        SerenityRest.given().header("Content-Type", "application/json")
                .body(requestData.toJSONString());
        SerenityRest.when().post(endpointAdminRegister());
    }

    public void verifyStatusCode(int status_code){
        then().statusCode(equalTo(status_code));
    }

    public void validateDataDetail(String response){
        if (response.equals("success")){
            SerenityRest.then().body("message", equalTo("SUCCESS"));
        }
    }

    public void errorMessageRequired(String errorRequired){
        if(errorRequired.equals("required")){
            then().body("message", equalTo("COLUMN_NOT_FILLED"));
        }
    }

    public void errorMessageExistUser(String errorExist){
        if(errorExist.equals("exist")){
            then().body("message", equalTo("USER_ALREADY_EXISTS"));
        }
    }

    public void errorMessageInvalid(String errorInvalid){
        if(errorInvalid.equals("invalid name")){
            then().body("message", equalTo("CHARACTER_LESS_THAN_4"));
        }
        else if(errorInvalid.equals("invalid email")){
            then().body("message", equalTo("EMAIL_NOT_VALID"));
        }
        else if(errorInvalid.equals("invalid password")){
            then().body("message", equalTo("CHARACTER_LESS_THAN_8"));
        }else{
            then().body("message", equalTo("FORMAT_EMAIL_WRONG"));
        }
    }







}
