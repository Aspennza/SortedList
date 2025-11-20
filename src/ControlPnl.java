import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ControlPnl extends JPanel
{
    JButton resetBtn;
    JButton searchBtn;
    JButton quitBtn;

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

    public void reset() {
        resetBtn.setEnabled(false);
        searchBtn.setEnabled(false);
    }

    public void addResetActionListener(ActionListener listener) {
        resetBtn.addActionListener(listener);
    }

    public void addSearchActionListener(ActionListener listener) {
        searchBtn.addActionListener(listener);
    }

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
