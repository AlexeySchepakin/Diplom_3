package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.LoginPage;
import page_objects.MainPage;
import page_objects.PasswordRecoveryPage;
import page_objects.ProfilePage;
import page_objects.RegistrationPage;
import utils.WebDriverFactory;
public class LoginTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private PasswordRecoveryPage passwordRecoveryPage;
    private RegistrationPage registrationPage;
    private ProfilePage profilePage;

    @Before
    public void setUp() {
        String browserName = System.getProperty("browser", "chrome");
        driver = WebDriverFactory.createDriver(browserName);

        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
        registrationPage = new RegistrationPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void testLoginFromMainPage() {
        mainPage.open();
        mainPage.navigateToLogin();
        loginPage.login("parashepa@gmail.com", "123456");
        Assert.assertTrue("Login failed", loginPage.isLoginSuccessful());
    }

    @Test
    public void testLoginFromRegistrationPage() {
        registrationPage.open();
        registrationPage.navigateToLogin();
        loginPage.login("parashepa@gmail.com", "123456");
        Assert.assertTrue("Login failed", loginPage.isLoginSuccessful());
    }

    @Test
    public void testLoginAfterPasswordRecovery() {
        passwordRecoveryPage.open();
        passwordRecoveryPage.navigateToLogin();
        loginPage.login("parashepa@gmail.com", "123456");
        Assert.assertTrue("Login failed", loginPage.isLoginSuccessful());
    }

    @Test
    public void testLogout() {
        loginPage.open();
        loginPage.login("parashepa@gmail.com", "123456");
        mainPage.goToProfile();
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(profilePage.getLogoutButton())).click();
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", currentUrl);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}