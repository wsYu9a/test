package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class LruCache<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<K, V> f1150a;

    /* renamed from: b, reason: collision with root package name */
    private int f1151b;

    /* renamed from: c, reason: collision with root package name */
    private int f1152c;

    /* renamed from: d, reason: collision with root package name */
    private int f1153d;

    /* renamed from: e, reason: collision with root package name */
    private int f1154e;

    /* renamed from: f, reason: collision with root package name */
    private int f1155f;

    /* renamed from: g, reason: collision with root package name */
    private int f1156g;

    /* renamed from: h, reason: collision with root package name */
    private int f1157h;

    public LruCache(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f1152c = i2;
        this.f1150a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int c(K k, V v) {
        int d2 = d(k, v);
        if (d2 >= 0) {
            return d2;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    @Nullable
    protected V a(@NonNull K k) {
        return null;
    }

    protected void b(boolean z, @NonNull K k, @NonNull V v, @Nullable V v2) {
    }

    public final synchronized int createCount() {
        return this.f1154e;
    }

    protected int d(@NonNull K k, @NonNull V v) {
        return 1;
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int evictionCount() {
        return this.f1155f;
    }

    @Nullable
    public final V get(@NonNull K k) {
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v2 = this.f1150a.get(k);
            if (v2 != null) {
                this.f1156g++;
                return v2;
            }
            this.f1157h++;
            V a2 = a(k);
            if (a2 == null) {
                return null;
            }
            synchronized (this) {
                this.f1154e++;
                v = (V) this.f1150a.put(k, a2);
                if (v != null) {
                    this.f1150a.put(k, v);
                } else {
                    this.f1151b += c(k, a2);
                }
            }
            if (v != null) {
                b(false, k, a2, v);
                return v;
            }
            trimToSize(this.f1152c);
            return a2;
        }
    }

    public final synchronized int hitCount() {
        return this.f1156g;
    }

    public final synchronized int maxSize() {
        return this.f1152c;
    }

    public final synchronized int missCount() {
        return this.f1157h;
    }

    @Nullable
    public final V put(@NonNull K k, @NonNull V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f1153d++;
            this.f1151b += c(k, v);
            put = this.f1150a.put(k, v);
            if (put != null) {
                this.f1151b -= c(k, put);
            }
        }
        if (put != null) {
            b(false, k, put, v);
        }
        trimToSize(this.f1152c);
        return put;
    }

    public final synchronized int putCount() {
        return this.f1153d;
    }

    @Nullable
    public final V remove(@NonNull K k) {
        V remove;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            remove = this.f1150a.remove(k);
            if (remove != null) {
                this.f1151b -= c(k, remove);
            }
        }
        if (remove != null) {
            b(false, k, remove, null);
        }
        return remove;
    }

    public void resize(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.f1152c = i2;
        }
        trimToSize(i2);
    }

    public final synchronized int size() {
        return this.f1151b;
    }

    public final synchronized Map<K, V> snapshot() {
        return new LinkedHashMap(this.f1150a);
    }

    public final synchronized String toString() {
        int i2;
        int i3;
        i2 = this.f1156g;
        i3 = this.f1157h + i2;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f1152c), Integer.valueOf(this.f1156g), Integer.valueOf(this.f1157h), Integer.valueOf(i3 != 0 ? (i2 * 100) / i3 : 0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0070, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void trimToSize(int r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            int r0 = r4.f1151b     // Catch: java.lang.Throwable -> L71
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<K, V> r0 = r4.f1150a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L11
            int r0 = r4.f1151b     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L52
        L11:
            int r0 = r4.f1151b     // Catch: java.lang.Throwable -> L71
            if (r0 <= r5) goto L50
            java.util.LinkedHashMap<K, V> r0 = r4.f1150a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L1e
            goto L50
        L1e:
            java.util.LinkedHashMap<K, V> r0 = r4.f1150a     // Catch: java.lang.Throwable -> L71
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L71
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L71
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L71
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L71
            java.util.LinkedHashMap<K, V> r2 = r4.f1150a     // Catch: java.lang.Throwable -> L71
            r2.remove(r1)     // Catch: java.lang.Throwable -> L71
            int r2 = r4.f1151b     // Catch: java.lang.Throwable -> L71
            int r3 = r4.c(r1, r0)     // Catch: java.lang.Throwable -> L71
            int r2 = r2 - r3
            r4.f1151b = r2     // Catch: java.lang.Throwable -> L71
            int r2 = r4.f1155f     // Catch: java.lang.Throwable -> L71
            r3 = 1
            int r2 = r2 + r3
            r4.f1155f = r2     // Catch: java.lang.Throwable -> L71
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            r2 = 0
            r4.b(r3, r1, r0, r2)
            goto L0
        L50:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            return
        L52:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r0.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.Class r1 = r4.getClass()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L71
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L71
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L71
            throw r5     // Catch: java.lang.Throwable -> L71
        L71:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            goto L75
        L74:
            throw r5
        L75:
            goto L74
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LruCache.trimToSize(int):void");
    }
}
