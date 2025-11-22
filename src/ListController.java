import javax.swing.*;

/**
 * Allows the creation of ListController objects for coordinating
 * the SortedList and the ListCreator. Also performs input validation.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class ListController
{
    //This SortedList instance is used to manipulate the data passed in
    private SortedList list;

    public ListController()
    {
        list = new SortedList();
    }

    /**
     * This method determines whether the user's item is a valid
     * input and, if so, calls the sortedAdd method of the SortedList.
     * @param item the String item to be added to the list
     * @return a boolean value representing whether the input was valid
     */
    public boolean addItemIfValid(String item)
    {
        if (item.equals("")) {
            return false;
        } else {
            list.sortedAdd(item.trim());
            return true;
        }
    }

    /**
     * This method is used to validate the user's search string
     * and, if it is valid, search the list.
     * @param search the search string to be used
     * @return a SearchResult object containing data on the string's position in the list and whether it exists in the list
     */
    public SearchResult search(String search)
    {
        if(search.equals("")) {
            return null;
        } else {
            SearchResult result = list.searchList(search.trim());
            return result;
        }
    }

    /**
     * This method is used to reset the class to its default state
     */
    public void reset()
    {
        list = new SortedList();
    }

    public int getListSize() {
        return list.getSize();
    }

    public String[] getStringList() {
        return list.getStringList();
    }

    public SortedList getList() {
        return list;
    }
}
