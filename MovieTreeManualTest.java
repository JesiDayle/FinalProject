
package movierentalsystem;

public class MovieTreeManualTest {
    public static void main(String[] args) {
        MovieTree movieTree = new MovieTree();

        // Insert movies into the tree
        movieTree.insert(new Movie("The Shining", "Horror"));
        movieTree.insert(new Movie("Deadpool vs Wolverine", "Action"));
        movieTree.insert(new Movie("Split", "Thriller"));

        // In-order traversal
        System.out.println("Movies in sorted order:");
        movieTree.inorderTraversal(movie -> System.out.println(movie.getTitle()));

        // Search for a movie
        String searchTitle = "The Shining";
        Movie found = movieTree.search(searchTitle);
        System.out.println("Search for '" + searchTitle + "': " + (found != null ? found.getTitle() : "Not found"));

        // Search for a missing movie
        String missingTitle = "Non-Existent";
        Movie missing = movieTree.search(missingTitle);
        System.out.println("Search for '" + missingTitle + "': " + (missing != null ? missing.getTitle() : "Not found"));
    }
}