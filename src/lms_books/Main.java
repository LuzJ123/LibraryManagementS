package lms_books;

import java.util.Scanner;
git add .
git commit -m "Initial commit with all project files"


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Initialize the database
        DBHelper.createTable();

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book genre: ");
                    String genre = scanner.nextLine();
                    DBHelper.addBook(title, author, genre);
                }
                case 2 -> {
                    System.out.print("Enter book title to remove: ");
                    String title = scanner.nextLine();
                    // Example: You'd need a method in DBHelper to remove a book
                    // DBHelper.removeBook(title);
                    System.out.println("Feature not implemented.");
                }
                case 3 -> DBHelper.displayBooks();
                case 4 -> System.out.println("Exiting the Library Management System. Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
