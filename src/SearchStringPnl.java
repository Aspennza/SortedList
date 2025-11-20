import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class SearchStringPnl extends JPanel
{
    JLabel searchStringLbl;
    JTextField searchStringTF;

    public SearchStringPnl()
    {
        setLayout(new GridBagLayout());
        setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(10, 10, 10, 10)));

        //GridBagConstraints for the searchStringLbl
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.gridwidth = 1;
        gbc1.gridheight = 1;
        gbc1.fill = GridBagConstraints.BOTH;

        //GridBagConstraints for the searchStringTF
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        gbc2.gridwidth = 1;
        gbc2.gridheight = 1;
        gbc2.fill = GridBagConstraints.NONE;
        gbc2.anchor = GridBagConstraints.WEST;
        gbc2.insets = new Insets(15, 15, 15, 15);

        searchStringLbl = new JLabel("Search String:");
        searchStringTF = new JTextField(30);

        add(searchStringLbl, gbc1);
        add(searchStringTF, gbc2);
    }

    public JLabel getSearchStringLbl() {
        return searchStringLbl;
    }

    public JTextField getSearchStringTF() {
        return searchStringTF;
    }
}