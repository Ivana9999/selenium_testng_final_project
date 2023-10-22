package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class AdminCitiesTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void VisitsTheAdminCitiesPageAndListCities () {
        navPage.clickOnLoginButton();
        loginPage.loginWithAdmincredentials();
        navPage.clickOnAdminButton();
        navPage.clickOnCitiesButton();
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "/admin/cities");
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void ChecksInputTypesForCreateOrEditNewCity () {
        navPage.clickOnLoginButton();
        loginPage.loginWithAdmincredentials();
        navPage.clickOnAdminButton();
        navPage.clickOnCitiesButton();
        citiesPage.clickOnNewItemButton();
        citiesPage.waitForEditDialogOrNewItemDialogToBeVisible();
        Assert.assertEquals(citiesPage.getInputField().getAttribute("type"), "text");
    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
  public void createNewCity () {
      navPage.clickOnLoginButton();
      loginPage.loginWithAdmincredentials();
      navPage.clickOnAdminButton();
      navPage.clickOnCitiesButton();
      citiesPage.clickOnNewItemButton();
      citiesPage.waitForEditDialogOrNewItemDialogToBeVisible();
      citiesPage.setCityName("Ivana Ivkoov 's city");
      citiesPage.clickOnSaveButton();
      messagePopUpPage.waitForSuccesfulPopUp();
      Assert.assertTrue(messagePopUpPage.getPopUpForSuccesfullyAddedCity().getText().contains("Saved successfully"));
  }
    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void editCity () {
        String oldCityName = "Ivana Ivkoov 's city";
        String newCityName = " Edited";

      navPage.clickOnLoginButton();
      loginPage.loginWithAdmincredentials();
      navPage.clickOnAdminButton();
      navPage.clickOnCitiesButton();
      citiesPage.setSearchName(oldCityName);
      citiesPage.waitForCertainNumberOfRows(1);
      citiesPage.getSpecificEditButton(0).click();
      citiesPage.waitForEditDialogOrNewItemDialogToBeVisible();
      citiesPage.setCityName(newCityName);
      citiesPage.clickOnSaveButton();
      messagePopUpPage.waitForSuccesfulPopUp();
      Assert.assertTrue(messagePopUpPage.getPopUpForSuccesfullyAddedCity().getText().contains("Saved successfully"));

  }
    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void searchCity () throws InterruptedException {
      String cityName = "Ivana Ivkoov 's city Edited";

      navPage.clickOnLoginButton();
      loginPage.loginWithAdmincredentials();
      navPage.clickOnAdminButton();
      navPage.clickOnCitiesButton();
      citiesPage.setSearchName(cityName);
      citiesPage.waitForCertainNumberOfRows(1);
      Thread.sleep(1000);
     Assert.assertEquals(citiesPage.getCellFromSpecificRow(0, 1).getText(), cityName);

  }
    @Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void deleteCity () throws InterruptedException {
      String cityName = "Ivana Ivkoov 's city Edited";
      navPage.clickOnLoginButton();
      loginPage.loginWithAdmincredentials();
      navPage.clickOnAdminButton();
      navPage.clickOnCitiesButton();
      citiesPage.setSearchName(cityName);
      citiesPage.waitForCertainNumberOfRows(1);
      Thread.sleep(1000);
      Assert.assertEquals(citiesPage.getCellFromSpecificRow(0, 1).getText(), cityName);
      citiesPage.getSpecificDeleteButton(0).click();
      citiesPage.waitForDeleteCityPopUp();
      citiesPage.getDeleteButtonFromPopUp().click();
      messagePopUpPage.waitForSuccesfulPopUp();
      Assert.assertTrue(messagePopUpPage.getPopUpForSuccesfullyAddedCity().getText().contains("Deleted successfully"));


  }
}
