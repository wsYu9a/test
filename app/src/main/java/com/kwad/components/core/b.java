package com.kwad.components.core;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.b.c;
import com.kwad.components.ad.b.f;
import com.kwad.components.ad.b.g;
import com.kwad.components.ad.b.h;
import com.kwad.components.ad.b.i;
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
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;

/* loaded from: classes3.dex */
public final class b implements KsLoadManager {

    /* renamed from: com.kwad.components.core.b$1 */
    public class AnonymousClass1 implements KsLoadManager.FullScreenVideoAdListener {
        final /* synthetic */ KsLoadManager.FullScreenVideoAdListener Ky;

        public AnonymousClass1(KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
            fullScreenVideoAdListener = fullScreenVideoAdListener;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public final void onError(int i10, String str) {
            fullScreenVideoAdListener.onError(i10, str);
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
    public class AnonymousClass2 implements KsLoadManager.RewardVideoAdListener {
        final /* synthetic */ KsLoadManager.RewardVideoAdListener KA;

        public AnonymousClass2(KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
            rewardVideoAdListener = rewardVideoAdListener;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public final void onError(int i10, String str) {
            rewardVideoAdListener.onError(i10, str);
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
    public class AnonymousClass3 implements KsLoadManager.FeedAdListener {
        final /* synthetic */ KsLoadManager.FeedAdListener fE;

        public AnonymousClass3(KsLoadManager.FeedAdListener feedAdListener) {
            feedAdListener = feedAdListener;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public final void onError(int i10, String str) {
            feedAdListener.onError(i10, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public final void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
            feedAdListener.onFeedAdLoad(list);
        }
    }

    /* renamed from: com.kwad.components.core.b$4 */
    public class AnonymousClass4 implements KsLoadManager.FeedAdListener {
        final /* synthetic */ KsLoadManager.FeedAdListener fE;

        public AnonymousClass4(KsLoadManager.FeedAdListener feedAdListener) {
            feedAdListener = feedAdListener;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public final void onError(int i10, String str) {
            feedAdListener.onError(i10, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public final void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
            feedAdListener.onFeedAdLoad(list);
        }
    }

    /* renamed from: com.kwad.components.core.b$5 */
    public class AnonymousClass5 implements KsLoadManager.DrawAdListener {
        final /* synthetic */ KsLoadManager.DrawAdListener ds;

        public AnonymousClass5(KsLoadManager.DrawAdListener drawAdListener) {
            drawAdListener = drawAdListener;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public final void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
            drawAdListener.onDrawAdLoad(list);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public final void onError(int i10, String str) {
            drawAdListener.onError(i10, str);
        }
    }

    /* renamed from: com.kwad.components.core.b$6 */
    public class AnonymousClass6 implements KsLoadManager.NativeAdListener {
        final /* synthetic */ KsLoadManager.NativeAdListener nA;

        public AnonymousClass6(KsLoadManager.NativeAdListener nativeAdListener) {
            nativeAdListener = nativeAdListener;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public final void onError(int i10, String str) {
            nativeAdListener.onError(i10, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public final void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
            nativeAdListener.onNativeAdLoad(list);
        }
    }

    /* renamed from: com.kwad.components.core.b$7 */
    public class AnonymousClass7 implements KsLoadManager.SplashScreenAdListener {
        final /* synthetic */ KsLoadManager.SplashScreenAdListener Dw;

        public AnonymousClass7(KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
            splashScreenAdListener = splashScreenAdListener;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public final void onError(int i10, String str) {
            splashScreenAdListener.onError(i10, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public final void onRequestResult(int i10) {
            splashScreenAdListener.onRequestResult(i10);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public final void onSplashScreenAdLoad(@Nullable KsSplashScreenAd ksSplashScreenAd) {
            splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAd);
        }
    }

    /* renamed from: com.kwad.components.core.b$8 */
    public class AnonymousClass8 implements KsLoadManager.InterstitialAdListener {
        final /* synthetic */ KsLoadManager.InterstitialAdListener ju;

        public AnonymousClass8(KsLoadManager.InterstitialAdListener interstitialAdListener) {
            interstitialAdListener = interstitialAdListener;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public final void onError(int i10, String str) {
            interstitialAdListener.onError(i10, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public final void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list) {
            interstitialAdListener.onInterstitialAdLoad(list);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public final void onRequestResult(int i10) {
            interstitialAdListener.onRequestResult(i10);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestToken(KsScene ksScene) {
        com.kwad.components.ad.b.b bVar = (com.kwad.components.ad.b.b) d.f(com.kwad.components.ad.b.b.class);
        return bVar != null ? bVar.getBidRequestToken(ksScene) : "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestTokenV2(KsScene ksScene) {
        com.kwad.components.ad.b.b bVar = (com.kwad.components.ad.b.b) d.f(com.kwad.components.ad.b.b.class);
        return bVar != null ? bVar.getBidRequestTokenV2(ksScene) : "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadBannerAd(KsScene ksScene, @NonNull KsLoadManager.BannerAdListener bannerAdListener) {
        try {
            com.kwad.components.ad.b.a aVar = (com.kwad.components.ad.b.a) d.f(com.kwad.components.ad.b.a.class);
            if (aVar != null) {
                aVar.loadBannerAd(ksScene, bannerAdListener);
            } else if (com.kwad.components.ad.f.a.ns.booleanValue()) {
                e eVar = e.azx;
                bannerAdListener.onError(eVar.errorCode, eVar.msg);
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
            e eVar2 = e.azF;
            bannerAdListener.onError(eVar2.errorCode, eVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadConfigFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        com.kwad.components.ad.b.d dVar = (com.kwad.components.ad.b.d) d.f(com.kwad.components.ad.b.d.class);
        if (dVar != null) {
            dVar.loadConfigFeedAd(ksScene, new KsLoadManager.FeedAdListener() { // from class: com.kwad.components.core.b.4
                final /* synthetic */ KsLoadManager.FeedAdListener fE;

                public AnonymousClass4(KsLoadManager.FeedAdListener feedAdListener2) {
                    feedAdListener = feedAdListener2;
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onError(int i10, String str) {
                    feedAdListener.onError(i10, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
                    feedAdListener.onFeedAdLoad(list);
                }
            });
        } else if (com.kwad.components.ad.f.a.ns.booleanValue()) {
            e eVar = e.azx;
            feedAdListener2.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadDrawAd(KsScene ksScene, @NonNull KsLoadManager.DrawAdListener drawAdListener) {
        c cVar = (c) d.f(c.class);
        if (cVar != null) {
            cVar.loadDrawAd(ksScene, new KsLoadManager.DrawAdListener() { // from class: com.kwad.components.core.b.5
                final /* synthetic */ KsLoadManager.DrawAdListener ds;

                public AnonymousClass5(KsLoadManager.DrawAdListener drawAdListener2) {
                    drawAdListener = drawAdListener2;
                }

                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public final void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
                    drawAdListener.onDrawAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public final void onError(int i10, String str) {
                    drawAdListener.onError(i10, str);
                }
            });
        } else if (com.kwad.components.ad.f.a.ns.booleanValue()) {
            e eVar = e.azx;
            drawAdListener2.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        com.kwad.components.ad.b.d dVar = (com.kwad.components.ad.b.d) d.f(com.kwad.components.ad.b.d.class);
        if (dVar != null) {
            dVar.loadFeedAd(ksScene, new KsLoadManager.FeedAdListener() { // from class: com.kwad.components.core.b.3
                final /* synthetic */ KsLoadManager.FeedAdListener fE;

                public AnonymousClass3(KsLoadManager.FeedAdListener feedAdListener2) {
                    feedAdListener = feedAdListener2;
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onError(int i10, String str) {
                    feedAdListener.onError(i10, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
                    feedAdListener.onFeedAdLoad(list);
                }
            });
        } else if (com.kwad.components.ad.f.a.ns.booleanValue()) {
            e eVar = e.azx;
            feedAdListener2.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFullScreenVideoAd(KsScene ksScene, @NonNull KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        com.kwad.components.ad.b.e eVar = (com.kwad.components.ad.b.e) d.f(com.kwad.components.ad.b.e.class);
        if (eVar != null) {
            eVar.loadFullScreenVideoAd(ksScene, new KsLoadManager.FullScreenVideoAdListener() { // from class: com.kwad.components.core.b.1
                final /* synthetic */ KsLoadManager.FullScreenVideoAdListener Ky;

                public AnonymousClass1(KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener2) {
                    fullScreenVideoAdListener = fullScreenVideoAdListener2;
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onError(int i10, String str) {
                    fullScreenVideoAdListener.onError(i10, str);
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
        } else if (com.kwad.components.ad.f.a.ns.booleanValue()) {
            e eVar2 = e.azx;
            fullScreenVideoAdListener2.onError(eVar2.errorCode, eVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.InterstitialAdListener interstitialAdListener) {
        f fVar = (f) d.f(f.class);
        if (fVar != null) {
            fVar.loadInterstitialAd(ksScene, new KsLoadManager.InterstitialAdListener() { // from class: com.kwad.components.core.b.8
                final /* synthetic */ KsLoadManager.InterstitialAdListener ju;

                public AnonymousClass8(KsLoadManager.InterstitialAdListener interstitialAdListener2) {
                    interstitialAdListener = interstitialAdListener2;
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onError(int i10, String str) {
                    interstitialAdListener.onError(i10, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list) {
                    interstitialAdListener.onInterstitialAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onRequestResult(int i10) {
                    interstitialAdListener.onRequestResult(i10);
                }
            });
        } else if (com.kwad.components.ad.f.a.ns.booleanValue()) {
            e eVar = e.azx;
            interstitialAdListener2.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(KsScene ksScene, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        g gVar = (g) d.f(g.class);
        if (gVar != null) {
            gVar.loadNativeAd(ksScene, new KsLoadManager.NativeAdListener() { // from class: com.kwad.components.core.b.6
                final /* synthetic */ KsLoadManager.NativeAdListener nA;

                public AnonymousClass6(KsLoadManager.NativeAdListener nativeAdListener2) {
                    nativeAdListener = nativeAdListener2;
                }

                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public final void onError(int i10, String str) {
                    nativeAdListener.onError(i10, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public final void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
                    nativeAdListener.onNativeAdLoad(list);
                }
            });
        } else if (com.kwad.components.ad.f.a.ns.booleanValue()) {
            e eVar = e.azx;
            nativeAdListener2.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadRewardVideoAd(KsScene ksScene, @NonNull KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        h hVar = (h) d.f(h.class);
        if (hVar != null) {
            hVar.loadRewardVideoAd(ksScene, new KsLoadManager.RewardVideoAdListener() { // from class: com.kwad.components.core.b.2
                final /* synthetic */ KsLoadManager.RewardVideoAdListener KA;

                public AnonymousClass2(KsLoadManager.RewardVideoAdListener rewardVideoAdListener2) {
                    rewardVideoAdListener = rewardVideoAdListener2;
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onError(int i10, String str) {
                    rewardVideoAdListener.onError(i10, str);
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
        } else if (com.kwad.components.ad.f.a.ns.booleanValue()) {
            e eVar = e.azx;
            rewardVideoAdListener2.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        try {
            i iVar = (i) d.f(i.class);
            if (iVar != null) {
                iVar.loadSplashScreenAd(ksScene, new KsLoadManager.SplashScreenAdListener() { // from class: com.kwad.components.core.b.7
                    final /* synthetic */ KsLoadManager.SplashScreenAdListener Dw;

                    public AnonymousClass7(KsLoadManager.SplashScreenAdListener splashScreenAdListener2) {
                        splashScreenAdListener = splashScreenAdListener2;
                    }

                    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                    public final void onError(int i10, String str) {
                        splashScreenAdListener.onError(i10, str);
                    }

                    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                    public final void onRequestResult(int i10) {
                        splashScreenAdListener.onRequestResult(i10);
                    }

                    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                    public final void onSplashScreenAdLoad(@Nullable KsSplashScreenAd ksSplashScreenAd) {
                        splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAd);
                    }
                });
            } else if (com.kwad.components.ad.f.a.ns.booleanValue()) {
                e eVar = e.azx;
                splashScreenAdListener2.onError(eVar.errorCode, eVar.msg);
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
            e eVar2 = e.azF;
            splashScreenAdListener2.onError(eVar2.errorCode, eVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener) {
        com.kwad.components.ad.b.b bVar = (com.kwad.components.ad.b.b) d.f(com.kwad.components.ad.b.b.class);
        if (bVar != null) {
            return bVar.showInstallDialog(activity, ksExitInstallListener);
        }
        return false;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(String str, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        g gVar = (g) d.f(g.class);
        if (gVar != null) {
            gVar.loadNativeAd(str, nativeAdListener);
        } else if (com.kwad.components.ad.f.a.ns.booleanValue()) {
            e eVar = e.azx;
            nativeAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }
}
