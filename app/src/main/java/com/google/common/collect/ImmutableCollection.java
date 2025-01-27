package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.DoNotMock;
import e5.b1;
import e5.z1;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@e5.m
@DoNotMock("Use ImmutableList.of or another implementation")
/* loaded from: classes2.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] EMPTY_ARRAY = new Object[0];

    public static abstract class a<E> extends b<E> {

        /* renamed from: b */
        public Object[] f9443b;

        /* renamed from: c */
        public int f9444c;

        /* renamed from: d */
        public boolean f9445d;

        public a(int i10) {
            e5.i.b(i10, "initialCapacity");
            this.f9443b = new Object[i10];
            this.f9444c = 0;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        @CanIgnoreReturnValue
        public b<E> b(E... eArr) {
            h(eArr, eArr.length);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        @CanIgnoreReturnValue
        public b<E> c(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                i(this.f9444c + collection.size());
                if (collection instanceof ImmutableCollection) {
                    this.f9444c = ((ImmutableCollection) collection).copyIntoArray(this.f9443b, this.f9444c);
                    return this;
                }
            }
            super.c(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        @CanIgnoreReturnValue
        public a<E> g(E e10) {
            b5.u.E(e10);
            i(this.f9444c + 1);
            Object[] objArr = this.f9443b;
            int i10 = this.f9444c;
            this.f9444c = i10 + 1;
            objArr[i10] = e10;
            return this;
        }

        public final void h(Object[] objArr, int i10) {
            b1.c(objArr, i10);
            i(this.f9444c + i10);
            System.arraycopy(objArr, 0, this.f9443b, this.f9444c, i10);
            this.f9444c += i10;
        }

        public final void i(int i10) {
            Object[] objArr = this.f9443b;
            if (objArr.length < i10) {
                this.f9443b = Arrays.copyOf(objArr, b.f(objArr.length, i10));
                this.f9445d = false;
            } else if (this.f9445d) {
                this.f9443b = (Object[]) objArr.clone();
                this.f9445d = false;
            }
        }
    }

    @DoNotMock
    public static abstract class b<E> {

        /* renamed from: a */
        public static final int f9446a = 4;

        public static int f(int i10, int i11) {
            if (i11 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i12 = i10 + (i10 >> 1) + 1;
            if (i12 < i11) {
                i12 = Integer.highestOneBit(i11 - 1) << 1;
            }
            if (i12 < 0) {
                return Integer.MAX_VALUE;
            }
            return i12;
        }

        @CanIgnoreReturnValue
        /* renamed from: a */
        public abstract b<E> g(E e10);

        @CanIgnoreReturnValue
        public b<E> b(E... eArr) {
            for (E e10 : eArr) {
                g(e10);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public b<E> c(Iterable<? extends E> iterable) {
            Iterator<? extends E> it = iterable.iterator();
            while (it.hasNext()) {
                g(it.next());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public b<E> d(Iterator<? extends E> it) {
            while (it.hasNext()) {
                g(it.next());
            }
            return this;
        }

        public abstract ImmutableCollection<E> e();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean add(E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        return isEmpty() ? ImmutableList.of() : ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(@CheckForNull Object obj);

    @CanIgnoreReturnValue
    public int copyIntoArray(Object[] objArr, int i10) {
        z1<E> it = iterator();
        while (it.hasNext()) {
            objArr[i10] = it.next();
            i10++;
        }
        return i10;
    }

    @CheckForNull
    public Object[] internalArray() {
        return null;
    }

    public int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    public int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, e5.m1
    public abstract z1<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(EMPTY_ARRAY);
    }

    public Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final <T> T[] toArray(T[] tArr) {
        b5.u.E(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] internalArray = internalArray();
            if (internalArray != null) {
                return (T[]) u.b(internalArray, internalArrayStart(), internalArrayEnd(), tArr);
            }
            tArr = (T[]) b1.j(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }
}
