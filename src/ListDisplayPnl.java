import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * Allows the creation of pre-designed JPanels with a JLabel
 * and JTextArea for displaying the user's list to the screen.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class ListDisplayPnl extends JPanel
{
    //This JLabel labels the listTA
    JLabel listLbl;

    //This JTextArea is used to display all operations performed on the SortedList
    JTextArea listTA;

    //This JScrollPane allows the listTA to scroll
    JScrollPane scroller;

    //This constructor instantiates the components and sets the layout of the panel
    public ListDisplayPnl() {
        setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(10, 10, 10, 10)));
        setLayout(new BorderLayout());

        listLbl = new JLabel("List Display:");
        listTA = new JTextArea(10, 50);
        listTA.setEditable(false);
        scroller = new JScrollPane(listTA);

        add(listLbl, BorderLayout.NORTH);
        add(scroller, BorderLayout.CENTER);
    }

    //This method resets the panel to its default state
    public void reset() {
        listTA.setText("");
    }

    public JLabel getListLbl() {
        return listLbl;
    }

    public JTextArea getListTA() {
        return listTA;
    }

    public JScrollPane getScroller() {
        return scroller;
    }
}
