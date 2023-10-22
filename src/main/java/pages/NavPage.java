package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage {
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getHomeLink() {
        return driver.findElement(By.cssSelector("a[href='/']"));
    }

    public WebElement getAboutLink() {
        return driver.findElement(By.cssSelector("a.btnAbout[href='/about']"));
    }

    public WebElement getMyProfileLink() {
        return driver.findElement(By.cssSelector("a.btnProfile[href='/profile']"));
    }

    public WebElement getAdminButton() {
        return driver.findElement(By.cssSelector("button.btnAdmin"));
    }

    public WebElement getCitiesLinkFromAdminDropDownMenu() {
        return driver.findElement(By.cssSelector("a.btnAdminCities[href='/admin/cities']"));
    }

    public WebElement getUsersLinkFromAdminDropDownMenu() {
        return driver.findElement(By.cssSelector("a.btnAdminUsers[href='/admin/users']"));
    }

    public WebElement getSignUpButton() {
        return driver.findElement(By.cssSelector("a.btnLogin[href='/signup']"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector("a.btnLogin[href='/login']"));
    }
    public WebElement getLogoutButton() {
        return driver.findElement(By.cssSelector("button.btnLogout"));
    }
    public WebElement getLanguagesButton () {
        return driver.findElement(By.cssSelector("button.btnLocaleActivation"));
    }
    public WebElement getENButtonFromLanguageDropDownMenu() {
        return driver.findElement(By.cssSelector("div.btnEN"));
    }
    public WebElement getESButtonFromLanguageDropDownMenu() {
        return driver.findElement(By.cssSelector("div.btnES"));
    }
    public WebElement getFRButtonFromLanguageDropDownMenu() {
        return driver.findElement(By.cssSelector("div.btnFR"));
    }
    public WebElement getCNButtonFromLanguageDropDownMenu() {
        return driver.findElement(By.cssSelector("div.btnCN"));
    }
    public void selectEnglishLanguageFromLanguagesDropDownMenu () {
        getLanguagesButton().click();
        getENButtonFromLanguageDropDownMenu().click();

    }

    public void clickOnLoginButton () {
        getLoginButton().click();
    }

    public void clickOnLogoutButton () {
        getLogoutButton().click();
    }

    public void clickOnSingUpButton () {
        getSignUpButton().click();;
    }
public void clickOnAdminButton () {
        getAdminButton().click();
}
public void clickOnCitiesButton () {
        getCitiesLinkFromAdminDropDownMenu().click();
}
}