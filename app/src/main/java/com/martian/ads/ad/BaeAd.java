package com.martian.ads.ad;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.FeedPortraitVideoView;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import com.baidu.mobads.sdk.api.XNativeView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.libmars.d.h;
import com.martian.libsupport.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class BaeAd extends BaseAd {
    public static String BIDDING_FAIL_LOW_PRICE = "203";
    private boolean cancelLoading;
    public RewardVideoAd mRewardVideoAd;

    /* renamed from: com.martian.ads.ad.BaeAd$1 */
    class AnonymousClass1 implements SplashInteractionListener {
        AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded() {
            AppTask appTask = BaeAd.this.getAppTaskList().getApps().get(0);
            SplashAd splashAd = (SplashAd) appTask.origin;
            if (!k.p(splashAd.getECPMLevel())) {
                try {
                    int parseInt = Integer.parseInt(splashAd.getECPMLevel());
                    if (BaeAd.this.adConfig.isBidding() || parseInt > 0) {
                        if (BaeAd.this.adConfig.getEcpmPercent() > 0.0d) {
                            double d2 = parseInt;
                            double ecpmPercent = BaeAd.this.adConfig.getEcpmPercent();
                            Double.isNaN(d2);
                            parseInt = (int) ((d2 * ecpmPercent) / 100.0d);
                        }
                        appTask.setEcpm(parseInt);
                        BaeAd.this.adConfig.setEcpm(parseInt);
                    }
                } catch (Exception unused) {
                }
            }
            BaeAd.this.onAdReceived();
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheSuccess() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdClick() {
            BaeAd.this.onClick();
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdDismissed() {
            BaeAd.this.onDismiss();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String arg0) {
            BaeAd.this.onError(new b.d.c.b.c(-1, arg0));
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdPresent() {
            BaeAd.this.onExpose();
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onLpClosed() {
            BaeAd.this.onClose();
        }
    }

    /* renamed from: com.martian.ads.ad.BaeAd$2 */
    class AnonymousClass2 implements BaiduNativeManager.PortraitVideoAdListener {
        final /* synthetic */ Activity val$activity;

        AnonymousClass2(final Activity val$activity) {
            activity = val$activity;
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.PortraitVideoAdListener
        public void onAdClick() {
            BaeAd.this.onClick();
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeFail(int i2, String s) {
            BaeAd.this.onError(null);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeLoad(final List<NativeResponse> nativeResponses) {
            if (nativeResponses == null || nativeResponses.isEmpty()) {
                BaeAd.this.onError(null);
                return;
            }
            for (NativeResponse nativeResponse : nativeResponses) {
                AppTask appTask = BaeAd.this.toAppTask(activity, nativeResponse);
                if (nativeResponse.getMaterialType() == NativeResponse.MaterialType.VIDEO) {
                    appTask.isVideoAd = true;
                    FeedPortraitVideoView feedPortraitVideoView = new FeedPortraitVideoView(activity);
                    feedPortraitVideoView.setCanClickVideo(true ^ BaeAd.this.adConfig.isAdCompliance());
                    feedPortraitVideoView.setAdData(nativeResponse);
                    appTask.videoView = new b.d.a.c(feedPortraitVideoView);
                }
                BaeAd.this.getAppTaskList().addAppTask(appTask);
            }
            BaeAd.this.onAdReceived();
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNoAd(int i2, String s) {
            BaeAd.this.onError(null);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadSuccess() {
        }
    }

    /* renamed from: com.martian.ads.ad.BaeAd$3 */
    class AnonymousClass3 implements BaiduNativeManager.FeedAdListener {
        final /* synthetic */ Activity val$activity;

        AnonymousClass3(final Activity val$activity) {
            activity = val$activity;
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeFail(int i2, String s) {
            BaeAd.this.onError(new b.d.c.b.c(i2, s));
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeLoad(List<NativeResponse> list) {
            if (list == null || list.isEmpty()) {
                BaeAd.this.onError(null);
                return;
            }
            for (NativeResponse nativeResponse : list) {
                if (nativeResponse != null) {
                    BaeAd.this.getAppTaskList().addAppTask(BaeAd.this.toAppTask(activity, nativeResponse));
                }
            }
            BaeAd.this.onAdReceived();
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNoAd(int i2, String s) {
            BaeAd.this.onError(new b.d.c.b.c(i2, s));
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadSuccess() {
        }
    }

    /* renamed from: com.martian.ads.ad.BaeAd$4 */
    class AnonymousClass4 implements RewardVideoAd.RewardVideoAdListener {
        private boolean verify = false;

        AnonymousClass4() {
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdClick() {
            BaeAd.this.onClick();
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdClose(float v) {
            BaeAd.this.onClose();
            BaeAd.this.onRewardVerify(this.verify);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdFailed(String s) {
            BaeAd.this.onError(new b.d.c.b.c(-1, s));
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdLoaded() {
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdShow() {
            BaeAd.this.onExpose();
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdSkip(float v) {
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
        public void onRewardVerify(boolean rewardVerify) {
            this.verify = rewardVerify;
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onVideoDownloadFailed() {
            BaeAd.this.onError(null);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onVideoDownloadSuccess() {
            BaeAd baeAd = BaeAd.this;
            if (baeAd.mRewardVideoAd == null) {
                baeAd.onError(null);
                return;
            }
            AppTask appTask = baeAd.adConfig.toAppTask();
            RewardVideoAd rewardVideoAd = BaeAd.this.mRewardVideoAd;
            appTask.origin = rewardVideoAd;
            if (!k.p(rewardVideoAd.getECPMLevel())) {
                try {
                    int parseInt = Integer.parseInt(BaeAd.this.mRewardVideoAd.getECPMLevel());
                    if (BaeAd.this.adConfig.getEcpmPercent() > 0.0d) {
                        double d2 = parseInt;
                        double ecpmPercent = BaeAd.this.adConfig.getEcpmPercent();
                        Double.isNaN(d2);
                        parseInt = (int) ((d2 * ecpmPercent) / 100.0d);
                    }
                    appTask.setEcpm(parseInt);
                    BaeAd.this.adConfig.setEcpm(parseInt);
                } catch (Exception unused) {
                }
            }
            BaeAd.this.getAppTaskList().addAppTask(appTask);
            BaeAd.this.onAdReceived();
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void playCompletion() {
        }
    }

    /* renamed from: com.martian.ads.ad.BaeAd$5 */
    class AnonymousClass5 implements ExpressInterstitialListener {
        final /* synthetic */ ExpressInterstitialAd val$expressInterstitialAd;

        AnonymousClass5(final ExpressInterstitialAd val$expressInterstitialAd) {
            expressInterstitialAd = val$expressInterstitialAd;
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onADExposed() {
            BaeAd.this.onExpose();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onADExposureFailed() {
            BaeAd.this.onError(null);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onADLoaded() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdCacheFailed() {
            BaeAd.this.onError(null);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdCacheSuccess() {
            AppTask appTask = BaeAd.this.adConfig.toAppTask();
            ExpressInterstitialAd expressInterstitialAd = expressInterstitialAd;
            appTask.origin = expressInterstitialAd;
            if (!k.p(expressInterstitialAd.getECPMLevel())) {
                try {
                    int parseInt = Integer.parseInt(expressInterstitialAd.getECPMLevel());
                    if (BaeAd.this.adConfig.getEcpmPercent() > 0.0d) {
                        double d2 = parseInt;
                        double ecpmPercent = BaeAd.this.adConfig.getEcpmPercent();
                        Double.isNaN(d2);
                        parseInt = (int) ((d2 * ecpmPercent) / 100.0d);
                    }
                    appTask.setEcpm(parseInt);
                    BaeAd.this.adConfig.setEcpm(parseInt);
                } catch (Exception unused) {
                }
            }
            BaeAd.this.getAppTaskList().addAppTask(appTask);
            BaeAd.this.onAdReceived();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdClick() {
            BaeAd.this.onClick();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdClose() {
            BaeAd.this.onDismiss();
            BaeAd.this.onClose();
            BaeAd.this.onRewardVerify(true);
            expressInterstitialAd.destroy();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdFailed(int i2, String s) {
            BaeAd.this.onError(new b.d.c.b.c(i2, s));
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onNoAd(int i2, String s) {
            BaeAd.this.onError(new b.d.c.b.c(i2, s));
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onVideoDownloadSuccess() {
        }
    }

    /* renamed from: com.martian.ads.ad.BaeAd$6 */
    class AnonymousClass6 implements ExpressInterstitialAd.InterAdDownloadWindowListener {
        AnonymousClass6() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public void adDownloadWindowClose() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public void adDownloadWindowShow() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public void onADPermissionClose() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public void onADPermissionShow() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public void onADPrivacyClick() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public void onADPrivacyClose() {
        }
    }

    /* renamed from: com.martian.ads.ad.BaeAd$7 */
    static class AnonymousClass7 implements NativeResponse.AdInteractionListener {
        final /* synthetic */ AppTask val$appTask;

        AnonymousClass7(final AppTask val$innerListener) {
            appTask = val$innerListener;
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposed() {
            b.d.a.j.b.J(appTask, b.d.a.k.a.this);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposureFailed(int reason) {
            b.d.a.k.a.this.f(new b.d.c.b.c(reason, "曝光失败"));
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADStatusChanged() {
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdClick() {
            b.d.a.k.a.this.j(b.d.a.j.b.Q(appTask));
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdUnionClick() {
        }
    }

    public BaeAd(AdConfig config, @NonNull b.d.a.k.a receiver) {
        super(config, receiver);
        this.cancelLoading = false;
    }

    public static void bindFlowAd(AppTask appTask, ViewGroup adContainer, View adView, View creativeView, b.d.a.k.a innerListener) {
        View renderShakeView;
        ArrayList arrayList = new ArrayList();
        if (adView == null) {
            adView = adContainer;
        }
        ArrayList arrayList2 = new ArrayList();
        if (appTask.isAdCompliance()) {
            arrayList.add(adView);
        } else {
            arrayList2.add(adView);
            if (creativeView != null) {
                arrayList2.add(creativeView);
            }
        }
        if (appTask.isShakeStyle() && (renderShakeView = ((NativeResponse) appTask.origin).renderShakeView(100, 138, new NativeResponse.AdShakeViewListener() { // from class: com.martian.ads.ad.d
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
            public final void onDismiss() {
                BaeAd.lambda$bindFlowAd$0();
            }
        })) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.height = h.b(138.0f);
            layoutParams.gravity = 17;
            adContainer.addView(renderShakeView, layoutParams);
        }
        ((NativeResponse) appTask.origin).registerViewForInteraction(adContainer, arrayList, arrayList2, new NativeResponse.AdInteractionListener() { // from class: com.martian.ads.ad.BaeAd.7
            final /* synthetic */ AppTask val$appTask;

            AnonymousClass7(AppTask appTask2) {
                appTask = appTask2;
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposed() {
                b.d.a.j.b.J(appTask, b.d.a.k.a.this);
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposureFailed(int reason) {
                b.d.a.k.a.this.f(new b.d.c.b.c(reason, "曝光失败"));
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADStatusChanged() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdClick() {
                b.d.a.k.a.this.j(b.d.a.j.b.Q(appTask));
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdUnionClick() {
            }
        });
    }

    private static String getAdSource(String source) {
        source.hashCode();
        switch (source) {
            case "KS":
                return "4";
            case "BQT":
                return "2";
            case "CSJ":
                return "1";
            case "GDT":
                return "3";
            default:
                return "5";
        }
    }

    private static int getAdn(String source) {
        source.hashCode();
        switch (source) {
            case "KS":
                return 3;
            case "CSJ":
                return 1;
            case "GDT":
                return 2;
            default:
                return 10;
        }
    }

    public static boolean isBaeFlowAd(AppTask appTask) {
        return appTask != null && (appTask.origin instanceof NativeResponse);
    }

    static /* synthetic */ void lambda$bindFlowAd$0() {
    }

    private void loadInteractionAd(Activity activity) {
        if (Build.VERSION.SDK_INT <= 23) {
            onError(null);
            return;
        }
        ExpressInterstitialAd expressInterstitialAd = new ExpressInterstitialAd(activity, this.adConfig.getAdsId());
        if (!k.p(this.adConfig.getAppid())) {
            expressInterstitialAd.setAppSid(this.adConfig.getAppid());
        }
        expressInterstitialAd.setDialogFrame(true);
        expressInterstitialAd.setLoadListener(new ExpressInterstitialListener() { // from class: com.martian.ads.ad.BaeAd.5
            final /* synthetic */ ExpressInterstitialAd val$expressInterstitialAd;

            AnonymousClass5(ExpressInterstitialAd expressInterstitialAd2) {
                expressInterstitialAd = expressInterstitialAd2;
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onADExposed() {
                BaeAd.this.onExpose();
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onADExposureFailed() {
                BaeAd.this.onError(null);
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onADLoaded() {
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onAdCacheFailed() {
                BaeAd.this.onError(null);
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onAdCacheSuccess() {
                AppTask appTask = BaeAd.this.adConfig.toAppTask();
                ExpressInterstitialAd expressInterstitialAd2 = expressInterstitialAd;
                appTask.origin = expressInterstitialAd2;
                if (!k.p(expressInterstitialAd2.getECPMLevel())) {
                    try {
                        int parseInt = Integer.parseInt(expressInterstitialAd.getECPMLevel());
                        if (BaeAd.this.adConfig.getEcpmPercent() > 0.0d) {
                            double d2 = parseInt;
                            double ecpmPercent = BaeAd.this.adConfig.getEcpmPercent();
                            Double.isNaN(d2);
                            parseInt = (int) ((d2 * ecpmPercent) / 100.0d);
                        }
                        appTask.setEcpm(parseInt);
                        BaeAd.this.adConfig.setEcpm(parseInt);
                    } catch (Exception unused) {
                    }
                }
                BaeAd.this.getAppTaskList().addAppTask(appTask);
                BaeAd.this.onAdReceived();
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onAdClick() {
                BaeAd.this.onClick();
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onAdClose() {
                BaeAd.this.onDismiss();
                BaeAd.this.onClose();
                BaeAd.this.onRewardVerify(true);
                expressInterstitialAd.destroy();
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onAdFailed(int i2, String s) {
                BaeAd.this.onError(new b.d.c.b.c(i2, s));
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onLpClosed() {
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onNoAd(int i2, String s) {
                BaeAd.this.onError(new b.d.c.b.c(i2, s));
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onVideoDownloadFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onVideoDownloadSuccess() {
            }
        });
        expressInterstitialAd2.setDownloadListener(new ExpressInterstitialAd.InterAdDownloadWindowListener() { // from class: com.martian.ads.ad.BaeAd.6
            AnonymousClass6() {
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
            public void adDownloadWindowClose() {
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
            public void adDownloadWindowShow() {
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
            public void onADPermissionClose() {
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
            public void onADPermissionShow() {
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
            public void onADPrivacyClick() {
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
            public void onADPrivacyClose() {
            }
        });
        AdConfig.AdInfo adInfo = this.adConfig.getAdInfo();
        if (adInfo != null) {
            expressInterstitialAd2.setRequestParameters(new RequestParameters.Builder().addCustExt(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, getAdSource(adInfo.getSource())).addCustExt("B", "" + adInfo.getEcpm()).build());
        }
        expressInterstitialAd2.load();
    }

    private void loadSplashAds(Activity activity) {
        AnonymousClass1 anonymousClass1 = new SplashInteractionListener() { // from class: com.martian.ads.ad.BaeAd.1
            AnonymousClass1() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onADLoaded() {
                AppTask appTask = BaeAd.this.getAppTaskList().getApps().get(0);
                SplashAd splashAd = (SplashAd) appTask.origin;
                if (!k.p(splashAd.getECPMLevel())) {
                    try {
                        int parseInt = Integer.parseInt(splashAd.getECPMLevel());
                        if (BaeAd.this.adConfig.isBidding() || parseInt > 0) {
                            if (BaeAd.this.adConfig.getEcpmPercent() > 0.0d) {
                                double d2 = parseInt;
                                double ecpmPercent = BaeAd.this.adConfig.getEcpmPercent();
                                Double.isNaN(d2);
                                parseInt = (int) ((d2 * ecpmPercent) / 100.0d);
                            }
                            appTask.setEcpm(parseInt);
                            BaeAd.this.adConfig.setEcpm(parseInt);
                        }
                    } catch (Exception unused) {
                    }
                }
                BaeAd.this.onAdReceived();
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheSuccess() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdClick() {
                BaeAd.this.onClick();
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdDismissed() {
                BaeAd.this.onDismiss();
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdFailed(String arg0) {
                BaeAd.this.onError(new b.d.c.b.c(-1, arg0));
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdPresent() {
                BaeAd.this.onExpose();
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onLpClosed() {
                BaeAd.this.onClose();
            }
        };
        RequestParameters.Builder builder = new RequestParameters.Builder();
        builder.addExtra("timeout", "4000");
        builder.addExtra(SplashAd.KEY_DISPLAY_DOWNLOADINFO, "true");
        builder.addExtra(SplashAd.KEY_POPDIALOG_DOWNLOAD, "true");
        if (this.adConfig.getAdInfo() != null) {
            AdConfig.AdInfo adInfo = this.adConfig.getAdInfo();
            builder.addCustExt(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, getAdSource(adInfo.getSource())).addCustExt("B", "" + adInfo.getEcpm());
        }
        SplashAd splashAd = new SplashAd(activity.getApplicationContext(), this.adConfig.getAdsId(), builder.build(), anonymousClass1);
        if (!k.p(this.adConfig.getAppid())) {
            splashAd.setAppSid(this.adConfig.getAppid());
        }
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = splashAd;
        appTask.setPicWidth(720);
        appTask.setPicHeight(TTAdConstant.EXT_PLUGIN_UNINSTALL);
        getAppTaskList().addAppTask(appTask);
        splashAd.load();
    }

    private void loadTempFlowAds(Activity activity) {
        RequestParameters build;
        b.d.a.a baeArticleInfo = this.adConfig.getBaeArticleInfo();
        if (baeArticleInfo != null) {
            build = new RequestParameters.Builder().downloadAppConfirmPolicy(1).setWidth(this.adConfig.getWidth()).setHeight(this.adConfig.getHeight()).addExtra(ArticleInfo.USER_SEX, baeArticleInfo.f()).addExtra(ArticleInfo.FAVORITE_BOOK, baeArticleInfo.c()).addExtra(ArticleInfo.PAGE_TITLE, baeArticleInfo.e()).addExtra(ArticleInfo.PAGE_ID, baeArticleInfo.d()).addExtra(ArticleInfo.CONTENT_CATEGORY, baeArticleInfo.a()).addExtra(ArticleInfo.CONTENT_LABEL, baeArticleInfo.b()).build();
        } else {
            build = new RequestParameters.Builder().downloadAppConfirmPolicy(1).setWidth(this.adConfig.getWidth()).setHeight(this.adConfig.getHeight()).addExtra(ArticleInfo.USER_SEX, h.F().k() + "").build();
        }
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(activity, this.adConfig.getAdsId());
        if (!k.p(this.adConfig.getAppid())) {
            baiduNativeManager.setAppSid(this.adConfig.getAppid());
        }
        baiduNativeManager.setCacheVideoOnlyWifi(true);
        baiduNativeManager.loadPortraitVideoAd(build, (BaiduNativeManager.PortraitVideoAdListener) new BaiduNativeManager.PortraitVideoAdListener() { // from class: com.martian.ads.ad.BaeAd.2
            final /* synthetic */ Activity val$activity;

            AnonymousClass2(Activity activity2) {
                activity = activity2;
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.PortraitVideoAdListener
            public void onAdClick() {
                BaeAd.this.onClick();
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onLpClosed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeFail(int i2, String s) {
                BaeAd.this.onError(null);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeLoad(final List<NativeResponse> nativeResponses) {
                if (nativeResponses == null || nativeResponses.isEmpty()) {
                    BaeAd.this.onError(null);
                    return;
                }
                for (NativeResponse nativeResponse : nativeResponses) {
                    AppTask appTask = BaeAd.this.toAppTask(activity, nativeResponse);
                    if (nativeResponse.getMaterialType() == NativeResponse.MaterialType.VIDEO) {
                        appTask.isVideoAd = true;
                        FeedPortraitVideoView feedPortraitVideoView = new FeedPortraitVideoView(activity);
                        feedPortraitVideoView.setCanClickVideo(true ^ BaeAd.this.adConfig.isAdCompliance());
                        feedPortraitVideoView.setAdData(nativeResponse);
                        appTask.videoView = new b.d.a.c(feedPortraitVideoView);
                    }
                    BaeAd.this.getAppTaskList().addAppTask(appTask);
                }
                BaeAd.this.onAdReceived();
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNoAd(int i2, String s) {
                BaeAd.this.onError(null);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadSuccess() {
            }
        });
    }

    private void loadVideoAd(Activity activity) {
        if (Build.VERSION.SDK_INT <= 23) {
            onError(null);
            return;
        }
        this.mRewardVideoAd = new RewardVideoAd(activity, this.adConfig.getAdsId(), new RewardVideoAd.RewardVideoAdListener() { // from class: com.martian.ads.ad.BaeAd.4
            private boolean verify = false;

            AnonymousClass4() {
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdClick() {
                BaeAd.this.onClick();
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdClose(float v) {
                BaeAd.this.onClose();
                BaeAd.this.onRewardVerify(this.verify);
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdFailed(String s) {
                BaeAd.this.onError(new b.d.c.b.c(-1, s));
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdLoaded() {
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdShow() {
                BaeAd.this.onExpose();
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdSkip(float v) {
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
            public void onRewardVerify(boolean rewardVerify) {
                this.verify = rewardVerify;
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onVideoDownloadFailed() {
                BaeAd.this.onError(null);
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onVideoDownloadSuccess() {
                BaeAd baeAd = BaeAd.this;
                if (baeAd.mRewardVideoAd == null) {
                    baeAd.onError(null);
                    return;
                }
                AppTask appTask = baeAd.adConfig.toAppTask();
                RewardVideoAd rewardVideoAd = BaeAd.this.mRewardVideoAd;
                appTask.origin = rewardVideoAd;
                if (!k.p(rewardVideoAd.getECPMLevel())) {
                    try {
                        int parseInt = Integer.parseInt(BaeAd.this.mRewardVideoAd.getECPMLevel());
                        if (BaeAd.this.adConfig.getEcpmPercent() > 0.0d) {
                            double d2 = parseInt;
                            double ecpmPercent = BaeAd.this.adConfig.getEcpmPercent();
                            Double.isNaN(d2);
                            parseInt = (int) ((d2 * ecpmPercent) / 100.0d);
                        }
                        appTask.setEcpm(parseInt);
                        BaeAd.this.adConfig.setEcpm(parseInt);
                    } catch (Exception unused) {
                    }
                }
                BaeAd.this.getAppTaskList().addAppTask(appTask);
                BaeAd.this.onAdReceived();
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void playCompletion() {
            }
        });
        AdConfig.AdInfo adInfo = this.adConfig.getAdInfo();
        if (adInfo != null) {
            this.mRewardVideoAd.setRequestParameters(new RequestParameters.Builder().addCustExt(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, getAdSource(adInfo.getSource())).addCustExt("B", "" + adInfo.getEcpm()).build());
        }
        if (!k.p(this.adConfig.getAppid())) {
            this.mRewardVideoAd.setAppSid(this.adConfig.getAppid());
        }
        this.mRewardVideoAd.load();
    }

    public static void sendInterstitialLossNotification(@NonNull ExpressInterstitialAd expressInterstitialAd) {
        expressInterstitialAd.biddingFail(BIDDING_FAIL_LOW_PRICE);
    }

    public static void sendLossNotification(AppTask winAppTask, @NonNull NativeResponse nativeResponse, String reason) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(SplashAd.KEY_BIDFAIL_ECPM, Integer.valueOf(winAppTask.getEcpm()));
        hashMap.put(SplashAd.KEY_BIDFAIL_ADN, Integer.valueOf(getAdn(winAppTask.source)));
        nativeResponse.biddingFail(reason, hashMap);
    }

    public static void sendSplashLossNotification(@NonNull SplashAd splashAd) {
        splashAd.biddingFail(BIDDING_FAIL_LOW_PRICE);
    }

    public static void sendVideoLossNotification(@NonNull RewardVideoAd rewardVideoAd) {
        rewardVideoAd.biddingFail(BIDDING_FAIL_LOW_PRICE);
    }

    public static void sendWinNotification(@NonNull NativeResponse nativeResponse) {
        nativeResponse.biddingSuccess(nativeResponse.getECPMLevel());
    }

    public static void showInterstitialAd(Activity activity, @NonNull ExpressInterstitialAd expressInterstitialAd, boolean isBidding) {
        if (isBidding) {
            expressInterstitialAd.biddingSuccess(expressInterstitialAd.getECPMLevel());
        }
        if (expressInterstitialAd.isReady()) {
            expressInterstitialAd.show(activity);
        }
    }

    public static void showSplashAd(@NonNull SplashAd splashAd, ViewGroup viewGroup, boolean isBidding) {
        if (isBidding) {
            splashAd.biddingSuccess(splashAd.getECPMLevel());
        }
        splashAd.show(viewGroup);
    }

    public static void showVideoAd(@NonNull RewardVideoAd rewardVideoAd, boolean isBidding) {
        if (isBidding) {
            rewardVideoAd.biddingSuccess(rewardVideoAd.getECPMLevel());
        }
        rewardVideoAd.show();
    }

    public AppTask toAppTask(Activity activity, NativeResponse adData) {
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = adData;
        appTask.title = h.F().n(adData.getTitle());
        appTask.desc = h.F().n(adData.getDesc());
        if (!k.p(adData.getIconUrl())) {
            appTask.iconUrl = adData.getIconUrl();
        }
        if (!k.p(adData.getActButtonString())) {
            appTask.buttonText = h.F().n(adData.getActButtonString());
        }
        if (!k.p(adData.getMarketingPendant())) {
            appTask.marketUrl = adData.getMarketingPendant();
        }
        appTask.appPromote = h.F().n("赞助正版章节");
        if (!k.p(adData.getECPMLevel())) {
            try {
                int parseInt = Integer.parseInt(adData.getECPMLevel());
                if (this.adConfig.getEcpmPercent() > 0.0d) {
                    double d2 = parseInt;
                    double ecpmPercent = this.adConfig.getEcpmPercent();
                    Double.isNaN(d2);
                    parseInt = (int) ((d2 * ecpmPercent) / 100.0d);
                }
                appTask.setEcpm(parseInt);
                this.adConfig.setEcpm(parseInt);
            } catch (Exception unused) {
            }
        }
        List<String> multiPicUrls = adData.getMultiPicUrls();
        if (multiPicUrls != null && multiPicUrls.size() > 0) {
            for (String str : multiPicUrls) {
                if (appTask.getPosterUrls().size() > 0 && k.p(appTask.iconUrl)) {
                    appTask.iconUrl = str;
                }
                appTask.addPosterUrl(str);
            }
        } else if (k.p(adData.getImageUrl())) {
            appTask.addPosterUrl(adData.getIconUrl());
        } else {
            appTask.addPosterUrl(adData.getImageUrl());
        }
        if (k.p(appTask.iconUrl)) {
            appTask.iconUrl = appTask.getPosterUrl();
        }
        if (this.adConfig.isWifiEnv() && adData.getMaterialType() == NativeResponse.MaterialType.VIDEO && activity != null) {
            appTask.isVideoAd = true;
            XNativeView xNativeView = new XNativeView(activity);
            xNativeView.setNativeItem(adData);
            xNativeView.setVideoMute(true);
            xNativeView.setUseDownloadFrame(this.adConfig.isAdCompliance());
            appTask.videoView = new b.d.a.b(xNativeView);
        }
        appTask.packageName = adData.getAppPackage();
        appTask.name = adData.getBrandName();
        appTask.setPicWidth(adData.getMainPicWidth());
        appTask.setPicHeight(adData.getMainPicHeight());
        appTask.baseUrl = adData.getBaiduLogoUrl();
        appTask.setAdCompliance(this.adConfig.isAdCompliance());
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
        if (AdConfig.AdType.REWARD_VIDEO.equalsIgnoreCase(this.adConfig.getType())) {
            loadVideoAd(activity);
            return;
        }
        if (AdConfig.AdType.INTERSTITIAL.equalsIgnoreCase(this.adConfig.getType())) {
            loadInteractionAd(activity);
        } else if (AdConfig.AdType.EXPRESS.equalsIgnoreCase(this.adConfig.getType())) {
            loadTempFlowAds(activity);
        } else {
            loadFlowAds(activity);
        }
    }

    protected void loadFlowAds(Activity activity) {
        RequestParameters build;
        b.d.a.a baeArticleInfo = this.adConfig.getBaeArticleInfo();
        if (baeArticleInfo != null) {
            AdConfig.AdInfo adInfo = this.adConfig.getAdInfo();
            if (adInfo == null) {
                build = new RequestParameters.Builder().downloadAppConfirmPolicy(1).addExtra(ArticleInfo.USER_SEX, baeArticleInfo.f()).addExtra(ArticleInfo.FAVORITE_BOOK, baeArticleInfo.c()).addExtra(ArticleInfo.PAGE_TITLE, baeArticleInfo.e()).addExtra(ArticleInfo.PAGE_ID, baeArticleInfo.d()).addExtra(ArticleInfo.CONTENT_CATEGORY, baeArticleInfo.a()).addExtra(ArticleInfo.CONTENT_LABEL, baeArticleInfo.b()).build();
            } else {
                build = new RequestParameters.Builder().downloadAppConfirmPolicy(1).addExtra(ArticleInfo.USER_SEX, baeArticleInfo.f()).addExtra(ArticleInfo.FAVORITE_BOOK, baeArticleInfo.c()).addExtra(ArticleInfo.PAGE_TITLE, baeArticleInfo.e()).addExtra(ArticleInfo.PAGE_ID, baeArticleInfo.d()).addCustExt(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, getAdSource(adInfo.getSource())).addCustExt("B", "" + adInfo.getEcpm()).addExtra(ArticleInfo.CONTENT_CATEGORY, baeArticleInfo.a()).addExtra(ArticleInfo.CONTENT_LABEL, baeArticleInfo.b()).build();
            }
        } else {
            build = new RequestParameters.Builder().downloadAppConfirmPolicy(1).addExtra(ArticleInfo.USER_SEX, h.F().k() + "").build();
        }
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(activity, this.adConfig.getAdsId());
        if (!k.p(this.adConfig.getAppid())) {
            baiduNativeManager.setAppSid(this.adConfig.getAppid());
        }
        baiduNativeManager.setCacheVideoOnlyWifi(true);
        baiduNativeManager.loadFeedAd(build, new BaiduNativeManager.FeedAdListener() { // from class: com.martian.ads.ad.BaeAd.3
            final /* synthetic */ Activity val$activity;

            AnonymousClass3(Activity activity2) {
                activity = activity2;
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onLpClosed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeFail(int i2, String s) {
                BaeAd.this.onError(new b.d.c.b.c(i2, s));
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeLoad(List<NativeResponse> list) {
                if (list == null || list.isEmpty()) {
                    BaeAd.this.onError(null);
                    return;
                }
                for (NativeResponse nativeResponse : list) {
                    if (nativeResponse != null) {
                        BaeAd.this.getAppTaskList().addAppTask(BaeAd.this.toAppTask(activity, nativeResponse));
                    }
                }
                BaeAd.this.onAdReceived();
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNoAd(int i2, String s) {
                BaeAd.this.onError(new b.d.c.b.c(i2, s));
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadSuccess() {
            }
        });
    }
}
