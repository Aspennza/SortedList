import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class ListCreatorTest {

    ListCreator creator;

    @BeforeEach
    void setUp() {
        creator = new ListCreator();
    }

    @Test
    void start() {
        creator.start();
        creator.getFrame().setVisible(false);
        assertNotNull(creator.getController());
        assertNotNull(creator.getFrame());
        assertNotNull(creator.getTitlePnl());
        assertNotNull(creator.getDataEntryPnl());
        assertNotNull(creator.getSearchStringPnl());
        assertNotNull(creator.getListDisplayPnl());
        assertNotNull(creator.getControlPnl());
        assertNotNull(creator.getDataEntryPnl().getAddBtn().getActionListeners());
        assertNotNull(creator.getControlPnl().getResetBtn().getActionListeners());
        assertNotNull(creator.getControlPnl().getSearchBtn().getActionListeners());
        assertNotNull(creator.getControlPnl().getQuitBtn().getActionListeners());
    }

    @Test
    void generateFrame() {
        creator.generateFrame();
        creator.getFrame().setVisible(false);
        assertNotNull(creator.getFrame());
        assertNotNull(creator.getTitlePnl());
        assertNotNull(creator.getDataEntryPnl());
        assertNotNull(creator.getSearchStringPnl());
        assertNotNull(creator.getListDisplayPnl());
        assertNotNull(creator.getControlPnl());
        assertEquals(JFrame.EXIT_ON_CLOSE, creator.getFrame().getDefaultCloseOperation());
        assertEquals("List Sorter", creator.getFrame().getTitle());
    }

    @Test
    void validateListItem() {
        creator.start();
        creator.getFrame().setVisible(false);
        creator.getDataEntryPnl().getDataTF().setText("");
        assertFalse(creator.validateListItem());
        creator.getDataEntryPnl().getDataTF().setText("apple");
        assertTrue(creator.validateListItem());
    }

    @Test
    void reset() {
        creator.start();
        creator.getFrame().setVisible(false);
        creator.getController().addItemIfValid("Test");
        SortedList oldList = creator.getController().getList();
        creator.getDataEntryPnl().getDataTF().setText("Text");
        creator.getSearchStringPnl().getSearchStringTF().setText("Text");
        creator.getListDisplayPnl().getListTA().setText("test");
        creator.getControlPnl().getResetBtn().setEnabled(true);
        creator.getControlPnl().getSearchBtn().setEnabled(true);
        creator.reset();
        assertNotEquals(oldList, creator.getController());
        assertEquals(0, creator.getController().getList().getSize());
        assertEquals("", creator.getDataEntryPnl().getDataTF().getText());
        assertEquals("", creator.getSearchStringPnl().getSearchStringTF().getText());
        assertEquals("", creator.getListDisplayPnl().getListTA().getText());
        assertFalse(creator.getControlPnl().getResetBtn().isEnabled());
        assertFalse(creator.getControlPnl().getSearchBtn().isEnabled());
    }

    @Test
    void handleSearch() {
        creator.start();
        creator.getFrame().setVisible(false);
        assertFalse(creator.handleSearch(""));
        assertTrue(creator.handleSearch("apple"));
    }

    @Test
    void setUpAddItemListener() {
        creator.start();
        creator.getFrame().setVisible(false);
        assertNotNull(creator.getDataEntryPnl().getAddBtn().getActionListeners());
    }

    @Test
    void setUpResetListener() {
        creator.start();
        creator.getFrame().setVisible(false);
        assertNotNull(creator.getControlPnl().getResetBtn().getActionListeners());
    }

    @Test
    void setUpSearchListener() {
        creator.start();
        creator.getFrame().setVisible(false);
        assertNotNull(creator.getControlPnl().getSearchBtn().getActionListeners());
    }

    @Test
    void setUpQuitListener() {
        creator.start();
        creator.getFrame().setVisible(false);
        assertNotNull(creator.getControlPnl().getQuitBtn().getActionListeners());
    }
}