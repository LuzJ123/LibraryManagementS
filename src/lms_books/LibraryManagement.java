package lms_books;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Author: Luz Jimenez
 * Course: Library Management System Project
 * Date: November 2024
 * Class: LibraryManagement
 * This class manages the library system, including adding, removing, checking in/out, and displaying books.
 */
public class LibraryManagement {
    git add .

    private ArrayList<Book> books; // A list to store books

    // Constructor
    public LibraryManagement() {
        books = new ArrayList<>();
    }

    // Add a new book to the library
    public void addBook(String title, String author, String genre, String status) {
        Book newBook = new Book(title, author, genre, status);

        books.add(newBook);
        System.out.println("Book added successfully: " + newBook);
    }

    // Remove a book from the library
    public void removeBook(String title) {
        boolean removed = books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
        if (removed) {
            System.out.println("Book removed successfully: " + title);
        } else {
            System.out.println("Book not found: " + title);
        }
    }

    // Display all books in the library
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Check out a book
    public void checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.getStatus().equalsIgnoreCase("Available")) {
                book.setStatus("Checked Out");
                System.out.println("Book checked out successfully: " + book);
                return;
            }
        }
        System.out.println("Book not found or already checked out: " + title);
    }

    // Check in a book
    public void checkInBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.getStatus().equalsIgnoreCase("Checked Out")) {
                book.setStatus("Available");
                System.out.println("Book checked in successfully" + book);
                return;
            }
        }
        System.out.println("Book not found or already available: " + title);
    }

    // Main method to run the Library Management System
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display menu
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Check Out a Book");
            System.out.println("5. Check In a Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            // Get user input
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1: // Add a book
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter book status (Available/Checked Out): ");
                    String status = scanner.nextLine();
                    library.addBook(title, author, genre, status);
                    break;

                case 2: // Remove a book
                    System.out.print("Enter book title to remove: ");
                    title = scanner.nextLine();
                    library.removeBook(title);
                    break;

                case 3: // Display all books
                    library.displayBooks();
                    break;

                case 4: // Check out a book
                    System.out.print("Enter book title to check out: ");
                    title = scanner.nextLine();
                    library.checkOutBook(title);
                    break;

                case 5: // Check in a book
                    System.out.print("Enter book title to check in: ");
                    title = scanner.nextLine();
                    library.checkInBook(title);
                    break;

                case 6: // Exit
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}

