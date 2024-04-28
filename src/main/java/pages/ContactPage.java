package pages;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class ContactPage extends BasePage {

    private By getContactPageTitleText = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[1]/h2");
    private By nameField = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[1]/div[1]/div");
    private By emailField = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[1]/div[2]/div");
    private By messageField = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[1]/div[3]/div");
    private By sendButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[1]/button");
    private By getSendButtonText = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[1]/button");
    public String setupHtmlContent() {
        return "<div class=\"MuiBox-root css-0\"><p class=\"MuiTypography-root\">Address</p><p class=\"MuiTypography-root\">Email</p><p class=\"MuiTypography-root\">Phone Number</p></div>";
    }
    public String setupHtmlContent2() {
        return "<div class=\"MuiBox-root css-0\"><p class=\"MuiTypography-root MuiTypography-body1 css-7o7cr3-MuiTypography-root\">Rampo Lefkata 1</p><p class=\"MuiTypography-root MuiTypography-body1 css-ilt4wu-MuiTypography-root\">ev@rampo.com</p><p class=\"MuiTypography-root MuiTypography-body1 css-7o7cr3-MuiTypography-root\">+389 75 500 000</p></div>";
    }
    public ContactPage(WebDriver driver){super(driver);}

    @Override
    public ContactPage newInstance(WebDriver driver){return new ContactPage(driver);}

    public String getTextFromTitle(){
        return getTextFromElement(getContactPageTitleText);
    }
    public void insertName(String name){
        insertText(nameField,name);
    }
    public void insertEmail(String email){
        insertText(emailField,email);
    }
    public void insertMessage(String message){
        insertText(messageField,message);
    }
    public void clickSendButton(){
        clickElement(sendButton);
    }
    public String getSendButtonText(){
        return getTextFromElement(getSendButtonText);
    }
    public boolean isContactPageTitleDisplayed(){return isElementDisplayed(getContactPageTitleText);}
    public String getSendButtonColor(){
        Color backgroundBackToEventsButtonColor = Color.fromString(driver.findElement(sendButton).getCssValue("background-color"));
        return backgroundBackToEventsButtonColor.asHex();
    }
    public String getSendButtonFontType() {
        return driver.findElement(sendButton).getCssValue("font-family");
    }
    public String getSendButtonFontSize() {
        return driver.findElement(sendButton).getCssValue("font-size");
    }
    public String[] extractTextFromContactPageElements(String htmlContent, String className) {
        Document doc = Jsoup.parse(htmlContent);
        Elements elements = doc.getElementsByClass(className);
        return elements.eachText().toArray(new String[0]);
    }

}
