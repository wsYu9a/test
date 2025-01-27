package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.TreeBasedTable;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.u0;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import javax.annotation.CheckForNull;

@a5.b(serializable = true)
@e5.m
/* loaded from: classes2.dex */
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;
    private final Comparator<? super C> columnComparator;

    public static class Factory<C, V> implements b5.z<TreeMap<C, V>>, Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super C> comparator;

        public Factory(Comparator<? super C> comparator) {
            this.comparator = comparator;
        }

        @Override // b5.z
        public TreeMap<C, V> get() {
            return new TreeMap<>(this.comparator);
        }
    }

    public class a extends AbstractIterator<C> {

        /* renamed from: d */
        @CheckForNull
        public C f9840d;

        /* renamed from: e */
        public final /* synthetic */ Iterator f9841e;

        /* renamed from: f */
        public final /* synthetic */ Comparator f9842f;

        public a(TreeBasedTable treeBasedTable, Iterator it, Comparator comparator) {
            this.f9841e = it;
            this.f9842f = comparator;
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        public C a() {
            while (this.f9841e.hasNext()) {
                C c10 = (C) this.f9841e.next();
                C c11 = this.f9840d;
                if (c11 == null || this.f9842f.compare(c10, c11) != 0) {
                    this.f9840d = c10;
                    return c10;
                }
            }
            this.f9840d = null;
            return b();
        }
    }

    public class b extends StandardTable<R, C, V>.g implements SortedMap<C, V> {

        /* renamed from: e */
        @CheckForNull
        public final C f9843e;

        /* renamed from: f */
        @CheckForNull
        public final C f9844f;

        /* renamed from: g */
        @CheckForNull
        public transient SortedMap<C, V> f9845g;

        public b(TreeBasedTable treeBasedTable, R r10) {
            this(r10, null, null);
        }

        @Override // java.util.SortedMap
        public Comparator<? super C> comparator() {
            return TreeBasedTable.this.columnComparator();
        }

        @Override // com.google.common.collect.StandardTable.g, java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return k(obj) && super.containsKey(obj);
        }

        @Override // com.google.common.collect.StandardTable.g
        public void e() {
            l();
            SortedMap<C, V> sortedMap = this.f9845g;
            if (sortedMap == null || !sortedMap.isEmpty()) {
                return;
            }
            TreeBasedTable.this.backingMap.remove(this.f9816b);
            this.f9845g = null;
            this.f9817c = null;
        }

        @Override // java.util.SortedMap
        public C firstKey() {
            f();
            Map<C, V> map = this.f9817c;
            if (map != null) {
                return (C) ((SortedMap) map).firstKey();
            }
            throw new NoSuchElementException();
        }

        public int h(Object obj, Object obj2) {
            return comparator().compare(obj, obj2);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> headMap(C c10) {
            b5.u.d(k(b5.u.E(c10)));
            return new b(this.f9816b, this.f9843e, c10);
        }

        @Override // com.google.common.collect.StandardTable.g
        @CheckForNull
        /* renamed from: i */
        public SortedMap<C, V> c() {
            l();
            SortedMap<C, V> sortedMap = this.f9845g;
            if (sortedMap == null) {
                return null;
            }
            C c10 = this.f9843e;
            if (c10 != null) {
                sortedMap = sortedMap.tailMap(c10);
            }
            C c11 = this.f9844f;
            return c11 != null ? sortedMap.headMap(c11) : sortedMap;
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* renamed from: j */
        public SortedSet<C> keySet() {
            return new Maps.e0(this);
        }

        public boolean k(@CheckForNull Object obj) {
            C c10;
            C c11;
            return obj != null && ((c10 = this.f9843e) == null || h(c10, obj) <= 0) && ((c11 = this.f9844f) == null || h(c11, obj) > 0);
        }

        public void l() {
            SortedMap<C, V> sortedMap = this.f9845g;
            if (sortedMap == null || (sortedMap.isEmpty() && TreeBasedTable.this.backingMap.containsKey(this.f9816b))) {
                this.f9845g = (SortedMap) TreeBasedTable.this.backingMap.get(this.f9816b);
            }
        }

        @Override // java.util.SortedMap
        public C lastKey() {
            f();
            Map<C, V> map = this.f9817c;
            if (map != null) {
                return (C) ((SortedMap) map).lastKey();
            }
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.StandardTable.g, java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V put(C c10, V v10) {
            b5.u.d(k(b5.u.E(c10)));
            return (V) super.put(c10, v10);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> subMap(C c10, C c11) {
            b5.u.d(k(b5.u.E(c10)) && k(b5.u.E(c11)));
            return new b(this.f9816b, c10, c11);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> tailMap(C c10) {
            b5.u.d(k(b5.u.E(c10)));
            return new b(this.f9816b, c10, this.f9844f);
        }

        public b(R r10, @CheckForNull C c10, @CheckForNull C c11) {
            super(r10);
            this.f9843e = c10;
            this.f9844f = c11;
            b5.u.d(c10 == null || c11 == null || h(c10, c11) <= 0);
        }
    }

    public TreeBasedTable(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        super(new TreeMap(comparator), new Factory(comparator2));
        this.columnComparator = comparator2;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable<>(Ordering.natural(), Ordering.natural());
    }

    public static /* synthetic */ Iterator lambda$createColumnKeyIterator$0(Map map) {
        return map.keySet().iterator();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.e, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.e, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return super.column(obj);
    }

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.e, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.e, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.e, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ boolean containsColumn(@CheckForNull Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.e, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ boolean containsRow(@CheckForNull Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.e, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ boolean containsValue(@CheckForNull Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.StandardTable
    public Iterator<C> createColumnKeyIterator() {
        Comparator<? super C> columnComparator = columnComparator();
        return new a(this, Iterators.O(u0.U(this.backingMap.values(), new b5.n() { // from class: e5.x1
            @Override // b5.n
            public final Object apply(Object obj) {
                Iterator lambda$createColumnKeyIterator$0;
                lambda$createColumnKeyIterator$0 = TreeBasedTable.lambda$createColumnKeyIterator$0((Map) obj);
                return lambda$createColumnKeyIterator$0;
            }
        }), columnComparator), columnComparator);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.e, com.google.common.collect.a0
    @CheckForNull
    public /* bridge */ /* synthetic */ Object get(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.e, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.e, com.google.common.collect.a0
    @CanIgnoreReturnValue
    @CheckForNull
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ void putAll(a0 a0Var) {
        super.putAll(a0Var);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.e, com.google.common.collect.a0
    @CanIgnoreReturnValue
    @CheckForNull
    public /* bridge */ /* synthetic */ Object remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.remove(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ Map row(Object obj) {
        return row((TreeBasedTable<R, C, V>) obj);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        Comparator<? super R> comparator = rowKeySet().comparator();
        Objects.requireNonNull(comparator);
        return comparator;
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.e
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.e, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        b5.u.E(comparator);
        b5.u.E(comparator2);
        return new TreeBasedTable<>(comparator, comparator2);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.a0
    public SortedMap<C, V> row(R r10) {
        return new b(this, r10);
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.e, com.google.common.collect.a0
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.a0
    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }
}
