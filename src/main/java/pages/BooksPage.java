package pages;

import Base.BasePage;
import book.Book;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ListSizeMismatch;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BooksPage extends BasePage {
    private List<Book> books = new ArrayList<>();

    private By title = By.xpath("//title");
    private By listOfBooks = By.xpath("//div[contains(@class, 's-main-slot') and contains(@class, 's-result-list')]//div[contains(@data-component-type, 's-search-result')]");
    private By booksNames = By.xpath("//div[contains(@class, 's-main-slot') and contains(@class, 's-result-list')]//div[contains(@data-component-type, 's-search-result')]//h2/a/span");
    private By authorsNames = By.xpath("//div[contains(@class, 's-main-slot') and contains(@class, 's-result-list')]//div[contains(@data-component-type, 's-search-result')]//div[contains(@class, 'a-row')]/div[@class='a-row']");
    private By booksPrices = By.xpath("//div[contains(@class, 's-main-slot') and contains(@class, 's-result-list')]//div[contains(@data-component-type, 's-search-result')]//span[@class='a-price']");


    public String getBookName(int index){
        waitForElementVisibility(booksNames, index);
        return getElements(booksNames).get(index).getText();
    }

    public String getBookAuthor(int index)
    {
        waitForElementVisibility(authorsNames, index);
        String author = getElements(authorsNames).get(index).getText();
        try {
            author = author.substring(author.indexOf("by"), author.lastIndexOf('|') - 1);
        }
        catch(StringIndexOutOfBoundsException e)
        {
            System.out.println("Problem is fixed, but you can read the exception description anyway: ");
            e.printStackTrace();
        }
        return author;
    }

    public float getBookPrice(int index)
    {
        waitForElementVisibility(booksPrices, index);
        float price = Float.parseFloat(getElements(booksPrices).get(index).getText().replace('\n', '.').substring(1));
        return price;
    }

    public boolean getBookBestseller(int index)
    {
        if(getElements(listOfBooks).get(index).findElements(By.xpath(".//*[text()='Best Seller']")).size()!=0)
        {
            return true;
        }
        return false;
    }

    public int getAmountOfBooks(){
        return getElements(listOfBooks).size();
    }

    public void waitForPage()
    {
        waitForElementDOMVisibility(title);
    }
}
