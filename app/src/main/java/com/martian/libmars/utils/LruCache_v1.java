package com.martian.libmars.utils;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class LruCache_v1<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<K, V> f10109a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<K, a<K, V>> f10110b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private ReferenceQueue<V> f10111c = new ReferenceQueue<>();

    /* renamed from: d, reason: collision with root package name */
    private b<K, V> f10112d = null;

    private static class a<K, V> extends WeakReference<V> {

        /* renamed from: a, reason: collision with root package name */
        K f10113a;

        public a(K key, V value, ReferenceQueue<V> queue) {
            super(value, queue);
            this.f10113a = key;
        }
    }

    public interface b<K, V> {
        void a(Map.Entry<K, V> eldest);
    }

    public LruCache_v1(final int capacity) {
        this.f10109a = new LinkedHashMap<K, V>(16, 0.75f, true) { // from class: com.martian.libmars.utils.LruCache_v1.1
            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                int size = size();
                int i2 = capacity;
                boolean z = size > i2 && i2 != -1;
                if (z && LruCache_v1.this.f10112d != null) {
                    LruCache_v1.this.f10112d.a(eldest);
                }
                return z;
            }
        };
    }

    private void b() {
        a aVar = (a) this.f10111c.poll();
        while (aVar != null) {
            this.f10110b.remove(aVar.f10113a);
            aVar = (a) this.f10111c.poll();
        }
    }

    public synchronized void c() {
        this.f10109a.clear();
        this.f10110b.clear();
        this.f10111c = new ReferenceQueue<>();
    }

    public synchronized V d(K key) {
        b();
        V v = this.f10109a.get(key);
        if (v != null) {
            return v;
        }
        a<K, V> aVar = this.f10110b.get(key);
        return aVar == null ? null : aVar.get();
    }

    public synchronized V e(K key, V value) {
        a<K, V> put;
        b();
        this.f10109a.put(key, value);
        put = this.f10110b.put(key, new a<>(key, value, this.f10111c));
        return put == null ? null : put.get();
    }

    public void f(b<K, V> l) {
        this.f10112d = l;
    }
}
