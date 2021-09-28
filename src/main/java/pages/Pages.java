package pages;

public class Pages {

    private static AmazonPage amazonPage;
    private static BooksPage booksPage;
    private static HeadFirstPage headFirstPage;

    public static AmazonPage amazonPage()
    {
        if(amazonPage == null)
        {
            amazonPage = new AmazonPage();
        }
        return amazonPage;
    }

    public static BooksPage booksPage()
    {
        if(booksPage == null)
        {
            booksPage = new BooksPage();
        }
        return booksPage;
    }

    public static HeadFirstPage headFirstPage()
    {
        if(headFirstPage == null)
        {
            headFirstPage = new HeadFirstPage();
        }
        return headFirstPage;
    }
}
