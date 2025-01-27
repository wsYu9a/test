package com.martian.ads.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import b8.p;
import b8.q;
import ba.l;
import ba.m;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.martian.ads.ad.GroMoreAd;
import com.martian.ads.ad.TTAd;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.ComplianceInfo;
import com.martian.apptask.data.ViewWrapper;
import com.martian.libmars.common.ConfigSingleton;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l9.p0;
import x8.c;

/* loaded from: classes3.dex */
public class TTAd extends BaseAd {

    /* renamed from: com.martian.ads.ad.TTAd$1 */
    public class AnonymousClass1 implements TTAdNative.CSJSplashAdListener {
        public AnonymousClass1() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashLoadFail(CSJAdError cSJAdError) {
            TTAd.this.fallback(new c(cSJAdError.getCode(), cSJAdError.getMsg()));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashLoadSuccess(CSJSplashAd cSJSplashAd) {
            if (cSJSplashAd == null) {
                TTAd.this.fallback(null);
                return;
            }
            AppTask appTask = TTAd.this.adConfig.toAppTask();
            appTask.origin = cSJSplashAd;
            TTAd.this.getAppTaskList().addAppTask(appTask);
            TTAd.this.onAdReceived();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
            TTAd.this.fallback(new c(cSJAdError.getCode(), cSJAdError.getMsg()));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$10 */
    public class AnonymousClass10 implements TTRewardVideoAd.RewardAdInteractionListener {
        final /* synthetic */ AdConfig val$adConfig;
        private boolean exposed = false;
        private boolean clicked = false;
        private boolean verify = false;

        public AnonymousClass10(AdConfig adConfig) {
            adConfig = adConfig;
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdClose() {
            if (d8.b.this != null) {
                p0.c("adtag", "onAdClose verify:" + this.verify);
                d8.b.this.d(adConfig);
                d8.b.this.k(adConfig, this.verify);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdShow() {
            if (this.exposed) {
                return;
            }
            this.exposed = true;
            d8.b bVar = d8.b.this;
            if (bVar != null) {
                bVar.b(adConfig);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdVideoBarClick() {
            if (this.clicked) {
                return;
            }
            this.clicked = true;
            d8.b bVar = d8.b.this;
            if (bVar != null) {
                bVar.l(adConfig);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onRewardArrived(boolean z10, int i10, Bundle bundle) {
            this.verify = z10;
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onRewardVerify(boolean z10, int i10, String str, int i11, String str2) {
            this.verify = z10;
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onSkippedVideo() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onVideoComplete() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onVideoError() {
            d8.b bVar = d8.b.this;
            if (bVar != null) {
                bVar.c(adConfig, new c(-1, "失败"));
            }
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$11 */
    public class AnonymousClass11 implements TTAdNative.FullScreenVideoAdListener {
        public AnonymousClass11() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onError(int i10, String str) {
            TTAd.this.fallback(new c(i10, str));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            if (tTFullScreenVideoAd == null) {
                TTAd.this.fallback(null);
                return;
            }
            TTAd.this.bindFullScreenVideoAd(tTFullScreenVideoAd);
            AppTask appTask = TTAd.this.adConfig.toAppTask();
            appTask.origin = tTFullScreenVideoAd;
            TTAd.this.getAppTaskList().addAppTask(appTask);
            TTAd.this.onAdReceived();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$12 */
    public class AnonymousClass12 implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
        boolean verify = false;

        public AnonymousClass12() {
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

    /* renamed from: com.martian.ads.ad.TTAd$13 */
    public class AnonymousClass13 implements TTAppDownloadListener {
        public AnonymousClass13() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j10, long j11, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j10, long j11, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j10, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long j10, long j11, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$14 */
    public class AnonymousClass14 implements TTNativeAd.AdInteractionListener {
        final /* synthetic */ AdConfig val$adConfig1;

        public AnonymousClass14(AdConfig adConfig) {
            adConfig = adConfig;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd tTNativeAd) {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.l(adConfig);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.l(adConfig);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.b(adConfig);
            }
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$15 */
    public class AnonymousClass15 implements TTAppDownloadListener {
        final WeakReference<GroMoreAd.AdViewHolder> adViewHolderWeakReference;
        private String appName;

        public AnonymousClass15() {
            this.adViewHolderWeakReference = new WeakReference<>(GroMoreAd.AdViewHolder.this);
        }

        private boolean notValid(String str) {
            return !str.equalsIgnoreCase(this.appName);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j10, long j11, String str, String str2) {
            Button button;
            GroMoreAd.AdViewHolder adViewHolder = this.adViewHolderWeakReference.get();
            if (notValid(str2) || adViewHolder == null || (button = adViewHolder.mCreativeButton) == null) {
                return;
            }
            button.setText(ConfigSingleton.D().s("立即下载"));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j10, long j11, String str, String str2) {
            Button button;
            GroMoreAd.AdViewHolder adViewHolder = this.adViewHolderWeakReference.get();
            if (notValid(str2) || adViewHolder == null || (button = adViewHolder.mCreativeButton) == null) {
                return;
            }
            button.setText(ConfigSingleton.D().s("点击下载"));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j10, String str, String str2) {
            Button button;
            GroMoreAd.AdViewHolder adViewHolder = this.adViewHolderWeakReference.get();
            if (notValid(str2) || adViewHolder == null || (button = adViewHolder.mCreativeButton) == null) {
                return;
            }
            button.setText(ConfigSingleton.D().s("点击安装"));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long j10, long j11, String str, String str2) {
            Button button;
            GroMoreAd.AdViewHolder adViewHolder = this.adViewHolderWeakReference.get();
            if (notValid(str2) || adViewHolder == null || (button = adViewHolder.mCreativeButton) == null) {
                return;
            }
            button.setText(ConfigSingleton.D().s("继续下载"));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
            Button button;
            GroMoreAd.AdViewHolder adViewHolder = this.adViewHolderWeakReference.get();
            if (notValid(str2) || adViewHolder == null || (button = adViewHolder.mCreativeButton) == null) {
                return;
            }
            button.setText(ConfigSingleton.D().s("点击打开"));
        }

        public TTAppDownloadListener setAppName(String str) {
            this.appName = str;
            return this;
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$16 */
    public class AnonymousClass16 implements TTNativeExpressAd.ExpressAdInteractionListener {
        final /* synthetic */ AdConfig val$adConfig;

        public AnonymousClass16(AdConfig adConfig) {
            adConfig = adConfig;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int i10) {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.l(adConfig);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int i10) {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.b(adConfig);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String str, int i10) {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.c(adConfig, new c(-1, ""));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float f10, float f11) {
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$17 */
    public class AnonymousClass17 implements TTAdDislike.DislikeInteractionCallback {
        final /* synthetic */ AdConfig val$adConfig;

        public AnonymousClass17(AdConfig adConfig) {
            adConfig = adConfig;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onCancel() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onSelected(int i10, String str, boolean z10) {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.d(adConfig);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onShow() {
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$18 */
    public class AnonymousClass18 implements TTAdNative.DrawFeedAdListener {
        public AnonymousClass18() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
        public void onDrawFeedAdLoad(List<TTDrawFeedAd> list) {
            if (list == null || list.isEmpty()) {
                TTAd.this.fallback(null);
                return;
            }
            TTAd.this.getAppTaskList().addAppTask(TTAd.this.toAppTask((TTFeedAd) list.get(0)));
            TTAd.this.onAdReceived();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
        public void onError(int i10, String str) {
            TTAd.this.fallback(new c(i10, str));
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$19 */
    public class AnonymousClass19 implements TTAdNative.FeedAdListener {
        public AnonymousClass19() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
        public void onError(int i10, String str) {
            TTAd.this.fallback(new c(i10, str));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
        public void onFeedAdLoad(List<TTFeedAd> list) {
            if (list == null || list.isEmpty()) {
                TTAd.this.fallback(null);
                return;
            }
            TTAd.this.getAppTaskList().addAppTask(TTAd.this.toAppTask(list.get(0)));
            TTAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$2 */
    public class AnonymousClass2 implements CSJSplashAd.SplashAdListener {
        final /* synthetic */ AdConfig val$adConfig;

        public AnonymousClass2(AdConfig adConfig) {
            adConfig = adConfig;
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
        public void onSplashAdClick(CSJSplashAd cSJSplashAd) {
            d8.b bVar = d8.b.this;
            if (bVar != null) {
                bVar.l(adConfig);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
        public void onSplashAdClose(CSJSplashAd cSJSplashAd, int i10) {
            d8.b bVar = d8.b.this;
            if (bVar != null) {
                bVar.d(adConfig);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
        public void onSplashAdShow(CSJSplashAd cSJSplashAd) {
            d8.b bVar = d8.b.this;
            if (bVar != null) {
                bVar.b(adConfig);
            }
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$3 */
    public class AnonymousClass3 implements TTAdNative.FeedAdListener {
        public AnonymousClass3() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
        public void onError(int i10, String str) {
            TTAd.this.fallback(new c(i10, str));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
        public void onFeedAdLoad(List<TTFeedAd> list) {
            if (list == null || list.isEmpty()) {
                TTAd.this.fallback(null);
                return;
            }
            TTAd.this.getAppTaskList().addAppTask(TTAd.this.toAppTask(list.get(0)));
            TTAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$4 */
    public class AnonymousClass4 implements TTAdNative.NativeExpressAdListener {
        public AnonymousClass4() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onError(int i10, String str) {
            TTAd.this.fallback(new c(i10, "" + i10));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            if (list == null || list.isEmpty()) {
                TTAd.this.fallback(null);
                return;
            }
            for (TTNativeExpressAd tTNativeExpressAd : list) {
                AppTask appTask = TTAd.this.adConfig.toAppTask();
                appTask.origin = tTNativeExpressAd;
                appTask.isVideoAd = true;
                appTask.customView = new q(tTNativeExpressAd);
                TTAd.this.getAppTaskList().addAppTask(appTask);
            }
            TTAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$5 */
    public class AnonymousClass5 implements TTAdNative.NativeAdListener {
        public AnonymousClass5() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
        public void onError(int i10, String str) {
            TTAd.this.fallback(new c(i10, str));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
        public void onNativeAdLoad(List<TTNativeAd> list) {
            if (list == null || list.get(0) == null) {
                TTAd.this.fallback(null);
                return;
            }
            Iterator<TTNativeAd> it = list.iterator();
            while (it.hasNext()) {
                TTAd.this.getAppTaskList().addAppTask(TTAd.this.toAppTask(it.next()));
            }
            TTAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$6 */
    public class AnonymousClass6 implements TTNativeAd.AdInteractionListener {
        final /* synthetic */ AdConfig val$adConfig;

        public AnonymousClass6(AdConfig adConfig) {
            adConfig = adConfig;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd tTNativeAd) {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.l(adConfig);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.l(adConfig);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.b(adConfig);
            }
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$7 */
    public class AnonymousClass7 implements TTAdDislike.DislikeInteractionCallback {
        final /* synthetic */ AdConfig val$adConfig;

        public AnonymousClass7(AdConfig adConfig) {
            adConfig = adConfig;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onCancel() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onSelected(int i10, String str, boolean z10) {
            d8.a aVar = d8.a.this;
            if (aVar != null) {
                aVar.d(adConfig);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onShow() {
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$8 */
    public class AnonymousClass8 implements TTAdNative.NativeExpressAdListener {
        public AnonymousClass8() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onError(int i10, String str) {
            TTAd.this.fallback(new c(i10, str));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            if (list == null || list.isEmpty()) {
                TTAd.this.fallback(null);
                return;
            }
            for (TTNativeExpressAd tTNativeExpressAd : list) {
                AppTask appTask = TTAd.this.adConfig.toAppTask();
                appTask.origin = tTNativeExpressAd;
                appTask.customView = new q(tTNativeExpressAd);
                TTAd.this.getAppTaskList().addAppTask(appTask);
            }
            TTAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.TTAd$9 */
    public class AnonymousClass9 implements TTAdNative.RewardVideoAdListener {
        public AnonymousClass9() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onError(int i10, String str) {
            TTAd.this.fallback(new c(i10, str));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            if (tTRewardVideoAd == null) {
                TTAd.this.fallback(null);
                return;
            }
            AppTask appTask = TTAd.this.adConfig.toAppTask();
            appTask.origin = tTRewardVideoAd;
            TTAd.this.getAppTaskList().addAppTask(appTask);
            TTAd.this.onAdReceived();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
        }
    }

    public TTAd(AdConfig adConfig, @NonNull d8.a aVar, Handler handler) {
        super(adConfig, aVar, handler);
    }

    public static void bindBannerAd(Activity activity, AppTask appTask, ViewGroup viewGroup, List<View> list, d8.a aVar) {
        if (viewGroup == null) {
            return;
        }
        TTNativeAd tTNativeAd = (TTNativeAd) appTask.origin;
        ArrayList arrayList = new ArrayList();
        arrayList.add(viewGroup);
        AdConfig adConfig = AdConfig.toAdConfig(appTask);
        tTNativeAd.registerViewForInteraction(viewGroup, arrayList, list, new TTNativeAd.AdInteractionListener() { // from class: com.martian.ads.ad.TTAd.6
            final /* synthetic */ AdConfig val$adConfig;

            public AnonymousClass6(AdConfig adConfig2) {
                adConfig = adConfig2;
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdClicked(View view, TTNativeAd tTNativeAd2) {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.l(adConfig);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdCreativeClick(View view, TTNativeAd tTNativeAd2) {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.l(adConfig);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdShow(TTNativeAd tTNativeAd2) {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.b(adConfig);
                }
            }
        });
        tTNativeAd.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.martian.ads.ad.TTAd.7
            final /* synthetic */ AdConfig val$adConfig;

            public AnonymousClass7(AdConfig adConfig2) {
                adConfig = adConfig2;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onCancel() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onSelected(int i10, String str, boolean z10) {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.d(adConfig);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onShow() {
            }
        });
    }

    public static void bindFlowAd(Activity activity, AppTask appTask, ViewGroup viewGroup, View view, GroMoreAd.AdViewHolder adViewHolder, d8.a aVar, boolean z10) {
        ArrayList arrayList;
        FrameLayout frameLayout;
        TTFeedAd tTFeedAd = (TTFeedAd) appTask.origin;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(viewGroup);
        arrayList2.add(view);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (adViewHolder != null) {
            Button button = adViewHolder.mCreativeButton;
            if (button != null) {
                arrayList4.add(button);
            }
            View view2 = adViewHolder.mCreativeButtonView;
            if (view2 != null) {
                arrayList4.add(view2);
            }
            ImageView imageView = adViewHolder.mPoster;
            if (imageView != null) {
                arrayList3.add(imageView);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        if (z10 || appTask.getComplianceInfo() == null || adViewHolder == null || adViewHolder.complianceView == null) {
            arrayList = arrayList5;
        } else {
            arrayList4.add(viewGroup);
            arrayList4.add(view);
            arrayList = arrayList4;
        }
        if (appTask.isCsjExpress()) {
            tTFeedAd.setExpressRenderListener(new TTNativeAd.ExpressRenderListener() { // from class: c8.p
                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.ExpressRenderListener
                public final void onRenderSuccess(View view3, float f10, float f11, boolean z11) {
                    TTAd.lambda$bindFlowAd$0(view3, f10, f11, z11);
                }
            });
            tTFeedAd.render();
        }
        if (adViewHolder != null && (frameLayout = adViewHolder.videoView) != null && appTask.isVideoAd && appTask.videoView != null) {
            frameLayout.setVisibility(0);
            appTask.videoView.init();
            adViewHolder.videoView.removeAllViews();
            adViewHolder.videoView.addView(appTask.videoView.getView());
        }
        tTFeedAd.registerViewForInteraction(viewGroup, arrayList3, arrayList2, arrayList4, arrayList, null, new TTNativeAd.AdInteractionListener() { // from class: com.martian.ads.ad.TTAd.14
            final /* synthetic */ AdConfig val$adConfig1;

            public AnonymousClass14(AdConfig adConfig) {
                adConfig = adConfig;
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdClicked(View view3, TTNativeAd tTNativeAd) {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.l(adConfig);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdCreativeClick(View view3, TTNativeAd tTNativeAd) {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.l(adConfig);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdShow(TTNativeAd tTNativeAd) {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.b(adConfig);
                }
            }
        });
        if (tTFeedAd.getInteractionType() != 4 || activity == null) {
            return;
        }
        tTFeedAd.setActivityForDownloadApp(activity);
        tTFeedAd.setDownloadListener(new TTAppDownloadListener() { // from class: com.martian.ads.ad.TTAd.15
            final WeakReference<GroMoreAd.AdViewHolder> adViewHolderWeakReference;
            private String appName;

            public AnonymousClass15() {
                this.adViewHolderWeakReference = new WeakReference<>(GroMoreAd.AdViewHolder.this);
            }

            private boolean notValid(String str) {
                return !str.equalsIgnoreCase(this.appName);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j10, long j11, String str, String str2) {
                Button button2;
                GroMoreAd.AdViewHolder adViewHolder2 = this.adViewHolderWeakReference.get();
                if (notValid(str2) || adViewHolder2 == null || (button2 = adViewHolder2.mCreativeButton) == null) {
                    return;
                }
                button2.setText(ConfigSingleton.D().s("立即下载"));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j10, long j11, String str, String str2) {
                Button button2;
                GroMoreAd.AdViewHolder adViewHolder2 = this.adViewHolderWeakReference.get();
                if (notValid(str2) || adViewHolder2 == null || (button2 = adViewHolder2.mCreativeButton) == null) {
                    return;
                }
                button2.setText(ConfigSingleton.D().s("点击下载"));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j10, String str, String str2) {
                Button button2;
                GroMoreAd.AdViewHolder adViewHolder2 = this.adViewHolderWeakReference.get();
                if (notValid(str2) || adViewHolder2 == null || (button2 = adViewHolder2.mCreativeButton) == null) {
                    return;
                }
                button2.setText(ConfigSingleton.D().s("点击安装"));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j10, long j11, String str, String str2) {
                Button button2;
                GroMoreAd.AdViewHolder adViewHolder2 = this.adViewHolderWeakReference.get();
                if (notValid(str2) || adViewHolder2 == null || (button2 = adViewHolder2.mCreativeButton) == null) {
                    return;
                }
                button2.setText(ConfigSingleton.D().s("继续下载"));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                Button button2;
                GroMoreAd.AdViewHolder adViewHolder2 = this.adViewHolderWeakReference.get();
                if (notValid(str2) || adViewHolder2 == null || (button2 = adViewHolder2.mCreativeButton) == null) {
                    return;
                }
                button2.setText(ConfigSingleton.D().s("点击打开"));
            }

            public TTAppDownloadListener setAppName(String str) {
                this.appName = str;
                return this;
            }
        }.setAppName(appTask.getComplianceInfo() == null ? "" : appTask.getComplianceInfo().getAppName()));
    }

    public static void bindFlowTempAd(Activity activity, AppTask appTask, d8.a aVar) {
        TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) appTask.origin;
        AdConfig adConfig = AdConfig.toAdConfig(appTask);
        tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.martian.ads.ad.TTAd.16
            final /* synthetic */ AdConfig val$adConfig;

            public AnonymousClass16(AdConfig adConfig2) {
                adConfig = adConfig2;
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i10) {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.l(adConfig);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i10) {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.b(adConfig);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i10) {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.c(adConfig, new c(-1, ""));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f10, float f11) {
            }
        });
        tTNativeExpressAd.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.martian.ads.ad.TTAd.17
            final /* synthetic */ AdConfig val$adConfig;

            public AnonymousClass17(AdConfig adConfig2) {
                adConfig = adConfig2;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onCancel() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onSelected(int i10, String str, boolean z10) {
                d8.a aVar2 = d8.a.this;
                if (aVar2 != null) {
                    aVar2.d(adConfig);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onShow() {
            }
        });
    }

    public void bindFullScreenVideoAd(TTFullScreenVideoAd tTFullScreenVideoAd) {
        tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.martian.ads.ad.TTAd.12
            boolean verify = false;

            public AnonymousClass12() {
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
        tTFullScreenVideoAd.setDownloadListener(new TTAppDownloadListener() { // from class: com.martian.ads.ad.TTAd.13
            public AnonymousClass13() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j10, long j11, String str, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j10, long j11, String str, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j10, String str, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j10, long j11, String str, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
            }
        });
    }

    public void fallback(c cVar) {
        onError(cVar);
    }

    @NonNull
    private static ComplianceInfo getComplianceInfo(com.bytedance.sdk.openadsdk.ComplianceInfo complianceInfo) {
        ComplianceInfo complianceInfo2 = new ComplianceInfo();
        complianceInfo2.setAppName(complianceInfo.getAppName());
        complianceInfo2.setAppVersion(complianceInfo.getAppVersion());
        complianceInfo2.setAppDeveloperName(complianceInfo.getDeveloperName());
        complianceInfo2.setAppPermissionUrl(complianceInfo.getPermissionUrl());
        complianceInfo2.setAppPrivacyUrl(complianceInfo.getPrivacyUrl());
        complianceInfo2.setAppFunctionDescUrl(complianceInfo.getFunctionDescUrl());
        complianceInfo2.setAppPermissions(complianceInfo.getPermissionsMap());
        return complianceInfo2;
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

    public static boolean isTTSplashAd(AppTask appTask) {
        return appTask.origin instanceof CSJSplashAd;
    }

    public static /* synthetic */ void lambda$bindFlowAd$0(View view, float f10, float f11, boolean z10) {
    }

    private void loadBannerAds(TTAdNative tTAdNative) {
        AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(this.adConfig.getAdsId()).setSupportDeepLink(true).setImageAcceptedSize(600, 90).setNativeAdType(1).setAdCount(this.adConfig.getAdsCount());
        if (!l.q(this.adConfig.getPrimeRit())) {
            adCount.setAdloadSeq(this.adConfig.getAdLoadSeq()).setPrimeRit(this.adConfig.getPrimeRit());
        }
        tTAdNative.loadNativeAd(adCount.build(), new TTAdNative.NativeAdListener() { // from class: com.martian.ads.ad.TTAd.5
            public AnonymousClass5() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
            public void onError(int i10, String str) {
                TTAd.this.fallback(new c(i10, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
            public void onNativeAdLoad(List<TTNativeAd> list) {
                if (list == null || list.get(0) == null) {
                    TTAd.this.fallback(null);
                    return;
                }
                Iterator<TTNativeAd> it = list.iterator();
                while (it.hasNext()) {
                    TTAd.this.getAppTaskList().addAppTask(TTAd.this.toAppTask(it.next()));
                }
                TTAd.this.onAdReceived();
            }
        });
    }

    private void loadBannerTemplateAds(Context context, TTAdNative tTAdNative) {
        int W0 = ConfigSingleton.W0(m.i(context));
        if (this.adConfig.getWidth() > 0) {
            W0 = this.adConfig.getWidth();
        }
        AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(this.adConfig.getAdsId()).setSupportDeepLink(true).setImageAcceptedSize(600, 90).setExpressViewAcceptedSize(W0, this.adConfig.getHeight() > 0 ? this.adConfig.getHeight() : 64).setAdCount(this.adConfig.getAdsCount());
        if (!l.q(this.adConfig.getPrimeRit())) {
            adCount.setAdloadSeq(this.adConfig.getAdLoadSeq()).setPrimeRit(this.adConfig.getPrimeRit());
        }
        tTAdNative.loadBannerExpressAd(adCount.build(), new TTAdNative.NativeExpressAdListener() { // from class: com.martian.ads.ad.TTAd.8
            public AnonymousClass8() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i10, String str) {
                TTAd.this.fallback(new c(i10, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                if (list == null || list.isEmpty()) {
                    TTAd.this.fallback(null);
                    return;
                }
                for (TTNativeExpressAd tTNativeExpressAd : list) {
                    AppTask appTask = TTAd.this.adConfig.toAppTask();
                    appTask.origin = tTNativeExpressAd;
                    appTask.customView = new q(tTNativeExpressAd);
                    TTAd.this.getAppTaskList().addAppTask(appTask);
                }
                TTAd.this.onAdReceived();
            }
        });
    }

    private void loadDrawAds(TTAdNative tTAdNative) {
        AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(this.adConfig.getAdsId()).setSupportDeepLink(true).setImageAcceptedSize(640, 320).setAdLoadType(TTAdLoadType.LOAD).setAdCount(this.adConfig.getAdsCount());
        if (!l.q(this.adConfig.getPrimeRit())) {
            adCount.setAdloadSeq(this.adConfig.getAdLoadSeq()).setPrimeRit(this.adConfig.getPrimeRit());
        }
        tTAdNative.loadDrawFeedAd(adCount.build(), new TTAdNative.DrawFeedAdListener() { // from class: com.martian.ads.ad.TTAd.18
            public AnonymousClass18() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
            public void onDrawFeedAdLoad(List<TTDrawFeedAd> list) {
                if (list == null || list.isEmpty()) {
                    TTAd.this.fallback(null);
                    return;
                }
                TTAd.this.getAppTaskList().addAppTask(TTAd.this.toAppTask((TTFeedAd) list.get(0)));
                TTAd.this.onAdReceived();
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
            public void onError(int i10, String str) {
                TTAd.this.fallback(new c(i10, str));
            }
        });
    }

    private void loadFullScreenVideoAd(TTAdNative tTAdNative) {
        tTAdNative.loadFullScreenVideoAd(new AdSlot.Builder().setCodeId(this.adConfig.getAdsId()).setSupportDeepLink(true).setImageAcceptedSize(DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED, 1920).setExpressViewAcceptedSize(500.0f, 500.0f).setUserID(ConfigSingleton.D().y()).setOrientation(1).build(), new TTAdNative.FullScreenVideoAdListener() { // from class: com.martian.ads.ad.TTAd.11
            public AnonymousClass11() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onError(int i10, String str) {
                TTAd.this.fallback(new c(i10, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
                if (tTFullScreenVideoAd == null) {
                    TTAd.this.fallback(null);
                    return;
                }
                TTAd.this.bindFullScreenVideoAd(tTFullScreenVideoAd);
                AppTask appTask = TTAd.this.adConfig.toAppTask();
                appTask.origin = tTFullScreenVideoAd;
                TTAd.this.getAppTaskList().addAppTask(appTask);
                TTAd.this.onAdReceived();
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
            }
        });
    }

    private void loadSplashAds(Context context, TTAdNative tTAdNative) {
        tTAdNative.loadSplashAd(new AdSlot.Builder().setCodeId(this.adConfig.getAdsId()).setImageAcceptedSize(m.i(context), m.h(context)).setAdLoadType(TTAdLoadType.LOAD).setExpressViewAcceptedSize(ConfigSingleton.W0(r0), ConfigSingleton.W0(r4)).build(), new TTAdNative.CSJSplashAdListener() { // from class: com.martian.ads.ad.TTAd.1
            public AnonymousClass1() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashLoadFail(CSJAdError cSJAdError) {
                TTAd.this.fallback(new c(cSJAdError.getCode(), cSJAdError.getMsg()));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashLoadSuccess(CSJSplashAd cSJSplashAd) {
                if (cSJSplashAd == null) {
                    TTAd.this.fallback(null);
                    return;
                }
                AppTask appTask = TTAd.this.adConfig.toAppTask();
                appTask.origin = cSJSplashAd;
                TTAd.this.getAppTaskList().addAppTask(appTask);
                TTAd.this.onAdReceived();
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
                TTAd.this.fallback(new c(cSJAdError.getCode(), cSJAdError.getMsg()));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
            }
        }, 4000);
    }

    private void loadStreamAds(TTAdNative tTAdNative) {
        AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(this.adConfig.getAdsId()).setSupportDeepLink(true).setImageAcceptedSize(640, 320).setAdLoadType(TTAdLoadType.LOAD).setAdCount(this.adConfig.getAdsCount());
        if (!l.q(this.adConfig.getPrimeRit())) {
            adCount.setAdloadSeq(this.adConfig.getAdLoadSeq()).setPrimeRit(this.adConfig.getPrimeRit());
        }
        tTAdNative.loadStream(adCount.build(), new TTAdNative.FeedAdListener() { // from class: com.martian.ads.ad.TTAd.19
            public AnonymousClass19() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onError(int i10, String str) {
                TTAd.this.fallback(new c(i10, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                if (list == null || list.isEmpty()) {
                    TTAd.this.fallback(null);
                    return;
                }
                TTAd.this.getAppTaskList().addAppTask(TTAd.this.toAppTask(list.get(0)));
                TTAd.this.onAdReceived();
            }
        });
    }

    private void loadTemplateAds(TTAdNative tTAdNative) {
        AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(this.adConfig.getAdsId()).setSupportDeepLink(true).setImageAcceptedSize(640, 320).setExpressViewAcceptedSize(this.adConfig.getWidth() <= 0 ? qe.c.f30025o : this.adConfig.getWidth(), this.adConfig.getHeight()).setAdCount(this.adConfig.getAdsCount());
        if (!l.q(this.adConfig.getPrimeRit())) {
            adCount.setAdloadSeq(this.adConfig.getAdLoadSeq()).setPrimeRit(this.adConfig.getPrimeRit());
        }
        tTAdNative.loadNativeExpressAd(adCount.build(), new TTAdNative.NativeExpressAdListener() { // from class: com.martian.ads.ad.TTAd.4
            public AnonymousClass4() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i10, String str) {
                TTAd.this.fallback(new c(i10, "" + i10));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                if (list == null || list.isEmpty()) {
                    TTAd.this.fallback(null);
                    return;
                }
                for (TTNativeExpressAd tTNativeExpressAd : list) {
                    AppTask appTask = TTAd.this.adConfig.toAppTask();
                    appTask.origin = tTNativeExpressAd;
                    appTask.isVideoAd = true;
                    appTask.customView = new q(tTNativeExpressAd);
                    TTAd.this.getAppTaskList().addAppTask(appTask);
                }
                TTAd.this.onAdReceived();
            }
        });
    }

    private void loadVideoAd(TTAdNative tTAdNative) {
        tTAdNative.loadRewardVideoAd(new AdSlot.Builder().setCodeId(this.adConfig.getAdsId()).setSupportDeepLink(true).setImageAcceptedSize(DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED, 1920).setExpressViewAcceptedSize(500.0f, 500.0f).setUserID(ConfigSingleton.D().y()).setOrientation(1).build(), new TTAdNative.RewardVideoAdListener() { // from class: com.martian.ads.ad.TTAd.9
            public AnonymousClass9() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onError(int i10, String str) {
                TTAd.this.fallback(new c(i10, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
                if (tTRewardVideoAd == null) {
                    TTAd.this.fallback(null);
                    return;
                }
                AppTask appTask = TTAd.this.adConfig.toAppTask();
                appTask.origin = tTRewardVideoAd;
                TTAd.this.getAppTaskList().addAppTask(appTask);
                TTAd.this.onAdReceived();
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
            }
        });
    }

    public static void showFullScreenVideoAd(Activity activity, @NonNull TTFullScreenVideoAd tTFullScreenVideoAd) {
        tTFullScreenVideoAd.showFullScreenVideoAd(activity);
    }

    public static void showSplashAd(AppTask appTask, ViewGroup viewGroup, d8.b bVar) {
        CSJSplashAd cSJSplashAd = (CSJSplashAd) appTask.origin;
        cSJSplashAd.setSplashAdListener(new CSJSplashAd.SplashAdListener() { // from class: com.martian.ads.ad.TTAd.2
            final /* synthetic */ AdConfig val$adConfig;

            public AnonymousClass2(AdConfig adConfig) {
                adConfig = adConfig;
            }

            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdClick(CSJSplashAd cSJSplashAd2) {
                d8.b bVar2 = d8.b.this;
                if (bVar2 != null) {
                    bVar2.l(adConfig);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdClose(CSJSplashAd cSJSplashAd2, int i10) {
                d8.b bVar2 = d8.b.this;
                if (bVar2 != null) {
                    bVar2.d(adConfig);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdShow(CSJSplashAd cSJSplashAd2) {
                d8.b bVar2 = d8.b.this;
                if (bVar2 != null) {
                    bVar2.b(adConfig);
                }
            }
        });
        cSJSplashAd.showSplashView(viewGroup);
    }

    public static void showVideoAd(Activity activity, AppTask appTask, d8.b bVar) {
        TTRewardVideoAd tTRewardVideoAd = (TTRewardVideoAd) appTask.origin;
        tTRewardVideoAd.setRewardAdInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.martian.ads.ad.TTAd.10
            final /* synthetic */ AdConfig val$adConfig;
            private boolean exposed = false;
            private boolean clicked = false;
            private boolean verify = false;

            public AnonymousClass10(AdConfig adConfig) {
                adConfig = adConfig;
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdClose() {
                if (d8.b.this != null) {
                    p0.c("adtag", "onAdClose verify:" + this.verify);
                    d8.b.this.d(adConfig);
                    d8.b.this.k(adConfig, this.verify);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdShow() {
                if (this.exposed) {
                    return;
                }
                this.exposed = true;
                d8.b bVar2 = d8.b.this;
                if (bVar2 != null) {
                    bVar2.b(adConfig);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdVideoBarClick() {
                if (this.clicked) {
                    return;
                }
                this.clicked = true;
                d8.b bVar2 = d8.b.this;
                if (bVar2 != null) {
                    bVar2.l(adConfig);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onRewardArrived(boolean z10, int i10, Bundle bundle) {
                this.verify = z10;
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify(boolean z10, int i10, String str, int i11, String str2) {
                this.verify = z10;
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onSkippedVideo() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onVideoComplete() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onVideoError() {
                d8.b bVar2 = d8.b.this;
                if (bVar2 != null) {
                    bVar2.c(adConfig, new c(-1, "失败"));
                }
            }
        });
        tTRewardVideoAd.showRewardVideoAd(activity);
    }

    public AppTask toAppTask(TTFeedAd tTFeedAd) {
        String str;
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = tTFeedAd;
        appTask.title = ConfigSingleton.D().s(tTFeedAd.getTitle());
        appTask.desc = ConfigSingleton.D().s(tTFeedAd.getDescription());
        if (tTFeedAd.getMediaExtraInfo() != null) {
            try {
                Map<String, Object> mediaExtraInfo = tTFeedAd.getMediaExtraInfo();
                Integer num = (Integer) mediaExtraInfo.get("if_ecbudget");
                if (num != null && num.intValue() == 1) {
                    String str2 = (String) mediaExtraInfo.get("discount_info");
                    if (!l.q(str2)) {
                        appTask.appPromote = str2;
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (l.q(appTask.appPromote)) {
            if (tTFeedAd.getAppCommentNum() > 0) {
                appTask.appPromote = ConfigSingleton.D().s(appTask.getNumbers(tTFeedAd.getAppCommentNum() * 10) + "人下载");
            } else if (tTFeedAd.getAppScore() > 0) {
                appTask.appPromote = tTFeedAd.getAppScore() + "分";
            } else {
                appTask.appPromote = ConfigSingleton.D().s("赞助正版章节");
            }
        }
        if (tTFeedAd.getIcon() == null || l.q(tTFeedAd.getIcon().getImageUrl())) {
            str = "";
        } else {
            str = tTFeedAd.getIcon().getImageUrl();
            appTask.iconUrl = str;
        }
        List<TTImage> imageList = tTFeedAd.getImageList();
        if (imageList != null && !imageList.isEmpty()) {
            for (TTImage tTImage : imageList) {
                if (!appTask.getPosterUrls().isEmpty() && l.q(appTask.iconUrl)) {
                    appTask.iconUrl = tTImage.getImageUrl();
                }
                appTask.addPosterUrl(tTImage.getImageUrl());
            }
        } else if (!l.q(str)) {
            appTask.addPosterUrl(str);
        }
        if (l.q(appTask.iconUrl)) {
            appTask.iconUrl = appTask.getPosterUrl();
        }
        if (tTFeedAd.getInteractionType() == 4) {
            appTask.buttonText = ConfigSingleton.D().s("立即下载");
            com.bytedance.sdk.openadsdk.ComplianceInfo complianceInfo = tTFeedAd.getComplianceInfo();
            if (complianceInfo != null && !l.q(complianceInfo.getAppName()) && !l.q(complianceInfo.getDeveloperName()) && !l.q(complianceInfo.getPrivacyUrl())) {
                appTask.setComplianceInfo(getComplianceInfo(complianceInfo));
            }
        } else if (tTFeedAd.getInteractionType() == 5) {
            appTask.buttonText = ConfigSingleton.D().s("立即拨打");
        } else if (!l.q(tTFeedAd.getButtonText())) {
            appTask.buttonText = ConfigSingleton.D().s(tTFeedAd.getButtonText());
        }
        if (tTFeedAd.getComplianceInfo() != null) {
            appTask.name = tTFeedAd.getComplianceInfo().getAppName();
        }
        appTask.setPicWidth(tTFeedAd.getAdViewWidth());
        appTask.setPicHeight(tTFeedAd.getAdViewHeight());
        if (tTFeedAd.getAdView() != null) {
            appTask.isVideoAd = true;
            appTask.videoView = new ViewWrapper(tTFeedAd.getAdView());
        }
        return appTask;
    }

    @Override // com.martian.ads.ad.BaseAd
    public void loadAds(Context context) {
        TTAdNative createAdNative;
        onAdRequest();
        createAdNative = p.a().createAdNative(context);
        String type = this.adConfig.getType();
        type.hashCode();
        switch (type) {
            case "banner_tt":
                loadBannerAds(createAdNative);
                break;
            case "banner":
                loadBannerTemplateAds(context, createAdNative);
                break;
            case "express":
                loadTemplateAds(createAdNative);
                break;
            case "native":
                loadFlowAds(context, createAdNative);
                break;
            case "splash":
                loadSplashAds(context, createAdNative);
                break;
            case "stream":
                loadStreamAds(createAdNative);
                break;
            case "full_video":
                loadFullScreenVideoAd(createAdNative);
                break;
            case "draw":
                loadDrawAds(createAdNative);
                break;
            case "reward_video":
                loadVideoAd(createAdNative);
                break;
            default:
                onError(null);
                break;
        }
    }

    public void loadFlowAds(Context context, TTAdNative tTAdNative) {
        AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(this.adConfig.getAdsId()).setSupportDeepLink(true).setImageAcceptedSize(640, 320).setAdCount(this.adConfig.getAdsCount());
        if (!l.q(this.adConfig.getPrimeRit())) {
            adCount.setAdloadSeq(this.adConfig.getAdLoadSeq()).setPrimeRit(this.adConfig.getPrimeRit());
        }
        if (this.adConfig.isExpress()) {
            adCount.supportRenderControl().setExpressViewAcceptedSize(ConfigSingleton.W0(m.i(context)) - 32, 0.0f);
        }
        tTAdNative.loadFeedAd(adCount.build(), new TTAdNative.FeedAdListener() { // from class: com.martian.ads.ad.TTAd.3
            public AnonymousClass3() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onError(int i10, String str) {
                TTAd.this.fallback(new c(i10, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                if (list == null || list.isEmpty()) {
                    TTAd.this.fallback(null);
                    return;
                }
                TTAd.this.getAppTaskList().addAppTask(TTAd.this.toAppTask(list.get(0)));
                TTAd.this.onAdReceived();
            }
        });
    }

    public AppTask toAppTask(TTNativeAd tTNativeAd) {
        String str;
        AppTask appTask = this.adConfig.toAppTask();
        appTask.origin = tTNativeAd;
        appTask.title = ConfigSingleton.D().s(tTNativeAd.getTitle());
        appTask.desc = ConfigSingleton.D().s(tTNativeAd.getDescription());
        if (tTNativeAd.getAppCommentNum() > 0) {
            appTask.appPromote = ConfigSingleton.D().s(appTask.getNumbers(tTNativeAd.getAppCommentNum() * 10) + "人下载");
        } else if (tTNativeAd.getAppScore() > 0) {
            appTask.appPromote = tTNativeAd.getAppScore() + "分";
        } else {
            appTask.appPromote = ConfigSingleton.D().s("赞助正版章节");
        }
        if (tTNativeAd.getIcon() != null && !l.q(tTNativeAd.getIcon().getImageUrl())) {
            str = tTNativeAd.getIcon().getImageUrl();
            appTask.iconUrl = str;
        } else {
            str = "";
        }
        List<TTImage> imageList = tTNativeAd.getImageList();
        if (imageList != null && !imageList.isEmpty()) {
            for (TTImage tTImage : imageList) {
                if (!appTask.getPosterUrls().isEmpty() && l.q(appTask.iconUrl)) {
                    appTask.iconUrl = tTImage.getImageUrl();
                }
                appTask.addPosterUrl(tTImage.getImageUrl());
            }
        } else if (!l.q(str)) {
            appTask.addPosterUrl(str);
        }
        if (l.q(appTask.iconUrl)) {
            appTask.iconUrl = appTask.getPosterUrl();
        }
        if (!l.q(tTNativeAd.getButtonText())) {
            appTask.buttonText = ConfigSingleton.D().s(tTNativeAd.getButtonText());
        } else if (tTNativeAd.getInteractionType() == 4) {
            appTask.buttonText = ConfigSingleton.D().s("立即下载");
        } else if (tTNativeAd.getInteractionType() == 5) {
            appTask.buttonText = ConfigSingleton.D().s("立即拨打");
        }
        if (tTNativeAd.getComplianceInfo() != null) {
            appTask.name = tTNativeAd.getComplianceInfo().getAppName();
        }
        if (tTNativeAd.getImageMode() == 5 && tTNativeAd.getAdView() != null) {
            appTask.isVideoAd = true;
            appTask.videoView = new ViewWrapper(tTNativeAd.getAdView());
        }
        return appTask;
    }
}
