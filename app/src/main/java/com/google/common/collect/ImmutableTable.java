package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Tables;
import com.google.common.collect.a0;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.DoNotMock;
import e5.u0;
import e5.z1;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
/* loaded from: classes2.dex */
public abstract class ImmutableTable<R, C, V> extends e<R, C, V> implements Serializable {

    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final int[] cellColumnIndices;
        private final int[] cellRowIndices;
        private final Object[] cellValues;
        private final Object[] columnKeys;
        private final Object[] rowKeys;

        private SerializedForm(Object[] objArr, Object[] objArr2, Object[] objArr3, int[] iArr, int[] iArr2) {
            this.rowKeys = objArr;
            this.columnKeys = objArr2;
            this.cellValues = objArr3;
            this.cellRowIndices = iArr;
            this.cellColumnIndices = iArr2;
        }

        public static SerializedForm create(ImmutableTable<?, ?, ?> immutableTable, int[] iArr, int[] iArr2) {
            return new SerializedForm(immutableTable.rowKeySet().toArray(), immutableTable.columnKeySet().toArray(), immutableTable.values().toArray(), iArr, iArr2);
        }

        public Object readResolve() {
            Object[] objArr = this.cellValues;
            if (objArr.length == 0) {
                return ImmutableTable.of();
            }
            int i10 = 0;
            if (objArr.length == 1) {
                return ImmutableTable.of(this.rowKeys[0], this.columnKeys[0], objArr[0]);
            }
            ImmutableList.a aVar = new ImmutableList.a(objArr.length);
            while (true) {
                Object[] objArr2 = this.cellValues;
                if (i10 >= objArr2.length) {
                    return RegularImmutableTable.forOrderedComponents(aVar.e(), ImmutableSet.copyOf(this.rowKeys), ImmutableSet.copyOf(this.columnKeys));
                }
                aVar.a(ImmutableTable.cellOf(this.rowKeys[this.cellRowIndices[i10]], this.columnKeys[this.cellColumnIndices[i10]], objArr2[i10]));
                i10++;
            }
        }
    }

    @DoNotMock
    public static final class a<R, C, V> {

        /* renamed from: a */
        public final List<a0.a<R, C, V>> f9500a = Lists.q();

        /* renamed from: b */
        @CheckForNull
        public Comparator<? super R> f9501b;

        /* renamed from: c */
        @CheckForNull
        public Comparator<? super C> f9502c;

        public ImmutableTable<R, C, V> a() {
            return b();
        }

        public ImmutableTable<R, C, V> b() {
            int size = this.f9500a.size();
            return size != 0 ? size != 1 ? RegularImmutableTable.forCells(this.f9500a, this.f9501b, this.f9502c) : new SingletonImmutableTable((a0.a) u0.z(this.f9500a)) : ImmutableTable.of();
        }

        @CanIgnoreReturnValue
        public a<R, C, V> c(a<R, C, V> aVar) {
            this.f9500a.addAll(aVar.f9500a);
            return this;
        }

        @CanIgnoreReturnValue
        public a<R, C, V> d(Comparator<? super C> comparator) {
            this.f9502c = (Comparator) b5.u.F(comparator, "columnComparator");
            return this;
        }

        @CanIgnoreReturnValue
        public a<R, C, V> e(Comparator<? super R> comparator) {
            this.f9501b = (Comparator) b5.u.F(comparator, "rowComparator");
            return this;
        }

        @CanIgnoreReturnValue
        public a<R, C, V> f(a0.a<? extends R, ? extends C, ? extends V> aVar) {
            if (aVar instanceof Tables.ImmutableCell) {
                b5.u.F(aVar.getRowKey(), "row");
                b5.u.F(aVar.getColumnKey(), "column");
                b5.u.F(aVar.getValue(), "value");
                this.f9500a.add(aVar);
            } else {
                g(aVar.getRowKey(), aVar.getColumnKey(), aVar.getValue());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public a<R, C, V> g(R r10, C c10, V v10) {
            this.f9500a.add(ImmutableTable.cellOf(r10, c10, v10));
            return this;
        }

        @CanIgnoreReturnValue
        public a<R, C, V> h(a0<? extends R, ? extends C, ? extends V> a0Var) {
            Iterator<a0.a<? extends R, ? extends C, ? extends V>> it = a0Var.cellSet().iterator();
            while (it.hasNext()) {
                f(it.next());
            }
            return this;
        }
    }

    public static <R, C, V> a<R, C, V> builder() {
        return new a<>();
    }

    public static <R, C, V> a0.a<R, C, V> cellOf(R r10, C c10, V v10) {
        return Tables.c(b5.u.F(r10, "rowKey"), b5.u.F(c10, "columnKey"), b5.u.F(v10, "value"));
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(a0<? extends R, ? extends C, ? extends V> a0Var) {
        return a0Var instanceof ImmutableTable ? (ImmutableTable) a0Var : copyOf(a0Var.cellSet());
    }

    public static <R, C, V> ImmutableTable<R, C, V> of() {
        return (ImmutableTable<R, C, V>) SparseImmutableTable.EMPTY;
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.a0
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return column((ImmutableTable<R, C, V>) obj);
    }

    @Override // com.google.common.collect.a0
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return get(obj, obj2) != null;
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ boolean containsColumn(@CheckForNull Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ boolean containsRow(@CheckForNull Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.e
    public abstract ImmutableSet<a0.a<R, C, V>> createCellSet();

    public abstract SerializedForm createSerializedForm();

    @Override // com.google.common.collect.e
    public abstract ImmutableCollection<V> createValues();

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    @CheckForNull
    public /* bridge */ /* synthetic */ Object get(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final V put(R r10, C c10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void putAll(a0<? extends R, ? extends C, ? extends V> a0Var) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.a0
    public /* bridge */ /* synthetic */ Map row(Object obj) {
        return row((ImmutableTable<R, C, V>) obj);
    }

    @Override // com.google.common.collect.a0
    public abstract ImmutableMap<R, Map<C, V>> rowMap();

    @Override // com.google.common.collect.e
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.e
    public final Iterator<V> valuesIterator() {
        throw new AssertionError("should never be called");
    }

    public final Object writeReplace() {
        return createSerializedForm();
    }

    public static <R, C, V> ImmutableTable<R, C, V> of(R r10, C c10, V v10) {
        return new SingletonImmutableTable(r10, c10, v10);
    }

    @Override // com.google.common.collect.e
    public final z1<a0.a<R, C, V>> cellIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public ImmutableSet<a0.a<R, C, V>> cellSet() {
        return (ImmutableSet) super.cellSet();
    }

    @Override // com.google.common.collect.a0
    public ImmutableMap<R, V> column(C c10) {
        b5.u.F(c10, "columnKey");
        return (ImmutableMap) com.google.common.base.a.a((ImmutableMap) columnMap().get(c10), ImmutableMap.of());
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public ImmutableSet<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.common.collect.a0
    public ImmutableMap<C, V> row(R r10) {
        b5.u.F(r10, "rowKey");
        return (ImmutableMap) com.google.common.base.a.a((ImmutableMap) rowMap().get(r10), ImmutableMap.of());
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public ImmutableSet<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(Iterable<? extends a0.a<? extends R, ? extends C, ? extends V>> iterable) {
        a builder = builder();
        Iterator<? extends a0.a<? extends R, ? extends C, ? extends V>> it = iterable.iterator();
        while (it.hasNext()) {
            builder.f(it.next());
        }
        return builder.a();
    }
}
