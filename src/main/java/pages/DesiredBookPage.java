package pages;

import Base.BasePage;
import book.Book;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.Constants;

import java.util.List;

public class DesiredBookPage extends BasePage {
    private Book desiredBook;

    private By title = By.xpath("//title");

    private By book = By.xpath(".//span[@class='a-size-base mediaTab_subtitle']");
    private By bookName = By.xpath(".//span[@id='productTitle']");
    private By bookAuthor = By.xpath(".//div[@id='bylineInfo_feature_div']");
    private By bestsellerBadge = By.xpath(".//i[@class='a-icon a-icon-addon p13n-best-seller-badge']");

    private void createBook()
    {
        List<SelenideElement> p = getElements(book);
        float price = Float.parseFloat(p.get(0).getText().substring(1,p.get(0).getText().indexOf(" ")));
        String name = getElementText(bookName);
        String author = getElementText(bookAuthor)
                .replace("(Author)","").replace(",","");
        String[] fullAuthor = author.split("\n");
        author = fullAuthor[0] + " ";
        for(int i = 1;i < fullAuthor.length;i++)
        {
            author+=fullAuthor[i];
            if(i+1 < fullAuthor.length)
            {
                author+="and ";
            }
        }
        author = author.trim();
        if(getSelenideElement(bestsellerBadge)
                .exists())
        {
            desiredBook = new Book(name,author,price,true);
        }
        else
        {
            desiredBook = new Book(name,author,price);
        }
    }

    public void open()
    {
        Selenide.open(Constants.DESIRED_BOOK_URL);
        createBook();
    }

    public Book getBook()
    {
        return desiredBook;
    }

    public void displayBook()
    {
        System.out.println(desiredBook.toString());
    }

    public void waitForPage()
    {
        waitForElementDOMVisibility(title);
    }
}
