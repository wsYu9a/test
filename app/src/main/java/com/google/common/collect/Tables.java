package com.google.common.collect;

import com.google.common.collect.a0;
import e5.a1;
import e5.d1;
import e5.j1;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
/* loaded from: classes2.dex */
public final class Tables {

    /* renamed from: a */
    public static final b5.n<? extends Map<?, ?>, ? extends Map<?, ?>> f9832a = new a();

    public static final class ImmutableCell<R, C, V> extends b<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;

        @d1
        private final C columnKey;

        @d1
        private final R rowKey;

        @d1
        private final V value;

        public ImmutableCell(@d1 R r10, @d1 C c10, @d1 V v10) {
            this.rowKey = r10;
            this.columnKey = c10;
            this.value = v10;
        }

        @Override // com.google.common.collect.a0.a
        @d1
        public C getColumnKey() {
            return this.columnKey;
        }

        @Override // com.google.common.collect.a0.a
        @d1
        public R getRowKey() {
            return this.rowKey;
        }

        @Override // com.google.common.collect.a0.a
        @d1
        public V getValue() {
            return this.value;
        }
    }

    public static final class UnmodifiableRowSortedMap<R, C, V> extends UnmodifiableTable<R, C, V> implements j1<R, C, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableRowSortedMap(j1<R, ? extends C, ? extends V> j1Var) {
            super(j1Var);
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.p, com.google.common.collect.a0
        public SortedSet<R> rowKeySet() {
            return Collections.unmodifiableSortedSet(delegate().rowKeySet());
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.p, com.google.common.collect.a0
        public SortedMap<R, Map<C, V>> rowMap() {
            return Collections.unmodifiableSortedMap(Maps.D0(delegate().rowMap(), Tables.j()));
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.p, e5.l0
        public j1<R, C, V> delegate() {
            return (j1) super.delegate();
        }
    }

    public static class UnmodifiableTable<R, C, V> extends p<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final a0<? extends R, ? extends C, ? extends V> delegate;

        public UnmodifiableTable(a0<? extends R, ? extends C, ? extends V> a0Var) {
            this.delegate = (a0) b5.u.E(a0Var);
        }

        @Override // com.google.common.collect.p, com.google.common.collect.a0
        public Set<a0.a<R, C, V>> cellSet() {
            return Collections.unmodifiableSet(super.cellSet());
        }

        @Override // com.google.common.collect.p, com.google.common.collect.a0
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.p, com.google.common.collect.a0
        public Map<R, V> column(@d1 C c10) {
            return Collections.unmodifiableMap(super.column(c10));
        }

        @Override // com.google.common.collect.p, com.google.common.collect.a0
        public Set<C> columnKeySet() {
            return Collections.unmodifiableSet(super.columnKeySet());
        }

        @Override // com.google.common.collect.p, com.google.common.collect.a0
        public Map<C, Map<R, V>> columnMap() {
            return Collections.unmodifiableMap(Maps.B0(super.columnMap(), Tables.j()));
        }

        @Override // com.google.common.collect.p, com.google.common.collect.a0
        @CheckForNull
        public V put(@d1 R r10, @d1 C c10, @d1 V v10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.p, com.google.common.collect.a0
        public void putAll(a0<? extends R, ? extends C, ? extends V> a0Var) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.p, com.google.common.collect.a0
        @CheckForNull
        public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.p, com.google.common.collect.a0
        public Map<C, V> row(@d1 R r10) {
            return Collections.unmodifiableMap(super.row(r10));
        }

        @Override // com.google.common.collect.p, com.google.common.collect.a0
        public Set<R> rowKeySet() {
            return Collections.unmodifiableSet(super.rowKeySet());
        }

        @Override // com.google.common.collect.p, com.google.common.collect.a0
        public Map<R, Map<C, V>> rowMap() {
            return Collections.unmodifiableMap(Maps.B0(super.rowMap(), Tables.j()));
        }

        @Override // com.google.common.collect.p, com.google.common.collect.a0
        public Collection<V> values() {
            return Collections.unmodifiableCollection(super.values());
        }

        @Override // com.google.common.collect.p, e5.l0
        public a0<R, C, V> delegate() {
            return this.delegate;
        }
    }

    public class a implements b5.n<Map<Object, Object>, Map<Object, Object>> {
        @Override // b5.n
        /* renamed from: a */
        public Map<Object, Object> apply(Map<Object, Object> map) {
            return Collections.unmodifiableMap(map);
        }
    }

    public static abstract class b<R, C, V> implements a0.a<R, C, V> {
        @Override // com.google.common.collect.a0.a
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a0.a)) {
                return false;
            }
            a0.a aVar = (a0.a) obj;
            return b5.r.a(getRowKey(), aVar.getRowKey()) && b5.r.a(getColumnKey(), aVar.getColumnKey()) && b5.r.a(getValue(), aVar.getValue());
        }

        @Override // com.google.common.collect.a0.a
        public int hashCode() {
            return b5.r.b(getRowKey(), getColumnKey(), getValue());
        }

        public String toString() {
            String valueOf = String.valueOf(getRowKey());
            String valueOf2 = String.valueOf(getColumnKey());
            String valueOf3 = String.valueOf(getValue());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 4 + valueOf2.length() + valueOf3.length());
            sb2.append("(");
            sb2.append(valueOf);
            sb2.append(",");
            sb2.append(valueOf2);
            sb2.append(")=");
            sb2.append(valueOf3);
            return sb2.toString();
        }
    }

    public static class c<R, C, V1, V2> extends e<R, C, V2> {

        /* renamed from: b */
        public final a0<R, C, V1> f9833b;

        /* renamed from: c */
        public final b5.n<? super V1, V2> f9834c;

        public class a implements b5.n<a0.a<R, C, V1>, a0.a<R, C, V2>> {
            public a() {
            }

            @Override // b5.n
            /* renamed from: a */
            public a0.a<R, C, V2> apply(a0.a<R, C, V1> aVar) {
                return Tables.c(aVar.getRowKey(), aVar.getColumnKey(), c.this.f9834c.apply(aVar.getValue()));
            }
        }

        public class b implements b5.n<Map<C, V1>, Map<C, V2>> {
            public b() {
            }

            @Override // b5.n
            /* renamed from: a */
            public Map<C, V2> apply(Map<C, V1> map) {
                return Maps.B0(map, c.this.f9834c);
            }
        }

        /* renamed from: com.google.common.collect.Tables$c$c */
        public class C0284c implements b5.n<Map<R, V1>, Map<R, V2>> {
            public C0284c() {
            }

            @Override // b5.n
            /* renamed from: a */
            public Map<R, V2> apply(Map<R, V1> map) {
                return Maps.B0(map, c.this.f9834c);
            }
        }

        public c(a0<R, C, V1> a0Var, b5.n<? super V1, V2> nVar) {
            this.f9833b = (a0) b5.u.E(a0Var);
            this.f9834c = (b5.n) b5.u.E(nVar);
        }

        public b5.n<a0.a<R, C, V1>, a0.a<R, C, V2>> a() {
            return new a();
        }

        @Override // com.google.common.collect.e
        public Iterator<a0.a<R, C, V2>> cellIterator() {
            return Iterators.c0(this.f9833b.cellSet().iterator(), a());
        }

        @Override // com.google.common.collect.e, com.google.common.collect.a0
        public void clear() {
            this.f9833b.clear();
        }

        @Override // com.google.common.collect.a0
        public Map<R, V2> column(@d1 C c10) {
            return Maps.B0(this.f9833b.column(c10), this.f9834c);
        }

        @Override // com.google.common.collect.e, com.google.common.collect.a0
        public Set<C> columnKeySet() {
            return this.f9833b.columnKeySet();
        }

        @Override // com.google.common.collect.a0
        public Map<C, Map<R, V2>> columnMap() {
            return Maps.B0(this.f9833b.columnMap(), new C0284c());
        }

        @Override // com.google.common.collect.e, com.google.common.collect.a0
        public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.f9833b.contains(obj, obj2);
        }

        @Override // com.google.common.collect.e
        public Collection<V2> createValues() {
            return f.m(this.f9833b.values(), this.f9834c);
        }

        @Override // com.google.common.collect.e, com.google.common.collect.a0
        @CheckForNull
        public V2 get(@CheckForNull Object obj, @CheckForNull Object obj2) {
            if (contains(obj, obj2)) {
                return this.f9834c.apply((Object) a1.a(this.f9833b.get(obj, obj2)));
            }
            return null;
        }

        @Override // com.google.common.collect.e, com.google.common.collect.a0
        @CheckForNull
        public V2 put(@d1 R r10, @d1 C c10, @d1 V2 v22) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.e, com.google.common.collect.a0
        public void putAll(a0<? extends R, ? extends C, ? extends V2> a0Var) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.e, com.google.common.collect.a0
        @CheckForNull
        public V2 remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            if (contains(obj, obj2)) {
                return this.f9834c.apply((Object) a1.a(this.f9833b.remove(obj, obj2)));
            }
            return null;
        }

        @Override // com.google.common.collect.a0
        public Map<C, V2> row(@d1 R r10) {
            return Maps.B0(this.f9833b.row(r10), this.f9834c);
        }

        @Override // com.google.common.collect.e, com.google.common.collect.a0
        public Set<R> rowKeySet() {
            return this.f9833b.rowKeySet();
        }

        @Override // com.google.common.collect.a0
        public Map<R, Map<C, V2>> rowMap() {
            return Maps.B0(this.f9833b.rowMap(), new b());
        }

        @Override // com.google.common.collect.a0
        public int size() {
            return this.f9833b.size();
        }
    }

    public static class d<C, R, V> extends e<C, R, V> {

        /* renamed from: c */
        public static final b5.n<a0.a<?, ?, ?>, a0.a<?, ?, ?>> f9838c = new a();

        /* renamed from: b */
        public final a0<R, C, V> f9839b;

        public class a implements b5.n<a0.a<?, ?, ?>, a0.a<?, ?, ?>> {
            @Override // b5.n
            /* renamed from: a */
            public a0.a<?, ?, ?> apply(a0.a<?, ?, ?> aVar) {
                return Tables.c(aVar.getColumnKey(), aVar.getRowKey(), aVar.getValue());
            }
        }

        public d(a0<R, C, V> a0Var) {
            this.f9839b = (a0) b5.u.E(a0Var);
        }

        @Override // com.google.common.collect.e
        public Iterator<a0.a<C, R, V>> cellIterator() {
            return Iterators.c0(this.f9839b.cellSet().iterator(), f9838c);
        }

        @Override // com.google.common.collect.e, com.google.common.collect.a0
        public void clear() {
            this.f9839b.clear();
        }

        @Override // com.google.common.collect.a0
        public Map<C, V> column(@d1 R r10) {
            return this.f9839b.row(r10);
        }

        @Override // com.google.common.collect.e, com.google.common.collect.a0
        public Set<R> columnKeySet() {
            return this.f9839b.rowKeySet();
        }

        @Override // com.google.common.collect.a0
        public Map<R, Map<C, V>> columnMap() {
            return this.f9839b.rowMap();
        }

        @Override // com.google.common.collect.e, com.google.common.collect.a0
        public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.f9839b.contains(obj2, obj);
        }

        @Override // com.google.common.collect.e, com.google.common.collect.a0
        public boolean containsColumn(@CheckForNull Object obj) {
            return this.f9839b.containsRow(obj);
        }

        @Override // com.google.common.collect.e, com.google.common.collect.a0
        public boolean containsRow(@CheckForNull Object obj) {
            return this.f9839b.containsColumn(obj);
        }

        @Override // com.google.common.collect.e, com.google.common.collect.a0
        public boolean containsValue(@CheckForNull Object obj) {
            return this.f9839b.containsValue(obj);
        }

        @Override // com.google.common.collect.e, com.google.common.collect.a0
        @CheckForNull
        public V get(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.f9839b.get(obj2, obj);
        }

        @Override // com.google.common.collect.e, com.google.common.collect.a0
        @CheckForNull
        public V put(@d1 C c10, @d1 R r10, @d1 V v10) {
            return this.f9839b.put(r10, c10, v10);
        }

        @Override // com.google.common.collect.e, com.google.common.collect.a0
        public void putAll(a0<? extends C, ? extends R, ? extends V> a0Var) {
            this.f9839b.putAll(Tables.g(a0Var));
        }

        @Override // com.google.common.collect.e, com.google.common.collect.a0
        @CheckForNull
        public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.f9839b.remove(obj2, obj);
        }

        @Override // com.google.common.collect.a0
        public Map<R, V> row(@d1 C c10) {
            return this.f9839b.column(c10);
        }

        @Override // com.google.common.collect.e, com.google.common.collect.a0
        public Set<C> rowKeySet() {
            return this.f9839b.columnKeySet();
        }

        @Override // com.google.common.collect.a0
        public Map<C, Map<R, V>> rowMap() {
            return this.f9839b.columnMap();
        }

        @Override // com.google.common.collect.a0
        public int size() {
            return this.f9839b.size();
        }

        @Override // com.google.common.collect.e, com.google.common.collect.a0
        public Collection<V> values() {
            return this.f9839b.values();
        }
    }

    public static boolean b(a0<?, ?, ?> a0Var, @CheckForNull Object obj) {
        if (obj == a0Var) {
            return true;
        }
        if (obj instanceof a0) {
            return a0Var.cellSet().equals(((a0) obj).cellSet());
        }
        return false;
    }

    public static <R, C, V> a0.a<R, C, V> c(@d1 R r10, @d1 C c10, @d1 V v10) {
        return new ImmutableCell(r10, c10, v10);
    }

    @a5.a
    public static <R, C, V> a0<R, C, V> d(Map<R, Map<C, V>> map, b5.z<? extends Map<C, V>> zVar) {
        b5.u.d(map.isEmpty());
        b5.u.E(zVar);
        return new StandardTable(map, zVar);
    }

    public static <R, C, V> a0<R, C, V> e(a0<R, C, V> a0Var) {
        return Synchronized.z(a0Var, null);
    }

    @a5.a
    public static <R, C, V1, V2> a0<R, C, V2> f(a0<R, C, V1> a0Var, b5.n<? super V1, V2> nVar) {
        return new c(a0Var, nVar);
    }

    public static <R, C, V> a0<C, R, V> g(a0<R, C, V> a0Var) {
        return a0Var instanceof d ? ((d) a0Var).f9839b : new d(a0Var);
    }

    @a5.a
    public static <R, C, V> j1<R, C, V> h(j1<R, ? extends C, ? extends V> j1Var) {
        return new UnmodifiableRowSortedMap(j1Var);
    }

    public static <R, C, V> a0<R, C, V> i(a0<? extends R, ? extends C, ? extends V> a0Var) {
        return new UnmodifiableTable(a0Var);
    }

    public static <K, V> b5.n<Map<K, V>, Map<K, V>> j() {
        return (b5.n<Map<K, V>, Map<K, V>>) f9832a;
    }
}
