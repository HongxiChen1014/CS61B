import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author daisy
 * @description
 * @create 2021-12-02-17:16
 */
public class TestArrayDequeGold {
    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> stdDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> correctDeque = new ArrayDequeSolution<>();
        String msg = "";

        for (int i = 0; i < 100; i += 1) {
            int chooseMethod = StdRandom.uniform(4);
            if (chooseMethod == 0) {
                // addFirst
                Integer chooseNum = StdRandom.uniform(100);
                stdDeque.addFirst(chooseNum);
                correctDeque.addFirst(chooseNum);
                msg += "addFirst(" + chooseNum + ")\n";
            } else if (chooseMethod == 1) {
                // addLast
                Integer chooseNum = StdRandom.uniform(100);
                stdDeque.addLast(chooseNum);
                correctDeque.addLast(chooseNum);
                msg += "addLast(" + chooseNum + ")\n";
            } else if (chooseMethod == 2) {
                //removeFirst
                if (stdDeque.size() == 0) {
                    continue;
                } else {
                    msg += "removeFirst()\n";
                    assertEquals(msg, correctDeque.removeFirst(), stdDeque.removeFirst());
                }
            } else {
                //removeLast
                if (stdDeque.size() == 0) {
                    continue;
                } else {
                    msg += "removeLast()\n";
                    assertEquals(msg, correctDeque.removeLast(), stdDeque.removeLast());
                }
            }

        }
    }
}
