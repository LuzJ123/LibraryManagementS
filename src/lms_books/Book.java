package lms_books;

public class Book {
    private String title;
    private String author;
    private String genre;
    private String status; // Status: Available, Checked Out, etc.
    private boolean available;

    // Constructor
    public Book(String title, String author, String genre, String status) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.status = status;
        this.available = status.equalsIgnoreCase("Available");
    }


    // Getter for status
    public String getStatus() {
        return status;
    }
    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    // Getter for genre
    public String getGenre() {
        return genre;
    }
    public boolean isAvailable() {
        return available;
    }

    // Setters
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Status: " + status;
    }
}

