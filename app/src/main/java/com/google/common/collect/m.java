package com.google.common.collect;

import com.google.common.collect.Sets;
import e5.d1;
import e5.p0;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@e5.m
@a5.c
/* loaded from: classes2.dex */
public abstract class m<E> extends p0<E> implements NavigableSet<E> {

    @a5.a
    public class a extends Sets.f<E> {
        public a(m mVar) {
            super(mVar);
        }
    }

    @CheckForNull
    public E ceiling(@d1 E e10) {
        return delegate().ceiling(e10);
    }

    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    public NavigableSet<E> descendingSet() {
        return delegate().descendingSet();
    }

    @Override // e5.p0, e5.n0, e5.y, e5.l0
    /* renamed from: e */
    public abstract NavigableSet<E> delegate();

    @CheckForNull
    public E f(@d1 E e10) {
        return (E) Iterators.J(tailSet(e10, true).iterator(), null);
    }

    @CheckForNull
    public E floor(@d1 E e10) {
        return delegate().floor(e10);
    }

    @d1
    public E g() {
        return iterator().next();
    }

    @CheckForNull
    public E h(@d1 E e10) {
        return (E) Iterators.J(headSet(e10, true).descendingIterator(), null);
    }

    public NavigableSet<E> headSet(@d1 E e10, boolean z10) {
        return delegate().headSet(e10, z10);
    }

    @CheckForNull
    public E higher(@d1 E e10) {
        return delegate().higher(e10);
    }

    public SortedSet<E> i(@d1 E e10) {
        return headSet(e10, false);
    }

    @CheckForNull
    public E j(@d1 E e10) {
        return (E) Iterators.J(tailSet(e10, false).iterator(), null);
    }

    @d1
    public E k() {
        return descendingIterator().next();
    }

    @CheckForNull
    public E l(@d1 E e10) {
        return (E) Iterators.J(headSet(e10, false).descendingIterator(), null);
    }

    @CheckForNull
    public E lower(@d1 E e10) {
        return delegate().lower(e10);
    }

    @CheckForNull
    public E m() {
        return (E) Iterators.U(iterator());
    }

    @CheckForNull
    public E n() {
        return (E) Iterators.U(descendingIterator());
    }

    @a5.a
    public NavigableSet<E> o(@d1 E e10, boolean z10, @d1 E e11, boolean z11) {
        return tailSet(e10, z10).headSet(e11, z11);
    }

    public SortedSet<E> p(@d1 E e10) {
        return tailSet(e10, true);
    }

    @CheckForNull
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @CheckForNull
    public E pollLast() {
        return delegate().pollLast();
    }

    @Override // e5.p0
    public SortedSet<E> standardSubSet(@d1 E e10, @d1 E e11) {
        return subSet(e10, true, e11, false);
    }

    public NavigableSet<E> subSet(@d1 E e10, boolean z10, @d1 E e11, boolean z11) {
        return delegate().subSet(e10, z10, e11, z11);
    }

    public NavigableSet<E> tailSet(@d1 E e10, boolean z10) {
        return delegate().tailSet(e10, z10);
    }
}
