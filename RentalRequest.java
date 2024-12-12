package movierentalsystem;
public class RentalRequest {
    private Customer customer;
    private Movie movie;

    // Constructor
    public RentalRequest(Customer customer, Movie movie) {
        this.customer = customer;
        this.movie = movie;
    }

    // Getters
    public Customer getCustomer() {
        return customer;
    }

    public Movie getMovie() {
        return movie;
    }
}