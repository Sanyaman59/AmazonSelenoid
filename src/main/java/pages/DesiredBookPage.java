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
    private By bookPrice = By.xpath(".//span[@class='a-size-base mediaTab_subtitle']");
    private By bookName = By.xpath(".//span[@id='productTitle']");
    private By authorName = By.xpath(".//div[@id='bylineInfo_feature_div']");
    private By bestsellerBadge = By.xpath(".//i[@class='a-icon a-icon-addon p13n-best-seller-badge']");


    public String getBookName()
    {
        waitForElementVisibility(bookName);
        return getElementText(bookName);
    }

    public String getBookAuthor()
    {
        waitForElementVisibility(authorName);
        String author = getElementText(authorName)
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
        return author;
    }

    public float getBookPrice()
    {
        List<SelenideElement> p = getElements(bookPrice);

        
        float price;
        try {
            price = Float.parseFloat(p.get(0).getText().substring(1, p.get(0).getText().indexOf(" ")));
        }
        catch(StringIndexOutOfBoundsException e)
        {
            price = Float.parseFloat(p.get(0).getText().substring(1));
        }
        return price;
    }

    public boolean getBookBestseller()
    {
        if(getSelenideElement(bestsellerBadge).exists())
            return true;
        else
            return false;
    }

    public void open()
    {
        Selenide.open(Constants.DESIRED_BOOK_URL);
    }

    public void waitForPage()
    {
        waitForElementDOMVisibility(title);
    }
}
