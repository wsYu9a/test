package com.martian.ads.ad;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import b.d.a.g;
import b.d.a.h;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.ViewWrapper;
import com.martian.libmars.utils.n0;
import com.martian.libsupport.k;
import com.martian.libsupport.l;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class TTAd extends BaseAd {
    private boolean cancelLoading;
    private boolean mHasShowDownloadActive;
    private TTNativeExpressAd mTTAd;

    /* renamed from: com.martian.ads.ad.TTAd$1 */
    class AnonymousClass1 implements TTAdNative.CSJSplashAdListener {

        /* renamed from: com.martian.ads.ad.TTAd$1$1 */
        class C02551 implements CSJSplashAd.SplashAdListener {
            C02551() {
            }

            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdClick(CSJSplashAd csjSplashAd) {
                TTAd.this.onClick();
            }

            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdClose(CSJSplashAd csjSplashAd, int i2) {
                TTAd.this.onClose();
            }

            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdShow(CSJSplashAd csjSplashAd) {
                TTAd.this.onExpose();
            }
        }

        AnonymousClass1() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashLoadFail(CSJAdError csjAdError) {
            TTAd.this.fallback(new b.d.c.b.c(csjAdError.getCode(), csjAdError.getMsg()));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashLoadSuccess() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashRenderFail(CSJSplashAd csjSplashAd, CSJAdError csjAdError) {
            TTAd.this.fallback(new b.d.c.b.c(csjAdError.getCode(), csjAdError.getMsg()));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashRenderSuccess(CSJSplashAd csjSplashAd) {
            if (csjSplashAd == null) {
                TTAd.this.fallback(null);
                return;
            }
            csjSplashAd.setSplashAdListener(new CSJSplashAd.SplashAdListener() { // from class: com.martian.ads.ad.TTAd.1.1
                C02551() {
                }

                @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                public void onSplashAdClick(CSJSplashAd csjSplashAd2) {
                    TTAd.this.onClick();
                }

                @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                public void onSplashAdClose(CSJSplashAd csjSplashAd2, int i2) {
                    TTAd.this.onClose();
                }

                @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                public void onSplashAdShow(CSJSplashAd csjSplashAd2) {
                    TTAd.this.onExpose();
                }
            });
            AppTask appTask = TTAd.this.adConfig.toAppTask();
            appTask.origin = csjSplashAd;
            TTAd.this.getAppTaskList().addAppTask(appTask);
            TTAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$10 */
    class AnonymousClass10 implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
        boolean verify = false;

        AnonymousClass10() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdClose() {
            TTAd.this.onClose();
            TTAd.this.onDismiss();
            TTAd.this.onRewardVerify(true);
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdShow() {
            TTAd.this.onExpose();
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdVideoBarClick() {
            TTAd.this.onClick();
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onSkippedVideo() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoComplete() {
            this.verify = true;
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$11 */
    class AnonymousClass11 implements TTAppDownloadListener {
        AnonymousClass11() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long totalBytes, long currBytes, String fileName, String appName) {
            if (TTAd.this.mHasShowDownloadActive) {
                return;
            }
            TTAd.this.mHasShowDownloadActive = true;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long totalBytes, long currBytes, String fileName, String appName) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long totalBytes, String fileName, String appName) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long totalBytes, long currBytes, String fileName, String appName) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
            TTAd.this.mHasShowDownloadActive = false;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String fileName, String appName) {
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$12 */
    class AnonymousClass12 implements TTAdNative.NativeExpressAdListener {
        final /* synthetic */ Activity val$activity;

        AnonymousClass12(final Activity val$activity) {
            activity = val$activity;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int code, String message) {
            TTAd.this.onError(new b.d.c.b.c(code, message));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            if (list == null || list.isEmpty()) {
                TTAd.this.onError(null);
                return;
            }
            TTAd.this.mTTAd = list.get(0);
            TTAd tTAd = TTAd.this;
            tTAd.bindAdListener(activity, tTAd.mTTAd);
            AppTask appTask = TTAd.this.adConfig.toAppTask();
            appTask.origin = TTAd.this.mTTAd;
            TTAd.this.getAppTaskList().addAppTask(appTask);
            TTAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$13 */
    class AnonymousClass13 implements TTNativeExpressAd.AdInteractionListener {
        final /* synthetic */ Activity val$activity;

        AnonymousClass13(final Activity val$activity) {
            activity = val$activity;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int type) {
            TTAd.this.onClick();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
        public void onAdDismiss() {
            TTAd.this.onDismiss();
            TTAd.this.onRewardVerify(true);
            if (TTAd.this.mTTAd != null) {
                TTAd.this.mTTAd.destroy();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int type) {
            TTAd.this.onExpose();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String msg, int code) {
            TTAd.this.onError(new b.d.c.b.c(code, msg));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float width, float height) {
            if (n0.B(activity)) {
                TTAd.this.mTTAd.showInteractionExpressAd(activity);
            }
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$14 */
    class AnonymousClass14 implements TTAppDownloadListener {
        AnonymousClass14() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long totalBytes, long currBytes, String fileName, String appName) {
            if (TTAd.this.mHasShowDownloadActive) {
                return;
            }
            TTAd.this.mHasShowDownloadActive = true;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long totalBytes, long currBytes, String fileName, String appName) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long totalBytes, String fileName, String appName) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long totalBytes, long currBytes, String fileName, String appName) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String fileName, String appName) {
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$15 */
    static class AnonymousClass15 implements TTNativeAd.AdInteractionListener {
        final /* synthetic */ AppTask val$appTask;

        AnonymousClass15(final AppTask val$innerListener) {
            appTask = val$innerListener;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd ad2) {
            b.d.a.k.a.this.j(b.d.a.j.b.Q(appTask));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd ad2) {
            b.d.a.k.a.this.j(b.d.a.j.b.Q(appTask));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd ad2) {
            b.d.a.j.b.J(appTask, b.d.a.k.a.this);
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$16 */
    static class AnonymousClass16 implements TTAppDownloadListener {
        boolean isDownload = false;

        AnonymousClass16() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long totalBytes, long currBytes, String fileName, String appName) {
            if (this.isDownload) {
                return;
            }
            this.isDownload = true;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long totalBytes, long currBytes, String fileName, String appName) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long totalBytes, String fileName, String appName) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long totalBytes, long currBytes, String fileName, String appName) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String fileName, String appName) {
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$17 */
    static class AnonymousClass17 implements TTNativeExpressAd.ExpressAdInteractionListener {
        final /* synthetic */ AppTask val$appTask;

        AnonymousClass17(final AppTask val$innerListener) {
            appTask = val$innerListener;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int type) {
            b.d.a.k.a.this.j(b.d.a.j.b.Q(appTask));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int type) {
            b.d.a.j.b.J(appTask, b.d.a.k.a.this);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String msg, int code) {
            b.d.a.k.a.this.g(b.d.a.j.b.Q(appTask), new b.d.c.b.c(-1, ""));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float width, float height) {
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$18 */
    static class AnonymousClass18 implements TTAdDislike.DislikeInteractionCallback {
        final /* synthetic */ AppTask val$appTask;

        AnonymousClass18(final AppTask val$innerListener) {
            appTask = val$innerListener;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onCancel() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onSelected(int position, String value, boolean b2) {
            b.d.a.k.a.this.b(b.d.a.j.b.Q(appTask));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onShow() {
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$19 */
    static class AnonymousClass19 implements TTAppDownloadListener {
        AnonymousClass19() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long totalBytes, long currBytes, String fileName, String appName) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long totalBytes, long currBytes, String fileName, String appName) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long totalBytes, String fileName, String appName) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long totalBytes, long currBytes, String fileName, String appName) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String fileName, String appName) {
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$2 */
    class AnonymousClass2 implements TTAdNative.FeedAdListener {
        AnonymousClass2() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int code, String message) {
            TTAd.this.fallback(new b.d.c.b.c(code, "" + code));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
        public void onFeedAdLoad(List<TTFeedAd> ads) {
            if (ads == null || ads.isEmpty()) {
                TTAd.this.fallback(null);
                return;
            }
            Iterator<TTFeedAd> it = ads.iterator();
            while (it.hasNext()) {
                TTAd.this.getAppTaskList().addAppTask(TTAd.this.toAppTask(it.next()));
            }
            TTAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$3 */
    class AnonymousClass3 implements TTAdNative.NativeExpressAdListener {
        AnonymousClass3() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int code, String message) {
            TTAd.this.fallback(new b.d.c.b.c(code, "" + code));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> ads) {
            if (ads == null || ads.isEmpty()) {
                TTAd.this.fallback(null);
                return;
            }
            for (TTNativeExpressAd tTNativeExpressAd : ads) {
                AppTask appTask = TTAd.this.adConfig.toAppTask();
                appTask.origin = tTNativeExpressAd;
                appTask.isVideoAd = true;
                appTask.customView = new h(tTNativeExpressAd);
                TTAd.this.getAppTaskList().addAppTask(appTask);
            }
            TTAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$4 */
    class AnonymousClass4 implements TTAdNative.NativeAdListener {
        AnonymousClass4() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int code, String message) {
            TTAd.this.fallback(new b.d.c.b.c(code, message));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
        public void onNativeAdLoad(List<TTNativeAd> ads) {
            if (ads == null || ads.get(0) == null) {
                TTAd.this.fallback(null);
                return;
            }
            Iterator<TTNativeAd> it = ads.iterator();
            while (it.hasNext()) {
                TTAd.this.getAppTaskList().addAppTask(TTAd.this.toAppTask(it.next()));
            }
            TTAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$5 */
    static class AnonymousClass5 implements TTNativeAd.AdInteractionListener {
        final /* synthetic */ AppTask val$appTask;

        AnonymousClass5(final AppTask val$innerListener) {
            appTask = val$innerListener;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd ad2) {
            b.d.a.k.a.this.j(b.d.a.j.b.Q(appTask));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd ad2) {
            b.d.a.k.a.this.j(b.d.a.j.b.Q(appTask));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd ad2) {
            b.d.a.j.b.J(appTask, b.d.a.k.a.this);
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$6 */
    static class AnonymousClass6 implements TTAppDownloadListener {
        boolean isDownload = false;

        AnonymousClass6() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long totalBytes, long currBytes, String fileName, String appName) {
            if (this.isDownload) {
                return;
            }
            this.isDownload = true;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long totalBytes, long currBytes, String fileName, String appName) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long totalBytes, String fileName, String appName) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long totalBytes, long currBytes, String fileName, String appName) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String fileName, String appName) {
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$7 */
    class AnonymousClass7 implements TTAdNative.NativeExpressAdListener {
        AnonymousClass7() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int code, String message) {
            TTAd.this.fallback(new b.d.c.b.c(code, message));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> ads) {
            if (ads == null || ads.isEmpty()) {
                TTAd.this.fallback(null);
                return;
            }
            for (TTNativeExpressAd tTNativeExpressAd : ads) {
                AppTask appTask = TTAd.this.adConfig.toAppTask();
                appTask.origin = tTNativeExpressAd;
                appTask.customView = new h(tTNativeExpressAd);
                TTAd.this.getAppTaskList().addAppTask(appTask);
            }
            TTAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$8 */
    class AnonymousClass8 implements TTAdNative.RewardVideoAdListener {

        /* renamed from: com.martian.ads.ad.TTAd$8$1 */
        class AnonymousClass1 implements TTRewardVideoAd.RewardAdInteractionListener {
            private boolean verify = false;

            AnonymousClass1() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdClose() {
                TTAd.this.onClose();
                TTAd.this.onRewardVerify(this.verify);
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdShow() {
                TTAd.this.onExpose();
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdVideoBarClick() {
                TTAd.this.onClick();
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onRewardArrived(boolean b2, int i2, Bundle bundle) {
                this.verify = b2;
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify(boolean rewardVerify, int rewardAmount, String rewardName, int errorCode, String errorMsg) {
                this.verify = rewardVerify;
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onSkippedVideo() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onVideoComplete() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onVideoError() {
                TTAd.this.fallback(new b.d.c.b.c(-1, AdConfig.ActionString.FAIL));
            }
        }

        /* renamed from: com.martian.ads.ad.TTAd$8$2 */
        class AnonymousClass2 implements TTAppDownloadListener {
            AnonymousClass2() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long totalBytes, long currBytes, String fileName, String appName) {
                if (TTAd.this.mHasShowDownloadActive) {
                    return;
                }
                TTAd.this.mHasShowDownloadActive = true;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long totalBytes, long currBytes, String fileName, String appName) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long totalBytes, String fileName, String appName) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long totalBytes, long currBytes, String fileName, String appName) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                TTAd.this.mHasShowDownloadActive = false;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String fileName, String appName) {
            }
        }

        AnonymousClass8() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int code, String message) {
            TTAd.this.fallback(new b.d.c.b.c(code, message));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd ad2) {
            if (ad2 == null) {
                TTAd.this.fallback(null);
                return;
            }
            ad2.setRewardAdInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.martian.ads.ad.TTAd.8.1
                private boolean verify = false;

                AnonymousClass1() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onAdClose() {
                    TTAd.this.onClose();
                    TTAd.this.onRewardVerify(this.verify);
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onAdShow() {
                    TTAd.this.onExpose();
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onAdVideoBarClick() {
                    TTAd.this.onClick();
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onRewardArrived(boolean b2, int i2, Bundle bundle) {
                    this.verify = b2;
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onRewardVerify(boolean rewardVerify, int rewardAmount, String rewardName, int errorCode, String errorMsg) {
                    this.verify = rewardVerify;
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onSkippedVideo() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onVideoComplete() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onVideoError() {
                    TTAd.this.fallback(new b.d.c.b.c(-1, AdConfig.ActionString.FAIL));
                }
            });
            ad2.setDownloadListener(new TTAppDownloadListener() { // from class: com.martian.ads.ad.TTAd.8.2
                AnonymousClass2() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadActive(long totalBytes, long currBytes, String fileName, String appName) {
                    if (TTAd.this.mHasShowDownloadActive) {
                        return;
                    }
                    TTAd.this.mHasShowDownloadActive = true;
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFailed(long totalBytes, long currBytes, String fileName, String appName) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFinished(long totalBytes, String fileName, String appName) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadPaused(long totalBytes, long currBytes, String fileName, String appName) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onIdle() {
                    TTAd.this.mHasShowDownloadActive = false;
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onInstalled(String fileName, String appName) {
                }
            });
            AppTask appTask = TTAd.this.adConfig.toAppTask();
            appTask.origin = ad2;
            TTAd.this.getAppTaskList().addAppTask(appTask);
            TTAd.this.onAdReceived();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached(TTRewardVideoAd ttRewardVideoAd) {
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$9 */
    class AnonymousClass9 implements TTAdNative.FullScreenVideoAdListener {
        AnonymousClass9() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int code, String message) {
            TTAd.this.fallback(new b.d.c.b.c(code, message));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd ttFullScreenVideoAd) {
            if (ttFullScreenVideoAd == null) {
                TTAd.this.fallback(null);
                return;
            }
            TTAd.this.bindFullScreenVideoAd(ttFullScreenVideoAd);
            AppTask appTask = TTAd.this.adConfig.toAppTask();
            appTask.origin = ttFullScreenVideoAd;
            TTAd.this.getAppTaskList().addAppTask(appTask);
            TTAd.this.onAdReceived();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached(TTFullScreenVideoAd ttFullScreenVideoAd) {
        }
    }

    public TTAd(AdConfig config, @NonNull b.d.a.k.a receiver) {
        super(config, receiver);
        this.cancelLoading = false;
        this.mHasShowDownloadActive = false;
    }

    public void bindAdListener(Activity activity, TTNativeExpressAd ad2) {
        ad2.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) new TTNativeExpressAd.AdInteractionListener() { // from class: com.martian.ads.ad.TTAd.13
            final /* synthetic */ Activity val$activity;

            AnonymousClass13(Activity activity2) {
                activity = activity2;
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int type) {
                TTAd.this.onClick();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
            public void onAdDismiss() {
                TTAd.this.onDismiss();
                TTAd.this.onRewardVerify(true);
                if (TTAd.this.mTTAd != null) {
                    TTAd.this.mTTAd.destroy();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int type) {
                TTAd.this.onExpose();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String msg, int code) {
                TTAd.this.onError(new b.d.c.b.c(code, msg));
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float width, float height) {
                if (n0.B(activity)) {
                    TTAd.this.mTTAd.showInteractionExpressAd(activity);
                }
            }
        });
        if (ad2.getInteractionType() != 4) {
            return;
        }
        ad2.setDownloadListener(new TTAppDownloadListener() { // from class: com.martian.ads.ad.TTAd.14
            AnonymousClass14() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long totalBytes, long currBytes, String fileName, String appName) {
                if (TTAd.this.mHasShowDownloadActive) {
                    return;
                }
                TTAd.this.mHasShowDownloadActive = true;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long totalBytes, long currBytes, String fileName, String appName) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long totalBytes, String fileName, String appName) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long totalBytes, long currBytes, String fileName, String appName) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String fileName, String appName) {
            }
        });
    }

    public static void bindBannerAd(final AppTask appTask, ViewGroup adContainer, View adView, View creativeView, final b.d.a.k.a innerListener) {
        if (adContainer != null) {
            if (adView == null) {
                adView = adContainer;
            }
            if (appTask.isAdCompliance() && creativeView != null) {
                adView = creativeView;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(adView);
            ArrayList arrayList2 = new ArrayList();
            if (creativeView == null) {
                creativeView = adView;
            }
            arrayList2.add(creativeView);
            ((TTNativeAd) appTask.origin).registerViewForInteraction(adContainer, arrayList, arrayList2, new TTNativeAd.AdInteractionListener() { // from class: com.martian.ads.ad.TTAd.5
                final /* synthetic */ AppTask val$appTask;

                AnonymousClass5(final AppTask appTask2) {
                    appTask = appTask2;
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdClicked(View view, TTNativeAd ad2) {
                    b.d.a.k.a.this.j(b.d.a.j.b.Q(appTask));
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdCreativeClick(View view, TTNativeAd ad2) {
                    b.d.a.k.a.this.j(b.d.a.j.b.Q(appTask));
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdShow(TTNativeAd ad2) {
                    b.d.a.j.b.J(appTask, b.d.a.k.a.this);
                }
            });
        }
        ((TTNativeAd) appTask2.origin).setDownloadListener(new TTAppDownloadListener() { // from class: com.martian.ads.ad.TTAd.6
            boolean isDownload = false;

            AnonymousClass6() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long totalBytes, long currBytes, String fileName, String appName) {
                if (this.isDownload) {
                    return;
                }
                this.isDownload = true;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long totalBytes, long currBytes, String fileName, String appName) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long totalBytes, String fileName, String appName) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long totalBytes, long currBytes, String fileName, String appName) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String fileName, String appName) {
            }
        });
    }

    public static void bindFlowAd(final AppTask appTask, ViewGroup adContainer, View adView, View creativeView, final b.d.a.k.a innerListener) {
        if (adContainer != null) {
            if (adView == null) {
                adView = adContainer;
            }
            if (appTask.isAdCompliance() && creativeView != null) {
                adView = creativeView;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(adView);
            ArrayList arrayList2 = new ArrayList();
            if (creativeView == null) {
                creativeView = adView;
            }
            arrayList2.add(creativeView);
            ((TTFeedAd) appTask.origin).registerViewForInteraction(adContainer, arrayList, arrayList2, new TTNativeAd.AdInteractionListener() { // from class: com.martian.ads.ad.TTAd.15
                final /* synthetic */ AppTask val$appTask;

                AnonymousClass15(final AppTask appTask2) {
                    appTask = appTask2;
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdClicked(View view, TTNativeAd ad2) {
                    b.d.a.k.a.this.j(b.d.a.j.b.Q(appTask));
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdCreativeClick(View view, TTNativeAd ad2) {
                    b.d.a.k.a.this.j(b.d.a.j.b.Q(appTask));
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdShow(TTNativeAd ad2) {
                    b.d.a.j.b.J(appTask, b.d.a.k.a.this);
                }
            });
        }
        ((TTFeedAd) appTask2.origin).setDownloadListener(new TTAppDownloadListener() { // from class: com.martian.ads.ad.TTAd.16
            boolean isDownload = false;

            AnonymousClass16() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long totalBytes, long currBytes, String fileName, String appName) {
                if (this.isDownload) {
                    return;
                }
                this.isDownload = true;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long totalBytes, long currBytes, String fileName, String appName) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long totalBytes, String fileName, String appName) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long totalBytes, long currBytes, String fileName, String appName) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String fileName, String appName) {
            }
        });
    }

    public static void bindFlowTempAd(Activity activity, final AppTask appTask, final b.d.a.k.a innerListener) {
        TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) appTask.origin;
        tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.martian.ads.ad.TTAd.17
            final /* synthetic */ AppTask val$appTask;

            AnonymousClass17(final AppTask appTask2) {
                appTask = appTask2;
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int type) {
                b.d.a.k.a.this.j(b.d.a.j.b.Q(appTask));
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int type) {
                b.d.a.j.b.J(appTask, b.d.a.k.a.this);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String msg, int code) {
                b.d.a.k.a.this.g(b.d.a.j.b.Q(appTask), new b.d.c.b.c(-1, ""));
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float width, float height) {
            }
        });
        tTNativeExpressAd.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.martian.ads.ad.TTAd.18
            final /* synthetic */ AppTask val$appTask;

            AnonymousClass18(final AppTask appTask2) {
                appTask = appTask2;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onCancel() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onSelected(int position, String value, boolean b2) {
                b.d.a.k.a.this.b(b.d.a.j.b.Q(appTask));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onShow() {
            }
        });
        if (tTNativeExpressAd.getInteractionType() == 4) {
            tTNativeExpressAd.setDownloadListener(new TTAppDownloadListener() { // from class: com.martian.ads.ad.TTAd.19
                AnonymousClass19() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadActive(long totalBytes, long currBytes, String fileName, String appName) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFailed(long totalBytes, long currBytes, String fileName, String appName) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFinished(long totalBytes, String fileName, String appName) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadPaused(long totalBytes, long currBytes, String fileName, String appName) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onIdle() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onInstalled(String fileName, String appName) {
                }
            });
        }
    }

    public void bindFullScreenVideoAd(TTFullScreenVideoAd ad2) {
        ad2.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.martian.ads.ad.TTAd.10
            boolean verify = false;

            AnonymousClass10() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdClose() {
                TTAd.this.onClose();
                TTAd.this.onDismiss();
                TTAd.this.onRewardVerify(true);
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdShow() {
                TTAd.this.onExpose();
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdVideoBarClick() {
                TTAd.this.onClick();
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onSkippedVideo() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onVideoComplete() {
                this.verify = true;
            }
        });
        ad2.setDownloadListener(new TTAppDownloadListener() { // from class: com.martian.ads.ad.TTAd.11
            AnonymousClass11() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long totalBytes, long currBytes, String fileName, String appName) {
                if (TTAd.this.mHasShowDownloadActive) {
                    return;
                }
                TTAd.this.mHasShowDownloadActive = true;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long totalBytes, long currBytes, String fileName, String appName) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long totalBytes, String fileName, String appName) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long totalBytes, long currBytes, String fileName, String appName) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                TTAd.this.mHasShowDownloadActive = false;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String fileName, String appName) {
            }
        });
    }

    public static void destroyBannerView(TTNativeAd ad2) {
        ad2.destroy();
    }

    public static void destroyView(TTFeedAd ad2) {
        ad2.destroy();
    }

    public void fallback(b.d.c.b.c errorResult) {
        onError(errorResult);
    }

    public static boolean isTTBannerAd(AppTask appTask) {
        return appTask != null && (appTask.origin instanceof TTNativeAd);
    }

    public static boolean isTTFlowAd(AppTask appTask) {
        return appTask != null && (appTask.origin instanceof TTFeedAd);
    }

    public static boolean isTTFlowTempAd(AppTask appTask) {
        return appTask != null && (appTask.origin instanceof TTNativeExpressAd);
    }

    private void loadBannerAds(TTAdNative mTTAdNative) {
        AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(this.adConfig.getAdsId()).setSupportDeepLink(true).setImageAcceptedSize(600, 90).setNativeAdType(1).setAdCount(this.adConfig.getAdsCount());
        if (!k.p(this.adConfig.getPrimeRit())) {
            adCount.setAdloadSeq(this.adConfig.getAdLoadSeq()).setPrimeRit(this.adConfig.getPrimeRit());
        }
        mTTAdNative.loadNativeAd(adCount.build(), new TTAdNative.NativeAdListener() { // from class: com.martian.ads.ad.TTAd.4
            AnonymousClass4() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int code, String message) {
                TTAd.this.fallback(new b.d.c.b.c(code, message));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
            public void onNativeAdLoad(List<TTNativeAd> ads) {
                if (ads == null || ads.get(0) == null) {
                    TTAd.this.fallback(null);
                    return;
                }
                Iterator<TTNativeAd> it = ads.iterator();
                while (it.hasNext()) {
                    TTAd.this.getAppTaskList().addAppTask(TTAd.this.toAppTask(it.next()));
                }
                TTAd.this.onAdReceived();
            }
        });
    }

    private void loadBannerTemplateAds(Activity activity, TTAdNative mTTAdNative) {
        int i1 = com.martian.libmars.d.h.i1(l.h(activity));
        if (this.adConfig.getWidth() > 0) {
            i1 = this.adConfig.getWidth();
        }
        AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(this.adConfig.getAdsId()).setSupportDeepLink(true).setImageAcceptedSize(600, 90).setExpressViewAcceptedSize(i1, this.adConfig.getHeight() > 0 ? this.adConfig.getHeight() : 64).setAdCount(this.adConfig.getAdsCount());
        if (!k.p(this.adConfig.getPrimeRit())) {
            adCount.setAdloadSeq(this.adConfig.getAdLoadSeq()).setPrimeRit(this.adConfig.getPrimeRit());
        }
        mTTAdNative.loadBannerExpressAd(adCount.build(), new TTAdNative.NativeExpressAdListener() { // from class: com.martian.ads.ad.TTAd.7
            AnonymousClass7() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int code, String message) {
                TTAd.this.fallback(new b.d.c.b.c(code, message));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> ads) {
                if (ads == null || ads.isEmpty()) {
                    TTAd.this.fallback(null);
                    return;
                }
                for (TTNativeExpressAd tTNativeExpressAd : ads) {
                    AppTask appTask = TTAd.this.adConfig.toAppTask();
                    appTask.origin = tTNativeExpressAd;
                    appTask.customView = new h(tTNativeExpressAd);
                    TTAd.this.getAppTaskList().addAppTask(appTask);
                }
                TTAd.this.onAdReceived();
            }
        });
    }

    private void loadFullScreenVideoAd(TTAdNative mTTAdNative) {
        mTTAdNative.loadFullScreenVideoAd(new AdSlot.Builder().setCodeId(this.adConfig.getAdsId()).setSupportDeepLink(true).setImageAcceptedSize(DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED, 1920).setExpressViewAcceptedSize(500.0f, 500.0f).setUserID(this.adConfig.getUid()).setOrientation(1).build(), new TTAdNative.FullScreenVideoAdListener() { // from class: com.martian.ads.ad.TTAd.9
            AnonymousClass9() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int code, String message) {
                TTAd.this.fallback(new b.d.c.b.c(code, message));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoAdLoad(TTFullScreenVideoAd ttFullScreenVideoAd) {
                if (ttFullScreenVideoAd == null) {
                    TTAd.this.fallback(null);
                    return;
                }
                TTAd.this.bindFullScreenVideoAd(ttFullScreenVideoAd);
                AppTask appTask = TTAd.this.adConfig.toAppTask();
                appTask.origin = ttFullScreenVideoAd;
                TTAd.this.getAppTaskList().addAppTask(appTask);
                TTAd.this.onAdReceived();
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached(TTFullScreenVideoAd ttFullScreenVideoAd) {
            }
        });
    }

    private void loadInteractionAd(Activity activity, TTAdNative mTTAdNative) {
        mTTAdNative.loadInteractionExpressAd(new AdSlot.Builder().setCodeId(this.adConfig.getAdsId()).setSupportDeepLink(true).setExpressViewAcceptedSize(this.adConfig.getWidth() > 0 ? this.adConfig.getWidth() : 288, Math.max(0, this.adConfig.getHeight())).setImageAcceptedSize(640, 320).setNativeAdType(2).build(), new TTAdNative.NativeExpressAdListener() { // from class: com.martian.ads.ad.TTAd.12
            final /* synthetic */ Activity val$activity;

            AnonymousClass12(Activity activity2) {
                activity = activity2;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int code, String message) {
                TTAd.this.onError(new b.d.c.b.c(code, message));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                if (list == null || list.isEmpty()) {
                    TTAd.this.onError(null);
                    return;
                }
                TTAd.this.mTTAd = list.get(0);
                TTAd tTAd = TTAd.this;
                tTAd.bindAdListener(activity, tTAd.mTTAd);
                AppTask appTask = TTAd.this.adConfig.toAppTask();
                appTask.origin = TTAd.this.mTTAd;
                TTAd.this.getAppTaskList().addAppTask(appTask);
                TTAd.this.onAdReceived();
            }
        });
    }

    private void loadSplashAds(Activity activity, TTAdNative mTTAdNative) {
        mTTAdNative.loadSplashAd(new AdSlot.Builder().setCodeId(this.adConfig.getAdsId()).setImageAcceptedSize(l.h(activity), l.g(activity)).setAdLoadType(this.adConfig.getAdLoadType()).setExpressViewAcceptedSize(com.martian.libmars.d.h.i1(r0), com.martian.libmars.d.h.i1(r4)).build(), new TTAdNative.CSJSplashAdListener() { // from class: com.martian.ads.ad.TTAd.1

            /* renamed from: com.martian.ads.ad.TTAd$1$1 */
            class C02551 implements CSJSplashAd.SplashAdListener {
                C02551() {
                }

                @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                public void onSplashAdClick(CSJSplashAd csjSplashAd2) {
                    TTAd.this.onClick();
                }

                @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                public void onSplashAdClose(CSJSplashAd csjSplashAd2, int i2) {
                    TTAd.this.onClose();
                }

                @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                public void onSplashAdShow(CSJSplashAd csjSplashAd2) {
                    TTAd.this.onExpose();
                }
            }

            AnonymousClass1() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashLoadFail(CSJAdError csjAdError) {
                TTAd.this.fallback(new b.d.c.b.c(csjAdError.getCode(), csjAdError.getMsg()));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashLoadSuccess() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashRenderFail(CSJSplashAd csjSplashAd, CSJAdError csjAdError) {
                TTAd.this.fallback(new b.d.c.b.c(csjAdError.getCode(), csjAdError.getMsg()));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashRenderSuccess(CSJSplashAd csjSplashAd) {
                if (csjSplashAd == null) {
                    TTAd.this.fallback(null);
                    return;
                }
                csjSplashAd.setSplashAdListener(new CSJSplashAd.SplashAdListener() { // from class: com.martian.ads.ad.TTAd.1.1
                    C02551() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                    public void onSplashAdClick(CSJSplashAd csjSplashAd2) {
                        TTAd.this.onClick();
                    }

                    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                    public void onSplashAdClose(CSJSplashAd csjSplashAd2, int i2) {
                        TTAd.this.onClose();
                    }

                    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                    public void onSplashAdShow(CSJSplashAd csjSplashAd2) {
                        TTAd.this.onExpose();
                    }
                });
                AppTask appTask = TTAd.this.adConfig.toAppTask();
                appTask.origin = csjSplashAd;
                TTAd.this.getAppTaskList().addAppTask(appTask);
                TTAd.this.onAdReceived();
            }
        }, 4000);
    }

    private void loadTemplateAds(TTAdNative mTTAdNative) {
        AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(this.adConfig.getAdsId()).setSupportDeepLink(true).setImageAcceptedSize(640, 320).setExpressViewAcceptedSize(this.adConfig.getWidth() <= 0 ? 360 : this.adConfig.getWidth(), this.adConfig.getHeight()).setAdCount(this.adConfig.getAdsCount());
        if (!k.p(this.adConfig.getPrimeRit())) {
            adCount.setAdloadSeq(this.adConfig.getAdLoadSeq()).setPrimeRit(this.adConfig.getPrimeRit());
        }
        mTTAdNative.loadNativeExpressAd(adCount.build(), new TTAdNative.NativeExpressAdListener() { // from class: com.martian.ads.ad.TTAd.3
            AnonymousClass3() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int code, String message) {
                TTAd.this.fallback(new b.d.c.b.c(code, "" + code));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> ads) {
                if (ads == null || ads.isEmpty()) {
                    TTAd.this.fallback(null);
                    return;
                }
                for (TTNativeExpressAd tTNativeExpressAd : ads) {
                    AppTask appTask = TTAd.this.adConfig.toAppTask();
                    appTask.origin = tTNativeExpressAd;
                    appTask.isVideoAd = true;
                    appTask.customView = new h(tTNativeExpressAd);
                    TTAd.this.getAppTaskList().addAppTask(appTask);
                }
                TTAd.this.onAdReceived();
            }
        });
    }

    private void loadVideoAd(TTAdNative mTTAdNative) {
        mTTAdNative.loadRewardVideoAd(new AdSlot.Builder().setCodeId(this.adConfig.getAdsId()).setSupportDeepLink(true).setImageAcceptedSize(DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED, 1920).setExpressViewAcceptedSize(500.0f, 500.0f).setUserID(this.adConfig.getUid()).setMediaExtra(this.adConfig.getRewardExtra()).setOrientation(1).build(), new TTAdNative.RewardVideoAdListener() { // from class: com.martian.ads.ad.TTAd.8

            /* renamed from: com.martian.ads.ad.TTAd$8$1 */
            class AnonymousClass1 implements TTRewardVideoAd.RewardAdInteractionListener {
                private boolean verify = false;

                AnonymousClass1() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onAdClose() {
                    TTAd.this.onClose();
                    TTAd.this.onRewardVerify(this.verify);
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onAdShow() {
                    TTAd.this.onExpose();
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onAdVideoBarClick() {
                    TTAd.this.onClick();
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onRewardArrived(boolean b2, int i2, Bundle bundle) {
                    this.verify = b2;
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onRewardVerify(boolean rewardVerify, int rewardAmount, String rewardName, int errorCode, String errorMsg) {
                    this.verify = rewardVerify;
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onSkippedVideo() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onVideoComplete() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onVideoError() {
                    TTAd.this.fallback(new b.d.c.b.c(-1, AdConfig.ActionString.FAIL));
                }
            }

            /* renamed from: com.martian.ads.ad.TTAd$8$2 */
            class AnonymousClass2 implements TTAppDownloadListener {
                AnonymousClass2() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadActive(long totalBytes, long currBytes, String fileName, String appName) {
                    if (TTAd.this.mHasShowDownloadActive) {
                        return;
                    }
                    TTAd.this.mHasShowDownloadActive = true;
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFailed(long totalBytes, long currBytes, String fileName, String appName) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFinished(long totalBytes, String fileName, String appName) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadPaused(long totalBytes, long currBytes, String fileName, String appName) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onIdle() {
                    TTAd.this.mHasShowDownloadActive = false;
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onInstalled(String fileName, String appName) {
                }
            }

            AnonymousClass8() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int code, String message) {
                TTAd.this.fallback(new b.d.c.b.c(code, message));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoAdLoad(TTRewardVideoAd ad2) {
                if (ad2 == null) {
                    TTAd.this.fallback(null);
                    return;
                }
                ad2.setRewardAdInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.martian.ads.ad.TTAd.8.1
                    private boolean verify = false;

                    AnonymousClass1() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdClose() {
                        TTAd.this.onClose();
                        TTAd.this.onRewardVerify(this.verify);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdShow() {
                        TTAd.this.onExpose();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdVideoBarClick() {
                        TTAd.this.onClick();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onRewardArrived(boolean b2, int i2, Bundle bundle) {
                        this.verify = b2;
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onRewardVerify(boolean rewardVerify, int rewardAmount, String rewardName, int errorCode, String errorMsg) {
                        this.verify = rewardVerify;
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onSkippedVideo() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoComplete() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoError() {
                        TTAd.this.fallback(new b.d.c.b.c(-1, AdConfig.ActionString.FAIL));
                    }
                });
                ad2.setDownloadListener(new TTAppDownloadListener() { // from class: com.martian.ads.ad.TTAd.8.2
                    AnonymousClass2() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadActive(long totalBytes, long currBytes, String fileName, String appName) {
                        if (TTAd.this.mHasShowDownloadActive) {
                            return;
                        }
                        TTAd.this.mHasShowDownloadActive = true;
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadFailed(long totalBytes, long currBytes, String fileName, String appName) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadFinished(long totalBytes, String fileName, String appName) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadPaused(long totalBytes, long currBytes, String fileName, String appName) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onIdle() {
                        TTAd.this.mHasShowDownloadActive = false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onInstalled(String fileName, String appName) {
                    }
                });
                AppTask appTask = TTAd.this.adConfig.toAppTask();
                appTask.origin = ad2;
                TTAd.this.getAppTaskList().addAppTask(appTask);
                TTAd.this.onAdReceived();
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached(TTRewardVideoAd ttRewardVideoAd) {
            }
        });
    }

    public static void showFullScreenVideoAd(Activity activity, @NonNull TTFullScreenVideoAd ttFullScreenVideoAd) {
        ttFullScreenVideoAd.showFullScreenVideoAd(activity);
    }

    public static void showInterstitialAd(@NonNull TTNativeExpressAd ttNativeExpressAd) {
        ttNativeExpressAd.render();
    }

    public static void showSplashAd(@NonNull CSJSplashAd splashAd, ViewGroup viewGroup) {
        splashAd.showSplashView(viewGroup);
    }

    public static void showVideoAd(Activity activity, @NonNull TTRewardVideoAd rewardVideoAd) {
        rewardVideoAd.showRewardVideoAd(activity);
    }

    public AppTask toAppTask(TTFeedAd ttFeedAd) {
        String str;
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = ttFeedAd;
        appTask.title = com.martian.libmars.d.h.F().n(ttFeedAd.getTitle());
        appTask.desc = com.martian.libmars.d.h.F().n(ttFeedAd.getDescription());
        if (ttFeedAd.getAppCommentNum() > 0) {
            appTask.appPromote = com.martian.libmars.d.h.F().n(appTask.getNumbers(ttFeedAd.getAppCommentNum() * 10) + "人下载");
        } else if (ttFeedAd.getAppScore() > 0) {
            appTask.appPromote = ttFeedAd.getAppScore() + "分";
        } else {
            appTask.appPromote = com.martian.libmars.d.h.F().n("赞助正版章节");
        }
        if (ttFeedAd.getIcon() == null || k.p(ttFeedAd.getIcon().getImageUrl())) {
            str = "";
        } else {
            str = ttFeedAd.getIcon().getImageUrl();
            appTask.iconUrl = str;
        }
        List<TTImage> imageList = ttFeedAd.getImageList();
        if (imageList != null && !imageList.isEmpty()) {
            for (TTImage tTImage : imageList) {
                if (appTask.getPosterUrls().size() > 0 && k.p(appTask.iconUrl)) {
                    appTask.iconUrl = tTImage.getImageUrl();
                }
                appTask.addPosterUrl(tTImage.getImageUrl());
            }
        } else if (!k.p(str)) {
            appTask.addPosterUrl(str);
        }
        if (k.p(appTask.iconUrl)) {
            appTask.iconUrl = appTask.getPosterUrl();
        }
        if (!k.p(ttFeedAd.getButtonText())) {
            appTask.buttonText = com.martian.libmars.d.h.F().n(ttFeedAd.getButtonText());
        }
        if (ttFeedAd.getComplianceInfo() != null) {
            appTask.name = ttFeedAd.getComplianceInfo().getAppName();
        }
        appTask.setPicWidth(ttFeedAd.getAdViewWidth());
        appTask.setPicHeight(ttFeedAd.getAdViewHeight());
        if (this.adConfig.isWifiEnv() && ttFeedAd.getImageMode() == 5 && ttFeedAd.getAdView() != null) {
            appTask.isVideoAd = true;
            appTask.videoView = new ViewWrapper(ttFeedAd.getAdView());
        }
        appTask.setInteractionType(ttFeedAd.getInteractionType());
        if (this.adConfig.isNeedNativeCompliance()) {
            appTask.setAdCompliance(this.adConfig.isAdCompliance());
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
        TTAdNative createAdNative;
        createAdNative = g.a().createAdNative(activity);
        String type = this.adConfig.getType();
        type.hashCode();
        switch (type) {
            case "banner_tt":
                loadBannerAds(createAdNative);
                return;
            case "banner":
                loadBannerTemplateAds(activity, createAdNative);
                return;
            case "express":
                loadTemplateAds(createAdNative);
                return;
            case "native":
                loadFlowAds(createAdNative);
                return;
            case "splash":
                loadSplashAds(activity, createAdNative);
                return;
            case "full_video":
                loadFullScreenVideoAd(createAdNative);
                return;
            case "interstitial":
                loadInteractionAd(activity, createAdNative);
                return;
            case "reward_video":
                loadVideoAd(createAdNative);
                return;
            default:
                if (!com.martian.libmars.d.h.F().Q0()) {
                    loadFlowAds(createAdNative);
                    return;
                }
                throw new IllegalStateException("invalid ads type:" + this.adConfig.getType());
        }
    }

    protected void loadFlowAds(TTAdNative mTTAdNative) {
        AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(this.adConfig.getAdsId()).setSupportDeepLink(true).setImageAcceptedSize(640, 320).setAdCount(this.adConfig.getAdsCount());
        if (!k.p(this.adConfig.getPrimeRit())) {
            adCount.setAdloadSeq(this.adConfig.getAdLoadSeq()).setPrimeRit(this.adConfig.getPrimeRit());
        }
        mTTAdNative.loadFeedAd(adCount.build(), new TTAdNative.FeedAdListener() { // from class: com.martian.ads.ad.TTAd.2
            AnonymousClass2() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int code, String message) {
                TTAd.this.fallback(new b.d.c.b.c(code, "" + code));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> ads) {
                if (ads == null || ads.isEmpty()) {
                    TTAd.this.fallback(null);
                    return;
                }
                Iterator<TTFeedAd> it = ads.iterator();
                while (it.hasNext()) {
                    TTAd.this.getAppTaskList().addAppTask(TTAd.this.toAppTask(it.next()));
                }
                TTAd.this.onAdReceived();
            }
        });
    }

    public AppTask toAppTask(TTNativeAd ttFeedAd) {
        String str;
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = ttFeedAd;
        appTask.title = com.martian.libmars.d.h.F().n(ttFeedAd.getTitle());
        appTask.desc = com.martian.libmars.d.h.F().n(ttFeedAd.getDescription());
        if (ttFeedAd.getAppCommentNum() > 0) {
            appTask.appPromote = com.martian.libmars.d.h.F().n(appTask.getNumbers(ttFeedAd.getAppCommentNum() * 10) + "人下载");
        } else if (ttFeedAd.getAppScore() > 0) {
            appTask.appPromote = ttFeedAd.getAppScore() + "分";
        } else {
            appTask.appPromote = com.martian.libmars.d.h.F().n("赞助正版章节");
        }
        if (ttFeedAd.getIcon() == null || k.p(ttFeedAd.getIcon().getImageUrl())) {
            str = "";
        } else {
            str = ttFeedAd.getIcon().getImageUrl();
            appTask.iconUrl = str;
        }
        List<TTImage> imageList = ttFeedAd.getImageList();
        if (imageList != null && !imageList.isEmpty()) {
            for (TTImage tTImage : imageList) {
                if (appTask.getPosterUrls().size() > 0 && k.p(appTask.iconUrl)) {
                    appTask.iconUrl = tTImage.getImageUrl();
                }
                appTask.addPosterUrl(tTImage.getImageUrl());
            }
        } else if (!k.p(str)) {
            appTask.addPosterUrl(str);
        }
        if (k.p(appTask.iconUrl)) {
            appTask.iconUrl = appTask.getPosterUrl();
        }
        if (!k.p(ttFeedAd.getButtonText())) {
            appTask.buttonText = com.martian.libmars.d.h.F().n(ttFeedAd.getButtonText());
        }
        if (ttFeedAd.getComplianceInfo() != null) {
            appTask.name = ttFeedAd.getComplianceInfo().getAppName();
        }
        if (this.adConfig.isWifiEnv() && ttFeedAd.getImageMode() == 5 && ttFeedAd.getAdView() != null) {
            appTask.isVideoAd = true;
            appTask.videoView = new ViewWrapper(ttFeedAd.getAdView());
        }
        appTask.setInteractionType(ttFeedAd.getInteractionType());
        if (this.adConfig.isNeedNativeCompliance()) {
            appTask.setAdCompliance(this.adConfig.isAdCompliance());
        }
        return appTask;
    }
}
