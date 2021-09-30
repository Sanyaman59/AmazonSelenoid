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
    private By listOfBooks = By.xpath("//div[contains(@class, 's-main-slot') and contains(@class, 's-result-list')]//div[contains(@data-component-type, 's-search-result')]");
//                                              s-main-slot s-result-list s-search-results sg-row
    private By books1 = By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']" +
            "/div[@class='s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 sg-col sg-col-12-of-16']");
//                        s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 sg-col sg-col-12-of-16

    private By books2 = By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']" +
            "/div[@class='s-result-item s-asin sg-col-0-of-12 s-spacing-small sg-col-16-of-20 sg-col sg-col-12-of-16']");


    private List<SelenideElement> webBooks;
    private List<Book> books = new ArrayList<>();

    private By booksNames = By.xpath("//div[contains(@class, 's-main-slot') and contains(@class, 's-result-list')]//div[contains(@data-component-type, 's-search-result')]//h2/a/span");
    private By authorsNames = By.xpath("//div[contains(@class, 's-main-slot') and contains(@class, 's-result-list')]//div[contains(@data-component-type, 's-search-result')]//div[contains(@class, 'a-row')]/div[@class='a-row']");
    private By booksPrices = By.xpath("//div[contains(@class, 's-main-slot') and contains(@class, 's-result-list')]//div[contains(@data-component-type, 's-search-result')]//span[@class='a-price']");

    public void printAuthors()
    {
        List<SelenideElement> elements = getElements(booksNames);
        for(int i = 0;i < getElements(booksNames).size();i++)
        {
            System.out.println(elements.get(i).getText());
        }
    }

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

    public BooksPage()
    {
        webBooks = getElements(listOfBooks);
        createBooks();
    }

    private void createBooks()
    {
        for(int i = 0;i < webBooks.size();i++)
        {
            String name = getBookName(i);
            String author = getBookAuthor(i);
            float price = 0;
            if(webBooks.get(i)
                    .findElements(By.xpath(".//span[@class='a-price']"))
                    .size()!=0)
            {
                price = Float.parseFloat(webBooks.get(i)
                        .findElement(By.xpath(".//span[@class='a-price']"))
                        .getText()
                        .replace('\n', '.')
                        .substring(1));
            }

            if(webBooks.get(i)
                    .findElements(By.xpath(".//*[text()='Best Seller']"))
                    .size()!=0)
            {
                books.add(new Book(name,author,price,true));
            }
            else
            {
                books.add(new Book(name, author, price));
            }
        }
    }

    public List<Book> getBooks()
    {
        return books;
    }

    public void close()
    {
        Selenide.closeWebDriver();
    }

    public void displayBooks()
    {
        for(Book wb : books)
        {
            System.out.println(wb.toString());
            System.out.println("-------------------------------------");
        }
    }

    public void displayBook(int index)
    {
        try
        {
            System.out.println(books.get(index).toString());
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("You entered too big value for index. The maximum number of elements is " + books.size());
        }
    }

    public boolean atPage()
    {
        if(Selenide.title().contains("Amazon.com : Java"))
            return true;
        else
            return false;
    }
}
