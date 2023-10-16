package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MessagePopUpPage extends BasicPage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void waitPopUptoBeVisible () {
        wait
                .withMessage("Pop up should be visible")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.v-snack__content")));
    }
    public WebElement getPopUp () {
        return driver.findElement(By.cssSelector("div.v-snack__content"));
    }

    public String getTextInsidePopUp () {
      List <WebElement> popUp = getPopUp().findElement(By.tagName("ul")).findElements(By.tagName("li"));
     return popUp.get(0).getText();
    }

}
