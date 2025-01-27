package com.google.common.collect;

import com.google.common.collect.Maps;
import e5.j1;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
/* loaded from: classes2.dex */
class StandardRowSortedTable<R, C, V> extends StandardTable<R, C, V> implements j1<R, C, V> {
    private static final long serialVersionUID = 0;

    public class b extends StandardTable<R, C, V>.h implements SortedMap<R, Map<C, V>> {
        public b() {
            super();
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public Comparator<? super R> comparator() {
            return StandardRowSortedTable.this.sortedBackingMap().comparator();
        }

        @Override // java.util.SortedMap
        public R firstKey() {
            return (R) StandardRowSortedTable.this.sortedBackingMap().firstKey();
        }

        @Override // com.google.common.collect.Maps.n0
        /* renamed from: h */
        public SortedSet<R> i() {
            return new Maps.e0(this);
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> headMap(R r10) {
            b5.u.E(r10);
            return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().headMap(r10), StandardRowSortedTable.this.factory).rowMap();
        }

        @Override // com.google.common.collect.Maps.n0, java.util.AbstractMap, java.util.Map
        /* renamed from: i */
        public SortedSet<R> keySet() {
            return (SortedSet) super.keySet();
        }

        @Override // java.util.SortedMap
        public R lastKey() {
            return (R) StandardRowSortedTable.this.sortedBackingMap().lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> subMap(R r10, R r11) {
            b5.u.E(r10);
            b5.u.E(r11);
            return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().subMap(r10, r11), StandardRowSortedTable.this.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> tailMap(R r10) {
            b5.u.E(r10);
            return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().tailMap(r10), StandardRowSortedTable.this.factory).rowMap();
        }

        public /* synthetic */ b(StandardRowSortedTable standardRowSortedTable, a aVar) {
            this();
        }
    }

    public StandardRowSortedTable(SortedMap<R, Map<C, V>> sortedMap, b5.z<? extends Map<C, V>> zVar) {
        super(sortedMap, zVar);
    }

    public SortedMap<R, Map<C, V>> sortedBackingMap() {
        return (SortedMap) this.backingMap;
    }

    @Override // com.google.common.collect.StandardTable
    public SortedMap<R, Map<C, V>> createRowMap() {
        return new b();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.e, com.google.common.collect.a0
    public SortedSet<R> rowKeySet() {
        return (SortedSet) rowMap().keySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.a0
    public SortedMap<R, Map<C, V>> rowMap() {
        return (SortedMap) super.rowMap();
    }
}
