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
        Assert.assertTrue(Pages.amazonPage().atPage());
        Pages.amazonPage().goToBooks();
        Assert.assertTrue(Pages.booksPage().atPage());
        Pages.booksPage().displayBooks();
        Pages.headFirstPage().open();
        Assert.assertTrue(Pages.headFirstPage().atPage());
        Pages.headFirstPage().displayBook();
        List<Book> books = Pages.booksPage().getBooks();
        Book headFirst = Pages.headFirstPage().getBook();
        if(books.contains(headFirst)) {
            Assert.assertEquals(headFirst.hashCode(), books.get(books.indexOf(headFirst)).hashCode());
            System.out.println("The book 'Head first...' is in this list. Their hash codes are : "
                    + headFirst.hashCode() + " : " + books.get(books.indexOf(headFirst)).hashCode());
            Assert.assertTrue(headFirst.equals(books.get(2)));
        }
        else
            System.out.println("He isn't here, is he?");
    }

    @Test
    public void headFirstTest()
    {
        Pages.headFirstPage().open();
        Assert.assertTrue(Pages.headFirstPage().atPage());
        Pages.headFirstPage().displayBook();
    }

    @Test
    public void booksTest()
    {
        Assert.assertTrue(Pages.amazonPage().atPage());
        Pages.amazonPage().goToBooks();
        Assert.assertTrue(Pages.booksPage().atPage());
        Pages.booksPage().displayBooks();
    }
}
