package com.google.common.collect;

import java.io.Serializable;
import javax.annotation.CheckForNull;

@a5.b(serializable = true)
@e5.m
/* loaded from: classes2.dex */
final class NullsFirstOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering<? super T> ordering;

    public NullsFirstOrdering(Ordering<? super T> ordering) {
        this.ordering = ordering;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(@CheckForNull T t10, @CheckForNull T t11) {
        if (t10 == t11) {
            return 0;
        }
        if (t10 == null) {
            return -1;
        }
        if (t11 == null) {
            return 1;
        }
        return this.ordering.compare(t10, t11);
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NullsFirstOrdering) {
            return this.ordering.equals(((NullsFirstOrdering) obj).ordering);
        }
        return false;
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ 957692532;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> nullsFirst() {
        return this;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> nullsLast() {
        return this.ordering.nullsLast();
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        return this.ordering.reverse().nullsLast();
    }

    public String toString() {
        String valueOf = String.valueOf(this.ordering);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 13);
        sb2.append(valueOf);
        sb2.append(".nullsFirst()");
        return sb2.toString();
    }
}
