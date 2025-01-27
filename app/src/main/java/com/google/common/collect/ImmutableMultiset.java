package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.s;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.concurrent.LazyInit;
import e5.c1;
import e5.z1;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b(emulated = true, serializable = true)
@e5.m
/* loaded from: classes2.dex */
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements s<E> {

    @CheckForNull
    @LazyInit
    private transient ImmutableList<E> asList;

    @CheckForNull
    @LazyInit
    private transient ImmutableSet<s.a<E>> entrySet;

    public final class EntrySet extends IndexedImmutableSet<s.a<E>> {
        private static final long serialVersionUID = 0;

        private EntrySet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof s.a)) {
                return false;
            }
            s.a aVar = (s.a) obj;
            return aVar.getCount() > 0 && ImmutableMultiset.this.count(aVar.getElement()) == aVar.getCount();
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ImmutableMultiset.this.elementSet().size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        @a5.c
        public Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }

        public /* synthetic */ EntrySet(ImmutableMultiset immutableMultiset, a aVar) {
            this();
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public s.a<E> get(int i10) {
            return ImmutableMultiset.this.getEntry(i10);
        }
    }

    @a5.c
    public static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        public EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }

        public Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    public class a extends z1<E> {

        /* renamed from: b */
        public int f9473b;

        /* renamed from: c */
        @CheckForNull
        public E f9474c;

        /* renamed from: d */
        public final /* synthetic */ Iterator f9475d;

        public a(ImmutableMultiset immutableMultiset, Iterator it) {
            this.f9475d = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9473b > 0 || this.f9475d.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.f9473b <= 0) {
                s.a aVar = (s.a) this.f9475d.next();
                this.f9474c = (E) aVar.getElement();
                this.f9473b = aVar.getCount();
            }
            this.f9473b--;
            E e10 = this.f9474c;
            Objects.requireNonNull(e10);
            return e10;
        }
    }

    public static class b<E> extends ImmutableCollection.b<E> {

        /* renamed from: b */
        @CheckForNull
        public t<E> f9476b;

        /* renamed from: c */
        public boolean f9477c;

        /* renamed from: d */
        public boolean f9478d;

        public b() {
            this(4);
        }

        @CheckForNull
        public static <T> t<T> n(Iterable<T> iterable) {
            if (iterable instanceof RegularImmutableMultiset) {
                return ((RegularImmutableMultiset) iterable).contents;
            }
            if (iterable instanceof AbstractMapBasedMultiset) {
                return ((AbstractMapBasedMultiset) iterable).backingMap;
            }
            return null;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        @CanIgnoreReturnValue
        public b<E> g(E e10) {
            return k(e10, 1);
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        @CanIgnoreReturnValue
        /* renamed from: h */
        public b<E> b(E... eArr) {
            super.b(eArr);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.b
        @CanIgnoreReturnValue
        /* renamed from: i */
        public b<E> c(Iterable<? extends E> iterable) {
            Objects.requireNonNull(this.f9476b);
            if (iterable instanceof s) {
                s d10 = Multisets.d(iterable);
                t n10 = n(d10);
                if (n10 != null) {
                    t<E> tVar = this.f9476b;
                    tVar.e(Math.max(tVar.D(), n10.D()));
                    for (int f10 = n10.f(); f10 >= 0; f10 = n10.t(f10)) {
                        k(n10.j(f10), n10.l(f10));
                    }
                } else {
                    Set<s.a<E>> entrySet = d10.entrySet();
                    t<E> tVar2 = this.f9476b;
                    tVar2.e(Math.max(tVar2.D(), entrySet.size()));
                    for (s.a<E> aVar : d10.entrySet()) {
                        k(aVar.getElement(), aVar.getCount());
                    }
                }
            } else {
                super.c(iterable);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        @CanIgnoreReturnValue
        /* renamed from: j */
        public b<E> d(Iterator<? extends E> it) {
            super.d(it);
            return this;
        }

        @CanIgnoreReturnValue
        public b<E> k(E e10, int i10) {
            Objects.requireNonNull(this.f9476b);
            if (i10 == 0) {
                return this;
            }
            if (this.f9477c) {
                this.f9476b = new t<>(this.f9476b);
                this.f9478d = false;
            }
            this.f9477c = false;
            b5.u.E(e10);
            t<E> tVar = this.f9476b;
            tVar.v(e10, i10 + tVar.g(e10));
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        /* renamed from: l */
        public ImmutableMultiset<E> e() {
            Objects.requireNonNull(this.f9476b);
            if (this.f9476b.D() == 0) {
                return ImmutableMultiset.of();
            }
            if (this.f9478d) {
                this.f9476b = new t<>(this.f9476b);
                this.f9478d = false;
            }
            this.f9477c = true;
            return new RegularImmutableMultiset(this.f9476b);
        }

        @CanIgnoreReturnValue
        public b<E> m(E e10, int i10) {
            Objects.requireNonNull(this.f9476b);
            if (i10 == 0 && !this.f9478d) {
                this.f9476b = new c1(this.f9476b);
                this.f9478d = true;
            } else if (this.f9477c) {
                this.f9476b = new t<>(this.f9476b);
                this.f9478d = false;
            }
            this.f9477c = false;
            b5.u.E(e10);
            if (i10 == 0) {
                this.f9476b.w(e10);
            } else {
                this.f9476b.v(b5.u.E(e10), i10);
            }
            return this;
        }

        public b(int i10) {
            this.f9477c = false;
            this.f9478d = false;
            this.f9476b = t.d(i10);
        }

        public b(boolean z10) {
            this.f9477c = false;
            this.f9478d = false;
            this.f9476b = null;
        }
    }

    public static <E> b<E> builder() {
        return new b<>();
    }

    private static <E> ImmutableMultiset<E> copyFromElements(E... eArr) {
        return new b().b(eArr).e();
    }

    public static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends s.a<? extends E>> collection) {
        b bVar = new b(collection.size());
        for (s.a<? extends E> aVar : collection) {
            bVar.k(aVar.getElement(), aVar.getCount());
        }
        return bVar.e();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return copyFromElements(eArr);
    }

    private ImmutableSet<s.a<E>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new EntrySet(this, null);
    }

    public static <E> ImmutableMultiset<E> of() {
        return RegularImmutableMultiset.EMPTY;
    }

    @Override // com.google.common.collect.s
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final int add(E e10, int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> asList = super.asList();
        this.asList = asList;
        return asList;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        return count(obj) > 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    @a5.c
    public int copyIntoArray(Object[] objArr, int i10) {
        z1<s.a<E>> it = entrySet().iterator();
        while (it.hasNext()) {
            s.a<E> next = it.next();
            Arrays.fill(objArr, i10, next.getCount() + i10, next.getElement());
            i10 += next.getCount();
        }
        return i10;
    }

    @Override // com.google.common.collect.s
    public abstract ImmutableSet<E> elementSet();

    @Override // java.util.Collection, com.google.common.collect.s
    public boolean equals(@CheckForNull Object obj) {
        return Multisets.i(this, obj);
    }

    public abstract s.a<E> getEntry(int i10);

    @Override // java.util.Collection, com.google.common.collect.s
    public int hashCode() {
        return Sets.k(entrySet());
    }

    @Override // com.google.common.collect.s
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final int remove(@CheckForNull Object obj, int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.s
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final int setCount(E e10, int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.s
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ImmutableCollection
    @a5.c
    public abstract Object writeReplace();

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.isPartialView()) {
                return immutableMultiset;
            }
        }
        b bVar = new b(Multisets.l(iterable));
        bVar.c(iterable);
        return bVar.e();
    }

    public static <E> ImmutableMultiset<E> of(E e10) {
        return copyFromElements(e10);
    }

    @Override // com.google.common.collect.s
    public ImmutableSet<s.a<E>> entrySet() {
        ImmutableSet<s.a<E>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<s.a<E>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, e5.m1
    public z1<E> iterator() {
        return new a(this, entrySet().iterator());
    }

    @Override // com.google.common.collect.s
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean setCount(E e10, int i10, int i11) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableMultiset<E> of(E e10, E e11) {
        return copyFromElements(e10, e11);
    }

    public static <E> ImmutableMultiset<E> of(E e10, E e11, E e12) {
        return copyFromElements(e10, e11, e12);
    }

    public static <E> ImmutableMultiset<E> of(E e10, E e11, E e12, E e13) {
        return copyFromElements(e10, e11, e12, e13);
    }

    public static <E> ImmutableMultiset<E> of(E e10, E e11, E e12, E e13, E e14) {
        return copyFromElements(e10, e11, e12, e13, e14);
    }

    public static <E> ImmutableMultiset<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E... eArr) {
        return new b().g(e10).g(e11).g(e12).g(e13).g(e14).g(e15).b(eArr).e();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        return new b().d(it).e();
    }
}
