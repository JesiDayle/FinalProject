package movierentalsystem;
import java.util.LinkedList;

public class RentalHistory {
    // Attributes
    private LinkedList<Movie> history;

    // Constructor
    public RentalHistory() {
        this.history = new LinkedList<>();
    }

    // Add a movie to the rental history
    public void addRental(Movie movie) {
        if (movie == null) {
            throw new IllegalArgumentException("Movie cannot be null.");
        }
        history.add(movie);
        System.out.println(movie.getTitle() + " added to rental history.");
    }

    // Display rental history
    public void printHistory() {
        if (history.isEmpty()) {
            System.out.println("No rentals in history.");
        } else {
            System.out.println("Rental History:");
            for (Movie movie : history) {
                System.out.println("- " + movie.getTitle() + " (" + movie.getGenre() + ")");
            }
        }
    }

    // Check if a movie has been rented before
    public boolean hasRented(Movie movie) {
        return history.contains(movie);
    }

    // Getter for history
    public LinkedList<Movie> getHistory() {
        return history;
    }
}