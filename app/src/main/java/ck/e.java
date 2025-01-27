package ck;

import rx.internal.util.atomic.LinkedQueueNode;

/* loaded from: classes5.dex */
public abstract class e<E> extends c<E> {

    /* renamed from: s */
    public static final long f2154s = g0.a(e.class, "producerNode");

    /* renamed from: r */
    public LinkedQueueNode<E> f2155r;

    public final LinkedQueueNode<E> a() {
        return this.f2155r;
    }

    public final LinkedQueueNode<E> b() {
        return (LinkedQueueNode) g0.f2178a.getObjectVolatile(this, f2154s);
    }

    public final void c(LinkedQueueNode<E> linkedQueueNode) {
        this.f2155r = linkedQueueNode;
    }
}
