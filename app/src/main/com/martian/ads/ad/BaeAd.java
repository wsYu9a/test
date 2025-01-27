package com.martian.ads.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import b8.j;
import b8.k;
import ba.l;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashAdListener;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import com.baidu.mobads.sdk.api.XNativeView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.BaeAd;
import com.martian.ads.ad.GroMoreAd;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.ComplianceInfo;
import com.martian.libmars.common.ConfigSingleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import l9.p0;
import x8.c;

/* loaded from: classes3.dex */
public class BaeAd extends BaseAd {
    public static String BIDDING_FAIL_LOW_PRICE = "203";
    public RewardVideoAd mRewardVideoAd;

    /* renamed from: com.martian.ads.ad.BaeAd$1 */
    public class AnonymousClass1 implements SplashAdListener {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded() {
            if (BaeAd.this.adConfig.isBidding()) {
                AppTask appTask = BaeAd.this.getAppTaskList().getApps().get(0);
                BaeAd.this.setBiddingEcpm(appTask, ((SplashAd) appTask.origin).getECPMLevel());
            }
            BaeAd.this.onAdReceived();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            BaeAd.this.onError(new c(-1, str));
        }
    }

    /* renamed from: com.martian.ads.ad.BaeAd$2 */
    public class AnonymousClass2 implements SplashInteractionListener {
        final /* synthetic */ AdConfig val$adConfig;

        public AnonymousClass2(AdConfig adConfig) {
            adConfig = adConfig;
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheSuccess() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdClick() {
            d8.b bVar = d8.b.this;
            if (bVar != null) {
                bVar.l(adConfig);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdDismissed() {
            d8.b bVar = d8.b.this;
            if (bVar != null) {
                bVar.g(adConfig);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdExposed() {
            d8.b bVar = d8.b.this;
            if (bVar != null) {
                bVar.b(adConfig);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdPresent() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdSkip() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onLpClosed() {
            d8.b bVar = d8.b.this;
            if (bVar != null) {
                bVar.d(adConfig);
            }
        }
    }

    /* renamed from: com.martian.ads.ad.BaeAd$3 */
    public class AnonymousClass3 implements BaiduNativeManager.PortraitVideoAdListener {
        public AnonymousClass3() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.PortraitVideoAdListener
        public void onAdClick() {
            BaeAd.this.onClick();
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeFail(int i10, String str, NativeResponse nativeResponse) {
            BaeAd.this.onError(new c(i10, str));
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeLoad(List<NativeResponse> list) {
            if (list == null || list.isEmpty()) {
                BaeAd.this.onError(null);
            } else {
                BaeAd.this.getAppTaskList().addAppTask(BaeAd.this.toAppTask(list.get(0)));
                BaeAd.this.onAdReceived();
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNoAd(int i10, String str, NativeResponse nativeResponse) {
            BaeAd.this.onError(new c(i10, str));
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadSuccess() {
        }
    }

    /* renamed from: com.martian.ads.ad.BaeAd$4 */
    public class AnonymousClass4 implements BaiduNativeManager.FeedAdListener {
        public AnonymousClass4() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeFail(int i10, String str, NativeResponse nativeResponse) {
            BaeAd.this.onError(new c(i10, str));
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeLoad(List<NativeResponse> list) {
            if (list == null || list.isEmpty()) {
                BaeAd.this.onError(null);
                return;
            }
            for (NativeResponse nativeResponse : list) {
                if (nativeResponse != null) {
                    BaeAd.this.getAppTaskList().addAppTask(BaeAd.this.toAppTask(nativeResponse));
                }
            }
            BaeAd.this.onAdReceived();
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNoAd(int i10, String str, NativeResponse nativeResponse) {
            BaeAd.this.onError(new c(i10, str));
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadSuccess() {
        }
    }

    /* renamed from: com.martian.ads.ad.BaeAd$5 */
    public class AnonymousClass5 implements BaiduNativeManager.ExpressAdListener {

        /* renamed from: com.martian.ads.ad.BaeAd$5$1 */
        public class AnonymousClass1 implements ExpressResponse.ExpressInteractionListener {
            public AnonymousClass1() {
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdClick() {
                BaeAd baeAd = BaeAd.this;
                d8.a aVar = baeAd.receiver;
                if (aVar != null) {
                    aVar.l(baeAd.adConfig);
                }
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdExposed() {
                BaeAd baeAd = BaeAd.this;
                d8.a aVar = baeAd.receiver;
                if (aVar != null) {
                    aVar.b(baeAd.adConfig);
                }
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdRenderFail(View view, String str, int i10) {
                BaeAd baeAd = BaeAd.this;
                d8.a aVar = baeAd.receiver;
                if (aVar != null) {
                    aVar.c(baeAd.adConfig, new c(-1, ""));
                }
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdRenderSuccess(View view, float f10, float f11) {
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdUnionClick() {
            }
        }

        public AnonymousClass5() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onNativeFail(int i10, String str, ExpressResponse expressResponse) {
            BaeAd.this.onError(new c(i10, str));
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onNativeLoad(List<ExpressResponse> list) {
            if (list == null || list.isEmpty()) {
                BaeAd.this.onError(null);
                return;
            }
            ExpressResponse expressResponse = list.get(0);
            if (expressResponse == null) {
                BaeAd.this.onError(null);
                return;
            }
            expressResponse.setInteractionListener(new ExpressResponse.ExpressInteractionListener() { // from class: com.martian.ads.ad.BaeAd.5.1
                public AnonymousClass1() {
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdClick() {
                    BaeAd baeAd = BaeAd.this;
                    d8.a aVar = baeAd.receiver;
                    if (aVar != null) {
                        aVar.l(baeAd.adConfig);
                    }
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdExposed() {
                    BaeAd baeAd = BaeAd.this;
                    d8.a aVar = baeAd.receiver;
                    if (aVar != null) {
                        aVar.b(baeAd.adConfig);
                    }
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdRenderFail(View view, String str, int i10) {
                    BaeAd baeAd = BaeAd.this;
                    d8.a aVar = baeAd.receiver;
                    if (aVar != null) {
                        aVar.c(baeAd.adConfig, new c(-1, ""));
                    }
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdRenderSuccess(View view, float f10, float f11) {
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdUnionClick() {
                }
            });
            AppTask appTask = BaeAd.this.adConfig.toAppTask();
            appTask.customView = new k(expressResponse);
            appTask.setPicWidth(1184);
            appTask.setPicHeight(1898);
            if (BaeAd.this.adConfig.isBidding()) {
                BaeAd.this.setBiddingEcpm(appTask, expressResponse.getECPMLevel());
            }
            BaeAd.this.getAppTaskList().addAppTask(appTask);
            BaeAd.this.onAdReceived();
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onNoAd(int i10, String str, ExpressResponse expressResponse) {
            BaeAd.this.onError(new c(i10, str));
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onVideoDownloadSuccess() {
        }
    }

    /* renamed from: com.martian.ads.ad.BaeAd$6 */
    public class AnonymousClass6 implements RewardVideoAd.RewardVideoAdListener {
        private boolean verify = false;

        public AnonymousClass6() {
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdClick() {
            BaeAd.this.onClick();
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdClose(float f10) {
            BaeAd.this.onClose();
            BaeAd.this.onRewardVerify(this.verify);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdFailed(String str) {
            BaeAd.this.onError(new c(-1, str));
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdLoaded() {
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdShow() {
            BaeAd.this.onExpose();
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdSkip(float f10) {
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
        public void onRewardVerify(boolean z10) {
            this.verify = z10;
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
            BaeAd baeAd2 = BaeAd.this;
            appTask.origin = baeAd2.mRewardVideoAd;
            if (baeAd2.adConfig.isBidding()) {
                BaeAd baeAd3 = BaeAd.this;
                baeAd3.setBiddingEcpm(appTask, baeAd3.mRewardVideoAd.getECPMLevel());
            }
            BaeAd.this.getAppTaskList().addAppTask(appTask);
            BaeAd.this.onAdReceived();
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void playCompletion() {
        }
    }

    /* renamed from: com.martian.ads.ad.BaeAd$7 */
    public class AnonymousClass7 implements ExpressInterstitialListener {
        final /* synthetic */ ExpressInterstitialAd val$expressInterstitialAd;

        public AnonymousClass7(ExpressInterstitialAd expressInterstitialAd) {
            expressInterstitialAd = expressInterstitialAd;
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
            appTask.origin = expressInterstitialAd;
            if (BaeAd.this.adConfig.isBidding()) {
                BaeAd.this.setBiddingEcpm(appTask, expressInterstitialAd.getECPMLevel());
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
        public void onAdFailed(int i10, String str) {
            BaeAd.this.onError(new c(i10, str));
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onNoAd(int i10, String str) {
            BaeAd.this.onError(new c(i10, str));
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onVideoDownloadSuccess() {
        }
    }

    /* renamed from: com.martian.ads.ad.BaeAd$8 */
    public class AnonymousClass8 implements ExpressInterstitialAd.InterAdDownloadWindowListener {
        public AnonymousClass8() {
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

    /* renamed from: com.martian.ads.ad.BaeAd$9 */
    public class AnonymousClass9 implements NativeResponse.AdInteractionListener {
        final /* synthetic */ AdConfig val$adConfig;
        final /* synthetic */ NativeResponse val$nativeResponse;
        final /* synthetic */ GroMoreAd.AdViewHolder val$viewHolder;

        public AnonymousClass9(AdConfig adConfig, GroMoreAd.AdViewHolder adViewHolder, NativeResponse nativeResponse) {
            adConfig = adConfig;
            adViewHolder = adViewHolder;
            nativeResponse = nativeResponse;
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposed() {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.b(adConfig);
            }
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposureFailed(int i10) {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.j(new c(i10, "曝光失败"));
            }
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADStatusChanged() {
            GroMoreAd.AdViewHolder adViewHolder = adViewHolder;
            if (adViewHolder == null || adViewHolder.mCreativeButton == null || nativeResponse.getAdActionType() != 2) {
                return;
            }
            int downloadStatus = nativeResponse.getDownloadStatus();
            if (downloadStatus == 101) {
                adViewHolder.mCreativeButton.setText(ConfigSingleton.D().s("点击安装"));
                return;
            }
            if (downloadStatus == 102) {
                adViewHolder.mCreativeButton.setText(ConfigSingleton.D().s("继续下载"));
                return;
            }
            if (downloadStatus == 103) {
                adViewHolder.mCreativeButton.setText(ConfigSingleton.D().s("点击启动"));
            } else if (downloadStatus == 104) {
                adViewHolder.mCreativeButton.setText(ConfigSingleton.D().s("重新下载"));
            } else {
                adViewHolder.mCreativeButton.setText(ConfigSingleton.D().s("立即下载"));
            }
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdClick() {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.l(adConfig);
            }
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdUnionClick() {
        }
    }

    public BaeAd(AdConfig adConfig, @NonNull d8.a aVar, Handler handler) {
        super(adConfig, aVar, handler);
    }

    public static void bindFlowAd(Activity activity, AppTask appTask, ViewGroup viewGroup, View view, GroMoreAd.AdViewHolder adViewHolder, boolean z10, d8.a aVar) {
        View renderShakeView;
        NativeResponse nativeResponse = (NativeResponse) appTask.origin;
        if (appTask.isBidding()) {
            nativeResponse.biddingSuccess(getSecondInfo(appTask), new BiddingListener() { // from class: c8.d
                @Override // com.baidu.mobads.sdk.api.BiddingListener
                public final void onBiddingResult(boolean z11, String str, HashMap hashMap) {
                    BaeAd.lambda$bindFlowAd$8(z11, str, hashMap);
                }
            });
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (adViewHolder != null) {
            if (z10 || appTask.getComplianceInfo() == null || adViewHolder.complianceView == null) {
                Button button = adViewHolder.mCreativeButton;
                if (button != null) {
                    arrayList.add(button);
                }
                View view2 = adViewHolder.mCreativeButtonView;
                if (view2 != null) {
                    arrayList.add(view2);
                }
                arrayList.add(viewGroup);
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
                arrayList2.add(viewGroup);
                arrayList2.add(view);
            }
            if (nativeResponse.getMaterialType() == NativeResponse.MaterialType.VIDEO && activity != null && adViewHolder.videoView != null) {
                XNativeView xNativeView = new XNativeView(activity);
                xNativeView.setNativeItem(nativeResponse);
                xNativeView.setVideoMute(true);
                xNativeView.setUseDownloadFrame(z10);
                xNativeView.render();
                adViewHolder.videoView.setVisibility(0);
                adViewHolder.videoView.removeAllViews();
                adViewHolder.videoView.addView(xNativeView);
            }
        } else {
            arrayList.add(viewGroup);
            arrayList.add(view);
        }
        if (appTask.isShakeStyle() && adViewHolder != null && (renderShakeView = nativeResponse.renderShakeView(100, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK, new NativeResponse.AdShakeViewListener() { // from class: c8.e
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
            public final void onDismiss() {
                BaeAd.lambda$bindFlowAd$9();
            }
        })) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.height = ConfigSingleton.i(138.0f);
            layoutParams.gravity = 17;
            viewGroup.addView(renderShakeView, layoutParams);
        }
        nativeResponse.registerViewForInteraction(viewGroup, arrayList, arrayList2, new NativeResponse.AdInteractionListener() { // from class: com.martian.ads.ad.BaeAd.9
            final /* synthetic */ AdConfig val$adConfig;
            final /* synthetic */ NativeResponse val$nativeResponse;
            final /* synthetic */ GroMoreAd.AdViewHolder val$viewHolder;

            public AnonymousClass9(AdConfig adConfig, GroMoreAd.AdViewHolder adViewHolder2, NativeResponse nativeResponse2) {
                adConfig = adConfig;
                adViewHolder = adViewHolder2;
                nativeResponse = nativeResponse2;
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposed() {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.b(adConfig);
                }
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposureFailed(int i10) {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.j(new c(i10, "曝光失败"));
                }
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADStatusChanged() {
                GroMoreAd.AdViewHolder adViewHolder2 = adViewHolder;
                if (adViewHolder2 == null || adViewHolder2.mCreativeButton == null || nativeResponse.getAdActionType() != 2) {
                    return;
                }
                int downloadStatus = nativeResponse.getDownloadStatus();
                if (downloadStatus == 101) {
                    adViewHolder.mCreativeButton.setText(ConfigSingleton.D().s("点击安装"));
                    return;
                }
                if (downloadStatus == 102) {
                    adViewHolder.mCreativeButton.setText(ConfigSingleton.D().s("继续下载"));
                    return;
                }
                if (downloadStatus == 103) {
                    adViewHolder.mCreativeButton.setText(ConfigSingleton.D().s("点击启动"));
                } else if (downloadStatus == 104) {
                    adViewHolder.mCreativeButton.setText(ConfigSingleton.D().s("重新下载"));
                } else {
                    adViewHolder.mCreativeButton.setText(ConfigSingleton.D().s("立即下载"));
                }
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdClick() {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.l(adConfig);
                }
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdUnionClick() {
            }
        });
    }

    private static String getAdSource(String str) {
        str.hashCode();
        switch (str) {
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

    private static int getAdn(String str) {
        if (TextUtils.isEmpty(str)) {
            return 10;
        }
        str.hashCode();
        switch (str) {
        }
        return 10;
    }

    @NonNull
    private static ComplianceInfo getComplianceInfo(NativeResponse nativeResponse) {
        ComplianceInfo complianceInfo = new ComplianceInfo();
        complianceInfo.setAppName(nativeResponse.getBrandName());
        complianceInfo.setAppVersion(nativeResponse.getAppVersion());
        complianceInfo.setAppDeveloperName(nativeResponse.getPublisher());
        complianceInfo.setAppPermissionUrl(nativeResponse.getAppPermissionLink());
        complianceInfo.setAppPrivacyUrl(nativeResponse.getAppPrivacyLink());
        complianceInfo.setAppFunctionDescUrl(nativeResponse.getAppFunctionLink());
        return complianceInfo;
    }

    public static LinkedHashMap<String, Object> getSecondInfo(AppTask appTask) {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("ecpm", Integer.valueOf(appTask.getLoseEcpm()));
        linkedHashMap.put(SplashAd.KEY_BIDFAIL_ADN, Integer.valueOf(getAdn(appTask.getLoseSource())));
        linkedHashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
        linkedHashMap.put("bid_t", Integer.valueOf(appTask.getLoseIsBidding() ? 3 : 1));
        return linkedHashMap;
    }

    public static LinkedHashMap<String, Object> getWinInfo(int i10, String str) {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("ecpm", Integer.valueOf(i10));
        linkedHashMap.put(SplashAd.KEY_BIDFAIL_ADN, Integer.valueOf(getAdn(str)));
        linkedHashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
        return linkedHashMap;
    }

    public static boolean isBaeFlowAd(AppTask appTask) {
        return appTask != null && (appTask.origin instanceof NativeResponse);
    }

    public static boolean isBaeSplashAd(AppTask appTask) {
        return appTask.origin instanceof SplashAd;
    }

    public static /* synthetic */ void lambda$bindFlowAd$8(boolean z10, String str, HashMap hashMap) {
        Log.i("adtag", "onBiddingResult-win: " + z10 + " msg信息：" + str);
    }

    public static /* synthetic */ void lambda$bindFlowAd$9() {
    }

    public /* synthetic */ void lambda$loadInteractionAd$5() {
        onError(null);
    }

    public /* synthetic */ void lambda$loadVideoAd$2() {
        onError(null);
    }

    public static /* synthetic */ void lambda$sendInterstitialLossNotification$7(boolean z10, String str, HashMap hashMap) {
        Log.i("adtag", "onBiddingResult-lose: " + z10 + " msg信息：" + str);
    }

    public static /* synthetic */ void lambda$sendLossNotification$10(boolean z10, String str, HashMap hashMap) {
        Log.i("adtag", "onBiddingResult-lose: " + z10 + " msg信息：" + str);
    }

    public static /* synthetic */ void lambda$sendSplashLossNotification$1(boolean z10, String str, HashMap hashMap) {
        Log.i("adtag", "onBiddingResult-lose: " + z10 + " msg信息：" + str);
    }

    public static /* synthetic */ void lambda$sendVideoLossNotification$4(boolean z10, String str, HashMap hashMap) {
        Log.i("adtag", "onBiddingResult-lose: " + z10 + " msg信息：" + str);
    }

    public static /* synthetic */ void lambda$showInterstitialAd$6(boolean z10, String str, HashMap hashMap) {
        Log.i("adtag", "onBiddingResult-win: " + z10 + " msg信息：" + str);
    }

    public static /* synthetic */ void lambda$showSplashAd$0(boolean z10, String str, HashMap hashMap) {
        Log.i("adtag", "onBiddingResult-win: " + z10 + " msg信息：" + str);
    }

    public static /* synthetic */ void lambda$showVideoAd$3(boolean z10, String str, HashMap hashMap) {
        Log.i("adtag", "onBiddingResult-win: " + z10 + " msg信息：" + str);
    }

    private void loadInteractionAd(Context context) {
        if (Build.VERSION.SDK_INT <= 23) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.postDelayed(new Runnable() { // from class: c8.c
                    public /* synthetic */ c() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        BaeAd.this.lambda$loadInteractionAd$5();
                    }
                }, 100L);
                return;
            } else {
                onError(null);
                return;
            }
        }
        ExpressInterstitialAd expressInterstitialAd = new ExpressInterstitialAd(context, this.adConfig.getAdsId());
        if (!l.q(this.adConfig.getAppid())) {
            expressInterstitialAd.setAppSid(this.adConfig.getAppid());
        }
        expressInterstitialAd.setDialogFrame(true);
        expressInterstitialAd.setLoadListener(new ExpressInterstitialListener() { // from class: com.martian.ads.ad.BaeAd.7
            final /* synthetic */ ExpressInterstitialAd val$expressInterstitialAd;

            public AnonymousClass7(ExpressInterstitialAd expressInterstitialAd2) {
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
                appTask.origin = expressInterstitialAd;
                if (BaeAd.this.adConfig.isBidding()) {
                    BaeAd.this.setBiddingEcpm(appTask, expressInterstitialAd.getECPMLevel());
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
            public void onAdFailed(int i10, String str) {
                BaeAd.this.onError(new c(i10, str));
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onLpClosed() {
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onNoAd(int i10, String str) {
                BaeAd.this.onError(new c(i10, str));
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onVideoDownloadFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
            public void onVideoDownloadSuccess() {
            }
        });
        expressInterstitialAd2.setDownloadListener(new ExpressInterstitialAd.InterAdDownloadWindowListener() { // from class: com.martian.ads.ad.BaeAd.8
            public AnonymousClass8() {
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
            expressInterstitialAd2.setRequestParameters(new RequestParameters.Builder().addCustExt(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, getAdSource(adInfo.getSource())).addCustExt("B", "" + (adInfo.getEcpm() * 1.2d)).build());
        }
        expressInterstitialAd2.load();
    }

    private void loadPortraitTempFlowAds(Context context) {
        RequestParameters build;
        j baeArticleInfo = this.adConfig.getBaeArticleInfo();
        if (baeArticleInfo != null) {
            build = new RequestParameters.Builder().downloadAppConfirmPolicy(1).setWidth(this.adConfig.getWidth()).setHeight(this.adConfig.getHeight()).addExtra(ArticleInfo.USER_SEX, baeArticleInfo.f()).addExtra(ArticleInfo.FAVORITE_BOOK, baeArticleInfo.c()).addExtra(ArticleInfo.PAGE_TITLE, baeArticleInfo.e()).addExtra(ArticleInfo.PAGE_ID, baeArticleInfo.d()).addExtra(ArticleInfo.CONTENT_CATEGORY, baeArticleInfo.a()).addExtra(ArticleInfo.CONTENT_LABEL, baeArticleInfo.b()).build();
        } else {
            build = new RequestParameters.Builder().downloadAppConfirmPolicy(1).setWidth(this.adConfig.getWidth()).setHeight(this.adConfig.getHeight()).addExtra(ArticleInfo.USER_SEX, ConfigSingleton.D().p() + "").build();
        }
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(context, this.adConfig.getAdsId());
        if (!l.q(this.adConfig.getAppid())) {
            baiduNativeManager.setAppSid(this.adConfig.getAppid());
        }
        baiduNativeManager.setCacheVideoOnlyWifi(true);
        baiduNativeManager.loadPortraitVideoAd(build, (BaiduNativeManager.PortraitVideoAdListener) new BaiduNativeManager.PortraitVideoAdListener() { // from class: com.martian.ads.ad.BaeAd.3
            public AnonymousClass3() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.PortraitVideoAdListener
            public void onAdClick() {
                BaeAd.this.onClick();
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onLpClosed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeFail(int i10, String str, NativeResponse nativeResponse) {
                BaeAd.this.onError(new c(i10, str));
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeLoad(List<NativeResponse> list) {
                if (list == null || list.isEmpty()) {
                    BaeAd.this.onError(null);
                } else {
                    BaeAd.this.getAppTaskList().addAppTask(BaeAd.this.toAppTask(list.get(0)));
                    BaeAd.this.onAdReceived();
                }
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNoAd(int i10, String str, NativeResponse nativeResponse) {
                BaeAd.this.onError(new c(i10, str));
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadSuccess() {
            }
        });
    }

    private void loadSplashAds(Context context) {
        AnonymousClass1 anonymousClass1 = new SplashAdListener() { // from class: com.martian.ads.ad.BaeAd.1
            public AnonymousClass1() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onADLoaded() {
                if (BaeAd.this.adConfig.isBidding()) {
                    AppTask appTask = BaeAd.this.getAppTaskList().getApps().get(0);
                    BaeAd.this.setBiddingEcpm(appTask, ((SplashAd) appTask.origin).getECPMLevel());
                }
                BaeAd.this.onAdReceived();
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdFailed(String str) {
                BaeAd.this.onError(new c(-1, str));
            }
        };
        RequestParameters.Builder builder = new RequestParameters.Builder();
        builder.addExtra("timeout", "4000");
        builder.addExtra(SplashAd.KEY_DISPLAY_DOWNLOADINFO, "true");
        builder.addExtra(SplashAd.KEY_POPDIALOG_DOWNLOAD, "true");
        if (this.adConfig.getAdInfo() != null) {
            builder.addCustExt(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, getAdSource(this.adConfig.getAdInfo().getSource())).addCustExt("B", "" + (r2.getEcpm() * 1.2d));
        }
        SplashAd splashAd = new SplashAd(context, this.adConfig.getAdsId(), builder.build(), anonymousClass1);
        if (!l.q(this.adConfig.getAppid())) {
            splashAd.setAppSid(this.adConfig.getAppid());
        }
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = splashAd;
        appTask.setPicWidth(720);
        appTask.setPicHeight(1280);
        getAppTaskList().addAppTask(appTask);
        splashAd.load();
    }

    private void loadTempFlowAds(Context context) {
        RequestParameters build;
        j baeArticleInfo = this.adConfig.getBaeArticleInfo();
        if (baeArticleInfo != null) {
            build = new RequestParameters.Builder().downloadAppConfirmPolicy(1).setWidth(this.adConfig.getWidth()).setHeight(this.adConfig.getHeight()).addExtra(ArticleInfo.USER_SEX, baeArticleInfo.f()).addExtra(ArticleInfo.FAVORITE_BOOK, baeArticleInfo.c()).addExtra(ArticleInfo.PAGE_TITLE, baeArticleInfo.e()).addExtra(ArticleInfo.PAGE_ID, baeArticleInfo.d()).addExtra(ArticleInfo.CONTENT_CATEGORY, baeArticleInfo.a()).addExtra(ArticleInfo.CONTENT_LABEL, baeArticleInfo.b()).build();
        } else {
            build = new RequestParameters.Builder().downloadAppConfirmPolicy(1).setWidth(this.adConfig.getWidth()).setHeight(this.adConfig.getHeight()).addExtra(ArticleInfo.USER_SEX, ConfigSingleton.D().p() + "").build();
        }
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(context, this.adConfig.getAdsId());
        if (!l.q(this.adConfig.getAppid())) {
            baiduNativeManager.setAppSid(this.adConfig.getAppid());
        }
        baiduNativeManager.setCacheVideoOnlyWifi(true);
        baiduNativeManager.loadExpressAd(build, new BaiduNativeManager.ExpressAdListener() { // from class: com.martian.ads.ad.BaeAd.5

            /* renamed from: com.martian.ads.ad.BaeAd$5$1 */
            public class AnonymousClass1 implements ExpressResponse.ExpressInteractionListener {
                public AnonymousClass1() {
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdClick() {
                    BaeAd baeAd = BaeAd.this;
                    d8.a aVar = baeAd.receiver;
                    if (aVar != null) {
                        aVar.l(baeAd.adConfig);
                    }
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdExposed() {
                    BaeAd baeAd = BaeAd.this;
                    d8.a aVar = baeAd.receiver;
                    if (aVar != null) {
                        aVar.b(baeAd.adConfig);
                    }
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdRenderFail(View view, String str, int i10) {
                    BaeAd baeAd = BaeAd.this;
                    d8.a aVar = baeAd.receiver;
                    if (aVar != null) {
                        aVar.c(baeAd.adConfig, new c(-1, ""));
                    }
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdRenderSuccess(View view, float f10, float f11) {
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdUnionClick() {
                }
            }

            public AnonymousClass5() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onLpClosed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onNativeFail(int i10, String str, ExpressResponse expressResponse) {
                BaeAd.this.onError(new c(i10, str));
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onNativeLoad(List<ExpressResponse> list) {
                if (list == null || list.isEmpty()) {
                    BaeAd.this.onError(null);
                    return;
                }
                ExpressResponse expressResponse = list.get(0);
                if (expressResponse == null) {
                    BaeAd.this.onError(null);
                    return;
                }
                expressResponse.setInteractionListener(new ExpressResponse.ExpressInteractionListener() { // from class: com.martian.ads.ad.BaeAd.5.1
                    public AnonymousClass1() {
                    }

                    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                    public void onAdClick() {
                        BaeAd baeAd = BaeAd.this;
                        d8.a aVar = baeAd.receiver;
                        if (aVar != null) {
                            aVar.l(baeAd.adConfig);
                        }
                    }

                    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                    public void onAdExposed() {
                        BaeAd baeAd = BaeAd.this;
                        d8.a aVar = baeAd.receiver;
                        if (aVar != null) {
                            aVar.b(baeAd.adConfig);
                        }
                    }

                    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                    public void onAdRenderFail(View view, String str, int i10) {
                        BaeAd baeAd = BaeAd.this;
                        d8.a aVar = baeAd.receiver;
                        if (aVar != null) {
                            aVar.c(baeAd.adConfig, new c(-1, ""));
                        }
                    }

                    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                    public void onAdRenderSuccess(View view, float f10, float f11) {
                    }

                    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                    public void onAdUnionClick() {
                    }
                });
                AppTask appTask = BaeAd.this.adConfig.toAppTask();
                appTask.customView = new k(expressResponse);
                appTask.setPicWidth(1184);
                appTask.setPicHeight(1898);
                if (BaeAd.this.adConfig.isBidding()) {
                    BaeAd.this.setBiddingEcpm(appTask, expressResponse.getECPMLevel());
                }
                BaeAd.this.getAppTaskList().addAppTask(appTask);
                BaeAd.this.onAdReceived();
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onNoAd(int i10, String str, ExpressResponse expressResponse) {
                BaeAd.this.onError(new c(i10, str));
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onVideoDownloadFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onVideoDownloadSuccess() {
            }
        });
    }

    private void loadVideoAd(Context context) {
        if (Build.VERSION.SDK_INT <= 23) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.postDelayed(new Runnable() { // from class: c8.g
                    public /* synthetic */ g() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        BaeAd.this.lambda$loadVideoAd$2();
                    }
                }, 100L);
                return;
            } else {
                onError(null);
                return;
            }
        }
        this.mRewardVideoAd = new RewardVideoAd(context, this.adConfig.getAdsId(), new RewardVideoAd.RewardVideoAdListener() { // from class: com.martian.ads.ad.BaeAd.6
            private boolean verify = false;

            public AnonymousClass6() {
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdClick() {
                BaeAd.this.onClick();
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdClose(float f10) {
                BaeAd.this.onClose();
                BaeAd.this.onRewardVerify(this.verify);
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdFailed(String str) {
                BaeAd.this.onError(new c(-1, str));
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdLoaded() {
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdShow() {
                BaeAd.this.onExpose();
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdSkip(float f10) {
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
            public void onRewardVerify(boolean z10) {
                this.verify = z10;
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
                BaeAd baeAd2 = BaeAd.this;
                appTask.origin = baeAd2.mRewardVideoAd;
                if (baeAd2.adConfig.isBidding()) {
                    BaeAd baeAd3 = BaeAd.this;
                    baeAd3.setBiddingEcpm(appTask, baeAd3.mRewardVideoAd.getECPMLevel());
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
            this.mRewardVideoAd.setRequestParameters(new RequestParameters.Builder().addCustExt(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, getAdSource(adInfo.getSource())).addCustExt("B", "" + (adInfo.getEcpm() * 1.2d)).build());
        }
        if (!l.q(this.adConfig.getAppid())) {
            this.mRewardVideoAd.setAppSid(this.adConfig.getAppid());
        }
        this.mRewardVideoAd.load();
    }

    public static void sendInterstitialLossNotification(int i10, String str, @NonNull ExpressInterstitialAd expressInterstitialAd) {
        expressInterstitialAd.biddingFail(getWinInfo(i10, str), new BiddingListener() { // from class: c8.j
            @Override // com.baidu.mobads.sdk.api.BiddingListener
            public final void onBiddingResult(boolean z10, String str2, HashMap hashMap) {
                BaeAd.lambda$sendInterstitialLossNotification$7(z10, str2, hashMap);
            }
        });
    }

    public static void sendLossNotification(int i10, String str, @NonNull NativeResponse nativeResponse, String str2) {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("ecpm", Integer.valueOf(i10));
        linkedHashMap.put(SplashAd.KEY_BIDFAIL_ADN, Integer.valueOf(getAdn(str)));
        linkedHashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
        linkedHashMap.put(MediationConstant.KEY_REASON, str2);
        nativeResponse.biddingFail(linkedHashMap, new BiddingListener() { // from class: c8.b
            @Override // com.baidu.mobads.sdk.api.BiddingListener
            public final void onBiddingResult(boolean z10, String str3, HashMap hashMap) {
                BaeAd.lambda$sendLossNotification$10(z10, str3, hashMap);
            }
        });
    }

    public static void sendSplashLossNotification(int i10, String str, @NonNull SplashAd splashAd) {
        splashAd.biddingFail(getWinInfo(i10, str), new BiddingListener() { // from class: c8.k
            @Override // com.baidu.mobads.sdk.api.BiddingListener
            public final void onBiddingResult(boolean z10, String str2, HashMap hashMap) {
                BaeAd.lambda$sendSplashLossNotification$1(z10, str2, hashMap);
            }
        });
    }

    public static void sendVideoLossNotification(int i10, String str, @NonNull RewardVideoAd rewardVideoAd) {
        rewardVideoAd.biddingFail(getWinInfo(i10, str), new BiddingListener() { // from class: c8.i
            @Override // com.baidu.mobads.sdk.api.BiddingListener
            public final void onBiddingResult(boolean z10, String str2, HashMap hashMap) {
                BaeAd.lambda$sendVideoLossNotification$4(z10, str2, hashMap);
            }
        });
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

    public static void showInterstitialAd(Activity activity, @NonNull AppTask appTask) {
        ExpressInterstitialAd expressInterstitialAd = (ExpressInterstitialAd) appTask.origin;
        if (appTask.isBidding()) {
            expressInterstitialAd.biddingSuccess(getSecondInfo(appTask), new BiddingListener() { // from class: c8.h
                @Override // com.baidu.mobads.sdk.api.BiddingListener
                public final void onBiddingResult(boolean z10, String str, HashMap hashMap) {
                    BaeAd.lambda$showInterstitialAd$6(z10, str, hashMap);
                }
            });
        }
        if (expressInterstitialAd.isReady()) {
            expressInterstitialAd.show(activity);
        }
    }

    public static void showSplashAd(AppTask appTask, ViewGroup viewGroup, d8.b bVar) {
        SplashAd splashAd = (SplashAd) appTask.origin;
        AdConfig adConfig = AdConfig.toAdConfig(appTask);
        if (appTask.isBidding()) {
            splashAd.biddingSuccess(getSecondInfo(appTask), new BiddingListener() { // from class: c8.a
                @Override // com.baidu.mobads.sdk.api.BiddingListener
                public final void onBiddingResult(boolean z10, String str, HashMap hashMap) {
                    BaeAd.lambda$showSplashAd$0(z10, str, hashMap);
                }
            });
        }
        splashAd.setListener(new SplashInteractionListener() { // from class: com.martian.ads.ad.BaeAd.2
            final /* synthetic */ AdConfig val$adConfig;

            public AnonymousClass2(AdConfig adConfig2) {
                adConfig = adConfig2;
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onADLoaded() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheSuccess() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdClick() {
                d8.b bVar2 = d8.b.this;
                if (bVar2 != null) {
                    bVar2.l(adConfig);
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdDismissed() {
                d8.b bVar2 = d8.b.this;
                if (bVar2 != null) {
                    bVar2.g(adConfig);
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdExposed() {
                d8.b bVar2 = d8.b.this;
                if (bVar2 != null) {
                    bVar2.b(adConfig);
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdFailed(String str) {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdPresent() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdSkip() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onLpClosed() {
                d8.b bVar2 = d8.b.this;
                if (bVar2 != null) {
                    bVar2.d(adConfig);
                }
            }
        });
        splashAd.show(viewGroup);
    }

    public static void showVideoAd(AppTask appTask) {
        RewardVideoAd rewardVideoAd = (RewardVideoAd) appTask.origin;
        if (appTask.isBidding()) {
            rewardVideoAd.biddingSuccess(getSecondInfo(appTask), new BiddingListener() { // from class: c8.f
                @Override // com.baidu.mobads.sdk.api.BiddingListener
                public final void onBiddingResult(boolean z10, String str, HashMap hashMap) {
                    BaeAd.lambda$showVideoAd$3(z10, str, hashMap);
                }
            });
        }
        rewardVideoAd.show();
    }

    public AppTask toAppTask(NativeResponse nativeResponse) {
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = nativeResponse;
        appTask.title = ConfigSingleton.D().s(nativeResponse.getTitle());
        appTask.desc = ConfigSingleton.D().s(nativeResponse.getDesc());
        if (!l.q(nativeResponse.getIconUrl())) {
            appTask.iconUrl = nativeResponse.getIconUrl();
        }
        if (!l.q(nativeResponse.getMarketingPendant())) {
            appTask.marketUrl = nativeResponse.getMarketingPendant();
        }
        appTask.appPromote = ConfigSingleton.D().s("赞助正版章节");
        if (this.adConfig.isBidding()) {
            setBiddingEcpm(appTask, nativeResponse.getECPMLevel());
        }
        List<String> multiPicUrls = nativeResponse.getMultiPicUrls();
        if (multiPicUrls != null && !multiPicUrls.isEmpty()) {
            for (String str : multiPicUrls) {
                if (!appTask.getPosterUrls().isEmpty() && l.q(appTask.iconUrl)) {
                    appTask.iconUrl = str;
                }
                appTask.addPosterUrl(str);
            }
        } else if (l.q(nativeResponse.getImageUrl())) {
            appTask.addPosterUrl(nativeResponse.getIconUrl());
        } else {
            appTask.addPosterUrl(nativeResponse.getImageUrl());
        }
        if (l.q(appTask.iconUrl)) {
            appTask.iconUrl = appTask.getPosterUrl();
        }
        if (nativeResponse.getAdActionType() == 2) {
            int downloadStatus = nativeResponse.getDownloadStatus();
            if (downloadStatus == 101) {
                appTask.buttonText = "点击安装";
            } else if (downloadStatus == 103) {
                appTask.buttonText = "点击启动";
            } else {
                if (downloadStatus == 102) {
                    appTask.buttonText = "继续下载";
                } else if (downloadStatus == 104) {
                    appTask.buttonText = "重新下载";
                } else {
                    appTask.buttonText = "立即下载";
                }
                if (!l.q(nativeResponse.getBrandName()) && !l.q(nativeResponse.getPublisher()) && !l.q(nativeResponse.getAppPrivacyLink())) {
                    appTask.setComplianceInfo(getComplianceInfo(nativeResponse));
                }
            }
        } else if (!l.q(nativeResponse.getActButtonString())) {
            appTask.buttonText = ConfigSingleton.D().s(nativeResponse.getActButtonString());
        }
        appTask.packageName = nativeResponse.getAppPackage();
        appTask.name = nativeResponse.getBrandName();
        appTask.setPicWidth(nativeResponse.getMainPicWidth());
        appTask.setPicHeight(nativeResponse.getMainPicHeight());
        this.adConfig.setAdNameInfo(appTask.getAdNameInfo());
        return appTask;
    }

    @Override // com.martian.ads.ad.BaseAd
    public void loadAds(Context context) {
        onAdRequest();
        String type = this.adConfig.getType();
        type.hashCode();
        switch (type) {
            case "express":
                loadPortraitTempFlowAds(context);
                break;
            case "native":
                loadFlowAds(context);
                break;
            case "splash":
                loadSplashAds(context);
                break;
            case "draw":
                loadTempFlowAds(context);
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
        RequestParameters build;
        j baeArticleInfo = this.adConfig.getBaeArticleInfo();
        if (baeArticleInfo != null) {
            AdConfig.AdInfo adInfo = this.adConfig.getAdInfo();
            if (adInfo == null) {
                build = new RequestParameters.Builder().downloadAppConfirmPolicy(1).addExtra(ArticleInfo.USER_SEX, baeArticleInfo.f()).addExtra(ArticleInfo.FAVORITE_BOOK, baeArticleInfo.c()).addExtra(ArticleInfo.PAGE_TITLE, baeArticleInfo.e()).addExtra(ArticleInfo.PAGE_ID, baeArticleInfo.d()).addExtra(ArticleInfo.CONTENT_CATEGORY, baeArticleInfo.a()).addExtra(ArticleInfo.CONTENT_LABEL, baeArticleInfo.b()).build();
            } else {
                build = new RequestParameters.Builder().downloadAppConfirmPolicy(1).addExtra(ArticleInfo.USER_SEX, baeArticleInfo.f()).addExtra(ArticleInfo.FAVORITE_BOOK, baeArticleInfo.c()).addExtra(ArticleInfo.PAGE_TITLE, baeArticleInfo.e()).addExtra(ArticleInfo.PAGE_ID, baeArticleInfo.d()).addCustExt(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, getAdSource(adInfo.getSource())).addCustExt("B", "" + (adInfo.getEcpm() * 1.2d)).addExtra(ArticleInfo.CONTENT_CATEGORY, baeArticleInfo.a()).addExtra(ArticleInfo.CONTENT_LABEL, baeArticleInfo.b()).build();
            }
        } else {
            build = new RequestParameters.Builder().downloadAppConfirmPolicy(1).addExtra(ArticleInfo.USER_SEX, ConfigSingleton.D().p() + "").build();
        }
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(context, this.adConfig.getAdsId());
        if (!l.q(this.adConfig.getAppid())) {
            baiduNativeManager.setAppSid(this.adConfig.getAppid());
        }
        baiduNativeManager.setCacheVideoOnlyWifi(true);
        baiduNativeManager.loadFeedAd(build, new BaiduNativeManager.FeedAdListener() { // from class: com.martian.ads.ad.BaeAd.4
            public AnonymousClass4() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onLpClosed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeFail(int i10, String str, NativeResponse nativeResponse) {
                BaeAd.this.onError(new c(i10, str));
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeLoad(List<NativeResponse> list) {
                if (list == null || list.isEmpty()) {
                    BaeAd.this.onError(null);
                    return;
                }
                for (NativeResponse nativeResponse : list) {
                    if (nativeResponse != null) {
                        BaeAd.this.getAppTaskList().addAppTask(BaeAd.this.toAppTask(nativeResponse));
                    }
                }
                BaeAd.this.onAdReceived();
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNoAd(int i10, String str, NativeResponse nativeResponse) {
                BaeAd.this.onError(new c(i10, str));
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
