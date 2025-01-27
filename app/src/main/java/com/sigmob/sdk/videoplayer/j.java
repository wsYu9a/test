package com.sigmob.sdk.videoplayer;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView;

/* loaded from: classes4.dex */
public abstract class j implements TextureView.SurfaceTextureListener {

    /* renamed from: a */
    public SurfaceTexture f20801a;

    /* renamed from: b */
    public Handler f20802b;

    /* renamed from: c */
    public Handler f20803c;

    /* renamed from: d */
    public i f20804d;

    public j(i iVar) {
        this.f20804d = iVar;
    }

    public abstract long a();

    public abstract void a(float f10);

    public abstract void a(long j10);

    public abstract void a(Surface surface);

    public abstract void a(boolean z10);

    public abstract long b();

    public abstract void b(float f10);

    public abstract int c();

    public abstract int d();

    public abstract boolean e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract void j();
}
