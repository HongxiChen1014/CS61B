import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author daisy
 * @description
 * @create 2021-11-26-21:59
 */
public class ArrayDequeTest {
    @Test
    public void testIsEmpty1() {
        ArrayDeque<Integer> arr1 = new ArrayDeque<>();
        assertEquals(true, arr1.isEmpty());
        arr1.addFirst(1);
        assertEquals(1, arr1.size());
        assertEquals(false, arr1.isEmpty());
        int m = arr1.removeFirst();
        assertEquals(1, m);
        assertEquals(true, arr1.isEmpty());
    }

    @Test
    public void testIsEmpty2() {
        ArrayDeque<Integer> arr1 = new ArrayDeque<>();
        assertEquals(true, arr1.isEmpty());
        arr1.addLast(1);
        assertEquals(1, arr1.size());
        assertEquals(false, arr1.isEmpty());
        int m = arr1.removeLast();
        assertEquals(1, m);
        assertEquals(true, arr1.isEmpty());
    }

    @Test
    public void testAddFirst() {
        ArrayDeque<Integer> arr1 = new ArrayDeque<>();
        arr1.addFirst(0);
        int a = arr1.removeLast();
        assertEquals(0, a);
    }

    @Test
    public void testGet() {
        ArrayDeque<Integer> arr1 = new ArrayDeque<>();
        arr1.addFirst(0);
        arr1.addFirst(1);
        arr1.addLast(2);
        int m = arr1.get(2);
        assertEquals(2, m);
    }

    @Test
    public void testAddFirst2() {
        ArrayDeque<Integer> arr1 = new ArrayDeque<>();
        arr1.addFirst(0);
        arr1.addFirst(1);
        assertEquals(0, (int) arr1.removeLast());
        assertEquals(1, (int) arr1.removeLast());
        arr1.removeLast();
        assertEquals(true, arr1.isEmpty());
    }


}
