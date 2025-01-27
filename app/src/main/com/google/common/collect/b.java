package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.s;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import e5.d1;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
/* loaded from: classes2.dex */
public abstract class b<E> extends AbstractCollection<E> implements s<E> {

    @CheckForNull
    @LazyInit
    private transient Set<E> elementSet;

    @CheckForNull
    @LazyInit
    private transient Set<s.a<E>> entrySet;

    public class a extends Multisets.h<E> {
        public a() {
        }

        @Override // com.google.common.collect.Multisets.h
        public s<E> a() {
            return b.this;
        }

        @Override // com.google.common.collect.Multisets.h, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return b.this.elementIterator();
        }
    }

    /* renamed from: com.google.common.collect.b$b */
    public class C0286b extends Multisets.i<E> {
        public C0286b() {
        }

        @Override // com.google.common.collect.Multisets.i
        public s<E> a() {
            return b.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<s.a<E>> iterator() {
            return b.this.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b.this.distinctElements();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.s
    @CanIgnoreReturnValue
    public final boolean add(@d1 E e10) {
        add(e10, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean addAll(Collection<? extends E> collection) {
        return Multisets.c(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract void clear();

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.s
    public boolean contains(@CheckForNull Object obj) {
        return count(obj) > 0;
    }

    public Set<E> createElementSet() {
        return new a();
    }

    public Set<s.a<E>> createEntrySet() {
        return new C0286b();
    }

    public abstract int distinctElements();

    public abstract Iterator<E> elementIterator();

    public Set<E> elementSet() {
        Set<E> set = this.elementSet;
        if (set != null) {
            return set;
        }
        Set<E> createElementSet = createElementSet();
        this.elementSet = createElementSet;
        return createElementSet;
    }

    public abstract Iterator<s.a<E>> entryIterator();

    public Set<s.a<E>> entrySet() {
        Set<s.a<E>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        Set<s.a<E>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.Collection, com.google.common.collect.s
    public final boolean equals(@CheckForNull Object obj) {
        return Multisets.i(this, obj);
    }

    @Override // java.util.Collection, com.google.common.collect.s
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.s
    @CanIgnoreReturnValue
    public final boolean remove(@CheckForNull Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.s
    @CanIgnoreReturnValue
    public final boolean removeAll(Collection<?> collection) {
        return Multisets.p(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.s
    @CanIgnoreReturnValue
    public final boolean retainAll(Collection<?> collection) {
        return Multisets.s(this, collection);
    }

    @CanIgnoreReturnValue
    public int setCount(@d1 E e10, int i10) {
        return Multisets.v(this, e10, i10);
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.s
    public final String toString() {
        return entrySet().toString();
    }

    @CanIgnoreReturnValue
    public int add(@d1 E e10, int i10) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    public int remove(@CheckForNull Object obj, int i10) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    public boolean setCount(@d1 E e10, int i10, int i11) {
        return Multisets.w(this, e10, i10, i11);
    }
}
