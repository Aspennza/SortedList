public class SortedList
{
    private String[] stringList;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public SortedList() {
        this.stringList = new String[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public SortedList(int chosenCapacity) {
        if (chosenCapacity < 0) {
            System.out.println("The starting size of a SortedList must be 0 or greater.");
        }

        this.stringList = new String[chosenCapacity];
        this.size = 0;
    }

    public void add(String item)
    {
        for (int i = 0; i < size - 1; i++) {
            if(stringList[i] == null)
            {
                stringList[i] = item;
                return;
            } else
            {
                expand();
                stringList[size - 1] = item;
            }
        }
    }

    public void remove(int index)
    {
        if (index > size - 1 || index < 0)
        {
            System.out.println("The chosen index is outside the bounds of the SortedList.");
        } else
        {

        }
    }

    private void expand()
    {
        String[] tempArray = new String[size];
        for (int i = 0; i < size - 1; i++) {
            tempArray[i] = stringList[i];
        }

        size = size + 1;

        stringList = new String[size];

        for (int i = 0; i < tempArray.length - 1; i++) {
            stringList[i] = tempArray[i];
        }
    }

    private void contract()
    {

    }

    public String get(int index)
    {
        if (index > size - 1 || index < 0)
        {
            System.out.println("The chosen index is outside the bounds of the SortedList.");
            return null;
        } else {
            return stringList[index];
        }
    }

    private void sort()
    {

    }
}
