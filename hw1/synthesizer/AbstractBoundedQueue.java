package synthesizer;

/**
 * @author daisy
 * @description
 * @create 2021-12-04-12:50
 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;

    public int capacity() {
        return capacity;
    }

    public int fillCount() {
        return fillCount;
    }

}
