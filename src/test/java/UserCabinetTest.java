import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UserCabinetTest {
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
    @DisplayName("Тест перехода в ЛК по клику на «Личный кабинет»")
    public void goToUserCabinetByUserCabinetButtonTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.loginButtonOnMainPageClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("arxipkin@gmail.com", "1234567");
        mainPage.userAccountButtonClick();
        UserCabinetPage userCabinet = new UserCabinetPage(driver);
        userCabinet.logoutUserButtonIsDisplayed();
    }

    @Test
    @DisplayName("Тест перехода из ЛК в конструктор по клику на «Конструктор»")
    public void goToConstructorByConstructorButtonTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.loginButtonOnMainPageClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("arxipkin@gmail.com", "1234567");
        mainPage.userAccountButtonClick();
        UserCabinetPage userCabinet = new UserCabinetPage(driver);
        userCabinet.constructorButtonClick();
        mainPage.constructorTabsAreDisplayedCheck();
    }

    @Test
    @DisplayName("Тест перехода из ЛК в конструктор по клику на «Конструктор»")
    public void goToConstructorByLogoClickTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.loginButtonOnMainPageClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("arxipkin@gmail.com", "1234567");
        mainPage.userAccountButtonClick();
        UserCabinetPage userCabinet = new UserCabinetPage(driver);
        userCabinet.logoClick();
        mainPage.constructorTabsAreDisplayedCheck();
    }

    @Test
    @DisplayName("Тест выхода по кнопке «Выйти» в личном кабинете")
    public void logoutUserTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.loginButtonOnMainPageClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("arxipkin@gmail.com", "1234567");
        mainPage.userAccountButtonClick();
        UserCabinetPage userCabinet = new UserCabinetPage(driver);
        userCabinet.logoutUser();
        loginPage.loginButtonIsDisplayedCheck();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}