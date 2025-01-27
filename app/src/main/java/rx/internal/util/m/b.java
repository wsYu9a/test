package rx.internal.util.m;

import rx.internal.util.atomic.LinkedQueueNode;

/* loaded from: classes5.dex */
abstract class b<E> extends d<E> {
    protected static final long I = g0.a(b.class, "consumerNode");
    protected LinkedQueueNode<E> J;

    b() {
    }

    protected final LinkedQueueNode<E> d() {
        return this.J;
    }

    protected final LinkedQueueNode<E> e() {
        return (LinkedQueueNode) g0.f36837a.getObjectVolatile(this, I);
    }

    protected final void f(LinkedQueueNode<E> linkedQueueNode) {
        this.J = linkedQueueNode;
    }
}
