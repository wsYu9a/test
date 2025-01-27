package com.sigmob.sdk.nativead;

import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class r implements q {

    /* renamed from: a */
    public WeakReference<com.sigmob.sdk.videoplayer.g> f20033a;

    /* renamed from: b */
    public i f20034b;

    public r(com.sigmob.sdk.videoplayer.g gVar) {
        this.f20033a = new WeakReference<>(gVar);
    }

    @Override // com.sigmob.sdk.nativead.q
    public int a() {
        com.sigmob.sdk.videoplayer.g g10 = g();
        if (g10 == null || g10.getDuration() == 0) {
            return 0;
        }
        return (int) (g10.getDuration() / 1000);
    }

    @Override // com.sigmob.sdk.nativead.q
    public void b() {
        com.sigmob.sdk.videoplayer.g g10 = g();
        if (g10 != null) {
            g10.v();
        }
    }

    @Override // com.sigmob.sdk.nativead.q
    public int c() {
        com.sigmob.sdk.videoplayer.g g10 = g();
        if (g10 == null || g10.getCurrentPositionWhenPlaying() == 0) {
            return 0;
        }
        return (int) ((g10.getCurrentPositionWhenPlaying() * 100) / g10.getDuration());
    }

    @Override // com.sigmob.sdk.nativead.q
    public void d() {
        com.sigmob.sdk.videoplayer.g g10 = g();
        if (g10 != null) {
            g10.l();
        }
    }

    @Override // com.sigmob.sdk.nativead.q
    public void destroy() {
        this.f20033a.clear();
        this.f20034b = null;
    }

    @Override // com.sigmob.sdk.nativead.q
    public void e() {
        com.sigmob.sdk.videoplayer.g g10 = g();
        if (g10 != null) {
            g10.C();
        }
    }

    @Override // com.sigmob.sdk.nativead.q
    public i f() {
        return this.f20034b;
    }

    public final com.sigmob.sdk.videoplayer.g g() {
        return this.f20033a.get();
    }

    @Override // com.sigmob.sdk.nativead.q
    public int getCurrentPosition() {
        com.sigmob.sdk.videoplayer.g g10 = g();
        if (g10 != null) {
            return (int) (g10.getCurrentPositionWhenPlaying() / 1000);
        }
        return 0;
    }

    @Override // com.sigmob.sdk.nativead.q
    public void pause() {
        com.sigmob.sdk.videoplayer.g g10 = g();
        if (g10 != null) {
            g10.k();
        }
    }

    @Override // com.sigmob.sdk.nativead.q
    public void start() {
        com.sigmob.sdk.videoplayer.g g10 = g();
        if (g10 != null) {
            g10.l();
        }
    }

    @Override // com.sigmob.sdk.nativead.q
    public void a(i iVar) {
        this.f20034b = iVar;
    }

    public void a(int i10) {
        com.sigmob.sdk.videoplayer.g g10 = g();
        if (g10 != null) {
            g10.setHolderImageResource(i10);
        }
    }

    @Override // com.sigmob.sdk.nativead.q
    public void a(boolean z10) {
        com.sigmob.sdk.videoplayer.g g10 = g();
        if (g10 != null) {
            g10.setSoundChange(z10);
        }
    }
}
