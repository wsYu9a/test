package com.martian.ads.ad;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.ViewWrapper;
import com.martian.libmars.d.h;
import com.martian.libsupport.k;
import com.vivo.ad.model.AdError;
import com.vivo.ad.nativead.NativeAdListener;
import com.vivo.ad.nativead.NativeResponse;
import com.vivo.mobilead.model.BackUrlInfo;
import com.vivo.mobilead.nativead.NativeAdParams;
import com.vivo.mobilead.nativead.VivoNativeAd;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.view.NativeVideoView;
import com.vivo.mobilead.unified.base.view.VivoNativeAdContainer;
import com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAd;
import com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener;
import com.vivo.mobilead.unified.splash.UnifiedVivoSplashAd;
import com.vivo.mobilead.unified.splash.UnifiedVivoSplashAdListener;
import java.util.List;

/* loaded from: classes2.dex */
public class VivoAd extends BaseAd {
    private boolean cancelLoading;
    private UnifiedVivoInterstitialAd vivoInterstitialAd;
    private UnifiedVivoSplashAd vivoSplashAd;

    /* renamed from: com.martian.ads.ad.VivoAd$1 */
    class AnonymousClass1 implements UnifiedVivoSplashAdListener {
        AnonymousClass1() {
        }

        @Override // com.vivo.mobilead.unified.splash.UnifiedVivoSplashAdListener
        public void onAdClick() {
            VivoAd.this.onClick();
        }

        @Override // com.vivo.mobilead.unified.splash.UnifiedVivoSplashAdListener
        public void onAdFailed(@NonNull VivoAdError vivoAdError) {
            VivoAd.this.fallback(new b.d.c.b.c(vivoAdError.getCode(), vivoAdError.getMsg()));
        }

        @Override // com.vivo.mobilead.unified.splash.UnifiedVivoSplashAdListener
        public void onAdReady(@NonNull View view) {
            int price;
            AppTask appTask = VivoAd.this.getAppTaskList().getApps().get(0);
            if (appTask != null) {
                appTask.customView = new ViewWrapper(view);
                if ((VivoAd.this.adConfig.isBidding() || VivoAd.this.vivoSplashAd.getPrice() > 0) && (price = VivoAd.this.vivoSplashAd.getPrice()) > 0) {
                    appTask.setEcpm(price);
                    VivoAd.this.adConfig.setEcpm(price);
                }
            }
            VivoAd.this.onAdReceived();
        }

        @Override // com.vivo.mobilead.unified.splash.UnifiedVivoSplashAdListener
        public void onAdShow() {
            VivoAd.this.onExpose();
        }

        @Override // com.vivo.mobilead.unified.splash.UnifiedVivoSplashAdListener
        public void onAdSkip() {
            VivoAd.this.onClose();
        }

        @Override // com.vivo.mobilead.unified.splash.UnifiedVivoSplashAdListener
        public void onAdTimeOver() {
            VivoAd.this.onDismiss();
        }
    }

    /* renamed from: com.martian.ads.ad.VivoAd$2 */
    class AnonymousClass2 implements NativeAdListener {
        AnonymousClass2() {
        }

        @Override // com.vivo.ad.nativead.NativeAdListener
        public void onADLoaded(List<NativeResponse> list) {
            if (list == null || list.isEmpty()) {
                VivoAd.this.fallback(null);
                return;
            }
            for (NativeResponse nativeResponse : list) {
                if (nativeResponse != null) {
                    VivoAd.this.getAppTaskList().addAppTask(VivoAd.this.toAppTask(nativeResponse));
                }
            }
            VivoAd.this.onAdReceived();
        }

        @Override // com.vivo.ad.nativead.NativeAdListener
        public void onAdShow(NativeResponse nativeResponse) {
            VivoAd.this.onExpose();
        }

        @Override // com.vivo.ad.nativead.NativeAdListener
        public void onClick(NativeResponse nativeResponse) {
            VivoAd.this.onClick();
        }

        @Override // com.vivo.ad.nativead.NativeAdListener
        public void onNoAD(AdError adError) {
            VivoAd.this.fallback(new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMsg()));
        }
    }

    /* renamed from: com.martian.ads.ad.VivoAd$3 */
    class AnonymousClass3 implements UnifiedVivoInterstitialAdListener {
        AnonymousClass3() {
        }

        @Override // com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener
        public void onAdClick() {
            VivoAd.this.onClick();
        }

        @Override // com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener
        public void onAdClose() {
            VivoAd.this.onClose();
        }

        @Override // com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener
        public void onAdFailed(VivoAdError vivoAdError) {
            VivoAd.this.onError(new b.d.c.b.c(vivoAdError.getCode(), vivoAdError.getMsg()));
        }

        @Override // com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener
        public void onAdReady() {
            AppTask appTask = VivoAd.this.adConfig.toAppTask();
            appTask.origin = VivoAd.this.vivoInterstitialAd;
            int price = VivoAd.this.vivoInterstitialAd.getPrice();
            if (VivoAd.this.adConfig.isBidding() || price > 0) {
                appTask.setEcpm(price);
                VivoAd.this.adConfig.setEcpm(price);
            }
            VivoAd.this.getAppTaskList().addAppTask(appTask);
            VivoAd.this.onAdReceived();
        }

        @Override // com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener
        public void onAdShow() {
            VivoAd.this.onExpose();
        }
    }

    public VivoAd(AdConfig config, @NonNull b.d.a.k.a receiver) {
        super(config, receiver);
        this.cancelLoading = false;
    }

    public static void bindFlowAd(Activity activity, final AppTask appTask, ViewGroup adContainer, View adView, ViewGroup videoView, View creativeView, final b.d.a.k.a innerListener) {
        if (adContainer == null || adView == null) {
            return;
        }
        NativeVideoView nativeVideoView = null;
        if (appTask.isVideoAd && videoView != null) {
            videoView.setVisibility(0);
            videoView.removeAllViews();
            nativeVideoView = new NativeVideoView(activity);
            videoView.addView(nativeVideoView);
        }
        adContainer.removeAllViews();
        ViewGroup viewGroup = (ViewGroup) adView.getParent();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        VivoNativeAdContainer vivoNativeAdContainer = new VivoNativeAdContainer(activity);
        vivoNativeAdContainer.addView(adView, -1, -2);
        adContainer.addView(vivoNativeAdContainer);
        if (nativeVideoView == null) {
            ((NativeResponse) appTask.origin).registerView(vivoNativeAdContainer, creativeView);
        } else {
            ((NativeResponse) appTask.origin).registerView(vivoNativeAdContainer, creativeView, nativeVideoView);
            nativeVideoView.start();
        }
    }

    public void fallback(b.d.c.b.c errorResult) {
        onError(errorResult);
    }

    public static boolean isVivoAd(AppTask appTask) {
        return appTask != null && (appTask.origin instanceof NativeResponse);
    }

    private void loadInteractionAd(Activity activity) {
        AdParams.Builder builder = new AdParams.Builder(this.adConfig.getAdsId());
        builder.setWxAppid(this.adConfig.getWxAppid());
        builder.setBackUrlInfo(new BackUrlInfo("vivobrowser://browser.vivo.com", "testabcdteststststststtsst"));
        UnifiedVivoInterstitialAd unifiedVivoInterstitialAd = new UnifiedVivoInterstitialAd(activity, builder.build(), new UnifiedVivoInterstitialAdListener() { // from class: com.martian.ads.ad.VivoAd.3
            AnonymousClass3() {
            }

            @Override // com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener
            public void onAdClick() {
                VivoAd.this.onClick();
            }

            @Override // com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener
            public void onAdClose() {
                VivoAd.this.onClose();
            }

            @Override // com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener
            public void onAdFailed(VivoAdError vivoAdError) {
                VivoAd.this.onError(new b.d.c.b.c(vivoAdError.getCode(), vivoAdError.getMsg()));
            }

            @Override // com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener
            public void onAdReady() {
                AppTask appTask = VivoAd.this.adConfig.toAppTask();
                appTask.origin = VivoAd.this.vivoInterstitialAd;
                int price = VivoAd.this.vivoInterstitialAd.getPrice();
                if (VivoAd.this.adConfig.isBidding() || price > 0) {
                    appTask.setEcpm(price);
                    VivoAd.this.adConfig.setEcpm(price);
                }
                VivoAd.this.getAppTaskList().addAppTask(appTask);
                VivoAd.this.onAdReceived();
            }

            @Override // com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener
            public void onAdShow() {
                VivoAd.this.onExpose();
            }
        });
        this.vivoInterstitialAd = unifiedVivoInterstitialAd;
        unifiedVivoInterstitialAd.loadVideoAd();
    }

    public static void sendInterstitialLossNotification(int winPrice, @NonNull UnifiedVivoInterstitialAd vivoInterstitialAd) {
        vivoInterstitialAd.sendLossNotification(1, winPrice);
    }

    public static void sendLossNotification(int winPrice, @NonNull NativeResponse nativeResponse, int reason) {
        nativeResponse.sendLossNotification(reason, winPrice);
    }

    public static void sendSplashLossNotification(int winPrice, @NonNull UnifiedVivoSplashAd splashAd) {
        splashAd.sendLossNotification(1, winPrice);
    }

    public static void sendWinNotification(NativeResponse nativeResponse) {
        nativeResponse.sendWinNotification(0);
    }

    public static boolean showInterstitialAd(Activity activity, @NonNull UnifiedVivoInterstitialAd vivoInterstitialAd, boolean isBidding) {
        if (isBidding) {
            vivoInterstitialAd.sendWinNotification(0);
        }
        vivoInterstitialAd.showVideoAd(activity);
        return true;
    }

    public static void showSplashAd(AppTask appTask, ViewGroup viewGroup) {
        if (appTask.customView == null) {
            return;
        }
        if (appTask.isBidding()) {
            ((UnifiedVivoSplashAd) appTask.origin).sendWinNotification(0);
        }
        viewGroup.addView(appTask.customView.getView());
    }

    public AppTask toAppTask(NativeResponse nativeResponse) {
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = nativeResponse;
        appTask.title = h.F().n(nativeResponse.getTitle());
        appTask.desc = h.F().n(nativeResponse.getDesc());
        if (!k.p(nativeResponse.getIconUrl())) {
            appTask.iconUrl = nativeResponse.getIconUrl();
        } else if (!k.p(nativeResponse.getAdMarkUrl())) {
            appTask.iconUrl = nativeResponse.getAdMarkUrl();
        }
        if (nativeResponse.getAppMiitInfo() != null) {
            appTask.name = nativeResponse.getAppMiitInfo().getName();
        }
        List<String> imgUrl = nativeResponse.getImgUrl();
        if (imgUrl != null && !imgUrl.isEmpty()) {
            for (String str : imgUrl) {
                if (appTask.getPosterUrls().size() > 0 && k.p(appTask.iconUrl)) {
                    appTask.iconUrl = str;
                }
                appTask.addPosterUrl(str);
            }
        } else if (!k.p(nativeResponse.getIconUrl())) {
            appTask.addPosterUrl(nativeResponse.getIconUrl());
        } else if (!k.p(nativeResponse.getAdMarkUrl())) {
            appTask.addPosterUrl(nativeResponse.getAdMarkUrl());
        }
        if (k.p(appTask.iconUrl)) {
            appTask.iconUrl = appTask.getPosterUrl();
        }
        if (nativeResponse.getPrice() > 0) {
            appTask.setEcpm(nativeResponse.getPrice());
            this.adConfig.setEcpm(nativeResponse.getPrice());
        }
        try {
            int i2 = nativeResponse.getImgDimensions()[0];
            int i3 = nativeResponse.getImgDimensions()[1];
            if (i2 > 0 && i3 > 0) {
                appTask.setPicWidth(i2);
                appTask.setPicHeight(i3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.adConfig.isWifiEnv() && nativeResponse.getMaterialMode() == 4) {
            appTask.isVideoAd = true;
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
        if ("splash".equals(this.adConfig.getType())) {
            loadSplashAds(activity);
        }
        if (AdConfig.AdType.INTERSTITIAL.equals(this.adConfig.getType())) {
            loadInteractionAd(activity);
        } else {
            loadFlowAds(activity);
        }
    }

    protected void loadFlowAds(Activity activity) {
        NativeAdParams.Builder builder = new NativeAdParams.Builder(this.adConfig.getAdsId());
        builder.setWxAppId(this.adConfig.getWxAppid());
        new VivoNativeAd(activity, builder.build(), new NativeAdListener() { // from class: com.martian.ads.ad.VivoAd.2
            AnonymousClass2() {
            }

            @Override // com.vivo.ad.nativead.NativeAdListener
            public void onADLoaded(List<NativeResponse> list) {
                if (list == null || list.isEmpty()) {
                    VivoAd.this.fallback(null);
                    return;
                }
                for (NativeResponse nativeResponse : list) {
                    if (nativeResponse != null) {
                        VivoAd.this.getAppTaskList().addAppTask(VivoAd.this.toAppTask(nativeResponse));
                    }
                }
                VivoAd.this.onAdReceived();
            }

            @Override // com.vivo.ad.nativead.NativeAdListener
            public void onAdShow(NativeResponse nativeResponse) {
                VivoAd.this.onExpose();
            }

            @Override // com.vivo.ad.nativead.NativeAdListener
            public void onClick(NativeResponse nativeResponse) {
                VivoAd.this.onClick();
            }

            @Override // com.vivo.ad.nativead.NativeAdListener
            public void onNoAD(AdError adError) {
                VivoAd.this.fallback(new b.d.c.b.c(adError.getErrorCode(), adError.getErrorMsg()));
            }
        }).loadAd();
    }

    protected void loadSplashAds(Activity activity) {
        AdParams.Builder builder = new AdParams.Builder(this.adConfig.getAdsId());
        builder.setFetchTimeout(3000);
        builder.setWxAppid(this.adConfig.getWxAppid());
        builder.setSplashOrientation(1);
        this.vivoSplashAd = new UnifiedVivoSplashAd(activity, new UnifiedVivoSplashAdListener() { // from class: com.martian.ads.ad.VivoAd.1
            AnonymousClass1() {
            }

            @Override // com.vivo.mobilead.unified.splash.UnifiedVivoSplashAdListener
            public void onAdClick() {
                VivoAd.this.onClick();
            }

            @Override // com.vivo.mobilead.unified.splash.UnifiedVivoSplashAdListener
            public void onAdFailed(@NonNull VivoAdError vivoAdError) {
                VivoAd.this.fallback(new b.d.c.b.c(vivoAdError.getCode(), vivoAdError.getMsg()));
            }

            @Override // com.vivo.mobilead.unified.splash.UnifiedVivoSplashAdListener
            public void onAdReady(@NonNull View view) {
                int price;
                AppTask appTask = VivoAd.this.getAppTaskList().getApps().get(0);
                if (appTask != null) {
                    appTask.customView = new ViewWrapper(view);
                    if ((VivoAd.this.adConfig.isBidding() || VivoAd.this.vivoSplashAd.getPrice() > 0) && (price = VivoAd.this.vivoSplashAd.getPrice()) > 0) {
                        appTask.setEcpm(price);
                        VivoAd.this.adConfig.setEcpm(price);
                    }
                }
                VivoAd.this.onAdReceived();
            }

            @Override // com.vivo.mobilead.unified.splash.UnifiedVivoSplashAdListener
            public void onAdShow() {
                VivoAd.this.onExpose();
            }

            @Override // com.vivo.mobilead.unified.splash.UnifiedVivoSplashAdListener
            public void onAdSkip() {
                VivoAd.this.onClose();
            }

            @Override // com.vivo.mobilead.unified.splash.UnifiedVivoSplashAdListener
            public void onAdTimeOver() {
                VivoAd.this.onDismiss();
            }
        }, builder.build());
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = this.vivoSplashAd;
        getAppTaskList().addAppTask(appTask);
        this.vivoSplashAd.loadAd();
    }
}
