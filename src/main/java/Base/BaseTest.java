package Base;

import com.codeborne.selenide.Selenide;
import config.SelenideConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Constants;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        SelenideConfig.createBrowserConfig("chrome");
        Selenide.open(Constants.URL);
    }

    @AfterMethod(alwaysRun = false)
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
