import Pages.ForgotPasswordPage;
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

public class LoginTest {
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
    @DisplayName("Тест логина по кнопке «Войти в аккаунт» на главной")
    public void loginUserByButtonOnMainPageTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.loginButtonOnMainPageClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("arxipkin@gmail.com", "1234567");
        mainPage.orderButtonIsDisplayedCheck();
    }

    @Test
    @DisplayName("Тест логина через кнопку «Личный кабинет»")
    public void loginUserByUserAccButtonTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.userAccountButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("arxipkin@gmail.com", "1234567");
        mainPage.orderButtonIsDisplayedCheck();
    }

    @Test
    @DisplayName("Тест логина через кнопку в форме регистрации")
    public void loginUserByRegisterPageTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.userAccountButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.registerButtonClick();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.loginButtonClick();
        loginPage.loginUser("arxipkin@gmail.com", "1234567");
        mainPage.orderButtonIsDisplayedCheck();
    }

    @Test
    @DisplayName("Тест логина через кнопку в форме восстановления пароля")
    public void loginUserByRecoveryPasswordFormTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.userAccountButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.passwordRecoveryButtonClick();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.loginButtonClick();
        loginPage.loginUser("arxipkin@gmail.com", "1234567");
        mainPage.orderButtonIsDisplayedCheck();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
