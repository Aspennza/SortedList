import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        pnl.getResetBtn().setEnabled(true);
        pnl.getSearchBtn().setEnabled(true);
        pnl.reset();
        assertFalse(pnl.getResetBtn().isEnabled());
        assertFalse(pnl.getSearchBtn().isEnabled());
    }

    @Test
    void addResetActionListener() {
        class ResetListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        }

        ResetListener listener = new ResetListener();
        pnl.addResetActionListener(listener);

        assertNotNull(pnl.getResetBtn().getActionListeners());
    }

    @Test
    void addSearchActionListener() {
        class SearchListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }

        SearchListener listener = new SearchListener();
        pnl.addSearchActionListener(listener);

        assertNotNull(pnl.getSearchBtn().getActionListeners());
    }

    @Test
    void addQuitActionListener() {
        class QuitListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {}
        }

        QuitListener listener = new QuitListener();
        pnl.addQuitActionListener(listener);
        assertNotNull(pnl.getQuitBtn().getActionListeners());
    }
}