import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.border.Border;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests the basic functionality of the methods in the ListDisplayPnl.java class.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
class ListDisplayPnlTest {

    //A ListDisplayPnl for testing the methods
    ListDisplayPnl pnl;

    @BeforeEach
    void setUp() {
        pnl = new ListDisplayPnl();
    }

    @Test
    void testConstructor() {
        assertTrue(pnl.getLayout() instanceof BorderLayout);

        assertNotNull(pnl.getListLbl());
        assertNotNull(pnl.getListTA());
        assertNotNull(pnl.getScroller());
        assertEquals("List Display:", pnl.getListLbl().getText());
        assertFalse(pnl.getListTA().isEditable());
    }

    @Test
    void reset() {
        pnl.getListTA().setText("Text");
        pnl.reset();
        assertEquals("", pnl.getListTA().getText());
    }
}