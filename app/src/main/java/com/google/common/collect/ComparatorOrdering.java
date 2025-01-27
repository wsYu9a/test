package com.google.common.collect;

import e5.d1;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.CheckForNull;

@a5.b(serializable = true)
@e5.m
/* loaded from: classes2.dex */
final class ComparatorOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<T> comparator;

    public ComparatorOrdering(Comparator<T> comparator) {
        this.comparator = (Comparator) b5.u.E(comparator);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(@d1 T t10, @d1 T t11) {
        return this.comparator.compare(t10, t11);
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ComparatorOrdering) {
            return this.comparator.equals(((ComparatorOrdering) obj).comparator);
        }
        return false;
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public String toString() {
        return this.comparator.toString();
    }
}
