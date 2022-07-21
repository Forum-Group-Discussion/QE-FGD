package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import starter.pages.HomePage;

import starter.pages.LoginPage;
import starter.pages.RegisterPage;


public class loginSteps{
    RegisterPage registerPage;
    LoginPage loginPage;
    HomePage homePage;

    @Given("i have registered")
    public void iHaveRegistered() {
        registerPage.openUrl();

    }


    @And("i input {string} and {string} for login")
    public void iInputAndForLogin(String email, String password) {
        loginPage.inputFieldEmail(email);
        loginPage.inputFieldPassword(password);
    }

    @And("i click continue button for login")
    public void iClickContinueButtonForLogin() {
        loginPage.clickButtonContinue();
    }

    @Then("i get my {string} after login")
    public void iGetMyAfterLogin(String result)throws InterruptedException{
        if(result.equals("home page")){
            homePage.validateAlertSuccesful(result);
        } else if(result.equals("login page")) {
            loginPage.validateFormLoginAppeared();
        }else{
            Thread.sleep(1000);
            loginPage.showErrorMessage();
        }
    }
}
