package com.google.common.collect;

import com.google.common.collect.s;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.d1;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@e5.m
/* loaded from: classes2.dex */
abstract class AbstractMapBasedMultiset<E> extends com.google.common.collect.b<E> implements Serializable {

    @a5.c
    private static final long serialVersionUID = 0;
    transient t<E> backingMap;
    transient long size;

    public class a extends AbstractMapBasedMultiset<E>.c<E> {
        public a() {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultiset.c
        @d1
        public E b(int i10) {
            return AbstractMapBasedMultiset.this.backingMap.j(i10);
        }
    }

    public class b extends AbstractMapBasedMultiset<E>.c<s.a<E>> {
        public b() {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultiset.c
        /* renamed from: c */
        public s.a<E> b(int i10) {
            return AbstractMapBasedMultiset.this.backingMap.h(i10);
        }
    }

    public abstract class c<T> implements Iterator<T> {

        /* renamed from: b */
        public int f9369b;

        /* renamed from: c */
        public int f9370c = -1;

        /* renamed from: d */
        public int f9371d;

        public c() {
            this.f9369b = AbstractMapBasedMultiset.this.backingMap.f();
            this.f9371d = AbstractMapBasedMultiset.this.backingMap.f9968d;
        }

        public final void a() {
            if (AbstractMapBasedMultiset.this.backingMap.f9968d != this.f9371d) {
                throw new ConcurrentModificationException();
            }
        }

        @d1
        public abstract T b(int i10);

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f9369b >= 0;
        }

        @Override // java.util.Iterator
        @d1
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T b10 = b(this.f9369b);
            int i10 = this.f9369b;
            this.f9370c = i10;
            this.f9369b = AbstractMapBasedMultiset.this.backingMap.t(i10);
            return b10;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            e5.i.e(this.f9370c != -1);
            AbstractMapBasedMultiset.this.size -= r0.backingMap.y(this.f9370c);
            this.f9369b = AbstractMapBasedMultiset.this.backingMap.u(this.f9369b, this.f9370c);
            this.f9370c = -1;
            this.f9371d = AbstractMapBasedMultiset.this.backingMap.f9968d;
        }
    }

    public AbstractMapBasedMultiset(int i10) {
        this.backingMap = newBackingMap(i10);
    }

    @a5.c
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int h10 = w.h(objectInputStream);
        this.backingMap = newBackingMap(3);
        w.g(this, objectInputStream, h10);
    }

    @a5.c
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        w.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    @CanIgnoreReturnValue
    public final int add(@d1 E e10, int i10) {
        if (i10 == 0) {
            return count(e10);
        }
        b5.u.k(i10 > 0, "occurrences cannot be negative: %s", i10);
        int n10 = this.backingMap.n(e10);
        if (n10 == -1) {
            this.backingMap.v(e10, i10);
            this.size += i10;
            return 0;
        }
        int l10 = this.backingMap.l(n10);
        long j10 = i10;
        long j11 = l10 + j10;
        b5.u.p(j11 <= 2147483647L, "too many occurrences: %s", j11);
        this.backingMap.C(n10, (int) j11);
        this.size += j10;
        return l10;
    }

    public void addTo(s<? super E> sVar) {
        b5.u.E(sVar);
        int f10 = this.backingMap.f();
        while (f10 >= 0) {
            sVar.add(this.backingMap.j(f10), this.backingMap.l(f10));
            f10 = this.backingMap.t(f10);
        }
    }

    @Override // com.google.common.collect.b, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backingMap.a();
        this.size = 0L;
    }

    @Override // com.google.common.collect.s
    public final int count(@CheckForNull Object obj) {
        return this.backingMap.g(obj);
    }

    @Override // com.google.common.collect.b
    public final int distinctElements() {
        return this.backingMap.D();
    }

    @Override // com.google.common.collect.b
    public final Iterator<E> elementIterator() {
        return new a();
    }

    @Override // com.google.common.collect.b
    public final Iterator<s.a<E>> entryIterator() {
        return new b();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.s
    public final Iterator<E> iterator() {
        return Multisets.n(this);
    }

    public abstract t<E> newBackingMap(int i10);

    @Override // com.google.common.collect.b, com.google.common.collect.s
    @CanIgnoreReturnValue
    public final int remove(@CheckForNull Object obj, int i10) {
        if (i10 == 0) {
            return count(obj);
        }
        b5.u.k(i10 > 0, "occurrences cannot be negative: %s", i10);
        int n10 = this.backingMap.n(obj);
        if (n10 == -1) {
            return 0;
        }
        int l10 = this.backingMap.l(n10);
        if (l10 > i10) {
            this.backingMap.C(n10, l10 - i10);
        } else {
            this.backingMap.y(n10);
            i10 = l10;
        }
        this.size -= i10;
        return l10;
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    @CanIgnoreReturnValue
    public final int setCount(@d1 E e10, int i10) {
        e5.i.b(i10, c7.g.f1744b);
        t<E> tVar = this.backingMap;
        int w10 = i10 == 0 ? tVar.w(e10) : tVar.v(e10, i10);
        this.size += i10 - w10;
        return w10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.s
    public final int size() {
        return Ints.x(this.size);
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    public final boolean setCount(@d1 E e10, int i10, int i11) {
        e5.i.b(i10, "oldCount");
        e5.i.b(i11, "newCount");
        int n10 = this.backingMap.n(e10);
        if (n10 == -1) {
            if (i10 != 0) {
                return false;
            }
            if (i11 > 0) {
                this.backingMap.v(e10, i11);
                this.size += i11;
            }
            return true;
        }
        if (this.backingMap.l(n10) != i10) {
            return false;
        }
        if (i11 == 0) {
            this.backingMap.y(n10);
            this.size -= i10;
        } else {
            this.backingMap.C(n10, i11);
            this.size += i11 - i10;
        }
        return true;
    }
}
