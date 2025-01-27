package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
abstract class a<E> extends AbstractQueue<E> {

    /* renamed from: a */
    private final AtomicReference<LinkedQueueNode<E>> f36762a = new AtomicReference<>();

    /* renamed from: b */
    private final AtomicReference<LinkedQueueNode<E>> f36763b = new AtomicReference<>();

    protected final LinkedQueueNode<E> a() {
        return this.f36763b.get();
    }

    protected final LinkedQueueNode<E> b() {
        return this.f36762a.get();
    }

    protected final LinkedQueueNode<E> c() {
        return this.f36763b.get();
    }

    protected final LinkedQueueNode<E> d() {
        return this.f36762a.get();
    }

    protected final void e(LinkedQueueNode<E> linkedQueueNode) {
        this.f36763b.lazySet(linkedQueueNode);
    }

    protected final void f(LinkedQueueNode<E> linkedQueueNode) {
        this.f36762a.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> g(LinkedQueueNode<E> linkedQueueNode) {
        return this.f36762a.getAndSet(linkedQueueNode);
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
        LinkedQueueNode<E> c2 = c();
        LinkedQueueNode<E> d2 = d();
        int i2 = 0;
        while (c2 != d2 && i2 < Integer.MAX_VALUE) {
            do {
                lvNext = c2.lvNext();
            } while (lvNext == null);
            i2++;
            c2 = lvNext;
        }
        return i2;
    }
}
