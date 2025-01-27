package rx.internal.util.m;

import rx.internal.util.atomic.LinkedQueueNode;

/* loaded from: classes5.dex */
abstract class e<E> extends c<E> {
    protected static final long q = g0.a(e.class, "producerNode");
    protected LinkedQueueNode<E> r;

    e() {
    }

    protected final LinkedQueueNode<E> a() {
        return this.r;
    }

    protected final LinkedQueueNode<E> b() {
        return (LinkedQueueNode) g0.f36837a.getObjectVolatile(this, q);
    }

    protected final void c(LinkedQueueNode<E> linkedQueueNode) {
        this.r = linkedQueueNode;
    }
}
