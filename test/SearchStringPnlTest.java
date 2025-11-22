import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests the basic functionality of the methods in the SearchStringPnl.java class.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
class SearchStringPnlTest {

    //A SearchStringPnl for testing the methods
    SearchStringPnl pnl;

    @BeforeEach
    void setUp() {
        pnl = new SearchStringPnl();
    }

    @Test
    void testConstructor() {
        assertTrue(pnl.getLayout() instanceof GridBagLayout);
        assertNotNull(pnl.getSearchStringLbl());
        assertNotNull(pnl.getSearchStringTF());
        assertEquals("Search String:", pnl.getSearchStringLbl().getText());
    }

    @Test
    void reset() {
        pnl.getSearchStringTF().setText("Test");
        pnl.reset();
        assertEquals("", pnl.getSearchStringTF().getText());
    }
}