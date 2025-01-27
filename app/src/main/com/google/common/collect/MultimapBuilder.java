package com.google.common.collect;

import e5.l1;
import e5.t1;
import e5.x0;
import e5.z0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

@a5.b
@e5.m
/* loaded from: classes2.dex */
public abstract class MultimapBuilder<K0, V0> {

    /* renamed from: a */
    public static final int f9686a = 8;

    public static final class ArrayListSupplier<V> implements b5.z<List<V>>, Serializable {
        private final int expectedValuesPerKey;

        public ArrayListSupplier(int i10) {
            this.expectedValuesPerKey = e5.i.b(i10, "expectedValuesPerKey");
        }

        @Override // b5.z
        public List<V> get() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    public static final class EnumSetSupplier<V extends Enum<V>> implements b5.z<Set<V>>, Serializable {
        private final Class<V> clazz;

        public EnumSetSupplier(Class<V> cls) {
            this.clazz = (Class) b5.u.E(cls);
        }

        @Override // b5.z
        public Set<V> get() {
            return EnumSet.noneOf(this.clazz);
        }
    }

    public static final class HashSetSupplier<V> implements b5.z<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        public HashSetSupplier(int i10) {
            this.expectedValuesPerKey = e5.i.b(i10, "expectedValuesPerKey");
        }

        @Override // b5.z
        public Set<V> get() {
            return u.e(this.expectedValuesPerKey);
        }
    }

    public static final class LinkedHashSetSupplier<V> implements b5.z<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        public LinkedHashSetSupplier(int i10) {
            this.expectedValuesPerKey = e5.i.b(i10, "expectedValuesPerKey");
        }

        @Override // b5.z
        public Set<V> get() {
            return u.g(this.expectedValuesPerKey);
        }
    }

    public enum LinkedListSupplier implements b5.z<List<?>> {
        INSTANCE;

        public static <V> b5.z<List<V>> instance() {
            return INSTANCE;
        }

        @Override // b5.z
        public List<?> get() {
            return new LinkedList();
        }
    }

    public static final class TreeSetSupplier<V> implements b5.z<SortedSet<V>>, Serializable {
        private final Comparator<? super V> comparator;

        public TreeSetSupplier(Comparator<? super V> comparator) {
            this.comparator = (Comparator) b5.u.E(comparator);
        }

        @Override // b5.z
        public SortedSet<V> get() {
            return new TreeSet(this.comparator);
        }
    }

    public class a extends f<Object> {

        /* renamed from: b */
        public final /* synthetic */ int f9687b;

        public a(int i10) {
            this.f9687b = i10;
        }

        @Override // com.google.common.collect.MultimapBuilder.f
        public <K, V> Map<K, Collection<V>> c() {
            return u.d(this.f9687b);
        }
    }

    public class b extends f<Object> {

        /* renamed from: b */
        public final /* synthetic */ int f9688b;

        public b(int i10) {
            this.f9688b = i10;
        }

        @Override // com.google.common.collect.MultimapBuilder.f
        public <K, V> Map<K, Collection<V>> c() {
            return u.f(this.f9688b);
        }
    }

    public class c extends f<K0> {

        /* renamed from: b */
        public final /* synthetic */ Comparator f9689b;

        public c(Comparator comparator) {
            this.f9689b = comparator;
        }

        @Override // com.google.common.collect.MultimapBuilder.f
        public <K extends K0, V> Map<K, Collection<V>> c() {
            return new TreeMap(this.f9689b);
        }
    }

    public class d extends f<K0> {

        /* renamed from: b */
        public final /* synthetic */ Class f9690b;

        public d(Class cls) {
            this.f9690b = cls;
        }

        @Override // com.google.common.collect.MultimapBuilder.f
        public <K extends K0, V> Map<K, Collection<V>> c() {
            return new EnumMap(this.f9690b);
        }
    }

    public static abstract class e<K0, V0> extends MultimapBuilder<K0, V0> {
        public e() {
            super(null);
        }

        @Override // com.google.common.collect.MultimapBuilder
        /* renamed from: j */
        public abstract <K extends K0, V extends V0> x0<K, V> a();

        @Override // com.google.common.collect.MultimapBuilder
        /* renamed from: k */
        public <K extends K0, V extends V0> x0<K, V> b(z0<? extends K, ? extends V> z0Var) {
            return (x0) super.b(z0Var);
        }
    }

    public static abstract class f<K0> {

        /* renamed from: a */
        public static final int f9691a = 2;

        public class a extends e<K0, Object> {

            /* renamed from: b */
            public final /* synthetic */ int f9692b;

            public a(int i10) {
                this.f9692b = i10;
            }

            @Override // com.google.common.collect.MultimapBuilder.e, com.google.common.collect.MultimapBuilder
            /* renamed from: j */
            public <K extends K0, V> x0<K, V> a() {
                return Multimaps.u(f.this.c(), new ArrayListSupplier(this.f9692b));
            }
        }

        public class b extends e<K0, Object> {
            public b() {
            }

            @Override // com.google.common.collect.MultimapBuilder.e, com.google.common.collect.MultimapBuilder
            /* renamed from: j */
            public <K extends K0, V> x0<K, V> a() {
                return Multimaps.u(f.this.c(), LinkedListSupplier.instance());
            }
        }

        public class c extends g<K0, Object> {

            /* renamed from: b */
            public final /* synthetic */ int f9695b;

            public c(int i10) {
                this.f9695b = i10;
            }

            @Override // com.google.common.collect.MultimapBuilder.g, com.google.common.collect.MultimapBuilder
            /* renamed from: j */
            public <K extends K0, V> l1<K, V> a() {
                return Multimaps.w(f.this.c(), new HashSetSupplier(this.f9695b));
            }
        }

        public class d extends g<K0, Object> {

            /* renamed from: b */
            public final /* synthetic */ int f9697b;

            public d(int i10) {
                this.f9697b = i10;
            }

            @Override // com.google.common.collect.MultimapBuilder.g, com.google.common.collect.MultimapBuilder
            /* renamed from: j */
            public <K extends K0, V> l1<K, V> a() {
                return Multimaps.w(f.this.c(), new LinkedHashSetSupplier(this.f9697b));
            }
        }

        public class e extends h<K0, V0> {

            /* renamed from: b */
            public final /* synthetic */ Comparator f9699b;

            public e(Comparator comparator) {
                this.f9699b = comparator;
            }

            @Override // com.google.common.collect.MultimapBuilder.h, com.google.common.collect.MultimapBuilder.g
            /* renamed from: l */
            public <K extends K0, V extends V0> t1<K, V> a() {
                return Multimaps.x(f.this.c(), new TreeSetSupplier(this.f9699b));
            }
        }

        /* renamed from: com.google.common.collect.MultimapBuilder$f$f */
        public class C0271f extends g<K0, V0> {

            /* renamed from: b */
            public final /* synthetic */ Class f9701b;

            public C0271f(Class cls) {
                this.f9701b = cls;
            }

            @Override // com.google.common.collect.MultimapBuilder.g, com.google.common.collect.MultimapBuilder
            /* renamed from: j */
            public <K extends K0, V extends V0> l1<K, V> a() {
                return Multimaps.w(f.this.c(), new EnumSetSupplier(this.f9701b));
            }
        }

        public e<K0, Object> a() {
            return b(2);
        }

        public e<K0, Object> b(int i10) {
            e5.i.b(i10, "expectedValuesPerKey");
            return new a(i10);
        }

        public abstract <K extends K0, V> Map<K, Collection<V>> c();

        public <V0 extends Enum<V0>> g<K0, V0> d(Class<V0> cls) {
            b5.u.F(cls, "valueClass");
            return new C0271f(cls);
        }

        public g<K0, Object> e() {
            return f(2);
        }

        public g<K0, Object> f(int i10) {
            e5.i.b(i10, "expectedValuesPerKey");
            return new c(i10);
        }

        public g<K0, Object> g() {
            return h(2);
        }

        public g<K0, Object> h(int i10) {
            e5.i.b(i10, "expectedValuesPerKey");
            return new d(i10);
        }

        public e<K0, Object> i() {
            return new b();
        }

        public h<K0, Comparable> j() {
            return k(Ordering.natural());
        }

        public <V0> h<K0, V0> k(Comparator<V0> comparator) {
            b5.u.F(comparator, "comparator");
            return new e(comparator);
        }
    }

    public static abstract class g<K0, V0> extends MultimapBuilder<K0, V0> {
        public g() {
            super(null);
        }

        @Override // com.google.common.collect.MultimapBuilder
        /* renamed from: j */
        public abstract <K extends K0, V extends V0> l1<K, V> a();

        @Override // com.google.common.collect.MultimapBuilder
        /* renamed from: k */
        public <K extends K0, V extends V0> l1<K, V> b(z0<? extends K, ? extends V> z0Var) {
            return (l1) super.b(z0Var);
        }
    }

    public static abstract class h<K0, V0> extends g<K0, V0> {
        @Override // com.google.common.collect.MultimapBuilder.g
        /* renamed from: l */
        public abstract <K extends K0, V extends V0> t1<K, V> a();

        @Override // com.google.common.collect.MultimapBuilder.g
        /* renamed from: m */
        public <K extends K0, V extends V0> t1<K, V> b(z0<? extends K, ? extends V> z0Var) {
            return (t1) super.b(z0Var);
        }
    }

    public /* synthetic */ MultimapBuilder(a aVar) {
        this();
    }

    public static <K0 extends Enum<K0>> f<K0> c(Class<K0> cls) {
        b5.u.E(cls);
        return new d(cls);
    }

    public static f<Object> d() {
        return e(8);
    }

    public static f<Object> e(int i10) {
        e5.i.b(i10, "expectedKeys");
        return new a(i10);
    }

    public static f<Object> f() {
        return g(8);
    }

    public static f<Object> g(int i10) {
        e5.i.b(i10, "expectedKeys");
        return new b(i10);
    }

    public static f<Comparable> h() {
        return i(Ordering.natural());
    }

    public static <K0> f<K0> i(Comparator<K0> comparator) {
        b5.u.E(comparator);
        return new c(comparator);
    }

    public abstract <K extends K0, V extends V0> z0<K, V> a();

    public <K extends K0, V extends V0> z0<K, V> b(z0<? extends K, ? extends V> z0Var) {
        z0<K, V> a10 = a();
        a10.putAll(z0Var);
        return a10;
    }

    public MultimapBuilder() {
    }
}
