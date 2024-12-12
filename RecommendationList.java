package movierentalsystem;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class RecommendationList {
    private LinkedList<Movie> recommendations;         // LinkedList to store recommended movies
    private Map<Movie, Integer> rentalCounts;          // Map to track the frequency of rentals

    // Constructor
    public RecommendationList() {
        this.recommendations = new LinkedList<>();
        this.rentalCounts = new HashMap<>();
    }

    // Method to add a movie to the recommendation list
    public void addMovie(Movie movie) {
        if (movie == null) {
            throw new IllegalArgumentException("Movie cannot be null.");
        }

        // Increment the count for the movie in the rental history
        rentalCounts.put(movie, rentalCounts.getOrDefault(movie, 0) + 1);

        // If the movie is frequently rented, add or keep it in the recommendation list
        if (!recommendations.contains(movie)) {
            recommendations.add(movie);
        }
    }

    // Method to remove a movie from the recommendation list
    public void removeMovie(Movie movie) {
        recommendations.remove(movie);
        rentalCounts.remove(movie);
    }

    // Method to get the list of recommended movies
    public LinkedList<Movie> getRecommendations() {
        return new LinkedList<>(recommendations);  // Return a copy to preserve encapsulation
    }

    // Method to print the recommendation list
    public void printRecommendations() {
        System.out.println("Recommended Movies:");
        for (Movie movie : recommendations) {
            System.out.println("- " + movie.getTitle() + " (Rented " + rentalCounts.get(movie) + " times)");
        }
    }

    // Optional: Get the top recommended movies by rental count
    public LinkedList<Movie> getTopRecommendations(int n) {
        return recommendations.stream()
                              .sorted((m1, m2) -> Integer.compare(rentalCounts.get(m2), rentalCounts.get(m1)))
                              .limit(n)
                              .collect(Collectors.toCollection(LinkedList::new));
    }
}