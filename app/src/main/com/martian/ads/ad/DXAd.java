package com.martian.ads.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import ba.l;
import com.aggmoread.sdk.client.AMAdExtras;
import com.aggmoread.sdk.client.AMAdLoadSlot;
import com.aggmoread.sdk.client.AMAdMediaListener;
import com.aggmoread.sdk.client.AMAdMediaView;
import com.aggmoread.sdk.client.AMConst;
import com.aggmoread.sdk.client.AMError;
import com.aggmoread.sdk.client.AMSdk;
import com.aggmoread.sdk.client.AMVideoConfigs;
import com.aggmoread.sdk.client.feedlist.AMNativeAd;
import com.aggmoread.sdk.client.feedlist.AMNativeAdListener;
import com.aggmoread.sdk.client.feedlist.AMNativeInteractionListener;
import com.aggmoread.sdk.client.interstitial.AMInterstitialAd;
import com.aggmoread.sdk.client.interstitial.AMInterstitialAdInteractionListener;
import com.aggmoread.sdk.client.interstitial.AMInterstitialAdListener;
import com.aggmoread.sdk.client.reward.AMRewardAd;
import com.aggmoread.sdk.client.reward.AMRewardAdListener;
import com.aggmoread.sdk.client.reward.AMRewardInteractionListener;
import com.aggmoread.sdk.client.splash.AMSplashAd;
import com.aggmoread.sdk.client.splash.AMSplashAdListener;
import com.aggmoread.sdk.client.splash.AMSplashInteractionListener;
import com.martian.ads.ad.GroMoreAd;
import com.martian.apptask.data.AppTask;
import com.martian.libmars.common.ConfigSingleton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l9.p0;
import x8.c;

/* loaded from: classes3.dex */
public class DXAd extends BaseAd {

    /* renamed from: com.martian.ads.ad.DXAd$1 */
    public class AnonymousClass1 implements AMSplashAdListener {
        public AnonymousClass1() {
        }

        @Override // com.aggmoread.sdk.client.IAMAdLoadListener
        public void onAdLoadFail(AMError aMError) {
            DXAd.this.fallback(aMError == null ? null : new c(aMError.code, aMError.msg));
        }

        @Override // com.aggmoread.sdk.client.IAMAdLoadListener
        public void onAdLoaded(List<AMSplashAd> list) {
            if (list == null || list.isEmpty()) {
                DXAd.this.fallback(null);
                return;
            }
            AppTask appTask = DXAd.this.adConfig.toAppTask();
            AMSplashAd aMSplashAd = list.get(0);
            appTask.origin = list.get(0);
            DXAd.this.getAppTaskList().addAppTask(appTask);
            DXAd.this.setBiddingEcpm(appTask, aMSplashAd.getAdExtras());
            DXAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.DXAd$2 */
    public class AnonymousClass2 implements AMSplashInteractionListener {
        final /* synthetic */ AdConfig val$adConfig;

        public AnonymousClass2(AdConfig adConfig) {
            adConfig = adConfig;
        }

        @Override // com.aggmoread.sdk.client.splash.AMSplashInteractionListener
        public void onAdClicked() {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.l(adConfig);
            }
        }

        @Override // com.aggmoread.sdk.client.splash.AMSplashInteractionListener
        public void onAdClosed() {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.d(adConfig);
            }
        }

        @Override // com.aggmoread.sdk.client.IAMAdInteractionListener
        public void onAdError(AMError aMError) {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.c(adConfig, aMError == null ? null : new c(aMError.code, aMError.msg));
            }
        }

        @Override // com.aggmoread.sdk.client.splash.AMSplashInteractionListener
        public void onAdExposed() {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.b(adConfig);
            }
        }

        @Override // com.aggmoread.sdk.client.splash.AMSplashInteractionListener
        public void onAdTick(long j10) {
        }
    }

    /* renamed from: com.martian.ads.ad.DXAd$3 */
    public class AnonymousClass3 implements AMNativeAdListener {
        public AnonymousClass3() {
        }

        @Override // com.aggmoread.sdk.client.IAMAdLoadListener
        public void onAdLoadFail(AMError aMError) {
        }

        @Override // com.aggmoread.sdk.client.IAMAdLoadListener
        public void onAdLoaded(List<AMNativeAd> list) {
            if (list == null || list.isEmpty()) {
                DXAd.this.fallback(null);
                return;
            }
            Iterator<AMNativeAd> it = list.iterator();
            while (it.hasNext()) {
                DXAd.this.getAppTaskList().addAppTask(DXAd.this.toAppTask(it.next()));
            }
            DXAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.DXAd$4 */
    public class AnonymousClass4 implements AMNativeInteractionListener {
        final /* synthetic */ AdConfig val$adConfig;

        public AnonymousClass4(AdConfig adConfig) {
            adConfig = adConfig;
        }

        @Override // com.aggmoread.sdk.client.feedlist.AMNativeInteractionListener
        public void onADStatusChanged(int i10) {
        }

        @Override // com.aggmoread.sdk.client.feedlist.AMNativeInteractionListener
        public void onAdClicked() {
            d8.a.this.l(adConfig);
        }

        @Override // com.aggmoread.sdk.client.IAMAdInteractionListener
        public void onAdError(AMError aMError) {
            d8.a.this.c(adConfig, aMError == null ? null : new c(aMError.code, aMError.msg));
        }

        @Override // com.aggmoread.sdk.client.feedlist.AMNativeInteractionListener
        public void onAdExposed() {
            d8.a.this.b(adConfig);
        }

        @Override // com.aggmoread.sdk.client.feedlist.AMNativeInteractionListener
        public void onLoadApkProgress(int i10) {
        }
    }

    /* renamed from: com.martian.ads.ad.DXAd$5 */
    public class AnonymousClass5 implements AMAdMediaListener {
        @Override // com.aggmoread.sdk.client.AMAdMediaListener
        public void onVideoClicked() {
        }

        @Override // com.aggmoread.sdk.client.AMAdMediaListener
        public void onVideoCompleted() {
        }

        @Override // com.aggmoread.sdk.client.AMAdMediaListener
        public void onVideoError(AMError aMError) {
        }

        @Override // com.aggmoread.sdk.client.AMAdMediaListener
        public void onVideoInit() {
        }

        @Override // com.aggmoread.sdk.client.AMAdMediaListener
        public void onVideoLoaded(int i10) {
        }

        @Override // com.aggmoread.sdk.client.AMAdMediaListener
        public void onVideoLoading() {
        }

        @Override // com.aggmoread.sdk.client.AMAdMediaListener
        public void onVideoPause() {
        }

        @Override // com.aggmoread.sdk.client.AMAdMediaListener
        public void onVideoReady() {
        }

        @Override // com.aggmoread.sdk.client.AMAdMediaListener
        public void onVideoResume() {
        }

        @Override // com.aggmoread.sdk.client.AMAdMediaListener
        public void onVideoStart() {
        }

        @Override // com.aggmoread.sdk.client.AMAdMediaListener
        public void onVideoStop() {
        }
    }

    /* renamed from: com.martian.ads.ad.DXAd$6 */
    public class AnonymousClass6 implements AMInterstitialAdListener {
        public AnonymousClass6() {
        }

        @Override // com.aggmoread.sdk.client.IAMAdLoadListener
        public void onAdLoadFail(AMError aMError) {
            DXAd.this.fallback(aMError == null ? null : new c(aMError.code, aMError.msg));
        }

        @Override // com.aggmoread.sdk.client.IAMAdLoadListener
        public void onAdLoaded(List<AMInterstitialAd> list) {
            if (list == null || list.isEmpty()) {
                DXAd.this.fallback(null);
                return;
            }
            AppTask appTask = DXAd.this.adConfig.toAppTask();
            AMInterstitialAd aMInterstitialAd = list.get(0);
            appTask.origin = aMInterstitialAd;
            DXAd.this.getAppTaskList().addAppTask(appTask);
            DXAd.this.setBiddingEcpm(appTask, aMInterstitialAd.getAdExtras());
            DXAd.this.onAdReceived();
        }

        @Override // com.aggmoread.sdk.client.interstitial.AMInterstitialAdListener
        public void onAdVideoCached() {
        }
    }

    /* renamed from: com.martian.ads.ad.DXAd$7 */
    public class AnonymousClass7 implements AMInterstitialAdInteractionListener {
        final /* synthetic */ AdConfig val$adConfig1;

        public AnonymousClass7(AdConfig adConfig) {
            adConfig = adConfig;
        }

        @Override // com.aggmoread.sdk.client.interstitial.AMInterstitialAdInteractionListener
        public void onADLeftApplication() {
        }

        @Override // com.aggmoread.sdk.client.interstitial.AMInterstitialAdInteractionListener
        public void onAdClicked() {
            d8.b bVar = d8.b.this;
            if (bVar != null) {
                bVar.l(adConfig);
            }
        }

        @Override // com.aggmoread.sdk.client.interstitial.AMInterstitialAdInteractionListener
        public void onAdClosed() {
            d8.b bVar = d8.b.this;
            if (bVar != null) {
                bVar.d(adConfig);
                d8.b.this.g(adConfig);
                d8.b.this.k(adConfig, true);
            }
        }

        @Override // com.aggmoread.sdk.client.IAMAdInteractionListener
        public void onAdError(AMError aMError) {
            d8.b bVar = d8.b.this;
            if (bVar != null) {
                bVar.c(adConfig, aMError == null ? null : new c(aMError.code, aMError.msg));
            }
        }

        @Override // com.aggmoread.sdk.client.interstitial.AMInterstitialAdInteractionListener
        public void onAdExposed() {
            d8.b bVar = d8.b.this;
            if (bVar != null) {
                bVar.b(adConfig);
            }
        }

        @Override // com.aggmoread.sdk.client.interstitial.AMInterstitialAdInteractionListener
        public void onAdVideoCompleted() {
        }
    }

    /* renamed from: com.martian.ads.ad.DXAd$8 */
    public class AnonymousClass8 implements AMRewardAdListener {
        public AnonymousClass8() {
        }

        @Override // com.aggmoread.sdk.client.IAMAdLoadListener
        public void onAdLoadFail(AMError aMError) {
            DXAd.this.fallback(aMError == null ? null : new c(aMError.code, aMError.msg));
        }

        @Override // com.aggmoread.sdk.client.IAMAdLoadListener
        public void onAdLoaded(List<AMRewardAd> list) {
            if (list == null || list.isEmpty()) {
                DXAd.this.fallback(null);
                return;
            }
            AMRewardAd aMRewardAd = list.get(0);
            AppTask appTask = DXAd.this.adConfig.toAppTask();
            appTask.origin = aMRewardAd;
            DXAd.this.getAppTaskList().addAppTask(appTask);
            DXAd.this.setBiddingEcpm(appTask, aMRewardAd.getAdExtras());
            DXAd.this.onAdReceived();
        }

        @Override // com.aggmoread.sdk.client.reward.AMRewardAdListener
        public void onAdVideoCached() {
        }
    }

    /* renamed from: com.martian.ads.ad.DXAd$9 */
    public class AnonymousClass9 implements AMRewardInteractionListener {
        final /* synthetic */ AdConfig val$adConfig;
        private boolean exposed = false;
        private boolean clicked = false;
        boolean onRewarded = false;

        public AnonymousClass9(AdConfig adConfig) {
            adConfig = adConfig;
        }

        @Override // com.aggmoread.sdk.client.reward.AMRewardInteractionListener
        public void onAdClicked() {
            if (this.clicked) {
                return;
            }
            this.clicked = true;
            d8.b bVar = d8.b.this;
            if (bVar != null) {
                bVar.l(adConfig);
            }
        }

        @Override // com.aggmoread.sdk.client.reward.AMRewardInteractionListener
        public void onAdClosed() {
            if (this.onRewarded) {
                d8.b.this.d(adConfig);
            }
            d8.b.this.k(adConfig, this.onRewarded);
        }

        @Override // com.aggmoread.sdk.client.IAMAdInteractionListener
        public void onAdError(AMError aMError) {
            d8.b bVar = d8.b.this;
            if (bVar != null) {
                bVar.c(adConfig, aMError == null ? null : new c(aMError.code, aMError.msg));
            }
        }

        @Override // com.aggmoread.sdk.client.reward.AMRewardInteractionListener
        public void onAdExposed() {
            if (this.exposed) {
                return;
            }
            this.exposed = true;
            d8.b bVar = d8.b.this;
            if (bVar != null) {
                bVar.b(adConfig);
            }
        }

        @Override // com.aggmoread.sdk.client.reward.AMRewardInteractionListener
        public void onReward(Map map) {
            this.onRewarded = true;
        }

        @Override // com.aggmoread.sdk.client.reward.AMRewardInteractionListener
        public void onVideoComplete() {
        }
    }

    public DXAd(AdConfig adConfig, @NonNull d8.a aVar, Handler handler) {
        super(adConfig, aVar, handler);
    }

    public static void bindFlowAd(Context context, AppTask appTask, ViewGroup viewGroup, View view, GroMoreAd.AdViewHolder adViewHolder, d8.a aVar) {
        if (viewGroup == null || view == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        if (adViewHolder != null) {
            Button button = adViewHolder.mCreativeButton;
            if (button != null) {
                arrayList.add(button);
            }
            View view2 = adViewHolder.mCreativeButtonView;
            if (view2 != null) {
                arrayList.add(view2);
            }
        }
        AMNativeAd aMNativeAd = (AMNativeAd) appTask.origin;
        if (appTask.isBidding()) {
            aMNativeAd.notifyBidSuccess(getBiddingEcpm(aMNativeAd.getAdExtras()));
        }
        View bindAdToView = aMNativeAd.bindAdToView(context, view, new FrameLayout.LayoutParams(0, 0), arrayList, null, new AMNativeInteractionListener() { // from class: com.martian.ads.ad.DXAd.4
            final /* synthetic */ AdConfig val$adConfig;

            public AnonymousClass4(AdConfig adConfig) {
                adConfig = adConfig;
            }

            @Override // com.aggmoread.sdk.client.feedlist.AMNativeInteractionListener
            public void onADStatusChanged(int i10) {
            }

            @Override // com.aggmoread.sdk.client.feedlist.AMNativeInteractionListener
            public void onAdClicked() {
                d8.a.this.l(adConfig);
            }

            @Override // com.aggmoread.sdk.client.IAMAdInteractionListener
            public void onAdError(AMError aMError) {
                d8.a.this.c(adConfig, aMError == null ? null : new c(aMError.code, aMError.msg));
            }

            @Override // com.aggmoread.sdk.client.feedlist.AMNativeInteractionListener
            public void onAdExposed() {
                d8.a.this.b(adConfig);
            }

            @Override // com.aggmoread.sdk.client.feedlist.AMNativeInteractionListener
            public void onLoadApkProgress(int i10) {
            }
        });
        if (aMNativeAd.isVideoAd() && adViewHolder != null && adViewHolder.videoView != null) {
            AMAdMediaView aMAdMediaView = new AMAdMediaView(context);
            adViewHolder.videoView.setVisibility(0);
            adViewHolder.videoView.removeAllViews();
            adViewHolder.videoView.addView(aMAdMediaView);
            aMNativeAd.bindMediaAdToView(aMAdMediaView, new AMAdMediaListener() { // from class: com.martian.ads.ad.DXAd.5
                @Override // com.aggmoread.sdk.client.AMAdMediaListener
                public void onVideoClicked() {
                }

                @Override // com.aggmoread.sdk.client.AMAdMediaListener
                public void onVideoCompleted() {
                }

                @Override // com.aggmoread.sdk.client.AMAdMediaListener
                public void onVideoError(AMError aMError) {
                }

                @Override // com.aggmoread.sdk.client.AMAdMediaListener
                public void onVideoInit() {
                }

                @Override // com.aggmoread.sdk.client.AMAdMediaListener
                public void onVideoLoaded(int i10) {
                }

                @Override // com.aggmoread.sdk.client.AMAdMediaListener
                public void onVideoLoading() {
                }

                @Override // com.aggmoread.sdk.client.AMAdMediaListener
                public void onVideoPause() {
                }

                @Override // com.aggmoread.sdk.client.AMAdMediaListener
                public void onVideoReady() {
                }

                @Override // com.aggmoread.sdk.client.AMAdMediaListener
                public void onVideoResume() {
                }

                @Override // com.aggmoread.sdk.client.AMAdMediaListener
                public void onVideoStart() {
                }

                @Override // com.aggmoread.sdk.client.AMAdMediaListener
                public void onVideoStop() {
                }
            });
        }
        if (bindAdToView != null) {
            ViewGroup viewGroup2 = (ViewGroup) bindAdToView.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeAllViews();
            }
            viewGroup.removeAllViews();
            viewGroup.addView(bindAdToView);
        }
    }

    public void fallback(c cVar) {
        onError(cVar);
    }

    private static int getBiddingEcpm(AMAdExtras aMAdExtras) {
        if (aMAdExtras == null) {
            return 1;
        }
        try {
            String str = (String) aMAdExtras.getData(AMConst.ExtrasKey.AD_PRICE);
            if (!l.q(str)) {
                return Integer.parseInt(str);
            }
        } catch (Exception e10) {
            p0.b(e10.getMessage());
        }
        return 1;
    }

    private AMVideoConfigs getVideoOptions() {
        AMVideoConfigs.Builder builder = new AMVideoConfigs.Builder();
        builder.setAutoPlayMuted(true);
        builder.setAutoPlayPolicy(0);
        builder.setEnableDetailPage(this.adConfig.isAdCompliance());
        builder.setDetailPageMuted(true);
        builder.setEnableUserControl(true);
        builder.setNeedCoverImage(true);
        return builder.build();
    }

    public static boolean isDxFlowAd(AppTask appTask) {
        return appTask != null && (appTask.origin instanceof AMNativeAd);
    }

    public static boolean isDxSplashAd(AppTask appTask) {
        return appTask.origin instanceof AMSplashAd;
    }

    private void loadFlowAds(Context context) {
        AMSdk.makeAdLoader(new AMAdLoadSlot.Builder().setSlotId(this.adConfig.getAdsId()).setVideoConfig(getVideoOptions()).setAdCount(1).build()).loadNativeAd(context, new AMNativeAdListener() { // from class: com.martian.ads.ad.DXAd.3
            public AnonymousClass3() {
            }

            @Override // com.aggmoread.sdk.client.IAMAdLoadListener
            public void onAdLoadFail(AMError aMError) {
            }

            @Override // com.aggmoread.sdk.client.IAMAdLoadListener
            public void onAdLoaded(List<AMNativeAd> list) {
                if (list == null || list.isEmpty()) {
                    DXAd.this.fallback(null);
                    return;
                }
                Iterator<AMNativeAd> it = list.iterator();
                while (it.hasNext()) {
                    DXAd.this.getAppTaskList().addAppTask(DXAd.this.toAppTask(it.next()));
                }
                DXAd.this.onAdReceived();
            }
        });
    }

    private void loadInteractionAd(Context context) {
        AMSdk.makeAdLoader(new AMAdLoadSlot.Builder().setSlotId(this.adConfig.getAdsId()).setVideoConfig(getVideoOptions()).setAdCount(1).build()).loadInterstitialAd(context, new AMInterstitialAdListener() { // from class: com.martian.ads.ad.DXAd.6
            public AnonymousClass6() {
            }

            @Override // com.aggmoread.sdk.client.IAMAdLoadListener
            public void onAdLoadFail(AMError aMError) {
                DXAd.this.fallback(aMError == null ? null : new c(aMError.code, aMError.msg));
            }

            @Override // com.aggmoread.sdk.client.IAMAdLoadListener
            public void onAdLoaded(List<AMInterstitialAd> list) {
                if (list == null || list.isEmpty()) {
                    DXAd.this.fallback(null);
                    return;
                }
                AppTask appTask = DXAd.this.adConfig.toAppTask();
                AMInterstitialAd aMInterstitialAd = list.get(0);
                appTask.origin = aMInterstitialAd;
                DXAd.this.getAppTaskList().addAppTask(appTask);
                DXAd.this.setBiddingEcpm(appTask, aMInterstitialAd.getAdExtras());
                DXAd.this.onAdReceived();
            }

            @Override // com.aggmoread.sdk.client.interstitial.AMInterstitialAdListener
            public void onAdVideoCached() {
            }
        });
    }

    private void loadSplashAds(Context context) {
        AMSdk.makeAdLoader(new AMAdLoadSlot.Builder().setSlotId(this.adConfig.getAdsId()).setAdCount(1).setFetchTimeOut(5000).build()).loadSplashAd(context, new AMSplashAdListener() { // from class: com.martian.ads.ad.DXAd.1
            public AnonymousClass1() {
            }

            @Override // com.aggmoread.sdk.client.IAMAdLoadListener
            public void onAdLoadFail(AMError aMError) {
                DXAd.this.fallback(aMError == null ? null : new c(aMError.code, aMError.msg));
            }

            @Override // com.aggmoread.sdk.client.IAMAdLoadListener
            public void onAdLoaded(List<AMSplashAd> list) {
                if (list == null || list.isEmpty()) {
                    DXAd.this.fallback(null);
                    return;
                }
                AppTask appTask = DXAd.this.adConfig.toAppTask();
                AMSplashAd aMSplashAd = list.get(0);
                appTask.origin = list.get(0);
                DXAd.this.getAppTaskList().addAppTask(appTask);
                DXAd.this.setBiddingEcpm(appTask, aMSplashAd.getAdExtras());
                DXAd.this.onAdReceived();
            }
        });
    }

    private void loadVideoAd(Context context) {
        AMSdk.makeAdLoader(new AMAdLoadSlot.Builder().setSlotId(this.adConfig.getAdsId()).setVideoConfig(getVideoOptions()).setAdCount(1).build()).loadRewardAd(context, new AMRewardAdListener() { // from class: com.martian.ads.ad.DXAd.8
            public AnonymousClass8() {
            }

            @Override // com.aggmoread.sdk.client.IAMAdLoadListener
            public void onAdLoadFail(AMError aMError) {
                DXAd.this.fallback(aMError == null ? null : new c(aMError.code, aMError.msg));
            }

            @Override // com.aggmoread.sdk.client.IAMAdLoadListener
            public void onAdLoaded(List<AMRewardAd> list) {
                if (list == null || list.isEmpty()) {
                    DXAd.this.fallback(null);
                    return;
                }
                AMRewardAd aMRewardAd = list.get(0);
                AppTask appTask = DXAd.this.adConfig.toAppTask();
                appTask.origin = aMRewardAd;
                DXAd.this.getAppTaskList().addAppTask(appTask);
                DXAd.this.setBiddingEcpm(appTask, aMRewardAd.getAdExtras());
                DXAd.this.onAdReceived();
            }

            @Override // com.aggmoread.sdk.client.reward.AMRewardAdListener
            public void onAdVideoCached() {
            }
        });
    }

    public static void sendInterstitialLossNotification(int i10, AMInterstitialAd aMInterstitialAd) {
        aMInterstitialAd.notifyBidFail(1, i10, "");
    }

    public static void sendLossNotification(int i10, String str, AppTask appTask) {
        ((AMNativeAd) appTask.origin).notifyBidFail(1, i10, str);
    }

    public static void sendSplashLossNotification(int i10, AppTask appTask) {
        ((AMSplashAd) appTask.origin).notifyBidFail(1, i10, "");
    }

    public static void sendVideoLossNotification(int i10, @NonNull AMRewardAd aMRewardAd) {
        aMRewardAd.notifyBidFail(1, i10, "");
    }

    public void setBiddingEcpm(AppTask appTask, AMAdExtras aMAdExtras) {
        if (this.adConfig.isBidding()) {
            int biddingEcpm = getBiddingEcpm(aMAdExtras);
            if (biddingEcpm > 0 && this.adConfig.getEcpmPercent() > l5.c.f27899e) {
                appTask.setOriginalEcpm(biddingEcpm);
                biddingEcpm = (int) ((biddingEcpm * this.adConfig.getEcpmPercent()) / 100.0d);
            }
            appTask.setEcpm(biddingEcpm);
            this.adConfig.setEcpm(biddingEcpm);
        }
    }

    public static void showInterstitialAd(Activity activity, AppTask appTask, d8.b bVar) {
        AMInterstitialAd aMInterstitialAd = (AMInterstitialAd) appTask.origin;
        if (appTask.isBidding()) {
            aMInterstitialAd.notifyBidSuccess(getBiddingEcpm(aMInterstitialAd.getAdExtras()));
        }
        aMInterstitialAd.show(activity, new AMInterstitialAdInteractionListener() { // from class: com.martian.ads.ad.DXAd.7
            final /* synthetic */ AdConfig val$adConfig1;

            public AnonymousClass7(AdConfig adConfig) {
                adConfig = adConfig;
            }

            @Override // com.aggmoread.sdk.client.interstitial.AMInterstitialAdInteractionListener
            public void onADLeftApplication() {
            }

            @Override // com.aggmoread.sdk.client.interstitial.AMInterstitialAdInteractionListener
            public void onAdClicked() {
                d8.b bVar2 = d8.b.this;
                if (bVar2 != null) {
                    bVar2.l(adConfig);
                }
            }

            @Override // com.aggmoread.sdk.client.interstitial.AMInterstitialAdInteractionListener
            public void onAdClosed() {
                d8.b bVar2 = d8.b.this;
                if (bVar2 != null) {
                    bVar2.d(adConfig);
                    d8.b.this.g(adConfig);
                    d8.b.this.k(adConfig, true);
                }
            }

            @Override // com.aggmoread.sdk.client.IAMAdInteractionListener
            public void onAdError(AMError aMError) {
                d8.b bVar2 = d8.b.this;
                if (bVar2 != null) {
                    bVar2.c(adConfig, aMError == null ? null : new c(aMError.code, aMError.msg));
                }
            }

            @Override // com.aggmoread.sdk.client.interstitial.AMInterstitialAdInteractionListener
            public void onAdExposed() {
                d8.b bVar2 = d8.b.this;
                if (bVar2 != null) {
                    bVar2.b(adConfig);
                }
            }

            @Override // com.aggmoread.sdk.client.interstitial.AMInterstitialAdInteractionListener
            public void onAdVideoCompleted() {
            }
        });
    }

    public static void showSplashAd(AppTask appTask, ViewGroup viewGroup, d8.a aVar) {
        AMSplashAd aMSplashAd = (AMSplashAd) appTask.origin;
        if (appTask.isBidding()) {
            aMSplashAd.notifyBidSuccess(getBiddingEcpm(aMSplashAd.getAdExtras()));
        }
        aMSplashAd.showViewGroup(viewGroup, new AMSplashInteractionListener() { // from class: com.martian.ads.ad.DXAd.2
            final /* synthetic */ AdConfig val$adConfig;

            public AnonymousClass2(AdConfig adConfig) {
                adConfig = adConfig;
            }

            @Override // com.aggmoread.sdk.client.splash.AMSplashInteractionListener
            public void onAdClicked() {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.l(adConfig);
                }
            }

            @Override // com.aggmoread.sdk.client.splash.AMSplashInteractionListener
            public void onAdClosed() {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.d(adConfig);
                }
            }

            @Override // com.aggmoread.sdk.client.IAMAdInteractionListener
            public void onAdError(AMError aMError) {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.c(adConfig, aMError == null ? null : new c(aMError.code, aMError.msg));
                }
            }

            @Override // com.aggmoread.sdk.client.splash.AMSplashInteractionListener
            public void onAdExposed() {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.b(adConfig);
                }
            }

            @Override // com.aggmoread.sdk.client.splash.AMSplashInteractionListener
            public void onAdTick(long j10) {
            }
        });
    }

    public static void showVideoAd(Activity activity, AppTask appTask, d8.b bVar) {
        AMRewardAd aMRewardAd = (AMRewardAd) appTask.origin;
        AdConfig adConfig = AdConfig.toAdConfig(appTask);
        if (appTask.isBidding()) {
            aMRewardAd.notifyBidSuccess(getBiddingEcpm(aMRewardAd.getAdExtras()));
        }
        aMRewardAd.show(activity, new AMRewardInteractionListener() { // from class: com.martian.ads.ad.DXAd.9
            final /* synthetic */ AdConfig val$adConfig;
            private boolean exposed = false;
            private boolean clicked = false;
            boolean onRewarded = false;

            public AnonymousClass9(AdConfig adConfig2) {
                adConfig = adConfig2;
            }

            @Override // com.aggmoread.sdk.client.reward.AMRewardInteractionListener
            public void onAdClicked() {
                if (this.clicked) {
                    return;
                }
                this.clicked = true;
                d8.b bVar2 = d8.b.this;
                if (bVar2 != null) {
                    bVar2.l(adConfig);
                }
            }

            @Override // com.aggmoread.sdk.client.reward.AMRewardInteractionListener
            public void onAdClosed() {
                if (this.onRewarded) {
                    d8.b.this.d(adConfig);
                }
                d8.b.this.k(adConfig, this.onRewarded);
            }

            @Override // com.aggmoread.sdk.client.IAMAdInteractionListener
            public void onAdError(AMError aMError) {
                d8.b bVar2 = d8.b.this;
                if (bVar2 != null) {
                    bVar2.c(adConfig, aMError == null ? null : new c(aMError.code, aMError.msg));
                }
            }

            @Override // com.aggmoread.sdk.client.reward.AMRewardInteractionListener
            public void onAdExposed() {
                if (this.exposed) {
                    return;
                }
                this.exposed = true;
                d8.b bVar2 = d8.b.this;
                if (bVar2 != null) {
                    bVar2.b(adConfig);
                }
            }

            @Override // com.aggmoread.sdk.client.reward.AMRewardInteractionListener
            public void onReward(Map map) {
                this.onRewarded = true;
            }

            @Override // com.aggmoread.sdk.client.reward.AMRewardInteractionListener
            public void onVideoComplete() {
            }
        });
    }

    public AppTask toAppTask(AMNativeAd aMNativeAd) {
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = aMNativeAd;
        appTask.title = ConfigSingleton.D().s(aMNativeAd.getTitle());
        appTask.desc = ConfigSingleton.D().s(aMNativeAd.getDesc());
        appTask.aliasUnion = this.adConfig.getAliasUnion();
        if (!l.q(aMNativeAd.getIconUrl())) {
            appTask.iconUrl = aMNativeAd.getIconUrl();
        }
        List<String> imageUrlList = aMNativeAd.getImageUrlList();
        if (imageUrlList == null || imageUrlList.isEmpty()) {
            appTask.addPosterUrl(aMNativeAd.getImageUrl());
        } else {
            for (String str : imageUrlList) {
                if (!appTask.getPosterUrls().isEmpty() && l.q(appTask.iconUrl)) {
                    appTask.iconUrl = str;
                }
                appTask.addPosterUrl(str);
            }
        }
        if (l.q(appTask.iconUrl)) {
            appTask.iconUrl = appTask.getPosterUrl();
        }
        setBiddingEcpm(appTask, aMNativeAd.getAdExtras());
        if (aMNativeAd.getDownloadCount() > 0) {
            appTask.appPromote = ConfigSingleton.D().s(appTask.getNumbers((int) aMNativeAd.getDownloadCount()) + "人下载");
        } else if (aMNativeAd.getAppScore() > 0) {
            appTask.appPromote = aMNativeAd.getAppScore() + "分";
        }
        if (aMNativeAd.isAppAd()) {
            int appStatus = aMNativeAd.getAppStatus();
            if (appStatus == 1) {
                appTask.buttonText = ConfigSingleton.D().s("点击查看");
            } else if (appStatus == 4) {
                appTask.buttonText = ConfigSingleton.D().s("下载中");
            } else if (appStatus != 8) {
                appTask.buttonText = ConfigSingleton.D().s("点击下载");
            } else {
                appTask.buttonText = ConfigSingleton.D().s("点击安装");
            }
        }
        appTask.setPicWidth(aMNativeAd.getPictureWidth());
        appTask.setPicHeight(aMNativeAd.getPictureHeight());
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
                fallback(null);
                break;
        }
    }
}
