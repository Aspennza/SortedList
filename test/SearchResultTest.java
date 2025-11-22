import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchResultTest {

    SearchResult result1;
    SearchResult result2;
    SearchResult result3;

    @BeforeEach
    void setUp() {
        result1 = new SearchResult(0, true);
        result2 = new SearchResult(1, false);
        result3 = new SearchResult(0, true);
    }

    @Test
    void testConstructor() {
        assertEquals(0, result1.getPosition());
        assertTrue(result1.exists());
    }

    @Test
    void testToString() {
        assertEquals("SearchResult{position=0, exists=true}", result1.toString());
    }

    @Test
    void testEquals() {
        assertEquals(result1, result1);
        assertEquals(result1, result3);
        assertNotEquals(result1, result2);
    }

    @Test
    void testHashCode() {
        assertEquals(2192, result1.hashCode());
    }
}