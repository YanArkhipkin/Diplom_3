package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;

    public static final By LOGIN_LINK = By.className("Auth_link__1fOlj");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по ссылке Войти")
    public void loginButtonClick() {
        driver.findElement(LOGIN_LINK).click();
    }

}
