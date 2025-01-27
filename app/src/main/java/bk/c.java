package bk;

import rx.internal.util.atomic.LinkedQueueNode;

/* loaded from: classes5.dex */
public final class c<E> extends a<E> {
    public c() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        f(linkedQueueNode);
        e(linkedQueueNode);
        linkedQueueNode.soNext(null);
    }

    @Override // java.util.Queue
    public boolean offer(E e10) {
        if (e10 == null) {
            throw new IllegalArgumentException("null elements not allowed");
        }
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e10);
        b().soNext(linkedQueueNode);
        f(linkedQueueNode);
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueNode<E> lvNext = a().lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> lvNext = a().lvNext();
        if (lvNext == null) {
            return null;
        }
        E andNullValue = lvNext.getAndNullValue();
        e(lvNext);
        return andNullValue;
    }
}
