package com.google.common.collect;

import com.google.common.collect.a0;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
/* loaded from: classes2.dex */
abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {

    public final class CellSet extends IndexedImmutableSet<a0.a<R, C, V>> {
        private CellSet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof a0.a)) {
                return false;
            }
            a0.a aVar = (a0.a) obj;
            Object obj2 = RegularImmutableTable.this.get(aVar.getRowKey(), aVar.getColumnKey());
            return obj2 != null && obj2.equals(aVar.getValue());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return RegularImmutableTable.this.size();
        }

        public /* synthetic */ CellSet(RegularImmutableTable regularImmutableTable, a aVar) {
            this();
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public a0.a<R, C, V> get(int i10) {
            return RegularImmutableTable.this.getCell(i10);
        }
    }

    public final class Values extends ImmutableList<V> {
        private Values() {
        }

        @Override // java.util.List
        public V get(int i10) {
            return (V) RegularImmutableTable.this.getValue(i10);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return RegularImmutableTable.this.size();
        }

        public /* synthetic */ Values(RegularImmutableTable regularImmutableTable, a aVar) {
            this();
        }
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<a0.a<R, C, V>> list, @CheckForNull Comparator<? super R> comparator, @CheckForNull Comparator<? super C> comparator2) {
        b5.u.E(list);
        if (comparator != null || comparator2 != null) {
            Collections.sort(list, new Comparator() { // from class: com.google.common.collect.v

                /* renamed from: b */
                public final /* synthetic */ Comparator f9976b;

                /* renamed from: c */
                public final /* synthetic */ Comparator f9977c;

                public /* synthetic */ v(Comparator comparator3, Comparator comparator22) {
                    comparator = comparator3;
                    comparator2 = comparator22;
                }

                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int lambda$forCells$0;
                    lambda$forCells$0 = RegularImmutableTable.lambda$forCells$0(comparator, comparator2, (a0.a) obj, (a0.a) obj2);
                    return lambda$forCells$0;
                }
            });
        }
        return forCellsInternal(list, comparator3, comparator22);
    }

    private static <R, C, V> RegularImmutableTable<R, C, V> forCellsInternal(Iterable<a0.a<R, C, V>> iterable, @CheckForNull Comparator<? super R> comparator, @CheckForNull Comparator<? super C> comparator2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ImmutableList copyOf = ImmutableList.copyOf(iterable);
        for (a0.a<R, C, V> aVar : iterable) {
            linkedHashSet.add(aVar.getRowKey());
            linkedHashSet2.add(aVar.getColumnKey());
        }
        return forOrderedComponents(copyOf, comparator == null ? ImmutableSet.copyOf((Collection) linkedHashSet) : ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator, linkedHashSet)), comparator2 == null ? ImmutableSet.copyOf((Collection) linkedHashSet2) : ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator2, linkedHashSet2)));
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forOrderedComponents(ImmutableList<a0.a<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        return ((long) immutableList.size()) > (((long) immutableSet.size()) * ((long) immutableSet2.size())) / 2 ? new DenseImmutableTable(immutableList, immutableSet, immutableSet2) : new SparseImmutableTable(immutableList, immutableSet, immutableSet2);
    }

    public static /* synthetic */ int lambda$forCells$0(Comparator comparator, Comparator comparator2, a0.a aVar, a0.a aVar2) {
        int compare = comparator == null ? 0 : comparator.compare(aVar.getRowKey(), aVar2.getRowKey());
        if (compare != 0) {
            return compare;
        }
        if (comparator2 == null) {
            return 0;
        }
        return comparator2.compare(aVar.getColumnKey(), aVar2.getColumnKey());
    }

    public final void checkNoDuplicate(R r10, C c10, @CheckForNull V v10, V v11) {
        b5.u.A(v10 == null, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", r10, c10, v11, v10);
    }

    public abstract a0.a<R, C, V> getCell(int i10);

    public abstract V getValue(int i10);

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.e
    public final ImmutableSet<a0.a<R, C, V>> createCellSet() {
        return isEmpty() ? ImmutableSet.of() : new CellSet();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.e
    public final ImmutableCollection<V> createValues() {
        return isEmpty() ? ImmutableList.of() : new Values();
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<a0.a<R, C, V>> iterable) {
        return forCellsInternal(iterable, null, null);
    }
}
