package com.example.steps;

import com.example.app.pages.HomePage;
import com.example.app.pages.LoginPage;
import com.example.app.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class registerStep {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    RegisterPage registerPage = new RegisterPage();

    @Given("i am on landing page")
    public void iAmOnLandingPage(){
     registerPage.validateLandingPage();
    }

    @When("i click icon account and register")
    public void iClickIconAccountAndRegister() throws InterruptedException {
        registerPage.clickSignUpButton();
    }

    @And("i input {string} my name")
    public void iInputMyName(String username) throws Exception {
      registerPage.inputUsername(username);
    }

    @And("i input {string} my email")
    public void iInputMyEmail(String email)throws Exception {
        registerPage.inputEmail(email);

    }

    @And("i input {string} my password")
    public void iInputMyPassword(String password)throws Exception{
        registerPage.inputPassword(password);
    }

    @And("i input {string}")
    public void iInput(String confirm) throws InterruptedException {
        registerPage.inputConfirmPassword(confirm);
    }

    @And("i click register button")
    public void iClickRegisterButton() {
        registerPage.clickButtonRegister();

    }

    @Then("i get my {string}")
    public void iGetMy(String result) throws Exception {
        if(result.equals("new user")){
           loginPage.validateloginTextAppeared();
        }else if(result.equals("register page")){
            registerPage.validateSignUpFormAppeared();
        }
    }


}
