package com.google.common.collect;

import com.google.common.collect.s;
import com.google.common.collect.z;
import e5.d1;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@a5.a
@e5.m
/* loaded from: classes2.dex */
public abstract class o<E> extends k<E> implements y<E> {

    public abstract class a extends h<E> {
        public a() {
        }

        @Override // com.google.common.collect.h
        public y<E> g() {
            return o.this;
        }
    }

    public class b extends z.b<E> {
        public b(o oVar) {
            super(oVar);
        }
    }

    @Override // com.google.common.collect.y, e5.m1
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.k, e5.y, e5.l0
    public abstract y<E> delegate();

    @Override // com.google.common.collect.y
    public y<E> descendingMultiset() {
        return delegate().descendingMultiset();
    }

    @CheckForNull
    public s.a<E> e() {
        Iterator<s.a<E>> it = entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        s.a<E> next = it.next();
        return Multisets.k(next.getElement(), next.getCount());
    }

    @CheckForNull
    public s.a<E> f() {
        Iterator<s.a<E>> it = descendingMultiset().entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        s.a<E> next = it.next();
        return Multisets.k(next.getElement(), next.getCount());
    }

    @Override // com.google.common.collect.y
    @CheckForNull
    public s.a<E> firstEntry() {
        return delegate().firstEntry();
    }

    @CheckForNull
    public s.a<E> g() {
        Iterator<s.a<E>> it = entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        s.a<E> next = it.next();
        s.a<E> k10 = Multisets.k(next.getElement(), next.getCount());
        it.remove();
        return k10;
    }

    @CheckForNull
    public s.a<E> h() {
        Iterator<s.a<E>> it = descendingMultiset().entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        s.a<E> next = it.next();
        s.a<E> k10 = Multisets.k(next.getElement(), next.getCount());
        it.remove();
        return k10;
    }

    @Override // com.google.common.collect.y
    public y<E> headMultiset(@d1 E e10, BoundType boundType) {
        return delegate().headMultiset(e10, boundType);
    }

    public y<E> i(@d1 E e10, BoundType boundType, @d1 E e11, BoundType boundType2) {
        return tailMultiset(e10, boundType).headMultiset(e11, boundType2);
    }

    @Override // com.google.common.collect.y
    @CheckForNull
    public s.a<E> lastEntry() {
        return delegate().lastEntry();
    }

    @Override // com.google.common.collect.y
    @CheckForNull
    public s.a<E> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    @Override // com.google.common.collect.y
    @CheckForNull
    public s.a<E> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    @Override // com.google.common.collect.y
    public y<E> subMultiset(@d1 E e10, BoundType boundType, @d1 E e11, BoundType boundType2) {
        return delegate().subMultiset(e10, boundType, e11, boundType2);
    }

    @Override // com.google.common.collect.y
    public y<E> tailMultiset(@d1 E e10, BoundType boundType) {
        return delegate().tailMultiset(e10, boundType);
    }

    @Override // com.google.common.collect.k, com.google.common.collect.s
    public NavigableSet<E> elementSet() {
        return delegate().elementSet();
    }
}
