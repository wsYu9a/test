package b.g.a.a.b.e;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* loaded from: classes4.dex */
public class f implements b.g.a.a.b.c {

    /* renamed from: a */
    private final LinkedHashMap<String, Bitmap> f4906a;

    /* renamed from: b */
    private final int f4907b;

    /* renamed from: c */
    private int f4908c;

    public f(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f4907b = i2;
        this.f4906a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int d(String str, Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x006e, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.f4908c     // Catch: java.lang.Throwable -> L6f
            if (r0 < 0) goto L50
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f4906a     // Catch: java.lang.Throwable -> L6f
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L11
            int r0 = r3.f4908c     // Catch: java.lang.Throwable -> L6f
            if (r0 != 0) goto L50
        L11:
            int r0 = r3.f4908c     // Catch: java.lang.Throwable -> L6f
            if (r0 <= r4) goto L4e
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f4906a     // Catch: java.lang.Throwable -> L6f
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L1e
            goto L4e
        L1e:
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f4906a     // Catch: java.lang.Throwable -> L6f
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L6f
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L6f
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L6f
            if (r0 != 0) goto L32
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L6f
            goto L4f
        L32:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L6f
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch: java.lang.Throwable -> L6f
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r2 = r3.f4906a     // Catch: java.lang.Throwable -> L6f
            r2.remove(r1)     // Catch: java.lang.Throwable -> L6f
            int r2 = r3.f4908c     // Catch: java.lang.Throwable -> L6f
            int r0 = r3.d(r1, r0)     // Catch: java.lang.Throwable -> L6f
            int r2 = r2 - r0
            r3.f4908c = r2     // Catch: java.lang.Throwable -> L6f
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L6f
            goto L0
        L4e:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L6f
        L4f:
            return
        L50:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L6f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6f
            r0.<init>()     // Catch: java.lang.Throwable -> L6f
            java.lang.Class r1 = r3.getClass()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L6f
            r0.append(r1)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L6f
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L6f
            throw r4     // Catch: java.lang.Throwable -> L6f
        L6f:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L6f
            goto L73
        L72:
            throw r4
        L73:
            goto L72
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.a.a.b.e.f.e(int):void");
    }

    @Override // b.g.a.a.b.d
    /* renamed from: a */
    public final Bitmap get(String str) {
        Bitmap bitmap;
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            bitmap = this.f4906a.get(str);
        }
        return bitmap;
    }

    @Override // b.g.a.a.b.d
    /* renamed from: b */
    public final boolean put(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f4908c += d(str, bitmap);
            Bitmap put = this.f4906a.put(str, bitmap);
            if (put != null) {
                this.f4908c -= d(str, put);
            }
        }
        e(this.f4907b);
        return true;
    }

    @Override // b.g.a.a.b.d
    /* renamed from: c */
    public final Bitmap remove(String str) {
        Bitmap remove;
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            remove = this.f4906a.remove(str);
            if (remove != null) {
                this.f4908c -= d(str, remove);
            }
        }
        return remove;
    }

    @Override // b.g.a.a.b.d
    public void clear() {
        e(-1);
    }

    @Override // b.g.a.a.b.d
    public Collection<String> keys() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f4906a.keySet());
        }
        return hashSet;
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.f4907b));
    }
}
