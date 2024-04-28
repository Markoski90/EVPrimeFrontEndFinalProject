package evprimeforntendapptests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SidePanel;

import static org.junit.Assert.assertEquals;

public class SidePanelTests {
    private WebDriver driver;
    private SidePanel sidePanel;

    @Before
    public void SetUp(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();

        sidePanel = new SidePanel(driver);
        sidePanel.navigateTo("http://localhost:3000");

    }

    @Test
    public void sidePanelIconsValidationTest() throws InterruptedException {
        sidePanel.clickMenuIcon();
        Thread.sleep(500);
        assertEquals("Home", sidePanel.getTextFromHomeButton());
        assertEquals("Events", sidePanel.getTextFromEventsButton());
        assertEquals("Contact", sidePanel.getTextFromContactButton());
        assertEquals("Login", sidePanel.getTextFromLoginButton());
        // font size, font family not tested !!!
    }

    @After
    public void TearDown(){
        driver.quit();
    }

}