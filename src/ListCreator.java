import javax.swing.*;
import java.awt.*;

public class ListCreator
{
    private JFrame frame;
    private TitlePnl titlePnl;
    private DataEntryPnl dataEntryPnl;
    private SearchStringPnl searchStringPnl;
    private ListDisplayPnl listDisplayPnl;
    private ControlPnl controlPnl;
    private SortedList list;

    public void start() {
        list = new SortedList();
        generateFrame();
    }

    public void generateFrame() {
        frame = new JFrame();

        //GridBagConstraints for the titlePnl
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.gridwidth = 1;
        gbc1.gridheight = 1;
        gbc1.weightx = 1;
        gbc1.fill = GridBagConstraints.BOTH;

        //GridBagConstraints for the filePnl
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.gridwidth = 1;
        gbc2.gridheight = 1;
        gbc2.weightx = 1;
        gbc2.fill = GridBagConstraints.BOTH;

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        gbc3.gridwidth = 1;
        gbc3.gridheight = 1;
        gbc3.weightx = 1;
        gbc3.fill = GridBagConstraints.BOTH;

        //GridBagConstraints for the tagPnl
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 3;
        gbc4.gridwidth = 1;
        gbc4.gridheight = 3;
        gbc4.weightx = 1;
        gbc4.weighty = 1;
        gbc4.fill = GridBagConstraints.BOTH;

        //GridBagConstraints for the controlPnl
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 0;
        gbc5.gridy = 6;
        gbc5.gridwidth = 1;
        gbc5.gridheight = 1;
        gbc5.weightx = 1;
        gbc5.fill = GridBagConstraints.BOTH;

        JPanel mainPnl = new JPanel();

        //This Toolkit is used to find the screen size of the computer running the GUI
        Toolkit kit = Toolkit.getDefaultToolkit();

        //This Dimension stores the screen size
        Dimension screenSize = kit.getScreenSize();

        //This int stores the height of the screen
        int screenHeight = screenSize.height;

        //This int stores the width of the screen
        int screenWidth = screenSize.width;

        mainPnl.setLayout(new GridBagLayout());
        frame.add(mainPnl);

        titlePnl = new TitlePnl();
        mainPnl.add(titlePnl, gbc1);

        dataEntryPnl = new DataEntryPnl();
        mainPnl.add(dataEntryPnl, gbc2);

        searchStringPnl = new SearchStringPnl();
        mainPnl.add(searchStringPnl, gbc3);

        listDisplayPnl = new ListDisplayPnl();
        mainPnl.add(listDisplayPnl, gbc4);

        controlPnl = new ControlPnl();
        mainPnl.add(controlPnl, gbc5);

        frame.setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("List Sorter");
        frame.setVisible(true);
    }
}
