
package movierentalsystem;

import javax.swing.SwingUtilities;

public class MovieRentalGUITest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MovieRentalGUI gui = new MovieRentalGUI();
            gui.populateTestMovies();
            gui.setVisible(true);
        });
    }
}