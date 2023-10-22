package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.util.RetryAnalyzerCount;
import retry.RetryAnalyzer;

public class LoginTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsLoginPage (){
     navPage.selectEnglishLanguageFromLanguagesDropDownMenu();
     navPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login");
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes () {
        navPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getEmailField().getAttribute("type"), "email");
        Assert.assertEquals(loginPage.getPasswordField().getAttribute("type"), "password");
    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserDoesNotExist () {
        navPage.clickOnLoginButton();
        loginPage.loginWithEmailAndPasword("non-existing-user@gmal.com", "password123");
        messagePopUpPage.waitPopUptoBeVisible();
        Assert.assertEquals(messagePopUpPage.getTextInsidePopUp(),"User does not exists");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login");
    }
    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void dispaysErrorsWhenPasswordIsWrong () {
        navPage.clickOnLoginButton();
        loginPage.loginWithEmailAndPasword("admin@admin.com", "password123");
        messagePopUpPage.waitPopUptoBeVisible();
        Assert.assertEquals(messagePopUpPage.getTextInsidePopUp(),"Wrong password");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login");
    }
    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void login() throws InterruptedException {
        navPage.clickOnLoginButton();
        loginPage.loginWithAdmincredentials();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/home");
    }
    @Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void logout() throws InterruptedException {
        navPage.clickOnLogoutButton();
    }

}
