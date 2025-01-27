package com.martian.ads.ad;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import ba.l;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.AdnName;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.GroMoreAd;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.ComplianceInfo;
import com.martian.libmars.common.ConfigSingleton;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import x8.c;

/* loaded from: classes3.dex */
public class KsAd extends BaseAd {
    public KsRewardVideoAd mRewardVideoAd;

    /* renamed from: com.martian.ads.ad.KsAd$1 */
    public class AnonymousClass1 implements KsLoadManager.SplashScreenAdListener {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onError(int i10, String str) {
            KsAd.this.onError(new c(i10, str));
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onRequestResult(int i10) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
            AppTask appTask = KsAd.this.adConfig.toAppTask();
            appTask.origin = ksSplashScreenAd;
            if (KsAd.this.adConfig.isBidding()) {
                KsAd.this.setBiddingEcpm(appTask, ksSplashScreenAd.getECPM());
            }
            KsAd.this.getAppTaskList().addAppTask(appTask);
            KsAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.KsAd$2 */
    public class AnonymousClass2 implements KsSplashScreenAd.SplashScreenAdInteractionListener {
        final /* synthetic */ AdConfig val$adConfig;

        public AnonymousClass2(AdConfig adConfig) {
            adConfig = adConfig;
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdClicked() {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.l(adConfig);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowEnd() {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.g(adConfig);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowError(int i10, String str) {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.c(adConfig, null);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowStart() {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.b(adConfig);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogCancel() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogShow() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onSkippedAd() {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.d(adConfig);
            }
        }
    }

    /* renamed from: com.martian.ads.ad.KsAd$3 */
    public class AnonymousClass3 implements KsLoadManager.NativeAdListener {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onError(int i10, String str) {
            KsAd.this.onError(new c(i10, str));
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
            if (list == null || list.isEmpty()) {
                KsAd.this.onError(null);
                return;
            }
            Iterator<KsNativeAd> it = list.iterator();
            while (it.hasNext()) {
                KsAd.this.getAppTaskList().addAppTask(KsAd.this.toAppTask(it.next()));
            }
            KsAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.KsAd$4 */
    public class AnonymousClass4 implements KsLoadManager.RewardVideoAdListener {

        /* renamed from: com.martian.ads.ad.KsAd$4$1 */
        public class AnonymousClass1 implements KsRewardVideoAd.RewardAdInteractionListener {
            private boolean verify = false;

            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onAdClicked() {
                KsAd.this.onClick();
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onExtraRewardVerify(int i10) {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onPageDismiss() {
                KsAd.this.onClose();
                KsAd.this.onRewardVerify(this.verify);
                KsAd.this.mRewardVideoAd = null;
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onRewardStepVerify(int i10, int i11) {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify() {
                this.verify = true;
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayEnd() {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayError(int i10, int i11) {
                KsAd.this.onError(new c(i10, "" + i11));
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayStart() {
                KsAd.this.onExpose();
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoSkipToEnd(long j10) {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify(Map<String, Object> map) {
                this.verify = true;
            }
        }

        public AnonymousClass4() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onError(int i10, String str) {
            KsAd.this.onError(new c(i10, str));
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
            if (list == null || list.isEmpty()) {
                KsAd.this.onError(new c(-1, "广告为空"));
                return;
            }
            KsAd.this.mRewardVideoAd = list.get(0);
            KsRewardVideoAd ksRewardVideoAd = KsAd.this.mRewardVideoAd;
            if (ksRewardVideoAd == null || !ksRewardVideoAd.isAdEnable()) {
                KsAd.this.onError(new c(-1, "广告无效"));
                return;
            }
            KsAd.this.mRewardVideoAd.setRewardAdInteractionListener(new KsRewardVideoAd.RewardAdInteractionListener() { // from class: com.martian.ads.ad.KsAd.4.1
                private boolean verify = false;

                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onAdClicked() {
                    KsAd.this.onClick();
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onExtraRewardVerify(int i10) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onPageDismiss() {
                    KsAd.this.onClose();
                    KsAd.this.onRewardVerify(this.verify);
                    KsAd.this.mRewardVideoAd = null;
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onRewardStepVerify(int i10, int i11) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onRewardVerify() {
                    this.verify = true;
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayEnd() {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayError(int i10, int i11) {
                    KsAd.this.onError(new c(i10, "" + i11));
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayStart() {
                    KsAd.this.onExpose();
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoSkipToEnd(long j10) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onRewardVerify(Map<String, Object> map) {
                    this.verify = true;
                }
            });
            AppTask appTask = KsAd.this.adConfig.toAppTask();
            KsAd ksAd = KsAd.this;
            appTask.origin = ksAd.mRewardVideoAd;
            if (ksAd.adConfig.isBidding()) {
                KsAd ksAd2 = KsAd.this;
                ksAd2.setBiddingEcpm(appTask, ksAd2.mRewardVideoAd.getECPM());
            }
            KsAd.this.getAppTaskList().addAppTask(appTask);
            KsAd.this.onAdReceived();
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoResult(@Nullable List<KsRewardVideoAd> list) {
        }
    }

    /* renamed from: com.martian.ads.ad.KsAd$5 */
    public class AnonymousClass5 implements KsLoadManager.InterstitialAdListener {

        /* renamed from: com.martian.ads.ad.KsAd$5$1 */
        public class AnonymousClass1 implements KsInterstitialAd.AdInteractionListener {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onAdClicked() {
                KsAd.this.onClick();
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onAdClosed() {
                KsAd.this.onClose();
                KsAd.this.onRewardVerify(true);
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onAdShow() {
                KsAd.this.onExpose();
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onPageDismiss() {
                KsAd.this.onDismiss();
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onSkippedAd() {
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onVideoPlayEnd() {
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onVideoPlayError(int i10, int i11) {
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onVideoPlayStart() {
            }
        }

        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onError(int i10, String str) {
            KsAd.this.onError(new c(i10, str));
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list) {
            if (list == null || list.isEmpty() || list.get(0) == null) {
                KsAd.this.onError(new c(-1, "广告为空"));
                return;
            }
            KsInterstitialAd ksInterstitialAd = list.get(0);
            ksInterstitialAd.setAdInteractionListener(new KsInterstitialAd.AdInteractionListener() { // from class: com.martian.ads.ad.KsAd.5.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onAdClicked() {
                    KsAd.this.onClick();
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onAdClosed() {
                    KsAd.this.onClose();
                    KsAd.this.onRewardVerify(true);
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onAdShow() {
                    KsAd.this.onExpose();
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onPageDismiss() {
                    KsAd.this.onDismiss();
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onSkippedAd() {
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onVideoPlayEnd() {
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onVideoPlayError(int i10, int i11) {
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onVideoPlayStart() {
                }
            });
            AppTask appTask = KsAd.this.adConfig.toAppTask();
            appTask.origin = ksInterstitialAd;
            if (KsAd.this.adConfig.isBidding()) {
                KsAd.this.setBiddingEcpm(appTask, ksInterstitialAd.getECPM());
            }
            KsAd.this.getAppTaskList().addAppTask(appTask);
            KsAd.this.onAdReceived();
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onRequestResult(int i10) {
        }
    }

    /* renamed from: com.martian.ads.ad.KsAd$6 */
    public class AnonymousClass6 implements KsNativeAd.AdInteractionListener {
        final /* synthetic */ AdConfig val$adConfig;

        public AnonymousClass6(AdConfig adConfig) {
            adConfig = adConfig;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            return false;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdClicked(View view, KsNativeAd ksNativeAd) {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.l(adConfig);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdShow(KsNativeAd ksNativeAd) {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.b(adConfig);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onDownloadTipsDialogShow() {
        }
    }

    /* renamed from: com.martian.ads.ad.KsAd$7 */
    public class AnonymousClass7 implements KsAppDownloadListener {
        final WeakReference<d8.a> adReceiverWeakReference;
        boolean isDownload = false;
        final /* synthetic */ AppTask val$appTask;

        public AnonymousClass7(AppTask appTask) {
            this.val$appTask = appTask;
            this.adReceiverWeakReference = new WeakReference<>(d8.a.this);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadStarted() {
            d8.a aVar = this.adReceiverWeakReference.get();
            if (aVar == null || this.isDownload) {
                return;
            }
            this.isDownload = true;
            aVar.e(this.val$appTask);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            d8.a aVar = this.adReceiverWeakReference.get();
            if (aVar != null) {
                aVar.f(this.val$appTask);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i10) {
        }
    }

    /* renamed from: com.martian.ads.ad.KsAd$8 */
    public class AnonymousClass8 implements KsLoadManager.DrawAdListener {
        final /* synthetic */ Context val$context;

        public AnonymousClass8(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
            if (list == null || list.isEmpty()) {
                KsAd.this.onError(null);
                return;
            }
            for (KsDrawAd ksDrawAd : list) {
                if (ksDrawAd != null && ksDrawAd.getDrawView(context) != null) {
                    ksDrawAd.setVideoSoundEnable(false);
                    KsAd.this.getAppTaskList().addAppTask(KsAd.this.toAppTask(ksDrawAd));
                }
            }
            if (KsAd.this.getAppTaskList().isEmpty()) {
                KsAd.this.onError(null);
            } else {
                KsAd.this.onAdReceived();
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public void onError(int i10, String str) {
            KsAd.this.onError(new c(i10, str));
        }
    }

    /* renamed from: com.martian.ads.ad.KsAd$9 */
    public class AnonymousClass9 implements KsDrawAd.AdInteractionListener {
        final /* synthetic */ AdConfig val$adConfig;

        public AnonymousClass9(AdConfig adConfig) {
            adConfig = adConfig;
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onAdClicked() {
            d8.a.this.l(adConfig);
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onAdShow() {
            d8.a.this.b(adConfig);
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayEnd() {
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayError() {
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayPause() {
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayResume() {
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayStart() {
        }
    }

    public KsAd(AdConfig adConfig, @NonNull d8.a aVar, Handler handler) {
        super(adConfig, aVar, handler);
    }

    public static void bindDrawAd(Activity activity, AppTask appTask, GroMoreAd.AdViewHolder adViewHolder, d8.a aVar) {
        KsDrawAd ksDrawAd;
        View drawView;
        if (adViewHolder == null || adViewHolder.videoView == null || (drawView = (ksDrawAd = (KsDrawAd) appTask.origin).getDrawView(activity)) == null) {
            return;
        }
        if (appTask.isBidding()) {
            sendDrawWinNotification(appTask);
        }
        View view = adViewHolder.textView;
        if (view != null) {
            view.setVisibility(8);
        }
        ImageView imageView = adViewHolder.mPoster;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        View view2 = adViewHolder.logoView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        ksDrawAd.setAdInteractionListener(new KsDrawAd.AdInteractionListener() { // from class: com.martian.ads.ad.KsAd.9
            final /* synthetic */ AdConfig val$adConfig;

            public AnonymousClass9(AdConfig adConfig) {
                adConfig = adConfig;
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onAdClicked() {
                d8.a.this.l(adConfig);
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onAdShow() {
                d8.a.this.b(adConfig);
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayEnd() {
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayError() {
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayPause() {
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayResume() {
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayStart() {
            }
        });
        adViewHolder.videoView.setVisibility(0);
        adViewHolder.videoView.removeAllViews();
        adViewHolder.videoView.addView(drawView);
    }

    public static void bindFlowAd(Activity activity, AppTask appTask, ViewGroup viewGroup, View view, GroMoreAd.AdViewHolder adViewHolder, boolean z10, d8.a aVar) {
        if (viewGroup == null) {
            return;
        }
        KsNativeAd ksNativeAd = (KsNativeAd) appTask.origin;
        if (appTask.isBidding()) {
            sendWinNotification(appTask);
        }
        HashMap hashMap = new HashMap();
        if (adViewHolder != null) {
            boolean z11 = (z10 || appTask.getComplianceInfo() == null || adViewHolder.complianceView == null) ? false : true;
            Button button = adViewHolder.mCreativeButton;
            if (button != null) {
                hashMap.put(button, Integer.valueOf(z11 ? 1 : 2));
            }
            View view2 = adViewHolder.mCreativeButtonView;
            if (view2 != null) {
                hashMap.put(view2, Integer.valueOf(z11 ? 1 : 2));
            }
            if (adViewHolder.mCreativeButtonView != null) {
                hashMap.put(viewGroup, Integer.valueOf(z11 ? 1 : 2));
            }
            if (adViewHolder.mCreativeButtonView != null) {
                hashMap.put(view, Integer.valueOf(z11 ? 1 : 2));
            }
            if ((ksNativeAd.getMaterialType() == 1 || ksNativeAd.getMaterialType() == 8) && activity != null && adViewHolder.videoView != null) {
                View videoView = ksNativeAd.getVideoView(activity, new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).build());
                adViewHolder.videoView.setVisibility(0);
                adViewHolder.videoView.removeAllViews();
                adViewHolder.videoView.addView(videoView);
            }
        } else {
            hashMap.put(viewGroup, 2);
            hashMap.put(view, 2);
        }
        ksNativeAd.registerViewForInteraction(activity, viewGroup, hashMap, new KsNativeAd.AdInteractionListener() { // from class: com.martian.ads.ad.KsAd.6
            final /* synthetic */ AdConfig val$adConfig;

            public AnonymousClass6(AdConfig adConfig) {
                adConfig = adConfig;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                return false;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdClicked(View view3, KsNativeAd ksNativeAd2) {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.l(adConfig);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdShow(KsNativeAd ksNativeAd2) {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.b(adConfig);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
            }
        });
        if (ksNativeAd.getInteractionType() == 1) {
            ksNativeAd.setDownloadListener(new KsAppDownloadListener(appTask) { // from class: com.martian.ads.ad.KsAd.7
                final WeakReference<d8.a> adReceiverWeakReference;
                boolean isDownload = false;
                final /* synthetic */ AppTask val$appTask;

                public AnonymousClass7(AppTask appTask2) {
                    this.val$appTask = appTask2;
                    this.adReceiverWeakReference = new WeakReference<>(d8.a.this);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadStarted() {
                    d8.a aVar2 = this.adReceiverWeakReference.get();
                    if (aVar2 == null || this.isDownload) {
                        return;
                    }
                    this.isDownload = true;
                    aVar2.e(this.val$appTask);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    d8.a aVar2 = this.adReceiverWeakReference.get();
                    if (aVar2 != null) {
                        aVar2.f(this.val$appTask);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i10) {
                }
            });
        }
    }

    private static String getAdnName(String str) {
        if (TextUtils.isEmpty(str)) {
            return AdnName.OTHER;
        }
        str.hashCode();
        switch (str) {
        }
        return AdnName.OTHER;
    }

    public static boolean isKsDrawAd(AppTask appTask) {
        return appTask != null && (appTask.origin instanceof KsDrawAd);
    }

    public static boolean isKsFlowAd(AppTask appTask) {
        return appTask != null && (appTask.origin instanceof KsNativeAd);
    }

    public static boolean isKsSplashAd(AppTask appTask) {
        return appTask.origin instanceof KsSplashScreenAd;
    }

    private void loadInteractionAd() {
        if (KsAdSDK.getLoadManager() == null) {
            onError(new c(-1, "未初始化"));
        } else {
            KsAdSDK.getLoadManager().loadInterstitialAd(new KsScene.Builder(Long.parseLong(this.adConfig.getAdsId())).build(), new KsLoadManager.InterstitialAdListener() { // from class: com.martian.ads.ad.KsAd.5

                /* renamed from: com.martian.ads.ad.KsAd$5$1 */
                public class AnonymousClass1 implements KsInterstitialAd.AdInteractionListener {
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onAdClicked() {
                        KsAd.this.onClick();
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onAdClosed() {
                        KsAd.this.onClose();
                        KsAd.this.onRewardVerify(true);
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onAdShow() {
                        KsAd.this.onExpose();
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onPageDismiss() {
                        KsAd.this.onDismiss();
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onSkippedAd() {
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onVideoPlayEnd() {
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onVideoPlayError(int i10, int i11) {
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onVideoPlayStart() {
                    }
                }

                public AnonymousClass5() {
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public void onError(int i10, String str) {
                    KsAd.this.onError(new c(i10, str));
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list) {
                    if (list == null || list.isEmpty() || list.get(0) == null) {
                        KsAd.this.onError(new c(-1, "广告为空"));
                        return;
                    }
                    KsInterstitialAd ksInterstitialAd = list.get(0);
                    ksInterstitialAd.setAdInteractionListener(new KsInterstitialAd.AdInteractionListener() { // from class: com.martian.ads.ad.KsAd.5.1
                        public AnonymousClass1() {
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onAdClicked() {
                            KsAd.this.onClick();
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onAdClosed() {
                            KsAd.this.onClose();
                            KsAd.this.onRewardVerify(true);
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onAdShow() {
                            KsAd.this.onExpose();
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onPageDismiss() {
                            KsAd.this.onDismiss();
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onSkippedAd() {
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onVideoPlayEnd() {
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onVideoPlayError(int i10, int i11) {
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onVideoPlayStart() {
                        }
                    });
                    AppTask appTask = KsAd.this.adConfig.toAppTask();
                    appTask.origin = ksInterstitialAd;
                    if (KsAd.this.adConfig.isBidding()) {
                        KsAd.this.setBiddingEcpm(appTask, ksInterstitialAd.getECPM());
                    }
                    KsAd.this.getAppTaskList().addAppTask(appTask);
                    KsAd.this.onAdReceived();
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public void onRequestResult(int i10) {
                }
            });
        }
    }

    private void loadSplashAds() {
        if (KsAdSDK.getLoadManager() == null) {
            onError(new c(-1, "未初始化"));
        } else {
            KsAdSDK.getLoadManager().loadSplashScreenAd(new KsScene.Builder(Long.parseLong(this.adConfig.getAdsId())).build(), new KsLoadManager.SplashScreenAdListener() { // from class: com.martian.ads.ad.KsAd.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public void onError(int i10, String str) {
                    KsAd.this.onError(new c(i10, str));
                }

                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public void onRequestResult(int i10) {
                }

                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
                    AppTask appTask = KsAd.this.adConfig.toAppTask();
                    appTask.origin = ksSplashScreenAd;
                    if (KsAd.this.adConfig.isBidding()) {
                        KsAd.this.setBiddingEcpm(appTask, ksSplashScreenAd.getECPM());
                    }
                    KsAd.this.getAppTaskList().addAppTask(appTask);
                    KsAd.this.onAdReceived();
                }
            });
        }
    }

    private void loadVideoAd() {
        if (KsAdSDK.getLoadManager() == null) {
            onError(new c(-1, "未初始化"));
            return;
        }
        this.mRewardVideoAd = null;
        KsAdSDK.getLoadManager().loadRewardVideoAd(new KsScene.Builder(Long.parseLong(this.adConfig.getAdsId())).build(), new KsLoadManager.RewardVideoAdListener() { // from class: com.martian.ads.ad.KsAd.4

            /* renamed from: com.martian.ads.ad.KsAd$4$1 */
            public class AnonymousClass1 implements KsRewardVideoAd.RewardAdInteractionListener {
                private boolean verify = false;

                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onAdClicked() {
                    KsAd.this.onClick();
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onExtraRewardVerify(int i10) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onPageDismiss() {
                    KsAd.this.onClose();
                    KsAd.this.onRewardVerify(this.verify);
                    KsAd.this.mRewardVideoAd = null;
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onRewardStepVerify(int i10, int i11) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onRewardVerify() {
                    this.verify = true;
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayEnd() {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayError(int i10, int i11) {
                    KsAd.this.onError(new c(i10, "" + i11));
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayStart() {
                    KsAd.this.onExpose();
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoSkipToEnd(long j10) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onRewardVerify(Map<String, Object> map) {
                    this.verify = true;
                }
            }

            public AnonymousClass4() {
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onError(int i10, String str) {
                KsAd.this.onError(new c(i10, str));
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
                if (list == null || list.isEmpty()) {
                    KsAd.this.onError(new c(-1, "广告为空"));
                    return;
                }
                KsAd.this.mRewardVideoAd = list.get(0);
                KsRewardVideoAd ksRewardVideoAd = KsAd.this.mRewardVideoAd;
                if (ksRewardVideoAd == null || !ksRewardVideoAd.isAdEnable()) {
                    KsAd.this.onError(new c(-1, "广告无效"));
                    return;
                }
                KsAd.this.mRewardVideoAd.setRewardAdInteractionListener(new KsRewardVideoAd.RewardAdInteractionListener() { // from class: com.martian.ads.ad.KsAd.4.1
                    private boolean verify = false;

                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onAdClicked() {
                        KsAd.this.onClick();
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onExtraRewardVerify(int i10) {
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onPageDismiss() {
                        KsAd.this.onClose();
                        KsAd.this.onRewardVerify(this.verify);
                        KsAd.this.mRewardVideoAd = null;
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onRewardStepVerify(int i10, int i11) {
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onRewardVerify() {
                        this.verify = true;
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onVideoPlayEnd() {
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onVideoPlayError(int i10, int i11) {
                        KsAd.this.onError(new c(i10, "" + i11));
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onVideoPlayStart() {
                        KsAd.this.onExpose();
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onVideoSkipToEnd(long j10) {
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onRewardVerify(Map<String, Object> map) {
                        this.verify = true;
                    }
                });
                AppTask appTask = KsAd.this.adConfig.toAppTask();
                KsAd ksAd = KsAd.this;
                appTask.origin = ksAd.mRewardVideoAd;
                if (ksAd.adConfig.isBidding()) {
                    KsAd ksAd2 = KsAd.this;
                    ksAd2.setBiddingEcpm(appTask, ksAd2.mRewardVideoAd.getECPM());
                }
                KsAd.this.getAppTaskList().addAppTask(appTask);
                KsAd.this.onAdReceived();
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onRewardVideoResult(@Nullable List<KsRewardVideoAd> list) {
            }
        });
    }

    public static void sendDrawLossNotification(int i10, @NonNull KsDrawAd ksDrawAd) {
        AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
        adExposureFailedReason.winEcpm = i10;
        ksDrawAd.reportAdExposureFailed(2, adExposureFailedReason);
    }

    public static void sendDrawWinNotification(@NonNull AppTask appTask) {
        ((KsDrawAd) appTask.origin).setBidEcpm(appTask.getOriginalEcpm(), appTask.getLoseEcpm());
    }

    public static void sendInterstitialLossNotification(int i10, @NonNull KsInterstitialAd ksInterstitialAd) {
        AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
        adExposureFailedReason.winEcpm = i10;
        ksInterstitialAd.reportAdExposureFailed(2, adExposureFailedReason);
    }

    public static void sendLossNotification(AppTask appTask, int i10, String str, @NonNull KsNativeAd ksNativeAd) {
        AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
        adExposureFailedReason.winEcpm = i10;
        adExposureFailedReason.setIsShow(1);
        adExposureFailedReason.setIsClick(2);
        if (!TextUtils.isEmpty(str)) {
            adExposureFailedReason.adnType = str.equals("KS") ? 1 : 2;
            adExposureFailedReason.adnName = getAdnName(str);
        }
        if (appTask != null) {
            if (appTask.getComplianceInfo() != null && !TextUtils.isEmpty(appTask.getComplianceInfo().getAppDeveloperName())) {
                adExposureFailedReason.setAdUserName(appTask.getComplianceInfo().getAppDeveloperName());
            }
            if (!TextUtils.isEmpty(appTask.getTitle())) {
                adExposureFailedReason.setAdTitle(appTask.getTitle());
            }
            if (!TextUtils.isEmpty(appTask.f12000id)) {
                adExposureFailedReason.setAdRequestId(appTask.f12000id);
            }
        }
        ksNativeAd.reportAdExposureFailed(2, adExposureFailedReason);
    }

    public static void sendSplashLossNotification(int i10, @NonNull KsSplashScreenAd ksSplashScreenAd) {
        AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
        adExposureFailedReason.winEcpm = i10;
        ksSplashScreenAd.reportAdExposureFailed(2, adExposureFailedReason);
    }

    public static void sendVideoLossNotification(int i10, @NonNull KsRewardVideoAd ksRewardVideoAd) {
        AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
        adExposureFailedReason.winEcpm = i10;
        ksRewardVideoAd.reportAdExposureFailed(2, adExposureFailedReason);
    }

    public static void sendWinNotification(@NonNull AppTask appTask) {
        ((KsNativeAd) appTask.origin).setBidEcpm(appTask.getOriginalEcpm(), appTask.getLoseEcpm());
    }

    public void setBiddingEcpm(AppTask appTask, int i10) {
        if (i10 > 0 && this.adConfig.getEcpmPercent() > l5.c.f27899e) {
            appTask.setOriginalEcpm(i10);
            i10 = (int) ((i10 * this.adConfig.getEcpmPercent()) / 100.0d);
        }
        appTask.setEcpm(i10);
        this.adConfig.setEcpm(i10);
    }

    public static void showInterstitialAd(Activity activity, AppTask appTask) {
        KsInterstitialAd ksInterstitialAd = (KsInterstitialAd) appTask.origin;
        if (appTask.isBidding()) {
            ksInterstitialAd.setBidEcpm(ksInterstitialAd.getECPM());
        }
        ksInterstitialAd.showInterstitialAd(activity, new KsVideoPlayConfig.Builder().videoSoundEnable(false).build());
    }

    public static void showSplashAd(Activity activity, AppTask appTask, ViewGroup viewGroup, d8.a aVar) {
        KsSplashScreenAd ksSplashScreenAd = (KsSplashScreenAd) appTask.origin;
        if (appTask.isBidding()) {
            ksSplashScreenAd.setBidEcpm(ksSplashScreenAd.getECPM());
        }
        View view = ksSplashScreenAd.getView(activity, new KsSplashScreenAd.SplashScreenAdInteractionListener() { // from class: com.martian.ads.ad.KsAd.2
            final /* synthetic */ AdConfig val$adConfig;

            public AnonymousClass2(AdConfig adConfig) {
                adConfig = adConfig;
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdClicked() {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.l(adConfig);
                }
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowEnd() {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.g(adConfig);
                }
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowError(int i10, String str) {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.c(adConfig, null);
                }
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowStart() {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.b(adConfig);
                }
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogCancel() {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogShow() {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onSkippedAd() {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.d(adConfig);
                }
            }
        });
        if (view != null) {
            viewGroup.addView(view);
        }
    }

    public static void showVideoAd(Activity activity, @NonNull KsRewardVideoAd ksRewardVideoAd, boolean z10) {
        if (z10) {
            ksRewardVideoAd.setBidEcpm(ksRewardVideoAd.getECPM());
        }
        ksRewardVideoAd.showRewardVideoAd(activity, null);
    }

    public AppTask toAppTask(KsNativeAd ksNativeAd) {
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = ksNativeAd;
        if (!l.q(ksNativeAd.getAppName())) {
            appTask.title = ConfigSingleton.D().s(ksNativeAd.getAppName());
        }
        appTask.desc = ConfigSingleton.D().s(ksNativeAd.getAdDescription());
        if (!l.q(ksNativeAd.getAppDownloadCountDes())) {
            appTask.appPromote = ConfigSingleton.D().s(ksNativeAd.getAppDownloadCountDes());
        } else if (ksNativeAd.getAppScore() > 0.0f) {
            appTask.appPromote = ksNativeAd.getAppScore() + "分";
        } else {
            appTask.appPromote = ConfigSingleton.D().s("赞助正版章节");
        }
        if (ksNativeAd.getInteractionType() == 1) {
            appTask.buttonText = ConfigSingleton.D().s("立即下载");
            if (!l.q(ksNativeAd.getAppName()) && !l.q(ksNativeAd.getCorporationName()) && !l.q(ksNativeAd.getAppPrivacyUrl())) {
                ComplianceInfo complianceInfo = new ComplianceInfo();
                complianceInfo.setAppName(ksNativeAd.getAppName());
                complianceInfo.setAppVersion(ksNativeAd.getAppVersion());
                complianceInfo.setAppDeveloperName(ksNativeAd.getCorporationName());
                complianceInfo.setAppPermissionUrl(ksNativeAd.getPermissionInfoUrl());
                complianceInfo.setAppPrivacyUrl(ksNativeAd.getAppPrivacyUrl());
                complianceInfo.setAppFunctionDescUrl(ksNativeAd.getIntroductionInfoUrl());
                appTask.setComplianceInfo(complianceInfo);
            }
        } else {
            String actionDescription = ksNativeAd.getActionDescription();
            if (!l.q(actionDescription) && !actionDescription.contains("0")) {
                appTask.buttonText = ConfigSingleton.D().s(actionDescription);
            }
        }
        if (this.adConfig.isBidding()) {
            setBiddingEcpm(appTask, ksNativeAd.getECPM());
        }
        appTask.packageName = ksNativeAd.getAppPackageName();
        appTask.name = ksNativeAd.getAppName();
        if (!l.q(ksNativeAd.getAppIconUrl())) {
            appTask.iconUrl = ksNativeAd.getAppIconUrl();
        }
        if (ksNativeAd.getVideoWidth() > 0) {
            appTask.setPicWidth(ksNativeAd.getVideoWidth());
        }
        if (ksNativeAd.getVideoHeight() > 0) {
            appTask.setPicHeight(ksNativeAd.getVideoHeight());
        }
        List<KsImage> imageList = ksNativeAd.getImageList();
        if (imageList != null && !imageList.isEmpty()) {
            Iterator<KsImage> it = imageList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                KsImage next = it.next();
                if (appTask.getPosterUrls().isEmpty()) {
                    if (next.getHeight() > 0) {
                        appTask.setPicHeight(next.getHeight());
                    }
                    if (next.getWidth() > 0) {
                        appTask.setPicWidth(next.getWidth());
                    }
                    appTask.addPosterUrl(next.getImageUrl());
                } else if (l.q(appTask.iconUrl)) {
                    appTask.iconUrl = next.getImageUrl();
                }
            }
        } else if (ksNativeAd.getVideoCoverImage() == null || l.q(ksNativeAd.getVideoCoverImage().getImageUrl())) {
            appTask.addPosterUrl(ksNativeAd.getAppIconUrl());
        } else {
            KsImage videoCoverImage = ksNativeAd.getVideoCoverImage();
            if (videoCoverImage.getHeight() > 0) {
                appTask.setPicHeight(videoCoverImage.getHeight());
            }
            if (videoCoverImage.getWidth() > 0) {
                appTask.setPicWidth(videoCoverImage.getWidth());
            }
            appTask.addPosterUrl(videoCoverImage.getImageUrl());
        }
        if (l.q(appTask.iconUrl)) {
            appTask.iconUrl = appTask.getPosterUrl();
        }
        return appTask;
    }

    @Override // com.martian.ads.ad.BaseAd
    public void loadAds(Context context) {
        char c10;
        try {
            onAdRequest();
            String type = this.adConfig.getType();
            switch (type.hashCode()) {
                case -1052618729:
                    if (type.equals(AdConfig.AdType.NATIVE)) {
                        c10 = 0;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -895866265:
                    if (type.equals("splash")) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 3091780:
                    if (type.equals("draw")) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 604727084:
                    if (type.equals("interstitial")) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 2087282539:
                    if (type.equals(AdConfig.AdType.REWARD_VIDEO)) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                default:
                    c10 = 65535;
                    break;
            }
            if (c10 == 0) {
                loadFlowAds();
                return;
            }
            if (c10 == 1) {
                loadDrawAds(context);
                return;
            }
            if (c10 == 2) {
                loadSplashAds();
                return;
            }
            if (c10 == 3) {
                loadInteractionAd();
            } else if (c10 != 4) {
                onError(null);
            } else {
                loadVideoAd();
            }
        } catch (Exception unused) {
            onError(new c(-1, "异常"));
        }
    }

    public void loadDrawAds(Context context) {
        if (KsAdSDK.getLoadManager() == null) {
            onError(new c(-1, "未初始化"));
        } else {
            KsAdSDK.getLoadManager().loadDrawAd(new KsScene.Builder(Long.parseLong(this.adConfig.getAdsId())).adNum(this.adConfig.getAdsCount()).build(), new KsLoadManager.DrawAdListener() { // from class: com.martian.ads.ad.KsAd.8
                final /* synthetic */ Context val$context;

                public AnonymousClass8(Context context2) {
                    context = context2;
                }

                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
                    if (list == null || list.isEmpty()) {
                        KsAd.this.onError(null);
                        return;
                    }
                    for (KsDrawAd ksDrawAd : list) {
                        if (ksDrawAd != null && ksDrawAd.getDrawView(context) != null) {
                            ksDrawAd.setVideoSoundEnable(false);
                            KsAd.this.getAppTaskList().addAppTask(KsAd.this.toAppTask(ksDrawAd));
                        }
                    }
                    if (KsAd.this.getAppTaskList().isEmpty()) {
                        KsAd.this.onError(null);
                    } else {
                        KsAd.this.onAdReceived();
                    }
                }

                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public void onError(int i10, String str) {
                    KsAd.this.onError(new c(i10, str));
                }
            });
        }
    }

    public void loadFlowAds() {
        if (KsAdSDK.getLoadManager() == null) {
            onError(new c(-1, "未初始化"));
        } else {
            KsAdSDK.getLoadManager().loadNativeAd(new KsScene.Builder(Long.parseLong(this.adConfig.getAdsId())).adNum(this.adConfig.getAdsCount()).build(), new KsLoadManager.NativeAdListener() { // from class: com.martian.ads.ad.KsAd.3
                public AnonymousClass3() {
                }

                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public void onError(int i10, String str) {
                    KsAd.this.onError(new c(i10, str));
                }

                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
                    if (list == null || list.isEmpty()) {
                        KsAd.this.onError(null);
                        return;
                    }
                    Iterator<KsNativeAd> it = list.iterator();
                    while (it.hasNext()) {
                        KsAd.this.getAppTaskList().addAppTask(KsAd.this.toAppTask(it.next()));
                    }
                    KsAd.this.onAdReceived();
                }
            });
        }
    }

    public AppTask toAppTask(KsDrawAd ksDrawAd) {
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = ksDrawAd;
        if (this.adConfig.isBidding()) {
            setBiddingEcpm(appTask, ksDrawAd.getECPM());
        }
        appTask.setPicWidth(900);
        appTask.setPicHeight(1600);
        return appTask;
    }
}
