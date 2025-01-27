package com.nostra13.universalimageloader.core.assist.deque;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public interface a<E> extends BlockingQueue<E>, b<E> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.a, java.util.concurrent.BlockingQueue, com.nostra13.universalimageloader.core.assist.deque.b
    boolean add(E e2);

    void addFirst(E e2);

    void addLast(E e2);

    @Override // java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.a, java.util.concurrent.BlockingQueue, com.nostra13.universalimageloader.core.assist.deque.b
    boolean contains(Object obj);

    E element();

    Iterator<E> iterator();

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, java.util.concurrent.BlockingQueue, com.nostra13.universalimageloader.core.assist.deque.b
    boolean offer(E e2);

    @Override // java.util.concurrent.BlockingQueue
    boolean offer(E e2, long j2, TimeUnit timeUnit) throws InterruptedException;

    boolean offerFirst(E e2);

    boolean offerFirst(E e2, long j2, TimeUnit timeUnit) throws InterruptedException;

    boolean offerLast(E e2);

    boolean offerLast(E e2, long j2, TimeUnit timeUnit) throws InterruptedException;

    E peek();

    E poll();

    @Override // java.util.concurrent.BlockingQueue
    E poll(long j2, TimeUnit timeUnit) throws InterruptedException;

    E pollFirst(long j2, TimeUnit timeUnit) throws InterruptedException;

    E pollLast(long j2, TimeUnit timeUnit) throws InterruptedException;

    void push(E e2);

    @Override // java.util.concurrent.BlockingQueue
    void put(E e2) throws InterruptedException;

    void putFirst(E e2) throws InterruptedException;

    void putLast(E e2) throws InterruptedException;

    E remove();

    @Override // java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.a, java.util.concurrent.BlockingQueue, com.nostra13.universalimageloader.core.assist.deque.b
    boolean remove(Object obj);

    boolean removeFirstOccurrence(Object obj);

    boolean removeLastOccurrence(Object obj);

    int size();

    @Override // java.util.concurrent.BlockingQueue
    E take() throws InterruptedException;

    E takeFirst() throws InterruptedException;

    E takeLast() throws InterruptedException;
}
