import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class ListDisplayPnl extends JPanel
{
    JLabel listLbl;
    JTextArea listTA;
    JScrollPane scroller;

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
