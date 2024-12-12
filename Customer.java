package movierentalsystem;
import java.util.LinkedList;
import java.util.Objects;

public class Customer {
    // Attributes
    private String customerID;
    private String name;
    private LinkedList<Movie> rentalHistory;       // Linked list to track rental history
    private LinkedList<Movie> recommendationList;   // Linked list for frequently rented movies

    // Constructor
    public Customer(String customerID, String name) {
        if (customerID == null || customerID.isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty.");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.customerID = customerID;
        this.name = name;
        this.rentalHistory = new LinkedList<>();
        this.recommendationList = new LinkedList<>();
    }

    // Getters
    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public LinkedList<Movie> getRentalHistory() {
        return rentalHistory;
    }

    public LinkedList<Movie> getRecommendationList() {
        return recommendationList;
    }

    // Rent a Movie: Add movie to rental history and possibly to recommendations
    public void rentMovie(Movie movie) {
        if (movie == null) {
            throw new IllegalArgumentException("Movie cannot be null.");
        }

        // Add movie to rental history
        rentalHistory.add(movie);

        // Optionally add to recommendation list if frequently rented
        if (!recommendationList.contains(movie)) {
            recommendationList.add(movie);
        }

        System.out.println(name + " (ID: " + customerID + ") rented the movie: " + movie.getTitle());
    }

    // Return a Movie: Add movie to rental history log (if using a separate class for history tracking)
    public void returnMovie(Movie movie) {
        if (movie == null) {
            throw new IllegalArgumentException("Movie cannot be null.");
        }

        // Add movie to rental history if needed
        if (!rentalHistory.contains(movie)) {
            rentalHistory.add(movie);
        }

        System.out.println(name + " (ID: " + customerID + ") returned the movie: " + movie.getTitle());
    }

    // Print Rental History
    public void printRentalHistory() {
        System.out.println("Rental History for " + name + " (ID: " + customerID + "):");
        for (Movie movie : rentalHistory) {
            System.out.println("- " + movie.getTitle());
        }
    }

    // Print Recommendation List
    public void printRecommendationList() {
        System.out.println("Recommended Movies for " + name + " (ID: " + customerID + "):");
        for (Movie movie : recommendationList) {
            System.out.println("- " + movie.getTitle());
        }
    }

    // Override equals to compare based on customerID
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
			return true;
		}
        if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
        Customer customer = (Customer) obj;
        return customerID.equals(customer.customerID);
    }

    // Override hashCode based on customerID
    @Override
    public int hashCode() {
        return Objects.hash(customerID);
    }

    // Override toString for meaningful Customer representation
    @Override
    public String toString() {
        return "Customer[ID: " + customerID + ", Name: " + name + "]";
    }
}
