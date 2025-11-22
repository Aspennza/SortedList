import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the basic functionality of the methods in the ListController.java class.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
class ListControllerTest {

    //A ListController for testing the methods
    ListController list;

    @BeforeEach
    void setUp() {
        list = new ListController();
    }

    @Test
    void testConstructor()
    {
        assertNotNull(list.getList());
    }

    @Test
    void addItemIfValid() {
        assertFalse(list.addItemIfValid(""));
        assertTrue(list.addItemIfValid("Test"));
        SearchResult result = list.getList().searchList("Test");
        assertEquals(new SearchResult(0, true), result);
    }

    @Test
    void search() {
        list.addItemIfValid("Test");
        assertNull(list.search(""));
        assertEquals(new SearchResult(0, true), list.search("test"));
        assertEquals(new SearchResult(0, false), list.search("apple"));
    }

    @Test
    void reset() {
        list.addItemIfValid("Test");
        SortedList oldList = list.getList();
        list.reset();
        assertNotEquals(list, oldList);
        assertEquals(0, list.getList().getSize());
    }
}