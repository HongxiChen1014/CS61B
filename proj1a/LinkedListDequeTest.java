import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Performs some basic linked list tests.
 */
public class LinkedListDequeTest {

    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /**
     * Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     * <p>
     * && is the "and" operation.
     */
    @Test
    public void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");
        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addLast("middle");
        passed = checkSize(2, lld1.size()) && passed;

        lld1.addLast("back");
        passed = checkSize(3, lld1.size()) && passed;

        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);

    }

    /**
     * Adds an item, then removes an item, and ensures that dll is empty afterwards.
     */
    @Test
    public void addRemoveTest() {

        System.out.println("Running add/remove test.");

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst(10);
        lld1.removeFirst();
        // should not be empty
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.removeFirst();
        // should be empty
        passed = checkEmpty(true, lld1.isEmpty()) && passed;

        printTestStatus(passed);

    }

    @Test
    public void testArrayDequeAddFirst() {
        ArrayDeque<Integer> arr1 = new ArrayDeque<>();
        assertEquals(true, arr1.isEmpty());
        arr1.addFirst(1);
        arr1.addFirst(2);
        arr1.addFirst(3);
        arr1.addFirst(4);
        arr1.addFirst(5);
        arr1.addFirst(6);
        arr1.addFirst(7);
        arr1.addFirst(8);
        arr1.addFirst(9);
        System.out.println(arr1.size());
        assertEquals(9, arr1.size());
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
