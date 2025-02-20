import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<T> implements Stack<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public T peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return (T) elements[size - 1];
    }

    @Override
    public T pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        T element = (T) elements[--size];
        elements[size] = null;
        return element;
    }

    @Override
    public T push(T item) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = item;
        return item;
    }

    @Override
    public int search(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (o.equals(elements[i])) {
                return size - i;
            }
        }
        return -1;
    }

    private void resize() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }
}
