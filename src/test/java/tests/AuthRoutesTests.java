package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{

    @Test
    public void forbidsVisitsToHomeUrlIfNotAuthenticated () {
        driver.navigate().to(baseUrl + "/home");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Current url should be " + baseUrl + "/login");

    }
    @Test
    public void ForbidsVisitsToProfileUrlIfNotAuthenticated () {
         driver.navigate().to(baseUrl + "/profile");
         Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Current url should be " + baseUrl + "/login");
    }
    @Test
    public void ForbidsVisitsToAdminCitiesUrlIfNotAuthenticated () {
        driver.navigate().to(baseUrl + "/admin/cities");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Current url should be " + baseUrl + "/login");
    }
    @Test
    public void  ForbidsVisitsToAdminUsersUrlIfNotAuthenticated () {
        driver.navigate().to(baseUrl + "/admin/users");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Current url should be " + baseUrl + "/login");
    }
}
