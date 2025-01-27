package bk;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.atomic.LinkedQueueNode;

/* loaded from: classes5.dex */
public abstract class a<E> extends AbstractQueue<E> {

    /* renamed from: b */
    public final AtomicReference<LinkedQueueNode<E>> f1684b = new AtomicReference<>();

    /* renamed from: c */
    public final AtomicReference<LinkedQueueNode<E>> f1685c = new AtomicReference<>();

    public final LinkedQueueNode<E> a() {
        return this.f1685c.get();
    }

    public final LinkedQueueNode<E> b() {
        return this.f1684b.get();
    }

    public final LinkedQueueNode<E> c() {
        return this.f1685c.get();
    }

    public final LinkedQueueNode<E> d() {
        return this.f1684b.get();
    }

    public final void e(LinkedQueueNode<E> linkedQueueNode) {
        this.f1685c.lazySet(linkedQueueNode);
    }

    public final void f(LinkedQueueNode<E> linkedQueueNode) {
        this.f1684b.lazySet(linkedQueueNode);
    }

    public final LinkedQueueNode<E> g(LinkedQueueNode<E> linkedQueueNode) {
        return this.f1684b.getAndSet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return c() == d();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> c10 = c();
        LinkedQueueNode<E> d10 = d();
        int i10 = 0;
        while (c10 != d10 && i10 < Integer.MAX_VALUE) {
            do {
                lvNext = c10.lvNext();
            } while (lvNext == null);
            i10++;
            c10 = lvNext;
        }
        return i10;
    }
}
