/**
 * @author daisy
 * @description
 * @create 2021-11-26-14:42
 */
public class ArrayDeque<T> {


    private T[] t;
    private int size = 0;
    private int front = -1; //front pointer
    private int end = -1; // end pointer
    private int contain = 8;
    private double usage = 0.25; //usage Factor

    public ArrayDeque() {
        t = (T[]) new Object[contain];
    }

    private int helperfront(int x) {
        return (x + contain - 1) % contain;
    }

    private int helperend(int x) {
        return (x + contain + 1) % contain;
    }

    private T[] reformat() {
        T[] temp = (T[]) new Object[contain];
        if (front < end) {
            System.arraycopy(t, front, temp, 0, size);
        } else {
            System.arraycopy(t, front, temp, 0, size - front);
            System.arraycopy(t, 0, temp, size - front, end + 1);
            front = 0;
            end = size - 1;
        }
        return temp;
    }

    private void extendArray() {
        contain = 2 * contain;
        t = reformat();
    }

    private void shortArray() {
        contain = contain / 2;
        t = reformat();
    }

    private void implementEmpty() {
        front = 0;
        end = 0;
    }

    public void addFirst(T item) {
        if (size == contain) {
            extendArray();
            front = helperfront(front);
        } else if (size == 0) {
            implementEmpty();
        } else {
            front = helperfront(front);
        }
        t[front] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == contain) {
            extendArray();
            end = helperend(end);
        } else if (size == 0) {
            implementEmpty();
        } else {
            end = helperend(end);
        }
        t[end] = item;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (front <= end) {
            for (int i = front; i <= end; i++) {
                System.out.print(t[i] + " ");
            }
        } else {
            for (int i = front; i < contain; i++) {
                System.out.print(t[i] + " ");
            }
            for (int i = 0; i <= end; i++) {
                System.out.print(t[i] + " ");
            }
        }
    }

    public T removeFirst() {
        T temp = t[front];
        front = (front + contain + 1) % contain;
        size--;
        if (size == 0) {
            front = -1;
            end = -1;
        }
        double actualUsage = size / contain;
        if (size != 0 && actualUsage < usage) {
            shortArray();
        }

        return temp;
    }

    public T removeLast() {
        T temp = t[end];
        end = (end + contain - 1) % contain;
        size--;
        if (size == 0) {
            front = -1;
            end = -1;
        }
        double actualUsage = size / contain;
        if (size != 0 && actualUsage < usage) {
            shortArray();
        }
        return temp;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        } else if (front + index < contain) {
            return t[front + index];
        } else {
            return t[contain - front - 1 + index];
        }
    }
}
