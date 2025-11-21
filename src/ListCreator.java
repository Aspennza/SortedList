import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.nio.file.Paths;
import java.util.Map;
import java.util.List;
import java.util.Set;

//Add a joptionpane welcoming users to the program/explaining it
//do code review really quick
//junit
//javadoc
//UML

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
        setUpAddItemListener();
        setUpQuitListener();
        setUpResetListener();
        setUpSearchListener();
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

    private boolean validateListItem()
    {
        String item = dataEntryPnl.getDataTF().getText().trim();

        if (item.equals("")) {
            JOptionPane.showMessageDialog(null, "You must enter text in the Data to Enter field before adding an item.");
            return false;
        } else {
            list.sortedAdd(item);
            return true;
        }
    }

    private void reset()
    {
        list = new SortedList();
        dataEntryPnl.reset();
        searchStringPnl.reset();
        listDisplayPnl.reset();
        controlPnl.reset();
    }

    private boolean validateSearchString()
    {
        String searchString = searchStringPnl.getSearchStringTF().getText().trim();

        if(searchString.equals("")) {
            JOptionPane.showMessageDialog(null, "You must enter text in the Search String field before adding an item.");
            return false;
        } else {
            SearchResult result = list.searchList(searchString);
            displaySearchResult(result, searchString);
            return true;
        }
    }

    private void displayArray() {
        listDisplayPnl.getListTA().append("\n\nCurrent List:");
        for (int i = 0; i < list.getSize(); i++)
        {
            listDisplayPnl.getListTA().append("\n" + list.getStringList()[i]);
        }
    }

    private void displaySearchResult(SearchResult result, String searchString) {
        int location = result.getPosition();
        boolean exists = result.exists();

        if(exists) {
            listDisplayPnl.getListTA().append("\n\nThe word " + searchString + " was found at list index " + location + ".\n");
        } else {
            listDisplayPnl.getListTA().append("\n\nElement not found. The element would exist at list index " + location + " if it were in the list.\n");
        }
    }

    public void setUpAddItemListener()
    {
        dataEntryPnl.addAddBtnListener((ActionEvent ae) ->
        {
            boolean added = validateListItem();

            if(added) {
                JOptionPane.showMessageDialog(null, "Item added.");
                controlPnl.getResetBtn().setEnabled(true);
                controlPnl.getSearchBtn().setEnabled(true);
                displayArray();
                dataEntryPnl.getDataTF().setText("");
            }
        });
    }

    public void setUpResetListener()
    {
        controlPnl.addResetActionListener((ActionEvent ae) -> {
            //This int tracks whether the user confirmed or denied they wanted to reset the program
            int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset the program?", "Reset", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            //This algorithm determines whether to reset the program based on the user's input
            if(selection == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Resetting the program...");
                reset();
            } else
            {
                JOptionPane.showMessageDialog(null, "The program will stay as-is.");
            }
        });
    }

    public void setUpSearchListener()
    {
        controlPnl.addSearchActionListener((ActionEvent ae) ->
        {
            boolean searched = validateSearchString();

            if(searched) {
                searchStringPnl.getSearchStringTF().setText("");
            }
        });
    }

    public void setUpQuitListener()
    {
        controlPnl.addQuitActionListener((ActionEvent ae) -> {
            //This int tracks whether the user confirmed or denied they wanted to quit the program
            int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit? You can press Reset Program to reset.", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            //This algorithm determines whether to quit the program based on the user's input
            if(selection == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Quitting the program...");
                System.exit(0);
            } else
            {
                JOptionPane.showMessageDialog(null, "The program will remain open.");
            }
        });
    }
}
