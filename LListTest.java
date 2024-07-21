import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LListTest {
    //test the insert and get value
    @Test
    public void testInsertAndGetValue() {
        LList list = new LList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.moveToStart();
        assertEquals(3, list.getValue());
    }
    //test the remove method
    @Test
    public void testRemove() {
        LList list = new LList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.remove();
        assertEquals(2, list.getValue());
    }
    //test the length method for llist
    @Test
    public void testLength() {
        LList list = new LList();
        list.append(1);
        list.append(2);
        list.append(3);
        assertEquals(3, list.length());
    }
    //test the move to pos to see where it goes
    @Test
    public void testMoveToPos() {
        LList list = new LList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.moveToPos(1);
        assertEquals(2, list.getValue());
    }
    //test the contains method to see if the value is in the list
    @Test
    public void testContains() {
        LList list = new LList();
        list.append(1);
        list.append(2);
        list.append(3);
        assertTrue(list.contains(2));
        assertFalse(list.contains(4));
    }
    //test the get method
    @Test
    public void testGet() {
        LList list = new LList();
        list.append(1);
        list.append(2);
        list.append(3);
        assertEquals(2, list.get(1));
        assertNull(list.get(3));
    }
    //test the is empty method by emptying the list
    @Test
    public void testIsEmpty() {
        LList emptyList = new LList();
        assertTrue(emptyList.isEmpty());
    }}