package com.google.common.collect;

import com.google.common.collect.s;
import e5.d1;
import e5.m1;
import e5.r1;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@e5.m
/* loaded from: classes2.dex */
public interface y<E> extends r1<E>, m1<E> {
    Comparator<? super E> comparator();

    y<E> descendingMultiset();

    @Override // e5.r1, com.google.common.collect.s
    NavigableSet<E> elementSet();

    @Override // e5.r1, com.google.common.collect.s
    /* bridge */ /* synthetic */ Set elementSet();

    @Override // e5.r1, com.google.common.collect.s
    /* bridge */ /* synthetic */ SortedSet elementSet();

    @Override // com.google.common.collect.s
    Set<s.a<E>> entrySet();

    @CheckForNull
    s.a<E> firstEntry();

    y<E> headMultiset(@d1 E e10, BoundType boundType);

    @Override // com.google.common.collect.s, java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    @CheckForNull
    s.a<E> lastEntry();

    @CheckForNull
    s.a<E> pollFirstEntry();

    @CheckForNull
    s.a<E> pollLastEntry();

    y<E> subMultiset(@d1 E e10, BoundType boundType, @d1 E e11, BoundType boundType2);

    y<E> tailMultiset(@d1 E e10, BoundType boundType);
}
