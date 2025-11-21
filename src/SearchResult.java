import java.util.Objects;
import java.util.Set;

public class SearchResult
{
    private final int position;
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
