package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserCabinetPage {
    private WebDriver driver;
    private static final By LOGOUT_BUTTON = By.xpath("(//button[@type='button'])[1]");
    private static final By CONSTRUCTOR_BUTTON = By.xpath("//p[text()='Конструктор']");
    private static final By MAIN_LOGO = By.className("AppHeader_header__logo__2D0X2");

    public UserCabinetPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Логаут пользователя")
    public void logoutUser() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_BUTTON));
        driver.findElement(LOGOUT_BUTTON).click();
    }

    @Step("Проверка отображения кнопки логаут")
    public void logoutUserButtonIsDisplayed() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_BUTTON));
        driver.findElement(LOGOUT_BUTTON).isDisplayed();
    }

    @Step("Клик по логотипу")
    public void logoClick() {
        driver.findElement(MAIN_LOGO).click();
    }

    @Step("Клик по кнопке Конструктор")
    public void constructorButtonClick() {
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }
}
