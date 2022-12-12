import Pages.LoginPage;
import Pages.MainPage;
import Pages.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RegistrationTest {
    private WebDriver driver;
    private final static String URL = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void setUp() {
        /*
        //setUp for Yandex.Browser
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexDriver\\yandexdriver.exe");
        options.setBinary("C:\\Users\\arxipkin01\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver = new ChromeDriver(options);
        */

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test
    @DisplayName("Тест успешной регистрации нового пользователя")
    public void userSuccessRegistrationTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.userAccountButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.registerButtonClick();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerUser("Иван", "ivan514614@gmail.com", "1234567");
        loginPage.loginButtonIsDisplayedCheck();
    }

    @Test
    @DisplayName("Тест наличия ошибки при вводе некорректного пароля")
    public void userRegistrationPasswordErrorTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.userAccountButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.registerButtonClick();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerUser("Иван", "ivan546111@gmail.com", "1234");
        registerPage.passwordErrorIsDisplayedCheck();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}