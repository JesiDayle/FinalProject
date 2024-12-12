package movierentalsystem;

public class Main {
    public static void main(String[] args) {
        // Create some Movie instances
        Movie movie1 = new Movie("The Matrix", "Sci-Fi");
        Movie movie2 = new Movie("Inception", "Sci-Fi");
        Movie movie3 = new Movie("Toy Story", "Animation");

        // Create a Customer instance
        Customer customer = new Customer("C123", "John Doe");

        // Rent movies
        customer.rentMovie(movie1);
        customer.rentMovie(movie2);
        customer.rentMovie(movie3);

        // Return a movie
        customer.returnMovie(movie1);

        // Print rental history
        customer.printRentalHistory();

        // Print recommendations (based on rentMovie calls)
        customer.printRecommendationList();
    }
}