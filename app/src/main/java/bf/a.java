package bf;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public interface a<E> extends BlockingQueue<E>, b<E> {
    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection, bf.b
    boolean add(E e10);

    @Override // bf.b
    void addFirst(E e10);

    @Override // bf.b
    void addLast(E e10);

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection, bf.b
    boolean contains(Object obj);

    @Override // java.util.Queue, bf.b
    E element();

    @Override // java.util.Collection, java.lang.Iterable, bf.b
    Iterator<E> iterator();

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, bf.b
    boolean offer(E e10);

    @Override // java.util.concurrent.BlockingQueue
    boolean offer(E e10, long j10, TimeUnit timeUnit) throws InterruptedException;

    @Override // bf.b
    boolean offerFirst(E e10);

    boolean offerFirst(E e10, long j10, TimeUnit timeUnit) throws InterruptedException;

    @Override // bf.b
    boolean offerLast(E e10);

    boolean offerLast(E e10, long j10, TimeUnit timeUnit) throws InterruptedException;

    @Override // java.util.Queue, bf.b
    E peek();

    @Override // java.util.Queue, bf.b
    E poll();

    @Override // java.util.concurrent.BlockingQueue
    E poll(long j10, TimeUnit timeUnit) throws InterruptedException;

    E pollFirst(long j10, TimeUnit timeUnit) throws InterruptedException;

    E pollLast(long j10, TimeUnit timeUnit) throws InterruptedException;

    @Override // bf.b
    void push(E e10);

    @Override // java.util.concurrent.BlockingQueue
    void put(E e10) throws InterruptedException;

    void putFirst(E e10) throws InterruptedException;

    void putLast(E e10) throws InterruptedException;

    @Override // java.util.Queue, bf.b
    E remove();

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection, bf.b
    boolean remove(Object obj);

    @Override // bf.b
    boolean removeFirstOccurrence(Object obj);

    @Override // bf.b
    boolean removeLastOccurrence(Object obj);

    @Override // java.util.Collection, bf.b
    int size();

    @Override // java.util.concurrent.BlockingQueue
    E take() throws InterruptedException;

    E takeFirst() throws InterruptedException;

    E takeLast() throws InterruptedException;
}
