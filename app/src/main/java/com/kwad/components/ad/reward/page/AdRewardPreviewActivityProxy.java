package com.kwad.components.ad.reward.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.h;
import com.kwad.components.ad.reward.j.b;
import com.kwad.components.ad.reward.model.RewardCallBackRespInfo;
import com.kwad.components.ad.reward.widget.HandSlideView;
import com.kwad.components.ad.reward.widget.RewardPreviewTopBarView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.core.proxy.f;
import com.kwad.components.core.request.e;
import com.kwad.components.core.s.h;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.bt;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes2.dex */
public class AdRewardPreviewActivityProxy extends f implements HandSlideView.a {
    public static final String KEY_TEMPLATE = "key_template_json";
    private static final String KEY_URL = "key_langingpage_url";
    private static final String TAG = "AdRewardPreviewActivityProxy";
    public static KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    public h mCloseDialog;
    private int mCount;
    private com.kwad.components.core.s.h mCountdownHelper;
    private long mCurrentDuration;
    private View mHandSlideContainer;

    @Nullable
    private HandSlideView mHandSlideView;
    private long mLastDown;
    protected KsLogoView mLogoView;
    private int mSkipCount;
    private long mStartPlayTime;
    private bs mTimerHelper;
    private RewardPreviewTopBarView mTopBarView;
    private String mUrl;
    private AdBaseFrameLayout mWebContainer;
    private boolean mHadAdClicked = false;
    private boolean mCheckExposureResult = true;
    private long mPageEnterTime = 0;
    private boolean mReportedPageShow = false;

    /* renamed from: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy$1 */
    public class AnonymousClass1 implements View.OnTouchListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                AdRewardPreviewActivityProxy.this.mLastDown = SystemClock.elapsedRealtime();
                return false;
            }
            if (motionEvent.getAction() != 1) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - AdRewardPreviewActivityProxy.this.mLastDown;
            if (AdRewardPreviewActivityProxy.this.mLastDown > 0 && elapsedRealtime > 60 && elapsedRealtime < 500) {
                AdRewardPreviewActivityProxy.this.handleAdClick();
            }
            AdRewardPreviewActivityProxy.this.mLastDown = 0L;
            return false;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy$2 */
    public class AnonymousClass2 implements h.a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.s.h.a
        public final void onProgress(long j10, long j11) {
            c.d(AdRewardPreviewActivityProxy.TAG, "onProgress currentDuration: " + j10 + " , totalDuration: " + j11);
            AdRewardPreviewActivityProxy.this.mCurrentDuration = j10;
            AdRewardPreviewActivityProxy.this.mTopBarView.n(j10);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy$3 */
    public class AnonymousClass3 implements RewardPreviewTopBarView.a {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.reward.widget.RewardPreviewTopBarView.a
        public final void G(boolean z10) {
            if (z10) {
                AdRewardPreviewActivityProxy.this.handleEndClose();
            } else {
                AdRewardPreviewActivityProxy.this.showCloseDialog();
            }
        }

        @Override // com.kwad.components.ad.reward.widget.RewardPreviewTopBarView.a
        public final void H(boolean z10) {
            if (z10) {
                return;
            }
            AdRewardPreviewActivityProxy.this.handleCountdownEnd();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy$4 */
    public class AnonymousClass4 implements KsAdWebView.e {
        public AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onPageFinished() {
            com.kwad.components.ad.reward.monitor.c.b(true, AdRewardPreviewActivityProxy.this.mAdTemplate, AdRewardPreviewActivityProxy.this.mPageEnterTime);
            com.kwad.components.ad.reward.monitor.c.P(AdRewardPreviewActivityProxy.this.mAdTemplate);
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onPageStart() {
            com.kwad.components.ad.reward.monitor.c.O(AdRewardPreviewActivityProxy.this.mAdTemplate);
            if (!AdRewardPreviewActivityProxy.this.mAdTemplate.mPvReported) {
                AdRewardPreviewActivityProxy.this.checkExposure();
            }
            if (!AdRewardPreviewActivityProxy.this.mHadAdClicked) {
                AdRewardPreviewActivityProxy.this.showHandSlideMask();
            }
            a.C0484a c0484a = new a.C0484a();
            c0484a.asB = "award_view";
            b.a(true, AdRewardPreviewActivityProxy.this.mAdTemplate, null, new com.kwad.sdk.core.adlog.c.b().b(c0484a));
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onReceivedHttpError(int i10, String str, String str2) {
            com.kwad.components.ad.reward.monitor.c.c(AdRewardPreviewActivityProxy.this.mAdTemplate, i10, str);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy$5 */
    public class AnonymousClass5 implements Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AdRewardPreviewActivityProxy.this.checkRequest(1);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy$6 */
    public class AnonymousClass6 extends l<e, RewardCallBackRespInfo> {
        final /* synthetic */ int rK;

        public AnonymousClass6(int i10) {
            i10 = i10;
        }

        @NonNull
        private static RewardCallBackRespInfo F(String str) {
            JSONObject jSONObject = new JSONObject(str);
            RewardCallBackRespInfo rewardCallBackRespInfo = new RewardCallBackRespInfo();
            rewardCallBackRespInfo.parseJson(jSONObject);
            return rewardCallBackRespInfo;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: gG */
        public e createRequest() {
            return new e(i10, AdRewardPreviewActivityProxy.this.mAdTemplate);
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ RewardCallBackRespInfo parseData(String str) {
            return F(str);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy$7 */
    public class AnonymousClass7 extends o<e, RewardCallBackRespInfo> {
        public AnonymousClass7() {
        }

        private void a(@NonNull RewardCallBackRespInfo rewardCallBackRespInfo) {
            AdRewardPreviewActivityProxy.this.mCheckExposureResult = rewardCallBackRespInfo.result == 1;
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* bridge */ /* synthetic */ void onStartRequest(@NonNull com.kwad.sdk.core.network.f fVar) {
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
            a((RewardCallBackRespInfo) baseResultData);
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onError(@NonNull e eVar, int i10, String str) {
            super.onError(eVar, i10, str);
            AdRewardPreviewActivityProxy.this.mCheckExposureResult = false;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy$8 */
    public class AnonymousClass8 extends h.b {
        public AnonymousClass8() {
        }

        @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
        public final void G(boolean z10) {
            a.a(AdRewardPreviewActivityProxy.mInteractionListener, System.currentTimeMillis() - AdRewardPreviewActivityProxy.this.mStartPlayTime);
            com.kwad.sdk.core.adlog.c.a(AdRewardPreviewActivityProxy.this.mAdTemplate, 1, AdRewardPreviewActivityProxy.this.getTimerHelper().getTime(), (JSONObject) null);
            AdRewardPreviewActivityProxy.this.finish();
        }

        @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
        public final void gl() {
            if (AdRewardPreviewActivityProxy.this.mCountdownHelper != null) {
                AdRewardPreviewActivityProxy.this.mCountdownHelper.pause();
            }
        }

        @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
        public final void gu() {
            if (AdRewardPreviewActivityProxy.this.mCountdownHelper != null) {
                AdRewardPreviewActivityProxy.this.mCountdownHelper.resume();
            }
        }
    }

    public static class a {
        public static void a(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, long j10) {
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onVideoSkipToEnd(j10);
                } catch (Throwable th2) {
                    c.printStackTraceOnly(th2);
                }
            }
        }

        public static void c(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onRewardVerify();
                try {
                    rewardAdInteractionListener.onRewardStepVerify(0, 0);
                } catch (Throwable th2) {
                    c.printStackTraceOnly(th2);
                }
            }
        }

        public static void d(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onVideoPlayEnd();
                } catch (Throwable th2) {
                    c.printStackTraceOnly(th2);
                }
            }
        }

        public static void e(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onPageDismiss();
                } catch (Throwable th2) {
                    c.printStackTraceOnly(th2);
                }
            }
        }

        public static void f(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onAdClicked();
                } catch (Throwable th2) {
                    c.printStackTraceOnly(th2);
                }
            }
        }
    }

    public void checkRequest(int i10) {
        new l<e, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.6
            final /* synthetic */ int rK;

            public AnonymousClass6(int i102) {
                i10 = i102;
            }

            @NonNull
            private static RewardCallBackRespInfo F(String str) {
                JSONObject jSONObject = new JSONObject(str);
                RewardCallBackRespInfo rewardCallBackRespInfo = new RewardCallBackRespInfo();
                rewardCallBackRespInfo.parseJson(jSONObject);
                return rewardCallBackRespInfo;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: gG */
            public e createRequest() {
                return new e(i10, AdRewardPreviewActivityProxy.this.mAdTemplate);
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ RewardCallBackRespInfo parseData(String str) {
                return F(str);
            }
        }.request(exposureRequest());
    }

    private void closeHandSlideMask() {
        HandSlideView handSlideView = this.mHandSlideView;
        if (handSlideView != null) {
            handSlideView.destroy();
            this.mHandSlideView = null;
        }
        View view = this.mHandSlideContainer;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private o<e, RewardCallBackRespInfo> exposureRequest() {
        return new o<e, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.7
            public AnonymousClass7() {
            }

            private void a(@NonNull RewardCallBackRespInfo rewardCallBackRespInfo) {
                AdRewardPreviewActivityProxy.this.mCheckExposureResult = rewardCallBackRespInfo.result == 1;
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* bridge */ /* synthetic */ void onStartRequest(@NonNull com.kwad.sdk.core.network.f fVar) {
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                a((RewardCallBackRespInfo) baseResultData);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onError(@NonNull e eVar, int i10, String str) {
                super.onError(eVar, i10, str);
                AdRewardPreviewActivityProxy.this.mCheckExposureResult = false;
            }
        };
    }

    private KsAdWebView.e getWebErrorListener() {
        return new KsAdWebView.e() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.4
            public AnonymousClass4() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                com.kwad.components.ad.reward.monitor.c.b(true, AdRewardPreviewActivityProxy.this.mAdTemplate, AdRewardPreviewActivityProxy.this.mPageEnterTime);
                com.kwad.components.ad.reward.monitor.c.P(AdRewardPreviewActivityProxy.this.mAdTemplate);
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
                com.kwad.components.ad.reward.monitor.c.O(AdRewardPreviewActivityProxy.this.mAdTemplate);
                if (!AdRewardPreviewActivityProxy.this.mAdTemplate.mPvReported) {
                    AdRewardPreviewActivityProxy.this.checkExposure();
                }
                if (!AdRewardPreviewActivityProxy.this.mHadAdClicked) {
                    AdRewardPreviewActivityProxy.this.showHandSlideMask();
                }
                a.C0484a c0484a = new a.C0484a();
                c0484a.asB = "award_view";
                b.a(true, AdRewardPreviewActivityProxy.this.mAdTemplate, null, new com.kwad.sdk.core.adlog.c.b().b(c0484a));
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i10, String str, String str2) {
                com.kwad.components.ad.reward.monitor.c.c(AdRewardPreviewActivityProxy.this.mAdTemplate, i10, str);
            }
        };
    }

    public void handleAdClick() {
        this.mHadAdClicked = true;
        a.C0484a c0484a = new a.C0484a();
        c0484a.asB = "award_view";
        b.a(this.mAdTemplate, (String) null, "nativePreview", new com.kwad.sdk.core.adlog.c.b().cL(72).b(c0484a).f(this.mWebContainer.getTouchCoords()), (JSONObject) null);
        closeHandSlideMask();
        a.f(mInteractionListener);
    }

    public void handleCountdownEnd() {
        if (this.mCheckExposureResult) {
            a.c(mInteractionListener);
        }
    }

    public void handleEndClose() {
        a.d(mInteractionListener);
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, 1, getTimerHelper().getTime(), (JSONObject) null);
        finish();
    }

    public static void launch(Activity activity, AdResultData adResultData, AdTemplate adTemplate, String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        com.kwad.components.ad.reward.monitor.c.i(true, adTemplate);
        boolean Eh = d.Eh();
        mInteractionListener = rewardAdInteractionListener;
        com.kwad.sdk.service.b.a(AdWebViewActivity.class, AdRewardPreviewActivityProxy.class);
        Intent intent = new Intent(activity, (Class<?>) AdWebViewActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(KEY_URL, str);
        if (Eh) {
            intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.nt().j(adResultData));
        } else {
            intent.putExtra("key_template_json", adTemplate.toJson().toString());
        }
        try {
            activity.startActivity(intent);
            if (!Eh) {
                activity.overridePendingTransition(0, 0);
            }
        } catch (Exception e10) {
            ServiceProvider.reportSdkCaughtException(e10);
            com.kwad.components.ad.reward.monitor.c.a(true, adTemplate, PageCreateStage.ERROR_START_ACTIVITY.getStage(), e10.getMessage());
        }
        com.kwad.components.ad.reward.monitor.c.c(true, adTemplate, PageCreateStage.END_LAUNCH.getStage());
    }

    private void reportSubPageCreate(String str) {
        com.kwad.components.ad.reward.monitor.c.c(true, this.mAdTemplate, str);
    }

    public void showCloseDialog() {
        com.kwad.components.ad.reward.h hVar = this.mCloseDialog;
        if (hVar == null || !hVar.isShowing()) {
            int ceil = (int) Math.ceil(this.mCurrentDuration / 1000.0f);
            this.mCloseDialog = com.kwad.components.ad.reward.h.a(getActivity(), this.mAdTemplate, com.kwad.components.ad.reward.h.g("还差" + ceil + "秒就可以获取奖励", ceil), new h.b() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.8
                public AnonymousClass8() {
                }

                @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
                public final void G(boolean z10) {
                    a.a(AdRewardPreviewActivityProxy.mInteractionListener, System.currentTimeMillis() - AdRewardPreviewActivityProxy.this.mStartPlayTime);
                    com.kwad.sdk.core.adlog.c.a(AdRewardPreviewActivityProxy.this.mAdTemplate, 1, AdRewardPreviewActivityProxy.this.getTimerHelper().getTime(), (JSONObject) null);
                    AdRewardPreviewActivityProxy.this.finish();
                }

                @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
                public final void gl() {
                    if (AdRewardPreviewActivityProxy.this.mCountdownHelper != null) {
                        AdRewardPreviewActivityProxy.this.mCountdownHelper.pause();
                    }
                }

                @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
                public final void gu() {
                    if (AdRewardPreviewActivityProxy.this.mCountdownHelper != null) {
                        AdRewardPreviewActivityProxy.this.mCountdownHelper.resume();
                    }
                }
            });
        }
    }

    public void showHandSlideMask() {
        HandSlideView handSlideView = this.mHandSlideView;
        if (handSlideView == null || handSlideView.isStarted()) {
            return;
        }
        this.mHandSlideContainer.setVisibility(0);
        this.mHandSlideView.a(this);
    }

    public void checkExposure() {
        long j10 = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate).adRewardInfo.callBackStrategyInfo.impressionCheckMs;
        if (j10 <= 0 || com.kwad.sdk.core.response.b.a.ag(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate)) <= 5000) {
            return;
        }
        bt.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.5
            public AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                AdRewardPreviewActivityProxy.this.checkRequest(1);
            }
        }, j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0042 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0043 A[RETURN] */
    @Override // com.kwad.components.core.proxy.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkIntentData(@androidx.annotation.Nullable android.content.Intent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "key_ad_result_cache_idx"
            r1 = 1
            r2 = 0
            if (r5 == 0) goto L21
            boolean r3 = r5.hasExtra(r0)     // Catch: java.lang.Throwable -> L1f
            if (r3 == 0) goto L21
            int r5 = r5.getIntExtra(r0, r2)     // Catch: java.lang.Throwable -> L1f
            com.kwad.components.core.c.f r0 = com.kwad.components.core.c.f.nt()     // Catch: java.lang.Throwable -> L1f
            com.kwad.sdk.core.response.model.AdResultData r5 = r0.d(r5, r1)     // Catch: java.lang.Throwable -> L1f
            com.kwad.sdk.core.response.model.AdTemplate r5 = r5.getFirstAdTemplate()     // Catch: java.lang.Throwable -> L1f
            r4.mAdTemplate = r5     // Catch: java.lang.Throwable -> L1f
            goto L3e
        L1f:
            r5 = move-exception
            goto L3b
        L21:
            android.content.Intent r5 = r4.getIntent()     // Catch: java.lang.Throwable -> L1f
            java.lang.String r0 = "key_template_json"
            java.lang.String r5 = r5.getStringExtra(r0)     // Catch: java.lang.Throwable -> L1f
            com.kwad.sdk.core.response.model.AdTemplate r0 = new com.kwad.sdk.core.response.model.AdTemplate     // Catch: java.lang.Throwable -> L1f
            r0.<init>()     // Catch: java.lang.Throwable -> L1f
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L1f
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L1f
            r0.parseJson(r3)     // Catch: java.lang.Throwable -> L1f
            r4.mAdTemplate = r0     // Catch: java.lang.Throwable -> L1f
            goto L3e
        L3b:
            com.kwad.sdk.core.d.c.printStackTrace(r5)
        L3e:
            com.kwad.sdk.core.response.model.AdTemplate r5 = r4.mAdTemplate
            if (r5 != 0) goto L43
            return r2
        L43:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.checkIntentData(android.content.Intent):boolean");
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        return R.layout.ksad_activity_reward_preview;
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return TAG;
    }

    public bs getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bs();
        }
        return this.mTimerHelper;
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        this.mUrl = getIntent().getStringExtra(KEY_URL);
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
        int i10 = eb2.adStyleInfo.adBrowseInfo.adBrowseDuration;
        int ae2 = com.kwad.sdk.core.response.b.a.ae(eb2);
        this.mCount = i10;
        this.mSkipCount = Math.min(ae2, i10);
        this.mStartPlayTime = System.currentTimeMillis();
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
        if (rewardAdInteractionListener != null) {
            try {
                rewardAdInteractionListener.onVideoPlayStart();
            } catch (Throwable th2) {
                c.printStackTraceOnly(th2);
            }
        }
    }

    @Override // com.kwad.components.core.proxy.f
    @SuppressLint({"SetTextI18n"})
    public void initView() {
        KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
        this.mAdWebView = ksAdWebView;
        this.mAdWebView.setClientConfig(ksAdWebView.getClientConfig().ex(this.mAdTemplate).bx(true).bz(true).bv(true).b(getWebErrorListener()));
        this.mAdWebView.onActivityCreate();
        this.mWebContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_preview_webview_container);
        KsLogoView ksLogoView = (KsLogoView) findViewById(R.id.ksad_reward_preview_logo);
        this.mLogoView = ksLogoView;
        ksLogoView.aK(this.mAdTemplate);
        this.mHandSlideContainer = findViewById(R.id.ksad_reward_preview_hand_slide_container);
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
        if (this.mUrl != null) {
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aF(eb2) && d.Dq() && al.isWifiConnected(getActivity())) {
                cVar.r(new a.C0427a(getActivity()).ap(false).aq(false).au(this.mAdTemplate).as(false));
            }
        }
        this.mAdWebView.loadUrl(!TextUtils.isEmpty(this.mUrl) ? this.mUrl : com.kwad.sdk.core.response.b.a.aS(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate)));
        getTimerHelper().startTiming();
        this.mWebContainer.a(new View.OnTouchListener() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    AdRewardPreviewActivityProxy.this.mLastDown = SystemClock.elapsedRealtime();
                    return false;
                }
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime() - AdRewardPreviewActivityProxy.this.mLastDown;
                if (AdRewardPreviewActivityProxy.this.mLastDown > 0 && elapsedRealtime > 60 && elapsedRealtime < 500) {
                    AdRewardPreviewActivityProxy.this.handleAdClick();
                }
                AdRewardPreviewActivityProxy.this.mLastDown = 0L;
                return false;
            }
        });
        this.mHandSlideView = (HandSlideView) findViewById(R.id.ksad_reward_preview_hand_slide);
        com.kwad.components.core.s.h hVar = new com.kwad.components.core.s.h(this.mCount * 1000);
        this.mCountdownHelper = hVar;
        hVar.a(new h.a() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.s.h.a
            public final void onProgress(long j10, long j11) {
                c.d(AdRewardPreviewActivityProxy.TAG, "onProgress currentDuration: " + j10 + " , totalDuration: " + j11);
                AdRewardPreviewActivityProxy.this.mCurrentDuration = j10;
                AdRewardPreviewActivityProxy.this.mTopBarView.n(j10);
            }
        });
        this.mCountdownHelper.start();
        RewardPreviewTopBarView rewardPreviewTopBarView = (RewardPreviewTopBarView) findViewById(R.id.ksad_reward_preview_topbar);
        this.mTopBarView = rewardPreviewTopBarView;
        rewardPreviewTopBarView.setTotalCountDuration(this.mCount * 1000);
        this.mTopBarView.setRewardTips(com.kwad.sdk.core.response.b.a.cf(eb2));
        this.mTopBarView.setCloseBtnDelayShowDuration(this.mSkipCount * 1000);
        this.mTopBarView.setTopBarListener(new RewardPreviewTopBarView.a() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.components.ad.reward.widget.RewardPreviewTopBarView.a
            public final void G(boolean z10) {
                if (z10) {
                    AdRewardPreviewActivityProxy.this.handleEndClose();
                } else {
                    AdRewardPreviewActivityProxy.this.showCloseDialog();
                }
            }

            @Override // com.kwad.components.ad.reward.widget.RewardPreviewTopBarView.a
            public final void H(boolean z10) {
                if (z10) {
                    return;
                }
                AdRewardPreviewActivityProxy.this.handleCountdownEnd();
            }
        });
    }

    @Override // com.kwad.components.core.proxy.f
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.d.c.bG(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        try {
            KsAdWebView ksAdWebView = this.mAdWebView;
            if (ksAdWebView != null && ksAdWebView.canGoBack()) {
                this.mAdWebView.goBack();
                com.kwad.sdk.core.adlog.c.bU(this.mAdTemplate);
                return;
            }
            RewardPreviewTopBarView rewardPreviewTopBarView = this.mTopBarView;
            if (rewardPreviewTopBarView == null || !rewardPreviewTopBarView.kz()) {
                showCloseDialog();
                return;
            }
            super.onBackPressed();
            a.d(mInteractionListener);
            com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, 11, getTimerHelper().getTime(), (JSONObject) null);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        try {
            super.onCreate(bundle);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mPageEnterTime = elapsedRealtime;
            com.kwad.components.ad.reward.monitor.c.a(true, this.mAdTemplate, elapsedRealtime);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @Override // com.kwad.components.core.proxy.f
    public void onCreateCaughtException(Throwable th2) {
        super.onCreateCaughtException(th2);
        com.kwad.components.ad.reward.monitor.b.b(true, this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.components.core.proxy.a.c
    public void onCreateStageChange(PageCreateStage pageCreateStage) {
        super.onCreateStageChange(pageCreateStage);
        reportSubPageCreate(pageCreateStage.getStage());
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        a.e(mInteractionListener);
        mInteractionListener = null;
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.onActivityDestroy();
            this.mAdWebView = null;
        }
        com.kwad.components.core.s.h hVar = this.mCountdownHelper;
        if (hVar != null) {
            hVar.stop();
        }
        super.onDestroy();
    }

    @Override // com.kwad.components.ad.reward.widget.HandSlideView.a
    public void onHandSlideLoopEnd() {
        closeHandSlideMask();
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
        getTimerHelper().Po();
        com.kwad.components.core.s.h hVar = this.mCountdownHelper;
        if (hVar != null) {
            hVar.pause();
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        getTimerHelper().Pn();
        com.kwad.components.core.s.h hVar = this.mCountdownHelper;
        if (hVar != null) {
            hVar.resume();
        }
        if (this.mReportedPageShow) {
            return;
        }
        com.kwad.components.ad.reward.monitor.c.f(true, this.mAdTemplate);
        this.mReportedPageShow = true;
    }
}
