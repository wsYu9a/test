package l9;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.collection.LruCache;

/* loaded from: classes3.dex */
public class n0 {

    /* renamed from: b */
    public static final int f28025b = 4096;

    /* renamed from: a */
    public final a f28026a;

    public n0(int i10) {
        this.f28026a = new a(i10);
    }

    public static n0 a() {
        return new n0(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8);
    }

    public BitmapDrawable b(String str) {
        return this.f28026a.get(str);
    }

    public boolean c(String str) {
        return this.f28026a.get(str) != null;
    }

    public BitmapDrawable d(String str, BitmapDrawable bitmapDrawable) {
        if (bitmapDrawable instanceof n9.o) {
            ((n9.o) bitmapDrawable).e(true);
        }
        return this.f28026a.put(str, bitmapDrawable);
    }

    public n0() {
        this(4096);
    }

    public static class a extends LruCache<String, BitmapDrawable> {
        public a(int i10) {
            super(i10);
        }

        @Override // androidx.collection.LruCache
        /* renamed from: b */
        public int sizeOf(@NonNull String str, BitmapDrawable bitmapDrawable) {
            Bitmap bitmap = bitmapDrawable.getBitmap();
            return (bitmap.getRowBytes() * bitmap.getHeight()) / 1024;
        }

        @Override // androidx.collection.LruCache
        /* renamed from: a */
        public void entryRemoved(boolean z10, @NonNull String str, @NonNull BitmapDrawable bitmapDrawable, BitmapDrawable bitmapDrawable2) {
        }
    }
}
