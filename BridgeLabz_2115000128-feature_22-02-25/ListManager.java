import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ListManager {
    public void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    public void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

    public int getSize(List<Integer> list) {
        return list.size();
    }
}

public class ListManagerTest {
    private ListManager listManager;
    private List<Integer> list;

    @BeforeEach
    public void setUp() {
        listManager = new ListManager();
        list = new ArrayList<>();
    }

    @Test
    public void testAddElement() {
        listManager.addElement(list, 10);
        assertTrue(list.contains(10));
        assertEquals(1, list.size());
    }

    @Test
    public void testRemoveElement() {
        list.add(20);
        listManager.removeElement(list, 20);
        assertFalse(list.contains(20));
        assertEquals(0, list.size());
    }

    @Test
    public void testGetSize() {
        assertEquals(0, listManager.getSize(list));
        list.add(5);
        list.add(15);
        assertEquals(2, listManager.getSize(list));
    }
}