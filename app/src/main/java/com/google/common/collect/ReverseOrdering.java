package com.google.common.collect;

import e5.d1;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@a5.b(serializable = true)
@e5.m
/* loaded from: classes2.dex */
final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering<? super T> forwardOrder;

    public ReverseOrdering(Ordering<? super T> ordering) {
        this.forwardOrder = (Ordering) b5.u.E(ordering);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(@d1 T t10, @d1 T t11) {
        return this.forwardOrder.compare(t11, t10);
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReverseOrdering) {
            return this.forwardOrder.equals(((ReverseOrdering) obj).forwardOrder);
        }
        return false;
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(@d1 E e10, @d1 E e11) {
        return (E) this.forwardOrder.min(e10, e11);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(@d1 E e10, @d1 E e11) {
        return (E) this.forwardOrder.max(e10, e11);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        return this.forwardOrder;
    }

    public String toString() {
        String valueOf = String.valueOf(this.forwardOrder);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 10);
        sb2.append(valueOf);
        sb2.append(".reverse()");
        return sb2.toString();
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(@d1 E e10, @d1 E e11, @d1 E e12, E... eArr) {
        return (E) this.forwardOrder.min(e10, e11, e12, eArr);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(@d1 E e10, @d1 E e11, @d1 E e12, E... eArr) {
        return (E) this.forwardOrder.max(e10, e11, e12, eArr);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterator<E> it) {
        return (E) this.forwardOrder.min(it);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterator<E> it) {
        return (E) this.forwardOrder.max(it);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterable<E> iterable) {
        return (E) this.forwardOrder.min(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterable<E> iterable) {
        return (E) this.forwardOrder.max(iterable);
    }
}
