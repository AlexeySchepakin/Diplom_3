package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        WebDriverWait waitClickable = new WebDriverWait(driver, 10);
        waitClickable.until(ExpectedConditions.elementToBeClickable(mainPage.getBunTab()));
        mainPage.clickBunTab();
        WebDriverWait waitVisible = new WebDriverWait(driver, 10);
        waitVisible.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getBunHeaderLocator()));
        WebElement bunHeader = driver.findElement(mainPage.getBunHeaderLocator());
        assertTrue("Bun category is not visible", bunHeader.isDisplayed());
    }

    @Test
    public void testSauceTabOpens() {
        mainPage.clickSauceTab();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getSauceHeaderLocator()));
        WebElement sauceHeader = driver.findElement(mainPage.getSauceHeaderLocator());
        assertTrue("Sauce category is not visible", sauceHeader.isDisplayed());
    }

    @Test
    public void testFillingTabOpens() {
        mainPage.clickFillingTab();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getFillingHeaderLocator()));
        WebElement fillingHeader = driver.findElement(mainPage.getFillingHeaderLocator());
        assertTrue("Filling category is not visible", fillingHeader.isDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}