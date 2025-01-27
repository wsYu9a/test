package cn.vlion.ad.inland.base;

import android.util.LruCache;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: b */
    public static v f3418b;

    /* renamed from: a */
    public a f3419a;

    public class a extends LruCache {
        public a(int i10) {
            super(i10);
        }

        @Override // android.util.LruCache
        public final int sizeOf(Object obj, Object obj2) {
            return super.sizeOf(obj, obj2);
        }
    }

    public v() {
        try {
            this.f3419a = new a(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 16);
        } catch (Throwable th2) {
            s4.a("HttpUrlBitmapCache:", th2);
        }
    }

    public static v a() {
        if (f3418b == null) {
            f3418b = new v();
        }
        return f3418b;
    }

    public final k5 a(String str) {
        try {
            return (k5) this.f3419a.get(str);
        } catch (Throwable th2) {
            s4.a("getBitmap:", th2);
            return null;
        }
    }

    public final void a(String str, k5 k5Var) {
        try {
            a aVar = this.f3419a;
            if (aVar != null) {
                aVar.put(str, k5Var);
            }
        } catch (Throwable th2) {
            s4.a("putDrawable:", th2);
        }
    }
}
