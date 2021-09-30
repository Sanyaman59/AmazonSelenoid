import Base.BaseTest;
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
        Assert.assertTrue(Pages.booksPage().atPage());
        Pages.booksPage().displayBooks();
        Pages.desiredBookPage().open();
        Pages.desiredBookPage().waitForPage();
        Book desiredBook = Pages.desiredBookPage().getBook();
        List<Book> books = Pages.booksPage().getBooks();
        desiredBook.correctPrice(books);
        System.out.println(desiredBook.toString());;
        Assert.assertTrue(books.contains(desiredBook));
        Assert.assertEquals(desiredBook.hashCode(), books.get(books.indexOf(desiredBook)).hashCode());
        System.out.println("The book 'Head first...' is in this list. Their hash codes are : "
                + desiredBook.hashCode() + " : " + books.get(books.indexOf(desiredBook)).hashCode());
    }

    @Test
    public void testNavigationPage()
    {
        Pages.navigationPage().waitForPage();
        Pages.navigationPage().goToBooks("Java");
        Pages.booksPage().displayBooks();
    }

    @Test
    public void testDesiredBookPage()
    {
        Pages.desiredBookPage().open();
        Pages.desiredBookPage().waitForPage();
        Pages.desiredBookPage().displayBook();
    }

    @Test
    public void booksTest()
    {
        Pages.navigationPage().waitForPage();
        Pages.navigationPage().goToBooks("Java");
        Assert.assertTrue(Pages.booksPage().atPage());
        System.out.println(Pages.booksPage().getAmountOfBooks());
        System.out.println(Pages.booksPage().getBookName(6));
        System.out.println(Pages.booksPage().getBookAuthor(6));
        System.out.println(Pages.booksPage().getBookPrice(6));
        System.out.println(Pages.booksPage().getBookBestseller(6));
        //Pages.booksPage().displayBooks();
    }
}
