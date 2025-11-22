import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TitlePnlTest {

    TitlePnl pnl;

    @BeforeEach
    void setUp() {
        pnl = new TitlePnl();
    }

    @Test
    void testConstructor()
    {
        assertNotNull(pnl.getTitleLbl());
        assertNotNull(pnl.getTitleFont());
        assertEquals("List Sorter", pnl.getTitleLbl().getText());
        assertEquals("Serif", pnl.getTitleFont().getName());
        assertEquals(Font.BOLD, pnl.getTitleFont().getStyle());
        assertEquals(36, pnl.getTitleFont().getSize());
        assertEquals(pnl.getTitleFont(), pnl.getTitleLbl().getFont());
    }
}