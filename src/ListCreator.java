import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

//javadoc
//UML

/**
 * This class is used to generate the GUI for the program and
 * develop the buttons' ActionListeners.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class ListCreator
{
    //This JFrame contains all the other GUI components
    private JFrame frame;

    //This TitlePnl object contains the logic for formatting the titlePnl
    private TitlePnl titlePnl;

    //THis DataEntryPnl contains the logic for formatting the dataEntryPnl
    private DataEntryPnl dataEntryPnl;

    //This SearchStringPnl contains the logic for formatting the searchStringPnl
    private SearchStringPnl searchStringPnl;

    //This ListDisplayPnl contains the logic for formatting the listDisplayPnl
    private ListDisplayPnl listDisplayPnl;

    //This ControlPnl contains the logic for formatting the controlPnl
    private ControlPnl controlPnl;

    //This ListController coordinates the ListCreator and the SortedList
    ListController controller;

    /**
     * This method instantiates the controller, the frame, and all the ActionListeners
     */
    public void start() {
        controller = new ListController();
        generateFrame();
        setUpAddItemListener();
        setUpQuitListener();
        setUpResetListener();
        setUpSearchListener();
        JOptionPane.showMessageDialog(null, "Welcome to the List Creator. First, enter some list items. They will be sorted in lexicographic order, and then you can search them.");
    }

    /**
     * This method sets up the JFrame, JPanels, and all the relevant settings for the JFrame
     */
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

        //GridBagConstraints for the DataEntryPnl
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.gridwidth = 1;
        gbc2.gridheight = 1;
        gbc2.weightx = 1;
        gbc2.fill = GridBagConstraints.BOTH;

        //GridBagConstraints for the searchStringPnl
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        gbc3.gridwidth = 1;
        gbc3.gridheight = 1;
        gbc3.weightx = 1;
        gbc3.fill = GridBagConstraints.BOTH;

        //GridBagConstraints for the listDisplayPnl
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

    /**
     * This method trims the user's list item and sends it to the controller for validation
     * @return a boolean representing whether the string is valid
     */
    public boolean validateListItem()
    {
        String item = dataEntryPnl.getDataTF().getText().trim();

        return controller.addItemIfValid(item);
    }

    /**
     * this method resets the program state
     */
    public void reset()
    {
        controller.reset();
        dataEntryPnl.reset();
        searchStringPnl.reset();
        listDisplayPnl.reset();
        controlPnl.reset();
    }

    /**
     * This method is used to send other classes the search string
     * @return a String containing the search string
     */
    public String getSearchString() {
        return searchStringPnl.getSearchStringTF().getText().trim();
    }

    /**
     * This method calls the controller method for searching and either displays an error message or displays the search results
     * @param searchString the user's chosen search string
     * @return a boolean representing whether the search was successful
     */
    public boolean handleSearch(String searchString)
    {
        SearchResult result = controller.search(searchString);

        //This algorithm checks whether the controller returned a null value (the search was invalid) or a SearchResult (the search was valid)
        if(result == null) {
            JOptionPane.showMessageDialog(null, "You must enter text in the Search String field before searching.");
            return false;
        } else {
            displaySearchResult(result, searchString);
            return true;
        }
    }

    /**
     * This method is used to print the current list to the ListTA
     */
    private void displayArray() {
        listDisplayPnl.getListTA().append("\n\nCurrent List:");
        for (int i = 0; i < controller.getListSize(); i++)
        {
            listDisplayPnl.getListTA().append("\n" + controller.getStringList()[i]);
        }
    }

    /**
     * This method is used to print the result of a list search to the ListTA
     * @param result a SearchResult containing the location of an item and whether it exists in the list
     * @param searchString the user's chosen search string
     */
    private void displaySearchResult(SearchResult result, String searchString) {
        int location = result.getPosition();
        boolean exists = result.exists();

        //This algorithm determines which message to display based on whether the search string is in the list
        if(exists) {
            listDisplayPnl.getListTA().append("\n\nThe word " + searchString + " was found at list index " + location + ".\n");
        } else {
            listDisplayPnl.getListTA().append("\n\nElement not found. The element would exist at list index " + location + " if it were in the list.\n");
        }
    }

    /**
     * This method is used to give the add button an ActionListener
     */
    public void setUpAddItemListener()
    {
        dataEntryPnl.addAddBtnListener((ActionEvent ae) ->
        {
            boolean added = validateListItem();

            //This algorithm checks whether the user's item was successfully added or not
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

    /**
     * This method is used to give the reset button an ActionListener
     */
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

    /**
     * This method is used to give the search button an ActionListener
     */
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

    /**
     * This method is used to give the quit button an ActionListener
     */
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
