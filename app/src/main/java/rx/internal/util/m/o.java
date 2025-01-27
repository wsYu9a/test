package rx.internal.util.m;

import rx.internal.util.atomic.LinkedQueueNode;

/* loaded from: classes5.dex */
public final class o<E> extends a<E> {
    public o() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        this.J = linkedQueueNode;
        g(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> g(LinkedQueueNode<E> linkedQueueNode) {
        LinkedQueueNode<E> linkedQueueNode2;
        do {
            linkedQueueNode2 = this.r;
        } while (!g0.f36837a.compareAndSwapObject(this, e.q, linkedQueueNode2, linkedQueueNode));
        return linkedQueueNode2;
    }

    @Override // java.util.Queue
    public final boolean offer(E e2) {
        if (e2 == null) {
            throw new IllegalArgumentException("null elements not allowed");
        }
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e2);
        g(linkedQueueNode).soNext(linkedQueueNode);
        return true;
    }

    @Override // java.util.Queue
    public final E peek() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> linkedQueueNode = this.J;
        LinkedQueueNode<E> lvNext2 = linkedQueueNode.lvNext();
        if (lvNext2 != null) {
            return lvNext2.lpValue();
        }
        if (linkedQueueNode == b()) {
            return null;
        }
        do {
            lvNext = linkedQueueNode.lvNext();
        } while (lvNext == null);
        return lvNext.lpValue();
    }

    @Override // java.util.Queue
    public final E poll() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> d2 = d();
        LinkedQueueNode<E> lvNext2 = d2.lvNext();
        if (lvNext2 != null) {
            E andNullValue = lvNext2.getAndNullValue();
            f(lvNext2);
            return andNullValue;
        }
        if (d2 == b()) {
            return null;
        }
        do {
            lvNext = d2.lvNext();
        } while (lvNext == null);
        E andNullValue2 = lvNext.getAndNullValue();
        this.J = lvNext;
        return andNullValue2;
    }
}
