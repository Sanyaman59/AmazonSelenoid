package Base;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.LocatorParser;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class BasePage {
    private By byLocator(By by, Object... args) {
        return LocatorParser.parseLocator(by, args);
    }

    protected SelenideElement getSelenideElement(By by, Object... args) {
        return $(byLocator(by, args));
    }

    protected List<SelenideElement> getElements(By by, Object... args) {
        return shouldBe(sizeGreaterThan(0), by, args);
    }

    protected SelenideElement shouldBe(Condition condition, By by, Object... args) {
        return $(byLocator(by, args)).shouldBe(condition);
    }

    protected ElementsCollection shouldBe(CollectionCondition condition, By by, Object... args) {
        return $$(byLocator(by, args)).shouldBe(condition);
    }

    protected void click(By by, Object... args) {
        step("Click on element: " + byLocator(by, args).toString());
        shouldBe(Condition.visible, by, args).click();
    }

    protected void type(String text, By by, Object... args) {
        step("Type text: '" + text + "' to: " + byLocator(by, args).toString());
        wipeText(by, args);
        shouldBe(Condition.visible, by, args).append(text);
    }

    protected String getElementText(By by, Object... args) {
        step("Get element text: " + byLocator(by, args).toString());
        return shouldBe(Condition.enabled, by, args).text();
    }

    protected void wipeText(By by, Object... args) {
        int stringSize = shouldBe(Condition.enabled, by, args).getWrappedElement().getAttribute("value").length();
        for (int i = 0; i < stringSize; i++) {
            shouldBe(Condition.enabled, by, args).sendKeys(Keys.BACK_SPACE);
        }
    }

    protected void waitForElementVisibility(By by, Object... args) {
        step("Wait for element's visibility: " + byLocator(by, args).toString());
        shouldBe(Condition.visible, by, args);
    }

    protected void waitForElementDOMVisibility(By by, Object... args) {
        step("Wait for element's visibility: " + byLocator(by, args).toString());
        shouldBe(Condition.enabled, by, args);
    }

    protected void waitForElementInvisibility(By by, Object... args) {
        step("Wait for element's invisibility: " + byLocator(by, args).toString());
        shouldBe(Condition.hidden, by, args);
    }

    protected boolean isCondition(Condition condition, By by, Object... args) {
        return getSelenideElement(by, args).is(condition);
    }

    protected boolean isElementVisible(By by, Object... args) {
        step("Is visible: " + byLocator(by, args).toString());
        return isCondition(Condition.visible, by, args);
    }
}
