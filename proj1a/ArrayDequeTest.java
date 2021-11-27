import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author daisy
 * @description
 * @create 2021-11-26-21:59
 */
public class ArrayDequeTest {
    @Test
    public void testAddFirst() {
        ArrayDeque<Integer> arr1 = new ArrayDeque<>();
        assertEquals(true, arr1.isEmpty());
        arr1.addFirst(1);
        assertEquals(1, arr1.size());
        assertEquals(false, arr1.isEmpty());
        arr1.removeFirst();
        assertEquals(true, arr1.isEmpty());
    }

    @Test
    public void testAddLast() {
        ArrayDeque<Integer> arr1 = new ArrayDeque<>();
        assertEquals(true, arr1.isEmpty());
        arr1.addLast(1);
        assertEquals(1, arr1.size());
        assertEquals(false, arr1.isEmpty());
        arr1.removeLast();
        assertEquals(true, arr1.isEmpty());
    }

    @Test
    public void testArrayDequeAddLast() {
        ArrayDeque<Integer> arr1 = new ArrayDeque<>();
        assertEquals(true, arr1.isEmpty());
        arr1.addLast(1);
        arr1.addLast(2);
        arr1.addLast(3);
        arr1.addLast(4);
        arr1.addLast(5);
        arr1.addLast(6);
        arr1.addLast(7);
        arr1.addLast(8);
        arr1.addLast(9);
        System.out.println(arr1.size());
        assertEquals(9, arr1.size());
        arr1.printDeque();
        assertEquals((Integer) 1, arr1.get(0));
    }
}
