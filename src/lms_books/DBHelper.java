package lms_books;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
git add .

public class DBHelper {

    private static final String URL = "jdbc:sqlite:lms_books.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Connected to SQLite database.");
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
        return conn;
    }

    public static void createTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS books (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    title TEXT NOT NULL,
                    author TEXT NOT NULL,
                    genre TEXT NOT NULL,
                    available BOOLEAN NOT NULL
                );
                """;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'books' created or already exists.");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    public static void addBook(String title, String author, String genre) {
        String sql = "INSERT INTO books (title, author, genre, available) VALUES (?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, genre);
            pstmt.setBoolean(4, true); // Default availability
            pstmt.executeUpdate();
            System.out.println("Book added: " + title);
        } catch (SQLException e) {
            System.err.println("Error adding book: " + e.getMessage());
        }
    }

    public static void displayBooks() {
        String sql = "SELECT * FROM books";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + ", Title: " + rs.getString("title")
                        + ", Author: " + rs.getString("author")
                        + ", Genre: " + rs.getString("genre")
                        + ", Available: " + rs.getBoolean("available"));
            }
        } catch (SQLException e) {
            System.err.println("Error displaying books: " + e.getMessage());
        }
    }
}

