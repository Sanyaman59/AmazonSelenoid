import Base.BaseTest;
import actions.Actions;
import book.Book;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Pages;

import java.util.List;

public class TestTest extends BaseTest {

    @Test
    public void testEmAll()
    {
        Pages.navigationPage().waitForPage();
        Pages.navigationPage().goToBooks("Java");
        Pages.booksPage().waitForPage();
        List<Book> books = Actions.booksAction().getBooksFromSearchPage();
        Pages.desiredBookPage().open();
        Pages.desiredBookPage().waitForPage();
        Book desiredBook = Actions.desiredBookAction().getBookFromDesiredBookPage();
        desiredBook.correctPrice(books);
        System.out.println(desiredBook);
        Assert.assertTrue(books.contains(desiredBook));
        Assert.assertEquals(desiredBook.hashCode(), books.get(books.indexOf(desiredBook)).hashCode());
        System.out.println("The book '"+desiredBook.getName()+"' is in this list. Their hash codes are : "
                + desiredBook.hashCode() + " : " + books.get(books.indexOf(desiredBook)).hashCode());
    }

    @Test
    public void testNavigationPage()
    {
        Pages.navigationPage().waitForPage();
        Pages.navigationPage().goToBooks("Java");
        Actions.booksAction().displayBooksFromSearchPage();
    }

    @Test
    public void testDesiredBookPage()
    {
        Pages.desiredBookPage().open();
        Pages.desiredBookPage().waitForPage();
        Book book = Actions.desiredBookAction().getBookFromDesiredBookPage();
        System.out.println(book);
        book.setName("Book about Sanya");
        book.setAuthor("Sanya");
        book.setPrice(1000000.50F);
        book.setBestseller(true);
        System.out.println(book);
        Actions.desiredBookAction().displayBookFromDesiredBookPage();
    }

    @Test
    public void booksTest()
    {
        Pages.navigationPage().waitForPage();
        Pages.navigationPage().goToBooks("Java");
        Pages.booksPage().waitForPage();
        Actions.booksAction().displayBookFromSearchPage(6);
        List<Book> books = Actions.booksAction().getBooksFromSearchPage();
        System.out.println(books.get(0));
    }
}
