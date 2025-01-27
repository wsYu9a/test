package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import e5.b1;
import e5.s0;
import e5.z1;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@a5.b(emulated = true, serializable = true)
@e5.m
/* loaded from: classes2.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    static final int MAX_TABLE_SIZE = 1073741824;

    @RetainedWith
    @CheckForNull
    @LazyInit
    private transient ImmutableList<E> asList;

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    public static class a<E> extends ImmutableCollection.a<E> {

        /* renamed from: e */
        @CheckForNull
        @a5.d
        public Object[] f9487e;

        /* renamed from: f */
        public int f9488f;

        public a() {
            super(4);
        }

        @Override // com.google.common.collect.ImmutableCollection.a
        @CanIgnoreReturnValue
        /* renamed from: j */
        public a<E> g(E e10) {
            b5.u.E(e10);
            if (this.f9487e != null && ImmutableSet.chooseTableSize(this.f9444c) <= this.f9487e.length) {
                n(e10);
                return this;
            }
            this.f9487e = null;
            super.g(e10);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.a, com.google.common.collect.ImmutableCollection.b
        @CanIgnoreReturnValue
        /* renamed from: k */
        public a<E> b(E... eArr) {
            if (this.f9487e != null) {
                for (E e10 : eArr) {
                    g(e10);
                }
            } else {
                super.b(eArr);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.a, com.google.common.collect.ImmutableCollection.b
        @CanIgnoreReturnValue
        /* renamed from: l */
        public a<E> c(Iterable<? extends E> iterable) {
            b5.u.E(iterable);
            if (this.f9487e != null) {
                Iterator<? extends E> it = iterable.iterator();
                while (it.hasNext()) {
                    g(it.next());
                }
            } else {
                super.c(iterable);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        @CanIgnoreReturnValue
        /* renamed from: m */
        public a<E> d(Iterator<? extends E> it) {
            b5.u.E(it);
            while (it.hasNext()) {
                g(it.next());
            }
            return this;
        }

        public final void n(E e10) {
            Objects.requireNonNull(this.f9487e);
            int length = this.f9487e.length - 1;
            int hashCode = e10.hashCode();
            int c10 = s0.c(hashCode);
            while (true) {
                int i10 = c10 & length;
                Object[] objArr = this.f9487e;
                Object obj = objArr[i10];
                if (obj == null) {
                    objArr[i10] = e10;
                    this.f9488f += hashCode;
                    super.g(e10);
                    return;
                } else if (obj.equals(e10)) {
                    return;
                } else {
                    c10 = i10 + 1;
                }
            }
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        /* renamed from: o */
        public ImmutableSet<E> e() {
            ImmutableSet<E> construct;
            int i10 = this.f9444c;
            if (i10 == 0) {
                return ImmutableSet.of();
            }
            if (i10 == 1) {
                Object obj = this.f9443b[0];
                Objects.requireNonNull(obj);
                return ImmutableSet.of(obj);
            }
            if (this.f9487e == null || ImmutableSet.chooseTableSize(i10) != this.f9487e.length) {
                construct = ImmutableSet.construct(this.f9444c, this.f9443b);
                this.f9444c = construct.size();
            } else {
                Object[] copyOf = ImmutableSet.shouldTrim(this.f9444c, this.f9443b.length) ? Arrays.copyOf(this.f9443b, this.f9444c) : this.f9443b;
                construct = new RegularImmutableSet<>(copyOf, this.f9488f, this.f9487e, r5.length - 1, this.f9444c);
            }
            this.f9445d = true;
            this.f9487e = null;
            return construct;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public a<E> p(a<E> aVar) {
            if (this.f9487e != null) {
                for (int i10 = 0; i10 < aVar.f9444c; i10++) {
                    Object obj = aVar.f9443b[i10];
                    Objects.requireNonNull(obj);
                    g(obj);
                }
            } else {
                h(aVar.f9443b, aVar.f9444c);
            }
            return this;
        }

        public a(int i10) {
            super(i10);
            this.f9487e = new Object[ImmutableSet.chooseTableSize(i10)];
        }
    }

    public static <E> a<E> builder() {
        return new a<>();
    }

    @a5.a
    public static <E> a<E> builderWithExpectedSize(int i10) {
        e5.i.b(i10, "expectedSize");
        return new a<>(i10);
    }

    @a5.d
    public static int chooseTableSize(int i10) {
        int max = Math.max(i10, 2);
        if (max >= CUTOFF) {
            b5.u.e(max < 1073741824, "collection too large");
            return 1073741824;
        }
        int highestOneBit = Integer.highestOneBit(max - 1) << 1;
        while (highestOneBit * DESIRED_LOAD_FACTOR < max) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    public static <E> ImmutableSet<E> construct(int i10, Object... objArr) {
        if (i10 == 0) {
            return of();
        }
        if (i10 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return of(obj);
        }
        int chooseTableSize = chooseTableSize(i10);
        Object[] objArr2 = new Object[chooseTableSize];
        int i11 = chooseTableSize - 1;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            Object a10 = b1.a(objArr[i14], i14);
            int hashCode = a10.hashCode();
            int c10 = s0.c(hashCode);
            while (true) {
                int i15 = c10 & i11;
                Object obj2 = objArr2[i15];
                if (obj2 == null) {
                    objArr[i13] = a10;
                    objArr2[i15] = a10;
                    i12 += hashCode;
                    i13++;
                    break;
                }
                if (obj2.equals(a10)) {
                    break;
                }
                c10++;
            }
        }
        Arrays.fill(objArr, i13, i10, (Object) null);
        if (i13 == 1) {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return new SingletonImmutableSet(obj3);
        }
        if (chooseTableSize(i13) < chooseTableSize / 2) {
            return construct(i13, objArr);
        }
        if (shouldTrim(i13, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i13);
        }
        return new RegularImmutableSet(objArr, i12, objArr2, i11, i13);
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    public static boolean shouldTrim(int i10, int i11) {
        return i10 < (i11 >> 1) + (i11 >> 2);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> createAsList = createAsList();
        this.asList = createAsList;
        return createAsList;
    }

    public ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.g(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.k(this);
    }

    public boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, e5.m1
    public abstract z1<E> iterator();

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableSet<E> of(E e10) {
        return new SingletonImmutableSet(e10);
    }

    public static <E> ImmutableSet<E> of(E e10, E e11) {
        return construct(2, e10, e11);
    }

    public static <E> ImmutableSet<E> of(E e10, E e11, E e12) {
        return construct(3, e10, e11, e12);
    }

    public static <E> ImmutableSet<E> of(E e10, E e11, E e12, E e13) {
        return construct(4, e10, e11, e12, e13);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> of(E e10, E e11, E e12, E e13, E e14) {
        return construct(5, e10, e11, e12, e13, e14);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E... eArr) {
        b5.u.e(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e10;
        objArr[1] = e11;
        objArr[2] = e12;
        objArr[3] = e13;
        objArr[4] = e14;
        objArr[5] = e15;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return construct(length, objArr);
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new a().g(next).d(it).e();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return construct(eArr.length, (Object[]) eArr.clone());
        }
        return of((Object) eArr[0]);
    }
}
