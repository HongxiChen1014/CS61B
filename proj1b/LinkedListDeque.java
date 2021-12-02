/**
 * @author daisy
 * @description
 * @create 2021-11-26-14:41
 */
public class LinkedListDeque<T> implements Deque<T> {
    private static class LinkedList<T> {
        private T first;
        private LinkedList<T> prev;
        private LinkedList<T> next;

        private LinkedList(T i) {
            first = i;
            prev = null;
            next = null;
        }
    }

    private LinkedList<T> t;
    private int size;
    private LinkedList<T> front;
    private LinkedList<T> end;

    public LinkedListDeque() {
        size = 0;
        t = new LinkedList(null);
    }

    @Override
    public void addFirst(T item) {
        if (size == 0) {
            t.next = new LinkedList(item);
            t.next.prev = t;
            t.prev = t.next;
            t.prev.next = t;
            end = t.next;
        } else {
            LinkedList temp = t.next;
            t.next = new LinkedList(item);
            t.next.prev = t;
            t.next.next = temp;
            t.next.next.prev = t.next;
        }
        front = t.next;
        size++;
    }

    @Override
    public void addLast(T item) {
        if (size == 0) {
            t.prev = new LinkedList(item);
            t.prev.next = t;
            t.next = t.prev;
            t.next.prev = t;
            front = t.next;
        } else {
            t.prev = new LinkedList(item);
            t.prev.next = t;
            end.next = t.prev;
            end.next.prev = end;
        }
        end = t.prev;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        LinkedList<T> cur = front;
        for (int i = 0; i < size; i++) {
            System.out.print(get(i));
            if (i != size - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T value = front.first;
        front = front.next;
        t.next = front;
        front.prev = t;
        size--;
        if (size == 0) {
            front = null;
            end = null;
        }
        return value;

    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T value = end.first;
        end = end.prev;
        end.next = t;
        t.prev = end;
        size--;
        if (size == 0) {
            front = null;
            end = null;
        }
        return value;
    }

    @Override
    public T get(int index) {
        if (index < 0 || front == null || index >= size) {
            return null;
        }
        LinkedList<T> cur = front;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.first;
    }


    public T getRecursive(int index) {
        if (index < 0 || front == null || index >= size) {
            return null;
        }
        LinkedList<T> result = getRecursiveHelper(front, index);
        return result.first;
    }

    private LinkedList<T> getRecursiveHelper(LinkedList<T> cur, int index) {
        if (index == 0) {
            return cur;
        } else {
            return getRecursiveHelper(cur.next, index - 1);
        }
    }
}

