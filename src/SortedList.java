import java.util.Arrays;
import java.util.Objects;

/**
 * This class creates a SortedList that is similar to an ArrayList
 * but automatically sorts its content using binary search methods.
 * Also provides methods for searching the list using binary search.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class SortedList
{
    //This String[] stores all the items in the SortedList
    private String[] stringList;

    //This int stores the current number of items in the SortedList
    private int size;

    //This int stores the current allocated capacity of the SortedList
    private int capacity;

    //This int stores the default capacity of the SortedList if accurate parameters are not provided
    private static final int DEFAULT_CAPACITY = 10;

    //This constructor initializes the stringList, size, and capacity variables
    public SortedList() {
        this.stringList = new String[DEFAULT_CAPACITY];
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    //This constructor initializes the stringList, size, and capacity variables, but also checks if the user's chosen capacity is valid
    public SortedList(int chosenCapacity) {
        //This algorithm checks if the user's chosen capacity is less than zero and corrects it
        if (chosenCapacity <= 0) {
            System.out.println("The starting size of a SortedList must be 0 or greater.");
            chosenCapacity = DEFAULT_CAPACITY;
        }
        this.stringList = new String[chosenCapacity];
        this.size = 0;
        this.capacity = chosenCapacity;
    }

    /**
     * This method allows the user to pick an index to remove an item from.
     * It validates the chosen index and moves all elements to account for the empty space.
     * @param index the user's chosen index
     */
    public void remove(int index)
    {
        //This algorithm checks if the user's index is valid
        if (index > size - 1 || index < 0)
        {
            System.out.println("The chosen index is outside the bounds of the SortedList.");
        } else
        {
            //This algorithm shifts all elements in the array to fix the gap
            for (int i = index; i < size - 1; i++)
            {
                stringList[i] = stringList[i + 1];
            }

            stringList[size - 1] = null;
            size--;
        }
    }

    /**
     * This method expands the capacity of the SortedList when it becomes full
     * by copying all the elements into a temporary array, then re-instantiating the
     * stringList array with a greater capacity.
     */
    private void expand()
    {
        String[] tempArray = new String[capacity];

        //This algorithm copies all the elements into tempArray
        for (int i = 0; i < size; i++) {
            tempArray[i] = stringList[i];
        }

        capacity = capacity * 2;
        stringList = new String[capacity];

        //This algorithm copies the elements back into the new stringList
        for (int i = 0; i < size; i++) {
            stringList[i] = tempArray[i];
        }
    }

    /**
     * This method allows users to retrieve the item at any index of the list.
     * @param index the user's chosen index
     * @return the String that is at the chosen index
     */
    public String get(int index)
    {
        //This algorithm validates the index
        if (index > size - 1 || index < 0)
        {
            System.out.println("The chosen index is outside the bounds of the SortedList.");
            return null;
        } else {
            return stringList[index];
        }
    }

    /**
     * This method uses binary search methods to place a user's chosen word
     * at the correct lexicographic index.
     * @param word the user's entered word
     */
    public void sortedAdd(String word)
    {
        //The lowest index of the array
        int low = 0;

        //The middle index of the dataset
        int mid = 0;

        //The highest index of the dataset
        int high = getSize() - 1;

        //This algorithm checks if there are no items existing in the array, and, if so, just adds the first item
        if(size == 0) {
            if(capacity == size) expand();
            stringList[0] = word;
            size++;
            return;
        }

        //This algorithm checks that the low boundary is less than or equal to the high boundary, then conducts a binary search
        while (low <= high)
        {
            mid = (low + high) / 2;

            //This algorithm checks if the chosen word is lexicographically to the left or the right of the word at the middle index
            boolean isWordToRight = isWordToRight(word, stringList[mid]);

            //The low index is raised if the word is to the right, and the high index is lowered if the word is to the left
            if (isWordToRight)
            {
                low = mid + 1;
            } else
            {
                high = mid - 1;
            }
        }

        //This algorithm increases the capacity if needed
        if (capacity == size) {
            expand();
        }

        //This algorithm makes room to add the word at the correct index
        for (int i = size - 1; i >= low; i--)
        {
            stringList[i + 1] = stringList[i];
        }

        stringList[low] = word;
        size++;
    }

    /**
     * This method uses binary search to determine where a word does or would exist
     * in the SortedList.
     * @param word the user's chosen word
     * @return a SearchResult object containing the position of the word and whether it exists in the list
     */
    public SearchResult searchList(String word)
    {
        //The low index of the list
        int low = 0;

        //The middle index of the list
        int mid = 0;

        //The highest index of the list
        int high = size - 1;

        //This algorithm checks that the low index is less than or equal to the high index, then uses binary search to find the user's word
        while (low <= high)
        {
           mid = (low + high) / 2;

           boolean isWordToRight = isWordToRight(word, stringList[mid]);

           //This algorithm checks if the user's word is the same as the middle term, to the left of it, or to the right of it
           if (word.equalsIgnoreCase(stringList[mid])) {
               return new SearchResult(mid, true);
           } else if (isWordToRight) {
            low = mid + 1;
           } else {
            high = mid - 1;
            }
        }

        return new SearchResult(low, false);
    }

    /**
     * This method checks if the user's word is to the left or right of the middle word in the list
     * @param insertWord the user's word
     * @param midWord the word at the middle index
     * @return a boolean representing whether the insertWord is to the right of the middle word
     */
    private boolean isWordToRight(String insertWord, String midWord)
    {
        if(midWord == null) return true;
        return insertWord.compareToIgnoreCase(midWord) > 0;
    }

    /**
     * This method checks if the list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public String[] getStringList() {
        return Arrays.copyOf(stringList, size);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "SortedList{" +
                "stringList=" + Arrays.toString(stringList) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SortedList that = (SortedList) o;
        return size == that.size && capacity == that.capacity && Objects.deepEquals(stringList, that.stringList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(stringList), size, capacity);
    }
}
