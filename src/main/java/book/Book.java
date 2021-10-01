package book;

import java.util.List;
import java.util.Objects;

public class Book {
    private String name;
    private String author;
    private float price = 0;
    private String bestseller;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public String getBestseller() {
        return bestseller;
    }
    public void setBestseller(boolean bestseller) {
        if(bestseller == true)
        {
            this.bestseller = "Bestseller";
        }
        else
        {
            this.bestseller = "Not a bestseller";
        }
    }

    public Book()
    {
        this.name = "";
        this.author = "";
        this.price = 0;
        this.bestseller = "Not a bestseller";
    }

    public Book(String name, String author, float price)
    {
        this.name = name;
        this.author = author;
        this.price = price;
        this.bestseller = "Not a bestseller";
    }

    public Book(String name, String author, float price, boolean bestseller)
    {
        this.name = name;
        this.author = author;
        this.price = price;
        if(bestseller==true)
            this.bestseller="Bestseller";
        else
            this.bestseller="Not a bestseller";
    }

    public Book(String name, String author)
    {
        this.name = name;
        this.author = author;
        this.bestseller = "Not a bestseller";
    }

    public Book(String name, String author, boolean bestseller)
    {
        this.name = name;
        this.author = author;
        if(bestseller==true)
            this.bestseller="Bestseller";
        else
            this.bestseller="Not a bestseller";
    }

    @Override
    public String toString()
    {
        return "Book : "+name +";\n"
                +"Author : "+author+";\n"
                +"Price : "+price+";\n"
                +bestseller+".\n";
    }

    @Override
    public boolean equals(Object o)
    {
        if(o==this)
            return true;
        if(!(o instanceof Book))
            return false;
        Book other = (Book) o;
        boolean nameEquals = (this.name == null && other.name == null)
                || (this.name != null && this.name.equals(other.name));
        boolean authorEquals = (this.author == null && other.author == null)
                || (this.author != null && this.author.equals(other.author));
        boolean priceEquals = (this.price == 0.0f && other.price == 0.0f)
                || (this.price != 0.0f && Float.compare(this.price,other.price)==0);
        boolean bestsellerEquals = (this.bestseller == null && other.bestseller == null)
                || (this.bestseller != null && this.bestseller.equals(other.bestseller));
        return nameEquals && authorEquals && priceEquals && bestsellerEquals;
    }

    public static boolean equals(Book one, Book two)
    {

        if(one == two)
            return true;
        if(!(one instanceof Book))
            return false;
        Book other = (Book) one;
        boolean nameEquals = (two.name == null && other.name == null)
                || (two.name != null && two.name.equals(other.name));
        boolean authorEquals = (two.author == null && other.author == null)
                || (two.author != null && two.author.equals(other.author));
//        boolean priceEquals = (two.price == 0.0f && other.price == 0.0f)
//                || (two.price != 0.0f && Float.compare(two.price,other.price)==0);
        boolean bestsellerEquals = (two.bestseller == null && other.bestseller == null)
                || (two.bestseller != null && two.bestseller.equals(other.bestseller));
        return nameEquals && authorEquals && bestsellerEquals;
    }

    public void correctPrice(List<Book> correctBook)
    {
        for(int i = 0; i < correctBook.size(); i++) {
            if (this.name.toString().contains(correctBook.get(i).name.toString())
                    && this.author.toString().contains(correctBook.get(i).author.toString())
                    && this.bestseller == correctBook.get(i).bestseller) {
                this.price = correctBook.get(i).price;
            }
        }
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name,author,price,bestseller);
    }
}
