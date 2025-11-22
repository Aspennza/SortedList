import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ControlPnlTest {

    ControlPnl pnl;

    @BeforeEach
    void setUp()
    {
        pnl = new ControlPnl();
    }

    @Test
    void testConstructor()
    {
        int rows = ((GridLayout) pnl.getLayout()).getRows();
        int cols = ((GridLayout) pnl.getLayout()).getColumns();
        assertEquals(1, rows);
        assertEquals(3, cols);

        assertNotNull(pnl.getResetBtn());
        assertNotNull(pnl.getSearchBtn());
        assertNotNull(pnl.getQuitBtn());

        assertEquals("Reset Program", pnl.getResetBtn().getText());
        assertEquals("Search List", pnl.getSearchBtn().getText());
        assertEquals("Quit", pnl.getQuitBtn().getText());

        assertFalse(pnl.getResetBtn().isEnabled());
        assertFalse(pnl.getSearchBtn().isEnabled());
    }

    @Test
    void reset()
    {

    }

    @Test
    void addResetActionListener() {
    }

    @Test
    void addSearchActionListener() {
    }

    @Test
    void addQuitActionListener() {
    }
}