package pages;

import Base.BasePage;
import book.Book;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Constants;

import java.util.List;

public class HeadFirstPage extends BasePage {
    private Book headFirst;
    static final String APP_URL = "https://www.amazon.com/Head-First-Java-Kathy-Sierra/dp/0596009208/ref=sr_1_2?dchild=1&keywords=Java&qid=1610356790&s=books&sr=1-2";
    private By book = By.xpath(".//span[@class='a-size-base mediaTab_subtitle']");
    private By bookName = By.xpath(".//span[@id='productTitle']");
    private By bookAuthor = By.xpath(".//div[@id='bylineInfo_feature_div']");
    private By bestsellerBadge = By.xpath(".//i[@class='a-icon a-icon-addon p13n-best-seller-badge']");

    public void open()
    {
        Selenide.open(APP_URL);
        createBook();
    }

    public void close()
    {
        Selenide.closeWebDriver();;
    }

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
            headFirst = new Book(name,author,price,true);
        }
        else
        {
            headFirst = new Book(name,author,price);
        }
    }

    public Book getBook()
    {
        return headFirst;
    }

    public void displayBook()
    {
        System.out.println(headFirst.toString());
    }

    public boolean atPage()
    {
        if(Selenide.title().contains("Head First Java, 2nd Edition: Sierra, Kathy, Bates, Bert: 8601404235726: Amazon.com: Books"))
            return true;
        else
            return false;
    }
}
