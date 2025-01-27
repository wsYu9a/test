package rx.internal.util.atomic;

/* loaded from: classes5.dex */
public final class c<E> extends a<E> {
    public c() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        f(linkedQueueNode);
        e(linkedQueueNode);
        linkedQueueNode.soNext(null);
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        if (e2 == null) {
            throw new IllegalArgumentException("null elements not allowed");
        }
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e2);
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
