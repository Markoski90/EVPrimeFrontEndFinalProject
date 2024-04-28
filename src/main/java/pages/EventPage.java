package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class EventPage extends BasePage {

    private By eventTitle = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[1]/div[1]/div[1]/h2");
    private By eventDate = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[1]/div[1]/div[2]/h6");
    private By eventLocation = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[1]/div[1]/div[3]/h6");
    private By eventDescription = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[2]/span");
    private By backToEventsButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[1]/div[2]/button/a");
    private By getBackToEventsButtonColor = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[2]/button[2]");


    private By editButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[2]/button[1]");
    private By deleteButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[1]/div[1]/button");
    private By confirmDeleteButton=By.xpath("/html/body/div[2]/div[3]/div/div/button[1]");
    private By eventTitleField = By.name("title");
    private By getEventTitleFieldText = By.id(":r4:-label");
    private By getEventImageFieldText = By.id(":r5:-label");
    private By getEventDateFieldText = By.id(":r6:-label");
    private By getEventLocationFieldText = By.id(":r7:-label");
    private By getEventDescriptionFieldText = By.id(":r8:-label");
    private By updateButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/form/div/button");

    public EventPage(WebDriver driver){super(driver);}
    @Override
    public EventPage newInstance(WebDriver driver){return new EventPage(driver);}

    public String getTextEventTitle(){
        return getTextFromElement(eventTitle);
    }
    public String getTextEventDate(){return getTextFromElement(eventDate);}
    public String getTextEventLocation(){return getTextFromElement(eventLocation);}
    public String getTextEventDescription(){return getTextFromElement(eventDescription);}
    public String getTextFromBackToEventsButton(){
        return getTextFromElement(backToEventsButton);
    }
    public void clickBackToEventsButton(){
        clickElement(backToEventsButton);
    }
    public void clickEditButton(){
        clickElement(editButton);
    }
    public void eventTitleInsertText(String title){
        insertText(eventTitleField, title);
    }
    public void clickUpdateButton(){
        clickElement(updateButton);
    }
    public void clickDeleteButton(){
        clickElement(deleteButton);
    }
    public void clickConfirmDeleteButton(){
        clickElement(confirmDeleteButton);
    }
    public String getEventTitleTextField(){
        return getTextFromElement(getEventTitleFieldText);
    }
    public String getEventImageTextField(){
        return getTextFromElement(getEventImageFieldText);
    }
    public String getEventDateTextField(){
        return getTextFromElement(getEventDateFieldText);
    }
    public String getEventLocationField(){
        return getTextFromElement(getEventLocationFieldText);
    }
    public String getEventDescriptionField(){
        return getTextFromElement(getEventDescriptionFieldText);
    }
    public String getEditEventButtonText(){
        return getTextFromElement(editButton);
    }
    public String getUpdateButtonText(){
        return getTextFromElement(updateButton);
    }
    public String getDeleteButtonText(){
        return getTextFromElement(deleteButton);
    }
    public String getUpdateButtonColor(){
        Color backgroundUpdateButtonColor = Color.fromString(driver.findElement(updateButton).getCssValue("background-color"));
        return backgroundUpdateButtonColor.asHex();
    }
    public String getUpdateButtonFontType() {
        return driver.findElement(updateButton).getCssValue("font-family");
    }
    public String getUpdateButtonFontSize() {
        return driver.findElement(updateButton).getCssValue("font-size");
    }
    public String getDeleteButtonColor(){
        Color backgroundDeleteButtonColor = Color.fromString(driver.findElement(deleteButton).getCssValue("background-color"));
        return backgroundDeleteButtonColor.asHex();
    }
    public String getDeleteButtonFontType() {
        return driver.findElement(deleteButton).getCssValue("font-family");
    }
    public String getDeleteButtonFontSize() {
        return driver.findElement(deleteButton).getCssValue("font-size");
    }
    public String getEditButtonColor(){
        Color backgroundEditButtonColor = Color.fromString(driver.findElement(editButton).getCssValue("background-color"));
        return backgroundEditButtonColor.asHex();
    }
   public String getEditButtonFontType() {
        return driver.findElement(editButton).getCssValue("font-family");
    }
    public String getEditButtonFontSize() {
        return driver.findElement(editButton).getCssValue("font-size");
    }
    public String getBackToEventsButtonColor(){
        Color backgroundBackToEventsButtonColor = Color.fromString(driver.findElement(getBackToEventsButtonColor).getCssValue("background-color"));
        return backgroundBackToEventsButtonColor.asHex();
    }
    public String getBackToEventsButtonFontType() {
        return driver.findElement(getBackToEventsButtonColor).getCssValue("font-family");
    }
    public String getBackToEventsButtonFontSize() {
        return driver.findElement(getBackToEventsButtonColor).getCssValue("font-size");
    }


}
