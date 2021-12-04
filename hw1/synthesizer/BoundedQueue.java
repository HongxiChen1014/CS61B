package synthesizer;

import java.util.Iterator;

/**
 * @author daisy
 * @description
 * @create 2021-12-04-12:49
 */
public interface BoundedQueue<T> extends Iterable<T> {
    public int capacity();

    public int fillCount();

    public void enqueue(T x);

    public T dequeue();

    public T peek();

    default boolean isEmpty() {
        return true;
    }

    default boolean isFull() {
        return false;
    }

    public Iterator<T> iterator();
}
