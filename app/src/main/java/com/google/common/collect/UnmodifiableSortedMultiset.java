package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.s;
import e5.d1;
import java.util.Comparator;
import java.util.NavigableSet;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@e5.m
/* loaded from: classes2.dex */
final class UnmodifiableSortedMultiset<E> extends Multisets.UnmodifiableMultiset<E> implements y<E> {
    private static final long serialVersionUID = 0;

    @CheckForNull
    private transient UnmodifiableSortedMultiset<E> descendingMultiset;

    public UnmodifiableSortedMultiset(y<E> yVar) {
        super(yVar);
    }

    @Override // com.google.common.collect.y, e5.m1
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.y
    public y<E> descendingMultiset() {
        UnmodifiableSortedMultiset<E> unmodifiableSortedMultiset = this.descendingMultiset;
        if (unmodifiableSortedMultiset != null) {
            return unmodifiableSortedMultiset;
        }
        UnmodifiableSortedMultiset<E> unmodifiableSortedMultiset2 = new UnmodifiableSortedMultiset<>(delegate().descendingMultiset());
        unmodifiableSortedMultiset2.descendingMultiset = this;
        this.descendingMultiset = unmodifiableSortedMultiset2;
        return unmodifiableSortedMultiset2;
    }

    @Override // com.google.common.collect.y
    @CheckForNull
    public s.a<E> firstEntry() {
        return delegate().firstEntry();
    }

    @Override // com.google.common.collect.y
    public y<E> headMultiset(@d1 E e10, BoundType boundType) {
        return Multisets.B(delegate().headMultiset(e10, boundType));
    }

    @Override // com.google.common.collect.y
    @CheckForNull
    public s.a<E> lastEntry() {
        return delegate().lastEntry();
    }

    @Override // com.google.common.collect.y
    @CheckForNull
    public s.a<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.y
    @CheckForNull
    public s.a<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.y
    public y<E> subMultiset(@d1 E e10, BoundType boundType, @d1 E e11, BoundType boundType2) {
        return Multisets.B(delegate().subMultiset(e10, boundType, e11, boundType2));
    }

    @Override // com.google.common.collect.y
    public y<E> tailMultiset(@d1 E e10, BoundType boundType) {
        return Multisets.B(delegate().tailMultiset(e10, boundType));
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset
    public NavigableSet<E> createElementSet() {
        return Sets.O(delegate().elementSet());
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.k, com.google.common.collect.s
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.k, e5.y, e5.l0
    public y<E> delegate() {
        return (y) super.delegate();
    }
}
