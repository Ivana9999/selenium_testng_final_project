package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{

    @Test
    public void visitsTheSignupPage () throws InterruptedException {
        navPage.clickOnSingUpButton();
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "/signup");
    }
    @Test
    public void checksInputTypes () {
        navPage.clickOnSingUpButton();
        Assert.assertEquals(signupPage.getFieldForEmailInput().getAttribute("type"), "email");
        Assert.assertEquals(signupPage.getFieldForPasswordInput().getAttribute("type"), "password");
        Assert.assertEquals(signupPage.getFieldForConfirmPassword().getAttribute("type"), "password");

    }
    @Test
    public void displaysErrorsWhenUserAlreadyExists () {
        navPage.clickOnSingUpButton();
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "/signup");
        signupPage.signUpWithNameEmailAndPassword("Another user", "admin@admin.com", "12345");
        messagePopUpPage.waitPopUptoBeVisible();
        Assert.assertEquals(messagePopUpPage.getTextInsidePopUp(),"E-mail already exists");
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "/signup");
    }
    @Test
    public void signUp () throws InterruptedException {
        navPage.clickOnSingUpButton();
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "/signup");
        signupPage.signUpWithNameEmailAndPassword("Ivana Ivkov", "ivadnaa.adsivkov@itbootcamp.rs", "12345");
        Thread.sleep(2000);
        Assert.assertEquals(signupPage.getVerifyAccountPopUp().getText(),"IMPORTANT: Verify your account");
        signupPage.clickOnCloseButtonForVerifyAccountPopup();
    }
}
