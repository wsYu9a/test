package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.s;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.d1;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
/* loaded from: classes2.dex */
public abstract class k<E> extends e5.y<E> implements s<E> {

    @a5.a
    public class a extends Multisets.h<E> {
        public a() {
        }

        @Override // com.google.common.collect.Multisets.h
        public s<E> a() {
            return k.this;
        }

        @Override // com.google.common.collect.Multisets.h, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Multisets.h(a().entrySet().iterator());
        }
    }

    @CanIgnoreReturnValue
    public int add(@d1 E e10, int i10) {
        return delegate().add(e10, i10);
    }

    @Override // com.google.common.collect.s
    public int count(@CheckForNull Object obj) {
        return delegate().count(obj);
    }

    @Override // e5.y, e5.l0
    public abstract s<E> delegate();

    public Set<E> elementSet() {
        return delegate().elementSet();
    }

    public Set<s.a<E>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Collection, com.google.common.collect.s
    public boolean equals(@CheckForNull Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Collection, com.google.common.collect.s
    public int hashCode() {
        return delegate().hashCode();
    }

    @CanIgnoreReturnValue
    public int remove(@CheckForNull Object obj, int i10) {
        return delegate().remove(obj, i10);
    }

    @CanIgnoreReturnValue
    public int setCount(@d1 E e10, int i10) {
        return delegate().setCount(e10, i10);
    }

    public boolean standardAdd(@d1 E e10) {
        add(e10, 1);
        return true;
    }

    @Override // e5.y
    @a5.a
    public boolean standardAddAll(Collection<? extends E> collection) {
        return Multisets.c(this, collection);
    }

    @Override // e5.y
    public void standardClear() {
        Iterators.h(entrySet().iterator());
    }

    @Override // e5.y
    public boolean standardContains(@CheckForNull Object obj) {
        return count(obj) > 0;
    }

    @a5.a
    public int standardCount(@CheckForNull Object obj) {
        for (s.a<E> aVar : entrySet()) {
            if (b5.r.a(aVar.getElement(), obj)) {
                return aVar.getCount();
            }
        }
        return 0;
    }

    public boolean standardEquals(@CheckForNull Object obj) {
        return Multisets.i(this, obj);
    }

    public int standardHashCode() {
        return entrySet().hashCode();
    }

    public Iterator<E> standardIterator() {
        return Multisets.n(this);
    }

    @Override // e5.y
    public boolean standardRemove(@CheckForNull Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // e5.y
    public boolean standardRemoveAll(Collection<?> collection) {
        return Multisets.p(this, collection);
    }

    @Override // e5.y
    public boolean standardRetainAll(Collection<?> collection) {
        return Multisets.s(this, collection);
    }

    public int standardSetCount(@d1 E e10, int i10) {
        return Multisets.v(this, e10, i10);
    }

    public int standardSize() {
        return Multisets.o(this);
    }

    @Override // e5.y
    public String standardToString() {
        return entrySet().toString();
    }

    @CanIgnoreReturnValue
    public boolean setCount(@d1 E e10, int i10, int i11) {
        return delegate().setCount(e10, i10, i11);
    }

    public boolean standardSetCount(@d1 E e10, int i10, int i11) {
        return Multisets.w(this, e10, i10, i11);
    }
}
