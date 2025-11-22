import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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
    ListController controller;

    public void start() {
        controller = new ListController();
        generateFrame();
        setUpAddItemListener();
        setUpQuitListener();
        setUpResetListener();
        setUpSearchListener();
        JOptionPane.showMessageDialog(null, "Welcome to the List Creator. First, enter some list items. They will be sorted in lexicographic order, and then you can search them.");
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

    public boolean validateListItem()
    {
        String item = dataEntryPnl.getDataTF().getText().trim();

        return controller.addItemIfValid(item);
    }

    public void reset()
    {
        controller.reset();
        dataEntryPnl.reset();
        searchStringPnl.reset();
        listDisplayPnl.reset();
        controlPnl.reset();
    }

    public String getSearchString() {
        return searchStringPnl.getSearchStringTF().getText().trim();
    }

    public boolean handleSearch(String searchString)
    {
        SearchResult result = controller.search(searchString);

        if(result == null) {
            JOptionPane.showMessageDialog(null, "You must enter text in the Search String field before searching.");
            return false;
        } else {
            displaySearchResult(result, searchString);
            return true;
        }
    }

    private void displayArray() {
        listDisplayPnl.getListTA().append("\n\nCurrent List:");
        for (int i = 0; i < controller.getListSize(); i++)
        {
            listDisplayPnl.getListTA().append("\n" + controller.getStringList()[i]);
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
            } else {
                JOptionPane.showMessageDialog(null, "The Data to Enter field must be filled out before adding an item.");
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
            String searchString = getSearchString();
            boolean searched = handleSearch(searchString);

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

    public JFrame getFrame() {
        return frame;
    }

    public TitlePnl getTitlePnl() {
        return titlePnl;
    }

    public DataEntryPnl getDataEntryPnl() {
        return dataEntryPnl;
    }

    public SearchStringPnl getSearchStringPnl() {
        return searchStringPnl;
    }

    public ListDisplayPnl getListDisplayPnl() {
        return listDisplayPnl;
    }

    public ControlPnl getControlPnl() {
        return controlPnl;
    }

    public ListController getController() {
        return controller;
    }
}
