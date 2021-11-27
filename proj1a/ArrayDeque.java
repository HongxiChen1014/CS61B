/**
 * @author daisy
 * @description
 * @create 2021-11-26-14:42
 */
public class ArrayDeque<T> {


    private T[] t;
    private int size;
    private int front; //front pointer
    private int end; // end pointer
    private int contain;
    private double usage = 0.25; //usage Factor

    public ArrayDeque() {
        contain = 8;
        front = -1;
        end = -1;
        size = 0;
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
        contain = (size + 1) * 2;
        t = reformat();
    }

    private void implementEmpty() {
        front = 0;
        end = 0;
    }

    public void addFirst(T item) {
        if (size == 0) {
            implementEmpty();
        }
        front = helperfront(front);
        t[front] = item;
        size++;
        if (size == contain) {
            extendArray();
        }

    }

    public void addLast(T item) {
        if (size == 0) {
            implementEmpty();
        }
        t[end] = item;
        size++;
        end = helperend(end);
        if (size == contain) {
            extendArray();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i));
            if (i != size - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T temp = get(0);
        t[front] = null;
        size--;
        if (size == 0) {
            front = -1;
            end = -1;
        } else {
            front = (front + contain + 1) % contain;
        }
        double actualUsage = (double) size / (double) contain;
        if (size >= 16 && actualUsage < usage) {
            shortArray();
        }
        return temp;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T temp = get(size - 1);
        t[end] = null;
        end = (end + contain - 1) % contain;
        size--;
        if (size == 0) {
            front = -1;
            end = -1;
        }
        double actualUsage = (double) size / (double) contain;
        if (size >= 16 && actualUsage < usage) {
            shortArray();
        }
        return temp;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        } else if (front + index < contain) {
            return t[front + index];
        } else {
            return t[index - contain + front];
        }
    }
}
