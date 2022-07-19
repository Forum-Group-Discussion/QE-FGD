package com.example.app.pages;

import com.example.app.base.BasePageObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utils.General;

import java.io.FileWriter;
import java.io.IOException;


public class RegisterPage extends BasePageObject {
    General general = new General();
    String input;

    By landingPage(){
        return By.xpath("//android.view.View[@content-desc=\"Hello!\"]");
    }

    By signUpForm(){
      return By.xpath("//android.view.View[@content-desc=\"Sign Up\"]");

    }

    By signUpButton(){
        return By.xpath("//android.widget.Button[@content-desc=\"Sign Up\"]");
    }

    By fieldUsername(){
        return By.xpath("//android.widget.EditText[1]");
    }

    By fieldEmail(){
        return By.xpath("//android.widget.EditText[2]");
    }

    By fieldPassword(){
        return By.xpath("//android.widget.EditText[3]");
    }

    By fieldConfirm(){
        return By.xpath("//android.widget.EditText[4]");
    }

    By submitForm(){
        return By.xpath("//android.widget.Button[@content-desc=\"Sign Up\"]");
    }

    public void validateLandingPage(){
        Assertions.assertTrue(isDisplayed(landingPage()));
    }

    public void validateSignUpFormAppeared(){
        Assertions.assertTrue(isDisplayed(signUpForm()));
    }


    public void clickSignUpButton() throws InterruptedException {
        Thread.sleep(5000);
        Assertions.assertTrue(isDisplayed(signUpButton()));
        click(signUpButton());

    }

    public void inputUsername(String input) throws InterruptedException {
        click(fieldUsername());
        Thread.sleep(3000);
        sendKeys(fieldUsername(),input);

    }

    public void inputEmail(String input) throws InterruptedException {
        click(fieldEmail());
        if (input.equals("same")){
            this.input = "sonyaprds@gmail.com";
        } else{
            this.input = general.randomEmail();
            try (FileWriter file = new FileWriter("src//main//resources//filejson//email.json")) {
                file.write(this.input);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Thread.sleep(5000);
        sendKeys(fieldEmail(),this.input);
    }

    public void inputPassword(String input) throws InterruptedException {
        click(fieldPassword());
        Thread.sleep(3000);
        sendKeys(fieldPassword(),input);
    }

    public void inputConfirmPassword(String input) throws InterruptedException {
        click(fieldConfirm());
        Thread.sleep(3000);
        sendKeys(fieldConfirm(),input);
    }

    public void clickButtonRegister(){
        click(submitForm());
    }













}
