package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.CheckForNull;

@a5.b(emulated = true, serializable = true)
@e5.m
/* loaded from: classes2.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements e5.g<K, V> {

    public static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;

        public SerializedForm(ImmutableBiMap<K, V> immutableBiMap) {
            super(immutableBiMap);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public a<K, V> makeBuilder(int i10) {
            return new a<>(i10);
        }
    }

    public static final class a<K, V> extends ImmutableMap.b<K, V> {
        public a() {
        }

        @Override // com.google.common.collect.ImmutableMap.b
        /* renamed from: n */
        public ImmutableBiMap<K, V> a() {
            return d();
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @DoNotCall
        @Deprecated
        /* renamed from: o */
        public ImmutableBiMap<K, V> c() {
            throw new UnsupportedOperationException("Not supported for bimaps");
        }

        @Override // com.google.common.collect.ImmutableMap.b
        /* renamed from: p */
        public ImmutableBiMap<K, V> d() {
            int i10 = this.f9453c;
            if (i10 == 0) {
                return ImmutableBiMap.of();
            }
            if (this.f9451a != null) {
                if (this.f9454d) {
                    this.f9452b = Arrays.copyOf(this.f9452b, i10 * 2);
                }
                ImmutableMap.b.m(this.f9452b, this.f9453c, this.f9451a);
            }
            this.f9454d = true;
            return new RegularImmutableBiMap(this.f9452b, this.f9453c);
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        /* renamed from: q */
        public a<K, V> e(ImmutableMap.b<K, V> bVar) {
            super.e(bVar);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        @a5.a
        /* renamed from: r */
        public a<K, V> h(Comparator<? super V> comparator) {
            super.h(comparator);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        /* renamed from: s */
        public a<K, V> i(K k10, V v10) {
            super.i(k10, v10);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        /* renamed from: t */
        public a<K, V> j(Map.Entry<? extends K, ? extends V> entry) {
            super.j(entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        @a5.a
        /* renamed from: u */
        public a<K, V> k(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.k(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        /* renamed from: v */
        public a<K, V> l(Map<? extends K, ? extends V> map) {
            super.l(map);
            return this;
        }

        public a(int i10) {
            super(i10);
        }
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    @a5.a
    public static <K, V> a<K, V> builderWithExpectedSize(int i10) {
        e5.i.b(i10, "expectedSize");
        return new a<>(i10);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.isPartialView()) {
                return immutableBiMap;
            }
        }
        return copyOf((Iterable) map.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return RegularImmutableBiMap.EMPTY;
    }

    @SafeVarargs
    public static <K, V> ImmutableBiMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entryArr) {
        return copyOf((Iterable) Arrays.asList(entryArr));
    }

    @Override // e5.g
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final V forcePut(K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // e5.g
    public abstract ImmutableBiMap<V, K> inverse();

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v10) {
        e5.i.a(k10, v10);
        return new RegularImmutableBiMap(new Object[]{k10, v10}, 1);
    }

    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet<V> createValues() {
        throw new AssertionError("should never be called");
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v10, K k11, V v11) {
        e5.i.a(k10, v10);
        e5.i.a(k11, v11);
        return new RegularImmutableBiMap(new Object[]{k10, v10, k11, v11}, 2);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, e5.g
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    @a5.a
    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4).k(iterable).a();
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12) {
        e5.i.a(k10, v10);
        e5.i.a(k11, v11);
        e5.i.a(k12, v12);
        return new RegularImmutableBiMap(new Object[]{k10, v10, k11, v11, k12, v12}, 3);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13) {
        e5.i.a(k10, v10);
        e5.i.a(k11, v11);
        e5.i.a(k12, v12);
        e5.i.a(k13, v13);
        return new RegularImmutableBiMap(new Object[]{k10, v10, k11, v11, k12, v12, k13, v13}, 4);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        e5.i.a(k10, v10);
        e5.i.a(k11, v11);
        e5.i.a(k12, v12);
        e5.i.a(k13, v13);
        e5.i.a(k14, v14);
        return new RegularImmutableBiMap(new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14}, 5);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15) {
        e5.i.a(k10, v10);
        e5.i.a(k11, v11);
        e5.i.a(k12, v12);
        e5.i.a(k13, v13);
        e5.i.a(k14, v14);
        e5.i.a(k15, v15);
        return new RegularImmutableBiMap(new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15}, 6);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16) {
        e5.i.a(k10, v10);
        e5.i.a(k11, v11);
        e5.i.a(k12, v12);
        e5.i.a(k13, v13);
        e5.i.a(k14, v14);
        e5.i.a(k15, v15);
        e5.i.a(k16, v16);
        return new RegularImmutableBiMap(new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16}, 7);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17) {
        e5.i.a(k10, v10);
        e5.i.a(k11, v11);
        e5.i.a(k12, v12);
        e5.i.a(k13, v13);
        e5.i.a(k14, v14);
        e5.i.a(k15, v15);
        e5.i.a(k16, v16);
        e5.i.a(k17, v17);
        return new RegularImmutableBiMap(new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17}, 8);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17, K k18, V v18) {
        e5.i.a(k10, v10);
        e5.i.a(k11, v11);
        e5.i.a(k12, v12);
        e5.i.a(k13, v13);
        e5.i.a(k14, v14);
        e5.i.a(k15, v15);
        e5.i.a(k16, v16);
        e5.i.a(k17, v17);
        e5.i.a(k18, v18);
        return new RegularImmutableBiMap(new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17, k18, v18}, 9);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17, K k18, V v18, K k19, V v19) {
        e5.i.a(k10, v10);
        e5.i.a(k11, v11);
        e5.i.a(k12, v12);
        e5.i.a(k13, v13);
        e5.i.a(k14, v14);
        e5.i.a(k15, v15);
        e5.i.a(k16, v16);
        e5.i.a(k17, v17);
        e5.i.a(k18, v18);
        e5.i.a(k19, v19);
        return new RegularImmutableBiMap(new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17, k18, v18, k19, v19}, 10);
    }
}
