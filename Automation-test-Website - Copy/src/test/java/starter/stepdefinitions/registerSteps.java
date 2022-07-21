package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import starter.pages.LoginPage;
import starter.pages.RegisterPage;


public class registerSteps{
    RegisterPage registerPage;
    LoginPage loginPage;

    @Given("i access the web")
    public void iAccessTheWeb() {
        registerPage.openUrl();
    }

    @When("i click get started")
    public void iClickGetStarted() {
        registerPage.clickButtonGetStarted();
    }

    @And("i click sign up")
    public void iClickSignUp() {
        registerPage.clickSignUpLink();
        registerPage.validateSignUpFormAppeared();
    }

    @And("i input {string} and {string} and {string} and {string}")
    public void iInputAndAndAnd(String username, String email, String password, String confirmPass) {
        registerPage.inputFieldUsername(username);

        if(email.equals("null")){
            registerPage.inputFieldEmailNull(email);
        }else{
        registerPage.inputFieldEmail(email);
        }
        registerPage.inputFieldPassword(password);
        registerPage.inputFieldConfirmPassword(confirmPass);
    }

    @And("i click continue button")
    public void iClickContinueButton() {
        registerPage.clickButtonContinue();
    }

    @Then("i get my {string}")
    public void iGetMy(String result) {
        if(result.equals("new user")){
            loginPage.validateFormLoginAppeared();
        }else{
            registerPage.registerFormAppeared();
            registerPage.displayErrorMessage(result);
        }
    }
}
