package ad;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import b.d.a.j.b;
import b.d.a.k.a;
import b.d.c.b.c;
import com.heytap.msp.mobad.api.InitParams;
import com.heytap.msp.mobad.api.MobAdManager;
import com.heytap.msp.mobad.api.ad.HotSplashAd;
import com.heytap.msp.mobad.api.ad.InterstitialAd;
import com.heytap.msp.mobad.api.ad.NativeAdvanceAd;
import com.heytap.msp.mobad.api.ad.RewardVideoAd;
import com.heytap.msp.mobad.api.listener.IHotSplashListener;
import com.heytap.msp.mobad.api.listener.IInitListener;
import com.heytap.msp.mobad.api.listener.IInterstitialAdListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener;
import com.heytap.msp.mobad.api.listener.IRewardVideoAdListener;
import com.heytap.msp.mobad.api.params.INativeAdFile;
import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import com.heytap.msp.mobad.api.params.MediaView;
import com.heytap.msp.mobad.api.params.NativeAdvanceContainer;
import com.heytap.msp.mobad.api.params.RewardVideoAdParams;
import com.heytap.msp.mobad.api.params.SplashAdParams;
import com.kwad.sdk.api.model.AdnName;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.BaseAd;
import com.martian.apptask.data.AppTask;
import com.martian.libmars.d.h;
import com.martian.libsupport.k;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.k0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class OppoAd extends BaseAd {
    private boolean cancelLoading;
    private HotSplashAd hotSplashAd;
    private InterstitialAd mInterstitialAd;
    private RewardVideoAd mRewardVideoAd;

    /* renamed from: ad.OppoAd$1 */
    class AnonymousClass1 implements IHotSplashListener {
        AnonymousClass1() {
        }

        @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
        public void onAdClick() {
            OppoAd.this.onClick();
        }

        @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
        public void onAdDismissed() {
            OppoAd.this.onDismiss();
        }

        @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
        public void onAdFailed(int i2, String s) {
            OppoAd.this.onError(new c(i2, s));
        }

        @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
        public void onAdReady() {
            int ecpm;
            AppTask appTask = OppoAd.this.getAppTaskList().getApps().get(0);
            if (appTask != null && ((((BaseAd) OppoAd.this).adConfig.isBidding() || OppoAd.this.hotSplashAd.getECPM() > 0) && (ecpm = OppoAd.this.hotSplashAd.getECPM()) > 0)) {
                appTask.setEcpm(ecpm);
                ((BaseAd) OppoAd.this).adConfig.setEcpm(ecpm);
            }
            OppoAd.this.onAdReceived();
        }

        @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
        public void onAdShow(String s) {
            OppoAd.this.onExpose();
        }
    }

    /* renamed from: ad.OppoAd$2 */
    class AnonymousClass2 implements IInterstitialAdListener {
        AnonymousClass2() {
        }

        @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
        public void onAdClick() {
            OppoAd.this.onClick();
        }

        @Override // com.heytap.msp.mobad.api.listener.IInterstitialAdListener
        public void onAdClose() {
            OppoAd.this.onClose();
            if (OppoAd.this.mInterstitialAd != null) {
                OppoAd.this.mInterstitialAd.destroyAd();
            }
        }

        @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
        public void onAdFailed(String s) {
            OppoAd.this.onError(new c(-1, s));
        }

        @Override // com.heytap.msp.mobad.api.listener.IInterstitialAdListener
        public void onAdReady() {
            if (OppoAd.this.mInterstitialAd == null) {
                OppoAd.this.onError(new c(-1, ""));
                return;
            }
            AppTask appTask = ((BaseAd) OppoAd.this).adConfig.toAppTask();
            appTask.origin = OppoAd.this.mInterstitialAd;
            int ecpm = OppoAd.this.mInterstitialAd.getECPM();
            if (((BaseAd) OppoAd.this).adConfig.isBidding() || ecpm > 0) {
                appTask.setEcpm(ecpm);
                ((BaseAd) OppoAd.this).adConfig.setEcpm(ecpm);
            }
            OppoAd.this.getAppTaskList().addAppTask(appTask);
            OppoAd.this.onAdReceived();
        }

        @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
        public void onAdShow() {
            OppoAd.this.onExpose();
        }

        @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
        public void onAdFailed(int i2, String s) {
            OppoAd.this.onError(new c(i2, s));
        }
    }

    /* renamed from: ad.OppoAd$3 */
    class AnonymousClass3 implements IRewardVideoAdListener {
        private boolean verify = false;

        AnonymousClass3() {
        }

        @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
        public void onAdClick(long l) {
            OppoAd.this.onClick();
        }

        @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
        public void onAdFailed(String s) {
            OppoAd.this.fallback(new c(-1, s));
        }

        @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
        public void onAdSuccess() {
            if (OppoAd.this.mRewardVideoAd == null || !OppoAd.this.mRewardVideoAd.isReady()) {
                if (OppoAd.this.mRewardVideoAd != null) {
                    OppoAd.this.mRewardVideoAd.destroyAd();
                }
                OppoAd.this.onError(new c(-1, ""));
                return;
            }
            AppTask appTask = ((BaseAd) OppoAd.this).adConfig.toAppTask();
            appTask.origin = OppoAd.this.mRewardVideoAd;
            int ecpm = OppoAd.this.mRewardVideoAd.getECPM();
            if (((BaseAd) OppoAd.this).adConfig.isBidding() || ecpm > 0) {
                appTask.setEcpm(ecpm);
                ((BaseAd) OppoAd.this).adConfig.setEcpm(ecpm);
            }
            OppoAd.this.getAppTaskList().addAppTask(appTask);
            OppoAd.this.onAdReceived();
        }

        @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
        public void onLandingPageClose() {
        }

        @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
        public void onLandingPageOpen() {
        }

        @Override // com.heytap.msp.mobad.api.listener.IRewardListener
        public void onReward(Object... objects) {
            this.verify = true;
        }

        @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
        public void onVideoPlayClose(long l) {
            OppoAd.this.onClose();
            OppoAd.this.onRewardVerify(this.verify);
        }

        @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
        public void onVideoPlayComplete() {
        }

        @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
        public void onVideoPlayError(String s) {
        }

        @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
        public void onVideoPlayStart() {
            OppoAd.this.onExpose();
        }

        @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
        public void onAdFailed(int i2, String s) {
            OppoAd.this.fallback(new c(i2, s));
        }
    }

    /* renamed from: ad.OppoAd$4 */
    class AnonymousClass4 implements INativeAdvanceLoadListener {
        AnonymousClass4() {
        }

        @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener
        public void onAdFailed(int i2, String s) {
            OppoAd.this.fallback(new c(i2, s));
        }

        @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener
        public void onAdSuccess(List<INativeAdvanceData> list) {
            if (list == null || list.isEmpty()) {
                OppoAd.this.fallback(null);
            } else {
                OppoAd.this.getAppTaskList().addAppTask(OppoAd.this.toAppTask(list.get(0)));
                OppoAd.this.onAdReceived();
            }
        }
    }

    /* renamed from: ad.OppoAd$5 */
    static class AnonymousClass5 implements INativeAdvanceInteractListener {
        final /* synthetic */ AppTask val$appTask;

        AnonymousClass5(final AppTask val$innerListener) {
            appTask = val$innerListener;
        }

        @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
        public void onClick() {
            a.this.j(b.Q(appTask));
        }

        @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
        public void onError(int code, String msg) {
            a.this.g(b.Q(appTask), new c(code, msg));
        }

        @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
        public void onShow() {
            a.this.a(b.Q(appTask));
        }
    }

    /* renamed from: ad.OppoAd$6 */
    static class AnonymousClass6 implements INativeAdvanceMediaListener {
        AnonymousClass6() {
        }

        @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
        public void onVideoPlayComplete() {
        }

        @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
        public void onVideoPlayError(int errorCode, String msg) {
        }

        @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
        public void onVideoPlayStart() {
        }
    }

    /* renamed from: ad.OppoAd$7 */
    static class AnonymousClass7 implements IInitListener {
        AnonymousClass7() {
        }

        @Override // com.heytap.msp.mobad.api.listener.IInitListener
        public void onFailed(String s) {
            MiConfigSingleton.x.this.onFailed(s);
        }

        @Override // com.heytap.msp.mobad.api.listener.IInitListener
        public void onSuccess() {
            MiConfigSingleton.x.this.onSuccess();
        }
    }

    public OppoAd() {
        this.cancelLoading = false;
    }

    public static void bindFlowAd(Activity activity, final AppTask appTask, ViewGroup adContainer, View adView, ViewGroup videoView, View creativeView, final a innerListener) {
        if (adContainer == null || adView == null) {
            return;
        }
        INativeAdvanceData iNativeAdvanceData = (INativeAdvanceData) appTask.origin;
        adContainer.removeAllViews();
        ViewGroup viewGroup = (ViewGroup) adView.getParent();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        NativeAdvanceContainer nativeAdvanceContainer = new NativeAdvanceContainer(activity);
        nativeAdvanceContainer.addView(adView, -1, -2);
        adContainer.addView(nativeAdvanceContainer);
        iNativeAdvanceData.setInteractListener(new INativeAdvanceInteractListener() { // from class: ad.OppoAd.5
            final /* synthetic */ AppTask val$appTask;

            AnonymousClass5(final AppTask appTask2) {
                appTask = appTask2;
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
            public void onClick() {
                a.this.j(b.Q(appTask));
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
            public void onError(int code, String msg) {
                a.this.g(b.Q(appTask), new c(code, msg));
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
            public void onShow() {
                a.this.a(b.Q(appTask));
            }
        });
        ArrayList arrayList = new ArrayList();
        if (creativeView != null) {
            arrayList.add(creativeView);
        }
        arrayList.add(adView);
        iNativeAdvanceData.bindToView(activity, nativeAdvanceContainer, arrayList);
        if (!appTask2.isVideoAd || videoView == null) {
            return;
        }
        videoView.setVisibility(0);
        videoView.removeAllViews();
        MediaView mediaView = new MediaView(activity);
        videoView.addView(mediaView);
        iNativeAdvanceData.bindMediaView(activity, mediaView, new INativeAdvanceMediaListener() { // from class: ad.OppoAd.6
            AnonymousClass6() {
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
            public void onVideoPlayComplete() {
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
            public void onVideoPlayError(int errorCode, String msg) {
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
            public void onVideoPlayStart() {
            }
        });
    }

    public static void exit(Context context) {
        MobAdManager.getInstance().exit(context);
    }

    public void fallback(c errorResult) {
        onError(errorResult);
    }

    public static void initialOppoAdSdk(Context context, MiConfigSingleton.x listener) {
        try {
            MobAdManager.getInstance().init(context, k0.t, new InitParams.Builder().setDebug(h.F().J0()).build(), new IInitListener() { // from class: ad.OppoAd.7
                AnonymousClass7() {
                }

                @Override // com.heytap.msp.mobad.api.listener.IInitListener
                public void onFailed(String s) {
                    MiConfigSingleton.x.this.onFailed(s);
                }

                @Override // com.heytap.msp.mobad.api.listener.IInitListener
                public void onSuccess() {
                    MiConfigSingleton.x.this.onSuccess();
                }
            });
        } catch (Exception unused) {
        }
    }

    public static boolean isOppoAd(AppTask appTask) {
        return appTask != null && (appTask.origin instanceof INativeAdvanceData);
    }

    public static void sendInterstitialLossNotification(int winPrice, @NonNull AppTask appTask) {
        ((InterstitialAd) appTask.origin).notifyRankLoss(1, AdnName.OTHER, winPrice);
    }

    public static void sendLossNotification(int winPrice, AppTask appTask, int reason) {
        ((INativeAdvanceData) appTask.origin).notifyRankLoss(reason, AdnName.OTHER, winPrice);
    }

    public static void sendSplashLossNotification(int winPrice, @NonNull AppTask appTask) {
        ((HotSplashAd) appTask.origin).notifyRankLoss(1, AdnName.OTHER, winPrice);
    }

    public static void sendVideoLossNotification(int winPrice, @NonNull AppTask appTask) {
        ((RewardVideoAd) appTask.origin).notifyRankLoss(1, AdnName.OTHER, winPrice);
    }

    public static void sendWinNotification(AppTask appTask) {
        INativeAdvanceData iNativeAdvanceData = (INativeAdvanceData) appTask.origin;
        iNativeAdvanceData.setBidECPM(iNativeAdvanceData.getECPM());
        iNativeAdvanceData.notifyRankWin(iNativeAdvanceData.getECPM() - 1);
    }

    public static boolean showInterstitialAd(@NonNull AppTask appTask) {
        InterstitialAd interstitialAd = (InterstitialAd) appTask.origin;
        if (appTask.isBidding()) {
            interstitialAd.setBidECPM(interstitialAd.getECPM());
            interstitialAd.notifyRankWin(interstitialAd.getECPM() - 1);
        }
        interstitialAd.showAd();
        return true;
    }

    public static void showSplashAd(Activity activity, @NonNull AppTask appTask) {
        HotSplashAd hotSplashAd = (HotSplashAd) appTask.origin;
        if (appTask.isBidding()) {
            hotSplashAd.setBidECPM(hotSplashAd.getECPM());
            hotSplashAd.notifyRankWin(hotSplashAd.getECPM() - 1);
        }
        hotSplashAd.showAd(activity);
    }

    public static boolean showVideoAd(@NonNull AppTask appTask) {
        RewardVideoAd rewardVideoAd = (RewardVideoAd) appTask.origin;
        if (appTask.isBidding()) {
            rewardVideoAd.setBidECPM(rewardVideoAd.getECPM());
            rewardVideoAd.notifyRankWin(rewardVideoAd.getECPM() - 1);
        }
        rewardVideoAd.showAd();
        return true;
    }

    public AppTask toAppTask(INativeAdvanceData nativeResponse) {
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = nativeResponse;
        appTask.title = h.F().n(nativeResponse.getTitle());
        appTask.desc = h.F().n(nativeResponse.getDesc());
        if (nativeResponse.getIconFiles() != null && !nativeResponse.getIconFiles().isEmpty()) {
            INativeAdFile iNativeAdFile = nativeResponse.getIconFiles().get(0);
            if (!k.p(iNativeAdFile.getUrl())) {
                appTask.iconUrl = iNativeAdFile.getUrl();
            }
        }
        List<INativeAdFile> imgFiles = nativeResponse.getImgFiles();
        if (imgFiles != null && !imgFiles.isEmpty()) {
            for (INativeAdFile iNativeAdFile2 : imgFiles) {
                if (appTask.getPosterUrls().size() > 0 && k.p(appTask.iconUrl)) {
                    appTask.iconUrl = iNativeAdFile2.getUrl();
                }
                appTask.addPosterUrl(iNativeAdFile2.getUrl());
            }
        }
        if (k.p(appTask.iconUrl)) {
            appTask.iconUrl = appTask.getPosterUrl();
        }
        if (nativeResponse.getECPM() > 0) {
            appTask.setEcpm(nativeResponse.getECPM());
            this.adConfig.setEcpm(nativeResponse.getECPM());
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
            case "splash":
                loadSplashAds(activity);
                break;
            case "interstitial":
                loadInterstitialAd(activity);
                break;
            case "reward_video":
                loadRewardVideoAd(activity);
                break;
            default:
                loadFlowAds(activity);
                break;
        }
    }

    protected void loadFlowAds(Activity activity) {
        new NativeAdvanceAd(activity, this.adConfig.getAdsId(), new INativeAdvanceLoadListener() { // from class: ad.OppoAd.4
            AnonymousClass4() {
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener
            public void onAdFailed(int i2, String s) {
                OppoAd.this.fallback(new c(i2, s));
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener
            public void onAdSuccess(List<INativeAdvanceData> list) {
                if (list == null || list.isEmpty()) {
                    OppoAd.this.fallback(null);
                } else {
                    OppoAd.this.getAppTaskList().addAppTask(OppoAd.this.toAppTask(list.get(0)));
                    OppoAd.this.onAdReceived();
                }
            }
        }).loadAd();
    }

    protected void loadInterstitialAd(Activity activity) {
        InterstitialAd interstitialAd = new InterstitialAd(activity, this.adConfig.getAdsId());
        this.mInterstitialAd = interstitialAd;
        interstitialAd.setAdListener(new IInterstitialAdListener() { // from class: ad.OppoAd.2
            AnonymousClass2() {
            }

            @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
            public void onAdClick() {
                OppoAd.this.onClick();
            }

            @Override // com.heytap.msp.mobad.api.listener.IInterstitialAdListener
            public void onAdClose() {
                OppoAd.this.onClose();
                if (OppoAd.this.mInterstitialAd != null) {
                    OppoAd.this.mInterstitialAd.destroyAd();
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
            public void onAdFailed(String s) {
                OppoAd.this.onError(new c(-1, s));
            }

            @Override // com.heytap.msp.mobad.api.listener.IInterstitialAdListener
            public void onAdReady() {
                if (OppoAd.this.mInterstitialAd == null) {
                    OppoAd.this.onError(new c(-1, ""));
                    return;
                }
                AppTask appTask = ((BaseAd) OppoAd.this).adConfig.toAppTask();
                appTask.origin = OppoAd.this.mInterstitialAd;
                int ecpm = OppoAd.this.mInterstitialAd.getECPM();
                if (((BaseAd) OppoAd.this).adConfig.isBidding() || ecpm > 0) {
                    appTask.setEcpm(ecpm);
                    ((BaseAd) OppoAd.this).adConfig.setEcpm(ecpm);
                }
                OppoAd.this.getAppTaskList().addAppTask(appTask);
                OppoAd.this.onAdReceived();
            }

            @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
            public void onAdShow() {
                OppoAd.this.onExpose();
            }

            @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
            public void onAdFailed(int i2, String s) {
                OppoAd.this.onError(new c(i2, s));
            }
        });
        this.mInterstitialAd.loadAd();
    }

    protected void loadRewardVideoAd(Activity activity) {
        this.mRewardVideoAd = new RewardVideoAd(activity, this.adConfig.getAdsId(), new IRewardVideoAdListener() { // from class: ad.OppoAd.3
            private boolean verify = false;

            AnonymousClass3() {
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
            public void onAdClick(long l) {
                OppoAd.this.onClick();
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
            public void onAdFailed(String s) {
                OppoAd.this.fallback(new c(-1, s));
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
            public void onAdSuccess() {
                if (OppoAd.this.mRewardVideoAd == null || !OppoAd.this.mRewardVideoAd.isReady()) {
                    if (OppoAd.this.mRewardVideoAd != null) {
                        OppoAd.this.mRewardVideoAd.destroyAd();
                    }
                    OppoAd.this.onError(new c(-1, ""));
                    return;
                }
                AppTask appTask = ((BaseAd) OppoAd.this).adConfig.toAppTask();
                appTask.origin = OppoAd.this.mRewardVideoAd;
                int ecpm = OppoAd.this.mRewardVideoAd.getECPM();
                if (((BaseAd) OppoAd.this).adConfig.isBidding() || ecpm > 0) {
                    appTask.setEcpm(ecpm);
                    ((BaseAd) OppoAd.this).adConfig.setEcpm(ecpm);
                }
                OppoAd.this.getAppTaskList().addAppTask(appTask);
                OppoAd.this.onAdReceived();
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
            public void onLandingPageClose() {
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
            public void onLandingPageOpen() {
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardListener
            public void onReward(Object... objects) {
                this.verify = true;
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
            public void onVideoPlayClose(long l) {
                OppoAd.this.onClose();
                OppoAd.this.onRewardVerify(this.verify);
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
            public void onVideoPlayComplete() {
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
            public void onVideoPlayError(String s) {
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
            public void onVideoPlayStart() {
                OppoAd.this.onExpose();
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
            public void onAdFailed(int i2, String s) {
                OppoAd.this.fallback(new c(i2, s));
            }
        });
        this.mRewardVideoAd.loadAd(new RewardVideoAdParams.Builder().setFetchTimeout(3000L).build());
    }

    protected void loadSplashAds(Activity activity) {
        try {
            this.hotSplashAd = new HotSplashAd(activity, this.adConfig.getAdsId(), new IHotSplashListener() { // from class: ad.OppoAd.1
                AnonymousClass1() {
                }

                @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
                public void onAdClick() {
                    OppoAd.this.onClick();
                }

                @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
                public void onAdDismissed() {
                    OppoAd.this.onDismiss();
                }

                @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
                public void onAdFailed(int i2, String s) {
                    OppoAd.this.onError(new c(i2, s));
                }

                @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
                public void onAdReady() {
                    int ecpm;
                    AppTask appTask = OppoAd.this.getAppTaskList().getApps().get(0);
                    if (appTask != null && ((((BaseAd) OppoAd.this).adConfig.isBidding() || OppoAd.this.hotSplashAd.getECPM() > 0) && (ecpm = OppoAd.this.hotSplashAd.getECPM()) > 0)) {
                        appTask.setEcpm(ecpm);
                        ((BaseAd) OppoAd.this).adConfig.setEcpm(ecpm);
                    }
                    OppoAd.this.onAdReceived();
                }

                @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
                public void onAdShow(String s) {
                    OppoAd.this.onExpose();
                }
            }, new SplashAdParams.Builder().setFetchTimeout(5000L).setShowPreLoadPage(false).build());
            AppTask appTask = this.adConfig.toAppTask();
            appTask.origin = this.hotSplashAd;
            getAppTaskList().addAppTask(appTask);
        } catch (Exception unused) {
            fallback(new c(-1, "出错"));
        }
    }

    public OppoAd(AdConfig config, @NonNull a receiver) {
        super(config, receiver);
        this.cancelLoading = false;
    }
}
