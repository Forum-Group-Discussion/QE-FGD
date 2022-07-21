package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import utils.General;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterPage extends PageObject {
    LoginPage loginPage;
    General general = new General();
    String username;
    String email;
    String password;

    private By landingPageAppeared(){
        return By.id("nav-logo");
    }

    private By buttonGetStarted(){
        return By.xpath("//a[text()='Get Started']");
    }

    private By signUpLink(){
        return By.xpath("//a[text()='Sign Up']");
    }

    private By signUpForm(){
        return By.xpath("//h1[text()='Sign Up']");
    }

    private By fieldUsername(){
        return By.xpath("//*[@name=\"name\"]");
    }

    private By fieldEmail(){
        return By.xpath("//*[@id='email']");
    }

    private By fieldPassword(){
        return By.xpath("//*[@name=\"password\"]");
    }

    private By fieldConfirmPassword(){
        return By.xpath("//*[@name=\"confirmpassword\"]");
    }

    private By continueButton(){
        return By.id("registerBtn");
    }

    private By errorMatchingEmail(){
        return By.xpath("//*[span[text()='Email format does not match']]");
    }

    @Step
    public void openUrl(){
        openUrl("https://found-capstone20.netlify.app/");
    }

    @Step
    public void clickButtonGetStarted(){
        $(landingPageAppeared()).isDisplayed();
        $(buttonGetStarted()).click();
    }

    @Step
    public void validateSignUpFormAppeared(){
        $(signUpForm()).isDisplayed();
    }

    @Step
    public void clickSignUpLink(){
        $(signUpLink()).click();
    }

    @Step
    public void inputFieldUsername(String username){
        if(username.equals("same")){
            this.username = "adminfound";
        } else if(username.equals("sonyaprds")){
            this.username = general.randomUsername();
            try (FileWriter file = new FileWriter("src//test//resources//filejson//username.json")) {
                file.write(this.username);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            this.username = "";

        }
        $(fieldUsername()).type(this.username);

    }

    @Step
    public void inputFieldEmail(String email){
            this.email = general.randomEmail();
        $(fieldEmail()).type(this.email);
    }

    @Step
    public void inputFieldEmailNull(String email){
        this.email = " ";
        $(fieldEmail()).type(this.email);
    }


    @Step
    public void inputFieldPassword(String password){
        if (password.equals("same")){
            this.password = "adminFound1511";
        } else if (password.equals("SonyaPrds1511")){
            this.password = "SonyaPrds1511";
        }else{
            this.password = "";
        }
        $(fieldPassword()).type(this.password);
    }

    @Step
    public void inputFieldConfirmPassword(String confirmPass){
        $(fieldConfirmPassword()).type(confirmPass);
    }

    @Step
    public void clickButtonContinue(){
        $(continueButton()).click();
    }

    @Step
    public void registerFormAppeared(){
        $(signUpForm()).isDisplayed();
    }

    @Step
    public void displayErrorMessage(String alert){
        if(alert=="Email format does not match"){
            $(errorMatchingEmail()).isDisplayed();
        }
        else{
            $(signUpForm()).isDisplayed();
        }
    }





}
