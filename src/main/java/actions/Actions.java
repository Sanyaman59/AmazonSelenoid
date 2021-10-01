package actions;

public class Actions {

    private static BooksAction booksAction;
    private static DesiredBookAction desiredBookAction;

    public static BooksAction booksAction()
    {
        if(booksAction == null)
        {
            booksAction = new BooksAction();
        }
        return booksAction;
    }

    public static DesiredBookAction desiredBookAction()
    {
        if(desiredBookAction == null)
        {
            desiredBookAction = new DesiredBookAction();
        }
        return desiredBookAction;
    }
}
