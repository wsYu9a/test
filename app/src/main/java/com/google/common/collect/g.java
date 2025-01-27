package com.google.common.collect;

import e5.d1;
import java.util.Comparator;
import java.util.Iterator;

@a5.b
@e5.m
/* loaded from: classes2.dex */
public final class g {
    public static <T> boolean a(Iterable<? extends T> iterable, Comparator<T> comparator) {
        b5.u.E(comparator);
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public static <T> boolean b(Iterable<? extends T> iterable, Comparator<T> comparator) {
        b5.u.E(comparator);
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) >= 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public static <T, S extends T> Comparator<Iterable<S>> c(Comparator<T> comparator) {
        return new LexicographicalOrdering((Comparator) b5.u.E(comparator));
    }

    public static <T extends Comparable<? super T>> T d(T t10, T t11) {
        return t10.compareTo(t11) >= 0 ? t10 : t11;
    }

    @d1
    public static <T> T e(@d1 T t10, @d1 T t11, Comparator<T> comparator) {
        return comparator.compare(t10, t11) >= 0 ? t10 : t11;
    }

    public static <T extends Comparable<? super T>> T f(T t10, T t11) {
        return t10.compareTo(t11) <= 0 ? t10 : t11;
    }

    @d1
    public static <T> T g(@d1 T t10, @d1 T t11, Comparator<T> comparator) {
        return comparator.compare(t10, t11) <= 0 ? t10 : t11;
    }
}
