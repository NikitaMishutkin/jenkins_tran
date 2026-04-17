package demo;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-web-security");

        Configuration.browserCapabilities = options;
        Configuration.timeout = 10000; // Увеличиваем таймаут до 10 секунд
        Configuration.browserSize = "1920x1080";
      //  Configuration.remote = "http://localhost:32768/";



        //видео фрагмент

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;



        // локальный запуск
        Configuration.browserCapabilities = options;
        Configuration.browser = "chrome";
        Configuration.headless = false;
    }

    @AfterEach
    void addAttachment(){
        Attach.screenshotAs("Last screenshot");

    }

}
