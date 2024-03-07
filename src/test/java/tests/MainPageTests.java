package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.MainPage;
import utils.WebDriverFactory;

import static org.junit.Assert.*;

public class MainPageTests {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        String browserName = System.getProperty("browser", "chrome");
        driver = WebDriverFactory.createDriver(browserName);

        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    public void testBunTabOpens() {
        mainPage.clickSauceTab();
        mainPage.clickBunTab();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getBunHeaderLocator()));
        assertTrue("Header under Bun tab is not visible", driver.findElement(mainPage.getBunHeaderLocator()).isDisplayed());
    }

    @Test
    public void testSauceTabOpens() {
        mainPage.clickSauceTab();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getSauceHeaderLocator()));
        assertTrue("Header under Sauce tab is not visible", driver.findElement(mainPage.getSauceHeaderLocator()).isDisplayed());
    }

    @Test
    public void testFillingTabOpens() {
        mainPage.clickFillingTab();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getFillingHeaderLocator()));
        assertTrue("Header under Filling tab is not visible", driver.findElement(mainPage.getFillingHeaderLocator()).isDisplayed());
    }


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
