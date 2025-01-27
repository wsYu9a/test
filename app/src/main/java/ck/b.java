package ck;

import rx.internal.util.atomic.LinkedQueueNode;

/* loaded from: classes5.dex */
public abstract class b<E> extends d<E> {
    public static final long K = g0.a(b.class, "consumerNode");
    public LinkedQueueNode<E> J;

    public final LinkedQueueNode<E> d() {
        return this.J;
    }

    public final LinkedQueueNode<E> e() {
        return (LinkedQueueNode) g0.f2178a.getObjectVolatile(this, K);
    }

    public final void f(LinkedQueueNode<E> linkedQueueNode) {
        this.J = linkedQueueNode;
    }
}
