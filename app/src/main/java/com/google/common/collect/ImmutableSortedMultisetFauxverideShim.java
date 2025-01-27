package com.google.common.collect;

import com.google.common.collect.ImmutableSortedMultiset;
import com.google.errorprone.annotations.DoNotCall;

@e5.m
@a5.c
/* loaded from: classes2.dex */
abstract class ImmutableSortedMultisetFauxverideShim<E> extends ImmutableMultiset<E> {
    @DoNotCall("Use naturalOrder.")
    @Deprecated
    public static <E> ImmutableSortedMultiset.a<E> builder() {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    public static <E> ImmutableSortedMultiset<E> copyOf(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e10) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e10, E e11) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e10, E e11, E e12) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e10, E e11, E e12, E e13) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e10, E e11, E e12, E e13, E e14) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E... eArr) {
        throw new UnsupportedOperationException();
    }
}
