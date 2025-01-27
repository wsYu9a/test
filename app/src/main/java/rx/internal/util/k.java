package rx.internal.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes5.dex */
public class k<T> implements Queue<T> {

    /* renamed from: a */
    private final LinkedList<T> f36814a;

    /* renamed from: b */
    private final int f36815b;

    public k() {
        this.f36814a = new LinkedList<>();
        this.f36815b = -1;
    }

    @Override // java.util.Queue, java.util.Collection
    public synchronized boolean add(T t) {
        return this.f36814a.add(t);
    }

    @Override // java.util.Collection
    public synchronized boolean addAll(Collection<? extends T> collection) {
        return this.f36814a.addAll(collection);
    }

    @Override // java.util.Collection
    public synchronized void clear() {
        this.f36814a.clear();
    }

    public synchronized Object clone() {
        k kVar;
        kVar = new k(this.f36815b);
        kVar.addAll(this.f36814a);
        return kVar;
    }

    @Override // java.util.Collection
    public synchronized boolean contains(Object obj) {
        return this.f36814a.contains(obj);
    }

    @Override // java.util.Collection
    public synchronized boolean containsAll(Collection<?> collection) {
        return this.f36814a.containsAll(collection);
    }

    @Override // java.util.Queue
    public synchronized T element() {
        return this.f36814a.element();
    }

    @Override // java.util.Collection
    public synchronized boolean equals(Object obj) {
        return this.f36814a.equals(obj);
    }

    @Override // java.util.Collection
    public synchronized int hashCode() {
        return this.f36814a.hashCode();
    }

    @Override // java.util.Collection
    public synchronized boolean isEmpty() {
        return this.f36814a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public synchronized Iterator<T> iterator() {
        return this.f36814a.iterator();
    }

    @Override // java.util.Queue
    public synchronized boolean offer(T t) {
        if (this.f36815b > -1 && this.f36814a.size() + 1 > this.f36815b) {
            return false;
        }
        return this.f36814a.offer(t);
    }

    @Override // java.util.Queue
    public synchronized T peek() {
        return this.f36814a.peek();
    }

    @Override // java.util.Queue
    public synchronized T poll() {
        return this.f36814a.poll();
    }

    @Override // java.util.Collection
    public synchronized boolean remove(Object obj) {
        return this.f36814a.remove(obj);
    }

    @Override // java.util.Collection
    public synchronized boolean removeAll(Collection<?> collection) {
        return this.f36814a.removeAll(collection);
    }

    @Override // java.util.Collection
    public synchronized boolean retainAll(Collection<?> collection) {
        return this.f36814a.retainAll(collection);
    }

    @Override // java.util.Collection
    public synchronized int size() {
        return this.f36814a.size();
    }

    @Override // java.util.Collection
    public synchronized Object[] toArray() {
        return this.f36814a.toArray();
    }

    public synchronized String toString() {
        return this.f36814a.toString();
    }

    @Override // java.util.Queue
    public synchronized T remove() {
        return this.f36814a.remove();
    }

    @Override // java.util.Collection
    public synchronized <R> R[] toArray(R[] rArr) {
        return (R[]) this.f36814a.toArray(rArr);
    }

    public k(int i2) {
        this.f36814a = new LinkedList<>();
        this.f36815b = i2;
    }
}
