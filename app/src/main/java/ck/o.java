package ck;

import rx.internal.util.atomic.LinkedQueueNode;

/* loaded from: classes5.dex */
public final class o<E> extends a<E> {
    public o() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        this.J = linkedQueueNode;
        g(linkedQueueNode);
    }

    public final LinkedQueueNode<E> g(LinkedQueueNode<E> linkedQueueNode) {
        LinkedQueueNode<E> linkedQueueNode2;
        do {
            linkedQueueNode2 = this.f2155r;
        } while (!p5.a.a(g0.f2178a, this, e.f2154s, linkedQueueNode2, linkedQueueNode));
        return linkedQueueNode2;
    }

    @Override // java.util.Queue
    public final boolean offer(E e10) {
        if (e10 == null) {
            throw new IllegalArgumentException("null elements not allowed");
        }
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e10);
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
        LinkedQueueNode<E> d10 = d();
        LinkedQueueNode<E> lvNext2 = d10.lvNext();
        if (lvNext2 != null) {
            E andNullValue = lvNext2.getAndNullValue();
            f(lvNext2);
            return andNullValue;
        }
        if (d10 == b()) {
            return null;
        }
        do {
            lvNext = d10.lvNext();
        } while (lvNext == null);
        E andNullValue2 = lvNext.getAndNullValue();
        this.J = lvNext;
        return andNullValue2;
    }
}
