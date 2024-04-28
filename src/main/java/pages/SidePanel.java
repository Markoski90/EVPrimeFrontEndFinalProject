package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SidePanel extends BasePage {
    private By menuIcon = By.xpath("//*[@id=\"root\"]/div/div/header/div/button");
    private By homeButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[1]/div/div[2]/span");
    private By eventsButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[2]/div/div[2]/span");
    private By contactButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[3]/div/div[2]/span");
    private By loginButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[4]/div/div[2]/span");
    private By logoutButton = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/ul/li/div/div[2]/span");

    public SidePanel(WebDriver driver) {
        super(driver);
    }
    @Override
    public CreateUserLoginPage newInstance(WebDriver driver) {
        return new CreateUserLoginPage(driver);
    }

    public void clickMenuIcon() {
        clickElement(menuIcon);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public void clickEventsButton() {
        clickElement(eventsButton);
    }

    public void clickContactButton() {
        clickElement(contactButton);
    }

    public String getTextFromHomeButton() {
        return getTextFromElement(homeButton);
    }

    public String getTextFromEventsButton() {
        return getTextFromElement(eventsButton);
    }

    public String getTextFromContactButton() {
        return getTextFromElement(contactButton);
    }

    public String getTextFromLoginButton() {
        return getTextFromElement(loginButton);
    }

    public String getTextFromLogOutButton() {
        return getTextFromElement(logoutButton);
    }

    public boolean isLoginButtonDisplayed() {
        return isElementDisplayed(loginButton);
    }

}


