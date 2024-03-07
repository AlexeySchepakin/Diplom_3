package page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    private final String mainPageUrl = "https://stellarburgers.nomoreparties.site";
    private final By loginLink = By.cssSelector("button.button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_large__G21Vg");
    private final By profileLink = By.xpath("//a[@href='/account']");
    private final By bunTab = By.xpath("//span[text()='Булки']");
    By bunHeader = By.xpath("//h2[@class='text text_type_main-medium mb-6 mt-10' and text()='Булки']");

    private final By sauceTab = By.xpath("//span[text()='Соусы']");
    By sauceHeader = By.xpath("//h2[@class='text text_type_main-medium mb-6 mt-10' and text()='Соусы']");

    private final By fillingTab = By.xpath("//span[text()='Начинки']");
    By fillingHeader = By.xpath("//h2[@class='text text_type_main-medium mb-6 mt-10' and text()='Начинки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Переход в профиль пользователя")
    public void goToProfile() {
        driver.findElement(profileLink).click();
    }

    public By getProfileLink() {
        return profileLink;
    }

    @Step("Открытие главной страницы")
    public void open() {
        driver.get(mainPageUrl);
    }

    @Step("Переход на страницу входа")
    public void navigateToLogin() {
        driver.findElement(loginLink).click();
    }

    @Step("Клик по вкладке 'Булки'")
    public void clickBunTab() {
        clickTab(bunTab);
    }

    @Step("Клик по вкладке 'Соусы'")
    public void clickSauceTab() {
        clickTab(sauceTab);
    }

    @Step("Клик по вкладке 'Начинки'")
    public void clickFillingTab() {
        clickTab(fillingTab);
    }

    @Step("Клик по вкладке")
    private void clickTab(By tabLocator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(tabLocator));
        tab.click();
    }

    public By getBunHeaderLocator() {
        return bunHeader;
    }

    public By getSauceHeaderLocator() {
        return sauceHeader;
    }

    public By getFillingHeaderLocator() {
        return fillingHeader;
    }
}