package pages;

import Base.BasePage;
import com.codeborne.selenide.Selenide;
import config.SelenideConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Constants;

import static com.codeborne.selenide.Selenide.$;

public class AmazonPage extends BasePage {
    private By filterSelector = By.id("nav-search-dropdown-card");
    private By bookFilter = By.name("url");
    private By searchField = By.xpath("//input[@name='field-keywords']");

    public void open()
    {
        SelenideConfig.createBrowserConfig("chrome");
        Selenide.open(Constants.URL);
    }

    public void close()
    {
        Selenide.closeWebDriver();
    }

    public boolean atPage()
    {
        if(Selenide.title().contains("Amazon.com. Spend less. Smile more."))
            return true;
        else
            return false;
    }


    public void goToBooks() {
            $(bookFilter).selectOption(5);
            $(searchField).setValue("Java").pressEnter();
    }
}
