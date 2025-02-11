import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;

public class Library {

    private List<LibraryItem> libraryItems;

    public Library() {
        libraryItems = new ArrayList<>();
    } // end constructor

    // Load the library catalog from a CSV file
    public void loadCatalogFromCSV(String filename) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            long start = System.currentTimeMillis();

            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into a string array
                String[] data = line.split(",");
                String type = data[0];

                if (type.equalsIgnoreCase("Book")) {
                    Book book = new Book(data[1], Integer.parseInt(data[2]), data[3], data[4]);
                    libraryItems.add(book);
                } else if (type.equalsIgnoreCase("CD")) {
                    CD cd = new CD(data[1], Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]));
                    libraryItems.add(cd);
                } else if (type.equalsIgnoreCase("DVD")) {
                    DVD dvd = new DVD(data[1], Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]));
                    libraryItems.add(dvd);
                } // end else if
            } // end while

            long end = System.currentTimeMillis();
            System.out.println("Catalog imported in " + (end - start) + " ms");

        } catch (IOException e) {
            System.err.println("Error importing catalog: " + e.getMessage());
        } // end catch block

    } // end loadCatalogFromCSV

    // Print out the catalog
    public void displayLibraryCatalog() {

        for (LibraryItem item : libraryItems) {
            System.out.println(item.toString());
        } // end for loop

    } // end displayLibraryCatalog

    // Print out books only
    public void displayBooks() {

        for (LibraryItem item : libraryItems) {
            if (item instanceof Book) {
                System.out.println(item);
            } // end if statement
        } // end for loop

    } // end displayBooks

    // Print out CDs only
    public void displayCDs() {

        for (LibraryItem item : libraryItems) {
            if (item instanceof CD) {
                System.out.println(item);
            } // end if statement
        } // end for loop

    } // end displayCDs

    // Print out DVDs only
    public void displayDVDs() {

        for (LibraryItem item : libraryItems) {
            if (item instanceof DVD) {
                System.out.println(item);
            } // end if statement
        } // end for loop

    } // end displayDVDs

    // Print out any library items with a matching title
    public void searchByTitle(String title) {

        boolean found = false;
        for (LibraryItem item : libraryItems) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                System.out.println(item);
                found = true;
            } // end if statement
        } // end for loop
        if (!found) {
            System.out.println("No such title found.");
        } // end if statement

    } // end searchByTitle

    // Add a library item to the catalog
    public void addItem(int itemType) {

        switch (itemType) {
            case 1:
                addBook();
                break;
            case 2:
                addCD();
                break;
            case 3:
                addDVD();
                break;
            default:
                System.out.println("Invalid item type.");
                break;
        } // end switch

    } // end addItem

    // Add a book to the catalog
    private void addBook() {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter year: ");
            int year = scanner.nextInt();
            System.out.print("Enter author: ");
            String ghost = scanner.nextLine();
            String author = scanner.nextLine();
            System.out.print("Enter ISBN: ");
            String isbn = scanner.nextLine();
            Book book = new Book(title, year, author, isbn);

            if (checkItem(book)) {
                libraryItems.add(book);
                System.out.println("Book added.");
            } else {
                System.out.println("Invalid info for book.");
            } // end else
        } catch (InputMismatchException e) {
            System.err.println("Error adding a book: " + e.getMessage());
        } // end catch block

    } // end addBook

    // Add a CD to the catalog
    private void addCD() {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.println("Enter year: ");
            int year = scanner.nextInt();
            System.out.print("Enter artist: ");
            String artist = scanner.nextLine();
            System.out.println("Enter number of track: ");
            int numOfTracks = scanner.nextInt();
            CD cd = new CD(title, year, artist, numOfTracks);

            if (checkItem(cd)) {
                libraryItems.add(cd);
                System.out.println("CD added.");
            } else {
                System.out.println("Invalid info for CD.");
            } // end else
        } catch (InputMismatchException e) {
            System.err.println("Error adding a dvd: " + e.getMessage());
        } // end catch block

    } // end addCD

    // Add a DVD to the catalog
    private void addDVD() {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.println("Enter year: ");
            int year = scanner.nextInt();
            System.out.print("Enter director: ");
            String director = scanner.nextLine();
            System.out.println("Enter ISBN: ");
            int duration = scanner.nextInt();
            DVD dvd = new DVD(title, year, director, duration);

            if (checkItem(dvd)) {
                libraryItems.add(dvd);
                System.out.println("DVD added.");
            } else {
                System.out.println("Invalid info for DVD.");
            } // end else
        } catch (InputMismatchException e) {
            System.err.println("Error adding a dvd: " + e.getMessage());
        } // end catch block

    } // end addDVD

    // Ensures that the year for the item to be added is valid
    public boolean checkItem(LibraryItem item) {

        return item.getYear() > 0 && item.getYear() < 2026;

    } // end checkItem

    // Exports catalog to a CSV file
    public void exportCatalogToCSV(String filename) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            long start = System.currentTimeMillis();
            for (LibraryItem item : libraryItems) {
                writer.write(item.formatForCSV());
                writer.newLine();
            } // end for loop

            long end = System.currentTimeMillis();
            System.out.println("Catalog exported in " + (end - start) + " ms");

        } catch (IOException e) {
            System.err.println("Error exporting catalog: " + e.getMessage());
        } // end catch block

    } // end exportCatalogToCSV

} // end class
