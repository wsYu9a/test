package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.o;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.r.c;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsRewardVideoActivity;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bi;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.HashMap;

@KsAdSdkDynamicImpl(KsRewardVideoActivity.class)
@Keep
/* loaded from: classes.dex */
public class KSRewardVideoActivityProxy extends com.kwad.components.core.j.b<j> implements com.kwad.components.ad.reward.g.c, j.b, o.a, c.b, j.a, OnAdLiveResumeInterceptor {
    public static final String KEY_REWARD_TYPE = "key_template_reward_type";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_TEMPLATE_PLAY_AGAIN = "key_template_json_play_again";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    private static final String TAG = "RewardVideo";
    private String listenerKey;
    private DetailVideoView mDetailVideoView;
    private boolean mIsBackEnable;
    private com.kwad.components.ad.reward.model.c mModel;
    private boolean mPageDismissCalled;
    private long mPageEnterTime;
    private FrameLayout mPlayLayout;
    private long mPlayTime;
    private o mRewardPresenter;
    private AdBaseFrameLayout mRootContainer;
    private bh mTimerHelper;
    private boolean mIsFinishVideoLookStep = false;
    private final com.kwad.components.ad.reward.d.j mRewardVerifyListener = new com.kwad.components.ad.reward.d.j() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            if (KSRewardVideoActivityProxy.this.mModel.hl() && ((j) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult && ((j) KSRewardVideoActivityProxy.this.mCallerContext).pn != 2) {
                KSRewardVideoActivityProxy.this.markOpenNsCompleted();
                KSRewardVideoActivityProxy.this.notifyRewardVerify();
                KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
            }
        }
    };
    private com.kwad.components.ad.reward.d.f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.6
        AnonymousClass6() {
        }

        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            KSRewardVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    private com.kwad.components.ad.reward.d.d mAdRewardStepListener = new com.kwad.components.ad.reward.d.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.7
        AnonymousClass7() {
        }

        @Override // com.kwad.components.ad.reward.d.d
        public final void fo() {
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    };
    private com.kwad.components.core.video.i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.8
        AnonymousClass8() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            KSRewardVideoActivityProxy.this.mPlayTime = j3;
        }
    };
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.9
        AnonymousClass9() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            KSRewardVideoActivityProxy.this.mPlayTime = j2;
        }
    };
    private com.kwad.components.ad.reward.d.b mAdOpenInteractionListener = new com.kwad.components.ad.reward.d.c() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.10
        AnonymousClass10() {
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void bN() {
            KsRewardVideoAd.RewardAdInteractionListener E = a.E(KSRewardVideoActivityProxy.this.getUniqueId());
            if (E != null) {
                E.onAdClicked();
            }
            ((j) KSRewardVideoActivityProxy.this.mCallerContext).fO = true;
            ((j) KSRewardVideoActivityProxy.this.mCallerContext).fL();
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void h(boolean z) {
            com.kwad.sdk.kwai.kwai.c.sZ().tc();
            KSRewardVideoActivityProxy.this.notifyPageDismiss(false);
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void onRewardVerify() {
            if (!((j) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult || ((j) KSRewardVideoActivityProxy.this.mCallerContext).pn == 2) {
                return;
            }
            KSRewardVideoActivityProxy.this.notifyRewardVerify();
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void onVideoPlayEnd() {
            KsRewardVideoAd.RewardAdInteractionListener E = a.E(KSRewardVideoActivityProxy.this.getUniqueId());
            if (E != null) {
                E.onVideoPlayEnd();
            }
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void onVideoPlayError(int i2, int i3) {
            KsRewardVideoAd.RewardAdInteractionListener E = a.E(KSRewardVideoActivityProxy.this.getUniqueId());
            if (E != null) {
                E.onVideoPlayError(i2, i3);
            }
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void onVideoPlayStart() {
            KsRewardVideoAd.RewardAdInteractionListener E = a.E(KSRewardVideoActivityProxy.this.getUniqueId());
            if (E != null) {
                E.onVideoPlayStart();
            }
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void onVideoSkipToEnd(long j2) {
            try {
                KsRewardVideoAd.RewardAdInteractionListener E = a.E(KSRewardVideoActivityProxy.this.getUniqueId());
                if (E != null) {
                    E.onVideoSkipToEnd(j2);
                }
            } catch (Throwable unused) {
            }
        }
    };

    /* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy$1 */
    final class AnonymousClass1 implements com.kwad.components.ad.reward.d.j {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            if (KSRewardVideoActivityProxy.this.mModel.hl() && ((j) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult && ((j) KSRewardVideoActivityProxy.this.mCallerContext).pn != 2) {
                KSRewardVideoActivityProxy.this.markOpenNsCompleted();
                KSRewardVideoActivityProxy.this.notifyRewardVerify();
                KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy$10 */
    final class AnonymousClass10 extends com.kwad.components.ad.reward.d.c {
        AnonymousClass10() {
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void bN() {
            KsRewardVideoAd.RewardAdInteractionListener E = a.E(KSRewardVideoActivityProxy.this.getUniqueId());
            if (E != null) {
                E.onAdClicked();
            }
            ((j) KSRewardVideoActivityProxy.this.mCallerContext).fO = true;
            ((j) KSRewardVideoActivityProxy.this.mCallerContext).fL();
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void h(boolean z) {
            com.kwad.sdk.kwai.kwai.c.sZ().tc();
            KSRewardVideoActivityProxy.this.notifyPageDismiss(false);
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void onRewardVerify() {
            if (!((j) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult || ((j) KSRewardVideoActivityProxy.this.mCallerContext).pn == 2) {
                return;
            }
            KSRewardVideoActivityProxy.this.notifyRewardVerify();
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void onVideoPlayEnd() {
            KsRewardVideoAd.RewardAdInteractionListener E = a.E(KSRewardVideoActivityProxy.this.getUniqueId());
            if (E != null) {
                E.onVideoPlayEnd();
            }
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void onVideoPlayError(int i2, int i3) {
            KsRewardVideoAd.RewardAdInteractionListener E = a.E(KSRewardVideoActivityProxy.this.getUniqueId());
            if (E != null) {
                E.onVideoPlayError(i2, i3);
            }
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void onVideoPlayStart() {
            KsRewardVideoAd.RewardAdInteractionListener E = a.E(KSRewardVideoActivityProxy.this.getUniqueId());
            if (E != null) {
                E.onVideoPlayStart();
            }
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void onVideoSkipToEnd(long j2) {
            try {
                KsRewardVideoAd.RewardAdInteractionListener E = a.E(KSRewardVideoActivityProxy.this.getUniqueId());
                if (E != null) {
                    E.onVideoSkipToEnd(j2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy$11 */
    final class AnonymousClass11 implements Runnable {
        final /* synthetic */ int ot;
        final /* synthetic */ int ou;

        AnonymousClass11(int i2, int i3) {
            i2 = i2;
            i3 = i3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.E(KSRewardVideoActivityProxy.this.getUniqueId()).onRewardStepVerify(i2, i3);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy$2 */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ KsRewardVideoAd.RewardAdInteractionListener on;

        AnonymousClass2(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            E = rewardAdInteractionListener;
        }

        @Override // java.lang.Runnable
        public final void run() {
            E.onRewardVerify();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy$3 */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ boolean oo;
        final /* synthetic */ AdTemplate op;

        /* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy$3$1 */
        final class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                KSRewardVideoActivityProxy.this.mModel.v(adTemplate);
                a.G(KSRewardVideoActivityProxy.this.getUniqueId());
                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                if (z) {
                    return;
                }
                KSRewardVideoActivityProxy.this.initMVP();
            }
        }

        AnonymousClass3(boolean z, AdTemplate adTemplate) {
            z = z;
            adTemplate = adTemplate;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!z) {
                ((j) KSRewardVideoActivityProxy.this.mCallerContext).releaseSync();
            }
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.3.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    KSRewardVideoActivityProxy.this.mModel.v(adTemplate);
                    a.G(KSRewardVideoActivityProxy.this.getUniqueId());
                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                    if (z) {
                        return;
                    }
                    KSRewardVideoActivityProxy.this.initMVP();
                }
            });
        }
    }

    /* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy$4 */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ AdTemplate or;

        AnonymousClass4(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.b.d(KSRewardVideoActivityProxy.TAG, "cache playAgain result: " + com.kwad.components.ad.b.a.a(adTemplate, true));
        }
    }

    /* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy$5 */
    final class AnonymousClass5 implements com.kwad.components.ad.reward.b.d {
        final /* synthetic */ j os;

        AnonymousClass5(j jVar) {
            jVar = jVar;
        }

        @Override // com.kwad.components.ad.reward.b.d
        public final void a(com.kwad.components.ad.reward.b.b bVar) {
            jVar.b(bVar);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy$6 */
    final class AnonymousClass6 extends com.kwad.components.ad.reward.d.a {
        AnonymousClass6() {
        }

        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            KSRewardVideoActivityProxy.this.mIsBackEnable = true;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy$7 */
    final class AnonymousClass7 implements com.kwad.components.ad.reward.d.d {
        AnonymousClass7() {
        }

        @Override // com.kwad.components.ad.reward.d.d
        public final void fo() {
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy$8 */
    final class AnonymousClass8 extends com.kwad.components.core.video.j {
        AnonymousClass8() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            KSRewardVideoActivityProxy.this.mPlayTime = j3;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy$9 */
    final class AnonymousClass9 extends AdLivePlayStateListenerAdapter {
        AnonymousClass9() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            KSRewardVideoActivityProxy.this.mPlayTime = j2;
        }
    }

    public static class a {
        private static final HashMap<String, a> ov = new HashMap<>();
        private KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
        private KsRewardVideoAd.RewardAdInteractionListener ow;
        private KsRewardVideoAd.RewardAdInteractionListener ox;
        private com.kwad.components.core.g.d oy;

        @Nullable
        private static a D(String str) {
            return ov.get(str);
        }

        public static KsRewardVideoAd.RewardAdInteractionListener E(String str) {
            a D = D(str);
            if (D != null) {
                return D.ox;
            }
            return null;
        }

        public static void F(String str) {
            a D = D(str);
            if (D != null) {
                D.ox = D.mInteractionListener;
            }
        }

        public static void G(String str) {
            a D = D(str);
            if (D != null) {
                D.ox = D.ow;
            }
        }

        public static com.kwad.components.core.g.d H(String str) {
            a D = D(str);
            if (D != null) {
                return D.oy;
            }
            return null;
        }

        public static void I(String str) {
            a D = D(str);
            if (D != null) {
                D.destroy();
                ov.put(str, null);
            }
        }

        public static void a(String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener2, com.kwad.components.core.g.d dVar) {
            a aVar = new a();
            aVar.mInteractionListener = rewardAdInteractionListener;
            aVar.ow = rewardAdInteractionListener2;
            aVar.oy = dVar;
            aVar.ox = rewardAdInteractionListener;
            ov.put(str, aVar);
        }

        private void destroy() {
            this.mInteractionListener = null;
            this.ow = null;
            this.ox = null;
            com.kwad.components.core.g.d dVar = this.oy;
            if (dVar != null) {
                dVar.destroy();
                this.oy = null;
            }
        }
    }

    private bh getTimerHelper() {
        if (this.mTimerHelper == null) {
            bh bhVar = new bh();
            this.mTimerHelper = bhVar;
            bhVar.startTiming();
        }
        return this.mTimerHelper;
    }

    public String getUniqueId() {
        return this.listenerKey;
    }

    private void handleNotifyVerify(boolean z) {
        ((j) this.mCallerContext).I(true);
        this.mModel.getAdTemplate().mRewardVerifyCalled = true;
        if (z || ((j) this.mCallerContext).pn == 0) {
            h.fw().m(this.mModel.getAdTemplate());
        }
        com.kwad.sdk.core.report.a.aB(this.mModel.getAdTemplate());
        if (!((j) this.mCallerContext).mAdTemplate.converted) {
            com.kwad.components.ad.reward.b.a.gQ().gR().O(com.kwad.components.ad.reward.b.b.rr);
        }
        KsRewardVideoAd.RewardAdInteractionListener E = a.E(getUniqueId());
        if (E != null) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.2
                final /* synthetic */ KsRewardVideoAd.RewardAdInteractionListener on;

                AnonymousClass2(KsRewardVideoAd.RewardAdInteractionListener E2) {
                    E = E2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    E.onRewardVerify();
                }
            });
            com.kwad.components.ad.reward.monitor.a.a(this.mModel.getAdTemplate(), 0, -1, true);
        }
        if (com.kwad.sdk.core.response.a.a.cw(this.mModel.bK())) {
            T t = this.mCallerContext;
            if (((j) t).mAdTemplate.converted || ((j) t).pg || ((j) t).fV()) {
                return;
            }
            j.a(getActivity(), (j) this.mCallerContext);
        }
    }

    private void initPlayAgain() {
        if (this.mModel.getAdTemplate() == null || this.mModel.getAdTemplate().mPlayAgain == null) {
            return;
        }
        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.4
            final /* synthetic */ AdTemplate or;

            AnonymousClass4(AdTemplate adTemplate) {
                adTemplate = adTemplate;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d(KSRewardVideoActivityProxy.TAG, "cache playAgain result: " + com.kwad.components.ad.b.a.a(adTemplate, true));
            }
        });
    }

    private boolean isLaunchTaskCompleted() {
        T t = this.mCallerContext;
        return ((j) t).pw != null && ((j) t).pw.isCompleted();
    }

    public static void launch(Activity activity, @NonNull AdTemplate adTemplate, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener2, com.kwad.components.core.g.d dVar, int i2) {
        Intent intent;
        com.kwad.sdk.utils.l.cv(adTemplate);
        if (ksVideoPlayConfig.isShowLandscape()) {
            com.kwad.sdk.service.a.a(KSRewardLandScapeVideoActivity.class, KSRewardLandScapeVideoActivityProxy.class);
            intent = new Intent(activity, (Class<?>) KSRewardLandScapeVideoActivity.class);
        } else {
            com.kwad.sdk.service.a.a(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
            intent = new Intent(activity, (Class<?>) KsRewardVideoActivity.class);
        }
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        intent.putExtra(KEY_REWARD_TYPE, i2);
        if (adTemplate.hasPlayAgain() && rewardAdInteractionListener2 != null) {
            intent.putExtra(KEY_TEMPLATE_PLAY_AGAIN, adTemplate.mPlayAgain.toJson().toString());
        }
        String uniqueId = adTemplate.getUniqueId();
        a.a(uniqueId, rewardAdInteractionListener, rewardAdInteractionListener2, dVar);
        a.F(uniqueId);
        activity.startActivity(intent);
        com.kwad.sdk.kwai.kwai.c.sZ().aU(true);
    }

    public void markOpenNsCompleted() {
        T t = this.mCallerContext;
        if (((j) t).px != null) {
            ((j) t).px.markOpenNsCompleted();
        }
    }

    private boolean needHandledOnResume() {
        return ((j) this.mCallerContext).fW();
    }

    public void notifyPageDismiss(boolean z) {
        com.kwad.components.ad.reward.model.c cVar;
        if (this.mPageDismissCalled || this.mCallerContext == 0 || (cVar = this.mModel) == null) {
            return;
        }
        this.mPageDismissCalled = true;
        com.kwad.sdk.core.report.a.n(cVar.getAdTemplate(), (int) Math.ceil(this.mPlayTime / 1000.0f));
        if (z) {
            com.kwad.sdk.core.report.a.a(this.mModel.getAdTemplate(), 1, getTimerHelper().getTime(), ((j) this.mCallerContext).mReportExtData);
        } else {
            com.kwad.sdk.core.report.a.a(this.mModel.getAdTemplate(), 6, getTimerHelper().getTime(), this.mModel.ho());
        }
        KsRewardVideoAd.RewardAdInteractionListener E = a.E(getUniqueId());
        if (E != null) {
            E.onPageDismiss();
        }
    }

    private void notifyRewardStep(int i2, int i3) {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || com.kwad.sdk.core.response.a.d.cm(cVar.getAdTemplate()) || ((j) this.mCallerContext).pm.contains(Integer.valueOf(i3))) {
            return;
        }
        ((j) this.mCallerContext).pm.add(Integer.valueOf(i3));
        p.a(i2, i3, (j) this.mCallerContext, this.mModel);
        if (a.E(getUniqueId()) == null) {
            return;
        }
        try {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.11
                final /* synthetic */ int ot;
                final /* synthetic */ int ou;

                AnonymousClass11(int i22, int i32) {
                    i2 = i22;
                    i3 = i32;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a.E(KSRewardVideoActivityProxy.this.getUniqueId()).onRewardStepVerify(i2, i3);
                }
            });
            com.kwad.components.ad.reward.monitor.a.a(this.mModel.getAdTemplate(), i22, i32, false);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    public void notifyRewardVerify() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || !((j) this.mCallerContext).mCheckExposureResult || com.kwad.sdk.core.response.a.d.cm(cVar.getAdTemplate()) || ((j) this.mCallerContext).fX()) {
            return;
        }
        boolean z = false;
        if (this.mModel.hk()) {
            T t = this.mCallerContext;
            if (((j) t).pw != null && ((j) t).pw.isCompleted()) {
                z = true;
            }
            if (z) {
                handleNotifyVerify(true);
                return;
            }
            return;
        }
        if (!this.mModel.hl()) {
            handleNotifyVerify(false);
            return;
        }
        T t2 = this.mCallerContext;
        if (((j) t2).px != null && ((j) t2).px.isCompleted()) {
            z = true;
        }
        if (z) {
            handleNotifyVerify(true);
        }
    }

    public void notifyRewardVerifyStepByStep() {
        if (this.mModel.hk()) {
            notifyRewardStep(2, 0);
            if (isLaunchTaskCompleted()) {
                notifyRewardStep(2, 2);
                return;
            }
            return;
        }
        if (!this.mModel.hl()) {
            if (this.mIsFinishVideoLookStep) {
                return;
            }
            this.mIsFinishVideoLookStep = true;
            notifyRewardStep(0, 0);
            return;
        }
        T t = this.mCallerContext;
        boolean z = ((j) t).px != null && ((j) t).px.isCompleted();
        notifyRewardStep(1, 0);
        if (z) {
            notifyRewardStep(1, 1);
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.a.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.a.a(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
    }

    @Override // com.kwad.components.core.l.d
    public boolean checkIntentData(@Nullable Intent intent) {
        com.kwad.components.ad.reward.model.c c2 = com.kwad.components.ad.reward.model.c.c(intent);
        this.mModel = c2;
        if (c2 != null) {
            return true;
        }
        com.kwad.sdk.g.a.V("reward", "show");
        return false;
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        super.finish();
        notifyPageDismiss(false);
    }

    @Override // com.kwad.components.core.l.d
    public int getLayoutId() {
        return R.layout.ksad_activity_reward_video;
    }

    @Override // com.kwad.components.core.l.d
    public String getPageName() {
        return "KSRewardLandScapeVideoActivityProxy";
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor
    public boolean handledAdLiveOnResume() {
        return needHandledOnResume();
    }

    @Override // com.kwad.components.core.l.d
    public void initData() {
        this.listenerKey = this.mModel.getAdTemplate().getUniqueId();
        this.mPageEnterTime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.reward.monitor.a.a(true, this.mModel.getAdTemplate(), this.mPageEnterTime);
        com.kwad.components.ad.reward.monitor.a.K(true);
        com.kwad.components.core.r.c.pL().a(this);
        c.fj().a(this.mRewardVerifyListener);
        initPlayAgain();
    }

    @Override // com.kwad.components.core.l.d
    public void initView() {
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.mRootContainer = adBaseFrameLayout;
        this.mDetailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
        this.mPlayLayout = (FrameLayout) this.mRootContainer.findViewById(R.id.ksad_reward_play_layout);
        boolean z = !ai.DL();
        if ((this.mModel.hk() || this.mModel.hl()) && z) {
            this.mDetailVideoView.setForce(true);
        }
        this.mDetailVideoView.f(true, com.kwad.sdk.core.config.d.uV());
        com.kwad.sdk.g.a.V("reward", "show");
    }

    @Override // com.kwad.components.ad.reward.j.b
    public boolean interceptPlayCardResume() {
        return needHandledOnResume();
    }

    @Override // com.kwad.components.core.l.d
    public boolean needAdaptionScreen() {
        return true;
    }

    @Override // com.kwad.components.core.j.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        BackPressHandleResult gs = this.mRewardPresenter.gs();
        if (gs.equals(BackPressHandleResult.HANDLED)) {
            return;
        }
        if (gs.equals(BackPressHandleResult.HANDLED_CLOSE)) {
            super.onBackPressed();
            notifyPageDismiss(false);
        } else if (this.mIsBackEnable) {
            notifyPageDismiss(false);
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_REWARD, "adShowSuccess").report();
    }

    @Override // com.kwad.components.core.j.b
    public j onCreateCallerContext() {
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        AdInfo bK = this.mModel.bK();
        j jVar = new j(this);
        jVar.mPageEnterTime = this.mPageEnterTime;
        jVar.mAdOpenInteractionListener = this.mAdOpenInteractionListener;
        jVar.mAdRewardStepListener = this.mAdRewardStepListener;
        jVar.mScreenOrientation = this.mModel.getScreenOrientation();
        jVar.mVideoPlayConfig = this.mModel.hm();
        jVar.mReportExtData = this.mModel.ho();
        jVar.mRootContainer = this.mRootContainer;
        jVar.mAdTemplate = adTemplate;
        jVar.pI = com.kwad.sdk.core.response.a.b.du(bK) ? LoadStrategy.FULL_TK : LoadStrategy.MULTI;
        com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
        jVar.oM = this.mDetailVideoView;
        com.kwad.components.ad.reward.j.a aVar = new com.kwad.components.ad.reward.j.a(jVar, this.mModel.hn() == 2);
        com.kwad.components.ad.reward.j.b bVar = new com.kwad.components.ad.reward.j.b(aVar);
        jVar.oN = bVar;
        bVar.jH().a(this.mVideoPlayStateListener);
        jVar.a(aVar);
        jVar.a((j.b) this);
        if (com.kwad.sdk.core.response.a.a.ax(bK)) {
            jVar.mApkDownloadHelper = new com.kwad.components.core.d.b.c(adTemplate, this.mModel.ho());
        }
        jVar.oQ = new RewardActionBarControl(jVar, this.mContext, adTemplate);
        jVar.b(this.mPlayEndPageListener);
        if (com.kwad.sdk.core.response.a.b.be(adTemplate)) {
            l lVar = new l(jVar, this.mModel.ho(), null);
            jVar.oR = lVar;
            lVar.a(new com.kwad.components.ad.reward.b.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.5
                final /* synthetic */ j os;

                AnonymousClass5(j jVar2) {
                    jVar = jVar2;
                }

                @Override // com.kwad.components.ad.reward.b.d
                public final void a(com.kwad.components.ad.reward.b.b bVar2) {
                    jVar.b(bVar2);
                }
            });
        }
        if (com.kwad.sdk.core.response.a.b.bF(adTemplate)) {
            String bH = com.kwad.sdk.core.response.a.b.bH(adTemplate);
            if (!TextUtils.isEmpty(bH)) {
                com.kwad.components.ad.i.b bVar2 = new com.kwad.components.ad.i.b(this.mModel.ho(), bH);
                jVar2.oS = bVar2;
                bVar2.a(this);
            }
        }
        if (com.kwad.sdk.core.response.a.a.aj(bK)) {
            jVar2.oT = new com.kwad.components.ad.i.a().ak(true);
        }
        jVar2.pf = true;
        if (com.kwad.sdk.core.response.a.a.bv(bK)) {
            jVar2.oP = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.ksad_playable_webview));
        }
        jVar2.pA = 0L;
        if (this.mModel.bK() != null) {
            jVar2.pA = com.kwad.sdk.core.response.a.a.bv(this.mModel.bK()) ? com.kwad.sdk.core.response.a.a.ai(this.mModel.bK()) : com.kwad.sdk.core.response.a.a.ad(this.mModel.bK());
        }
        jVar2.a((com.kwad.components.ad.reward.g.c) this);
        jVar2.mTimerHelper = getTimerHelper();
        return jVar2;
    }

    @Override // com.kwad.components.core.j.b
    public Presenter onCreatePresenter() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null) {
            return null;
        }
        o oVar = new o(this, this.mRootContainer, cVar, (j) this.mCallerContext);
        this.mRewardPresenter = oVar;
        oVar.a(this);
        return this.mRewardPresenter;
    }

    @Override // com.kwad.components.core.j.b, com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        c.fj().b(this.mRewardVerifyListener);
        super.onDestroy();
        notifyPageDismiss(false);
        T t = this.mCallerContext;
        if (t != 0) {
            ((j) t).oN.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
            if (((j) this.mCallerContext).oN.jF()) {
                ((j) this.mCallerContext).oN.jG().removeInterceptor(this);
                ((j) this.mCallerContext).oN.jG().unRegisterAdLivePlayStateListener(this.mAdLivePlayStateListener);
            }
            a.I(getUniqueId());
        }
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar != null) {
            String E = com.kwad.sdk.core.response.a.a.E(cVar.bK());
            if (!TextUtils.isEmpty(E)) {
                com.kwad.sdk.core.videocache.b.a.ba(this.mContext.getApplicationContext()).cV(E);
            }
        }
        com.kwad.components.core.r.c.pL().b(this);
        this.listenerKey = null;
    }

    @Override // com.kwad.components.core.r.c.b
    public void onPageClose() {
        finish();
    }

    @Override // com.kwad.components.core.j.b, com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        T t = this.mCallerContext;
        if (t != 0) {
            ((j) t).mPageEnterTime = -1L;
        }
    }

    @Override // com.kwad.components.ad.reward.g.c, com.kwad.components.core.webview.jshandler.j.a
    public void onPlayAgainClick(boolean z) {
        AdTemplate adTemplate;
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || (adTemplate = cVar.getAdTemplate().mPlayAgain) == null) {
            return;
        }
        adTemplate.inPlayAgain = true;
        o oVar = this.mRewardPresenter;
        if (z) {
            oVar.r(adTemplate);
        } else {
            oVar.jW();
            this.mRewardPresenter = null;
            this.mPresenter = null;
        }
        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.3
            final /* synthetic */ boolean oo;
            final /* synthetic */ AdTemplate op;

            /* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy$3$1 */
            final class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    KSRewardVideoActivityProxy.this.mModel.v(adTemplate);
                    a.G(KSRewardVideoActivityProxy.this.getUniqueId());
                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                    if (z) {
                        return;
                    }
                    KSRewardVideoActivityProxy.this.initMVP();
                }
            }

            AnonymousClass3(boolean z2, AdTemplate adTemplate2) {
                z = z2;
                adTemplate = adTemplate2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (!z) {
                    ((j) KSRewardVideoActivityProxy.this.mCallerContext).releaseSync();
                }
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.3.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        KSRewardVideoActivityProxy.this.mModel.v(adTemplate);
                        a.G(KSRewardVideoActivityProxy.this.getUniqueId());
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        if (z) {
                            return;
                        }
                        KSRewardVideoActivityProxy.this.initMVP();
                    }
                });
            }
        });
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreDestroy() {
        super.onPreDestroy();
        com.kwad.components.core.webview.a.c.a.rn().ro();
    }

    @Override // com.kwad.components.core.j.b, com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar != null) {
            AdTemplate adTemplate = cVar.getAdTemplate();
            com.kwad.sdk.core.c.a.vU();
            com.kwad.sdk.core.c.a.am(adTemplate);
        }
        com.kwad.components.ad.reward.b.a.gQ().O(this.mContext);
    }

    @Override // com.kwad.components.ad.reward.o.a
    public void onUnbind() {
        this.mIsBackEnable = false;
        ((j) this.mCallerContext).I(false);
        ((j) this.mCallerContext).pk = false;
    }
}
