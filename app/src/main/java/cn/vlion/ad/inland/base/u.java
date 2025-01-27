package cn.vlion.ad.inland.base;

import android.graphics.Bitmap;
import android.util.LruCache;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: b */
    public static u f3389b;

    /* renamed from: a */
    public a f3390a;

    public class a extends LruCache {
        public a(int i10) {
            super(i10);
        }

        @Override // android.util.LruCache
        public final int sizeOf(Object obj, Object obj2) {
            return super.sizeOf(obj, obj2);
        }
    }

    public u() {
        try {
            this.f3390a = new a(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8);
        } catch (Throwable th2) {
            s4.a("HttpUrlBitmapCache:", th2);
        }
    }

    public static u b() {
        if (f3389b == null) {
            f3389b = new u();
        }
        return f3389b;
    }

    public final void a() {
        try {
            a aVar = this.f3390a;
            if (aVar != null) {
                aVar.evictAll();
            }
        } catch (Throwable th2) {
            s4.a("putBitmap:", th2);
        }
    }

    public final Bitmap a(String str) {
        try {
            a aVar = this.f3390a;
            if (aVar != null) {
                return (Bitmap) aVar.get(str);
            }
            return null;
        } catch (Throwable th2) {
            s4.a("getBitmap:", th2);
            return null;
        }
    }

    public final void a(String str, Bitmap bitmap) {
        try {
            a aVar = this.f3390a;
            if (aVar != null) {
                aVar.put(str, bitmap);
            }
        } catch (Throwable th2) {
            s4.a("putBitmap:", th2);
        }
    }
}
