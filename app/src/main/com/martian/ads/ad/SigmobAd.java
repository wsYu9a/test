package com.martian.ads.ad;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import ba.l;
import com.martian.ads.ad.GroMoreAd;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.ComplianceInfo;
import com.martian.libmars.common.ConfigSingleton;
import com.sigmob.sdk.base.models.SigImage;
import com.sigmob.windad.Splash.WindSplashAD;
import com.sigmob.windad.Splash.WindSplashADListener;
import com.sigmob.windad.Splash.WindSplashAdRequest;
import com.sigmob.windad.WindAdBiddingLossReason;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.natives.AdAppInfo;
import com.sigmob.windad.natives.NativeADEventListener;
import com.sigmob.windad.natives.WindNativeAdData;
import com.sigmob.windad.natives.WindNativeAdRequest;
import com.sigmob.windad.natives.WindNativeUnifiedAd;
import com.sigmob.windad.newInterstitial.WindNewInterstitialAd;
import com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener;
import com.sigmob.windad.newInterstitial.WindNewInterstitialAdRequest;
import com.sigmob.windad.rewardVideo.WindRewardAdRequest;
import com.sigmob.windad.rewardVideo.WindRewardInfo;
import com.sigmob.windad.rewardVideo.WindRewardVideoAd;
import com.sigmob.windad.rewardVideo.WindRewardVideoAdListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import l9.p0;
import x8.c;

/* loaded from: classes3.dex */
public class SigmobAd extends BaseAd {

    /* renamed from: com.martian.ads.ad.SigmobAd$1 */
    public class AnonymousClass1 implements WindSplashADListener {
        public AnonymousClass1() {
        }

        @Override // com.sigmob.windad.Splash.WindSplashADListener
        public void onSplashAdClick(String str) {
            SigmobAd.this.onClick();
        }

        @Override // com.sigmob.windad.Splash.WindSplashADListener
        public void onSplashAdClose(String str) {
            SigmobAd.this.onClose();
        }

        @Override // com.sigmob.windad.Splash.WindSplashADListener
        public void onSplashAdLoadFail(WindAdError windAdError, String str) {
            SigmobAd.this.fallback(new c(windAdError.getErrorCode(), windAdError.getMessage()));
        }

        @Override // com.sigmob.windad.Splash.WindSplashADListener
        public void onSplashAdLoadSuccess(String str) {
            if (SigmobAd.this.adConfig.isBidding()) {
                AppTask appTask = SigmobAd.this.getAppTaskList().getApps().get(0);
                SigmobAd.this.setBiddingEcpm(appTask, ((WindSplashAD) appTask.origin).getEcpm());
            }
            SigmobAd.this.onAdReceived();
        }

        @Override // com.sigmob.windad.Splash.WindSplashADListener
        public void onSplashAdShow(String str) {
            SigmobAd.this.onExpose();
        }

        @Override // com.sigmob.windad.Splash.WindSplashADListener
        public void onSplashAdShowError(WindAdError windAdError, String str) {
            SigmobAd.this.onClose();
        }

        @Override // com.sigmob.windad.Splash.WindSplashADListener
        public void onSplashAdSkip(String str) {
            SigmobAd.this.onDismiss();
        }
    }

    /* renamed from: com.martian.ads.ad.SigmobAd$2 */
    public class AnonymousClass2 implements WindNewInterstitialAdListener {
        final /* synthetic */ WindNewInterstitialAd val$windNewInterstitialAd;

        public AnonymousClass2(WindNewInterstitialAd windNewInterstitialAd) {
            windNewInterstitialAd = windNewInterstitialAd;
        }

        @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
        public void onInterstitialAdClicked(String str) {
            SigmobAd.this.onClick();
        }

        @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
        public void onInterstitialAdClosed(String str) {
            SigmobAd.this.onClose();
            SigmobAd.this.onDismiss();
            SigmobAd.this.onRewardVerify(true);
            windNewInterstitialAd.destroy();
        }

        @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
        public void onInterstitialAdLoadError(WindAdError windAdError, String str) {
            SigmobAd.this.fallback(new c(windAdError.getErrorCode(), windAdError.getMessage()));
            windNewInterstitialAd.destroy();
        }

        @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
        public void onInterstitialAdLoadSuccess(String str) {
            AppTask appTask = SigmobAd.this.adConfig.toAppTask();
            appTask.origin = windNewInterstitialAd;
            SigmobAd.this.getAppTaskList().addAppTask(appTask);
            if (SigmobAd.this.adConfig.isBidding()) {
                SigmobAd.this.setBiddingEcpm(appTask, windNewInterstitialAd.getEcpm());
            }
            SigmobAd.this.onAdReceived();
        }

        @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
        public void onInterstitialAdPreLoadFail(String str) {
            SigmobAd.this.fallback(new c(-1, "PreLoadFail"));
            windNewInterstitialAd.destroy();
        }

        @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
        public void onInterstitialAdPreLoadSuccess(String str) {
        }

        @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
        public void onInterstitialAdShow(String str) {
            SigmobAd.this.onExpose();
        }

        @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
        public void onInterstitialAdShowError(WindAdError windAdError, String str) {
        }
    }

    /* renamed from: com.martian.ads.ad.SigmobAd$3 */
    public class AnonymousClass3 implements WindRewardVideoAdListener {
        final /* synthetic */ WindRewardVideoAd val$windRewardVideoAd;
        private boolean verify = false;

        public AnonymousClass3(WindRewardVideoAd windRewardVideoAd) {
            windRewardVideoAd = windRewardVideoAd;
        }

        @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
        public void onRewardAdClicked(String str) {
            SigmobAd.this.onClick();
        }

        @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
        public void onRewardAdClosed(String str) {
            SigmobAd.this.onClose();
            SigmobAd.this.onRewardVerify(this.verify);
            windRewardVideoAd.destroy();
        }

        @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
        public void onRewardAdLoadError(WindAdError windAdError, String str) {
            SigmobAd.this.fallback(new c(windAdError.getErrorCode(), windAdError.getMessage()));
        }

        @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
        public void onRewardAdLoadSuccess(String str) {
            AppTask appTask = SigmobAd.this.adConfig.toAppTask();
            appTask.origin = windRewardVideoAd;
            if (SigmobAd.this.adConfig.isBidding()) {
                SigmobAd.this.setBiddingEcpm(appTask, windRewardVideoAd.getEcpm());
            }
            SigmobAd.this.getAppTaskList().addAppTask(appTask);
            SigmobAd.this.onAdReceived();
        }

        @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
        public void onRewardAdPlayEnd(String str) {
        }

        @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
        public void onRewardAdPlayError(WindAdError windAdError, String str) {
            SigmobAd.this.onClose();
        }

        @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
        public void onRewardAdPlayStart(String str) {
            SigmobAd.this.onExpose();
        }

        @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
        public void onRewardAdPreLoadFail(String str) {
            SigmobAd.this.fallback(new c(-1, "PreLoadFail"));
            windRewardVideoAd.destroy();
        }

        @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
        public void onRewardAdPreLoadSuccess(String str) {
        }

        @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
        public void onRewardAdRewarded(WindRewardInfo windRewardInfo, String str) {
            this.verify = true;
        }
    }

    /* renamed from: com.martian.ads.ad.SigmobAd$4 */
    public class AnonymousClass4 implements WindNativeUnifiedAd.WindNativeAdLoadListener {
        final /* synthetic */ WindNativeUnifiedAd val$windNativeUnifiedAd;

        public AnonymousClass4(WindNativeUnifiedAd windNativeUnifiedAd) {
            windNativeUnifiedAd = windNativeUnifiedAd;
        }

        @Override // com.sigmob.windad.natives.WindNativeUnifiedAd.WindNativeAdLoadListener
        public void onAdError(WindAdError windAdError, String str) {
            SigmobAd.this.fallback(new c(windAdError.getErrorCode(), windAdError.getMessage()));
        }

        @Override // com.sigmob.windad.natives.WindNativeUnifiedAd.WindNativeAdLoadListener
        public void onAdLoad(List<WindNativeAdData> list, String str) {
            if (list == null || list.isEmpty()) {
                SigmobAd.this.fallback(null);
                return;
            }
            AppTask appTask = SigmobAd.this.toAppTask(list.get(0));
            if (SigmobAd.this.adConfig.isBidding()) {
                SigmobAd.this.setBiddingEcpm(appTask, windNativeUnifiedAd.getEcpm());
                appTask.backupOrigin = windNativeUnifiedAd;
            }
            SigmobAd.this.getAppTaskList().addAppTask(appTask);
            SigmobAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.SigmobAd$5 */
    public class AnonymousClass5 implements NativeADEventListener {
        final /* synthetic */ AdConfig val$adConfig;

        public AnonymousClass5(AdConfig adConfig) {
            adConfig = adConfig;
        }

        @Override // com.sigmob.windad.natives.NativeADEventListener
        public void onAdClicked() {
            d8.a.this.l(adConfig);
        }

        @Override // com.sigmob.windad.natives.NativeADEventListener
        public void onAdDetailDismiss() {
        }

        @Override // com.sigmob.windad.natives.NativeADEventListener
        public void onAdDetailShow() {
        }

        @Override // com.sigmob.windad.natives.NativeADEventListener
        public void onAdError(WindAdError windAdError) {
        }

        @Override // com.sigmob.windad.natives.NativeADEventListener
        public void onAdExposed() {
            d8.a.this.b(adConfig);
        }
    }

    /* renamed from: com.martian.ads.ad.SigmobAd$6 */
    public class AnonymousClass6 implements WindNativeAdData.NativeADMediaListener {
        @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
        public void onVideoCompleted() {
        }

        @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
        public void onVideoError(WindAdError windAdError) {
        }

        @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
        public void onVideoLoad() {
        }

        @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
        public void onVideoPause() {
        }

        @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
        public void onVideoResume() {
        }

        @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
        public void onVideoStart() {
        }
    }

    public SigmobAd(AdConfig adConfig, @NonNull d8.a aVar, Handler handler) {
        super(adConfig, aVar, handler);
    }

    public static void bindFlowAd(AppTask appTask, ViewGroup viewGroup, View view, GroMoreAd.AdViewHolder adViewHolder, d8.a aVar) {
        FrameLayout frameLayout;
        WindNativeAdData windNativeAdData = (WindNativeAdData) appTask.origin;
        if (appTask.isBidding()) {
            Object obj = appTask.backupOrigin;
            if (obj instanceof WindNativeUnifiedAd) {
                ((WindNativeUnifiedAd) obj).sendWinNotificationWithInfo(getWinNotificationInfo(appTask));
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(viewGroup);
        arrayList.add(view);
        ArrayList arrayList2 = new ArrayList();
        if (adViewHolder != null) {
            Button button = adViewHolder.mCreativeButton;
            if (button != null) {
                arrayList2.add(button);
            }
            View view2 = adViewHolder.mCreativeButtonView;
            if (view2 != null) {
                arrayList2.add(view2);
            }
            if (appTask.isShakeStyle()) {
                int i10 = appTask.isPortraitAd() ? 100 : 70;
                View widgetView = windNativeAdData.getWidgetView(i10, i10);
                if (widgetView != null && (frameLayout = adViewHolder.shakeViewContainer) != null) {
                    frameLayout.setVisibility(0);
                    adViewHolder.shakeViewContainer.addView(widgetView);
                }
            }
        }
        windNativeAdData.bindViewForInteraction(viewGroup, arrayList, arrayList2, null, new NativeADEventListener() { // from class: com.martian.ads.ad.SigmobAd.5
            final /* synthetic */ AdConfig val$adConfig;

            public AnonymousClass5(AdConfig adConfig) {
                adConfig = adConfig;
            }

            @Override // com.sigmob.windad.natives.NativeADEventListener
            public void onAdClicked() {
                d8.a.this.l(adConfig);
            }

            @Override // com.sigmob.windad.natives.NativeADEventListener
            public void onAdDetailDismiss() {
            }

            @Override // com.sigmob.windad.natives.NativeADEventListener
            public void onAdDetailShow() {
            }

            @Override // com.sigmob.windad.natives.NativeADEventListener
            public void onAdError(WindAdError windAdError) {
            }

            @Override // com.sigmob.windad.natives.NativeADEventListener
            public void onAdExposed() {
                d8.a.this.b(adConfig);
            }
        });
        if (adViewHolder != null) {
            if (windNativeAdData.getAdPatternType() == 1) {
                adViewHolder.videoView.setVisibility(0);
                windNativeAdData.bindMediaView(adViewHolder.videoView, new WindNativeAdData.NativeADMediaListener() { // from class: com.martian.ads.ad.SigmobAd.6
                    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
                    public void onVideoCompleted() {
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
                    public void onVideoError(WindAdError windAdError) {
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
                    public void onVideoLoad() {
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
                    public void onVideoPause() {
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
                    public void onVideoResume() {
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
                    public void onVideoStart() {
                    }
                });
            } else if (windNativeAdData.getAdPatternType() == 2) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(adViewHolder.mPoster);
                windNativeAdData.bindImageViews(arrayList3, 0);
            }
        }
    }

    public void fallback(c cVar) {
        onError(cVar);
    }

    private static String getAdn(String str) {
        str.hashCode();
        switch (str) {
            case "SIGMOB":
                return "1";
            case "KS":
                return "4";
            case "BQT":
                return "5";
            case "CSJ":
                return "2";
            case "GDT":
                return "3";
            default:
                return "1001";
        }
    }

    @NonNull
    private static ComplianceInfo getComplianceInfo(AdAppInfo adAppInfo) {
        ComplianceInfo complianceInfo = new ComplianceInfo();
        complianceInfo.setAppName(adAppInfo.getAppName());
        complianceInfo.setAppVersion(adAppInfo.getVersionName());
        complianceInfo.setAppDeveloperName(adAppInfo.getAuthorName());
        complianceInfo.setAppPermissionUrl(adAppInfo.getPermissionsUrl());
        complianceInfo.setAppPrivacyUrl(adAppInfo.getPrivacyAgreementUrl());
        complianceInfo.setAppFunctionDescUrl(adAppInfo.getDescriptionUrl());
        return complianceInfo;
    }

    private static Map<String, Object> getLossNotificationInfo(int i10, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(WindAds.AUCTION_PRICE, Integer.valueOf(i10));
        hashMap.put(WindAds.CURRENCY, WindAds.CNY);
        hashMap.put(WindAds.LOSS_REASON, Integer.valueOf(WindAdBiddingLossReason.LOSS_REASON_LOW_PRICE.getCode()));
        hashMap.put(WindAds.ADN_ID, getAdn(str));
        return hashMap;
    }

    private static Map<String, Object> getWinNotificationInfo(AppTask appTask) {
        HashMap hashMap = new HashMap();
        hashMap.put(WindAds.AUCTION_PRICE, Integer.valueOf(appTask.getEcpm()));
        hashMap.put(WindAds.HIGHEST_LOSS_PRICE, Integer.valueOf(appTask.getLoseEcpm()));
        hashMap.put(WindAds.CURRENCY, WindAds.CNY);
        return hashMap;
    }

    public static boolean isSigmobFlowAd(AppTask appTask) {
        return appTask != null && (appTask.origin instanceof WindNativeAdData);
    }

    public static boolean isSigmobInterstitialAd(AppTask appTask) {
        return appTask.origin instanceof WindNewInterstitialAd;
    }

    public static boolean isSigmobSplashAd(AppTask appTask) {
        return appTask.origin instanceof WindSplashAD;
    }

    public static boolean isSigmobVideoAd(AppTask appTask) {
        return appTask.origin instanceof WindRewardVideoAd;
    }

    private void loadInterstitialAd() {
        WindNewInterstitialAd windNewInterstitialAd = new WindNewInterstitialAd(new WindNewInterstitialAdRequest(this.adConfig.getAdsId(), null, new HashMap()));
        windNewInterstitialAd.setWindNewInterstitialAdListener(new WindNewInterstitialAdListener() { // from class: com.martian.ads.ad.SigmobAd.2
            final /* synthetic */ WindNewInterstitialAd val$windNewInterstitialAd;

            public AnonymousClass2(WindNewInterstitialAd windNewInterstitialAd2) {
                windNewInterstitialAd = windNewInterstitialAd2;
            }

            @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
            public void onInterstitialAdClicked(String str) {
                SigmobAd.this.onClick();
            }

            @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
            public void onInterstitialAdClosed(String str) {
                SigmobAd.this.onClose();
                SigmobAd.this.onDismiss();
                SigmobAd.this.onRewardVerify(true);
                windNewInterstitialAd.destroy();
            }

            @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
            public void onInterstitialAdLoadError(WindAdError windAdError, String str) {
                SigmobAd.this.fallback(new c(windAdError.getErrorCode(), windAdError.getMessage()));
                windNewInterstitialAd.destroy();
            }

            @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
            public void onInterstitialAdLoadSuccess(String str) {
                AppTask appTask = SigmobAd.this.adConfig.toAppTask();
                appTask.origin = windNewInterstitialAd;
                SigmobAd.this.getAppTaskList().addAppTask(appTask);
                if (SigmobAd.this.adConfig.isBidding()) {
                    SigmobAd.this.setBiddingEcpm(appTask, windNewInterstitialAd.getEcpm());
                }
                SigmobAd.this.onAdReceived();
            }

            @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
            public void onInterstitialAdPreLoadFail(String str) {
                SigmobAd.this.fallback(new c(-1, "PreLoadFail"));
                windNewInterstitialAd.destroy();
            }

            @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
            public void onInterstitialAdPreLoadSuccess(String str) {
            }

            @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
            public void onInterstitialAdShow(String str) {
                SigmobAd.this.onExpose();
            }

            @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
            public void onInterstitialAdShowError(WindAdError windAdError, String str) {
            }
        });
        windNewInterstitialAd2.loadAd();
    }

    private void loadSplashAds() {
        WindSplashAdRequest windSplashAdRequest = new WindSplashAdRequest(this.adConfig.getAdsId(), null, new HashMap());
        windSplashAdRequest.setDisableAutoHideAd(true);
        windSplashAdRequest.setFetchDelay(5);
        WindSplashAD windSplashAD = new WindSplashAD(windSplashAdRequest, new WindSplashADListener() { // from class: com.martian.ads.ad.SigmobAd.1
            public AnonymousClass1() {
            }

            @Override // com.sigmob.windad.Splash.WindSplashADListener
            public void onSplashAdClick(String str) {
                SigmobAd.this.onClick();
            }

            @Override // com.sigmob.windad.Splash.WindSplashADListener
            public void onSplashAdClose(String str) {
                SigmobAd.this.onClose();
            }

            @Override // com.sigmob.windad.Splash.WindSplashADListener
            public void onSplashAdLoadFail(WindAdError windAdError, String str) {
                SigmobAd.this.fallback(new c(windAdError.getErrorCode(), windAdError.getMessage()));
            }

            @Override // com.sigmob.windad.Splash.WindSplashADListener
            public void onSplashAdLoadSuccess(String str) {
                if (SigmobAd.this.adConfig.isBidding()) {
                    AppTask appTask = SigmobAd.this.getAppTaskList().getApps().get(0);
                    SigmobAd.this.setBiddingEcpm(appTask, ((WindSplashAD) appTask.origin).getEcpm());
                }
                SigmobAd.this.onAdReceived();
            }

            @Override // com.sigmob.windad.Splash.WindSplashADListener
            public void onSplashAdShow(String str) {
                SigmobAd.this.onExpose();
            }

            @Override // com.sigmob.windad.Splash.WindSplashADListener
            public void onSplashAdShowError(WindAdError windAdError, String str) {
                SigmobAd.this.onClose();
            }

            @Override // com.sigmob.windad.Splash.WindSplashADListener
            public void onSplashAdSkip(String str) {
                SigmobAd.this.onDismiss();
            }
        });
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = windSplashAD;
        getAppTaskList().addAppTask(appTask);
        windSplashAD.loadAd();
    }

    private void loadVideoAd() {
        WindRewardVideoAd windRewardVideoAd = new WindRewardVideoAd(new WindRewardAdRequest(this.adConfig.getAdsId(), null, new HashMap()));
        windRewardVideoAd.setWindRewardVideoAdListener(new WindRewardVideoAdListener() { // from class: com.martian.ads.ad.SigmobAd.3
            final /* synthetic */ WindRewardVideoAd val$windRewardVideoAd;
            private boolean verify = false;

            public AnonymousClass3(WindRewardVideoAd windRewardVideoAd2) {
                windRewardVideoAd = windRewardVideoAd2;
            }

            @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
            public void onRewardAdClicked(String str) {
                SigmobAd.this.onClick();
            }

            @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
            public void onRewardAdClosed(String str) {
                SigmobAd.this.onClose();
                SigmobAd.this.onRewardVerify(this.verify);
                windRewardVideoAd.destroy();
            }

            @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
            public void onRewardAdLoadError(WindAdError windAdError, String str) {
                SigmobAd.this.fallback(new c(windAdError.getErrorCode(), windAdError.getMessage()));
            }

            @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
            public void onRewardAdLoadSuccess(String str) {
                AppTask appTask = SigmobAd.this.adConfig.toAppTask();
                appTask.origin = windRewardVideoAd;
                if (SigmobAd.this.adConfig.isBidding()) {
                    SigmobAd.this.setBiddingEcpm(appTask, windRewardVideoAd.getEcpm());
                }
                SigmobAd.this.getAppTaskList().addAppTask(appTask);
                SigmobAd.this.onAdReceived();
            }

            @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
            public void onRewardAdPlayEnd(String str) {
            }

            @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
            public void onRewardAdPlayError(WindAdError windAdError, String str) {
                SigmobAd.this.onClose();
            }

            @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
            public void onRewardAdPlayStart(String str) {
                SigmobAd.this.onExpose();
            }

            @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
            public void onRewardAdPreLoadFail(String str) {
                SigmobAd.this.fallback(new c(-1, "PreLoadFail"));
                windRewardVideoAd.destroy();
            }

            @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
            public void onRewardAdPreLoadSuccess(String str) {
            }

            @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
            public void onRewardAdRewarded(WindRewardInfo windRewardInfo, String str) {
                this.verify = true;
            }
        });
        windRewardVideoAd2.loadAd();
    }

    public static void sendInterstitialLossNotification(int i10, String str, AppTask appTask) {
        ((WindNewInterstitialAd) appTask.origin).sendLossNotificationWithInfo(getLossNotificationInfo(i10, str));
    }

    public static void sendLossNotification(int i10, String str, AppTask appTask) {
        if (appTask.isBidding()) {
            Object obj = appTask.backupOrigin;
            if (obj instanceof WindNativeUnifiedAd) {
                ((WindNativeUnifiedAd) obj).sendLossNotificationWithInfo(getLossNotificationInfo(i10, str));
            }
        }
    }

    public static void sendSplashLossNotification(int i10, String str, AppTask appTask) {
        ((WindSplashAD) appTask.origin).sendLossNotificationWithInfo(getLossNotificationInfo(i10, str));
    }

    public static void sendVideoLossNotification(int i10, String str, AppTask appTask) {
        ((WindRewardVideoAd) appTask.origin).sendLossNotificationWithInfo(getLossNotificationInfo(i10, str));
    }

    public void setBiddingEcpm(AppTask appTask, String str) {
        if (!l.q(str)) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt > 0 && this.adConfig.getEcpmPercent() > l5.c.f27899e) {
                    appTask.setOriginalEcpm(parseInt);
                    parseInt = (int) ((parseInt * this.adConfig.getEcpmPercent()) / 100.0d);
                }
                appTask.setEcpm(parseInt);
                this.adConfig.setEcpm(parseInt);
                return;
            } catch (Exception e10) {
                p0.b(e10.getMessage());
            }
        }
        appTask.setEcpm(0);
        this.adConfig.setEcpm(0);
    }

    public static void showInterstitialAd(AppTask appTask, d8.b bVar) {
        try {
            WindNewInterstitialAd windNewInterstitialAd = (WindNewInterstitialAd) appTask.origin;
            if (windNewInterstitialAd != null && windNewInterstitialAd.isReady()) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("scene_id", appTask.pid);
                if (appTask.isBidding()) {
                    windNewInterstitialAd.sendWinNotificationWithInfo(getWinNotificationInfo(appTask));
                }
                windNewInterstitialAd.show(hashMap);
                return;
            }
        } catch (Exception unused) {
        }
        if (bVar != null) {
            bVar.a();
        }
    }

    public static void showSplashAd(AppTask appTask, ViewGroup viewGroup, d8.b bVar) {
        WindSplashAD windSplashAD = (WindSplashAD) appTask.origin;
        if (appTask.isBidding()) {
            windSplashAD.sendWinNotificationWithInfo(getWinNotificationInfo(appTask));
        }
        if (windSplashAD.isReady()) {
            windSplashAD.show(viewGroup);
        } else {
            bVar.a();
        }
    }

    public static void showVideoAd(AppTask appTask, d8.b bVar) {
        try {
            WindRewardVideoAd windRewardVideoAd = (WindRewardVideoAd) appTask.origin;
            if (windRewardVideoAd != null && windRewardVideoAd.isReady()) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("scene_id", appTask.pid);
                if (appTask.isBidding()) {
                    windRewardVideoAd.sendWinNotificationWithInfo(getWinNotificationInfo(appTask));
                }
                windRewardVideoAd.show(hashMap);
                return;
            }
        } catch (Exception unused) {
        }
        if (bVar != null) {
            bVar.a();
        }
    }

    public AppTask toAppTask(WindNativeAdData windNativeAdData) {
        String str;
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = windNativeAdData;
        appTask.title = ConfigSingleton.D().s(windNativeAdData.getTitle());
        appTask.desc = ConfigSingleton.D().s(windNativeAdData.getDesc());
        appTask.appPromote = ConfigSingleton.D().s("赞助正版章节");
        if (windNativeAdData.getIconUrl() != null) {
            str = windNativeAdData.getIconUrl();
            appTask.iconUrl = str;
        } else {
            str = "";
        }
        List<SigImage> imageList = windNativeAdData.getImageList();
        if (imageList != null && !imageList.isEmpty()) {
            int i10 = 0;
            for (SigImage sigImage : imageList) {
                if (!appTask.getPosterUrls().isEmpty() && l.q(appTask.iconUrl)) {
                    appTask.iconUrl = sigImage.getImageUrl();
                }
                appTask.addPosterUrl(sigImage.getImageUrl());
                if (i10 == 0) {
                    appTask.setPicWidth(sigImage.getWidth());
                    appTask.setPicHeight(sigImage.getHeight());
                }
                i10++;
            }
        } else if (!l.q(str)) {
            appTask.addPosterUrl(str);
        }
        if (l.q(appTask.iconUrl)) {
            appTask.iconUrl = appTask.getPosterUrl();
        }
        if (!l.q(windNativeAdData.getCTAText())) {
            appTask.buttonText = ConfigSingleton.D().s(windNativeAdData.getCTAText());
        }
        if (windNativeAdData.getAdAppInfo() != null) {
            if (l.q(appTask.buttonText)) {
                appTask.buttonText = ConfigSingleton.D().s("立即下载");
            }
            AdAppInfo adAppInfo = windNativeAdData.getAdAppInfo();
            if (adAppInfo != null && !l.q(adAppInfo.getAppName()) && !l.q(adAppInfo.getAuthorName()) && !l.q(adAppInfo.getPrivacyAgreementUrl())) {
                appTask.setComplianceInfo(getComplianceInfo(adAppInfo));
                appTask.name = adAppInfo.getAppName();
            }
        }
        return appTask;
    }

    @Override // com.martian.ads.ad.BaseAd
    public void loadAds(Context context) {
        onAdRequest();
        String type = this.adConfig.getType();
        type.hashCode();
        switch (type) {
            case "native":
                loadFlowAds();
                break;
            case "splash":
                loadSplashAds();
                break;
            case "interstitial":
                loadInterstitialAd();
                break;
            case "reward_video":
                loadVideoAd();
                break;
            default:
                onError(null);
                break;
        }
    }

    public void loadFlowAds() {
        WindNativeUnifiedAd windNativeUnifiedAd = new WindNativeUnifiedAd(new WindNativeAdRequest(this.adConfig.getAdsId(), null, new HashMap()));
        windNativeUnifiedAd.setNativeAdLoadListener(new WindNativeUnifiedAd.WindNativeAdLoadListener() { // from class: com.martian.ads.ad.SigmobAd.4
            final /* synthetic */ WindNativeUnifiedAd val$windNativeUnifiedAd;

            public AnonymousClass4(WindNativeUnifiedAd windNativeUnifiedAd2) {
                windNativeUnifiedAd = windNativeUnifiedAd2;
            }

            @Override // com.sigmob.windad.natives.WindNativeUnifiedAd.WindNativeAdLoadListener
            public void onAdError(WindAdError windAdError, String str) {
                SigmobAd.this.fallback(new c(windAdError.getErrorCode(), windAdError.getMessage()));
            }

            @Override // com.sigmob.windad.natives.WindNativeUnifiedAd.WindNativeAdLoadListener
            public void onAdLoad(List<WindNativeAdData> list, String str) {
                if (list == null || list.isEmpty()) {
                    SigmobAd.this.fallback(null);
                    return;
                }
                AppTask appTask = SigmobAd.this.toAppTask(list.get(0));
                if (SigmobAd.this.adConfig.isBidding()) {
                    SigmobAd.this.setBiddingEcpm(appTask, windNativeUnifiedAd.getEcpm());
                    appTask.backupOrigin = windNativeUnifiedAd;
                }
                SigmobAd.this.getAppTaskList().addAppTask(appTask);
                SigmobAd.this.onAdReceived();
            }
        });
        windNativeUnifiedAd2.loadAd(this.adConfig.getAdsCount());
    }
}
