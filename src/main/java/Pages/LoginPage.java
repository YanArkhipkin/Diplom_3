package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private static final By EMAIL_FIELD = By.xpath("(//input[contains(@class,'text input__textfield')])[1]");
    private static final By PASSWORD_FIELD = By.xpath("(//input[contains(@class,'text input__textfield')])[2]");
    private static final By LOGIN_BUTTON = By.xpath("//button[text()='Войти']");
    private static final By REGISTER_LINK = By.xpath("(//a[@class='Auth_link__1fOlj'])[1]");
    private static final By PASSWORD_RECOVER_LINK = By.xpath("(//a[@class='Auth_link__1fOlj'])[2]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Логин юзера")
    public void loginUser(String email, String password) {
        driver.findElement(EMAIL_FIELD).click();
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        driver.findElement(PASSWORD_FIELD).click();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Клик по ссылке Зарегистрироваться")
    public void registerButtonClick() {
        driver.findElement(REGISTER_LINK).click();
    }

    @Step("Проверка отображения кнопки Войти")
    public void loginButtonIsDisplayedCheck() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    @Step("Клик по ссылке Восстановить пароль")
    public void passwordRecoveryButtonClick() {
        driver.findElement(PASSWORD_RECOVER_LINK).click();
    }
}