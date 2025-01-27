package com.martian.ads.ad;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.libmars.d.h;
import com.martian.libsupport.k;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.pi.IBidding;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class GDTAd extends BaseAd {
    private UnifiedBannerView banner;
    private boolean bannerLoaded;
    private boolean cancelLoading;
    private UnifiedInterstitialAD iad;
    private RewardVideoAD rewardVideoAD;

    /* renamed from: com.martian.ads.ad.GDTAd$1 */
    class AnonymousClass1 implements SplashADListener {
        AnonymousClass1() {
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADClicked() {
            GDTAd.this.onClick();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADDismissed() {
            GDTAd.this.onDismiss();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADExposure() {
            GDTAd.this.onExpose();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADLoaded(long l) {
            AppTask appTask = GDTAd.this.getAppTaskList().getApps().get(0);
            int ecpm = ((SplashAD) appTask.origin).getECPM();
            if (GDTAd.this.adConfig.isBidding() || ecpm > 0) {
                if (GDTAd.this.adConfig.getEcpmPercent() > 0.0d) {
                    double d2 = ecpm;
                    double ecpmPercent = GDTAd.this.adConfig.getEcpmPercent();
                    Double.isNaN(d2);
                    ecpm = (int) ((d2 * ecpmPercent) / 100.0d);
                }
                appTask.setEcpm(ecpm);
                GDTAd.this.adConfig.setEcpm(ecpm);
            }
            GDTAd.this.onAdReceived();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADPresent() {
            GDTAd.this.onExpose();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADTick(long l) {
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onNoAD(AdError adError) {
            GDTAd.this.onError(new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMsg()));
        }
    }

    /* renamed from: com.martian.ads.ad.GDTAd$2 */
    class AnonymousClass2 implements NativeADUnifiedListener {
        AnonymousClass2() {
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            if (list == null || list.isEmpty()) {
                GDTAd.this.onError(null);
                return;
            }
            Iterator<NativeUnifiedADData> it = list.iterator();
            while (it.hasNext()) {
                GDTAd.this.getAppTaskList().addAppTask(GDTAd.this.toAppTask(it.next()));
            }
            GDTAd.this.onAdReceived();
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            GDTAd.this.onError(new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMsg()));
        }
    }

    /* renamed from: com.martian.ads.ad.GDTAd$3 */
    class AnonymousClass3 implements NativeExpressAD.NativeExpressADListener {
        AnonymousClass3() {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            GDTAd.this.onClick();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            GDTAd.this.onClose();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(final NativeExpressADView nativeExpressADView) {
            GDTAd.this.onExpose();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            if (list == null || list.isEmpty()) {
                GDTAd.this.onError(null);
                return;
            }
            for (NativeExpressADView nativeExpressADView : list) {
                AppTask appTask = GDTAd.this.adConfig.toAppTask();
                b.d.a.f fVar = new b.d.a.f(nativeExpressADView);
                appTask.customView = fVar;
                fVar.init();
                GDTAd.this.getAppTaskList().addAppTask(appTask);
            }
            GDTAd.this.onAdReceived();
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            GDTAd.this.onError(new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMsg()));
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            GDTAd.this.onError(new b.d.c.b.c(-1, AdConfig.ActionString.FAIL));
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(final NativeExpressADView nativeExpressADView) {
        }
    }

    /* renamed from: com.martian.ads.ad.GDTAd$4 */
    class AnonymousClass4 implements UnifiedBannerADListener {
        AnonymousClass4() {
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClicked() {
            GDTAd.this.onClick();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClosed() {
            GDTAd.this.onClose();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADExposure() {
            GDTAd.this.onExpose();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADReceive() {
            if (GDTAd.this.bannerLoaded) {
                GDTAd.this.destroyBanner();
                return;
            }
            GDTAd.this.bannerLoaded = true;
            AppTask appTask = GDTAd.this.adConfig.toAppTask();
            b.d.a.e eVar = new b.d.a.e(GDTAd.this.banner);
            appTask.customView = eVar;
            eVar.init();
            GDTAd.this.getAppTaskList().addAppTask(appTask);
            GDTAd.this.onAdReceived();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onNoAD(AdError error) {
            if (GDTAd.this.bannerLoaded) {
                GDTAd.this.destroyBanner();
            } else {
                GDTAd.this.bannerLoaded = true;
                GDTAd.this.onError(new b.d.c.b.c(error.getErrorCode(), error.getErrorMsg()));
            }
        }
    }

    /* renamed from: com.martian.ads.ad.GDTAd$5 */
    class AnonymousClass5 implements UnifiedInterstitialADListener {
        AnonymousClass5() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClicked() {
            GDTAd.this.onClick();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClosed() {
            GDTAd.this.onDismiss();
            GDTAd.this.onClose();
            GDTAd.this.onRewardVerify(true);
            if (GDTAd.this.iad != null) {
                GDTAd.this.iad.destroy();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADExposure() {
            GDTAd.this.onExpose();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADOpened() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADReceive() {
            AppTask appTask = GDTAd.this.adConfig.toAppTask();
            appTask.origin = GDTAd.this.iad;
            int ecpm = GDTAd.this.iad.getECPM();
            if (GDTAd.this.adConfig.isBidding() || ecpm > 0) {
                if (GDTAd.this.adConfig.getEcpmPercent() > 0.0d) {
                    double d2 = ecpm;
                    double ecpmPercent = GDTAd.this.adConfig.getEcpmPercent();
                    Double.isNaN(d2);
                    ecpm = (int) ((d2 * ecpmPercent) / 100.0d);
                }
                appTask.setEcpm(ecpm);
                GDTAd.this.adConfig.setEcpm(ecpm);
            }
            GDTAd.this.getAppTaskList().addAppTask(appTask);
            GDTAd.this.onAdReceived();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onNoAD(AdError adError) {
            GDTAd.this.onError(new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMsg()));
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderFail() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderSuccess() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
        }
    }

    /* renamed from: com.martian.ads.ad.GDTAd$6 */
    class AnonymousClass6 implements RewardVideoADListener {
        private boolean reward = false;

        AnonymousClass6() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClick() {
            GDTAd.this.onClick();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClose() {
            if (this.reward) {
                GDTAd.this.onClose();
            }
            GDTAd.this.onRewardVerify(this.reward);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADExpose() {
            GDTAd.this.onExpose();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADLoad() {
            AppTask appTask = GDTAd.this.adConfig.toAppTask();
            appTask.origin = GDTAd.this.rewardVideoAD;
            if (GDTAd.this.adConfig.isBidding() || GDTAd.this.rewardVideoAD.getECPM() > 0) {
                int ecpm = GDTAd.this.rewardVideoAD.getECPM();
                if (GDTAd.this.adConfig.getEcpmPercent() > 0.0d) {
                    double d2 = ecpm;
                    double ecpmPercent = GDTAd.this.adConfig.getEcpmPercent();
                    Double.isNaN(d2);
                    ecpm = (int) ((d2 * ecpmPercent) / 100.0d);
                }
                appTask.setEcpm(ecpm);
                GDTAd.this.adConfig.setEcpm(ecpm);
            }
            GDTAd.this.getAppTaskList().addAppTask(appTask);
            GDTAd.this.onAdReceived();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADShow() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onError(AdError adError) {
            GDTAd.this.onError(new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMsg()));
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onReward(Map<String, Object> map) {
            this.reward = true;
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoCached() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoComplete() {
            this.reward = true;
        }
    }

    /* renamed from: com.martian.ads.ad.GDTAd$7 */
    static class AnonymousClass7 implements NativeADEventListener {
        final /* synthetic */ b.d.a.k.a val$innerListener;

        AnonymousClass7(final b.d.a.k.a val$appTask) {
            innerListener = val$appTask;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            innerListener.j(b.d.a.j.b.Q(AppTask.this));
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError error) {
            innerListener.g(b.d.a.j.b.Q(AppTask.this), new b.d.c.b.c(error.getErrorCode(), error.getErrorMsg()));
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            b.d.a.j.b.J(AppTask.this, innerListener);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
        }
    }

    /* renamed from: com.martian.ads.ad.GDTAd$8 */
    static class AnonymousClass8 implements NativeADMediaListener {
        AnonymousClass8() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoClicked() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoCompleted() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoError(AdError error) {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoInit() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoaded(int videoDuration) {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoading() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoPause() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoReady() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoResume() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStart() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStop() {
        }
    }

    public GDTAd(AdConfig config, @NonNull b.d.a.k.a receiver) {
        super(config, receiver);
        this.cancelLoading = false;
        this.bannerLoaded = false;
    }

    public static void bindFlowAd(Activity activity, final AppTask appTask, ViewGroup adContainer, View adView, ViewGroup videoView, View creativeView, final b.d.a.k.a innerListener) {
        NativeAdContainer nativeAdContainer;
        NativeAdContainer nativeAdContainer2;
        if (adContainer == null || adView == null) {
            return;
        }
        NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) appTask.origin;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(adView);
        if (creativeView != null) {
            arrayList2.add(creativeView);
        }
        if (adView instanceof NativeAdContainer) {
            NativeAdContainer nativeAdContainer3 = (NativeAdContainer) adView;
            if (nativeAdContainer3.getChildCount() > 0) {
                arrayList.add(nativeAdContainer3.getChildAt(0));
            }
            nativeAdContainer2 = nativeAdContainer3;
        } else {
            adContainer.removeAllViews();
            ViewGroup viewGroup = (ViewGroup) adView.getParent();
            if (viewGroup instanceof NativeAdContainer) {
                nativeAdContainer = (NativeAdContainer) viewGroup;
                ViewGroup viewGroup2 = (ViewGroup) nativeAdContainer.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeAllViews();
                }
            } else {
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                nativeAdContainer = new NativeAdContainer(activity);
                nativeAdContainer.addView(adView, -1, -2);
            }
            adContainer.addView(nativeAdContainer);
            nativeAdContainer2 = nativeAdContainer;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, 0);
        if (arrayList2.isEmpty()) {
            nativeUnifiedADData.bindAdToView(activity, nativeAdContainer2, layoutParams, arrayList);
        } else {
            nativeUnifiedADData.bindAdToView(activity, nativeAdContainer2, layoutParams, arrayList, arrayList2);
        }
        nativeUnifiedADData.setNativeAdEventListener(new NativeADEventListener() { // from class: com.martian.ads.ad.GDTAd.7
            final /* synthetic */ b.d.a.k.a val$innerListener;

            AnonymousClass7(final b.d.a.k.a innerListener2) {
                innerListener = innerListener2;
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADClicked() {
                innerListener.j(b.d.a.j.b.Q(AppTask.this));
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADError(AdError error) {
                innerListener.g(b.d.a.j.b.Q(AppTask.this), new b.d.c.b.c(error.getErrorCode(), error.getErrorMsg()));
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                b.d.a.j.b.J(AppTask.this, innerListener);
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
            }
        });
        if (nativeUnifiedADData.getAdPatternType() == 2 && videoView != null && h.F().U0()) {
            videoView.setVisibility(0);
            MediaView mediaView = new MediaView(activity);
            videoView.removeAllViews();
            videoView.addView(mediaView);
            nativeUnifiedADData.bindMediaView(mediaView, new VideoOption.Builder().setAutoPlayMuted(true).setAutoPlayPolicy(0).build(), new NativeADMediaListener() { // from class: com.martian.ads.ad.GDTAd.8
                AnonymousClass8() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoClicked() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoCompleted() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoError(AdError error) {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoInit() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoLoaded(int videoDuration) {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoLoading() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoPause() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoReady() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoResume() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoStart() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoStop() {
                }
            });
        }
    }

    public void destroyBanner() {
        UnifiedBannerView unifiedBannerView = this.banner;
        if (unifiedBannerView != null) {
            unifiedBannerView.destroy();
        }
    }

    public static void destroyView(NativeUnifiedADData ad2) {
        ad2.destroy();
    }

    public static boolean isGdtFlowAd(AppTask appTask) {
        return appTask != null && (appTask.origin instanceof NativeUnifiedADData);
    }

    private void loadBannerAds(Activity activity) {
        UnifiedBannerView unifiedBannerView = new UnifiedBannerView(activity, this.adConfig.getAdsId(), new UnifiedBannerADListener() { // from class: com.martian.ads.ad.GDTAd.4
            AnonymousClass4() {
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADClicked() {
                GDTAd.this.onClick();
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADClosed() {
                GDTAd.this.onClose();
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADExposure() {
                GDTAd.this.onExpose();
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADLeftApplication() {
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADReceive() {
                if (GDTAd.this.bannerLoaded) {
                    GDTAd.this.destroyBanner();
                    return;
                }
                GDTAd.this.bannerLoaded = true;
                AppTask appTask = GDTAd.this.adConfig.toAppTask();
                b.d.a.e eVar = new b.d.a.e(GDTAd.this.banner);
                appTask.customView = eVar;
                eVar.init();
                GDTAd.this.getAppTaskList().addAppTask(appTask);
                GDTAd.this.onAdReceived();
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onNoAD(AdError error) {
                if (GDTAd.this.bannerLoaded) {
                    GDTAd.this.destroyBanner();
                } else {
                    GDTAd.this.bannerLoaded = true;
                    GDTAd.this.onError(new b.d.c.b.c(error.getErrorCode(), error.getErrorMsg()));
                }
            }
        });
        this.banner = unifiedBannerView;
        unifiedBannerView.loadAD();
    }

    private void loadFlowAds(Activity activity) {
        NativeUnifiedAD nativeUnifiedAD = new NativeUnifiedAD(activity, this.adConfig.getAdsId(), new NativeADUnifiedListener() { // from class: com.martian.ads.ad.GDTAd.2
            AnonymousClass2() {
            }

            @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
            public void onADLoaded(List<NativeUnifiedADData> list) {
                if (list == null || list.isEmpty()) {
                    GDTAd.this.onError(null);
                    return;
                }
                Iterator<NativeUnifiedADData> it = list.iterator();
                while (it.hasNext()) {
                    GDTAd.this.getAppTaskList().addAppTask(GDTAd.this.toAppTask(it.next()));
                }
                GDTAd.this.onAdReceived();
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                GDTAd.this.onError(new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMsg()));
            }
        });
        nativeUnifiedAD.setMaxVideoDuration(20);
        nativeUnifiedAD.loadData(this.adConfig.getAdsCount());
    }

    private void loadInteractionAd(Activity activity) {
        UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD(activity, this.adConfig.getAdsId(), new UnifiedInterstitialADListener() { // from class: com.martian.ads.ad.GDTAd.5
            AnonymousClass5() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClicked() {
                GDTAd.this.onClick();
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClosed() {
                GDTAd.this.onDismiss();
                GDTAd.this.onClose();
                GDTAd.this.onRewardVerify(true);
                if (GDTAd.this.iad != null) {
                    GDTAd.this.iad.destroy();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADExposure() {
                GDTAd.this.onExpose();
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADLeftApplication() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADOpened() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADReceive() {
                AppTask appTask = GDTAd.this.adConfig.toAppTask();
                appTask.origin = GDTAd.this.iad;
                int ecpm = GDTAd.this.iad.getECPM();
                if (GDTAd.this.adConfig.isBidding() || ecpm > 0) {
                    if (GDTAd.this.adConfig.getEcpmPercent() > 0.0d) {
                        double d2 = ecpm;
                        double ecpmPercent = GDTAd.this.adConfig.getEcpmPercent();
                        Double.isNaN(d2);
                        ecpm = (int) ((d2 * ecpmPercent) / 100.0d);
                    }
                    appTask.setEcpm(ecpm);
                    GDTAd.this.adConfig.setEcpm(ecpm);
                }
                GDTAd.this.getAppTaskList().addAppTask(appTask);
                GDTAd.this.onAdReceived();
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onNoAD(AdError adError) {
                GDTAd.this.onError(new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMsg()));
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderFail() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderSuccess() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onVideoCached() {
            }
        });
        this.iad = unifiedInterstitialAD;
        unifiedInterstitialAD.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(true).build());
        this.iad.loadAD();
    }

    private void loadSplashAds(Activity activity) {
        SplashAD splashAD = new SplashAD(activity.getApplicationContext(), this.adConfig.getAdsId(), new SplashADListener() { // from class: com.martian.ads.ad.GDTAd.1
            AnonymousClass1() {
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADClicked() {
                GDTAd.this.onClick();
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADDismissed() {
                GDTAd.this.onDismiss();
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADExposure() {
                GDTAd.this.onExpose();
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADLoaded(long l) {
                AppTask appTask = GDTAd.this.getAppTaskList().getApps().get(0);
                int ecpm = ((SplashAD) appTask.origin).getECPM();
                if (GDTAd.this.adConfig.isBidding() || ecpm > 0) {
                    if (GDTAd.this.adConfig.getEcpmPercent() > 0.0d) {
                        double d2 = ecpm;
                        double ecpmPercent = GDTAd.this.adConfig.getEcpmPercent();
                        Double.isNaN(d2);
                        ecpm = (int) ((d2 * ecpmPercent) / 100.0d);
                    }
                    appTask.setEcpm(ecpm);
                    GDTAd.this.adConfig.setEcpm(ecpm);
                }
                GDTAd.this.onAdReceived();
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADPresent() {
                GDTAd.this.onExpose();
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADTick(long l) {
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onNoAD(AdError adError) {
                GDTAd.this.onError(new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMsg()));
            }
        });
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = splashAD;
        getAppTaskList().addAppTask(appTask);
        splashAD.fetchAdOnly();
    }

    private void loadTemplateFlowAds(Activity activity) {
        NativeExpressAD nativeExpressAD = new NativeExpressAD(activity, new ADSize(-1, -2), this.adConfig.getAdsId(), new NativeExpressAD.NativeExpressADListener() { // from class: com.martian.ads.ad.GDTAd.3
            AnonymousClass3() {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADClicked(NativeExpressADView nativeExpressADView) {
                GDTAd.this.onClick();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADClosed(NativeExpressADView nativeExpressADView) {
                GDTAd.this.onClose();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADExposure(final NativeExpressADView nativeExpressADView) {
                GDTAd.this.onExpose();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADLoaded(List<NativeExpressADView> list) {
                if (list == null || list.isEmpty()) {
                    GDTAd.this.onError(null);
                    return;
                }
                for (NativeExpressADView nativeExpressADView : list) {
                    AppTask appTask = GDTAd.this.adConfig.toAppTask();
                    b.d.a.f fVar = new b.d.a.f(nativeExpressADView);
                    appTask.customView = fVar;
                    fVar.init();
                    GDTAd.this.getAppTaskList().addAppTask(appTask);
                }
                GDTAd.this.onAdReceived();
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                GDTAd.this.onError(new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMsg()));
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderFail(NativeExpressADView nativeExpressADView) {
                GDTAd.this.onError(new b.d.c.b.c(-1, AdConfig.ActionString.FAIL));
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderSuccess(final NativeExpressADView nativeExpressADView) {
            }
        });
        nativeExpressAD.setMaxVideoDuration(20);
        nativeExpressAD.loadAD(this.adConfig.getAdsCount());
    }

    private void loadVideoAd(Activity activity) {
        RewardVideoAD rewardVideoAD = new RewardVideoAD(activity, this.adConfig.getAdsId(), new RewardVideoADListener() { // from class: com.martian.ads.ad.GDTAd.6
            private boolean reward = false;

            AnonymousClass6() {
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADClick() {
                GDTAd.this.onClick();
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADClose() {
                if (this.reward) {
                    GDTAd.this.onClose();
                }
                GDTAd.this.onRewardVerify(this.reward);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADExpose() {
                GDTAd.this.onExpose();
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADLoad() {
                AppTask appTask = GDTAd.this.adConfig.toAppTask();
                appTask.origin = GDTAd.this.rewardVideoAD;
                if (GDTAd.this.adConfig.isBidding() || GDTAd.this.rewardVideoAD.getECPM() > 0) {
                    int ecpm = GDTAd.this.rewardVideoAD.getECPM();
                    if (GDTAd.this.adConfig.getEcpmPercent() > 0.0d) {
                        double d2 = ecpm;
                        double ecpmPercent = GDTAd.this.adConfig.getEcpmPercent();
                        Double.isNaN(d2);
                        ecpm = (int) ((d2 * ecpmPercent) / 100.0d);
                    }
                    appTask.setEcpm(ecpm);
                    GDTAd.this.adConfig.setEcpm(ecpm);
                }
                GDTAd.this.getAppTaskList().addAppTask(appTask);
                GDTAd.this.onAdReceived();
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADShow() {
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onError(AdError adError) {
                GDTAd.this.onError(new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMsg()));
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onReward(Map<String, Object> map) {
                this.reward = true;
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onVideoCached() {
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onVideoComplete() {
                this.reward = true;
            }
        });
        this.rewardVideoAD = rewardVideoAD;
        rewardVideoAD.loadAD();
    }

    public static void sendInterstitialLossNotification(int price, @NonNull UnifiedInterstitialAD expressInterstitialAd) {
        HashMap hashMap = new HashMap();
        hashMap.put(IBidding.WIN_PRICE, Integer.valueOf(price));
        hashMap.put(IBidding.LOSS_REASON, 1);
        hashMap.put(IBidding.ADN_ID, "2");
        expressInterstitialAd.sendLossNotification(hashMap);
    }

    public static void sendLossNotification(int winPrice, @NonNull NativeUnifiedADData nativeUnifiedADData, int reason) {
        HashMap hashMap = new HashMap();
        hashMap.put(IBidding.WIN_PRICE, Integer.valueOf(winPrice));
        hashMap.put(IBidding.LOSS_REASON, Integer.valueOf(reason));
        hashMap.put(IBidding.ADN_ID, "2");
        nativeUnifiedADData.sendLossNotification(hashMap);
    }

    public static void sendSplashLossNotification(int winPrice, @NonNull SplashAD SplashAd) {
        HashMap hashMap = new HashMap();
        hashMap.put(IBidding.WIN_PRICE, Integer.valueOf(winPrice));
        hashMap.put(IBidding.LOSS_REASON, 1);
        hashMap.put(IBidding.ADN_ID, "2");
        SplashAd.sendLossNotification(hashMap);
    }

    public static void sendVideoLossNotification(int price, @NonNull RewardVideoAD rewardVideoAD) {
        HashMap hashMap = new HashMap();
        hashMap.put(IBidding.WIN_PRICE, Integer.valueOf(price));
        hashMap.put(IBidding.LOSS_REASON, 1);
        hashMap.put(IBidding.ADN_ID, "2");
        rewardVideoAD.sendLossNotification(hashMap);
    }

    public static void sendWinNotification(NativeUnifiedADData nativeUnifiedADData) {
        HashMap hashMap = new HashMap();
        hashMap.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(nativeUnifiedADData.getECPM()));
        nativeUnifiedADData.sendWinNotification(hashMap);
    }

    public static boolean showInterstitialAd(Activity activity, @NonNull UnifiedInterstitialAD expressInterstitialAd, boolean isBidding) {
        if (isBidding) {
            expressInterstitialAd.sendWinNotification(expressInterstitialAd.getECPM());
        }
        expressInterstitialAd.show(activity);
        return true;
    }

    public static void showSplashAd(@NonNull SplashAD splashAd, ViewGroup viewGroup, boolean isBidding) {
        if (splashAd.isValid()) {
            if (isBidding) {
                splashAd.sendWinNotification(splashAd.getECPM());
            }
            splashAd.showAd(viewGroup);
        }
    }

    public static void showVideoAd(@NonNull RewardVideoAD rewardVideoAD, boolean isBidding) {
        if (rewardVideoAD.hasShown()) {
            return;
        }
        if (isBidding) {
            rewardVideoAD.sendWinNotification(rewardVideoAD.getECPM());
        }
        rewardVideoAD.showAD();
    }

    public AppTask toAppTask(NativeUnifiedADData ad2) {
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = ad2;
        appTask.title = h.F().n(ad2.getTitle());
        appTask.desc = h.F().n(ad2.getDesc());
        if (!k.p(ad2.getCTAText())) {
            appTask.buttonText = ad2.getCTAText();
        } else if (ad2.isAppAd()) {
            int appStatus = ad2.getAppStatus();
            if (appStatus == 1) {
                appTask.buttonText = h.F().n("点击查看");
            } else if (appStatus == 4) {
                appTask.buttonText = h.F().n("下载中");
            } else if (appStatus != 8) {
                appTask.buttonText = h.F().n("点击下载");
            } else {
                appTask.buttonText = h.F().n("点击安装");
            }
        }
        if (ad2.getDownloadCount() > 0) {
            appTask.appPromote = h.F().n(appTask.getNumbers((int) ad2.getDownloadCount()) + "人下载");
        } else if (ad2.getAppScore() > 0) {
            appTask.appPromote = ad2.getAppScore() + "分";
        }
        if (ad2.getECPM() > 0) {
            int ecpm = ad2.getECPM();
            if (this.adConfig.getEcpmPercent() > 0.0d) {
                double d2 = ecpm;
                double ecpmPercent = this.adConfig.getEcpmPercent();
                Double.isNaN(d2);
                ecpm = (int) ((d2 * ecpmPercent) / 100.0d);
            }
            appTask.setEcpm(ecpm);
            this.adConfig.setEcpm(ecpm);
        }
        if (!k.p(ad2.getIconUrl())) {
            appTask.iconUrl = ad2.getIconUrl();
        }
        if (ad2.getAdPatternType() == 3) {
            for (String str : ad2.getImgList()) {
                if (appTask.getPosterUrls().size() > 0 && k.p(appTask.iconUrl)) {
                    appTask.iconUrl = str;
                }
                appTask.addPosterUrl(str);
            }
        } else if (k.p(ad2.getImgUrl())) {
            appTask.addPosterUrl(ad2.getIconUrl());
        } else {
            appTask.addPosterUrl(ad2.getImgUrl());
        }
        if (k.p(appTask.iconUrl)) {
            appTask.iconUrl = appTask.getPosterUrl();
        }
        if (ad2.getAppMiitInfo() != null) {
            appTask.name = ad2.getAppMiitInfo().getAppName();
        }
        appTask.setPicWidth(ad2.getPictureWidth());
        appTask.setPicHeight(ad2.getPictureHeight());
        return appTask;
    }

    @Override // com.martian.ads.ad.BaseAd
    protected boolean adCanceled() {
        return this.cancelLoading;
    }

    @Override // com.martian.ads.ad.BaseAd
    public void cancelLoading() {
        this.cancelLoading = true;
    }

    @Override // com.martian.ads.ad.BaseAd
    public void loadAds(Activity activity) {
        if ("splash".equalsIgnoreCase(this.adConfig.getType())) {
            loadSplashAds(activity);
            return;
        }
        if (AdConfig.AdType.NATIVE.equalsIgnoreCase(this.adConfig.getType())) {
            loadFlowAds(activity);
            return;
        }
        if (AdConfig.AdType.EXPRESS.equalsIgnoreCase(this.adConfig.getType())) {
            loadTemplateFlowAds(activity);
            return;
        }
        if ("banner".equalsIgnoreCase(this.adConfig.getType())) {
            loadBannerAds(activity);
        } else if (AdConfig.AdType.INTERSTITIAL.equalsIgnoreCase(this.adConfig.getType())) {
            loadInteractionAd(activity);
        } else if (AdConfig.AdType.REWARD_VIDEO.equalsIgnoreCase(this.adConfig.getType())) {
            loadVideoAd(activity);
        }
    }
}
