package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getEmailField () {
        return driver.findElement(By.id("email"));
    }
    public WebElement getPasswordField () {
        return driver.findElement(By.id("password"));
    }
    public WebElement getLoginButton () {
        return driver.findElement(By.className("v-btn__content"));
    }
    public void clickOnLoginButton () {
        getLoginButton().click();
    }

    public void clearPaswordAndEmailFields() {
        getPasswordField().clear();
        getEmailField().clear();
    }

    public void loginWithAdmincredentials () {
            clearPaswordAndEmailFields();
            getEmailField().sendKeys("admin@admin.com");
            getPasswordField().sendKeys("12345");
            clickOnLoginButton();
    }
    public void loginWithEmailAndPasword (String pasword, String email) {
        clearPaswordAndEmailFields();
        getEmailField().sendKeys(pasword);
        getPasswordField().sendKeys(email);
        clickOnLoginButton();
    }
}
