package com.google.common.collect;

import e5.d1;
import e5.u0;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import javax.annotation.CheckForNull;

@a5.b(serializable = true)
@e5.m
/* loaded from: classes2.dex */
final class CompoundOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<? super T>[] comparators;

    public CompoundOrdering(Comparator<? super T> comparator, Comparator<? super T> comparator2) {
        this.comparators = new Comparator[]{comparator, comparator2};
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(@d1 T t10, @d1 T t11) {
        int i10 = 0;
        while (true) {
            Comparator<? super T>[] comparatorArr = this.comparators;
            if (i10 >= comparatorArr.length) {
                return 0;
            }
            int compare = comparatorArr[i10].compare(t10, t11);
            if (compare != 0) {
                return compare;
            }
            i10++;
        }
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CompoundOrdering) {
            return Arrays.equals(this.comparators, ((CompoundOrdering) obj).comparators);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.comparators);
    }

    public String toString() {
        String arrays = Arrays.toString(this.comparators);
        StringBuilder sb2 = new StringBuilder(String.valueOf(arrays).length() + 19);
        sb2.append("Ordering.compound(");
        sb2.append(arrays);
        sb2.append(")");
        return sb2.toString();
    }

    public CompoundOrdering(Iterable<? extends Comparator<? super T>> iterable) {
        this.comparators = (Comparator[]) u0.R(iterable, new Comparator[0]);
    }
}
