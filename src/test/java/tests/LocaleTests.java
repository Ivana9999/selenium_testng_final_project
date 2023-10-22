package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class LocaleTests extends BasicTest{
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToES () {
        navPage.clickOnLanguageButton();
        navPage.getESButtonFromLanguageDropDownMenu().click();
        Assert.assertEquals(navPage.getHeader().getText(), "Página de aterrizaje");
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToEN () {
        navPage.clickOnLanguageButton();
        navPage.getENButtonFromLanguageDropDownMenu().click();
        Assert.assertEquals(navPage.getHeader().getText(), "Landing");
    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToCN () {
        navPage.clickOnLanguageButton();
        navPage.getCNButtonFromLanguageDropDownMenu().click();
        Assert.assertEquals(navPage.getHeader().getText(), "首页");
    }


    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToFR () {
        navPage.clickOnLanguageButton();
        navPage.getFRButtonFromLanguageDropDownMenu().click();
        Assert.assertEquals(navPage.getHeader().getText(), "Page d'atterrissage");
    }
}
