package movierentalsystem;

public class MovieTree {
    private MovieNode root;

    // Inner class to represent nodes in the tree
    private static class MovieNode {
        Movie movie;
        MovieNode left, right;

        public MovieNode(Movie movie) {
            if (movie == null) {
                throw new IllegalArgumentException("Movie cannot be null.");
            }
            this.movie = movie;
            this.left = this.right = null;
        }
    }

    // Insert a movie into the tree
    public void insert(Movie movie) {
        root = insertRec(root, movie);
    }

    private MovieNode insertRec(MovieNode root, Movie movie) {
        if (root == null) {
            return new MovieNode(movie);
        }
        if (movie.getTitle().compareTo(root.movie.getTitle()) < 0) {
            root.left = insertRec(root.left, movie);
        } else if (movie.getTitle().compareTo(root.movie.getTitle()) > 0) {
            root.right = insertRec(root.right, movie);
        }
        return root;
    }

    // Perform an in-order traversal and apply a consumer to each movie
    public void inorderTraversal(java.util.function.Consumer<Movie> action) {
        inorderRec(root, action);
    }

    private void inorderRec(MovieNode root, java.util.function.Consumer<Movie> action) {
        if (root != null) {
            inorderRec(root.left, action);
            action.accept(root.movie);
            inorderRec(root.right, action);
        }
    }

    // Search for a movie by title
    public Movie search(String title) {
        return searchRec(root, title);
    }

    private Movie searchRec(MovieNode root, String title) {
        if (root == null || root.movie.getTitle().equals(title)) {
            return (root == null) ? null : root.movie;
        }
        if (title.compareTo(root.movie.getTitle()) < 0) {
            return searchRec(root.left, title);
        }
        return searchRec(root.right, title);
    }

    // Check if the tree is empty
    public boolean isEmpty() {
        return root == null;
    }
}