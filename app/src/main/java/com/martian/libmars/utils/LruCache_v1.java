package com.martian.libmars.utils;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class LruCache_v1<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap<K, V> f12395a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<K, a<K, V>> f12396b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public ReferenceQueue<V> f12397c = new ReferenceQueue<>();

    /* renamed from: d, reason: collision with root package name */
    public b<K, V> f12398d = null;

    public static class a<K, V> extends WeakReference<V> {

        /* renamed from: a, reason: collision with root package name */
        public K f12399a;

        public a(K k10, V v10, ReferenceQueue<V> referenceQueue) {
            super(v10, referenceQueue);
            this.f12399a = k10;
        }
    }

    public interface b<K, V> {
        void a(Map.Entry<K, V> entry);
    }

    public LruCache_v1(final int i10) {
        this.f12395a = new LinkedHashMap<K, V>(16, 0.75f, true) { // from class: com.martian.libmars.utils.LruCache_v1.1
            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<K, V> entry) {
                int size = size();
                int i11 = i10;
                boolean z10 = size > i11 && i11 != -1;
                if (z10 && LruCache_v1.this.f12398d != null) {
                    LruCache_v1.this.f12398d.a(entry);
                }
                return z10;
            }
        };
    }

    public final void b() {
        a aVar = (a) this.f12397c.poll();
        while (aVar != null) {
            this.f12396b.remove(aVar.f12399a);
            aVar = (a) this.f12397c.poll();
        }
    }

    public synchronized void c() {
        this.f12395a.clear();
        this.f12396b.clear();
        this.f12397c = new ReferenceQueue<>();
    }

    public synchronized V d(K k10) {
        b();
        V v10 = this.f12395a.get(k10);
        if (v10 != null) {
            return v10;
        }
        a<K, V> aVar = this.f12396b.get(k10);
        return aVar == null ? null : aVar.get();
    }

    public synchronized V e(K k10, V v10) {
        a<K, V> put;
        b();
        this.f12395a.put(k10, v10);
        put = this.f12396b.put(k10, new a<>(k10, v10, this.f12397c));
        return put == null ? null : put.get();
    }

    public void f(b<K, V> bVar) {
        this.f12398d = bVar;
    }
}
