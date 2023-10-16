package tests;

import helper.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.reporters.HtmlHelper;
import pages.*;
import retry.RetryAnalyzer;

import java.io.IOException;
import java.time.Duration;

public abstract class BasicTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected LoginPage loginPage;
    protected RetryAnalyzer retryAnalyzer;
    protected CitiesPage citiesPage;
    protected MessagePopUpPage messagePopUpPage;
    protected NavPage navPage;
    protected SignupPage signupPage;

@BeforeClass
    public void setup () {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    loginPage = new LoginPage(driver, wait);
    signupPage = new SignupPage(driver, wait);
    citiesPage = new CitiesPage(driver, wait);
    messagePopUpPage = new MessagePopUpPage(driver, wait);
    navPage = new NavPage(driver, wait);
}
@BeforeMethod
    public void beforeMethod () {
    driver.manage().deleteAllCookies();
    driver.navigate().to(baseUrl);
}
@AfterMethod
    public void afterMethod (ITestResult testResult) throws IOException {
    if (testResult.getStatus()==ITestResult.FAILURE) {
        Helper.takeScreenshot(driver, testResult.getName());
    }
}
@AfterClass
    public void afterClass () {
    driver.quit();
}
}
