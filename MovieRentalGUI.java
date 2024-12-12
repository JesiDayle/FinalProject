package movierentalsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieRentalGUI extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JButton rentButton, viewDetailsButton, returnButton, loginButton, customerAccountButton, sortButton, searchButton, resetButton;
    private JTextField searchField;
    private JList<String> movieList;
    private DefaultListModel<String> movieListModel;
    private JList<String> rentedMoviesList;
    private DefaultListModel<String> rentedMoviesListModel;
    private MovieTree movieTree = new MovieTree();

    public MovieRentalGUI() {
        setTitle("Movie Rental System");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        movieTree = new MovieTree();

        // Top panel for search, reset, and login
        JPanel topPanel = new JPanel(new BorderLayout());
        searchField = new JTextField("Search movies...");
        topPanel.add(searchField, BorderLayout.CENTER);

        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        topPanel.add(searchButton, BorderLayout.WEST);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        topPanel.add(resetButton, BorderLayout.SOUTH);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        topPanel.add(loginButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        movieListModel = new DefaultListModel<>();
        movieList = new JList<>(movieListModel);

        rentedMoviesListModel = new DefaultListModel<>();
        rentedMoviesList = new JList<>(rentedMoviesListModel);

        rentButton = new JButton("Rent");
        rentButton.addActionListener(this);
        viewDetailsButton = new JButton("View Details");
        viewDetailsButton.addActionListener(this);
        returnButton = new JButton("Return");
        returnButton.addActionListener(this);
        customerAccountButton = new JButton("Customer Account");
        customerAccountButton.addActionListener(this);
        sortButton = new JButton("Sort Movies");
        sortButton.addActionListener(this);

        JPanel moviePanel = new JPanel(new BorderLayout());
        JLabel movieListLabel = new JLabel("Movie Inventory List", JLabel.CENTER);
        moviePanel.add(movieListLabel, BorderLayout.NORTH);
        moviePanel.add(new JScrollPane(movieList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        buttonPanel.add(viewDetailsButton);
        buttonPanel.add(rentButton);
        buttonPanel.add(customerAccountButton);
        buttonPanel.add(sortButton);

        JPanel rentedPanel = new JPanel(new BorderLayout());
        JLabel rentedMoviesLabel = new JLabel("Current Rented Movies", JLabel.CENTER);
        rentedPanel.add(rentedMoviesLabel, BorderLayout.NORTH);
        rentedPanel.add(new JScrollPane(rentedMoviesList), BorderLayout.CENTER);
        rentedPanel.add(returnButton, BorderLayout.SOUTH);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, moviePanel, rentedPanel);
        splitPane.setDividerLocation(400);
        splitPane.setResizeWeight(0.5);
        add(splitPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        populateTestMovies();
    }

    public void populateTestMovies() {
        String[] movies = {
            "The Shining", "Deadpool vs Wolverine", "Constantine",
            "Karate Kid", "Edward Scissorhands", "Fanboys",
            "Split", "Sweeney Todd", "Avatar", "Inception",
            "The Avengers", "The Dark Knight", "Interstellar",
            "Joker", "Parasite", "Titanic", "The Matrix",
            "Gladiator", "Forrest Gump", "The Lion King",
            "Frozen", "Black Panther", "Coco", "Toy Story",
            "Up", "Inside Out", "Zootopia", "Moana",
            "Aladdin", "Beauty and the Beast", "The Little Mermaid",
            "Finding Nemo", "Shrek", "The Incredibles",
            "WALL-E", "Ratatouille", "Monsters, Inc.",
            "Harry Potter and the Sorcerer's Stone",
            "The Lord of the Rings: The Fellowship of the Ring",
            "The Lord of the Rings: The Two Towers",
            "The Lord of the Rings: The Return of the King",
            "Star Wars: A New Hope", "Star Wars: The Empire Strikes Back",
            "Star Wars: Return of the Jedi", "Star Wars: The Force Awakens",
            "Jurassic Park", "Jaws", "E.T. the Extra-Terrestrial",
            "Back to the Future", "Indiana Jones and the Raiders of the Lost Ark"
        };

        // Shuffle the movies to ensure an unsorted display
        java.util.Collections.shuffle(java.util.Arrays.asList(movies));

        // Insert movies into the tree for sorting purposes but do not sort the display list yet
        for (String movie : movies) {
            movieTree.insert(new Movie(movie, "Genre")); // Add movies to the tree
            movieListModel.addElement(movie); // Add unsorted movies to the list model
        }
    }

    private void populateListFromTree() {
        movieTree.inorderTraversal(movie -> movieListModel.addElement(movie.getTitle()));
    }

    private void searchMovies(String query) {
        movieListModel.clear();

        movieTree.inorderTraversal(movie -> {
            if (movie.getTitle().toLowerCase().contains(query.toLowerCase())) {
                movieListModel.addElement(movie.getTitle());
            }
        });

        if (movieListModel.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No movies found matching: " + query);
        }
    }

    private void resetMovies() {
        searchField.setText("");  // Clear the search field
        movieListModel.clear();  // Clear the movie list model
        populateListFromTree();  // Repopulate the movie list
    }

    private void sortMovies() {
        movieListModel.clear(); // Clear the current movie list model
        populateListFromTree(); // Repopulate the movie list using the in-order traversal of the movie tree
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String query = searchField.getText();
            if (query == null || query.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a movie title to search.");
            } else {
                searchMovies(query.trim());
            }
        } else if (e.getSource() == resetButton) {
            resetMovies();
        } else if (e.getSource() == rentButton) {
            String selectedMovie = movieList.getSelectedValue();
            if (selectedMovie != null) {
                movieListModel.removeElement(selectedMovie);
                rentedMoviesListModel.addElement(selectedMovie);
            }
        } else if (e.getSource() == viewDetailsButton) {
            String selectedMovie = movieList.getSelectedValue();
            if (selectedMovie != null) {
                JOptionPane.showMessageDialog(this, "Details of " + selectedMovie);
            }
        } else if (e.getSource() == returnButton) {
            String selectedMovie = rentedMoviesList.getSelectedValue();
            if (selectedMovie != null) {
                rentedMoviesListModel.removeElement(selectedMovie);
                movieListModel.addElement(selectedMovie);
            }
        } else if (e.getSource() == customerAccountButton) {
            JOptionPane.showMessageDialog(this, "Customer Account details feature coming soon.");
        } else if (e.getSource() == sortButton) {
            sortMovies();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MovieRentalGUI().setVisible(true));
    }
}
