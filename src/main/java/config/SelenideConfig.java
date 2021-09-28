package config;

import com.codeborne.selenide.Configuration;

public class SelenideConfig {
    public static void createBrowserConfig(String browser) {

        Configuration.browser = browser;
        Configuration.fastSetValue = false;
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        Configuration.pageLoadStrategy = "eager";
        Configuration.savePageSource = false;
        Configuration.screenshots = false;
        Configuration.timeout = 4000;
    }
}
