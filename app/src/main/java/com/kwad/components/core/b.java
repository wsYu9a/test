package com.kwad.components.core;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kwad.components.ad.a.d;
import com.kwad.components.ad.a.e;
import com.kwad.components.ad.a.g;
import com.kwad.components.ad.a.h;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsExitInstallListener;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.components.c;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.martian.ads.ad.AdConfig;
import java.util.List;

/* loaded from: classes2.dex */
public final class b implements KsLoadManager {

    /* renamed from: com.kwad.components.core.b$1 */
    final class AnonymousClass1 implements KsLoadManager.FullScreenVideoAdListener {
        final /* synthetic */ KsLoadManager.FullScreenVideoAdListener gg;

        AnonymousClass1(KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
            fullScreenVideoAdListener = fullScreenVideoAdListener;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public final void onError(int i2, String str) {
            fullScreenVideoAdListener.onError(i2, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public final void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list) {
            fullScreenVideoAdListener.onFullScreenVideoAdLoad(list);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public final void onFullScreenVideoResult(@Nullable List<KsFullScreenVideoAd> list) {
            fullScreenVideoAdListener.onFullScreenVideoResult(list);
        }
    }

    /* renamed from: com.kwad.components.core.b$2 */
    final class AnonymousClass2 implements KsLoadManager.RewardVideoAdListener {
        final /* synthetic */ KsLoadManager.RewardVideoAdListener oz;

        AnonymousClass2(KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
            rewardVideoAdListener = rewardVideoAdListener;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public final void onError(int i2, String str) {
            rewardVideoAdListener.onError(i2, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public final void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
            rewardVideoAdListener.onRewardVideoAdLoad(list);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public final void onRewardVideoResult(@Nullable List<KsRewardVideoAd> list) {
            rewardVideoAdListener.onRewardVideoResult(list);
        }
    }

    /* renamed from: com.kwad.components.core.b$3 */
    final class AnonymousClass3 implements KsLoadManager.FeedAdListener {
        final /* synthetic */ KsLoadManager.FeedAdListener ek;

        AnonymousClass3(KsLoadManager.FeedAdListener feedAdListener) {
            feedAdListener = feedAdListener;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public final void onError(int i2, String str) {
            feedAdListener.onError(i2, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public final void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
            feedAdListener.onFeedAdLoad(list);
        }
    }

    /* renamed from: com.kwad.components.core.b$4 */
    final class AnonymousClass4 implements KsLoadManager.FeedAdListener {
        final /* synthetic */ KsLoadManager.FeedAdListener ek;

        AnonymousClass4(KsLoadManager.FeedAdListener feedAdListener) {
            feedAdListener = feedAdListener;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public final void onError(int i2, String str) {
            feedAdListener.onError(i2, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public final void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
            feedAdListener.onFeedAdLoad(list);
        }
    }

    /* renamed from: com.kwad.components.core.b$5 */
    final class AnonymousClass5 implements KsLoadManager.DrawAdListener {
        final /* synthetic */ KsLoadManager.DrawAdListener cj;

        AnonymousClass5(KsLoadManager.DrawAdListener drawAdListener) {
            drawAdListener = drawAdListener;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public final void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
            drawAdListener.onDrawAdLoad(list);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public final void onError(int i2, String str) {
            drawAdListener.onError(i2, str);
        }
    }

    /* renamed from: com.kwad.components.core.b$6 */
    final class AnonymousClass6 implements KsLoadManager.NativeAdListener {
        final /* synthetic */ KsLoadManager.NativeAdListener mG;

        AnonymousClass6(KsLoadManager.NativeAdListener nativeAdListener) {
            nativeAdListener = nativeAdListener;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public final void onError(int i2, String str) {
            nativeAdListener.onError(i2, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public final void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
            nativeAdListener.onNativeAdLoad(list);
        }
    }

    /* renamed from: com.kwad.components.core.b$7 */
    final class AnonymousClass7 implements KsLoadManager.SplashScreenAdListener {
        final /* synthetic */ KsLoadManager.SplashScreenAdListener Bm;

        AnonymousClass7(KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
            splashScreenAdListener = splashScreenAdListener;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public final void onError(int i2, String str) {
            splashScreenAdListener.onError(i2, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public final void onRequestResult(int i2) {
            splashScreenAdListener.onRequestResult(i2);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public final void onSplashScreenAdLoad(@Nullable KsSplashScreenAd ksSplashScreenAd) {
            splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAd);
        }
    }

    /* renamed from: com.kwad.components.core.b$8 */
    final class AnonymousClass8 implements KsLoadManager.InterstitialAdListener {
        final /* synthetic */ KsLoadManager.InterstitialAdListener hQ;

        AnonymousClass8(KsLoadManager.InterstitialAdListener interstitialAdListener) {
            interstitialAdListener = interstitialAdListener;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public final void onError(int i2, String str) {
            interstitialAdListener.onError(i2, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public final void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list) {
            interstitialAdListener.onInterstitialAdLoad(list);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public final void onRequestResult(int i2) {
            interstitialAdListener.onRequestResult(i2);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestToken(KsScene ksScene) {
        com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) c.f(com.kwad.components.ad.a.a.class);
        return aVar != null ? aVar.getBidRequestToken(ksScene) : "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestTokenV2(KsScene ksScene) {
        com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) c.f(com.kwad.components.ad.a.a.class);
        return aVar != null ? aVar.getBidRequestTokenV2(ksScene) : "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadConfigFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        com.kwad.sdk.g.a.U(IAdInterListener.AdProdType.PRODUCT_FEEDS, "request");
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FEED, "loadRequest").bw(ksScene.getAdNum()).report();
        com.kwad.components.ad.a.c cVar = (com.kwad.components.ad.a.c) c.f(com.kwad.components.ad.a.c.class);
        if (cVar != null) {
            cVar.loadConfigFeedAd(ksScene, new KsLoadManager.FeedAdListener() { // from class: com.kwad.components.core.b.4
                final /* synthetic */ KsLoadManager.FeedAdListener ek;

                AnonymousClass4(KsLoadManager.FeedAdListener feedAdListener2) {
                    feedAdListener = feedAdListener2;
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onError(int i2, String str) {
                    feedAdListener.onError(i2, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
                    feedAdListener.onFeedAdLoad(list);
                }
            });
            com.kwad.sdk.g.a.V(IAdInterListener.AdProdType.PRODUCT_FEEDS, "request");
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.agk;
            feedAdListener2.onError(fVar.errorCode, fVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadDrawAd(KsScene ksScene, @NonNull KsLoadManager.DrawAdListener drawAdListener) {
        com.kwad.sdk.g.a.U("draw", "request");
        com.kwad.components.ad.a.b bVar = (com.kwad.components.ad.a.b) c.f(com.kwad.components.ad.a.b.class);
        if (bVar != null) {
            bVar.loadDrawAd(ksScene, new KsLoadManager.DrawAdListener() { // from class: com.kwad.components.core.b.5
                final /* synthetic */ KsLoadManager.DrawAdListener cj;

                AnonymousClass5(KsLoadManager.DrawAdListener drawAdListener2) {
                    drawAdListener = drawAdListener2;
                }

                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public final void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
                    drawAdListener.onDrawAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public final void onError(int i2, String str) {
                    drawAdListener.onError(i2, str);
                }
            });
            com.kwad.sdk.g.a.V("draw", "request");
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.agk;
            drawAdListener2.onError(fVar.errorCode, fVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        com.kwad.sdk.g.a.U(IAdInterListener.AdProdType.PRODUCT_FEEDS, "request");
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FEED, "loadRequest").bw(ksScene.getAdNum()).report();
        com.kwad.components.ad.a.c cVar = (com.kwad.components.ad.a.c) c.f(com.kwad.components.ad.a.c.class);
        if (cVar != null) {
            cVar.loadFeedAd(ksScene, new KsLoadManager.FeedAdListener() { // from class: com.kwad.components.core.b.3
                final /* synthetic */ KsLoadManager.FeedAdListener ek;

                AnonymousClass3(KsLoadManager.FeedAdListener feedAdListener2) {
                    feedAdListener = feedAdListener2;
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onError(int i2, String str) {
                    feedAdListener.onError(i2, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
                    feedAdListener.onFeedAdLoad(list);
                }
            });
            com.kwad.sdk.g.a.V(IAdInterListener.AdProdType.PRODUCT_FEEDS, "request");
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.agk;
            feedAdListener2.onError(fVar.errorCode, fVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFullScreenVideoAd(KsScene ksScene, @NonNull KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        com.kwad.sdk.g.a.U("fullscreen", "request");
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FULLSCREEN, "loadRequest").report();
        d dVar = (d) c.f(d.class);
        if (dVar != null) {
            dVar.loadFullScreenVideoAd(ksScene, new KsLoadManager.FullScreenVideoAdListener() { // from class: com.kwad.components.core.b.1
                final /* synthetic */ KsLoadManager.FullScreenVideoAdListener gg;

                AnonymousClass1(KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener2) {
                    fullScreenVideoAdListener = fullScreenVideoAdListener2;
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onError(int i2, String str) {
                    fullScreenVideoAdListener.onError(i2, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list) {
                    fullScreenVideoAdListener.onFullScreenVideoAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onFullScreenVideoResult(@Nullable List<KsFullScreenVideoAd> list) {
                    fullScreenVideoAdListener.onFullScreenVideoResult(list);
                }
            });
            com.kwad.sdk.g.a.V("fullscreen", "request");
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.agk;
            fullScreenVideoAdListener2.onError(fVar.errorCode, fVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.InterstitialAdListener interstitialAdListener) {
        com.kwad.sdk.g.a.U(AdConfig.AdType.INTERSTITIAL, "request");
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_INTERSTITIAL, "loadRequest").report();
        e eVar = (e) c.f(e.class);
        if (eVar != null) {
            eVar.loadInterstitialAd(ksScene, new KsLoadManager.InterstitialAdListener() { // from class: com.kwad.components.core.b.8
                final /* synthetic */ KsLoadManager.InterstitialAdListener hQ;

                AnonymousClass8(KsLoadManager.InterstitialAdListener interstitialAdListener2) {
                    interstitialAdListener = interstitialAdListener2;
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onError(int i2, String str) {
                    interstitialAdListener.onError(i2, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list) {
                    interstitialAdListener.onInterstitialAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onRequestResult(int i2) {
                    interstitialAdListener.onRequestResult(i2);
                }
            });
            com.kwad.sdk.g.a.V(AdConfig.AdType.INTERSTITIAL, "request");
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.agk;
            interstitialAdListener2.onError(fVar.errorCode, fVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(KsScene ksScene, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        com.kwad.sdk.g.a.U(AdConfig.AdType.NATIVE, "request");
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "loadRequest").bw(ksScene.getAdNum()).report();
        com.kwad.components.ad.a.f fVar = (com.kwad.components.ad.a.f) c.f(com.kwad.components.ad.a.f.class);
        if (fVar != null) {
            fVar.loadNativeAd(ksScene, new KsLoadManager.NativeAdListener() { // from class: com.kwad.components.core.b.6
                final /* synthetic */ KsLoadManager.NativeAdListener mG;

                AnonymousClass6(KsLoadManager.NativeAdListener nativeAdListener2) {
                    nativeAdListener = nativeAdListener2;
                }

                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public final void onError(int i2, String str) {
                    nativeAdListener.onError(i2, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public final void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
                    nativeAdListener.onNativeAdLoad(list);
                }
            });
            com.kwad.sdk.g.a.V(AdConfig.AdType.NATIVE, "request");
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar2 = f.agk;
            nativeAdListener2.onError(fVar2.errorCode, fVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(String str, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "loadRequest").aW(true).report();
        com.kwad.components.ad.a.f fVar = (com.kwad.components.ad.a.f) c.f(com.kwad.components.ad.a.f.class);
        if (fVar != null) {
            fVar.loadNativeAd(str, nativeAdListener);
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar2 = f.agk;
            nativeAdListener.onError(fVar2.errorCode, fVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadRewardVideoAd(KsScene ksScene, @NonNull KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        com.kwad.sdk.g.a.U("reward", "request");
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_REWARD, "loadRequest").report();
        g gVar = (g) c.f(g.class);
        if (gVar != null) {
            gVar.loadRewardVideoAd(ksScene, new KsLoadManager.RewardVideoAdListener() { // from class: com.kwad.components.core.b.2
                final /* synthetic */ KsLoadManager.RewardVideoAdListener oz;

                AnonymousClass2(KsLoadManager.RewardVideoAdListener rewardVideoAdListener2) {
                    rewardVideoAdListener = rewardVideoAdListener2;
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onError(int i2, String str) {
                    rewardVideoAdListener.onError(i2, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
                    rewardVideoAdListener.onRewardVideoAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onRewardVideoResult(@Nullable List<KsRewardVideoAd> list) {
                    rewardVideoAdListener.onRewardVideoResult(list);
                }
            });
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.agk;
            rewardVideoAdListener2.onError(fVar.errorCode, fVar.msg);
        }
        com.kwad.sdk.g.a.V("reward", "request");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        com.kwad.sdk.g.a.U("splash", "request");
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_SPLASH, "loadRequest").report();
        h hVar = (h) c.f(h.class);
        if (hVar != null) {
            hVar.loadSplashScreenAd(ksScene, new KsLoadManager.SplashScreenAdListener() { // from class: com.kwad.components.core.b.7
                final /* synthetic */ KsLoadManager.SplashScreenAdListener Bm;

                AnonymousClass7(KsLoadManager.SplashScreenAdListener splashScreenAdListener2) {
                    splashScreenAdListener = splashScreenAdListener2;
                }

                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public final void onError(int i2, String str) {
                    splashScreenAdListener.onError(i2, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public final void onRequestResult(int i2) {
                    splashScreenAdListener.onRequestResult(i2);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public final void onSplashScreenAdLoad(@Nullable KsSplashScreenAd ksSplashScreenAd) {
                    splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAd);
                }
            });
            com.kwad.sdk.g.a.V("splash", "request");
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.agk;
            splashScreenAdListener2.onError(fVar.errorCode, fVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener) {
        com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) c.f(com.kwad.components.ad.a.a.class);
        if (aVar != null) {
            return aVar.showInstallDialog(activity, ksExitInstallListener);
        }
        return false;
    }
}
