package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class HomePage extends PageObject {

    String dashboardText = "Admin Page, Welcome  ";

    private By loginSuccesfullAlert(){
        return By.xpath("//h2[text()='Login is successful']");
    }

    private By dashboardAdmin(){
        return By.xpath("//div[contains(text(), 'Admin Page, Welcome ')]");
    }

    private By logoutButton(){
        return By.xpath("//*[@value=\"Logout\"]");
    }

    private By confirmLogout(){
        return By.xpath("//button[contains(@class, 'swal2-confirm swal2-styled swal2-default-outline') and contains(text(), 'Yes, Logout!')]");
    }

    @Step

    public boolean validateAlertSuccesful(String text){
        return $(loginSuccesfullAlert()).getText().equals(text);
    }
    public boolean validateDashboardAdmin(){
        return $(dashboardAdmin()).getText().equals(this.dashboardText);
    }

    public void clickLogoutButton(){
        $(logoutButton()).click();
    }

    public void clickConfirmLogout(){
        $(confirmLogout()).click();
    }

}
