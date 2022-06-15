package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;


public class LoginPage extends PageObject {


    RegisterPage registerPage = new RegisterPage();
    private By loginForm(){
        return By.xpath("//*[@id=\"root\"]/div/div/h1");
    }
    private By fieldEmail(){
        return By.xpath("//*[@name=\"email\"]");
    }

    private By fieldPassword(){
        return By.xpath("//*[@name=\"password\"]");
    }

    private By buttonContinue(){
        return By.id("loginBtn");
    }

    private By errorMessageWrong(){
        return By.id("swal2-title");
    }

    @Step
    public void validateFormLoginAppeared(){
        $(loginForm()).isDisplayed();
    }

    @Step
    public void inputFieldEmail(String email){
        $(fieldEmail()).type(email);
    }

    @Step
    public void inputFieldPassword(String password){
        $(fieldPassword()).type(password);
    }

    @Step
    public void clickButtonContinue(){
        $(buttonContinue()).click();
    }

    @Step
    public void showErrorMessage(){
        $(errorMessageWrong()).isDisplayed();
    }


}
