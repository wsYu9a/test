package com.martian.libmars.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.collection.LruCache;

/* loaded from: classes.dex */
public class o0 {

    /* renamed from: a */
    private static final int f10177a = 4096;

    /* renamed from: b */
    private final a f10178b;

    /* loaded from: classes2.dex */
    private static class a extends LruCache<String, BitmapDrawable> {
        public a(int maxSize) {
            super(maxSize);
        }

        @Override // androidx.collection.LruCache
        /* renamed from: e */
        public void b(boolean evicted, @NonNull String key, @NonNull BitmapDrawable oldValue, BitmapDrawable newValue) {
        }

        @Override // androidx.collection.LruCache
        /* renamed from: f */
        public int d(@NonNull String key, BitmapDrawable bd) {
            Bitmap bitmap = bd.getBitmap();
            return (bitmap.getRowBytes() * bitmap.getHeight()) / 1024;
        }
    }

    public o0(int cacheSize) {
        this.f10178b = new a(cacheSize);
    }

    public static o0 a() {
        return new o0(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8);
    }

    public BitmapDrawable b(String key) {
        return this.f10178b.get(key);
    }

    public boolean c(String url) {
        return this.f10178b.get(url) != null;
    }

    public BitmapDrawable d(String key, BitmapDrawable value) {
        if (value instanceof com.martian.libmars.widget.n) {
            ((com.martian.libmars.widget.n) value).e(true);
        }
        return this.f10178b.put(key, value);
    }

    public o0() {
        this(4096);
    }
}
