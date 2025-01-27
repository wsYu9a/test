package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;

/* loaded from: classes4.dex */
final class b implements Runnable {

    /* renamed from: a */
    private static final String f15930a = "Display image in ImageAware (loaded from %1$s) [%2$s]";

    /* renamed from: b */
    private static final String f15931b = "ImageAware is reused for another image. Task is cancelled. [%s]";

    /* renamed from: c */
    private static final String f15932c = "ImageAware was collected by GC. Task is cancelled. [%s]";

    /* renamed from: d */
    private final Bitmap f15933d;

    /* renamed from: e */
    private final String f15934e;

    /* renamed from: f */
    private final com.nostra13.universalimageloader.core.j.a f15935f;

    /* renamed from: g */
    private final String f15936g;

    /* renamed from: h */
    private final com.nostra13.universalimageloader.core.i.a f15937h;

    /* renamed from: i */
    private final com.nostra13.universalimageloader.core.k.a f15938i;

    /* renamed from: j */
    private final e f15939j;
    private final LoadedFrom k;

    public b(Bitmap bitmap, f fVar, e eVar, LoadedFrom loadedFrom) {
        this.f15933d = bitmap;
        this.f15934e = fVar.f15994a;
        this.f15935f = fVar.f15996c;
        this.f15936g = fVar.f15995b;
        this.f15937h = fVar.f15998e.w();
        this.f15938i = fVar.f15999f;
        this.f15939j = eVar;
        this.k = loadedFrom;
    }

    private boolean c() {
        return !this.f15936g.equals(this.f15939j.h(this.f15935f));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f15935f.isCollected()) {
            b.g.a.b.d.a(f15932c, this.f15936g);
            this.f15938i.onLoadingCancelled(this.f15934e, this.f15935f.getWrappedView());
        } else if (c()) {
            b.g.a.b.d.a(f15931b, this.f15936g);
            this.f15938i.onLoadingCancelled(this.f15934e, this.f15935f.getWrappedView());
        } else {
            b.g.a.b.d.a(f15930a, this.k, this.f15936g);
            this.f15937h.a(this.f15933d, this.f15935f, this.k);
            this.f15939j.d(this.f15935f);
            this.f15938i.onLoadingComplete(this.f15934e, this.f15935f.getWrappedView(), this.f15933d);
        }
    }
}
