package com.google.common.collect;

import com.google.common.collect.s;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import javax.annotation.CheckForNull;

@e5.m
@a5.c
/* loaded from: classes2.dex */
final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    private final transient long[] cumulativeCounts;

    @a5.d
    final transient RegularImmutableSortedSet<E> elementSet;
    private final transient int length;
    private final transient int offset;
    private static final long[] ZERO_CUMULATIVE_COUNTS = {0};
    static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(Ordering.natural());

    public RegularImmutableSortedMultiset(Comparator<? super E> comparator) {
        this.elementSet = ImmutableSortedSet.emptySet(comparator);
        this.cumulativeCounts = ZERO_CUMULATIVE_COUNTS;
        this.offset = 0;
        this.length = 0;
    }

    private int getCount(int i10) {
        long[] jArr = this.cumulativeCounts;
        int i11 = this.offset;
        return (int) (jArr[(i11 + i10) + 1] - jArr[i11 + i10]);
    }

    @Override // com.google.common.collect.s
    public int count(@CheckForNull Object obj) {
        int indexOf = this.elementSet.indexOf(obj);
        if (indexOf >= 0) {
            return getCount(indexOf);
        }
        return 0;
    }

    @Override // com.google.common.collect.y
    @CheckForNull
    public s.a<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(0);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public s.a<E> getEntry(int i10) {
        return Multisets.k(this.elementSet.asList().get(i10), getCount(i10));
    }

    public ImmutableSortedMultiset<E> getSubMultiset(int i10, int i11) {
        b5.u.f0(i10, i11, this.length);
        return i10 == i11 ? ImmutableSortedMultiset.emptyMultiset(comparator()) : (i10 == 0 && i11 == this.length) ? this : new RegularImmutableSortedMultiset(this.elementSet.getSubSet(i10, i11), this.cumulativeCounts, this.offset + i10, i11 - i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.y
    public /* bridge */ /* synthetic */ y headMultiset(Object obj, BoundType boundType) {
        return headMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.offset > 0 || this.length < this.cumulativeCounts.length - 1;
    }

    @Override // com.google.common.collect.y
    @CheckForNull
    public s.a<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(this.length - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.s
    public int size() {
        long[] jArr = this.cumulativeCounts;
        int i10 = this.offset;
        return Ints.x(jArr[this.length + i10] - jArr[i10]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.y
    public /* bridge */ /* synthetic */ y tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.y
    public ImmutableSortedMultiset<E> headMultiset(E e10, BoundType boundType) {
        return getSubMultiset(0, this.elementSet.headIndex(e10, b5.u.E(boundType) == BoundType.CLOSED));
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.y
    public ImmutableSortedMultiset<E> tailMultiset(E e10, BoundType boundType) {
        return getSubMultiset(this.elementSet.tailIndex(e10, b5.u.E(boundType) == BoundType.CLOSED), this.length);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.s
    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    public RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> regularImmutableSortedSet, long[] jArr, int i10, int i11) {
        this.elementSet = regularImmutableSortedSet;
        this.cumulativeCounts = jArr;
        this.offset = i10;
        this.length = i11;
    }
}
