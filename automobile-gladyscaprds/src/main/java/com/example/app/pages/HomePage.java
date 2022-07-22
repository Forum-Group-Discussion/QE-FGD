package com.example.app.pages;

import com.example.app.base.BasePageObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class HomePage extends BasePageObject {
    By homePageText(){
        return By.xpath("//android.view.View[1]/android.widget.ImageView");
    }

    By iconAccount(){
        return By.xpath("//android.view.View[@content-desc=\"Tab 5 of 5\"]");
    }

    By editProfile(){
        return By.xpath("//android.view.View[@content-desc=\"Edit Profile\"]");
    }


    public void validateHomePageAppear()throws Exception{
        Assertions.assertTrue(isDisplayed(homePageText()));
        Thread.sleep(3000);
    }

    public void clickIconAccount(){
        click(iconAccount());
    }

    public void clickEditProfile(){
        click(editProfile());
    }


}
