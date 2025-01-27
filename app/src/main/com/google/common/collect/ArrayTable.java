package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Tables;
import com.google.common.collect.a0;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import e5.d1;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@a5.a
@e5.m
/* loaded from: classes2.dex */
public final class ArrayTable<R, C, V> extends com.google.common.collect.e<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;

    @CheckForNull
    private transient ArrayTable<R, C, V>.f columnMap;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;

    @CheckForNull
    private transient ArrayTable<R, C, V>.h rowMap;

    public class a extends e5.a<a0.a<R, C, V>> {
        public a(int i10) {
            super(i10);
        }

        @Override // e5.a
        /* renamed from: b */
        public a0.a<R, C, V> a(int i10) {
            return ArrayTable.this.getCell(i10);
        }
    }

    public class b extends Tables.b<R, C, V> {

        /* renamed from: b */
        public final int f9374b;

        /* renamed from: c */
        public final int f9375c;

        /* renamed from: d */
        public final /* synthetic */ int f9376d;

        public b(int i10) {
            this.f9376d = i10;
            this.f9374b = i10 / ArrayTable.this.columnList.size();
            this.f9375c = i10 % ArrayTable.this.columnList.size();
        }

        @Override // com.google.common.collect.a0.a
        public C getColumnKey() {
            return (C) ArrayTable.this.columnList.get(this.f9375c);
        }

        @Override // com.google.common.collect.a0.a
        public R getRowKey() {
            return (R) ArrayTable.this.rowList.get(this.f9374b);
        }

        @Override // com.google.common.collect.a0.a
        @CheckForNull
        public V getValue() {
            return (V) ArrayTable.this.at(this.f9374b, this.f9375c);
        }
    }

    public class c extends e5.a<V> {
        public c(int i10) {
            super(i10);
        }

        @Override // e5.a
        @CheckForNull
        public V a(int i10) {
            return (V) ArrayTable.this.getValue(i10);
        }
    }

    public static abstract class d<K, V> extends Maps.y<K, V> {

        /* renamed from: b */
        public final ImmutableMap<K, Integer> f9379b;

        public class a extends e5.b<K, V> {

            /* renamed from: b */
            public final /* synthetic */ int f9380b;

            public a(int i10) {
                this.f9380b = i10;
            }

            @Override // e5.b, java.util.Map.Entry
            public K getKey() {
                return (K) d.this.e(this.f9380b);
            }

            @Override // e5.b, java.util.Map.Entry
            @d1
            public V getValue() {
                return (V) d.this.g(this.f9380b);
            }

            @Override // e5.b, java.util.Map.Entry
            @d1
            public V setValue(@d1 V v10) {
                return (V) d.this.h(this.f9380b, v10);
            }
        }

        public class b extends e5.a<Map.Entry<K, V>> {
            public b(int i10) {
                super(i10);
            }

            @Override // e5.a
            /* renamed from: b */
            public Map.Entry<K, V> a(int i10) {
                return d.this.c(i10);
            }
        }

        public /* synthetic */ d(ImmutableMap immutableMap, a aVar) {
            this(immutableMap);
        }

        @Override // com.google.common.collect.Maps.y
        public Iterator<Map.Entry<K, V>> a() {
            return new b(size());
        }

        public Map.Entry<K, V> c(int i10) {
            b5.u.C(i10, size());
            return new a(i10);
        }

        @Override // com.google.common.collect.Maps.y, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return this.f9379b.containsKey(obj);
        }

        public K e(int i10) {
            return this.f9379b.keySet().asList().get(i10);
        }

        public abstract String f();

        @d1
        public abstract V g(int i10);

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object obj) {
            Integer num = this.f9379b.get(obj);
            if (num == null) {
                return null;
            }
            return g(num.intValue());
        }

        @d1
        public abstract V h(int i10, @d1 V v10);

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f9379b.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f9379b.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V put(K k10, @d1 V v10) {
            Integer num = this.f9379b.get(k10);
            if (num != null) {
                return h(num.intValue(), v10);
            }
            String f10 = f();
            String valueOf = String.valueOf(k10);
            String valueOf2 = String.valueOf(this.f9379b.keySet());
            StringBuilder sb2 = new StringBuilder(String.valueOf(f10).length() + 9 + valueOf.length() + valueOf2.length());
            sb2.append(f10);
            sb2.append(" ");
            sb2.append(valueOf);
            sb2.append(" not in ");
            sb2.append(valueOf2);
            throw new IllegalArgumentException(sb2.toString());
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Maps.y, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f9379b.size();
        }

        public d(ImmutableMap<K, Integer> immutableMap) {
            this.f9379b = immutableMap;
        }
    }

    public class e extends d<R, V> {

        /* renamed from: c */
        public final int f9383c;

        public e(int i10) {
            super(ArrayTable.this.rowKeyToIndex, null);
            this.f9383c = i10;
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String f() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.d
        @CheckForNull
        public V g(int i10) {
            return (V) ArrayTable.this.at(i10, this.f9383c);
        }

        @Override // com.google.common.collect.ArrayTable.d
        @CheckForNull
        public V h(int i10, @CheckForNull V v10) {
            return (V) ArrayTable.this.set(i10, this.f9383c, v10);
        }
    }

    public class f extends d<C, Map<R, V>> {
        public /* synthetic */ f(ArrayTable arrayTable, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String f() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.d
        /* renamed from: i */
        public Map<R, V> g(int i10) {
            return new e(i10);
        }

        @Override // com.google.common.collect.ArrayTable.d, java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: j */
        public Map<R, V> put(C c10, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.d
        /* renamed from: k */
        public Map<R, V> h(int i10, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        public f() {
            super(ArrayTable.this.columnKeyToIndex, null);
        }
    }

    public class g extends d<C, V> {

        /* renamed from: c */
        public final int f9386c;

        public g(int i10) {
            super(ArrayTable.this.columnKeyToIndex, null);
            this.f9386c = i10;
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String f() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.d
        @CheckForNull
        public V g(int i10) {
            return (V) ArrayTable.this.at(this.f9386c, i10);
        }

        @Override // com.google.common.collect.ArrayTable.d
        @CheckForNull
        public V h(int i10, @CheckForNull V v10) {
            return (V) ArrayTable.this.set(this.f9386c, i10, v10);
        }
    }

    public class h extends d<R, Map<C, V>> {
        public /* synthetic */ h(ArrayTable arrayTable, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String f() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.d
        /* renamed from: i */
        public Map<C, V> g(int i10) {
            return new g(i10);
        }

        @Override // com.google.common.collect.ArrayTable.d, java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: j */
        public Map<C, V> put(R r10, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.d
        /* renamed from: k */
        public Map<C, V> h(int i10, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        public h() {
            super(ArrayTable.this.rowKeyToIndex, null);
        }
    }

    private ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        ImmutableList<R> copyOf = ImmutableList.copyOf(iterable);
        this.rowList = copyOf;
        ImmutableList<C> copyOf2 = ImmutableList.copyOf(iterable2);
        this.columnList = copyOf2;
        b5.u.d(copyOf.isEmpty() == copyOf2.isEmpty());
        this.rowKeyToIndex = Maps.Q(copyOf);
        this.columnKeyToIndex = Maps.Q(copyOf2);
        this.array = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, copyOf.size(), copyOf2.size()));
        eraseAll();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    public a0.a<R, C, V> getCell(int i10) {
        return new b(i10);
    }

    @CheckForNull
    public V getValue(int i10) {
        return at(i10 / this.columnList.size(), i10 % this.columnList.size());
    }

    @CheckForNull
    public V at(int i10, int i11) {
        b5.u.C(i10, this.rowList.size());
        b5.u.C(i11, this.columnList.size());
        return this.array[i10][i11];
    }

    @Override // com.google.common.collect.e
    public Iterator<a0.a<R, C, V>> cellIterator() {
        return new a(size());
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public Set<a0.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.a0
    public Map<R, V> column(C c10) {
        b5.u.E(c10);
        Integer num = this.columnKeyToIndex.get(c10);
        return num == null ? Collections.emptyMap() : new e(num.intValue());
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @Override // com.google.common.collect.a0
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.f fVar = this.columnMap;
        if (fVar != null) {
            return fVar;
        }
        ArrayTable<R, C, V>.f fVar2 = new f(this, null);
        this.columnMap = fVar2;
        return fVar2;
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public boolean containsColumn(@CheckForNull Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public boolean containsRow(@CheckForNull Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public boolean containsValue(@CheckForNull Object obj) {
        for (V[] vArr : this.array) {
            for (V v10 : vArr) {
                if (b5.r.a(obj, v10)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V erase(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), null);
    }

    public void eraseAll() {
        for (V[] vArr : this.array) {
            Arrays.fill(vArr, (Object) null);
        }
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    @CheckForNull
    public V get(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return at(num.intValue(), num2.intValue());
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    @CanIgnoreReturnValue
    @CheckForNull
    public V put(R r10, C c10, @CheckForNull V v10) {
        b5.u.E(r10);
        b5.u.E(c10);
        Integer num = this.rowKeyToIndex.get(r10);
        b5.u.y(num != null, "Row %s not in %s", r10, this.rowList);
        Integer num2 = this.columnKeyToIndex.get(c10);
        b5.u.y(num2 != null, "Column %s not in %s", c10, this.columnList);
        return set(num.intValue(), num2.intValue(), v10);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public void putAll(a0<? extends R, ? extends C, ? extends V> a0Var) {
        super.putAll(a0Var);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.a0
    public Map<C, V> row(R r10) {
        b5.u.E(r10);
        Integer num = this.rowKeyToIndex.get(r10);
        return num == null ? Collections.emptyMap() : new g(num.intValue());
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // com.google.common.collect.a0
    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.h hVar = this.rowMap;
        if (hVar != null) {
            return hVar;
        }
        ArrayTable<R, C, V>.h hVar2 = new h(this, null);
        this.rowMap = hVar2;
        return hVar2;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V set(int i10, int i11, @CheckForNull V v10) {
        b5.u.C(i10, this.rowList.size());
        b5.u.C(i11, this.columnList.size());
        V[] vArr = this.array[i10];
        V v11 = vArr[i11];
        vArr[i11] = v10;
        return v11;
    }

    @Override // com.google.common.collect.a0
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    @a5.c
    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, this.rowList.size(), this.columnList.size()));
        for (int i10 = 0; i10 < this.rowList.size(); i10++) {
            V[] vArr2 = this.array[i10];
            System.arraycopy(vArr2, 0, vArr[i10], 0, vArr2.length);
        }
        return vArr;
    }

    @Override // com.google.common.collect.e
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.e
    public Iterator<V> valuesIterator() {
        return new c(size());
    }

    public static <R, C, V> ArrayTable<R, C, V> create(a0<R, C, ? extends V> a0Var) {
        return a0Var instanceof ArrayTable ? new ArrayTable<>((ArrayTable) a0Var) : new ArrayTable<>(a0Var);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ArrayTable(a0<R, C, ? extends V> a0Var) {
        this(a0Var.rowKeySet(), a0Var.columnKeySet());
        putAll(a0Var);
    }

    private ArrayTable(ArrayTable<R, C, V> arrayTable) {
        ImmutableList<R> immutableList = arrayTable.rowList;
        this.rowList = immutableList;
        ImmutableList<C> immutableList2 = arrayTable.columnList;
        this.columnList = immutableList2;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, immutableList.size(), immutableList2.size()));
        this.array = vArr;
        for (int i10 = 0; i10 < this.rowList.size(); i10++) {
            V[] vArr2 = arrayTable.array[i10];
            System.arraycopy(vArr2, 0, vArr[i10], 0, vArr2.length);
        }
    }
}
