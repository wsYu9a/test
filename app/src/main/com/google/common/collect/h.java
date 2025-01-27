package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.s;
import com.google.common.collect.z;
import e5.d1;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@e5.m
/* loaded from: classes2.dex */
public abstract class h<E> extends k<E> implements y<E> {

    /* renamed from: b */
    @CheckForNull
    public transient Comparator<? super E> f9932b;

    /* renamed from: c */
    @CheckForNull
    public transient NavigableSet<E> f9933c;

    /* renamed from: d */
    @CheckForNull
    public transient Set<s.a<E>> f9934d;

    public class a extends Multisets.i<E> {
        public a() {
        }

        @Override // com.google.common.collect.Multisets.i
        public s<E> a() {
            return h.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<s.a<E>> iterator() {
            return h.this.f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.g().entrySet().size();
        }
    }

    @Override // com.google.common.collect.y, e5.m1
    public Comparator<? super E> comparator() {
        Comparator<? super E> comparator = this.f9932b;
        if (comparator != null) {
            return comparator;
        }
        Ordering reverse = Ordering.from(g().comparator()).reverse();
        this.f9932b = reverse;
        return reverse;
    }

    @Override // com.google.common.collect.y
    public y<E> descendingMultiset() {
        return g();
    }

    public Set<s.a<E>> e() {
        return new a();
    }

    @Override // com.google.common.collect.k, com.google.common.collect.s
    public Set<s.a<E>> entrySet() {
        Set<s.a<E>> set = this.f9934d;
        if (set != null) {
            return set;
        }
        Set<s.a<E>> e10 = e();
        this.f9934d = e10;
        return e10;
    }

    public abstract Iterator<s.a<E>> f();

    @Override // com.google.common.collect.y
    @CheckForNull
    public s.a<E> firstEntry() {
        return g().lastEntry();
    }

    public abstract y<E> g();

    @Override // com.google.common.collect.y
    public y<E> headMultiset(@d1 E e10, BoundType boundType) {
        return g().tailMultiset(e10, boundType).descendingMultiset();
    }

    @Override // e5.y, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return Multisets.n(this);
    }

    @Override // com.google.common.collect.y
    @CheckForNull
    public s.a<E> lastEntry() {
        return g().firstEntry();
    }

    @Override // com.google.common.collect.y
    @CheckForNull
    public s.a<E> pollFirstEntry() {
        return g().pollLastEntry();
    }

    @Override // com.google.common.collect.y
    @CheckForNull
    public s.a<E> pollLastEntry() {
        return g().pollFirstEntry();
    }

    @Override // com.google.common.collect.y
    public y<E> subMultiset(@d1 E e10, BoundType boundType, @d1 E e11, BoundType boundType2) {
        return g().subMultiset(e11, boundType2, e10, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.y
    public y<E> tailMultiset(@d1 E e10, BoundType boundType) {
        return g().headMultiset(e10, boundType).descendingMultiset();
    }

    @Override // e5.y, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return standardToArray();
    }

    @Override // e5.l0
    public String toString() {
        return entrySet().toString();
    }

    @Override // e5.y, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) standardToArray(tArr);
    }

    @Override // com.google.common.collect.k, e5.y, e5.l0
    public s<E> delegate() {
        return g();
    }

    @Override // com.google.common.collect.k, com.google.common.collect.s
    public NavigableSet<E> elementSet() {
        NavigableSet<E> navigableSet = this.f9933c;
        if (navigableSet != null) {
            return navigableSet;
        }
        z.b bVar = new z.b(this);
        this.f9933c = bVar;
        return bVar;
    }
}
