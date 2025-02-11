import java.util.*;

public class LibraryCatalogApp {

    public static void main(String[] args) {

        // Initialize library catalog
        Library library = new Library();

        // Load existing catalog from CSV if available
        library.loadCatalogFromCSV("input.csv");

        // Main menu loop
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            handleUserChoice(choice, library);
        } // end while loop

    } // end main

    // Display the menu options
    private static void displayMenu() {
        System.out.println("\nMain Menu: ");
        System.out.println("1. Display Entire Library Catalog");
        System.out.println("2. Display Books only");
        System.out.println("3. Display CDs only");
        System.out.println("4. Display DVDs only");
        System.out.println("5. Search by Title");
        System.out.println("6. Add a new item");
        System.out.println("7. Export Library Catalog to CSV");
        System.out.println("8. Import new items from a CSV");
        System.out.println("9. Exit\n");
    } // end displayMenu

    // Get user's menu choice
    private static int getUserChoice() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    } // end getUserChoice

    // Uses an Integer, Runnable HashMap to handle user choice
    private static void handleUserChoice(int choice, Library library) {

        Map<Integer, Runnable> menu = new HashMap<>();

        menu.put(1, library::displayLibraryCatalog);
        menu.put(2, library::displayBooks);
        menu.put(3, library::displayCDs);
        menu.put(4, library::displayDVDs);
        menu.put(5, () -> {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the title: ");
            String title = scan.nextLine();
            library.searchByTitle(title);
        });
        menu.put(6, () -> {
            Scanner scan = new Scanner(System.in);
            System.out.println("""
                    Please enter the type of item you would like to add:\s
                    1. Book\s
                    2. CD\s
                    3. DVD""");
            int type = scan.nextInt();
            library.addItem(type);
        });
        menu.put(7, () -> {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the name for the file you would like to export the data to: ");
            String filename = scan.nextLine();
            library.exportCatalogToCSV(filename);
        });
        menu.put(8, () -> {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the name for the file you would like to import: ");
            String filename = scan.nextLine();
            library.loadCatalogFromCSV(filename);
        });
        menu.put(9, () -> System.exit(0));

        Runnable runnable = menu.get(choice);
        if (runnable != null) {
            runnable.run();
        } else {
            System.out.println("Invalid choice");
        } // end else statement

    } // end handleUserChoice

} // end class
