package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multisets;
import com.google.common.collect.i;
import com.google.common.collect.s;
import e5.d1;
import e5.l1;
import e5.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
/* loaded from: classes2.dex */
public class i<K, V> extends com.google.common.collect.a<K, V> implements e5.s<K, V> {

    /* renamed from: b */
    public final z0<K, V> f9936b;

    /* renamed from: c */
    public final b5.v<? super Map.Entry<K, V>> f9937c;

    public class a extends Maps.n0<K, Collection<V>> {

        /* renamed from: com.google.common.collect.i$a$a */
        public class C0291a extends Maps.q<K, Collection<V>> {

            /* renamed from: com.google.common.collect.i$a$a$a */
            public class C0292a extends AbstractIterator<Map.Entry<K, Collection<V>>> {

                /* renamed from: d */
                public final Iterator<Map.Entry<K, Collection<V>>> f9940d;

                public C0292a() {
                    this.f9940d = i.this.f9936b.asMap().entrySet().iterator();
                }

                @Override // com.google.common.collect.AbstractIterator
                @CheckForNull
                /* renamed from: d */
                public Map.Entry<K, Collection<V>> a() {
                    while (this.f9940d.hasNext()) {
                        Map.Entry<K, Collection<V>> next = this.f9940d.next();
                        K key = next.getKey();
                        Collection d10 = i.d(next.getValue(), new c(key));
                        if (!d10.isEmpty()) {
                            return Maps.O(key, d10);
                        }
                    }
                    return b();
                }
            }

            public C0291a() {
            }

            @Override // com.google.common.collect.Maps.q
            public Map<K, Collection<V>> a() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new C0292a();
            }

            @Override // com.google.common.collect.Maps.q, com.google.common.collect.Sets.j, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return i.this.e(Predicates.n(collection));
            }

            @Override // com.google.common.collect.Maps.q, com.google.common.collect.Sets.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return i.this.e(Predicates.q(Predicates.n(collection)));
            }

            @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return Iterators.Z(iterator());
            }
        }

        public class b extends Maps.z<K, Collection<V>> {
            public b() {
                super(a.this);
            }

            @Override // com.google.common.collect.Maps.z, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                return a.this.remove(obj) != null;
            }

            @Override // com.google.common.collect.Sets.j, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return i.this.e(Maps.U(Predicates.n(collection)));
            }

            @Override // com.google.common.collect.Sets.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return i.this.e(Maps.U(Predicates.q(Predicates.n(collection))));
            }
        }

        public class c extends Maps.m0<K, Collection<V>> {
            public c() {
                super(a.this);
            }

            @Override // com.google.common.collect.Maps.m0, java.util.AbstractCollection, java.util.Collection
            public boolean remove(@CheckForNull Object obj) {
                if (!(obj instanceof Collection)) {
                    return false;
                }
                Collection collection = (Collection) obj;
                Iterator<Map.Entry<K, Collection<V>>> it = i.this.f9936b.asMap().entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<K, Collection<V>> next = it.next();
                    Collection d10 = i.d(next.getValue(), new c(next.getKey()));
                    if (!d10.isEmpty() && collection.equals(d10)) {
                        if (d10.size() == next.getValue().size()) {
                            it.remove();
                            return true;
                        }
                        d10.clear();
                        return true;
                    }
                }
                return false;
            }

            @Override // com.google.common.collect.Maps.m0, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                return i.this.e(Maps.Q0(Predicates.n(collection)));
            }

            @Override // com.google.common.collect.Maps.m0, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                return i.this.e(Maps.Q0(Predicates.q(Predicates.n(collection))));
            }
        }

        public a() {
        }

        @Override // com.google.common.collect.Maps.n0
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new C0291a();
        }

        @Override // com.google.common.collect.Maps.n0
        /* renamed from: c */
        public Set<K> i() {
            return new b();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return get(obj) != null;
        }

        @Override // com.google.common.collect.Maps.n0
        public Collection<Collection<V>> e() {
            return new c();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: f */
        public Collection<V> get(@CheckForNull Object obj) {
            Collection<V> collection = i.this.f9936b.asMap().get(obj);
            if (collection == null) {
                return null;
            }
            Collection<V> d10 = i.d(collection, new c(obj));
            if (d10.isEmpty()) {
                return null;
            }
            return d10;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: g */
        public Collection<V> remove(@CheckForNull Object obj) {
            Collection<V> collection = i.this.f9936b.asMap().get(obj);
            if (collection == null) {
                return null;
            }
            ArrayList q10 = Lists.q();
            Iterator<V> it = collection.iterator();
            while (it.hasNext()) {
                V next = it.next();
                if (i.this.f(obj, next)) {
                    it.remove();
                    q10.add(next);
                }
            }
            if (q10.isEmpty()) {
                return null;
            }
            return i.this.f9936b instanceof l1 ? Collections.unmodifiableSet(Sets.B(q10)) : Collections.unmodifiableList(q10);
        }
    }

    public class b extends Multimaps.c<K, V> {

        public class a extends Multisets.i<K> {
            public a() {
            }

            public static /* synthetic */ boolean c(b5.v vVar, Map.Entry entry) {
                return vVar.apply(Multisets.k(entry.getKey(), ((Collection) entry.getValue()).size()));
            }

            @Override // com.google.common.collect.Multisets.i
            public s<K> a() {
                return b.this;
            }

            public final boolean d(b5.v<? super s.a<K>> vVar) {
                return i.this.e(new b5.v() { // from class: e5.n
                    public /* synthetic */ n() {
                    }

                    @Override // b5.v
                    public final boolean apply(Object obj) {
                        boolean c10;
                        c10 = i.b.a.c(b5.v.this, (Map.Entry) obj);
                        return c10;
                    }
                });
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<s.a<K>> iterator() {
                return b.this.entryIterator();
            }

            @Override // com.google.common.collect.Sets.j, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return d(Predicates.n(collection));
            }

            @Override // com.google.common.collect.Sets.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return d(Predicates.q(Predicates.n(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return i.this.keySet().size();
            }
        }

        public b() {
            super(i.this);
        }

        @Override // com.google.common.collect.b, com.google.common.collect.s
        public Set<s.a<K>> entrySet() {
            return new a();
        }

        @Override // com.google.common.collect.Multimaps.c, com.google.common.collect.b, com.google.common.collect.s
        public int remove(@CheckForNull Object obj, int i10) {
            e5.i.b(i10, "occurrences");
            if (i10 == 0) {
                return count(obj);
            }
            Collection<V> collection = i.this.f9936b.asMap().get(obj);
            int i11 = 0;
            if (collection == null) {
                return 0;
            }
            Iterator<V> it = collection.iterator();
            while (it.hasNext()) {
                if (i.this.f(obj, it.next()) && (i11 = i11 + 1) <= i10) {
                    it.remove();
                }
            }
            return i11;
        }
    }

    public final class c implements b5.v<V> {

        /* renamed from: b */
        @d1
        public final K f9946b;

        public c(@d1 K k10) {
            this.f9946b = k10;
        }

        @Override // b5.v
        public boolean apply(@d1 V v10) {
            return i.this.f(this.f9946b, v10);
        }
    }

    public i(z0<K, V> z0Var, b5.v<? super Map.Entry<K, V>> vVar) {
        this.f9936b = (z0) b5.u.E(z0Var);
        this.f9937c = (b5.v) b5.u.E(vVar);
    }

    public static <E> Collection<E> d(Collection<E> collection, b5.v<? super E> vVar) {
        return collection instanceof Set ? Sets.i((Set) collection, vVar) : f.d(collection, vVar);
    }

    @Override // e5.s
    public z0<K, V> a() {
        return this.f9936b;
    }

    @Override // e5.s
    public b5.v<? super Map.Entry<K, V>> c() {
        return this.f9937c;
    }

    @Override // e5.z0
    public void clear() {
        entries().clear();
    }

    @Override // e5.z0
    public boolean containsKey(@CheckForNull Object obj) {
        return asMap().get(obj) != null;
    }

    @Override // com.google.common.collect.a
    public Map<K, Collection<V>> createAsMap() {
        return new a();
    }

    @Override // com.google.common.collect.a
    public Collection<Map.Entry<K, V>> createEntries() {
        return d(this.f9936b.entries(), this.f9937c);
    }

    @Override // com.google.common.collect.a
    public Set<K> createKeySet() {
        return asMap().keySet();
    }

    @Override // com.google.common.collect.a
    public s<K> createKeys() {
        return new b();
    }

    @Override // com.google.common.collect.a
    public Collection<V> createValues() {
        return new e5.t(this);
    }

    public boolean e(b5.v<? super Map.Entry<K, Collection<V>>> vVar) {
        Iterator<Map.Entry<K, Collection<V>>> it = this.f9936b.asMap().entrySet().iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            Map.Entry<K, Collection<V>> next = it.next();
            K key = next.getKey();
            Collection d10 = d(next.getValue(), new c(key));
            if (!d10.isEmpty() && vVar.apply(Maps.O(key, d10))) {
                if (d10.size() == next.getValue().size()) {
                    it.remove();
                } else {
                    d10.clear();
                }
                z10 = true;
            }
        }
        return z10;
    }

    @Override // com.google.common.collect.a
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    public final boolean f(@d1 K k10, @d1 V v10) {
        return this.f9937c.apply(Maps.O(k10, v10));
    }

    public Collection<V> g() {
        return this.f9936b instanceof l1 ? Collections.emptySet() : Collections.emptyList();
    }

    @Override // e5.z0, e5.x0
    public Collection<V> get(@d1 K k10) {
        return d(this.f9936b.get(k10), new c(k10));
    }

    @Override // e5.z0, e5.x0
    public Collection<V> removeAll(@CheckForNull Object obj) {
        return (Collection) com.google.common.base.a.a(asMap().remove(obj), g());
    }

    @Override // e5.z0
    public int size() {
        return entries().size();
    }
}
