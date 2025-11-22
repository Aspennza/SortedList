import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests the basic functionality of the methods in the SortedList.java class.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
class SortedListTest {

    //A SortedList for testing the methods
    SortedList list;

    //A SortedList for testing the methods
    SortedList list2;

    //A SortedList for testing the methods
    SortedList list3;

    //A SortedList for testing the methods
    SortedList list4;

    @BeforeEach
    void setUp() {
        list = new SortedList();
        list2 = new SortedList(0);
        list3 = new SortedList(1);
        list4 = new SortedList();
    }

    @Test
    void testConstructor() {
        assertNotNull(list.getStringList());
        assertEquals(0, list.getStringList().length);
        assertEquals(0, list.getSize());
        assertEquals(10, list.getCapacity());
    }

    @Test
    void testConstructor2() {
        assertNotNull(list2.getStringList());
        assertEquals(0, list2.getStringList().length);
        assertEquals(0, list2.getSize());
        assertEquals(10, list2.getCapacity());

        assertNotNull(list3.getStringList());
        assertEquals(0, list3.getStringList().length);
        assertEquals(0, list3.getSize());
        assertEquals(1, list3.getCapacity());
    }

    @Test
    void remove() {
        list.sortedAdd("apple");
        list.sortedAdd("pear");

        list.remove(-1);
        list.remove(3);

        assertEquals("apple", list.getStringList()[0]);
        assertEquals("pear", list.getStringList()[1]);

        list.remove(0);
        assertEquals("pear", list.getStringList()[0]);
    }

    @Test
    void get() {
        list.sortedAdd("apple");
        list.sortedAdd("pear");

        assertEquals(null, list.get(-1));
        assertEquals(null, list.get(3));
        assertEquals("apple", list.get(0));
    }

    @Test
    void sortedAdd() {
        list.sortedAdd("apple");
        list.sortedAdd("pear");
        list.sortedAdd("blueberry");
        list.sortedAdd("flower");

        assertEquals("apple", list.getStringList()[0]);
        assertEquals("blueberry", list.getStringList()[1]);
        assertEquals("flower", list.getStringList()[2]);
        assertEquals("pear", list.getStringList()[3]);
    }

    @Test
    void searchList() {
        list.sortedAdd("apple");
        list.sortedAdd("pear");
        list.sortedAdd("blueberry");
        list.sortedAdd("flower");

        assertEquals(new SearchResult(0, true), list.searchList("apple"));
        assertEquals(new SearchResult(3, false), list.searchList("guava"));
    }

    @Test
    void isEmpty() {
        assertTrue(list.isEmpty());
        list.sortedAdd("apple");
        list.sortedAdd("pear");
        list.sortedAdd("blueberry");
        list.sortedAdd("flower");
        assertFalse(list.isEmpty());
    }

    @Test
    void testToString() {
        assertEquals("SortedList{stringList=[null, null, null, null, null, null, null, null, null, null], size=0, capacity=10}", list.toString());
        assertEquals("SortedList{stringList=[null], size=0, capacity=1}", list3.toString());
    }

    @Test
    void testEquals() {
        assertEquals(list, list);
        assertEquals(list, list4);
        assertEquals(list, list2);
        assertNotEquals(list, list3);
    }

    @Test
    void testHashCode() {
        assertEquals(59583, list3.hashCode());
        assertEquals(-293373206, list.hashCode());
    }
}