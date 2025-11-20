//Come back to writing the sort method for organizing in alphabetical order
//create a method for searching the list
//Junit
//javadoc
//UML
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

    public String[] remove(int index)
    {
        String[] tempArray = new String[size - 1];

        if (index > size - 1 || index < 0)
        {
            System.out.println("The chosen index is outside the bounds of the SortedList.");
            return null;
        } else
        {
            System.arraycopy(stringList, 0, tempArray, 0, index);
            System.arraycopy(stringList, index + 1, tempArray, index, stringList.length - index);
            return tempArray;
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

    public void sortedAdd(String word)
    {
        int low = 0;
        int mid = 0;
        int high = getSize() - 1;

        do
        {
            mid = (low + high) / 2;

            boolean isWordToRight = isWordToRight(word, stringList[mid]);

            if (isWordToRight)
            {
                low = mid + 1;
            } else
            {
                high = mid - 1;
            }
        } while (low <= high);

        expand();

        for (int i = stringList.length - 1; i > low; i--)
        {
            stringList[i] = stringList[i - 1];
        }

        stringList[low] = word;
    }

    private boolean isWordToRight(String insertWord, String midWord)
    {
        insertWord = insertWord.toLowerCase();
        midWord = midWord.toLowerCase();

        for (int i = 0; i < midWord.length() && i < insertWord.length(); i++)
        {
            if(insertWord.charAt(i) > midWord.charAt(i)) {
                return true;
            } else if (insertWord.charAt(i) < midWord.charAt(i)) {
                return false;
            }
        }

        if (insertWord.length() < midWord.length())
        {
            return false;
        } else {
            return true;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String[] getStringList() {
        return stringList;
    }

    public int getSize() {
        return size;
    }
}
