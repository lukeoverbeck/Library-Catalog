public class DVD implements LibraryItem {

    private String title;
    private int year;
    private String director;
    private int duration;

    public DVD(String title, int year, String director, int duration) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.duration = duration;
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
        return "DVD," + title + "," + year + ","
                + director + "," + duration;
    } // end formatForCSV

    public String toString() {
        return "DVD: " + title + " (" + year + ") by "
                + director + " [" + duration + "]";
    } // end toString

} // end class
