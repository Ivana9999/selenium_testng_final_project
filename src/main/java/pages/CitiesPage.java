package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CitiesPage extends BasicPage {
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getButtonForNewItem() {
        return driver.findElement(By.cssSelector("button.btnNewItem"));
    }

    public WebElement getInputField() {
        return driver.findElement(By.id("search"));
    }

    public void waitForEditDialogOrNewItemDialogToBeVisible() {
        wait
                .withMessage("Edit dialog should be visible")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("v-card__title")));
    }

    public void waitForDeleteButtonDialog() {
        wait
                .withMessage("Delete button dialog should be visible")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.v-card button.green--text")));
    }

    public WebElement getSaveButtonForNewItemAndEditDialog() {
        return driver.findElement(By.cssSelector("button.btnSave"));
    }

    public WebElement getDeleteButtonFromDeleteDialog() {
        return driver.findElement(By.cssSelector(".v-dialog__content--active button.text--lighten3"));
    }

    public WebElement getTableContent() {
        return driver.findElement(By.cssSelector("table tbody"));
    }

    public void waitForCertainNumberOfRows(int numberOfRows) {
        wait.withMessage("Waiting for " + numberOfRows + " to be visible")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("table tbody"), numberOfRows));
    }

    public WebElement getCellFromSpecificRow(int row, int cell) {
        WebElement table = getTableContent();

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        WebElement requestedRow = rows.get(row);

        List<WebElement> cells = requestedRow.findElements(By.tagName("td"));

        return cells.get(cell);
    }

    public WebElement getSpecificEditButton(int row) {
        WebElement table = getTableContent();

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        WebElement requestedRow = rows.get(row);

        return requestedRow.findElement(By.id("edit"));
    }

    public WebElement getSpecificDeleteButton(int row) {
        WebElement table = getTableContent();

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        WebElement requestedRow = rows.get(row);

        return requestedRow.findElement(By.cssSelector("button#delete"));
    }

    public void clickOnNewItemButton() {
        getButtonForNewItem().click();
    }

    public WebElement getNameInput() {
        return driver.findElement(By.id("name"));
    }

    public void setCityName(String cityName) {
        getNameInput().clear();
        getNameInput().sendKeys(cityName);
    }

    public void clickOnSaveButton() {
        getSaveButtonForNewItemAndEditDialog().click();
    }


    public void setSearchName(String cityName) {
        getInputField().sendKeys(cityName);
    }
    public WebElement getDeleteCityPopUp () {
        return driver.findElement(By.className("v-toolbar__content"));
    }
    public void waitForDeleteCityPopUp () {
        wait
                .withMessage("Delete City Pop up should be visible")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("v-toolbar__content")));

    }
    public WebElement getDeleteButtonFromPopUp () {
       return driver.findElement(By.cssSelector("button.v-btn--text.red--text"));
    }
}
