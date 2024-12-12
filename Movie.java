package movierentalsystem;
public class Movie {
    // Attributes
    private String title;
    private String genre;
    private boolean isAvailable;

    // Constructor
    public Movie(String title, String genre) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        if (genre == null || genre.isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be null or empty.");
        }
        this.title = title;
        this.genre = genre;
        this.isAvailable = true;  // default to available
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Methods to rent and return the movie
    public void rent() {
        if (!isAvailable) {
            throw new IllegalStateException("Movie is already rented.");
        }
        isAvailable = false;
        System.out.println(title + " has been rented.");
    }

    public void returnMovie() {
        if (isAvailable) {
            throw new IllegalStateException("Movie is not rented.");
        }
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }

    @Override
    public String toString() {
        return title + " (" + genre + ") - " + (isAvailable ? "Available" : "Rented");
    }
}
