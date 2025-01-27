package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.m0;
import e5.u0;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

@a5.b
@a5.a
@e5.m
/* loaded from: classes2.dex */
public final class EvictingQueue<E> extends m0<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Queue<E> delegate;

    @a5.d
    final int maxSize;

    private EvictingQueue(int i10) {
        b5.u.k(i10 >= 0, "maxSize (%s) must >= 0", i10);
        this.delegate = new ArrayDeque(i10);
        this.maxSize = i10;
    }

    public static <E> EvictingQueue<E> create(int i10) {
        return new EvictingQueue<>(i10);
    }

    @Override // e5.y, java.util.Collection, java.util.Queue
    @CanIgnoreReturnValue
    public boolean add(E e10) {
        b5.u.E(e10);
        if (this.maxSize == 0) {
            return true;
        }
        if (size() == this.maxSize) {
            this.delegate.remove();
        }
        this.delegate.add(e10);
        return true;
    }

    @Override // e5.y, java.util.Collection
    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        if (size < this.maxSize) {
            return standardAddAll(collection);
        }
        clear();
        return u0.a(this, u0.N(collection, size - this.maxSize));
    }

    @Override // e5.m0, java.util.Queue
    @CanIgnoreReturnValue
    public boolean offer(E e10) {
        return add(e10);
    }

    public int remainingCapacity() {
        return this.maxSize - size();
    }

    @Override // e5.y, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return super.toArray();
    }

    @Override // e5.m0, e5.y, e5.l0
    public Queue<E> delegate() {
        return this.delegate;
    }
}
