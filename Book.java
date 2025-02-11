public class Book implements LibraryItem {

    private String title;
    private int year;
    private String author;
    private String isbn;

    public Book(String title, int year, String author, String isbn) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.isbn = isbn;
    } // end constructor

    @Override
    public String getTitle() {
        return title;
    } // end getTitle

    @Override
    public int getYear() {
        return year;
    } // end getYear

    @Override
    public String formatForCSV() {
        return "Book," + title + "," + year + "," + author + "," + isbn;
    } // end formatForCSB

    @Override
    public String toString() {
        return "Book: " + title + " (" + year + ") by "
                + author + " [ISBN: " + isbn + "]";
    } // end toString
}
