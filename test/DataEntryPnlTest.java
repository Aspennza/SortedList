import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the basic functionality of the methods in the DataEntryPnl.java class.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
class DataEntryPnlTest {

    //A DataEntryPnl for testing the methods
    DataEntryPnl pnl;

    @BeforeEach
    void setUp() {
        pnl = new DataEntryPnl();
    }

    @Test
    void testConstructor() {
        assertTrue(pnl.getLayout() instanceof GridBagLayout);
        assertNotNull(pnl.getDataLbl());
        assertNotNull(pnl.getDataTF());
        assertNotNull(pnl.getAddBtn());
        assertEquals("Data to Enter:", pnl.getDataLbl().getText());
        assertEquals("Add List Item", pnl.getAddBtn().getText());
    }

    @Test
    void addAddBtnListener() {
        class AddListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        }
        AddListener listener = new AddListener();

        pnl.addAddBtnListener(listener);
        assertNotNull(pnl.getAddBtn().getActionListeners());
    }

    @Test
    void reset() {
        pnl.getDataTF().setText("Text");
        pnl.reset();
        assertEquals("", pnl.getDataTF().getText());
    }
}