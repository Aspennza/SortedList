import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * Allows the creation of pre-designed JPanels with a JLabel
 * representing the title of the program.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class TitlePnl extends JPanel
{
    //A JLabel for the title of the program
    JLabel titleLbl;

    //A Font for the titleLbl
    Font titleFont;

    //This constructor initializes the label and font
    public TitlePnl() {
        titleLbl = new JLabel("List Sorter");
        setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(10, 10, 10, 10)));
        titleFont = new Font("Serif", Font.BOLD, 36);
        titleLbl.setFont(titleFont);
        add(titleLbl);
    }

    public JLabel getTitleLbl() {
        return titleLbl;
    }

    public Font getTitleFont() {
        return titleFont;
    }
}
