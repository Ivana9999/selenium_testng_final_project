package tests;

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
        loginPage.loginWithEmailAndPasword("password123", "non-existing-user@gmal.com");
        messagePopUpPage.waitPopUptoBeVisible();
        Assert.assertEquals(messagePopUpPage.getTextInsidePopUp(),"User does not exists");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login");
    }
    @Test
    public void dispaysErrorsWhenPasswordIsWron () {

    }
}
