package synthesizer;

import java.util.Iterator;

/**
 * @author daisy
 * @description
 * @create 2021-12-04-12:49
 */
public interface BoundedQueue<T> extends Iterable<T> {
    int capacity();

    int fillCount();

    void enqueue(T x);

    T dequeue();

    T peek();

    default boolean isEmpty() {
        return fillCount() == 0;
    }

    default boolean isFull() {
        return fillCount() == capacity();
    }

    Iterator<T> iterator();
}
