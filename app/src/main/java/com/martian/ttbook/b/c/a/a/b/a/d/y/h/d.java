package com.martian.ttbook.b.c.a.a.b.a.d.y.h;

import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.martian.ttbook.b.c.a.a.d.b.i;

/* loaded from: classes4.dex */
public class d extends c {

    /* renamed from: c */
    private CSJSplashAd f15542c;

    class a implements TTAdNative.CSJSplashAdListener {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashLoadFail(CSJAdError cSJAdError) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJSPTAG_V2", "onSplashLoadFail");
            d.this.f15538a.a(new i(cSJAdError.getCode(), cSJAdError.getMsg()));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashLoadSuccess() {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJSPTAG_V2", "onSplashLoadSuccess");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJSPTAG_V2", "onSplashRenderFail");
            d.this.f15538a.a(new i(cSJAdError.getCode(), cSJAdError.getMsg()));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJSPTAG_V2", "onSplashRenderSuccess");
            d.this.f15542c = cSJSplashAd;
            d dVar = d.this;
            dVar.f15538a.a(dVar.f15542c);
        }
    }

    class b implements CSJSplashAd.SplashAdListener {
        b() {
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
        public void onSplashAdClick(CSJSplashAd cSJSplashAd) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJSPTAG_V2", "onAdClicked");
            d.this.f15538a.onAdClicked();
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
        public void onSplashAdClose(CSJSplashAd cSJSplashAd, int i2) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJSPTAG_V2", "onAdClosed");
            d.this.f15538a.onAdClosed();
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
        public void onSplashAdShow(CSJSplashAd cSJSplashAd) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJSPTAG_V2", "onSplashAdShow");
            d.this.f15538a.onAdExposure();
        }
    }

    public d(com.martian.ttbook.b.c.a.a.b.a.d.y.h.a aVar) {
        super(aVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.h.c
    public void c(ViewGroup viewGroup) {
        CSJSplashAd cSJSplashAd;
        com.martian.ttbook.b.c.a.a.e.d.g("CSJSPTAG_V2", "showAd");
        if (viewGroup == null || (cSJSplashAd = this.f15542c) == null) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJSPTAG_V2", "showAd return ");
            return;
        }
        cSJSplashAd.hideSkipButton();
        viewGroup.addView(this.f15542c.getSplashView());
        this.f15542c.setSplashAdListener(new b());
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.h.c
    public void d(TTAdNative tTAdNative, AdSlot adSlot, int i2) {
        com.martian.ttbook.b.c.a.a.e.d.g("CSJSPTAG_V2", "load");
        tTAdNative.loadSplashAd(adSlot, new a(), i2);
    }
}
