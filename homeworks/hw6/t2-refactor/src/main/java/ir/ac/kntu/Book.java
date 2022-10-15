package ir.ac.kntu;

/*
Program Description: Online Store
The Book class is a subclass to Product, practicing the concept of inheritance.
*/
public class Book extends Product {

    private String title;

    private String author;

    /*
     * Book constructor class that creates an instance of book.
     * Because this class extends, the code must use the super keyword to call the
     * Product constructor to initialize price and serialNumber,
     * since these instance variables are shared amongst all products.
     */
    public Book(double price, int serialNumber, String title, String author) {
        super(price, serialNumber);
        setTitle(title);
        setAuthor(author);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Returns a description of the specific book when invoked in a specific format
    @Override
    public String getDescription() {
        return this.title + " by " + this.author;
    }
}
