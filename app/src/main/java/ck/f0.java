package ck;

import rx.internal.util.atomic.LinkedQueueNode;

/* loaded from: classes5.dex */
public final class f0<E> extends a<E> {
    public f0() {
        c(new LinkedQueueNode<>());
        f(this.f2155r);
        this.J.soNext(null);
    }

    @Override // java.util.Queue
    public boolean offer(E e10) {
        if (e10 == null) {
            throw new IllegalArgumentException("null elements not allowed");
        }
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e10);
        this.f2155r.soNext(linkedQueueNode);
        this.f2155r = linkedQueueNode;
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueNode<E> lvNext = this.J.lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> lvNext = this.J.lvNext();
        if (lvNext == null) {
            return null;
        }
        E andNullValue = lvNext.getAndNullValue();
        this.J = lvNext;
        return andNullValue;
    }
}
