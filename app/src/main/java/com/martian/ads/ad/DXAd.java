package com.martian.ads.ad;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.martian.apptask.data.AppTask;
import com.martian.libmars.d.h;
import com.martian.libsupport.k;
import com.martian.ttbook.sdk.client.AdController;
import com.martian.ttbook.sdk.client.AdError;
import com.martian.ttbook.sdk.client.AdExtras;
import com.martian.ttbook.sdk.client.AdRequest;
import com.martian.ttbook.sdk.client.NativeAdData;
import com.martian.ttbook.sdk.client.NativeAdListener;
import com.martian.ttbook.sdk.client.VideoSettings;
import com.martian.ttbook.sdk.client.feedlist.FeedListNativeAdListener;
import com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener;
import com.martian.ttbook.sdk.client.splash.SplashAdExtListener;
import com.martian.ttbook.sdk.client.video.RewardVideoAdListener2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class DXAd extends BaseAd {
    private AdRequest adRequest;
    private boolean cancelLoading;

    /* renamed from: com.martian.ads.ad.DXAd$1 */
    class AnonymousClass1 implements SplashAdExtListener {
        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.splash.SplashAdListener
        public void onAdClicked() {
            DXAd.this.onClick();
        }

        @Override // com.martian.ttbook.sdk.client.splash.SplashAdListener
        public void onAdDismissed() {
            DXAd.this.onDismiss();
            DXAd.this.recycleRequest();
        }

        @Override // com.martian.ttbook.sdk.client.splash.SplashAdListener, com.martian.ttbook.sdk.client.AdCommonListener
        public void onAdError(AdError adError) {
            DXAd.this.fallback(new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMessage()));
        }

        @Override // com.martian.ttbook.sdk.client.splash.SplashAdListener
        public void onAdExposure() {
            DXAd.this.onExpose();
        }

        @Override // com.martian.ttbook.sdk.client.splash.SplashAdExtListener
        public void onAdLoaded(AdController adController) {
            AppTask appTask = DXAd.this.adConfig.toAppTask();
            appTask.origin = adController;
            DXAd.this.getAppTaskList().addAppTask(appTask);
            DXAd.this.onAdReceived();
        }

        @Override // com.martian.ttbook.sdk.client.splash.SplashAdListener
        public void onAdShow() {
        }

        @Override // com.martian.ttbook.sdk.client.splash.SplashAdExtListener
        public void onAdSkip() {
        }

        @Override // com.martian.ttbook.sdk.client.splash.SplashAdExtListener
        public void onAdTick(long l) {
        }
    }

    /* renamed from: com.martian.ads.ad.DXAd$2 */
    class AnonymousClass2 implements FeedListNativeAdListener {
        AnonymousClass2() {
        }

        @Override // com.martian.ttbook.sdk.client.AdCommonListener
        public void onAdError(AdError adError) {
            DXAd.this.fallback(new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMessage()));
        }

        @Override // com.martian.ttbook.sdk.client.feedlist.FeedListNativeAdListener
        public void onAdLoaded(List<NativeAdData> list) {
            if (list == null || list.isEmpty()) {
                DXAd.this.fallback(null);
                return;
            }
            Iterator<NativeAdData> it = list.iterator();
            while (it.hasNext()) {
                DXAd.this.getAppTaskList().addAppTask(DXAd.this.toAppTask(it.next()));
            }
            DXAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.DXAd$3 */
    class AnonymousClass3 implements RewardVideoAdListener2 {
        boolean onRewarded = false;

        AnonymousClass3() {
        }

        @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener2
        public View getSkipView(Activity activity) {
            return null;
        }

        @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
        public void onAdClicked() {
            DXAd.this.onClick();
        }

        @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
        public void onAdDismissed() {
            if (this.onRewarded) {
                DXAd.this.onClose();
            }
            DXAd.this.recycleRequest();
        }

        @Override // com.martian.ttbook.sdk.client.AdCommonListener
        public void onAdError(AdError adError) {
            DXAd.this.fallback(new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMessage()));
        }

        @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
        public void onAdExposure() {
            DXAd.this.onExpose();
        }

        @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener2
        public void onAdLoaded(AdController adController) {
        }

        @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
        public void onAdShow() {
        }

        @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
        public void onAdVideoCompleted() {
        }

        @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
        public void onReward() {
            this.onRewarded = true;
            DXAd.this.onRewardVerify(true);
        }
    }

    /* renamed from: com.martian.ads.ad.DXAd$4 */
    class AnonymousClass4 implements InterstitialAdListener {
        AnonymousClass4() {
        }

        @Override // com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener
        public void onAdClicked() {
            DXAd.this.onClick();
        }

        @Override // com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener
        public void onAdDismissed() {
            DXAd.this.onDismiss();
            DXAd.this.recycleRequest();
        }

        @Override // com.martian.ttbook.sdk.client.AdCommonListener
        public void onAdError(AdError adError) {
            DXAd.this.fallback(new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMessage()));
        }

        @Override // com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener
        public void onAdExposure() {
            DXAd.this.onExpose();
        }

        @Override // com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener
        public void onAdShow() {
        }
    }

    /* renamed from: com.martian.ads.ad.DXAd$5 */
    static class AnonymousClass5 implements NativeAdListener {
        final /* synthetic */ AppTask val$appTask;

        AnonymousClass5(final AppTask val$innerListener) {
            appTask = val$innerListener;
        }

        @Override // com.martian.ttbook.sdk.client.data.AdDataListener
        public void onADClicked() {
            b.d.a.k.a.this.j(b.d.a.j.b.Q(appTask));
        }

        @Override // com.martian.ttbook.sdk.client.data.AdDataListener
        public void onADExposed() {
            b.d.a.j.b.J(appTask, b.d.a.k.a.this);
        }

        @Override // com.martian.ttbook.sdk.client.AdCommonListener
        public void onAdError(AdError adError) {
            b.d.a.k.a.this.g(b.d.a.j.b.Q(appTask), new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMessage()));
        }
    }

    public DXAd(AdConfig config, @NonNull b.d.a.k.a receiver) {
        super(config, receiver);
        this.cancelLoading = false;
    }

    public static void bindFlowAd(Activity activity, final AppTask appTask, ViewGroup adContainer, View adView, ViewGroup videoView, View creativeView, final b.d.a.k.a innerListener) {
        if (adContainer == null || adView == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (creativeView != null) {
            arrayList.add(creativeView);
        }
        View bindView = ((NativeAdData) appTask.origin).bindView(adView, null, new FrameLayout.LayoutParams(0, 0), arrayList, new NativeAdListener() { // from class: com.martian.ads.ad.DXAd.5
            final /* synthetic */ AppTask val$appTask;

            AnonymousClass5(final AppTask appTask2) {
                appTask = appTask2;
            }

            @Override // com.martian.ttbook.sdk.client.data.AdDataListener
            public void onADClicked() {
                b.d.a.k.a.this.j(b.d.a.j.b.Q(appTask));
            }

            @Override // com.martian.ttbook.sdk.client.data.AdDataListener
            public void onADExposed() {
                b.d.a.j.b.J(appTask, b.d.a.k.a.this);
            }

            @Override // com.martian.ttbook.sdk.client.AdCommonListener
            public void onAdError(AdError adError) {
                b.d.a.k.a.this.g(b.d.a.j.b.Q(appTask), new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMessage()));
            }
        });
        if (bindView != null) {
            ViewGroup viewGroup = (ViewGroup) bindView.getParent();
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            adContainer.removeAllViews();
            adContainer.addView(bindView);
        }
    }

    public void fallback(b.d.c.b.c errorResult) {
        onError(errorResult);
        recycleRequest();
    }

    public static boolean isDxFlowAd(AppTask appTask) {
        return appTask != null && (appTask.origin instanceof NativeAdData);
    }

    private void loadFlowAds(Activity activity) {
        this.adRequest = new AdRequest.Builder(activity).setCodeId(this.adConfig.getAdsId()).setVideoSettings(new VideoSettings.Builder().setAutoPlayPolicy(1).setAutoPlayMuted(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).setContainerRender(1).setVideoPlayPolicy(1).build()).setSupportVideo(true).setAdRequestCount(1).build().loadFeedListNativeAd(new FeedListNativeAdListener() { // from class: com.martian.ads.ad.DXAd.2
            AnonymousClass2() {
            }

            @Override // com.martian.ttbook.sdk.client.AdCommonListener
            public void onAdError(AdError adError) {
                DXAd.this.fallback(new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMessage()));
            }

            @Override // com.martian.ttbook.sdk.client.feedlist.FeedListNativeAdListener
            public void onAdLoaded(List<NativeAdData> list) {
                if (list == null || list.isEmpty()) {
                    DXAd.this.fallback(null);
                    return;
                }
                Iterator<NativeAdData> it = list.iterator();
                while (it.hasNext()) {
                    DXAd.this.getAppTaskList().addAppTask(DXAd.this.toAppTask(it.next()));
                }
                DXAd.this.onAdReceived();
            }
        });
    }

    private void loadInteractionAd(Activity activity) {
        this.adRequest = new AdRequest.Builder(activity).setCodeId(this.adConfig.getAdsId()).setSupportVideo(true).setVideoSettings(new VideoSettings.Builder().setAutoPlayMuted(false).setAutoPlayPolicy(1).setVideoPlayPolicy(1).build()).build().loadInterstitialAd(new InterstitialAdListener() { // from class: com.martian.ads.ad.DXAd.4
            AnonymousClass4() {
            }

            @Override // com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener
            public void onAdClicked() {
                DXAd.this.onClick();
            }

            @Override // com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener
            public void onAdDismissed() {
                DXAd.this.onDismiss();
                DXAd.this.recycleRequest();
            }

            @Override // com.martian.ttbook.sdk.client.AdCommonListener
            public void onAdError(AdError adError) {
                DXAd.this.fallback(new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMessage()));
            }

            @Override // com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener
            public void onAdExposure() {
                DXAd.this.onExpose();
            }

            @Override // com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener
            public void onAdShow() {
            }
        });
    }

    private void loadSplashAds(Activity activity) {
        this.adRequest = new AdRequest.Builder(activity).setCodeId(this.adConfig.getAdsId()).setTimeoutMs(5000).build().loadSplashAd(new SplashAdExtListener() { // from class: com.martian.ads.ad.DXAd.1
            AnonymousClass1() {
            }

            @Override // com.martian.ttbook.sdk.client.splash.SplashAdListener
            public void onAdClicked() {
                DXAd.this.onClick();
            }

            @Override // com.martian.ttbook.sdk.client.splash.SplashAdListener
            public void onAdDismissed() {
                DXAd.this.onDismiss();
                DXAd.this.recycleRequest();
            }

            @Override // com.martian.ttbook.sdk.client.splash.SplashAdListener, com.martian.ttbook.sdk.client.AdCommonListener
            public void onAdError(AdError adError) {
                DXAd.this.fallback(new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMessage()));
            }

            @Override // com.martian.ttbook.sdk.client.splash.SplashAdListener
            public void onAdExposure() {
                DXAd.this.onExpose();
            }

            @Override // com.martian.ttbook.sdk.client.splash.SplashAdExtListener
            public void onAdLoaded(AdController adController) {
                AppTask appTask = DXAd.this.adConfig.toAppTask();
                appTask.origin = adController;
                DXAd.this.getAppTaskList().addAppTask(appTask);
                DXAd.this.onAdReceived();
            }

            @Override // com.martian.ttbook.sdk.client.splash.SplashAdListener
            public void onAdShow() {
            }

            @Override // com.martian.ttbook.sdk.client.splash.SplashAdExtListener
            public void onAdSkip() {
            }

            @Override // com.martian.ttbook.sdk.client.splash.SplashAdExtListener
            public void onAdTick(long l) {
            }
        }, true);
    }

    private void loadVideoAd(Activity activity) {
        AdRequest build = new AdRequest.Builder(activity).setCodeId(this.adConfig.getAdsId()).setRewardName("金币").setRewardAmount(1).setUserID(this.adConfig.getUid()).setVolumnOn(false).build();
        this.adRequest = build;
        build.loadRewardVideoAd(new RewardVideoAdListener2() { // from class: com.martian.ads.ad.DXAd.3
            boolean onRewarded = false;

            AnonymousClass3() {
            }

            @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener2
            public View getSkipView(Activity activity2) {
                return null;
            }

            @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
            public void onAdClicked() {
                DXAd.this.onClick();
            }

            @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
            public void onAdDismissed() {
                if (this.onRewarded) {
                    DXAd.this.onClose();
                }
                DXAd.this.recycleRequest();
            }

            @Override // com.martian.ttbook.sdk.client.AdCommonListener
            public void onAdError(AdError adError) {
                DXAd.this.fallback(new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMessage()));
            }

            @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
            public void onAdExposure() {
                DXAd.this.onExpose();
            }

            @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener2
            public void onAdLoaded(AdController adController) {
            }

            @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
            public void onAdShow() {
            }

            @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
            public void onAdVideoCompleted() {
            }

            @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
            public void onReward() {
                this.onRewarded = true;
                DXAd.this.onRewardVerify(true);
            }
        });
    }

    public void recycleRequest() {
        AdRequest adRequest = this.adRequest;
        if (adRequest != null) {
            adRequest.recycle();
            this.adRequest = null;
        }
    }

    public static void resumeAd(AppTask appTask) {
        if (isDxFlowAd(appTask)) {
            ((NativeAdData) appTask.origin).resume();
        }
    }

    public static void showSplashAd(@NonNull AdController adController, ViewGroup viewGroup) {
        adController.show(viewGroup);
    }

    public AppTask toAppTask(NativeAdData nativeAdData) {
        AdExtras adExtras;
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = nativeAdData;
        appTask.title = h.F().n(nativeAdData.getTitle());
        appTask.desc = h.F().n(nativeAdData.getDesc());
        appTask.aliasUnion = this.adConfig.getAliasUnion();
        if (!k.p(nativeAdData.getIconUrl())) {
            appTask.iconUrl = nativeAdData.getIconUrl();
        }
        List<String> imageList = nativeAdData.getImageList();
        if (imageList == null || imageList.isEmpty()) {
            appTask.addPosterUrl(nativeAdData.getImageUrl());
        } else {
            for (String str : imageList) {
                if (appTask.getPosterUrls().size() > 0 && k.p(appTask.iconUrl)) {
                    appTask.iconUrl = str;
                }
                appTask.addPosterUrl(str);
            }
        }
        if (k.p(appTask.iconUrl)) {
            appTask.iconUrl = appTask.getPosterUrl();
        }
        if (this.adConfig.isBidding() && (adExtras = nativeAdData.getAdExtras()) != null) {
            try {
                int parseInt = Integer.parseInt(adExtras.getStringExtra(AdExtras.EXTRA_ECPM, "0"));
                if (parseInt > 0) {
                    int i2 = (int) (parseInt * 0.8f);
                    this.adConfig.setEcpm(i2);
                    appTask.setEcpm(i2);
                }
            } catch (Exception unused) {
            }
        }
        if (nativeAdData.getAdAppMiitInfo() != null) {
            appTask.name = nativeAdData.getAdAppMiitInfo().getAppName();
        }
        if (nativeAdData.isAppAd()) {
            int appStatus = nativeAdData.getAppStatus();
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
        String type = this.adConfig.getType();
        type.hashCode();
        switch (type) {
            case "native":
                loadFlowAds(activity);
                return;
            case "splash":
                loadSplashAds(activity);
                return;
            case "interstitial":
                loadInteractionAd(activity);
                return;
            case "reward_video":
                loadVideoAd(activity);
                return;
            default:
                if (!h.F().Q0()) {
                    loadFlowAds(activity);
                    return;
                }
                throw new IllegalStateException("invalid ads type:" + this.adConfig.getType());
        }
    }
}
