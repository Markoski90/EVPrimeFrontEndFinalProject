package evprimeforntendapptests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateUserLoginPage;
import pages.SidePanel;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class CreateUserLoginTests {
    private WebDriver driver;
    private SidePanel sidePanel;
    private CreateUserLoginPage createUserLoginPage;
    
    @Before
    public void SetUp() throws InterruptedException{
        driver= new ChromeDriver();
        driver.manage().window().maximize();

        sidePanel = new SidePanel(driver);
        createUserLoginPage=new CreateUserLoginPage(driver);

        sidePanel.navigateTo("http://localhost:3000");
        sidePanel.clickMenuIcon();
        Thread.sleep(500);
        sidePanel.clickLoginButton();
    }

    @Test
    public void createUserTest() throws InterruptedException {
        Thread.sleep(2000);
        createUserLoginPage.clickChangeStateButton();
        assertEquals("Create new user",createUserLoginPage.getTextFromTitle());
        createUserLoginPage.insertEmail(RandomStringUtils.randomAlphanumeric(10) +"@mail.com");
        createUserLoginPage.insertPassword(RandomStringUtils.randomAlphanumeric(10));
        createUserLoginPage.clickGoButton();
    }

    @Test
    public void emailExistTest() throws InterruptedException {
        Thread.sleep(200);
        createUserLoginPage.clickChangeStateButton();
        createUserLoginPage.insertEmail("mail@email.com");
        createUserLoginPage.insertPassword("password");
        createUserLoginPage.clickGoButton();
        Thread.sleep(800);
        assertEquals("Email exists already.",createUserLoginPage.getErrorMessage().get(0).getText());
    }
    @Test
    public void passwordTooShortTest() throws InterruptedException {
        Thread.sleep(1000);
        createUserLoginPage.clickChangeStateButton();
        createUserLoginPage.insertEmail("email@email.com");
        createUserLoginPage.insertPassword("pas");
        createUserLoginPage.clickGoButton();
        Thread.sleep(800);
        assertEquals("Invalid password. Must be at least 6 characters long.",createUserLoginPage.getErrorMessage().get(0).getText());
    }

    @Test
    public void LoginUserTest() throws InterruptedException {
        Thread.sleep(1000);
        assertEquals("Log in",createUserLoginPage.getTextFromTitle());
        createUserLoginPage.insertEmail("mail@email.com");
        createUserLoginPage.insertPassword("password");
        createUserLoginPage.clickGoButton();
        Thread.sleep(800);
        assertFalse(sidePanel.isLoginButtonDisplayed());
        assertEquals("Log out",sidePanel.getTextFromLogOutButton());
    }

    @Test
    public void InvalidEmailTest() throws InterruptedException {
        Thread.sleep(200);
        createUserLoginPage.clickChangeStateButton();
        createUserLoginPage.insertEmail("mail.mail.com");
        createUserLoginPage.insertPassword("password");
        createUserLoginPage.clickGoButton();
        Thread.sleep(800);
        assertEquals("Invalid email.",createUserLoginPage.getErrorMessage().get(0).getText());
    }

    @Test
    public void InvalidPasswordTest() throws InterruptedException {
        Thread.sleep(200);
        createUserLoginPage.insertEmail("mail@email.com");
        createUserLoginPage.insertPassword("paassword");
        createUserLoginPage.clickGoButton();
        Thread.sleep(1000);
        assertEquals("Invalid email or password entered.",createUserLoginPage.getErrorMessage().get(0).getText());
    }

    @Test
    public void emptyEmailFieldTest() throws InterruptedException {
        Thread.sleep(1000);
        createUserLoginPage.insertEmail("");
        createUserLoginPage.insertPassword("paassword");
        createUserLoginPage.clickGoButton();
        Thread.sleep(800);
        assertEquals("Authentication failed.",createUserLoginPage.getAuthenticationErrorMessage());
    }
    @Test
    public void verifyCssForUserLoginButtons(){
        sidePanel.clickLoginButton();

        assertEquals("#304ffe",createUserLoginPage.getGoButtonColor());
        assertEquals("\"Josefin Sans\"",createUserLoginPage.getGoButtonFontType());
        assertEquals("14px",createUserLoginPage.getGoButtonFontSize());

        assertEquals("#9c27b0",createUserLoginPage.getChangeStateButtonColor());
        assertEquals("\"Josefin Sans\"",createUserLoginPage.getChangeStateButtonFontType());
        assertEquals("14px",createUserLoginPage.getChangeStateButtonFontSize());

    }

    @After
    public void TearDown(){
        driver.quit();
    }

}
