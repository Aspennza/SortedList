import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class DataEntryPnl extends JPanel
{
    JLabel dataLbl;
    JTextField dataTF;
    JButton addBtn;

    public DataEntryPnl() {
        setLayout(new GridBagLayout());
        setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(10, 10, 10, 10)));

        //GridBagConstraints for the dataLbl
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.gridwidth = 1;
        gbc1.gridheight = 1;
        gbc1.fill = GridBagConstraints.BOTH;
        gbc1.insets = new Insets(15, 15, 15, 15);

        //GridBagConstraints for the dataTF
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        gbc2.gridwidth = 1;
        gbc2.gridheight = 1;
        gbc2.fill = GridBagConstraints.NONE;
        gbc2.anchor = GridBagConstraints.WEST;

        //GridBagConstraints for the addBtn
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 2;
        gbc3.gridy = 0;
        gbc3.gridwidth = 1;
        gbc3.gridheight = 1;
        gbc3.fill = GridBagConstraints.BOTH;
        gbc3.insets = new Insets(15, 15, 15, 15);

        dataLbl = new JLabel("Data to Enter:");
        dataTF = new JTextField(30);
        addBtn = new JButton("Add List Item");

        add(dataLbl, gbc1);
        add(dataTF, gbc2);
        add(addBtn, gbc3);
    }

    public void addAddBtnListener(ActionListener listener) {
        addBtn.addActionListener(listener);
    }

    public void reset() {
        dataTF.setText("");
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public JTextField getDataTF() {
        return dataTF;
    }

    public JLabel getDataLbl() {
        return dataLbl;
    }
}
