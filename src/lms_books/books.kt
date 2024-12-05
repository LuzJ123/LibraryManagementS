package lms_books

class books {
    /**
     * A class representing a book in the library management system.
     */
    inner class Book // Constructor with ID (used for existing books)
        (// Getters and Setters
        var id: Int, // Unique identifier for the book
        // Title of the book
        var title: String, // Author of the book
        var author: String, // Genre of the book
        var genre: String, // Availability status of the book
        var isAvailable: Boolean
    ) {
        // Constructor without ID (used for new books before database assignment)
        constructor(title: String, author: String, genre: String, available: Boolean) : this(
            -1,
            title,
            author,
            genre,
            available
        )

        override fun toString(): String {
            return String.format(
                "Book[ID: %d, Title: %s, Author: %s, Genre: %s, Available: %s]",
                id, title, author, genre, if (isAvailable) "Yes" else "No"
            )
        }
    }
}
