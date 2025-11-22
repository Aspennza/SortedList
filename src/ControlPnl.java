import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Allows the creation of pre-designed JPanel objects with JButton controls
 * for resetting the ListCreator, searching the list, and quitting the program.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class ControlPnl extends JPanel
{
    //This JButton is used to reset the program
    JButton resetBtn;

    //This JButton is used to search the SortedList
    JButton searchBtn;

    //This JButton is used to quit the program
    JButton quitBtn;

    //This constructor instantiates the buttons and gives the panel a layout
    public ControlPnl() {
        setLayout(new GridLayout(1, 3));
        setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(10, 10, 10, 10)));

        resetBtn = new JButton("Reset Program");
        resetBtn.setEnabled(false);
        searchBtn = new JButton("Search List");
        searchBtn.setEnabled(false);
        quitBtn = new JButton("Quit");

        add(resetBtn);
        add(searchBtn);
        add(quitBtn);
    }

    /**
     * This method resets the panel to its default state
     */
    public void reset() {
        resetBtn.setEnabled(false);
        searchBtn.setEnabled(false);
    }

    /**
     * This method allows the listCreator to manage the ActionListener for the reset button
     * @param listener the listener to be passed in
     */
    public void addResetActionListener(ActionListener listener) {
        resetBtn.addActionListener(listener);
    }

    /**
     * This method allows the listCreator to manage the ActionListener for the search button
     * @param listener the listener to be passed in
     */
    public void addSearchActionListener(ActionListener listener) {
        searchBtn.addActionListener(listener);
    }

    /**
     * This method allows the listCreator to manage the ActionListener for the quit button
     * @param listener the listener to be passed in
     */
    public void addQuitActionListener(ActionListener listener) {
        quitBtn.addActionListener(listener);
    }

    public JButton getResetBtn() {
        return resetBtn;
    }

    public JButton getSearchBtn() {
        return searchBtn;
    }

    public JButton getQuitBtn() {
        return quitBtn;
    }
}
