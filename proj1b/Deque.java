/**
 * @author daisy
 * @description
 * @create 2021-12-02-11:28
 */
public interface Deque<T> {
    public void addFirst(T item);

    public void addLast(T item);

    public boolean isEmpty();

    public int size();

    public void printDeque();

    public T removeFirst();

    public T removeLast();

    public T get(int index);
}
