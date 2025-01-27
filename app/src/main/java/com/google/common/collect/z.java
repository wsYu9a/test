package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.s;
import com.google.j2objc.annotations.Weak;
import e5.d1;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@e5.m
/* loaded from: classes2.dex */
public final class z {

    public static class a<E> extends Multisets.h<E> implements SortedSet<E> {

        /* renamed from: b */
        @Weak
        public final y<E> f9979b;

        public a(y<E> yVar) {
            this.f9979b = yVar;
        }

        @Override // com.google.common.collect.Multisets.h
        /* renamed from: b */
        public final y<E> a() {
            return this.f9979b;
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return a().comparator();
        }

        @Override // java.util.SortedSet
        @d1
        public E first() {
            return (E) z.d(a().firstEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(@d1 E e10) {
            return a().headMultiset(e10, BoundType.OPEN).elementSet();
        }

        @Override // com.google.common.collect.Multisets.h, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Multisets.h(a().entrySet().iterator());
        }

        @Override // java.util.SortedSet
        @d1
        public E last() {
            return (E) z.d(a().lastEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(@d1 E e10, @d1 E e11) {
            return a().subMultiset(e10, BoundType.CLOSED, e11, BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(@d1 E e10) {
            return a().tailMultiset(e10, BoundType.CLOSED).elementSet();
        }
    }

    @a5.c
    public static class b<E> extends a<E> implements NavigableSet<E> {
        public b(y<E> yVar) {
            super(yVar);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E ceiling(@d1 E e10) {
            return (E) z.c(a().tailMultiset(e10, BoundType.CLOSED).firstEntry());
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return new b(a().descendingMultiset());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E floor(@d1 E e10) {
            return (E) z.c(a().headMultiset(e10, BoundType.CLOSED).lastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(@d1 E e10, boolean z10) {
            return new b(a().headMultiset(e10, BoundType.forBoolean(z10)));
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E higher(@d1 E e10) {
            return (E) z.c(a().tailMultiset(e10, BoundType.OPEN).firstEntry());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E lower(@d1 E e10) {
            return (E) z.c(a().headMultiset(e10, BoundType.OPEN).lastEntry());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollFirst() {
            return (E) z.c(a().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollLast() {
            return (E) z.c(a().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(@d1 E e10, boolean z10, @d1 E e11, boolean z11) {
            return new b(a().subMultiset(e10, BoundType.forBoolean(z10), e11, BoundType.forBoolean(z11)));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(@d1 E e10, boolean z10) {
            return new b(a().tailMultiset(e10, BoundType.forBoolean(z10)));
        }
    }

    @CheckForNull
    public static <E> E c(@CheckForNull s.a<E> aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.getElement();
    }

    public static <E> E d(@CheckForNull s.a<E> aVar) {
        if (aVar != null) {
            return aVar.getElement();
        }
        throw new NoSuchElementException();
    }
}
