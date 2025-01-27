package com.martian.ads.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import ba.l;
import ba.m;
import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.adapter.VlionLossReason;
import cn.vlion.ad.inland.base.natives.VlionNativeADEventListener;
import cn.vlion.ad.inland.base.natives.VlionNativeAdData;
import cn.vlion.ad.inland.base.natives.VlionNativeAdvert;
import cn.vlion.ad.inland.core.config.VlionAdError;
import cn.vlion.ad.inland.core.config.VlionSlotConfig;
import cn.vlion.ad.inland.core.interstitial.VlionInterstitialAd;
import cn.vlion.ad.inland.core.interstitial.VlionInterstitialListener;
import cn.vlion.ad.inland.core.natives.VlionNativeADListener;
import cn.vlion.ad.inland.core.natives.VlionNativeAd;
import cn.vlion.ad.inland.core.reward.VlionRewardVideoListener;
import cn.vlion.ad.inland.core.reward.VlionRewardedVideoAd;
import cn.vlion.ad.inland.core.splash.VlionSplashAd;
import cn.vlion.ad.inland.core.splash.VlionSplashListener;
import com.martian.ads.ad.GroMoreAd;
import com.martian.ads.ad.MentaAd;
import com.martian.apptask.data.AppTask;
import com.martian.libmars.common.ConfigSingleton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import l9.p0;
import x8.c;

/* loaded from: classes3.dex */
public class MentaAd extends BaseAd {

    /* renamed from: com.martian.ads.ad.MentaAd$1 */
    public class AnonymousClass1 implements VlionSplashListener {
        final WeakReference<VlionSplashAd> splashAdWeakReference;
        final /* synthetic */ VlionSplashAd val$vlionSplashAd;

        public AnonymousClass1(VlionSplashAd vlionSplashAd) {
            this.val$vlionSplashAd = vlionSplashAd;
            this.splashAdWeakReference = new WeakReference<>(vlionSplashAd);
        }

        @Override // cn.vlion.ad.inland.core.splash.VlionSplashListener
        public void onAdClick() {
            MentaAd.this.onClick();
        }

        @Override // cn.vlion.ad.inland.core.splash.VlionSplashListener
        public void onAdClose() {
            MentaAd.this.onClose();
            VlionSplashAd vlionSplashAd = this.splashAdWeakReference.get();
            if (vlionSplashAd != null) {
                vlionSplashAd.destroy();
            }
        }

        @Override // cn.vlion.ad.inland.core.splash.VlionSplashListener
        public void onAdExposure() {
            MentaAd.this.onExpose();
        }

        @Override // cn.vlion.ad.inland.core.splash.VlionSplashListener
        public void onAdLoadFailure(VlionAdError vlionAdError) {
            MentaAd.this.onError(new c(-1, vlionAdError.code + vlionAdError.desc));
        }

        @Override // cn.vlion.ad.inland.core.splash.VlionSplashListener
        public void onAdLoadSuccess(double d10) {
            if (MentaAd.this.adConfig.isBidding() && !MentaAd.this.getAppTaskList().isEmpty()) {
                MentaAd.this.setBiddingEcpm(MentaAd.this.getAppTaskList().getApps().get(0), d10);
            }
            VlionSplashAd vlionSplashAd = this.splashAdWeakReference.get();
            if (vlionSplashAd != null) {
                vlionSplashAd.notifyWinPrice(l5.c.f27899e, VlionBidderSource.OtherReason);
            }
        }

        @Override // cn.vlion.ad.inland.core.splash.VlionSplashListener
        public void onAdRenderFailure(VlionAdError vlionAdError) {
            MentaAd.this.onError(new c(-1, vlionAdError.code + vlionAdError.desc));
        }

        @Override // cn.vlion.ad.inland.core.splash.VlionSplashListener
        public void onAdRenderSuccess() {
            if (MentaAd.this.getAppTaskList().isEmpty()) {
                return;
            }
            MentaAd.this.onAdReceived();
        }

        @Override // cn.vlion.ad.inland.core.splash.VlionSplashListener
        public void onAdShowFailure(VlionAdError vlionAdError) {
            MentaAd.this.onError(new c(-1, vlionAdError.code + vlionAdError.desc));
        }

        @Override // cn.vlion.ad.inland.core.splash.VlionSplashListener
        public void onAdSkip() {
            MentaAd.this.onClose();
        }
    }

    /* renamed from: com.martian.ads.ad.MentaAd$2 */
    public class AnonymousClass2 implements VlionNativeADListener {
        public AnonymousClass2() {
        }

        @Override // cn.vlion.ad.inland.core.natives.VlionNativeADListener
        public void onAdLoadFailure(VlionAdError vlionAdError) {
            MentaAd.this.onError(new c(-1, vlionAdError.code + vlionAdError.desc));
        }

        @Override // cn.vlion.ad.inland.core.natives.VlionNativeADListener
        public void onAdLoadSuccess(VlionNativeAdvert vlionNativeAdvert) {
            if (vlionNativeAdvert == null || vlionNativeAdvert.getVlionNativeAdData() == null) {
                MentaAd.this.onError(null);
            } else {
                MentaAd.this.getAppTaskList().addAppTask(MentaAd.this.toAppTask(vlionNativeAdvert));
                MentaAd.this.onAdReceived();
            }
        }
    }

    /* renamed from: com.martian.ads.ad.MentaAd$3 */
    public class AnonymousClass3 implements VlionNativeADEventListener {
        final /* synthetic */ AdConfig val$adConfig;

        public AnonymousClass3(AdConfig adConfig) {
            adConfig = adConfig;
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativeADEventListener
        public void onClick() {
            d8.a.this.l(adConfig);
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativeADEventListener
        public void onClose() {
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativeADEventListener
        public void onExposure() {
            d8.a.this.b(adConfig);
        }
    }

    /* renamed from: com.martian.ads.ad.MentaAd$4 */
    public class AnonymousClass4 implements VlionInterstitialListener {
        final /* synthetic */ Context val$context;
        final /* synthetic */ VlionInterstitialAd val$vlionInterstitialAd;

        public AnonymousClass4(VlionInterstitialAd vlionInterstitialAd, Context context) {
            this.val$vlionInterstitialAd = vlionInterstitialAd;
            this.val$context = context;
        }

        public /* synthetic */ void lambda$onAdRenderSuccess$0() {
            MentaAd.this.optimizeAdReceived();
        }

        @Override // cn.vlion.ad.inland.core.interstitial.VlionInterstitialListener
        public void onAdClick() {
            MentaAd.this.onClick();
        }

        @Override // cn.vlion.ad.inland.core.interstitial.VlionInterstitialListener
        public void onAdClose() {
            MentaAd.this.onClose();
            MentaAd.this.onDismiss();
            MentaAd.this.onRewardVerify(true);
            Context context = this.val$context;
            if (context != null) {
                VlionInterstitialAd vlionInterstitialAd = this.val$vlionInterstitialAd;
                Objects.requireNonNull(vlionInterstitialAd);
                ((Activity) context).runOnUiThread(new Runnable() { // from class: c8.o
                    public /* synthetic */ o() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        VlionInterstitialAd.this.destroy();
                    }
                });
            }
        }

        @Override // cn.vlion.ad.inland.core.interstitial.VlionInterstitialListener
        public void onAdExposure() {
            MentaAd.this.onExpose();
        }

        @Override // cn.vlion.ad.inland.core.interstitial.VlionInterstitialListener
        public void onAdLoadFailure(VlionAdError vlionAdError) {
            MentaAd.this.onError(new c(-1, vlionAdError.code + vlionAdError.desc));
        }

        @Override // cn.vlion.ad.inland.core.interstitial.VlionInterstitialListener
        public void onAdLoadSuccess(double d10) {
            AppTask appTask = MentaAd.this.adConfig.toAppTask();
            appTask.origin = this.val$vlionInterstitialAd;
            if (MentaAd.this.adConfig.isBidding()) {
                MentaAd.this.setBiddingEcpm(appTask, d10);
            }
            MentaAd.this.getAppTaskList().addAppTask(appTask);
            this.val$vlionInterstitialAd.notifyWinPrice(l5.c.f27899e, VlionBidderSource.OtherReason);
        }

        @Override // cn.vlion.ad.inland.core.interstitial.VlionInterstitialListener
        public void onAdRenderFailure(VlionAdError vlionAdError) {
            MentaAd.this.onError(new c(-1, vlionAdError.code + vlionAdError.desc));
        }

        @Override // cn.vlion.ad.inland.core.interstitial.VlionInterstitialListener
        public void onAdRenderSuccess() {
            Handler handler;
            if (!MentaAd.this.getAppTaskList().isEmpty() || (handler = MentaAd.this.handler) == null) {
                MentaAd.this.optimizeAdReceived();
            } else {
                handler.postDelayed(new Runnable() { // from class: com.martian.ads.ad.a
                    public /* synthetic */ a() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        MentaAd.AnonymousClass4.this.lambda$onAdRenderSuccess$0();
                    }
                }, 200L);
            }
        }

        @Override // cn.vlion.ad.inland.core.interstitial.VlionInterstitialListener
        public void onAdShowFailure(VlionAdError vlionAdError) {
        }
    }

    /* renamed from: com.martian.ads.ad.MentaAd$5 */
    public class AnonymousClass5 implements VlionRewardVideoListener {
        final /* synthetic */ VlionRewardedVideoAd val$vlionRewardedVideoAd;
        private boolean verify = false;

        public AnonymousClass5(VlionRewardedVideoAd vlionRewardedVideoAd) {
            this.val$vlionRewardedVideoAd = vlionRewardedVideoAd;
        }

        public /* synthetic */ void lambda$onAdRenderSuccess$0() {
            MentaAd.this.optimizeAdReceived();
        }

        @Override // cn.vlion.ad.inland.core.reward.VlionRewardVideoListener
        public void onAdClick() {
            MentaAd.this.onClick();
        }

        @Override // cn.vlion.ad.inland.core.reward.VlionRewardVideoListener
        public void onAdClose() {
            MentaAd.this.onClose();
            MentaAd.this.onRewardVerify(this.verify);
            this.val$vlionRewardedVideoAd.destroy();
        }

        @Override // cn.vlion.ad.inland.core.reward.VlionRewardVideoListener
        public void onAdExposure() {
            MentaAd.this.onExpose();
        }

        @Override // cn.vlion.ad.inland.core.reward.VlionRewardVideoListener
        public void onAdLoadFailure(VlionAdError vlionAdError) {
            MentaAd.this.onError(new c(-1, vlionAdError.code + vlionAdError.desc));
        }

        @Override // cn.vlion.ad.inland.core.reward.VlionRewardVideoListener
        public void onAdLoadSuccess(double d10) {
            AppTask appTask = MentaAd.this.adConfig.toAppTask();
            appTask.origin = this.val$vlionRewardedVideoAd;
            if (MentaAd.this.adConfig.isBidding()) {
                MentaAd.this.setBiddingEcpm(appTask, d10);
            }
            MentaAd.this.getAppTaskList().addAppTask(appTask);
            this.val$vlionRewardedVideoAd.notifyWinPrice(l5.c.f27899e, VlionBidderSource.OtherReason);
        }

        @Override // cn.vlion.ad.inland.core.reward.VlionRewardVideoListener
        public void onAdPlayFailure(VlionAdError vlionAdError) {
        }

        @Override // cn.vlion.ad.inland.core.reward.VlionRewardVideoListener
        public void onAdRenderFailure(VlionAdError vlionAdError) {
            MentaAd.this.onError(new c(-1, vlionAdError.code + vlionAdError.desc));
        }

        @Override // cn.vlion.ad.inland.core.reward.VlionRewardVideoListener
        public void onAdRenderSuccess() {
            Handler handler;
            if (!MentaAd.this.getAppTaskList().isEmpty() || (handler = MentaAd.this.handler) == null) {
                MentaAd.this.optimizeAdReceived();
            } else {
                handler.postDelayed(new Runnable() { // from class: com.martian.ads.ad.b
                    public /* synthetic */ b() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        MentaAd.AnonymousClass5.this.lambda$onAdRenderSuccess$0();
                    }
                }, 200L);
            }
        }

        @Override // cn.vlion.ad.inland.core.reward.VlionRewardVideoListener
        public void onAdReward() {
            this.verify = true;
        }

        @Override // cn.vlion.ad.inland.core.reward.VlionRewardVideoListener
        public void onAdShowFailure(VlionAdError vlionAdError) {
        }

        @Override // cn.vlion.ad.inland.core.reward.VlionRewardVideoListener
        public void onAdVideoSkip() {
        }

        @Override // cn.vlion.ad.inland.core.reward.VlionRewardVideoListener
        public void onVideoCompleted() {
        }

        @Override // cn.vlion.ad.inland.core.reward.VlionRewardVideoListener
        public void onVideoStart() {
        }
    }

    public MentaAd(AdConfig adConfig, @NonNull d8.a aVar, Handler handler) {
        super(adConfig, aVar, handler);
    }

    public static void bindFlowAd(Activity activity, AppTask appTask, ViewGroup viewGroup, View view, GroMoreAd.AdViewHolder adViewHolder, d8.a aVar) {
        VlionNativeAdvert vlionNativeAdvert = (VlionNativeAdvert) appTask.origin;
        if (adViewHolder == null || adViewHolder.videoView == null) {
            return;
        }
        vlionNativeAdvert.notifyWinPrice(appTask.getLoseEcpm(), getAdnName(appTask.source));
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        Button button = adViewHolder.mCreativeButton;
        if (button != null) {
            arrayList.add(button);
        }
        View view2 = adViewHolder.mCreativeButtonView;
        if (view2 != null) {
            arrayList.add(view2);
        }
        View nativeMediaAdView = vlionNativeAdvert.getNativeMediaAdView();
        if (nativeMediaAdView != null) {
            adViewHolder.videoView.setVisibility(0);
            adViewHolder.videoView.removeAllViews();
            adViewHolder.videoView.addView(nativeMediaAdView);
        }
        vlionNativeAdvert.registerNativeView(activity, viewGroup, arrayList, null, new ArrayList(), new VlionNativeADEventListener() { // from class: com.martian.ads.ad.MentaAd.3
            final /* synthetic */ AdConfig val$adConfig;

            public AnonymousClass3(AdConfig adConfig) {
                adConfig = adConfig;
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativeADEventListener
            public void onClick() {
                d8.a.this.l(adConfig);
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativeADEventListener
            public void onClose() {
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativeADEventListener
            public void onExposure() {
                d8.a.this.b(adConfig);
            }
        });
    }

    private static VlionBidderSource getAdnName(String str) {
        if (TextUtils.isEmpty(str)) {
            return VlionBidderSource.OtherReason;
        }
        str.hashCode();
        switch (str) {
        }
        return VlionBidderSource.OtherReason;
    }

    public static boolean isMentaFlowAd(AppTask appTask) {
        return appTask != null && (appTask.origin instanceof VlionNativeAdvert);
    }

    public static boolean isMentaSplashAd(AppTask appTask) {
        return appTask.origin instanceof VlionSplashAd;
    }

    private void loadInteractionAd(Context context) {
        VlionInterstitialAd vlionInterstitialAd = new VlionInterstitialAd((Activity) context, new VlionSlotConfig.Builder().setSlotID(this.adConfig.getAdsId()).setSize(300.0f, 400.0f).setTolerateTime(5.0f).setImageScale(2).build());
        vlionInterstitialAd.setVlionInterstitialListener(new AnonymousClass4(vlionInterstitialAd, context));
        vlionInterstitialAd.loadAd();
    }

    private void loadSplashAds(Context context) {
        VlionSplashAd vlionSplashAd = new VlionSplashAd(context, new VlionSlotConfig.Builder().setSlotID(this.adConfig.getAdsId()).setSize(m.i(context), m.h(context)).setTolerateTime(5.0f).setImageScale(2).build());
        vlionSplashAd.setVlionSplashListener(new VlionSplashListener(vlionSplashAd) { // from class: com.martian.ads.ad.MentaAd.1
            final WeakReference<VlionSplashAd> splashAdWeakReference;
            final /* synthetic */ VlionSplashAd val$vlionSplashAd;

            public AnonymousClass1(VlionSplashAd vlionSplashAd2) {
                this.val$vlionSplashAd = vlionSplashAd2;
                this.splashAdWeakReference = new WeakReference<>(vlionSplashAd2);
            }

            @Override // cn.vlion.ad.inland.core.splash.VlionSplashListener
            public void onAdClick() {
                MentaAd.this.onClick();
            }

            @Override // cn.vlion.ad.inland.core.splash.VlionSplashListener
            public void onAdClose() {
                MentaAd.this.onClose();
                VlionSplashAd vlionSplashAd2 = this.splashAdWeakReference.get();
                if (vlionSplashAd2 != null) {
                    vlionSplashAd2.destroy();
                }
            }

            @Override // cn.vlion.ad.inland.core.splash.VlionSplashListener
            public void onAdExposure() {
                MentaAd.this.onExpose();
            }

            @Override // cn.vlion.ad.inland.core.splash.VlionSplashListener
            public void onAdLoadFailure(VlionAdError vlionAdError) {
                MentaAd.this.onError(new c(-1, vlionAdError.code + vlionAdError.desc));
            }

            @Override // cn.vlion.ad.inland.core.splash.VlionSplashListener
            public void onAdLoadSuccess(double d10) {
                if (MentaAd.this.adConfig.isBidding() && !MentaAd.this.getAppTaskList().isEmpty()) {
                    MentaAd.this.setBiddingEcpm(MentaAd.this.getAppTaskList().getApps().get(0), d10);
                }
                VlionSplashAd vlionSplashAd2 = this.splashAdWeakReference.get();
                if (vlionSplashAd2 != null) {
                    vlionSplashAd2.notifyWinPrice(l5.c.f27899e, VlionBidderSource.OtherReason);
                }
            }

            @Override // cn.vlion.ad.inland.core.splash.VlionSplashListener
            public void onAdRenderFailure(VlionAdError vlionAdError) {
                MentaAd.this.onError(new c(-1, vlionAdError.code + vlionAdError.desc));
            }

            @Override // cn.vlion.ad.inland.core.splash.VlionSplashListener
            public void onAdRenderSuccess() {
                if (MentaAd.this.getAppTaskList().isEmpty()) {
                    return;
                }
                MentaAd.this.onAdReceived();
            }

            @Override // cn.vlion.ad.inland.core.splash.VlionSplashListener
            public void onAdShowFailure(VlionAdError vlionAdError) {
                MentaAd.this.onError(new c(-1, vlionAdError.code + vlionAdError.desc));
            }

            @Override // cn.vlion.ad.inland.core.splash.VlionSplashListener
            public void onAdSkip() {
                MentaAd.this.onClose();
            }
        });
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = vlionSplashAd2;
        getAppTaskList().addAppTask(appTask);
        vlionSplashAd2.loadAd();
    }

    private void loadVideoAd(Context context) {
        VlionRewardedVideoAd vlionRewardedVideoAd = new VlionRewardedVideoAd(context, new VlionSlotConfig.Builder().setSlotID(this.adConfig.getAdsId()).setSize(1080.0f, 1920.0f).setTolerateTime(5.0f).setImageScale(2).build());
        vlionRewardedVideoAd.setVlionRewardVideoListener(new AnonymousClass5(vlionRewardedVideoAd));
        vlionRewardedVideoAd.loadAd();
    }

    public void optimizeAdReceived() {
        if (getAppTaskList().isEmpty()) {
            onError(new c(-1, "ad null"));
        } else {
            onAdReceived();
        }
    }

    public static void sendDrawLossNotification(int i10, String str, @NonNull VlionNativeAdvert vlionNativeAdvert) {
        vlionNativeAdvert.notifyWinPriceFailure(i10, getAdnName(str), VlionLossReason.BidFailure);
    }

    public static void sendInterstitialLossNotification(int i10, String str, @NonNull VlionInterstitialAd vlionInterstitialAd) {
        vlionInterstitialAd.notifyWinPriceFailure(i10, getAdnName(str), VlionLossReason.BidFailure);
    }

    public static void sendSplashLossNotification(int i10, String str, @NonNull AppTask appTask) {
        ((VlionSplashAd) appTask.origin).notifyWinPriceFailure(i10, getAdnName(str), VlionLossReason.BidFailure);
    }

    public static void sendVideoLossNotification(int i10, String str, VlionRewardedVideoAd vlionRewardedVideoAd) {
        vlionRewardedVideoAd.notifyWinPriceFailure(i10, getAdnName(str), VlionLossReason.BidFailure);
    }

    public void setBiddingEcpm(AppTask appTask, double d10) {
        int i10 = (int) d10;
        if (i10 > 0) {
            try {
                if (this.adConfig.getEcpmPercent() > l5.c.f27899e) {
                    appTask.setOriginalEcpm(i10);
                    i10 = (int) ((i10 * this.adConfig.getEcpmPercent()) / 100.0d);
                }
            } catch (Exception e10) {
                p0.b(e10.getMessage());
                appTask.setEcpm(0);
                this.adConfig.setEcpm(0);
                return;
            }
        }
        appTask.setEcpm(i10);
        this.adConfig.setEcpm(i10);
    }

    public static void showInterstitialAd(Activity activity, @NonNull AppTask appTask) {
        VlionInterstitialAd vlionInterstitialAd = (VlionInterstitialAd) appTask.origin;
        vlionInterstitialAd.notifyWinPrice(appTask.getLoseEcpm(), getAdnName(appTask.source));
        vlionInterstitialAd.showAd(activity);
    }

    public static void showSplashAd(AppTask appTask, ViewGroup viewGroup) {
        ((VlionSplashAd) appTask.origin).showAd(viewGroup);
    }

    public static void showVideoAd(Activity activity, @NonNull AppTask appTask) {
        VlionRewardedVideoAd vlionRewardedVideoAd = (VlionRewardedVideoAd) appTask.origin;
        vlionRewardedVideoAd.notifyWinPrice(appTask.getLoseEcpm(), getAdnName(appTask.source));
        vlionRewardedVideoAd.showAd(activity);
    }

    public AppTask toAppTask(VlionNativeAdvert vlionNativeAdvert) {
        List<String> imgList;
        VlionNativeAdData vlionNativeAdData = vlionNativeAdvert.getVlionNativeAdData();
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = vlionNativeAdvert;
        appTask.title = ConfigSingleton.D().s(vlionNativeAdData.getTitle());
        appTask.desc = ConfigSingleton.D().s(vlionNativeAdData.getDescription());
        if (!l.q(vlionNativeAdData.getBrandUrl())) {
            appTask.iconUrl = vlionNativeAdData.getBrandUrl();
        }
        appTask.appPromote = ConfigSingleton.D().s("赞助正版章节");
        if (this.adConfig.isBidding()) {
            setBiddingEcpm(appTask, vlionNativeAdData.getPrice());
        }
        if (l.q(appTask.iconUrl) && (imgList = vlionNativeAdData.getImgList()) != null && !imgList.isEmpty()) {
            Iterator<String> it = imgList.iterator();
            if (it.hasNext()) {
                appTask.iconUrl = it.next();
            }
        }
        if (vlionNativeAdData.getVlionNativeType() == 4) {
            appTask.setPicWidth(vlionNativeAdData.getVideoWidth());
            appTask.setPicHeight(vlionNativeAdData.getVideoHeight());
        } else {
            appTask.setPicWidth(vlionNativeAdData.getImageWidth());
            appTask.setPicHeight(vlionNativeAdData.getImageHeight());
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

    public void loadFlowAds(Context context) {
        VlionNativeAd.fetchFeedsAd(context, new VlionSlotConfig.Builder().setSlotID(this.adConfig.getAdsId()).setTolerateTime(5.0f).setSize(640.0f, 360.0f).setImageScale(2).build(), new VlionNativeADListener() { // from class: com.martian.ads.ad.MentaAd.2
            public AnonymousClass2() {
            }

            @Override // cn.vlion.ad.inland.core.natives.VlionNativeADListener
            public void onAdLoadFailure(VlionAdError vlionAdError) {
                MentaAd.this.onError(new c(-1, vlionAdError.code + vlionAdError.desc));
            }

            @Override // cn.vlion.ad.inland.core.natives.VlionNativeADListener
            public void onAdLoadSuccess(VlionNativeAdvert vlionNativeAdvert) {
                if (vlionNativeAdvert == null || vlionNativeAdvert.getVlionNativeAdData() == null) {
                    MentaAd.this.onError(null);
                } else {
                    MentaAd.this.getAppTaskList().addAppTask(MentaAd.this.toAppTask(vlionNativeAdvert));
                    MentaAd.this.onAdReceived();
                }
            }
        });
    }
}
