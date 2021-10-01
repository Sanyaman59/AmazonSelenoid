package actions;

import book.Book;
import pages.Pages;

import java.util.ArrayList;
import java.util.List;

public class BooksAction {

    public List<Book> getBooksFromSearchPage()
    {
        List<Book> books = new ArrayList<>();
        for(int i = 0; i < Pages.booksPage().getAmountOfBooks();i++)
        {
            Book book = new Book();
            book.setName(Pages.booksPage().getBookName(i));
            book.setAuthor(Pages.booksPage().getBookAuthor(i));
            book.setPrice(Pages.booksPage().getBookPrice(i));
            book.setBestseller(Pages.booksPage().getBookBestseller(i));
            books.add(book);
        }
        return books;
    }

    public Book getBookFromSearchPage(int index)
    {
        Book book = new Book();
        book.setName(Pages.booksPage().getBookName(index));
        book.setAuthor(Pages.booksPage().getBookAuthor(index));
        book.setPrice(Pages.booksPage().getBookPrice(index));
        book.setBestseller(Pages.booksPage().getBookBestseller(index));
        return book;
    }

    public void displayBooksFromSearchPage()
    {
        for(int i = 0; i < Pages.booksPage().getAmountOfBooks();i++)
        {
            Book book = new Book();
            System.out.println("Book №"+(i+1));
            book.setName(Pages.booksPage().getBookName(i));
            book.setAuthor(Pages.booksPage().getBookAuthor(i));
            book.setPrice(Pages.booksPage().getBookPrice(i));
            book.setBestseller(Pages.booksPage().getBookBestseller(i));
            System.out.println(book);
        }
    }

    public void displayBookFromSearchPage(int index)
    {
        Book book = new Book();
        System.out.println("Book №"+(index+1));
        book.setName(Pages.booksPage().getBookName(index));
        book.setAuthor(Pages.booksPage().getBookAuthor(index));
        book.setPrice(Pages.booksPage().getBookPrice(index));
        book.setBestseller(Pages.booksPage().getBookBestseller(index));
        System.out.println(book);
        System.out.println();
    }
}
