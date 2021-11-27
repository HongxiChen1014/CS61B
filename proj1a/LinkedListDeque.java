/**
 * @author daisy
 * @description
 * @create 2021-11-26-14:41
 */
public class LinkedListDeque<T> {
    private static class LinkedList<T> {
        public T first;
        public LinkedList<T> prev;
        public LinkedList<T> next;

        public LinkedList(T i) {
            first = i;
            prev = null;
            next = null;
        }
    }

    private LinkedList<T> t;
    private int size;
    private LinkedList<T> numFirst;
    private LinkedList<T> numLast;

    public LinkedListDeque() {
        size = 0;
        t = null;
    }

    public void notNull(T item) {
        t = new LinkedList<T>(item);
        numFirst = t;
        numLast = t;
    }

    public void addFirst(T item) {
        if (t == null) {
            notNull(item);
        } else {
            numFirst.prev = new LinkedList<T>(item);
            numFirst.prev.next = numFirst;
            numFirst = numFirst.prev;
        }
        size++;
    }

    public void addLast(T item) {
        if (t == null) {
            notNull(item);
        } else {
            numLast.next = new LinkedList<>(item);
            numLast.next.prev = numLast;
            numLast = numLast.next;
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        LinkedList<T> cur = numFirst;

        while (cur != null) {
            System.out.print(cur.first + " ");
            cur = cur.next;
        }
    }

    public void isNull() {
        t = null;
        numLast = null;
        numFirst = null;
    }

    public T removeFirst() {
        LinkedList<T> cur = numFirst;
        T temp = cur.first;
        size--;
        if (size == 0) {
            isNull();
        } else {
            cur.next.prev = null;
            cur.next = null;
        }
        return temp;
    }

    public T removeLast() {
        LinkedList<T> cur = numLast;
        T temp = cur.first;
        size--;
        if (size == 0) {
            isNull();
        } else {
            cur.prev.next = null;
            cur.prev = null;
        }
        return temp;
    }

    public T get(int index) {
        LinkedList<T> cur = numFirst;
        int i = index;
        while (i > 0 && cur != null) {
            cur = cur.next;
            i--;
        }
        if (cur == null) {
            return null;
        }
        return cur.first;
    }


    public T getRecursive(int index) {
        LinkedList<T> result = getRecursiveHelper(numFirst, index);
        if (result == null) {
            return null;
        }
        return result.first;
    }

    private LinkedList<T> getRecursiveHelper(LinkedList<T> cur, int index) {
        if (index == 0 || cur == null) {
            return cur;
        } else {
            return getRecursiveHelper(cur.next, index - 1);
        }
    }
}
