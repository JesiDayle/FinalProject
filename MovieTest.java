
package movierentalsystem;

public class MovieTest {
    public static void main(String[] args) {
        // Test creating a movie
        Movie movie = new Movie("The Shining", "Horror");
        System.out.println("Title: " + movie.getTitle());
        System.out.println("Genre: " + movie.getGenre());
        System.out.println("Availability: " + (movie.isAvailable() ? "Available" : "Rented"));

        // Test renting the movie
        movie.rent();
        System.out.println("After renting: " + (movie.isAvailable() ? "Available" : "Rented"));

        // Test returning the movie
        movie.returnMovie();
        System.out.println("After returning: " + (movie.isAvailable() ? "Available" : "Rented"));

        // Test invalid operations
        try {
            movie.returnMovie(); // Should throw an exception
        } catch (IllegalStateException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}