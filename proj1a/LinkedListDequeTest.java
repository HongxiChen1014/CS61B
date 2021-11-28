import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Performs some basic linked list tests.
 */
public class LinkedListDequeTest {

    @Test
    public void testAddfirst() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.addFirst(3);
    }

    @Test
    public void testAddLast() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
    }

    @Test
    public void testRemoveFirst() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.addFirst(3);
        lld.removeFirst();
        assertEquals(2, lld.size());
        lld.removeFirst();
        lld.removeFirst();
        assertEquals(true, lld.isEmpty());
    }

    @Test
    public void testRemoveLast() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        lld.removeFirst();
        assertEquals(2, lld.size());
        lld.removeFirst();
        lld.removeFirst();
        assertEquals(true, lld.isEmpty());
    }

    @Test
    public void testGet() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        int num1 = lld.get(0);
        assertEquals(1, num1);
        int num2 = lld.get(1);
        assertEquals(2, num2);
        int num3 = lld.get(2);
        assertEquals(3, num3);
    }

    @Test
    public void testGetRecursive() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        int num1 = lld.getRecursive(0);
        assertEquals(1, num1);
        int num2 = lld.getRecursive(1);
        assertEquals(2, num2);
        int num3 = lld.getRecursive(2);
        assertEquals(3, num3);
    }
}
