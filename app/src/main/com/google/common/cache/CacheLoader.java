package com.google.common.cache;

import b5.n;
import b5.u;
import b5.z;
import com.google.common.util.concurrent.l;
import com.google.errorprone.annotations.CheckReturnValue;
import d5.d;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import p5.c0;
import p5.d0;

@a5.b(emulated = true)
@d
/* loaded from: classes2.dex */
public abstract class CacheLoader<K, V> {

    public static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final n<K, V> computingFunction;

        public FunctionToCacheLoader(n<K, V> nVar) {
            this.computingFunction = (n) u.E(nVar);
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K k10) {
            return (V) this.computingFunction.apply(u.E(k10));
        }
    }

    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }

    public static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final z<V> computingSupplier;

        public SupplierToCacheLoader(z<V> zVar) {
            this.computingSupplier = (z) u.E(zVar);
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(Object obj) {
            u.E(obj);
            return this.computingSupplier.get();
        }
    }

    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
    }

    public class a extends CacheLoader<K, V> {

        /* renamed from: c */
        public final /* synthetic */ Executor f9178c;

        /* renamed from: com.google.common.cache.CacheLoader$a$a */
        public class CallableC0265a implements Callable<V> {

            /* renamed from: b */
            public final /* synthetic */ Object f9179b;

            /* renamed from: c */
            public final /* synthetic */ Object f9180c;

            public CallableC0265a(Object obj, Object obj2) {
                this.f9179b = obj;
                this.f9180c = obj2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public V call() throws Exception {
                return CacheLoader.this.reload(this.f9179b, this.f9180c).get();
            }
        }

        public a(Executor executor) {
            this.f9178c = executor;
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K k10) throws Exception {
            return (V) CacheLoader.this.load(k10);
        }

        @Override // com.google.common.cache.CacheLoader
        public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
            return CacheLoader.this.loadAll(iterable);
        }

        @Override // com.google.common.cache.CacheLoader
        public c0<V> reload(K k10, V v10) throws Exception {
            d0 b10 = d0.b(new CallableC0265a(k10, v10));
            this.f9178c.execute(b10);
            return b10;
        }
    }

    @CheckReturnValue
    @a5.c
    public static <K, V> CacheLoader<K, V> asyncReloading(CacheLoader<K, V> cacheLoader, Executor executor) {
        u.E(cacheLoader);
        u.E(executor);
        return cacheLoader.new a(executor);
    }

    @CheckReturnValue
    public static <K, V> CacheLoader<K, V> from(n<K, V> nVar) {
        return new FunctionToCacheLoader(nVar);
    }

    public abstract V load(K k10) throws Exception;

    public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
        throw new UnsupportedLoadingOperationException();
    }

    @a5.c
    public c0<V> reload(K k10, V v10) throws Exception {
        u.E(k10);
        u.E(v10);
        return l.m(load(k10));
    }

    @CheckReturnValue
    public static <V> CacheLoader<Object, V> from(z<V> zVar) {
        return new SupplierToCacheLoader(zVar);
    }
}
