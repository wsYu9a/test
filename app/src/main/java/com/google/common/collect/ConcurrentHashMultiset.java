package com.google.common.collect;

import com.google.common.collect.s;
import com.google.common.collect.w;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.f0;
import e5.n0;
import e5.u0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;

@e5.m
@a5.c
/* loaded from: classes2.dex */
public final class ConcurrentHashMultiset<E> extends com.google.common.collect.b<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient ConcurrentMap<E, AtomicInteger> countMap;

    public class b extends AbstractIterator<s.a<E>> {

        /* renamed from: d */
        public final Iterator<Map.Entry<E, AtomicInteger>> f9409d;

        public b() {
            this.f9409d = ConcurrentHashMultiset.this.countMap.entrySet().iterator();
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        /* renamed from: d */
        public s.a<E> a() {
            while (this.f9409d.hasNext()) {
                Map.Entry<E, AtomicInteger> next = this.f9409d.next();
                int i10 = next.getValue().get();
                if (i10 != 0) {
                    return Multisets.k(next.getKey(), i10);
                }
            }
            return b();
        }
    }

    public class c extends f0<s.a<E>> {

        /* renamed from: b */
        @CheckForNull
        public s.a<E> f9411b;

        /* renamed from: c */
        public final /* synthetic */ Iterator f9412c;

        public c(Iterator it) {
            this.f9412c = it;
        }

        @Override // e5.f0, e5.l0
        /* renamed from: e */
        public Iterator<s.a<E>> delegate() {
            return this.f9412c;
        }

        @Override // e5.f0, java.util.Iterator
        /* renamed from: f */
        public s.a<E> next() {
            s.a<E> aVar = (s.a) super.next();
            this.f9411b = aVar;
            return aVar;
        }

        @Override // e5.f0, java.util.Iterator
        public void remove() {
            b5.u.h0(this.f9411b != null, "no calls to next() since the last call to remove()");
            ConcurrentHashMultiset.this.setCount(this.f9411b.getElement(), 0);
            this.f9411b = null;
        }
    }

    public class d extends com.google.common.collect.b<E>.C0286b {
        public d() {
            super();
        }

        @Override // com.google.common.collect.b.C0286b, com.google.common.collect.Multisets.i
        /* renamed from: b */
        public ConcurrentHashMultiset<E> a() {
            return ConcurrentHashMultiset.this;
        }

        public final List<s.a<E>> c() {
            ArrayList v10 = Lists.v(size());
            Iterators.a(v10, iterator());
            return v10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return c().toArray();
        }

        public /* synthetic */ d(ConcurrentHashMultiset concurrentHashMultiset, a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) c().toArray(tArr);
        }
    }

    public static class e {

        /* renamed from: a */
        public static final w.b<ConcurrentHashMultiset> f9415a = w.a(ConcurrentHashMultiset.class, "countMap");
    }

    @a5.d
    public ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        b5.u.u(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.countMap = concurrentMap;
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset<>(new ConcurrentHashMap());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        e.f9415a.b(this, (ConcurrentMap) objectInputStream.readObject());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<E> snapshot() {
        ArrayList v10 = Lists.v(size());
        for (s.a aVar : entrySet()) {
            Object element = aVar.getElement();
            for (int count = aVar.getCount(); count > 0; count--) {
                v10.add(element);
            }
        }
        return v10;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.countMap);
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    @CanIgnoreReturnValue
    public int add(E e10, int i10) {
        AtomicInteger atomicInteger;
        int i11;
        AtomicInteger atomicInteger2;
        b5.u.E(e10);
        if (i10 == 0) {
            return count(e10);
        }
        e5.i.d(i10, "occurrences");
        do {
            atomicInteger = (AtomicInteger) Maps.p0(this.countMap, e10);
            if (atomicInteger == null && (atomicInteger = this.countMap.putIfAbsent(e10, new AtomicInteger(i10))) == null) {
                return 0;
            }
            do {
                i11 = atomicInteger.get();
                if (i11 == 0) {
                    atomicInteger2 = new AtomicInteger(i10);
                    if (this.countMap.putIfAbsent(e10, atomicInteger2) == null) {
                        break;
                    }
                } else {
                    try {
                    } catch (ArithmeticException unused) {
                        StringBuilder sb2 = new StringBuilder(65);
                        sb2.append("Overflow adding ");
                        sb2.append(i10);
                        sb2.append(" occurrences to a count of ");
                        sb2.append(i11);
                        throw new IllegalArgumentException(sb2.toString());
                    }
                }
            } while (!atomicInteger.compareAndSet(i11, l5.f.c(i11, i10)));
            return i11;
        } while (!this.countMap.replace(e10, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // com.google.common.collect.b, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.countMap.clear();
    }

    @Override // com.google.common.collect.b, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.s
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.s
    public int count(@CheckForNull Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) Maps.p0(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @Override // com.google.common.collect.b
    public Set<E> createElementSet() {
        return new a(this, this.countMap.keySet());
    }

    @Override // com.google.common.collect.b
    @Deprecated
    public Set<s.a<E>> createEntrySet() {
        return new d(this, null);
    }

    @Override // com.google.common.collect.b
    public int distinctElements() {
        return this.countMap.size();
    }

    @Override // com.google.common.collect.b
    public Iterator<E> elementIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.b
    public Iterator<s.a<E>> entryIterator() {
        return new c(new b());
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.b, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.s
    public Iterator<E> iterator() {
        return Multisets.n(this);
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    @CanIgnoreReturnValue
    public int remove(@CheckForNull Object obj, int i10) {
        int i11;
        int max;
        if (i10 == 0) {
            return count(obj);
        }
        e5.i.d(i10, "occurrences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.p0(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i11 = atomicInteger.get();
            if (i11 == 0) {
                return 0;
            }
            max = Math.max(0, i11 - i10);
        } while (!atomicInteger.compareAndSet(i11, max));
        if (max == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return i11;
    }

    @CanIgnoreReturnValue
    public boolean removeExactly(@CheckForNull Object obj, int i10) {
        int i11;
        int i12;
        if (i10 == 0) {
            return true;
        }
        e5.i.d(i10, "occurrences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.p0(this.countMap, obj);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i11 = atomicInteger.get();
            if (i11 < i10) {
                return false;
            }
            i12 = i11 - i10;
        } while (!atomicInteger.compareAndSet(i11, i12));
        if (i12 == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return true;
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    @CanIgnoreReturnValue
    public int setCount(E e10, int i10) {
        AtomicInteger atomicInteger;
        int i11;
        AtomicInteger atomicInteger2;
        b5.u.E(e10);
        e5.i.b(i10, c7.g.f1744b);
        do {
            atomicInteger = (AtomicInteger) Maps.p0(this.countMap, e10);
            if (atomicInteger == null && (i10 == 0 || (atomicInteger = this.countMap.putIfAbsent(e10, new AtomicInteger(i10))) == null)) {
                return 0;
            }
            do {
                i11 = atomicInteger.get();
                if (i11 == 0) {
                    if (i10 != 0) {
                        atomicInteger2 = new AtomicInteger(i10);
                        if (this.countMap.putIfAbsent(e10, atomicInteger2) == null) {
                            break;
                        }
                    } else {
                        return 0;
                    }
                }
            } while (!atomicInteger.compareAndSet(i11, i10));
            if (i10 == 0) {
                this.countMap.remove(e10, atomicInteger);
            }
            return i11;
        } while (!this.countMap.replace(e10, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.s
    public int size() {
        long j10 = 0;
        while (this.countMap.values().iterator().hasNext()) {
            j10 += r0.next().get();
        }
        return Ints.x(j10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return snapshot().toArray();
    }

    public class a extends n0<E> {

        /* renamed from: b */
        public final /* synthetic */ Set f9408b;

        public a(ConcurrentHashMultiset concurrentHashMultiset, Set set) {
            this.f9408b = set;
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return obj != null && f.j(this.f9408b, obj);
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            return obj != null && f.k(this.f9408b, obj);
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // e5.n0, e5.y, e5.l0
        public Set<E> delegate() {
            return this.f9408b;
        }
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> iterable) {
        ConcurrentHashMultiset<E> create = create();
        u0.a(create, iterable);
        return create;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) snapshot().toArray(tArr);
    }

    @a5.a
    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        return new ConcurrentHashMultiset<>(concurrentMap);
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    @CanIgnoreReturnValue
    public boolean setCount(E e10, int i10, int i11) {
        b5.u.E(e10);
        e5.i.b(i10, "oldCount");
        e5.i.b(i11, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.p0(this.countMap, e10);
        if (atomicInteger == null) {
            if (i10 != 0) {
                return false;
            }
            return i11 == 0 || this.countMap.putIfAbsent(e10, new AtomicInteger(i11)) == null;
        }
        int i12 = atomicInteger.get();
        if (i12 == i10) {
            if (i12 == 0) {
                if (i11 == 0) {
                    this.countMap.remove(e10, atomicInteger);
                    return true;
                }
                AtomicInteger atomicInteger2 = new AtomicInteger(i11);
                return this.countMap.putIfAbsent(e10, atomicInteger2) == null || this.countMap.replace(e10, atomicInteger, atomicInteger2);
            }
            if (atomicInteger.compareAndSet(i12, i11)) {
                if (i11 == 0) {
                    this.countMap.remove(e10, atomicInteger);
                }
                return true;
            }
        }
        return false;
    }
}
