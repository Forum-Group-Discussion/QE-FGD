package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import starter.pages.HomePage;
import starter.pages.LoginPage;
import starter.pages.RegisterPage;

public class logoutSteps extends PageObject {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    String email = "kiyowo@gmail.com";
    String password ="Kiyowo1511";
    @Given("i am on homepage")
    public void iAmOnHomepage() throws InterruptedException {
        registerPage.openUrl();
        registerPage.clickButtonGetStarted();
        loginPage.inputFieldEmail(this.email);
        loginPage.inputFieldPassword(this.password);
        loginPage.clickButtonContinue();
        Thread.sleep(5000);
        homePage.validateDashboardAdmin();
    }

    @When("i click logout")
    public void iClickLogout() {

        homePage.clickLogoutButton();
        homePage.clickConfirmLogout();
    }

    @Then("i get landing page")
    public void iGetLandingPage() {
        registerPage.clickButtonGetStarted();
    }
}
