package com.google.common.base;

import b5.g;
import b5.n;
import b5.q;
import b5.r;
import b5.s;
import b5.u;
import b5.v;
import b5.z;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.CheckForNull;

@a5.b
@g
/* loaded from: classes2.dex */
public final class Functions {

    public static class ConstantFunction<E> implements n<Object, E>, Serializable {
        private static final long serialVersionUID = 0;

        @s
        private final E value;

        public ConstantFunction(@s E e10) {
            this.value = e10;
        }

        @Override // b5.n
        @s
        public E apply(@CheckForNull Object obj) {
            return this.value;
        }

        @Override // b5.n
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof ConstantFunction) {
                return r.a(this.value, ((ConstantFunction) obj).value);
            }
            return false;
        }

        public int hashCode() {
            E e10 = this.value;
            if (e10 == null) {
                return 0;
            }
            return e10.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.value);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 20);
            sb2.append("Functions.constant(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static class ForMapWithDefault<K, V> implements n<K, V>, Serializable {
        private static final long serialVersionUID = 0;

        @s
        final V defaultValue;
        final Map<K, ? extends V> map;

        public ForMapWithDefault(Map<K, ? extends V> map, @s V v10) {
            this.map = (Map) u.E(map);
            this.defaultValue = v10;
        }

        @Override // b5.n
        @s
        public V apply(@s K k10) {
            V v10 = this.map.get(k10);
            return (v10 != null || this.map.containsKey(k10)) ? (V) q.a(v10) : this.defaultValue;
        }

        @Override // b5.n
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof ForMapWithDefault)) {
                return false;
            }
            ForMapWithDefault forMapWithDefault = (ForMapWithDefault) obj;
            return this.map.equals(forMapWithDefault.map) && r.a(this.defaultValue, forMapWithDefault.defaultValue);
        }

        public int hashCode() {
            return r.b(this.map, this.defaultValue);
        }

        public String toString() {
            String valueOf = String.valueOf(this.map);
            String valueOf2 = String.valueOf(this.defaultValue);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 33 + valueOf2.length());
            sb2.append("Functions.forMap(");
            sb2.append(valueOf);
            sb2.append(", defaultValue=");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static class FunctionComposition<A, B, C> implements n<A, C>, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: f */
        private final n<A, ? extends B> f9108f;

        /* renamed from: g */
        private final n<B, C> f9109g;

        public FunctionComposition(n<B, C> nVar, n<A, ? extends B> nVar2) {
            this.f9109g = (n) u.E(nVar);
            this.f9108f = (n) u.E(nVar2);
        }

        @Override // b5.n
        @s
        public C apply(@s A a10) {
            return (C) this.f9109g.apply(this.f9108f.apply(a10));
        }

        @Override // b5.n
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof FunctionComposition)) {
                return false;
            }
            FunctionComposition functionComposition = (FunctionComposition) obj;
            return this.f9108f.equals(functionComposition.f9108f) && this.f9109g.equals(functionComposition.f9109g);
        }

        public int hashCode() {
            return this.f9108f.hashCode() ^ this.f9109g.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.f9109g);
            String valueOf2 = String.valueOf(this.f9108f);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 2 + valueOf2.length());
            sb2.append(valueOf);
            sb2.append("(");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static class FunctionForMapNoDefault<K, V> implements n<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final Map<K, V> map;

        public FunctionForMapNoDefault(Map<K, V> map) {
            this.map = (Map) u.E(map);
        }

        @Override // b5.n
        @s
        public V apply(@s K k10) {
            V v10 = this.map.get(k10);
            u.u(v10 != null || this.map.containsKey(k10), "Key '%s' not present in map", k10);
            return (V) q.a(v10);
        }

        @Override // b5.n
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof FunctionForMapNoDefault) {
                return this.map.equals(((FunctionForMapNoDefault) obj).map);
            }
            return false;
        }

        public int hashCode() {
            return this.map.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.map);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 18);
            sb2.append("Functions.forMap(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public enum IdentityFunction implements n<Object, Object> {
        INSTANCE;

        @Override // b5.n
        @CheckForNull
        public Object apply(@CheckForNull Object obj) {
            return obj;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.identity()";
        }
    }

    public static class PredicateFunction<T> implements n<T, Boolean>, Serializable {
        private static final long serialVersionUID = 0;
        private final v<T> predicate;

        public /* synthetic */ PredicateFunction(v vVar, a aVar) {
            this(vVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // b5.n
        public /* bridge */ /* synthetic */ Boolean apply(@s Object obj) {
            return apply((PredicateFunction<T>) obj);
        }

        @Override // b5.n
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof PredicateFunction) {
                return this.predicate.equals(((PredicateFunction) obj).predicate);
            }
            return false;
        }

        public int hashCode() {
            return this.predicate.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.predicate);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 24);
            sb2.append("Functions.forPredicate(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }

        private PredicateFunction(v<T> vVar) {
            this.predicate = (v) u.E(vVar);
        }

        @Override // b5.n
        public Boolean apply(@s T t10) {
            return Boolean.valueOf(this.predicate.apply(t10));
        }
    }

    public static class SupplierFunction<F, T> implements n<F, T>, Serializable {
        private static final long serialVersionUID = 0;
        private final z<T> supplier;

        public /* synthetic */ SupplierFunction(z zVar, a aVar) {
            this(zVar);
        }

        @Override // b5.n
        @s
        public T apply(@s F f10) {
            return this.supplier.get();
        }

        @Override // b5.n
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof SupplierFunction) {
                return this.supplier.equals(((SupplierFunction) obj).supplier);
            }
            return false;
        }

        public int hashCode() {
            return this.supplier.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.supplier);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 23);
            sb2.append("Functions.forSupplier(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }

        private SupplierFunction(z<T> zVar) {
            this.supplier = (z) u.E(zVar);
        }
    }

    public enum ToStringFunction implements n<Object, String> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.toStringFunction()";
        }

        @Override // b5.n
        public String apply(Object obj) {
            u.E(obj);
            return obj.toString();
        }
    }

    public static <A, B, C> n<A, C> a(n<B, C> nVar, n<A, ? extends B> nVar2) {
        return new FunctionComposition(nVar, nVar2);
    }

    public static <E> n<Object, E> b(@s E e10) {
        return new ConstantFunction(e10);
    }

    public static <K, V> n<K, V> c(Map<K, V> map) {
        return new FunctionForMapNoDefault(map);
    }

    public static <K, V> n<K, V> d(Map<K, ? extends V> map, @s V v10) {
        return new ForMapWithDefault(map, v10);
    }

    public static <T> n<T, Boolean> e(v<T> vVar) {
        return new PredicateFunction(vVar);
    }

    public static <F, T> n<F, T> f(z<T> zVar) {
        return new SupplierFunction(zVar);
    }

    public static <E> n<E, E> g() {
        return IdentityFunction.INSTANCE;
    }

    public static n<Object, String> h() {
        return ToStringFunction.INSTANCE;
    }
}
