package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class HomePage extends PageObject {
    private By loginSuccesfullAlert(){
        return By.xpath("//h2[text()='Login is successful']");
    }

    @Step
    public void validateAlertSuccesful(){
        $(loginSuccesfullAlert()).isDisplayed();
    }
}
