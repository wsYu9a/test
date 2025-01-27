package com.google.common.collect;

import com.google.common.collect.s;
import com.google.common.collect.z;
import e5.d1;
import e5.r0;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@e5.m
/* loaded from: classes2.dex */
public abstract class d<E> extends b<E> implements y<E> {

    @r0
    final Comparator<? super E> comparator;

    @CheckForNull
    private transient y<E> descendingMultiset;

    public class a extends h<E> {
        public a() {
        }

        @Override // com.google.common.collect.h
        public Iterator<s.a<E>> f() {
            return d.this.descendingEntryIterator();
        }

        @Override // com.google.common.collect.h
        public y<E> g() {
            return d.this;
        }

        @Override // com.google.common.collect.h, e5.y, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return d.this.descendingIterator();
        }
    }

    public d() {
        this(Ordering.natural());
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public y<E> createDescendingMultiset() {
        return new a();
    }

    public abstract Iterator<s.a<E>> descendingEntryIterator();

    public Iterator<E> descendingIterator() {
        return Multisets.n(descendingMultiset());
    }

    public y<E> descendingMultiset() {
        y<E> yVar = this.descendingMultiset;
        if (yVar != null) {
            return yVar;
        }
        y<E> createDescendingMultiset = createDescendingMultiset();
        this.descendingMultiset = createDescendingMultiset;
        return createDescendingMultiset;
    }

    @CheckForNull
    public s.a<E> firstEntry() {
        Iterator<s.a<E>> entryIterator = entryIterator();
        if (entryIterator.hasNext()) {
            return entryIterator.next();
        }
        return null;
    }

    @CheckForNull
    public s.a<E> lastEntry() {
        Iterator<s.a<E>> descendingEntryIterator = descendingEntryIterator();
        if (descendingEntryIterator.hasNext()) {
            return descendingEntryIterator.next();
        }
        return null;
    }

    @CheckForNull
    public s.a<E> pollFirstEntry() {
        Iterator<s.a<E>> entryIterator = entryIterator();
        if (!entryIterator.hasNext()) {
            return null;
        }
        s.a<E> next = entryIterator.next();
        s.a<E> k10 = Multisets.k(next.getElement(), next.getCount());
        entryIterator.remove();
        return k10;
    }

    @CheckForNull
    public s.a<E> pollLastEntry() {
        Iterator<s.a<E>> descendingEntryIterator = descendingEntryIterator();
        if (!descendingEntryIterator.hasNext()) {
            return null;
        }
        s.a<E> next = descendingEntryIterator.next();
        s.a<E> k10 = Multisets.k(next.getElement(), next.getCount());
        descendingEntryIterator.remove();
        return k10;
    }

    public y<E> subMultiset(@d1 E e10, BoundType boundType, @d1 E e11, BoundType boundType2) {
        b5.u.E(boundType);
        b5.u.E(boundType2);
        return tailMultiset(e10, boundType).headMultiset(e11, boundType2);
    }

    public d(Comparator<? super E> comparator) {
        this.comparator = (Comparator) b5.u.E(comparator);
    }

    @Override // com.google.common.collect.b
    public NavigableSet<E> createElementSet() {
        return new z.b(this);
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }
}
