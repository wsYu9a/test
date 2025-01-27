package e5;

import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.CheckForNull;

@a5.b
@m
/* loaded from: classes2.dex */
public abstract class g0<E> extends y<E> implements List<E> {
    @Override // java.util.List
    public void add(int i10, @d1 E e10) {
        delegate().add(i10, e10);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    public boolean addAll(int i10, Collection<? extends E> collection) {
        return delegate().addAll(i10, collection);
    }

    @Override // e5.y, e5.l0
    /* renamed from: e */
    public abstract List<E> delegate();

    @Override // java.util.Collection, java.util.List
    public boolean equals(@CheckForNull Object obj) {
        return obj == this || delegate().equals(obj);
    }

    public boolean f(int i10, Iterable<? extends E> iterable) {
        return Lists.a(this, i10, iterable);
    }

    public int g(@CheckForNull Object obj) {
        return Lists.l(this, obj);
    }

    @Override // java.util.List
    @d1
    public E get(int i10) {
        return delegate().get(i10);
    }

    public int h(@CheckForNull Object obj) {
        return Lists.n(this, obj);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return delegate().hashCode();
    }

    public ListIterator<E> i() {
        return listIterator(0);
    }

    @Override // java.util.List
    public int indexOf(@CheckForNull Object obj) {
        return delegate().indexOf(obj);
    }

    @a5.a
    public ListIterator<E> j(int i10) {
        return Lists.p(this, i10);
    }

    @a5.a
    public List<E> k(int i10, int i11) {
        return Lists.C(this, i10, i11);
    }

    @Override // java.util.List
    public int lastIndexOf(@CheckForNull Object obj) {
        return delegate().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return delegate().listIterator();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @d1
    public E remove(int i10) {
        return delegate().remove(i10);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @d1
    public E set(int i10, @d1 E e10) {
        return delegate().set(i10, e10);
    }

    public boolean standardAdd(@d1 E e10) {
        add(size(), e10);
        return true;
    }

    @a5.a
    public boolean standardEquals(@CheckForNull Object obj) {
        return Lists.j(this, obj);
    }

    @a5.a
    public int standardHashCode() {
        return Lists.k(this);
    }

    public Iterator<E> standardIterator() {
        return listIterator();
    }

    @Override // java.util.List
    public List<E> subList(int i10, int i11) {
        return delegate().subList(i10, i11);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i10) {
        return delegate().listIterator(i10);
    }
}
