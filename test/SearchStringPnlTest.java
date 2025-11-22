import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class SearchStringPnlTest {

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