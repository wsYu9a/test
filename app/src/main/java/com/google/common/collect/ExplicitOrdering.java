package com.google.common.collect;

import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.List;
import javax.annotation.CheckForNull;

@a5.b(serializable = true)
@e5.m
/* loaded from: classes2.dex */
final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap<T, Integer> rankMap;

    public ExplicitOrdering(List<T> list) {
        this(Maps.Q(list));
    }

    private int rank(T t10) {
        Integer num = this.rankMap.get(t10);
        if (num != null) {
            return num.intValue();
        }
        throw new Ordering.IncomparableValueException(t10);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t10, T t11) {
        return rank(t10) - rank(t11);
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof ExplicitOrdering) {
            return this.rankMap.equals(((ExplicitOrdering) obj).rankMap);
        }
        return false;
    }

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.rankMap.keySet());
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 19);
        sb2.append("Ordering.explicit(");
        sb2.append(valueOf);
        sb2.append(")");
        return sb2.toString();
    }

    public ExplicitOrdering(ImmutableMap<T, Integer> immutableMap) {
        this.rankMap = immutableMap;
    }
}
