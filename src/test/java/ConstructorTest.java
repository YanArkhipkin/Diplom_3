import Pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class ConstructorTest {
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
    @DisplayName("Тест перехода к разделу «Булки»")
    public void goToBunsConstructorTabTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.saucesTabClick();
        mainPage.bunsTabClick();
        assertEquals(mainPage.currentActiveText(), "Булки");
    }

    @Test
    @DisplayName("Тест перехода к разделу «Соусы»")
    public void goToSaucesConstructorTabTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.saucesTabClick();
        assertEquals(mainPage.currentActiveText(), "Соусы");
    }

    @Test
    @DisplayName("Тест перехода к разделу «Начинки»")
    public void goToFillingsConstructorTabTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.fillingsTabClick();
        assertEquals(mainPage.currentActiveText(), "Начинки");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
