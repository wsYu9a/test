package com.vivo.mobilead.util;

/* loaded from: classes4.dex */
public class e0 {
    public static boolean a() {
        if (!h()) {
            return false;
        }
        try {
            Class.forName("com.qq.e.ads.banner2.UnifiedBannerView");
            if (com.vivo.mobilead.manager.f.j().d().isGdt()) {
                return com.vivo.mobilead.manager.f.j().d().isThird();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean b() {
        if (!h()) {
            return false;
        }
        try {
            Class.forName("com.qq.e.comm.managers.GDTADManager");
            if (com.vivo.mobilead.manager.f.j().d().isGdt()) {
                return com.vivo.mobilead.manager.f.j().d().isThird();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean c() {
        if (!h()) {
            return false;
        }
        try {
            Class.forName("com.qq.e.ads.interstitial2.UnifiedInterstitialAD");
            if (com.vivo.mobilead.manager.f.j().d().isGdt()) {
                return com.vivo.mobilead.manager.f.j().d().isThird();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean d() {
        if (!h()) {
            return false;
        }
        try {
            Class.forName("com.qq.e.ads.nativ.NativeUnifiedAD");
            Class.forName("com.qq.e.ads.nativ.NativeUnifiedADData");
            if (com.vivo.mobilead.manager.f.j().d().isGdt()) {
                return com.vivo.mobilead.manager.f.j().d().isThird();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean e() {
        if (!h()) {
            return false;
        }
        try {
            Class.forName("com.qq.e.ads.nativ.NativeExpressAD");
            Class.forName("com.qq.e.ads.nativ.NativeExpressADView");
            if (com.vivo.mobilead.manager.f.j().d().isGdt()) {
                return com.vivo.mobilead.manager.f.j().d().isThird();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean f() {
        if (!h()) {
            return false;
        }
        try {
            Class.forName("com.qq.e.ads.rewardvideo.RewardVideoAD");
            if (com.vivo.mobilead.manager.f.j().d().isGdt()) {
                return com.vivo.mobilead.manager.f.j().d().isThird();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean g() {
        if (!h()) {
            return false;
        }
        try {
            Class.forName("com.qq.e.ads.splash.SplashAD");
            if (com.vivo.mobilead.manager.f.j().d().isGdt()) {
                return com.vivo.mobilead.manager.f.j().d().isThird();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static boolean h() {
        try {
            Class.forName("com.qq.e.comm.managers.status.SDKStatus");
            return com.vivo.mobilead.util.e1.a.a();
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean i() {
        try {
            Class.forName("com.kwad.sdk.api.KsAdSDK");
            return com.vivo.mobilead.util.e1.b.a();
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean j() {
        try {
            Class.forName("com.bytedance.sdk.openadsdk.TTAdSdk");
            return com.vivo.mobilead.util.e1.c.a();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean k() {
        try {
            Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean l() {
        if (!i()) {
            return false;
        }
        try {
            Class.forName("com.kwad.sdk.api.KsAdSDK");
            Class.forName("com.kwad.sdk.api.KsLoadManager");
            if (com.vivo.mobilead.manager.f.j().d().isKs()) {
                return com.vivo.mobilead.manager.f.j().d().isThird();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean m() {
        if (!i()) {
            return false;
        }
        try {
            Class.forName("com.kwad.sdk.api.KsFullScreenVideoAd");
            if (com.vivo.mobilead.manager.f.j().d().isKs()) {
                return com.vivo.mobilead.manager.f.j().d().isThird();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean n() {
        if (!i()) {
            return false;
        }
        try {
            Class.forName("com.kwad.sdk.api.KsNativeAd");
            if (com.vivo.mobilead.manager.f.j().d().isKs()) {
                return com.vivo.mobilead.manager.f.j().d().isThird();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean o() {
        if (!i()) {
            return false;
        }
        try {
            Class.forName("com.kwad.sdk.api.KsFeedAd");
            if (com.vivo.mobilead.manager.f.j().d().isKs()) {
                return com.vivo.mobilead.manager.f.j().d().isThird();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean p() {
        if (!i()) {
            return false;
        }
        try {
            Class.forName("com.kwad.sdk.api.KsRewardVideoAd");
            if (com.vivo.mobilead.manager.f.j().d().isKs()) {
                return com.vivo.mobilead.manager.f.j().d().isThird();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean q() {
        if (!i()) {
            return false;
        }
        try {
            Class.forName("com.kwad.sdk.api.KsSplashScreenAd");
            if (com.vivo.mobilead.manager.f.j().d().isKs()) {
                return com.vivo.mobilead.manager.f.j().d().isThird();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean r() {
        if (!j()) {
            return false;
        }
        try {
            Class.forName("com.bytedance.sdk.openadsdk.TTNativeExpressAd");
            if (com.vivo.mobilead.manager.f.j().d().isTt()) {
                return com.vivo.mobilead.manager.f.j().d().isThird();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean s() {
        if (!j()) {
            return false;
        }
        try {
            Class.forName("com.bytedance.sdk.openadsdk.TTAdManager");
            Class.forName("com.bytedance.sdk.openadsdk.TTAdSdk");
            if (com.vivo.mobilead.manager.f.j().d().isTt()) {
                return com.vivo.mobilead.manager.f.j().d().isThird();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean t() {
        if (!j()) {
            return false;
        }
        try {
            Class.forName("com.bytedance.sdk.openadsdk.TTNativeExpressAd");
            Class.forName("com.bytedance.sdk.openadsdk.TTFullScreenVideoAd");
            if (com.vivo.mobilead.manager.f.j().d().isTt()) {
                return com.vivo.mobilead.manager.f.j().d().isThird();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean u() {
        if (!j()) {
            return false;
        }
        try {
            Class.forName("com.bytedance.sdk.openadsdk.TTFeedAd");
            if (com.vivo.mobilead.manager.f.j().d().isTt()) {
                return com.vivo.mobilead.manager.f.j().d().isThird();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean v() {
        if (!j()) {
            return false;
        }
        try {
            Class.forName("com.bytedance.sdk.openadsdk.TTNativeExpressAd");
            if (com.vivo.mobilead.manager.f.j().d().isTt()) {
                return com.vivo.mobilead.manager.f.j().d().isThird();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean w() {
        if (!j()) {
            return false;
        }
        try {
            Class.forName("com.bytedance.sdk.openadsdk.TTRewardVideoAd");
            if (com.vivo.mobilead.manager.f.j().d().isTt()) {
                return com.vivo.mobilead.manager.f.j().d().isThird();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean x() {
        if (!j()) {
            return false;
        }
        try {
            Class.forName("com.bytedance.sdk.openadsdk.TTSplashAd");
            if (com.vivo.mobilead.manager.f.j().d().isTt()) {
                return com.vivo.mobilead.manager.f.j().d().isThird();
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
