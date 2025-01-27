package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import d5.d;
import d5.h;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@a5.b
@d
/* loaded from: classes2.dex */
public abstract class a<K, V> implements d5.b<K, V> {

    /* renamed from: com.google.common.cache.a$a */
    public static final class C0266a implements b {

        /* renamed from: a */
        public final h f9295a = LongAddables.a();

        /* renamed from: b */
        public final h f9296b = LongAddables.a();

        /* renamed from: c */
        public final h f9297c = LongAddables.a();

        /* renamed from: d */
        public final h f9298d = LongAddables.a();

        /* renamed from: e */
        public final h f9299e = LongAddables.a();

        /* renamed from: f */
        public final h f9300f = LongAddables.a();

        public static long h(long j10) {
            if (j10 >= 0) {
                return j10;
            }
            return Long.MAX_VALUE;
        }

        @Override // com.google.common.cache.a.b
        public void a(int i10) {
            this.f9295a.add(i10);
        }

        @Override // com.google.common.cache.a.b
        public void b(int i10) {
            this.f9296b.add(i10);
        }

        @Override // com.google.common.cache.a.b
        public void c() {
            this.f9300f.increment();
        }

        @Override // com.google.common.cache.a.b
        public void d(long j10) {
            this.f9298d.increment();
            this.f9299e.add(j10);
        }

        @Override // com.google.common.cache.a.b
        public void e(long j10) {
            this.f9297c.increment();
            this.f9299e.add(j10);
        }

        @Override // com.google.common.cache.a.b
        public d5.c f() {
            return new d5.c(h(this.f9295a.sum()), h(this.f9296b.sum()), h(this.f9297c.sum()), h(this.f9298d.sum()), h(this.f9299e.sum()), h(this.f9300f.sum()));
        }

        public void g(b bVar) {
            d5.c f10 = bVar.f();
            this.f9295a.add(f10.c());
            this.f9296b.add(f10.j());
            this.f9297c.add(f10.h());
            this.f9298d.add(f10.f());
            this.f9299e.add(f10.n());
            this.f9300f.add(f10.b());
        }
    }

    public interface b {
        void a(int i10);

        void b(int i10);

        void c();

        void d(long j10);

        void e(long j10);

        d5.c f();
    }

    @Override // d5.b
    public ConcurrentMap<K, V> asMap() {
        throw new UnsupportedOperationException();
    }

    @Override // d5.b
    public void cleanUp() {
    }

    @Override // d5.b
    public V get(K k10, Callable<? extends V> callable) throws ExecutionException {
        throw new UnsupportedOperationException();
    }

    @Override // d5.b
    public ImmutableMap<K, V> getAllPresent(Iterable<? extends Object> iterable) {
        V ifPresent;
        LinkedHashMap c02 = Maps.c0();
        for (Object obj : iterable) {
            if (!c02.containsKey(obj) && (ifPresent = getIfPresent(obj)) != null) {
                c02.put(obj, ifPresent);
            }
        }
        return ImmutableMap.copyOf((Map) c02);
    }

    @Override // d5.b
    public void invalidate(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // d5.b
    public void invalidateAll(Iterable<? extends Object> iterable) {
        Iterator<? extends Object> it = iterable.iterator();
        while (it.hasNext()) {
            invalidate(it.next());
        }
    }

    @Override // d5.b
    public void put(K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // d5.b
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // d5.b
    public long size() {
        throw new UnsupportedOperationException();
    }

    @Override // d5.b
    public d5.c stats() {
        throw new UnsupportedOperationException();
    }

    @Override // d5.b
    public void invalidateAll() {
        throw new UnsupportedOperationException();
    }
}
