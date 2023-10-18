package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.util.RetryAnalyzerCount;

public class LoginTests extends BasicTest {

    @Test
    public void visitsLoginPage (){
     navPage.selectEnglishLanguageFromLanguagesDropDownMenu();
     navPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login");
    }
    @Test
    public void checksInputTypes () {
        navPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getEmailField().getAttribute("type"), "email");
        Assert.assertEquals(loginPage.getPasswordField().getAttribute("type"), "password");
    }
    @Test
    public void displaysErrorsWhenUserDoesNotExist () {
        navPage.clickOnLoginButton();
        loginPage.loginWithEmailAndPasword("non-existing-user@gmal.com", "password123");
        messagePopUpPage.waitPopUptoBeVisible();
        Assert.assertEquals(messagePopUpPage.getTextInsidePopUp(),"User does not exists");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login");
    }
    @Test
    public void dispaysErrorsWhenPasswordIsWrong () {
        navPage.clickOnLoginButton();
        loginPage.loginWithEmailAndPasword("admin@admin.com", "password123");
        messagePopUpPage.waitPopUptoBeVisible();
        Assert.assertEquals(messagePopUpPage.getTextInsidePopUp(),"Wrong password");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login");
    }
    @Test
    public void login() throws InterruptedException {
        navPage.clickOnLoginButton();
        loginPage.loginWithAdmincredentials();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/home");
    }

    @Test
    public void logout() throws InterruptedException {
        login();
        navPage.clickOnLogoutButton();
    }

}
