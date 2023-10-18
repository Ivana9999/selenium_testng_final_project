package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasicPage {
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getFieldForNameInput() {
        return driver.findElement(By.id("name"));
    }

    public WebElement getFieldForEmailInput() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getFieldForPasswordInput() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getFieldForConfirmPassword() {
        return driver.findElement(By.id("confirmPassword"));
    }

    public WebElement getSignMeButton() {
        return driver.findElement(By.cssSelector("button.v-btn--is-elevated.secondary"));
    }

    public void clearInputs () {
        getFieldForNameInput().clear();
        getFieldForEmailInput().clear();
        getFieldForPasswordInput().clear();
        getFieldForConfirmPassword().clear();
    }

    public void signUpWithNameEmailAndPassword (String name, String email, String password) {
        clearInputs();
        getFieldForNameInput().sendKeys(name);
        getFieldForEmailInput().sendKeys(email);
        getFieldForPasswordInput().sendKeys(password);
        getFieldForConfirmPassword().sendKeys(password);
        getSignMeButton().click();
    }
    public WebElement getVerifyAccountPopUp () {
        return driver.findElement(By.cssSelector(".v-card__title.headline.grey.lighten-2.black--text.dlgVerifyAccount"));
    }
    public void clickOnCloseButtonForVerifyAccountPopup () {
        driver.findElement(By.cssSelector("button.btnClose.v-btn.v-btn--text.theme--light.v-size--default.primary--text")).click();

    }
}