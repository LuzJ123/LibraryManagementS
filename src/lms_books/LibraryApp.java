package lms_books;


import java.util.Scanner;  // Importing Scanner class
import lms_books.Library;  // Importing Library class (if in the same package, this is optional)
import lms_books.Book;     // Importing Book class (if in the same package, this is optional)
git add .

public class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Display all books");
            System.out.println("4. Check out a book");
            System.out.println("5. Check in a book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter book status (Available/Checked Out): ");
                    String status = scanner.nextLine();

                    Book book = new Book(title, author, genre, status);
                    library.addBook(book);
                }

                case 2 -> {
                    System.out.print("Enter book title to remove: ");
                    String title = scanner.nextLine();
                    library.removeBook(title);
                }

                case 3 -> {
                    library.displayBooks();
                }

                case 4 -> {
                    System.out.print("Enter book title to check out: ");
                    String title = scanner.nextLine();
                    library.checkOutBook(title);
                }

                case 5 -> {
                    System.out.print("Enter book title to check in: ");
                    String title = scanner.nextLine();
                    library.checkInBook(title);
                }

                case 6 -> {
                    System.out.println("Exiting the Library Management System. Goodbye!");
                }

                default -> {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        } while (choice != 6);


        scanner.close();
    }
}

