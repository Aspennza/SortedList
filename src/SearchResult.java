import java.util.Objects;
import java.util.Set;

/**
 * This class allows the creation of SearchResult objects containing
 * an item's position in the SortedList and whether it exists in the list.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class SearchResult
{
    //This int stores the position the item would exist at
    private final int position;

    //This boolean determines whether the item is in the list
    private final boolean exists;

    public SearchResult(int position, boolean exists) {
        this.position = position;
        this.exists = exists;
    }

    public int getPosition() {
        return position;
    }

    public boolean exists() {
        return exists;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "position=" + position +
                ", exists=" + exists +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SearchResult that = (SearchResult) o;
        return position == that.position && exists == that.exists;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, exists);
    }
}
