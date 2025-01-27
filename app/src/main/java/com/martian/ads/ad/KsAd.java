package com.martian.ads.ad;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.ViewWrapper;
import com.martian.libmars.d.h;
import com.martian.libsupport.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class KsAd extends BaseAd {
    private boolean cancelLoading;
    public KsRewardVideoAd mRewardVideoAd;

    /* renamed from: com.martian.ads.ad.KsAd$1 */
    class AnonymousClass1 implements KsLoadManager.SplashScreenAdListener {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onError(int code, String msg) {
            KsAd.this.onError(new b.d.c.b.c(code, msg));
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onRequestResult(int i2) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onSplashScreenAdLoad(KsSplashScreenAd splashScreenAd) {
            AppTask appTask = KsAd.this.adConfig.toAppTask();
            appTask.origin = splashScreenAd;
            int ecpm = splashScreenAd.getECPM();
            if (KsAd.this.adConfig.isBidding() || ecpm > 0) {
                if (KsAd.this.adConfig.getEcpmPercent() > 0.0d) {
                    double d2 = ecpm;
                    double ecpmPercent = KsAd.this.adConfig.getEcpmPercent();
                    Double.isNaN(d2);
                    ecpm = (int) ((d2 * ecpmPercent) / 100.0d);
                }
                appTask.setEcpm(ecpm);
                KsAd.this.adConfig.setEcpm(ecpm);
            }
            KsAd.this.getAppTaskList().addAppTask(appTask);
            KsAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.KsAd$2 */
    static class AnonymousClass2 implements KsSplashScreenAd.SplashScreenAdInteractionListener {
        final /* synthetic */ AdConfig val$adConfig;

        AnonymousClass2(final AdConfig val$receiver) {
            Q = val$receiver;
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdClicked() {
            b.d.a.k.a aVar = b.d.a.k.a.this;
            if (aVar != null) {
                aVar.j(Q);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowEnd() {
            b.d.a.k.a aVar = b.d.a.k.a.this;
            if (aVar != null) {
                aVar.c(Q);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowError(int code, String extra) {
            b.d.a.k.a aVar = b.d.a.k.a.this;
            if (aVar != null) {
                aVar.g(Q, null);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowStart() {
            b.d.a.k.a aVar = b.d.a.k.a.this;
            if (aVar != null) {
                aVar.a(Q);
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
            b.d.a.k.a aVar = b.d.a.k.a.this;
            if (aVar != null) {
                aVar.b(Q);
            }
        }
    }

    /* renamed from: com.martian.ads.ad.KsAd$3 */
    class AnonymousClass3 implements KsLoadManager.NativeAdListener {
        final /* synthetic */ Activity val$activity;

        AnonymousClass3(final Activity val$activity) {
            activity = val$activity;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onError(int code, String msg) {
            KsAd.this.onError(new b.d.c.b.c(code, msg));
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onNativeAdLoad(@Nullable List<KsNativeAd> adList) {
            if (adList == null || adList.isEmpty()) {
                KsAd.this.onError(null);
                return;
            }
            Iterator<KsNativeAd> it = adList.iterator();
            while (it.hasNext()) {
                KsAd.this.getAppTaskList().addAppTask(KsAd.this.toAppTask(activity, it.next()));
            }
            KsAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.KsAd$4 */
    class AnonymousClass4 implements KsLoadManager.RewardVideoAdListener {

        /* renamed from: com.martian.ads.ad.KsAd$4$1 */
        class AnonymousClass1 implements KsRewardVideoAd.RewardAdInteractionListener {
            private boolean verify = false;

            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onAdClicked() {
                KsAd.this.onClick();
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onExtraRewardVerify(int i2) {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onPageDismiss() {
                KsAd.this.onClose();
                KsAd.this.onRewardVerify(this.verify);
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onRewardStepVerify(int i2, int i1) {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify() {
                this.verify = true;
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayEnd() {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayError(int code, int extra) {
                KsAd.this.onError(new b.d.c.b.c(code, "" + extra));
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayStart() {
                KsAd.this.onExpose();
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoSkipToEnd(long l) {
            }
        }

        AnonymousClass4() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onError(int code, String msg) {
            KsAd.this.onError(new b.d.c.b.c(code, msg));
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> adList) {
            if (adList == null || adList.isEmpty()) {
                KsAd.this.onError(new b.d.c.b.c(-1, "广告为空"));
                return;
            }
            KsAd.this.mRewardVideoAd = adList.get(0);
            KsRewardVideoAd ksRewardVideoAd = KsAd.this.mRewardVideoAd;
            if (ksRewardVideoAd == null || !ksRewardVideoAd.isAdEnable()) {
                KsAd.this.onError(new b.d.c.b.c(-1, "广告无效"));
                return;
            }
            KsAd.this.mRewardVideoAd.setRewardAdInteractionListener(new KsRewardVideoAd.RewardAdInteractionListener() { // from class: com.martian.ads.ad.KsAd.4.1
                private boolean verify = false;

                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onAdClicked() {
                    KsAd.this.onClick();
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onExtraRewardVerify(int i2) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onPageDismiss() {
                    KsAd.this.onClose();
                    KsAd.this.onRewardVerify(this.verify);
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onRewardStepVerify(int i2, int i1) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onRewardVerify() {
                    this.verify = true;
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayEnd() {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayError(int code, int extra) {
                    KsAd.this.onError(new b.d.c.b.c(code, "" + extra));
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayStart() {
                    KsAd.this.onExpose();
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoSkipToEnd(long l) {
                }
            });
            AppTask appTask = KsAd.this.adConfig.toAppTask();
            KsAd ksAd = KsAd.this;
            appTask.origin = ksAd.mRewardVideoAd;
            if (ksAd.adConfig.isBidding() || KsAd.this.mRewardVideoAd.getECPM() > 0) {
                int ecpm = KsAd.this.mRewardVideoAd.getECPM();
                if (KsAd.this.adConfig.getEcpmPercent() > 0.0d) {
                    double d2 = ecpm;
                    double ecpmPercent = KsAd.this.adConfig.getEcpmPercent();
                    Double.isNaN(d2);
                    ecpm = (int) ((d2 * ecpmPercent) / 100.0d);
                }
                appTask.setEcpm(ecpm);
                KsAd.this.adConfig.setEcpm(ecpm);
            }
            KsAd.this.getAppTaskList().addAppTask(appTask);
            KsAd.this.onAdReceived();
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoResult(@Nullable List<KsRewardVideoAd> list) {
        }
    }

    /* renamed from: com.martian.ads.ad.KsAd$5 */
    class AnonymousClass5 implements KsLoadManager.InterstitialAdListener {

        /* renamed from: com.martian.ads.ad.KsAd$5$1 */
        class AnonymousClass1 implements KsInterstitialAd.AdInteractionListener {
            AnonymousClass1() {
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
            public void onVideoPlayError(int i2, int i1) {
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onVideoPlayStart() {
            }
        }

        AnonymousClass5() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onError(int i2, String s) {
            KsAd.this.onError(new b.d.c.b.c(i2, s));
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> adList) {
            if (adList == null || adList.size() <= 0 || adList.get(0) == null) {
                KsAd.this.onError(new b.d.c.b.c(-1, "广告为空"));
                return;
            }
            KsInterstitialAd ksInterstitialAd = adList.get(0);
            ksInterstitialAd.setAdInteractionListener(new KsInterstitialAd.AdInteractionListener() { // from class: com.martian.ads.ad.KsAd.5.1
                AnonymousClass1() {
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
                public void onVideoPlayError(int i2, int i1) {
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onVideoPlayStart() {
                }
            });
            AppTask appTask = KsAd.this.adConfig.toAppTask();
            appTask.origin = ksInterstitialAd;
            int ecpm = ksInterstitialAd.getECPM();
            if (KsAd.this.adConfig.isBidding() || ecpm > 0) {
                if (KsAd.this.adConfig.getEcpmPercent() > 0.0d) {
                    double d2 = ecpm;
                    double ecpmPercent = KsAd.this.adConfig.getEcpmPercent();
                    Double.isNaN(d2);
                    ecpm = (int) ((d2 * ecpmPercent) / 100.0d);
                }
                appTask.setEcpm(ecpm);
                KsAd.this.adConfig.setEcpm(ecpm);
            }
            KsAd.this.getAppTaskList().addAppTask(appTask);
            KsAd.this.onAdReceived();
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onRequestResult(int adNumber) {
        }
    }

    /* renamed from: com.martian.ads.ad.KsAd$6 */
    static class AnonymousClass6 implements KsNativeAd.AdInteractionListener {
        final /* synthetic */ AppTask val$appTask;

        AnonymousClass6(final AppTask val$innerListener) {
            appTask = val$innerListener;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            return false;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdClicked(View view, KsNativeAd ad2) {
            b.d.a.k.a.this.j(b.d.a.j.b.Q(appTask));
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdShow(KsNativeAd ad2) {
            b.d.a.j.b.J(appTask, b.d.a.k.a.this);
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onDownloadTipsDialogShow() {
        }
    }

    /* renamed from: com.martian.ads.ad.KsAd$7 */
    static class AnonymousClass7 implements KsAppDownloadListener {
        boolean isDownload = false;

        AnonymousClass7() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadStarted() {
            if (this.isDownload) {
                return;
            }
            this.isDownload = true;
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int progress) {
        }
    }

    public KsAd(AdConfig config, @NonNull b.d.a.k.a receiver) {
        super(config, receiver);
        this.cancelLoading = false;
    }

    public static void bindFlowAd(Activity activity, final AppTask appTask, ViewGroup adContainer, View adView, View creativeView, final b.d.a.k.a innerListener) {
        KsNativeAd ksNativeAd = (KsNativeAd) appTask.origin;
        if (ksNativeAd == null) {
            return;
        }
        if (adContainer != null) {
            if (adView == null) {
                adView = adContainer;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(adView, 2);
            if (creativeView != null) {
                hashMap.put(creativeView, 1);
            }
            ksNativeAd.registerViewForInteraction(activity, adContainer, hashMap, new KsNativeAd.AdInteractionListener() { // from class: com.martian.ads.ad.KsAd.6
                final /* synthetic */ AppTask val$appTask;

                AnonymousClass6(final AppTask appTask2) {
                    appTask = appTask2;
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                    return false;
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onAdClicked(View view, KsNativeAd ad2) {
                    b.d.a.k.a.this.j(b.d.a.j.b.Q(appTask));
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onAdShow(KsNativeAd ad2) {
                    b.d.a.j.b.J(appTask, b.d.a.k.a.this);
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onDownloadTipsDialogDismiss() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onDownloadTipsDialogShow() {
                }
            });
        }
        if (ksNativeAd.getInteractionType() == 1) {
            ksNativeAd.setDownloadListener(new KsAppDownloadListener() { // from class: com.martian.ads.ad.KsAd.7
                boolean isDownload = false;

                AnonymousClass7() {
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadStarted() {
                    if (this.isDownload) {
                        return;
                    }
                    this.isDownload = true;
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int progress) {
                }
            });
        }
    }

    public static boolean isKsFlowAd(AppTask appTask) {
        return appTask != null && (appTask.origin instanceof KsNativeAd);
    }

    private void loadInteractionAd() {
        if (KsAdSDK.getLoadManager() == null) {
            onError(new b.d.c.b.c(-1, "未初始化"));
        } else {
            KsAdSDK.getLoadManager().loadInterstitialAd(new KsScene.Builder(Long.parseLong(this.adConfig.getAdsId())).build(), new KsLoadManager.InterstitialAdListener() { // from class: com.martian.ads.ad.KsAd.5

                /* renamed from: com.martian.ads.ad.KsAd$5$1 */
                class AnonymousClass1 implements KsInterstitialAd.AdInteractionListener {
                    AnonymousClass1() {
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
                    public void onVideoPlayError(int i2, int i1) {
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onVideoPlayStart() {
                    }
                }

                AnonymousClass5() {
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public void onError(int i2, String s) {
                    KsAd.this.onError(new b.d.c.b.c(i2, s));
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> adList) {
                    if (adList == null || adList.size() <= 0 || adList.get(0) == null) {
                        KsAd.this.onError(new b.d.c.b.c(-1, "广告为空"));
                        return;
                    }
                    KsInterstitialAd ksInterstitialAd = adList.get(0);
                    ksInterstitialAd.setAdInteractionListener(new KsInterstitialAd.AdInteractionListener() { // from class: com.martian.ads.ad.KsAd.5.1
                        AnonymousClass1() {
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
                        public void onVideoPlayError(int i2, int i1) {
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onVideoPlayStart() {
                        }
                    });
                    AppTask appTask = KsAd.this.adConfig.toAppTask();
                    appTask.origin = ksInterstitialAd;
                    int ecpm = ksInterstitialAd.getECPM();
                    if (KsAd.this.adConfig.isBidding() || ecpm > 0) {
                        if (KsAd.this.adConfig.getEcpmPercent() > 0.0d) {
                            double d2 = ecpm;
                            double ecpmPercent = KsAd.this.adConfig.getEcpmPercent();
                            Double.isNaN(d2);
                            ecpm = (int) ((d2 * ecpmPercent) / 100.0d);
                        }
                        appTask.setEcpm(ecpm);
                        KsAd.this.adConfig.setEcpm(ecpm);
                    }
                    KsAd.this.getAppTaskList().addAppTask(appTask);
                    KsAd.this.onAdReceived();
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public void onRequestResult(int adNumber) {
                }
            });
        }
    }

    private void loadSplashAds() {
        if (KsAdSDK.getLoadManager() == null) {
            onError(new b.d.c.b.c(-1, "未初始化"));
        } else {
            KsAdSDK.getLoadManager().loadSplashScreenAd(new KsScene.Builder(Long.parseLong(this.adConfig.getAdsId())).build(), new KsLoadManager.SplashScreenAdListener() { // from class: com.martian.ads.ad.KsAd.1
                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public void onError(int code, String msg) {
                    KsAd.this.onError(new b.d.c.b.c(code, msg));
                }

                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public void onRequestResult(int i2) {
                }

                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public void onSplashScreenAdLoad(KsSplashScreenAd splashScreenAd) {
                    AppTask appTask = KsAd.this.adConfig.toAppTask();
                    appTask.origin = splashScreenAd;
                    int ecpm = splashScreenAd.getECPM();
                    if (KsAd.this.adConfig.isBidding() || ecpm > 0) {
                        if (KsAd.this.adConfig.getEcpmPercent() > 0.0d) {
                            double d2 = ecpm;
                            double ecpmPercent = KsAd.this.adConfig.getEcpmPercent();
                            Double.isNaN(d2);
                            ecpm = (int) ((d2 * ecpmPercent) / 100.0d);
                        }
                        appTask.setEcpm(ecpm);
                        KsAd.this.adConfig.setEcpm(ecpm);
                    }
                    KsAd.this.getAppTaskList().addAppTask(appTask);
                    KsAd.this.onAdReceived();
                }
            });
        }
    }

    private void loadVideoAd() {
        if (KsAdSDK.getLoadManager() == null) {
            onError(new b.d.c.b.c(-1, "未初始化"));
            return;
        }
        this.mRewardVideoAd = null;
        KsAdSDK.getLoadManager().loadRewardVideoAd(new KsScene.Builder(Long.parseLong(this.adConfig.getAdsId())).build(), new KsLoadManager.RewardVideoAdListener() { // from class: com.martian.ads.ad.KsAd.4

            /* renamed from: com.martian.ads.ad.KsAd$4$1 */
            class AnonymousClass1 implements KsRewardVideoAd.RewardAdInteractionListener {
                private boolean verify = false;

                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onAdClicked() {
                    KsAd.this.onClick();
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onExtraRewardVerify(int i2) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onPageDismiss() {
                    KsAd.this.onClose();
                    KsAd.this.onRewardVerify(this.verify);
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onRewardStepVerify(int i2, int i1) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onRewardVerify() {
                    this.verify = true;
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayEnd() {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayError(int code, int extra) {
                    KsAd.this.onError(new b.d.c.b.c(code, "" + extra));
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayStart() {
                    KsAd.this.onExpose();
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoSkipToEnd(long l) {
                }
            }

            AnonymousClass4() {
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onError(int code, String msg) {
                KsAd.this.onError(new b.d.c.b.c(code, msg));
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> adList) {
                if (adList == null || adList.isEmpty()) {
                    KsAd.this.onError(new b.d.c.b.c(-1, "广告为空"));
                    return;
                }
                KsAd.this.mRewardVideoAd = adList.get(0);
                KsRewardVideoAd ksRewardVideoAd = KsAd.this.mRewardVideoAd;
                if (ksRewardVideoAd == null || !ksRewardVideoAd.isAdEnable()) {
                    KsAd.this.onError(new b.d.c.b.c(-1, "广告无效"));
                    return;
                }
                KsAd.this.mRewardVideoAd.setRewardAdInteractionListener(new KsRewardVideoAd.RewardAdInteractionListener() { // from class: com.martian.ads.ad.KsAd.4.1
                    private boolean verify = false;

                    AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onAdClicked() {
                        KsAd.this.onClick();
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onExtraRewardVerify(int i2) {
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onPageDismiss() {
                        KsAd.this.onClose();
                        KsAd.this.onRewardVerify(this.verify);
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onRewardStepVerify(int i2, int i1) {
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onRewardVerify() {
                        this.verify = true;
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onVideoPlayEnd() {
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onVideoPlayError(int code, int extra) {
                        KsAd.this.onError(new b.d.c.b.c(code, "" + extra));
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onVideoPlayStart() {
                        KsAd.this.onExpose();
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onVideoSkipToEnd(long l) {
                    }
                });
                AppTask appTask = KsAd.this.adConfig.toAppTask();
                KsAd ksAd = KsAd.this;
                appTask.origin = ksAd.mRewardVideoAd;
                if (ksAd.adConfig.isBidding() || KsAd.this.mRewardVideoAd.getECPM() > 0) {
                    int ecpm = KsAd.this.mRewardVideoAd.getECPM();
                    if (KsAd.this.adConfig.getEcpmPercent() > 0.0d) {
                        double d2 = ecpm;
                        double ecpmPercent = KsAd.this.adConfig.getEcpmPercent();
                        Double.isNaN(d2);
                        ecpm = (int) ((d2 * ecpmPercent) / 100.0d);
                    }
                    appTask.setEcpm(ecpm);
                    KsAd.this.adConfig.setEcpm(ecpm);
                }
                KsAd.this.getAppTaskList().addAppTask(appTask);
                KsAd.this.onAdReceived();
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onRewardVideoResult(@Nullable List<KsRewardVideoAd> list) {
            }
        });
    }

    public static void sendInterstitialLossNotification(int winPrice, @NonNull KsInterstitialAd mKsInterstitialAd) {
        AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
        adExposureFailedReason.winEcpm = winPrice;
        mKsInterstitialAd.reportAdExposureFailed(2, adExposureFailedReason);
    }

    public static void sendLossNotification(int winPrice, @NonNull KsNativeAd ksNativeAd) {
        AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
        adExposureFailedReason.winEcpm = winPrice;
        ksNativeAd.reportAdExposureFailed(2, adExposureFailedReason);
    }

    public static void sendSplashLossNotification(int winPrice, @NonNull KsSplashScreenAd SplashAd) {
        AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
        adExposureFailedReason.winEcpm = winPrice;
        SplashAd.reportAdExposureFailed(2, adExposureFailedReason);
    }

    public static void sendVideoLossNotification(int winPrice, @NonNull KsRewardVideoAd rewardVideoAd) {
        AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
        adExposureFailedReason.winEcpm = winPrice;
        rewardVideoAd.reportAdExposureFailed(2, adExposureFailedReason);
    }

    public static void sendWinNotification(@NonNull KsNativeAd ksNativeAd) {
        ksNativeAd.setBidEcpm(ksNativeAd.getECPM());
    }

    public static boolean showInterstitialAd(Activity activity, KsInterstitialAd mKsInterstitialAd, boolean isBidding) {
        if (isBidding) {
            mKsInterstitialAd.setBidEcpm(mKsInterstitialAd.getECPM());
        }
        mKsInterstitialAd.showInterstitialAd(activity, new KsVideoPlayConfig.Builder().videoSoundEnable(false).build());
        return true;
    }

    public static void showSplashAd(Activity activity, AppTask appTask, ViewGroup viewGroup, b.d.a.k.a receiver) {
        KsSplashScreenAd ksSplashScreenAd = (KsSplashScreenAd) appTask.origin;
        if (appTask.isBidding()) {
            ksSplashScreenAd.setBidEcpm(ksSplashScreenAd.getECPM());
        }
        viewGroup.addView(ksSplashScreenAd.getView(activity, new KsSplashScreenAd.SplashScreenAdInteractionListener() { // from class: com.martian.ads.ad.KsAd.2
            final /* synthetic */ AdConfig val$adConfig;

            AnonymousClass2(final AdConfig val$receiver) {
                Q = val$receiver;
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdClicked() {
                b.d.a.k.a aVar = b.d.a.k.a.this;
                if (aVar != null) {
                    aVar.j(Q);
                }
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowEnd() {
                b.d.a.k.a aVar = b.d.a.k.a.this;
                if (aVar != null) {
                    aVar.c(Q);
                }
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowError(int code, String extra) {
                b.d.a.k.a aVar = b.d.a.k.a.this;
                if (aVar != null) {
                    aVar.g(Q, null);
                }
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowStart() {
                b.d.a.k.a aVar = b.d.a.k.a.this;
                if (aVar != null) {
                    aVar.a(Q);
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
                b.d.a.k.a aVar = b.d.a.k.a.this;
                if (aVar != null) {
                    aVar.b(Q);
                }
            }
        }));
    }

    public static void showVideoAd(Activity activity, @NonNull KsRewardVideoAd rewardVideoAd, boolean isBidding) {
        if (isBidding) {
            rewardVideoAd.setBidEcpm(rewardVideoAd.getECPM());
        }
        rewardVideoAd.showRewardVideoAd(activity, null);
    }

    public AppTask toAppTask(Activity activity, KsNativeAd adData) {
        View videoView;
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = adData;
        if (!k.p(adData.getAppName())) {
            appTask.title = h.F().n(adData.getAppName());
        }
        appTask.desc = h.F().n(adData.getAdDescription());
        if (!k.p(adData.getAppDownloadCountDes())) {
            appTask.appPromote = h.F().n(adData.getAppDownloadCountDes());
        } else if (adData.getAppScore() > 0.0f) {
            appTask.appPromote = adData.getAppScore() + "分";
        } else {
            appTask.appPromote = h.F().n("赞助正版章节");
        }
        if (!k.p(adData.getActionDescription())) {
            appTask.buttonText = h.F().n(adData.getActionDescription());
        }
        if (adData.getECPM() > 0) {
            int ecpm = adData.getECPM();
            if (this.adConfig.getEcpmPercent() > 0.0d) {
                double d2 = ecpm;
                double ecpmPercent = this.adConfig.getEcpmPercent();
                Double.isNaN(d2);
                ecpm = (int) ((d2 * ecpmPercent) / 100.0d);
            }
            appTask.setEcpm(ecpm);
            this.adConfig.setEcpm(ecpm);
        }
        appTask.packageName = adData.getAppPackageName();
        appTask.name = adData.getAppName();
        if (!k.p(adData.getAppIconUrl())) {
            appTask.iconUrl = adData.getAppIconUrl();
        }
        if (adData.getVideoWidth() > 0) {
            appTask.setPicWidth(adData.getVideoWidth());
        }
        if (adData.getVideoHeight() > 0) {
            appTask.setPicHeight(adData.getVideoHeight());
        }
        List<KsImage> imageList = adData.getImageList();
        if (imageList != null && imageList.size() > 0) {
            Iterator<KsImage> it = imageList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                KsImage next = it.next();
                if (appTask.getPosterUrls().size() <= 0) {
                    if (next.getHeight() > 0) {
                        appTask.setPicHeight(next.getHeight());
                    }
                    if (next.getWidth() > 0) {
                        appTask.setPicWidth(next.getWidth());
                    }
                    appTask.addPosterUrl(next.getImageUrl());
                } else if (k.p(appTask.iconUrl)) {
                    appTask.iconUrl = next.getImageUrl();
                }
            }
        } else if (adData.getVideoCoverImage() == null || k.p(adData.getVideoCoverImage().getImageUrl())) {
            appTask.addPosterUrl(adData.getAppIconUrl());
        } else {
            KsImage videoCoverImage = adData.getVideoCoverImage();
            if (videoCoverImage.getHeight() > 0) {
                appTask.setPicHeight(videoCoverImage.getHeight());
            }
            if (videoCoverImage.getWidth() > 0) {
                appTask.setPicWidth(videoCoverImage.getWidth());
            }
            appTask.addPosterUrl(videoCoverImage.getImageUrl());
        }
        if (k.p(appTask.iconUrl)) {
            appTask.iconUrl = appTask.getPosterUrl();
        }
        if (this.adConfig.isWifiEnv() && adData.getMaterialType() == 1 && activity != null && (videoView = adData.getVideoView(activity, new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).build())) != null) {
            appTask.isVideoAd = true;
            appTask.videoView = new ViewWrapper(videoView);
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
        try {
            if ("splash".equalsIgnoreCase(this.adConfig.getType())) {
                loadSplashAds();
            } else if (AdConfig.AdType.REWARD_VIDEO.equalsIgnoreCase(this.adConfig.getType())) {
                loadVideoAd();
            } else if (AdConfig.AdType.INTERSTITIAL.equalsIgnoreCase(this.adConfig.getType())) {
                loadInteractionAd();
            } else {
                loadFlowAds(activity);
            }
        } catch (Exception unused) {
            onError(new b.d.c.b.c(-1, "异常"));
        }
    }

    protected void loadFlowAds(Activity activity) {
        if (KsAdSDK.getLoadManager() == null) {
            onError(new b.d.c.b.c(-1, "未初始化"));
        } else {
            KsAdSDK.getLoadManager().loadNativeAd(new KsScene.Builder(Long.parseLong(this.adConfig.getAdsId())).adNum(this.adConfig.getAdsCount()).build(), new KsLoadManager.NativeAdListener() { // from class: com.martian.ads.ad.KsAd.3
                final /* synthetic */ Activity val$activity;

                AnonymousClass3(Activity activity2) {
                    activity = activity2;
                }

                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public void onError(int code, String msg) {
                    KsAd.this.onError(new b.d.c.b.c(code, msg));
                }

                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public void onNativeAdLoad(@Nullable List<KsNativeAd> adList) {
                    if (adList == null || adList.isEmpty()) {
                        KsAd.this.onError(null);
                        return;
                    }
                    Iterator<KsNativeAd> it = adList.iterator();
                    while (it.hasNext()) {
                        KsAd.this.getAppTaskList().addAppTask(KsAd.this.toAppTask(activity, it.next()));
                    }
                    KsAd.this.onAdReceived();
                }
            });
        }
    }
}
