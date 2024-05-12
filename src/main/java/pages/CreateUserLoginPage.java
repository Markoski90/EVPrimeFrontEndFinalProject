package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.util.List;

public class CreateUserLoginPage extends BasePage{

    private By formTitle = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[1]");
    private By emailTextBox = By.name("email");
    private By passwordTextBox = By.name("password");
    private By goButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[4]/div[1]/button");
    private By changeStateButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[4]/div[2]/button");
    private By getErrorMessages = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/ul");
    private By authenticationErrorMessage=By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/span");
    public CreateUserLoginPage(WebDriver driver){super(driver);}

    @Override
    public CreateUserLoginPage newInstance(WebDriver driver){return new CreateUserLoginPage(driver);}

    public void insertEmail(String email){
        insertText(emailTextBox,email);
    }

    public void insertPassword(String password){
        insertText(passwordTextBox,password);
    }

    public void clickGoButton(){
        clickElement(goButton);
    }

    public void clickChangeStateButton(){
        clickElement(changeStateButton);
    }

    public String getTextFromTitle(){
        return getTextFromElement(formTitle);
    }

    public List<WebElement> getErrorMessage(){
        return returnListOfElements (getErrorMessages);
    }

    public String getAuthenticationErrorMessage(){
        return getTextFromElement(authenticationErrorMessage);
    }


    public String getGoButtonColor(){
        Color backgroundEditButtonColor = Color.fromString(driver.findElement(goButton).getCssValue("background-color"));
        return backgroundEditButtonColor.asHex();
    }

    public String getGoButtonFontType() {
        return driver.findElement(goButton).getCssValue("font-family");
    }

    public String getGoButtonFontSize() {
        return driver.findElement(goButton).getCssValue("font-size");
    }


    public String getChangeStateButtonColor(){
        Color backgroundEditButtonColor = Color.fromString(driver.findElement(changeStateButton).getCssValue("background-color"));
        return backgroundEditButtonColor.asHex();
    }

    public String getChangeStateButtonFontType() {
        return driver.findElement(changeStateButton).getCssValue("font-family");
    }

    public String getChangeStateButtonFontSize() {
        return driver.findElement(changeStateButton).getCssValue("font-size");
    }
}
