package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public abstract class BasePage {
    public WebDriver driver;
    Actions actions;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }
    public abstract BasePage newInstance(WebDriver driver);
    public void navigateTo (String url) {
        driver.get(url);
    }
    public void clickElement(By element) {
        driver.findElement(element).click();
    }
    public String getTextFromElement(By element){
        return driver.findElement(element).getText();
    }
    public void insertText(By element,String text){
         driver.findElement(element).sendKeys(text);
    }
    public boolean isElementDisplayed(By element) {
        try {
            driver.findElement(element).getText();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public List<WebElement> returnListOfElements(By element){
        return driver.findElements(element);
    }

    public void hoverElement(By locator){
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }

}
