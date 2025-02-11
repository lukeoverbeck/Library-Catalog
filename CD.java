public class CD implements LibraryItem {

    private String title;
    private int year;
    private String artist;
    private int numOfTracks;

    public CD(String title, int year, String artist, int numOfTracks) {
        this.title = title;
        this.year = year;
        this.artist = artist;
        this.numOfTracks = numOfTracks;
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
        return "CD," + title + "," + year + ","
                + artist + "," + numOfTracks;
    } // end formatForCSV

    public String toString() {
        return "CD: " + title + " (" + year + ") by "
                + artist + " [" + numOfTracks + "]";
    } // end toString

} // end class
