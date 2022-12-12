package Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    private static final By NAME_FIELD = By.xpath("(//input[@name='name'])[1]");
    private static final By EMAIL_FIELD = By.xpath("(//input[@name='name'])[2]");
    private static final By PASSWORD_FIELD = By.xpath("(//input[contains(@class,'text input__textfield')])[3]");
    private static final By REGISTER_BUTTON = By.xpath("//button[text()='Зарегистрироваться']");
    private static final By ERROR_TEXT = By.xpath("//p[@class='input__error text_type_main-default']");
    private static final By LOGIN_LINK = By.className("Auth_link__1fOlj");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Регистрация пользователя")
    public void registerUser(String name, String email, String password) {
        driver.findElement(NAME_FIELD).click();
        driver.findElement(NAME_FIELD).sendKeys(name);
        driver.findElement(EMAIL_FIELD).click();
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        driver.findElement(PASSWORD_FIELD).click();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(REGISTER_BUTTON).click();
    }

    @Step("Проверка отображения ошибки Некорректный пароль")
    public void passwordErrorIsDisplayedCheck() {
        driver.findElement(ERROR_TEXT).isDisplayed();
    }

    @Step("Клик по ссылке Войти")
    public void loginButtonClick() {
        driver.findElement(LOGIN_LINK).click();
    }
}