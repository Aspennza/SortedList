import javax.swing.*;

public class ListController
{
    private SortedList list;

    public ListController()
    {
        list = new SortedList();
    }

    public boolean addItemIfValid(String item)
    {
        if (item.equals("")) {
            return false;
        } else {
            list.sortedAdd(item.trim());
            return true;
        }
    }

    public SearchResult search(String search)
    {
        if(search.equals("")) {
            return null;
        } else {
            SearchResult result = list.searchList(search.trim());
            return result;
        }
    }

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
