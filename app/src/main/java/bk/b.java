package bk;

import rx.internal.util.atomic.LinkedQueueNode;

/* loaded from: classes5.dex */
public final class b<E> extends a<E> {
    public b() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        e(linkedQueueNode);
        g(linkedQueueNode);
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
        LinkedQueueNode<E> a10 = a();
        LinkedQueueNode<E> lvNext2 = a10.lvNext();
        if (lvNext2 != null) {
            return lvNext2.lpValue();
        }
        if (a10 == d()) {
            return null;
        }
        do {
            lvNext = a10.lvNext();
        } while (lvNext == null);
        return lvNext.lpValue();
    }

    @Override // java.util.Queue
    public final E poll() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> a10 = a();
        LinkedQueueNode<E> lvNext2 = a10.lvNext();
        if (lvNext2 != null) {
            E andNullValue = lvNext2.getAndNullValue();
            e(lvNext2);
            return andNullValue;
        }
        if (a10 == d()) {
            return null;
        }
        do {
            lvNext = a10.lvNext();
        } while (lvNext == null);
        E andNullValue2 = lvNext.getAndNullValue();
        e(lvNext);
        return andNullValue2;
    }
}
