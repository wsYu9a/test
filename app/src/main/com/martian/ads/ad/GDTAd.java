package com.martian.ads.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import b8.o;
import ba.l;
import com.martian.ads.ad.GroMoreAd;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.ComplianceInfo;
import com.martian.libmars.common.ConfigSingleton;
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
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
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
import l9.p0;
import x8.c;

/* loaded from: classes3.dex */
public class GDTAd extends BaseAd {
    private UnifiedInterstitialAD iad;
    private RewardVideoAD rewardVideoAD;

    /* renamed from: com.martian.ads.ad.GDTAd$1 */
    public class AnonymousClass1 implements SplashADListener {
        public AnonymousClass1() {
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
        public void onADLoaded(long j10) {
            AppTask appTask = GDTAd.this.getAppTaskList().getApps().get(0);
            SplashAD splashAD = (SplashAD) appTask.origin;
            if (GDTAd.this.adConfig.isBidding()) {
                GDTAd.this.setBiddingEcpm(appTask, splashAD.getECPM());
            }
            GDTAd.this.onAdReceived();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADPresent() {
            GDTAd.this.onExpose();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADTick(long j10) {
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onNoAD(AdError adError) {
            GDTAd.this.onError(new c(adError.getErrorCode(), adError.getErrorMsg()));
        }
    }

    /* renamed from: com.martian.ads.ad.GDTAd$2 */
    public class AnonymousClass2 implements NativeADUnifiedListener {
        public AnonymousClass2() {
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
            GDTAd.this.onError(new c(adError.getErrorCode(), adError.getErrorMsg()));
        }
    }

    /* renamed from: com.martian.ads.ad.GDTAd$3 */
    public class AnonymousClass3 implements NativeExpressAD.NativeExpressADListener {
        public AnonymousClass3() {
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
        public void onADExposure(NativeExpressADView nativeExpressADView) {
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
                appTask.customView = new o(nativeExpressADView);
                appTask.setPicWidth(1184);
                appTask.setPicHeight(1898);
                if (GDTAd.this.adConfig.isBidding()) {
                    GDTAd.this.setBiddingEcpm(appTask, nativeExpressADView.getECPM());
                }
                GDTAd.this.getAppTaskList().addAppTask(appTask);
            }
            GDTAd.this.onAdReceived();
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            GDTAd.this.onError(new c(adError.getErrorCode(), adError.getErrorMsg()));
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            GDTAd.this.onError(new c(-1, "失败"));
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
        }
    }

    /* renamed from: com.martian.ads.ad.GDTAd$4 */
    public class AnonymousClass4 implements UnifiedInterstitialADListener {
        public AnonymousClass4() {
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
            if (GDTAd.this.adConfig.isBidding()) {
                GDTAd gDTAd = GDTAd.this;
                gDTAd.setBiddingEcpm(appTask, gDTAd.iad.getECPM());
            }
            GDTAd.this.getAppTaskList().addAppTask(appTask);
            GDTAd.this.onAdReceived();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onNoAD(AdError adError) {
            GDTAd.this.onError(new c(adError.getErrorCode(), adError.getErrorMsg()));
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

    /* renamed from: com.martian.ads.ad.GDTAd$5 */
    public class AnonymousClass5 implements RewardVideoADListener {
        private boolean reward = false;

        public AnonymousClass5() {
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
            if (GDTAd.this.adConfig.isBidding()) {
                GDTAd gDTAd = GDTAd.this;
                gDTAd.setBiddingEcpm(appTask, gDTAd.rewardVideoAD.getECPM());
            }
            GDTAd.this.getAppTaskList().addAppTask(appTask);
            GDTAd.this.onAdReceived();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADShow() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onError(AdError adError) {
            GDTAd.this.onError(new c(adError.getErrorCode(), adError.getErrorMsg()));
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

    /* renamed from: com.martian.ads.ad.GDTAd$6 */
    public class AnonymousClass6 implements NativeADEventListener {
        final /* synthetic */ AdConfig val$adConfig;

        public AnonymousClass6(AdConfig adConfig) {
            adConfig = adConfig;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            d8.a.this.l(adConfig);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
            d8.a.this.c(adConfig, new c(adError.getErrorCode(), adError.getErrorMsg()));
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            d8.a.this.b(adConfig);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
        }
    }

    /* renamed from: com.martian.ads.ad.GDTAd$7 */
    public class AnonymousClass7 implements NativeADMediaListener {
        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoClicked() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoCompleted() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoError(AdError adError) {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoInit() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoaded(int i10) {
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

    public GDTAd(AdConfig adConfig, @NonNull d8.a aVar, Handler handler) {
        super(adConfig, aVar, handler);
    }

    public static void bindFlowAd(Activity activity, AppTask appTask, ViewGroup viewGroup, View view, GroMoreAd.AdViewHolder adViewHolder, boolean z10, d8.a aVar) {
        NativeAdContainer nativeAdContainer;
        NativeAdContainer nativeAdContainer2;
        if (viewGroup == null || view == null) {
            return;
        }
        NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) appTask.origin;
        if (appTask.isBidding()) {
            sendWinNotification(nativeUnifiedADData);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (adViewHolder == null) {
            arrayList.add(view);
        } else if (z10 || appTask.getComplianceInfo() == null || adViewHolder.complianceView == null) {
            Button button = adViewHolder.mCreativeButton;
            if (button != null) {
                arrayList.add(button);
            }
            View view2 = adViewHolder.mCreativeButtonView;
            if (view2 != null) {
                arrayList.add(view2);
            }
            arrayList.add(view);
        } else {
            Button button2 = adViewHolder.mCreativeButton;
            if (button2 != null) {
                arrayList2.add(button2);
            }
            View view3 = adViewHolder.mCreativeButtonView;
            if (view3 != null) {
                arrayList2.add(view3);
            }
            arrayList2.add(view);
        }
        if (view instanceof NativeAdContainer) {
            NativeAdContainer nativeAdContainer3 = (NativeAdContainer) view;
            if (nativeAdContainer3.getChildCount() > 0) {
                arrayList.add(nativeAdContainer3.getChildAt(0));
            }
            nativeAdContainer2 = nativeAdContainer3;
        } else {
            viewGroup.removeAllViews();
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 instanceof NativeAdContainer) {
                nativeAdContainer = (NativeAdContainer) viewGroup2;
                ViewGroup viewGroup3 = (ViewGroup) nativeAdContainer.getParent();
                if (viewGroup3 != null) {
                    viewGroup3.removeAllViews();
                }
            } else {
                if (viewGroup2 != null) {
                    viewGroup2.removeAllViews();
                }
                nativeAdContainer = new NativeAdContainer(activity);
                nativeAdContainer.addView(view, -1, -1);
            }
            viewGroup.addView(nativeAdContainer);
            nativeAdContainer2 = nativeAdContainer;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, 0);
        if (arrayList2.isEmpty()) {
            nativeUnifiedADData.bindAdToView(activity, nativeAdContainer2, layoutParams, arrayList);
        } else {
            nativeUnifiedADData.bindAdToView(activity, nativeAdContainer2, layoutParams, arrayList, arrayList2);
        }
        nativeUnifiedADData.setNativeAdEventListener(new NativeADEventListener() { // from class: com.martian.ads.ad.GDTAd.6
            final /* synthetic */ AdConfig val$adConfig;

            public AnonymousClass6(AdConfig adConfig) {
                adConfig = adConfig;
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADClicked() {
                d8.a.this.l(adConfig);
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADError(AdError adError) {
                d8.a.this.c(adConfig, new c(adError.getErrorCode(), adError.getErrorMsg()));
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                d8.a.this.b(adConfig);
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
            }
        });
        if (nativeUnifiedADData.getAdPatternType() != 2 || adViewHolder == null || adViewHolder.videoView == null || !ConfigSingleton.D().N0()) {
            return;
        }
        MediaView mediaView = new MediaView(activity);
        adViewHolder.videoView.setVisibility(0);
        adViewHolder.videoView.removeAllViews();
        adViewHolder.videoView.addView(mediaView);
        nativeUnifiedADData.bindMediaView(mediaView, new VideoOption.Builder().setAutoPlayMuted(true).setAutoPlayPolicy(0).build(), new NativeADMediaListener() { // from class: com.martian.ads.ad.GDTAd.7
            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoClicked() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoCompleted() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoError(AdError adError) {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoInit() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoaded(int i10) {
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

    @NonNull
    private static ComplianceInfo getComplianceInfo(NativeUnifiedADAppMiitInfo nativeUnifiedADAppMiitInfo) {
        ComplianceInfo complianceInfo = new ComplianceInfo();
        complianceInfo.setAppName(nativeUnifiedADAppMiitInfo.getAppName());
        complianceInfo.setAppVersion(nativeUnifiedADAppMiitInfo.getVersionName());
        complianceInfo.setAppDeveloperName(nativeUnifiedADAppMiitInfo.getAuthorName());
        complianceInfo.setAppPermissionUrl(nativeUnifiedADAppMiitInfo.getPermissionsUrl());
        complianceInfo.setAppPrivacyUrl(nativeUnifiedADAppMiitInfo.getPrivacyAgreement());
        complianceInfo.setAppFunctionDescUrl(nativeUnifiedADAppMiitInfo.getDescriptionUrl());
        return complianceInfo;
    }

    public static boolean isGdtFlowAd(AppTask appTask) {
        return appTask != null && (appTask.origin instanceof NativeUnifiedADData);
    }

    public static boolean isGdtSplashAd(AppTask appTask) {
        return appTask.origin instanceof SplashAD;
    }

    public static boolean isGdtTemplateFlowAd(AppTask appTask) {
        return appTask != null && (appTask.customView instanceof o);
    }

    private void loadFlowAds(Context context) {
        NativeUnifiedAD nativeUnifiedAD = new NativeUnifiedAD(context, this.adConfig.getAdsId(), new NativeADUnifiedListener() { // from class: com.martian.ads.ad.GDTAd.2
            public AnonymousClass2() {
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
                GDTAd.this.onError(new c(adError.getErrorCode(), adError.getErrorMsg()));
            }
        });
        nativeUnifiedAD.setMaxVideoDuration(300);
        nativeUnifiedAD.loadData(this.adConfig.getAdsCount());
    }

    private void loadInteractionAd(Context context) {
        UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) context, this.adConfig.getAdsId(), new UnifiedInterstitialADListener() { // from class: com.martian.ads.ad.GDTAd.4
            public AnonymousClass4() {
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
                if (GDTAd.this.adConfig.isBidding()) {
                    GDTAd gDTAd = GDTAd.this;
                    gDTAd.setBiddingEcpm(appTask, gDTAd.iad.getECPM());
                }
                GDTAd.this.getAppTaskList().addAppTask(appTask);
                GDTAd.this.onAdReceived();
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onNoAD(AdError adError) {
                GDTAd.this.onError(new c(adError.getErrorCode(), adError.getErrorMsg()));
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

    private void loadSplashAds(Context context) {
        SplashAD splashAD = new SplashAD(context, this.adConfig.getAdsId(), new SplashADListener() { // from class: com.martian.ads.ad.GDTAd.1
            public AnonymousClass1() {
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
            public void onADLoaded(long j10) {
                AppTask appTask = GDTAd.this.getAppTaskList().getApps().get(0);
                SplashAD splashAD2 = (SplashAD) appTask.origin;
                if (GDTAd.this.adConfig.isBidding()) {
                    GDTAd.this.setBiddingEcpm(appTask, splashAD2.getECPM());
                }
                GDTAd.this.onAdReceived();
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADPresent() {
                GDTAd.this.onExpose();
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADTick(long j10) {
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onNoAD(AdError adError) {
                GDTAd.this.onError(new c(adError.getErrorCode(), adError.getErrorMsg()));
            }
        });
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = splashAD;
        getAppTaskList().addAppTask(appTask);
        splashAD.fetchAdOnly();
    }

    private void loadTemplateFlowAds(Context context) {
        NativeExpressAD nativeExpressAD = new NativeExpressAD(context, new ADSize(-1, -2), this.adConfig.getAdsId(), new NativeExpressAD.NativeExpressADListener() { // from class: com.martian.ads.ad.GDTAd.3
            public AnonymousClass3() {
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
            public void onADExposure(NativeExpressADView nativeExpressADView) {
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
                    appTask.customView = new o(nativeExpressADView);
                    appTask.setPicWidth(1184);
                    appTask.setPicHeight(1898);
                    if (GDTAd.this.adConfig.isBidding()) {
                        GDTAd.this.setBiddingEcpm(appTask, nativeExpressADView.getECPM());
                    }
                    GDTAd.this.getAppTaskList().addAppTask(appTask);
                }
                GDTAd.this.onAdReceived();
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                GDTAd.this.onError(new c(adError.getErrorCode(), adError.getErrorMsg()));
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderFail(NativeExpressADView nativeExpressADView) {
                GDTAd.this.onError(new c(-1, "失败"));
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            }
        });
        nativeExpressAD.setMaxVideoDuration(300);
        nativeExpressAD.loadAD(this.adConfig.getAdsCount());
    }

    private void loadVideoAd(Context context) {
        RewardVideoAD rewardVideoAD = new RewardVideoAD(context, this.adConfig.getAdsId(), new RewardVideoADListener() { // from class: com.martian.ads.ad.GDTAd.5
            private boolean reward = false;

            public AnonymousClass5() {
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
                if (GDTAd.this.adConfig.isBidding()) {
                    GDTAd gDTAd = GDTAd.this;
                    gDTAd.setBiddingEcpm(appTask, gDTAd.rewardVideoAD.getECPM());
                }
                GDTAd.this.getAppTaskList().addAppTask(appTask);
                GDTAd.this.onAdReceived();
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADShow() {
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onError(AdError adError) {
                GDTAd.this.onError(new c(adError.getErrorCode(), adError.getErrorMsg()));
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

    public static void sendInterstitialLossNotification(int i10, @NonNull UnifiedInterstitialAD unifiedInterstitialAD) {
        HashMap hashMap = new HashMap();
        hashMap.put(IBidding.WIN_PRICE, Integer.valueOf(i10));
        hashMap.put(IBidding.LOSS_REASON, 1);
        hashMap.put(IBidding.ADN_ID, "2");
        unifiedInterstitialAD.sendLossNotification(hashMap);
    }

    public static void sendLossNotification(int i10, @NonNull NativeUnifiedADData nativeUnifiedADData, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put(IBidding.WIN_PRICE, Integer.valueOf(i10));
        hashMap.put(IBidding.LOSS_REASON, Integer.valueOf(i11));
        hashMap.put(IBidding.ADN_ID, "2");
        nativeUnifiedADData.sendLossNotification(hashMap);
    }

    public static void sendSplashLossNotification(int i10, @NonNull SplashAD splashAD) {
        HashMap hashMap = new HashMap();
        hashMap.put(IBidding.WIN_PRICE, Integer.valueOf(i10));
        hashMap.put(IBidding.LOSS_REASON, 1);
        hashMap.put(IBidding.ADN_ID, "2");
        splashAD.sendLossNotification(hashMap);
    }

    public static void sendVideoLossNotification(int i10, @NonNull RewardVideoAD rewardVideoAD) {
        HashMap hashMap = new HashMap();
        hashMap.put(IBidding.WIN_PRICE, Integer.valueOf(i10));
        hashMap.put(IBidding.LOSS_REASON, 1);
        hashMap.put(IBidding.ADN_ID, "2");
        rewardVideoAD.sendLossNotification(hashMap);
    }

    public static void sendWinNotification(NativeUnifiedADData nativeUnifiedADData) {
        HashMap hashMap = new HashMap();
        hashMap.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(nativeUnifiedADData.getECPM()));
        nativeUnifiedADData.sendWinNotification(hashMap);
    }

    public void setBiddingEcpm(AppTask appTask, int i10) {
        if (i10 > 0 && this.adConfig.getEcpmPercent() > l5.c.f27899e) {
            appTask.setOriginalEcpm(i10);
            i10 = (int) ((i10 * this.adConfig.getEcpmPercent()) / 100.0d);
        }
        appTask.setEcpm(i10);
        this.adConfig.setEcpm(i10);
    }

    public static void showInterstitialAd(Activity activity, @NonNull UnifiedInterstitialAD unifiedInterstitialAD, boolean z10) {
        if (z10) {
            unifiedInterstitialAD.sendWinNotification(unifiedInterstitialAD.getECPM());
        }
        unifiedInterstitialAD.show(activity);
    }

    public static void showSplashAd(@NonNull SplashAD splashAD, ViewGroup viewGroup, boolean z10) {
        if (splashAD.isValid()) {
            if (z10) {
                splashAD.sendWinNotification(splashAD.getECPM());
            }
            splashAD.showAd(viewGroup);
        }
    }

    public static void showVideoAd(@NonNull RewardVideoAD rewardVideoAD, boolean z10) {
        if (rewardVideoAD.hasShown()) {
            return;
        }
        if (z10) {
            rewardVideoAD.sendWinNotification(rewardVideoAD.getECPM());
        }
        rewardVideoAD.showAD();
    }

    public AppTask toAppTask(NativeUnifiedADData nativeUnifiedADData) {
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = nativeUnifiedADData;
        appTask.title = ConfigSingleton.D().s(nativeUnifiedADData.getTitle());
        appTask.desc = ConfigSingleton.D().s(nativeUnifiedADData.getDesc());
        if (nativeUnifiedADData.isAppAd()) {
            if (nativeUnifiedADData.getAppStatus() == 1) {
                appTask.buttonText = ConfigSingleton.D().s("点击查看");
            } else if (nativeUnifiedADData.getAppStatus() == 1) {
                appTask.buttonText = ConfigSingleton.D().s("点击安装");
            } else {
                appTask.buttonText = ConfigSingleton.D().s("立即下载");
                NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData.getAppMiitInfo();
                if (appMiitInfo != null && !l.q(appMiitInfo.getAppName()) && !l.q(appMiitInfo.getAuthorName()) && !l.q(appMiitInfo.getPrivacyAgreement())) {
                    appTask.setComplianceInfo(getComplianceInfo(appMiitInfo));
                }
            }
        } else if (!l.q(nativeUnifiedADData.getCTAText())) {
            appTask.buttonText = nativeUnifiedADData.getCTAText();
        } else if (!l.q(nativeUnifiedADData.getButtonText())) {
            appTask.buttonText = nativeUnifiedADData.getButtonText();
        }
        if (nativeUnifiedADData.getDownloadCount() > 0) {
            appTask.appPromote = ConfigSingleton.D().s(appTask.getNumbers((int) nativeUnifiedADData.getDownloadCount()) + "人下载");
        } else if (nativeUnifiedADData.getAppScore() > 0) {
            appTask.appPromote = nativeUnifiedADData.getAppScore() + "分";
        }
        if (this.adConfig.isBidding()) {
            setBiddingEcpm(appTask, nativeUnifiedADData.getECPM());
        }
        if (!l.q(nativeUnifiedADData.getIconUrl())) {
            appTask.iconUrl = nativeUnifiedADData.getIconUrl();
        }
        try {
            Object obj = nativeUnifiedADData.getExtraInfo().get("widget_info");
            if (obj instanceof Map) {
                appTask.marketUrl = (String) ((Map) obj).get("url");
            }
        } catch (Exception e10) {
            p0.b(e10.getMessage());
        }
        if (nativeUnifiedADData.getAdPatternType() == 3) {
            for (String str : nativeUnifiedADData.getImgList()) {
                if (!appTask.getPosterUrls().isEmpty() && l.q(appTask.iconUrl)) {
                    appTask.iconUrl = str;
                }
                appTask.addPosterUrl(str);
            }
        } else if (l.q(nativeUnifiedADData.getImgUrl())) {
            appTask.addPosterUrl(nativeUnifiedADData.getIconUrl());
        } else {
            appTask.addPosterUrl(nativeUnifiedADData.getImgUrl());
        }
        if (l.q(appTask.iconUrl)) {
            appTask.iconUrl = appTask.getPosterUrl();
        }
        if (nativeUnifiedADData.getAppMiitInfo() != null) {
            appTask.name = nativeUnifiedADData.getAppMiitInfo().getAppName();
        }
        appTask.setPicWidth(nativeUnifiedADData.getPictureWidth());
        appTask.setPicHeight(nativeUnifiedADData.getPictureHeight());
        return appTask;
    }

    @Override // com.martian.ads.ad.BaseAd
    public void loadAds(Context context) {
        onAdRequest();
        String type = this.adConfig.getType();
        type.hashCode();
        switch (type) {
            case "express":
                loadTemplateFlowAds(context);
                break;
            case "native":
                loadFlowAds(context);
                break;
            case "splash":
                loadSplashAds(context);
                break;
            case "interstitial":
                loadInteractionAd(context);
                break;
            case "reward_video":
                loadVideoAd(context);
                break;
            default:
                onError(null);
                break;
        }
    }
}
