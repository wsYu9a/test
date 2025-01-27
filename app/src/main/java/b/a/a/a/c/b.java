package b.a.a.a.c;

import b.a.a.a.c.d.b.d;
import b.a.a.a.c.d.b.e;
import b.a.a.a.c.d.b.f;
import b.a.a.a.c.d.b.g;
import b.a.a.a.c.d.b.h;
import b.a.a.a.c.d.b.i;
import b.a.a.a.c.d.b.j;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.vivo.mobilead.util.k0;

/* loaded from: classes.dex */
public class b implements TTAdNative {

    /* renamed from: a */
    private final TTAdNative f4164a;

    public b(TTAdNative tTAdNative) {
        this.f4164a = tTAdNative;
    }

    public void a(AdSlot adSlot, TTAdNative.BannerAdListener bannerAdListener) {
        k0.c(adSlot.getCodeId(), 5);
        this.f4164a.loadBannerAd(adSlot, new b.a.a.a.c.d.b.b(bannerAdListener, adSlot.getCodeId(), 5));
    }

    public void b(AdSlot adSlot, TTAdNative.InteractionAdListener interactionAdListener) {
        k0.c(adSlot.getCodeId(), 6);
        this.f4164a.loadInteractionAd(adSlot, new f(interactionAdListener, adSlot.getCodeId(), 6));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        k0.c(adSlot.getCodeId(), 12);
        this.f4164a.loadBannerExpressAd(adSlot, new h(nativeExpressAdListener, adSlot.getCodeId(), 12));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        k0.c(adSlot.getCodeId(), 3);
        this.f4164a.loadDrawFeedAd(adSlot, new b.a.a.a.c.d.b.c(drawFeedAdListener, adSlot.getCodeId(), 3));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        k0.c(adSlot.getCodeId(), 11);
        this.f4164a.loadExpressDrawFeedAd(adSlot, new h(nativeExpressAdListener, adSlot.getCodeId(), 11));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
        k0.c(adSlot.getCodeId(), 1);
        this.f4164a.loadFeedAd(adSlot, new d(feedAdListener, adSlot.getCodeId(), 1));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        k0.c(adSlot.getCodeId(), 9);
        this.f4164a.loadFullScreenVideoAd(adSlot, new e(fullScreenVideoAdListener, adSlot.getCodeId(), 9));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadInteractionExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        k0.c(adSlot.getCodeId(), 13);
        this.f4164a.loadInteractionExpressAd(adSlot, new h(nativeExpressAdListener, adSlot.getCodeId(), 13));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadNativeAd(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
        k0.c(adSlot.getCodeId(), 4);
        this.f4164a.loadNativeAd(adSlot, new g(nativeAdListener, adSlot.getCodeId(), 4));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        k0.c(adSlot.getCodeId(), 10);
        this.f4164a.loadNativeExpressAd(adSlot, new h(nativeExpressAdListener, adSlot.getCodeId(), 10));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        k0.c(adSlot.getCodeId(), 8);
        this.f4164a.loadRewardVideoAd(adSlot, new i(rewardVideoAdListener, adSlot.getCodeId(), 8));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener, int i2) {
        k0.c(adSlot.getCodeId(), 7);
        this.f4164a.loadSplashAd(adSlot, new j(splashAdListener, adSlot.getCodeId(), 7), i2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
        k0.c(adSlot.getCodeId(), 2);
        this.f4164a.loadStream(adSlot, new d(feedAdListener, adSlot.getCodeId(), 2));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener) {
        k0.c(adSlot.getCodeId(), 7);
        this.f4164a.loadSplashAd(adSlot, new j(splashAdListener, adSlot.getCodeId(), 7));
    }
}
