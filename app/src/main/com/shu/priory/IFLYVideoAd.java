package com.shu.priory;

import android.content.Context;
import android.view.ViewGroup;
import com.shu.priory.i.a;
import com.shu.priory.listener.IFLYVideoListener;

/* loaded from: classes3.dex */
public class IFLYVideoAd {
    public static final int FULLSCREEN_VIDEO_AD = 1;
    public static final int LANDSCAPE = 0;
    public static final int NATIVE_VIDEO_AD = 0;
    public static final int PORTRAIT = 1;

    /* renamed from: a */
    private final a f16790a;

    public IFLYVideoAd(Context context, String str, int i10, IFLYVideoListener iFLYVideoListener) {
        this.f16790a = new a(context, str, i10, iFLYVideoListener);
    }

    public boolean backPressed() {
        return this.f16790a.j();
    }

    public void cacheVideo() {
        this.f16790a.c();
    }

    public ViewGroup getVideoView() {
        return this.f16790a.m();
    }

    public boolean isPlaying() {
        return this.f16790a.i();
    }

    public void loadAd() {
        this.f16790a.b();
    }

    public void onPause() {
        this.f16790a.g();
    }

    public void onResume() {
        this.f16790a.h();
    }

    public void release() {
        this.f16790a.e();
    }

    public void setDirectJump(boolean z10) {
        this.f16790a.c(z10);
    }

    public void setParameter(String str, Object obj) {
        this.f16790a.a(str, obj);
    }

    public void setVolume(boolean z10) {
        this.f16790a.a(z10);
    }

    public void setWifiTip(boolean z10) {
        this.f16790a.b(z10);
    }

    public void showAd(Object... objArr) {
        this.f16790a.a(objArr);
    }

    public void skipAd() {
        this.f16790a.f();
    }

    public void startPlay() {
        this.f16790a.d();
    }

    public void videoDownScroll() {
        this.f16790a.l();
    }

    public void videoUpScroll() {
        this.f16790a.k();
    }
}
