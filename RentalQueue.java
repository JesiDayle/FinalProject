package movierentalsystem;
import java.util.LinkedList;
import java.util.Queue;

public class RentalQueue {
    // Queue to store rental requests, where each entry is a rental request by a customer
    private Queue<RentalRequest> rentalQueue;

    // Constructor
    public RentalQueue() {
        this.rentalQueue = new LinkedList<>();
    }

    // Add a new rental request to the queue
    public void addRentalRequest(Customer customer, Movie movie) {
        if (customer == null || movie == null) {
            throw new IllegalArgumentException("Customer and Movie cannot be null.");
        }

        RentalRequest request = new RentalRequest(customer, movie);
        rentalQueue.add(request);
        System.out.println("Added rental request for " + movie.getTitle() + " by " + customer.getName());
    }

    // Process (remove) the next rental request in the queue
    public void processNextRequest() {
        if (rentalQueue.isEmpty()) {
            System.out.println("No pending rental requests.");
        } else {
            RentalRequest request = rentalQueue.poll(); // Retrieves and removes the head of the queue
            System.out.println("Processing rental for " + request.getMovie().getTitle() + " by " + request.getCustomer().getName());
            // Here you can call additional methods to finalize the rental, e.g., adding to rental history
        }
    }

    // View the next request in line without removing it
    public RentalRequest peekNextRequest() {
        return rentalQueue.peek(); // Retrieves but does not remove the head of the queue
    }

    // Check if there are any pending requests
    public boolean hasPendingRequests() {
        return !rentalQueue.isEmpty();
    }

    // Print all pending rental requests
    public void printPendingRequests() {
        if (rentalQueue.isEmpty()) {
            System.out.println("No pending rental requests.");
        } else {
            System.out.println("Pending Rental Requests:");
            for (RentalRequest request : rentalQueue) {
                System.out.println("- " + request.getCustomer().getName() + " requested " + request.getMovie().getTitle());
            }
        }
    }
}