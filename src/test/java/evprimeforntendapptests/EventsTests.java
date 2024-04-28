package evprimeforntendapptests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import utils.DbClient;
import utils.DateBuilder;

import static org.junit.Assert.*;


public class EventsTests {
    private WebDriver driver;
    private SidePanel sidePanel;
    private CreateUserLoginPage createUserLoginPage;
    private EventsPage eventsPage;
    private EventPage eventPage;
    static DateBuilder dateBuilder = new DateBuilder();

    @Before
    public void SetUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        sidePanel = new SidePanel(driver);
        createUserLoginPage = new CreateUserLoginPage(driver);
        eventsPage = new EventsPage(driver);
        eventPage = new EventPage(driver);

        sidePanel.navigateTo("http://localhost:3000");
        sidePanel.clickMenuIcon();
        Thread.sleep(2000);
        sidePanel.clickLoginButton();
    }

    @Test
    public void createAnEventTest() throws InterruptedException {
        createUserLoginPage.insertEmail("mail@email.com");
        createUserLoginPage.insertPassword("password");
        createUserLoginPage.clickGoButton();
        Thread.sleep(2000);
        eventsPage.hoverPlusButton();
        Thread.sleep(2000);
        eventsPage.clickAddEventButton();
        eventsPage.insertEventTitle(RandomStringUtils.randomAlphabetic(10));
        eventsPage.insertEventImage("https://cdn.vox-cdn.com/thumbor/qk7COj8PFLrli5KmcUbE3eirblc=/0x0:3635x2419/1200x800/filters:focal(1585x502:2165x1082)/cdn.vox-cdn.com/uploads/chorus_image/image/72360597/1247247312.0.jpg");
        eventsPage.insertEventDate(dateBuilder.currentTime());
        eventsPage.insertEventLocation("Ohrid");
        eventsPage.insertEventDescription(RandomStringUtils.randomAlphabetic(25));
        eventsPage.clickCreateEventButton();
    }

    //precondition create event directly from database
    @Test
    public void eventValidationTest() throws InterruptedException {
        createUserLoginPage.insertEmail("mail@email.com");
        createUserLoginPage.insertPassword("password");
        createUserLoginPage.clickGoButton();
        Thread.sleep(2000);
        sidePanel.clickEventsButton();
        Thread.sleep(1000);
        eventsPage.clickOnEventByIndex(1);
        assertEquals("Prodigy Tour", eventPage.getTextEventTitle());
        assertEquals("09/09/2023 12:00 am-16/09/2023 11:59 pm", eventPage.getTextEventDate());
        assertEquals("Ohrid Stadium", eventPage.getTextEventLocation());
        assertEquals("One of the greatest Band coming in Ohrid", eventPage.getTextEventDescription());
        assertEquals("BACK TO EVENTS", eventPage.getTextFromBackToEventsButton());
        assertEquals("EDIT EVENT", eventPage.getEditEventButtonText());
    }

    @Test
    public void validateEventFieldsText() throws InterruptedException {
        createUserLoginPage.insertEmail("mail@email.com");
        createUserLoginPage.insertPassword("password");
        createUserLoginPage.clickGoButton();
        Thread.sleep(2000);
        sidePanel.clickEventsButton();
        Thread.sleep(2000);
        eventsPage.clickOnEventByIndex(1);
        eventPage.clickEditButton();
        assertEquals("Event Title",eventPage.getEventTitleTextField());
        assertEquals("Event Image",eventPage.getEventImageTextField());
        assertEquals("Event Date",eventPage.getEventDateTextField());
        assertEquals("Event Location",eventPage.getEventLocationField());
        assertEquals("Event Description",eventPage.getEventDescriptionField());
    }

    //precondition create event directly from database
    @Test
    public void validateBackToEventsButtonTest() throws InterruptedException {
        createUserLoginPage.insertEmail("mail@email.com");
        createUserLoginPage.insertPassword("password");
        createUserLoginPage.clickGoButton();
        Thread.sleep(2000);
        sidePanel.clickEventsButton();
        Thread.sleep(1000);
        eventsPage.clickOnEventByIndex(1);
        Thread.sleep(1000);
        eventPage.clickBackToEventsButton();
        WebElement eventList = eventsPage.findEventList();
        assertTrue(eventList.isDisplayed());
    }

    //precondition create event directly from database
    @Test
    public void eventValidationWhenUserNotLoggedInTest() throws InterruptedException {
        sidePanel.clickEventsButton();
        Thread.sleep(1000);
        eventsPage.clickOnEventByIndex(1);
        assertEquals("Prodigy Tour", eventPage.getTextEventTitle());
        assertEquals("09/09/2023 12:00 am-16/09/2023 11:59 pm", eventPage.getTextEventDate());
        assertEquals("Ohrid Stadium", eventPage.getTextEventLocation());
        assertEquals("One of the greatest Band coming in Ohrid", eventPage.getTextEventDescription());
        assertEquals("BACK TO EVENTS", eventPage.getTextFromBackToEventsButton());
        eventPage.clickBackToEventsButton();
        Thread.sleep(1000);
        WebElement eventList = eventsPage.findEventList();
        assertTrue(eventList.isDisplayed());
    }

    //precondition create event directly from database
    @Test
    public void updateEventTest() throws InterruptedException {
        createUserLoginPage.insertEmail("mail@email.com");
        createUserLoginPage.insertPassword("password");
        createUserLoginPage.clickGoButton();
        Thread.sleep(2000);
        sidePanel.clickEventsButton();
        Thread.sleep(2000);
        eventsPage.clickOnEventByIndex(3);
        assertEquals("EDIT EVENT", eventPage.getEditEventButtonText());
        eventPage.clickEditButton();
        eventPage.eventTitleInsertText("Juventus Champions");
        assertEquals("UPDATE EVENT", eventPage.getUpdateButtonText());
        eventPage.clickUpdateButton();
    }

    @Test
    public void deleteEventTest() throws InterruptedException {
        createUserLoginPage.insertEmail("mail@email.com");
        createUserLoginPage.insertPassword("password");
        createUserLoginPage.clickGoButton();
        Thread.sleep(2000);
        sidePanel.clickEventsButton();
        Thread.sleep(2000);
        eventsPage.clickOnEventByIndex(3);
        eventPage.clickDeleteButton();
        assertEquals("DELETE EVENT",eventPage.getDeleteButtonText());
        DbClient.deleteEventById(3);
        eventPage.clickConfirmDeleteButton();
    }

    @Test
    public void verifyingEventButtonsCss() throws InterruptedException {
        createUserLoginPage.insertEmail("mail@email.com");
        createUserLoginPage.insertPassword("password");
        createUserLoginPage.clickGoButton();
        Thread.sleep(2000);
        sidePanel.clickEventsButton();
        Thread.sleep(1000);
        eventsPage.clickOnEventByIndex(2);

        assertEquals("#d32f2f",eventPage.getDeleteButtonColor());
        assertEquals("\"Josefin Sans\"",eventPage.getDeleteButtonFontType());
        assertEquals("14px",eventPage.getDeleteButtonFontSize());

        assertEquals("#304ffe",eventPage.getEditButtonColor());
        assertEquals("\"Josefin Sans\"",eventPage.getEditButtonFontType());
        assertEquals("14px",eventPage.getEditButtonFontSize());

        assertEquals("#9c27b0",eventPage.getBackToEventsButtonColor());
        assertEquals("\"Josefin Sans\"",eventPage.getBackToEventsButtonFontType());
        assertEquals("14px",eventPage.getBackToEventsButtonFontSize());

        eventPage.clickEditButton();
        assertEquals("#2e7d32",eventPage.getUpdateButtonColor());
        assertEquals("\"Josefin Sans\"",eventPage.getUpdateButtonFontType());
        assertEquals("14px",eventPage.getUpdateButtonFontSize());
    }

    @After
    public void TearDown(){
        driver.quit();
    }

}
