package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;

/* loaded from: classes4.dex */
final class g implements Runnable {

    /* renamed from: a */
    private static final String f16002a = "PostProcess image before displaying [%s]";

    /* renamed from: b */
    private final e f16003b;

    /* renamed from: c */
    private final Bitmap f16004c;

    /* renamed from: d */
    private final f f16005d;

    /* renamed from: e */
    private final Handler f16006e;

    public g(e eVar, Bitmap bitmap, f fVar, Handler handler) {
        this.f16003b = eVar;
        this.f16004c = bitmap;
        this.f16005d = fVar;
        this.f16006e = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.g.a.b.d.a(f16002a, this.f16005d.f15995b);
        LoadAndDisplayImageTask.t(new b(this.f16005d.f15998e.D().process(this.f16004c), this.f16005d, this.f16003b, LoadedFrom.MEMORY_CACHE), this.f16005d.f15998e.J(), this.f16006e, this.f16003b);
    }
}
