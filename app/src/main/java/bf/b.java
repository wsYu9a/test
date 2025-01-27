package bf;

import java.util.Iterator;
import java.util.Queue;

/* loaded from: classes3.dex */
public interface b<E> extends Queue<E> {
    boolean add(E e10);

    void addFirst(E e10);

    void addLast(E e10);

    boolean contains(Object obj);

    Iterator<E> descendingIterator();

    E element();

    E getFirst();

    E getLast();

    Iterator<E> iterator();

    boolean offer(E e10);

    boolean offerFirst(E e10);

    boolean offerLast(E e10);

    E peek();

    E peekFirst();

    E peekLast();

    E poll();

    E pollFirst();

    E pollLast();

    E pop();

    void push(E e10);

    E remove();

    boolean remove(Object obj);

    E removeFirst();

    boolean removeFirstOccurrence(Object obj);

    E removeLast();

    boolean removeLastOccurrence(Object obj);

    int size();
}
