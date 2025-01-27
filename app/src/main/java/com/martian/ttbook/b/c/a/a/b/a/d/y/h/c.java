package com.martian.ttbook.b.c.a.a.b.a.d.y.h;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.martian.ttbook.b.c.a.a.d.b.i;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    protected com.martian.ttbook.b.c.a.a.b.a.d.y.h.a f15538a;

    /* renamed from: b */
    private TTSplashAd f15539b;

    class a implements TTAdNative.SplashAdListener {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i2, String str) {
            c.this.f15538a.a(new i(i2, str));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        public void onSplashAdLoad(TTSplashAd tTSplashAd) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJSPTAG_V1", "onSplashAdLoad");
            c.this.f15539b = tTSplashAd;
            c cVar = c.this;
            cVar.f15538a.a(cVar.f15539b);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        public void onTimeout() {
            c.this.f15538a.a(new i(10006, "广告拉取超时"));
        }
    }

    class b implements TTSplashAd.AdInteractionListener {
        b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdClicked(View view, int i2) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJSPTAG_V1", "onAdClicked");
            c.this.f15538a.onAdClicked();
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdShow(View view, int i2) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJSPTAG_V1", "onAdShow");
            c.this.f15538a.onAdExposure();
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdSkip() {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJSPTAG_V1", "onAdSkip");
            c.this.f15538a.onAdClosed();
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdTimeOver() {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJSPTAG_V1", "onAdTimeOver");
            c.this.f15538a.onAdClosed();
        }
    }

    public c(com.martian.ttbook.b.c.a.a.b.a.d.y.h.a aVar) {
        this.f15538a = aVar;
    }

    public void c(ViewGroup viewGroup) {
        TTSplashAd tTSplashAd;
        com.martian.ttbook.b.c.a.a.e.d.g("CSJSPTAG_V1", "showAd");
        if (viewGroup == null || (tTSplashAd = this.f15539b) == null) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJSPTAG_V1", "showAd return ");
            return;
        }
        tTSplashAd.setNotAllowSdkCountdown();
        viewGroup.addView(this.f15539b.getSplashView());
        this.f15539b.setSplashInteractionListener(new b());
    }

    public void d(TTAdNative tTAdNative, AdSlot adSlot, int i2) {
        com.martian.ttbook.b.c.a.a.e.d.g("CSJSPTAG_V1", "loadAd");
        tTAdNative.loadSplashAd(adSlot, new a(), i2);
    }
}
