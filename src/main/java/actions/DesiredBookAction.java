package actions;

import book.Book;
import pages.Pages;

public class DesiredBookAction {

    public Book getBookFromDesiredBookPage()
    {
        Book book = new Book();
        book.setName(Pages.desiredBookPage().getBookName());
        book.setAuthor(Pages.desiredBookPage().getBookAuthor());
        book.setPrice(Pages.desiredBookPage().getBookPrice());
        book.setBestseller(Pages.desiredBookPage().getBookBestseller());
        return book;
    }

    public void displayBookFromDesiredBookPage()
    {
        Book book = new Book();
        System.out.println("Desired book");
        book.setName(Pages.desiredBookPage().getBookName());
        book.setAuthor(Pages.desiredBookPage().getBookAuthor());
        book.setPrice(Pages.desiredBookPage().getBookPrice());
        book.setBestseller(Pages.desiredBookPage().getBookBestseller());
        System.out.println(book);
    }
}
