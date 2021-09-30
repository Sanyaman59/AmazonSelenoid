package pages;

public class Pages {

    private static NavigationPage navigationPage;
    private static BooksPage booksPage;
    private static DesiredBookPage desiredBookPage;

    public static NavigationPage navigationPage()
    {
        if(navigationPage == null)
        {
            navigationPage = new NavigationPage();
        }
        return navigationPage;
    }

    public static BooksPage booksPage()
    {
        if(booksPage == null)
        {
            booksPage = new BooksPage();
        }
        return booksPage;
    }

    public static DesiredBookPage desiredBookPage()
    {
        if(desiredBookPage == null)
        {
            desiredBookPage = new DesiredBookPage();
        }
        return desiredBookPage;
    }
}
