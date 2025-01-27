package com.vivo.mobilead.lottie.c;

import android.util.LruCache;
import com.vivo.mobilead.lottie.LottieComposition;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: a */
    private static final g f29396a = new g();

    /* renamed from: b */
    private final LruCache<String, LottieComposition> f29397b = new LruCache<>(20);

    g() {
    }

    public static g a() {
        return f29396a;
    }

    public LottieComposition a(String str) {
        if (str == null) {
            return null;
        }
        return this.f29397b.get(str);
    }

    public void a(int i2) {
        this.f29397b.resize(i2);
    }

    public void a(String str, LottieComposition lottieComposition) {
        if (str == null) {
            return;
        }
        this.f29397b.put(str, lottieComposition);
    }
}
