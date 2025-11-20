import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//Come back to writing the sort method for organizing in alphabetical order
//create a method for searching the list
//Junit
//javadoc
//UML
public class SortedList
{
    private String[] stringList;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    public SortedList() {
        this.stringList = new String[DEFAULT_CAPACITY];
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    public SortedList(int chosenCapacity) {
        if (chosenCapacity <= 0) {
            System.out.println("The starting size of a SortedList must be 0 or greater.");
            chosenCapacity = DEFAULT_CAPACITY;
        }
        this.stringList = new String[chosenCapacity];
        this.size = 0;
        this.capacity = chosenCapacity;
    }

    public void remove(int index)
    {
        if (index > size - 1 || index < 0)
        {
            System.out.println("The chosen index is outside the bounds of the SortedList.");
        } else
        {
            for (int i = index; i < size - 1; i++)
            {
                stringList[i] = stringList[i + 1];
            }

            stringList[size - 1] = null;
            size--;
        }
    }

    private void expand()
    {
        String[] tempArray = new String[capacity];
        for (int i = 0; i < size; i++) {
            tempArray[i] = stringList[i];
        }

        capacity = capacity * 2;

        stringList = new String[capacity];

        for (int i = 0; i < size; i++) {
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

        if (capacity == size) {
            expand();
        }

        for (int i = size - 1; i > low; i--)
        {
            stringList[i] = stringList[i - 1];
        }

        stringList[low] = word;
        size++;
    }

    public int searchList(String word)
    {
        int low = 0;
        int mid = 0;
        int high = size - 1;

        do
        {
           mid = (low + high) / 2;

           boolean isWordToRight = isWordToRight(word, stringList[mid]);

           if (word.equalsIgnoreCase(stringList[mid])) {
               return mid;
           } else if (isWordToRight) {
            low = mid + 1;
           } else {
            high = mid - 1;
            }
        } while (low <= high);

        return low;
    }

    //DOES THIS NEED TO BE THE MANUAL VERSION THAT"S SAVED IN ONENOTE??
    private boolean isWordToRight(String insertWord, String midWord)
    {
        return insertWord.compareToIgnoreCase(midWord) > 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String[] getStringList() {
        return Arrays.copyOf(stringList, size);
    }

    public int getSize() {
        return size;
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
