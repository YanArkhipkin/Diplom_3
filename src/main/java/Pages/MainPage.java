package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    private static final By USER_CABINET_BUTTON = By.xpath("//p[text()='Личный Кабинет']");
    private static final By LOGIN_BUTTON = By.xpath("//button[text()='Войти в аккаунт']");
    private static final By ORDER_BUTTON = By.xpath("//button[text()='Оформить заказ']");
    private static final By BUNS_TAB = By.xpath("(//div[contains(@class,'tab_tab__1SPyG ')])[1]");
    private static final By SAUCES_TAB = By.xpath("(//div[contains(@class,'tab_tab__1SPyG ')])[2]");
    private static final By FILLINGS_TAB = By.xpath("(//div[contains(@class,'tab_tab__1SPyG ')])[3]");
    private static final By TAB_ACTIVE = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]//span[1]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке Личный кабинет")
    public void userAccountButtonClick() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(USER_CABINET_BUTTON));
        driver.findElement(USER_CABINET_BUTTON).click();
    }

    @Step("Клик по кнопке Войти в аккаунт на главной")
    public void loginButtonOnMainPageClick() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Проверка отображения кнопки Оформить заказ")
    public void orderButtonIsDisplayedCheck() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(ORDER_BUTTON));
        driver.findElement(ORDER_BUTTON).isDisplayed();
    }

    @Step("Клик по табу Соусы")
    public void saucesTabClick() {
        driver.findElement(SAUCES_TAB).click();
    }

    @Step("Клик по табу Булки")
    public void bunsTabClick() {
        driver.findElement(BUNS_TAB).click();
    }

    @Step("Клик по табу Начинки")
    public void fillingsTabClick() {
        driver.findElement(FILLINGS_TAB).click();
    }

    @Step("Получение наименования активного таба")
    public String currentActiveText() {
        return driver.findElement(TAB_ACTIVE).getText();
    }

    @Step("Проверка видимости табов конструткора")
    public void constructorTabsAreDisplayedCheck() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(BUNS_TAB));
        driver.findElement(BUNS_TAB).isDisplayed();
        driver.findElement(SAUCES_TAB).isDisplayed();
        driver.findElement(FILLINGS_TAB).isDisplayed();
    }
}