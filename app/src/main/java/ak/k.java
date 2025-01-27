package ak;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes5.dex */
public class k<T> implements Queue<T> {

    /* renamed from: b, reason: collision with root package name */
    public final LinkedList<T> f276b;

    /* renamed from: c, reason: collision with root package name */
    public final int f277c;

    public k() {
        this.f276b = new LinkedList<>();
        this.f277c = -1;
    }

    @Override // java.util.Queue, java.util.Collection
    public synchronized boolean add(T t10) {
        return this.f276b.add(t10);
    }

    @Override // java.util.Collection
    public synchronized boolean addAll(Collection<? extends T> collection) {
        return this.f276b.addAll(collection);
    }

    @Override // java.util.Collection
    public synchronized void clear() {
        this.f276b.clear();
    }

    public synchronized Object clone() {
        k kVar;
        kVar = new k(this.f277c);
        kVar.addAll(this.f276b);
        return kVar;
    }

    @Override // java.util.Collection
    public synchronized boolean contains(Object obj) {
        return this.f276b.contains(obj);
    }

    @Override // java.util.Collection
    public synchronized boolean containsAll(Collection<?> collection) {
        return this.f276b.containsAll(collection);
    }

    @Override // java.util.Queue
    public synchronized T element() {
        return this.f276b.element();
    }

    @Override // java.util.Collection
    public synchronized boolean equals(Object obj) {
        return this.f276b.equals(obj);
    }

    @Override // java.util.Collection
    public synchronized int hashCode() {
        return this.f276b.hashCode();
    }

    @Override // java.util.Collection
    public synchronized boolean isEmpty() {
        return this.f276b.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public synchronized Iterator<T> iterator() {
        return this.f276b.iterator();
    }

    @Override // java.util.Queue
    public synchronized boolean offer(T t10) {
        if (this.f277c > -1 && this.f276b.size() + 1 > this.f277c) {
            return false;
        }
        return this.f276b.offer(t10);
    }

    @Override // java.util.Queue
    public synchronized T peek() {
        return this.f276b.peek();
    }

    @Override // java.util.Queue
    public synchronized T poll() {
        return this.f276b.poll();
    }

    @Override // java.util.Collection
    public synchronized boolean remove(Object obj) {
        return this.f276b.remove(obj);
    }

    @Override // java.util.Collection
    public synchronized boolean removeAll(Collection<?> collection) {
        return this.f276b.removeAll(collection);
    }

    @Override // java.util.Collection
    public synchronized boolean retainAll(Collection<?> collection) {
        return this.f276b.retainAll(collection);
    }

    @Override // java.util.Collection
    public synchronized int size() {
        return this.f276b.size();
    }

    @Override // java.util.Collection
    public synchronized Object[] toArray() {
        return this.f276b.toArray();
    }

    public synchronized String toString() {
        return this.f276b.toString();
    }

    @Override // java.util.Queue
    public synchronized T remove() {
        return this.f276b.remove();
    }

    @Override // java.util.Collection
    public synchronized <R> R[] toArray(R[] rArr) {
        return (R[]) this.f276b.toArray(rArr);
    }

    public k(int i10) {
        this.f276b = new LinkedList<>();
        this.f277c = i10;
    }
}
