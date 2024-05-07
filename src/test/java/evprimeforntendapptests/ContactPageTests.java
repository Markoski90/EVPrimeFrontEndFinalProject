package evprimeforntendapptests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import static org.junit.Assert.*;

public class ContactPageTests {
    private WebDriver driver;
    private SidePanel sidePanel;
    private CreateUserLoginPage createUserLoginPage;
    private EventsPage eventsPage;
    private EventPage eventPage;
    private ContactPage contactPage;

    @Before
    public void SetUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        sidePanel = new SidePanel(driver);
        createUserLoginPage = new CreateUserLoginPage(driver);
        eventsPage = new EventsPage(driver);
        eventPage = new EventPage(driver);
        contactPage = new ContactPage(driver);

        sidePanel.navigateTo("http://localhost:3000");
        sidePanel.clickMenuIcon();
        Thread.sleep(2000);
        sidePanel.clickLoginButton();
    }

    @Test
    public void validationOfContactPage(){
        sidePanel.clickContactButton();
        assertTrue(contactPage.isContactPageTitleDisplayed());
        assertEquals("Want to reach out?", contactPage.getTextFromTitle());

        // Elements bellow are not interactable

//        contactPage.insertName("Daniel");
//        contactPage.insertEmail("mail@mail.com");
//        contactPage.insertMessage(RandomStringUtils.randomAlphabetic(12));
//        contactPage.clickSendButton();

        String htmlContentContactElement = contactPage.setupHtmlContent();
        String htmlContentContactInformation = contactPage.setupHtmlContent2();

        String[] contactElementTexts = contactPage.extractTextFromContactPageElements(htmlContentContactElement, "MuiTypography-root");
        String[] contactInformationTexts = contactPage.extractTextFromContactPageElements(htmlContentContactInformation, "MuiTypography-root");

        assertEquals("Address" + " " + "Rampo Lefkata 1" , contactElementTexts[0] + " " + contactInformationTexts[0]);
        assertEquals("Email" + " " + "ev@rampo.com" , contactElementTexts[1] + " " + contactInformationTexts[1]);
        assertEquals("Phone Number" + " " + "+389 75 500 000", contactElementTexts[2] + " " + contactInformationTexts[2]);
        assertEquals("SEND",contactPage.getSendButtonText());
        assertEquals("#304ffe",contactPage.getSendButtonColor());
        assertEquals("\"Josefin Sans\"",contactPage.getSendButtonFontType());
        assertEquals("14px",contactPage.getSendButtonFontSize());
        }

    @After
    public void TearDown(){
        driver.quit();
    }

}
