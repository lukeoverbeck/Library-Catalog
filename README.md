# Library-Catalog

Description:

Allows users to manage a collection of books, CDs, and DVDs. Users can add new items, search for specific titles, and display categorized lists of items. Additionally, the system supports importing and exporting catalog data via CSV files for easy data management.

Features:

Display Catalog: View the entire library collection or filter by Books, CDs, or DVDs.
Search by Title: Find specific items by entering a title.
Add New Items: Supports Books, CDs, or DVDs.
CSV Import/Export: Load items from an existing CSV file or export the current catalog to a new or existing CSV file.
User-Friendly Interface: Simple menu-based system for easy navigation.

How It Works: 

Load Data: The program loads the catalog from an input CSV file (if available).
Menu Navigation: Several different options to interact with the library.
Add Items: The program prompts for relevant details based on the item type.
Search & Display: Can view categorized lists or search by title.
Export Data: The catalog can be saved to a CSV file for future use.

File Structure:

LibraryCatalogApp.java - Main entry point for the application.
Library.java - Handles catalog management, including adding, searching, and exporting items.
LibraryItem.java - Interface for all library items.
Book.java, CD.java, DVD.java - Individual item classes with specific attributes.
