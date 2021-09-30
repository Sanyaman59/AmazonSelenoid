package pages;

import Base.BasePage;
import com.codeborne.selenide.Selenide;
import config.SelenideConfig;
import org.openqa.selenium.By;
import utils.Constants;

import static com.codeborne.selenide.Selenide.$;

public class NavigationPage extends BasePage {
    private By filterSelector = By.id("nav-search-dropdown-card");
    private By bookFilter = By.name("url");
    private By searchField = By.xpath("//input[@name='field-keywords']");
    private By title = By.xpath("//title");

    public void waitForPage()
    {
        waitForElementDOMVisibility(title);
    }

    public void goToBooks(String text) {
        $(bookFilter).selectOptionContainingText("Books");
        $(searchField).setValue(text).pressEnter();
    }
}
