package config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SelenideConfig {
    public static void createBrowserConfig(String browser) {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = browser;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC",true);
        capabilities.setCapability("enableVideo",true);
        Configuration.browserCapabilities = capabilities;
        Configuration.fastSetValue = false;
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        Configuration.pageLoadStrategy = "eager";
        Configuration.savePageSource = false;
        Configuration.screenshots = false;
        Configuration.timeout = 4000;
    }
}
