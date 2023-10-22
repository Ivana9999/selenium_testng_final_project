package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{

    @Test
    public void setLocaleToES () {
        navPage.clickOnLanguageButton();
        navPage.getESButtonFromLanguageDropDownMenu().click();
        Assert.assertEquals(navPage.getHeader().getText(), "Página de aterrizaje");
    }

    @Test
    public void setLocaleToEN () {
        navPage.clickOnLanguageButton();
        navPage.getENButtonFromLanguageDropDownMenu().click();
        Assert.assertEquals(navPage.getHeader().getText(), "Landing");
    }

    @Test
    public void setLocaleToCN () {
        navPage.clickOnLanguageButton();
        navPage.getCNButtonFromLanguageDropDownMenu().click();
        Assert.assertEquals(navPage.getHeader().getText(), "首页");
    }


    @Test
    public void setLocaleToFR () {
        navPage.clickOnLanguageButton();
        navPage.getFRButtonFromLanguageDropDownMenu().click();
        Assert.assertEquals(navPage.getHeader().getText(), "Page d'atterrissage");
    }
}
