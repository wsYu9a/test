package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.core.s.c;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsRewardVideoActivity;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.bt;

@KsAdSdkDynamicImpl(KsRewardVideoActivity.class)
@Keep
/* loaded from: classes2.dex */
public class KSRewardVideoActivityProxy extends com.kwad.components.core.l.b<g> implements g.b, n.a, c.b, OnAdLiveResumeInterceptor {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    public static final String KEY_REWARD_TYPE = "key_template_reward_type";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String KEY_VIDEO_PLAY_CONFIG_JSON = "key_video_play_config_json";
    private static final String TAG = "RewardVideo";
    private String listenerKey;
    private boolean mIsBackEnable;
    private com.kwad.components.ad.reward.model.c mModel;
    private boolean mPageDismissCalled;
    private long mPageEnterTime;
    private n mRewardPresenter;
    private AdBaseFrameLayout mRootContainer;
    private bs mTimerHelper;
    private boolean mReportedPageResume = false;
    private boolean mIsFinishVideoLookStep = false;
    private final com.kwad.components.ad.reward.e.l mRewardVerifyListener = new com.kwad.components.ad.reward.e.l() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (KSRewardVideoActivityProxy.this.mModel.hE() && ((g) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult && ((g) KSRewardVideoActivityProxy.this.mCallerContext).qE != 2) {
                KSRewardVideoActivityProxy.this.markOpenNsCompleted();
                KSRewardVideoActivityProxy.this.notifyRewardVerify();
                KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
            }
        }
    };
    private com.kwad.components.ad.reward.e.i mAdOpenInteractionListener = new com.kwad.components.ad.reward.e.i() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void cg() {
            super.cg();
            ((g) KSRewardVideoActivityProxy.this.mCallerContext).f11685hc = true;
            ((g) KSRewardVideoActivityProxy.this.mCallerContext).fY();
        }

        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void i(boolean z10) {
            if (KSRewardVideoActivityProxy.this.notifyPageDismiss(z10)) {
                com.kwad.sdk.a.a.c.Bg().Bj();
                super.i(z10);
            }
        }

        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void onRewardVerify() {
            if (!((g) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult || ((g) KSRewardVideoActivityProxy.this.mCallerContext).qE == 2) {
                return;
            }
            KSRewardVideoActivityProxy.this.notifyRewardVerify();
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    };
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.3
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            KSRewardVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    private com.kwad.components.ad.reward.e.d mAdRewardStepListener = new com.kwad.components.ad.reward.e.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.4
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.ad.reward.e.d
        public final void fA() {
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy$1 */
    public class AnonymousClass1 implements com.kwad.components.ad.reward.e.l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (KSRewardVideoActivityProxy.this.mModel.hE() && ((g) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult && ((g) KSRewardVideoActivityProxy.this.mCallerContext).qE != 2) {
                KSRewardVideoActivityProxy.this.markOpenNsCompleted();
                KSRewardVideoActivityProxy.this.notifyRewardVerify();
                KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy$2 */
    public class AnonymousClass2 extends com.kwad.components.ad.reward.e.i {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void cg() {
            super.cg();
            ((g) KSRewardVideoActivityProxy.this.mCallerContext).f11685hc = true;
            ((g) KSRewardVideoActivityProxy.this.mCallerContext).fY();
        }

        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void i(boolean z10) {
            if (KSRewardVideoActivityProxy.this.notifyPageDismiss(z10)) {
                com.kwad.sdk.a.a.c.Bg().Bj();
                super.i(z10);
            }
        }

        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void onRewardVerify() {
            if (!((g) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult || ((g) KSRewardVideoActivityProxy.this.mCallerContext).qE == 2) {
                return;
            }
            KSRewardVideoActivityProxy.this.notifyRewardVerify();
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy$3 */
    public class AnonymousClass3 extends com.kwad.components.ad.reward.e.a {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            KSRewardVideoActivityProxy.this.mIsBackEnable = true;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy$4 */
    public class AnonymousClass4 implements com.kwad.components.ad.reward.e.d {
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.ad.reward.e.d
        public final void fA() {
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy$5 */
    public class AnonymousClass5 implements com.kwad.components.ad.reward.c.d {
        final /* synthetic */ g pP;

        public AnonymousClass5(g gVar) {
            gVar = gVar;
        }

        @Override // com.kwad.components.ad.reward.c.d
        public final void a(com.kwad.components.ad.reward.c.b bVar) {
            gVar.b(bVar);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy$6 */
    public class AnonymousClass6 extends bd {
        final /* synthetic */ int pQ;
        final /* synthetic */ int pR;

        public AnonymousClass6(int i10, int i11) {
            i10 = i10;
            i11 = i11;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            try {
                if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.h(i10, i11)) {
                    com.kwad.components.ad.reward.monitor.c.a(KSRewardVideoActivityProxy.this.mModel.getAdTemplate(), i10, i11, false);
                }
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy$7 */
    public class AnonymousClass7 extends bd {
        public AnonymousClass7() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.hm()) {
                com.kwad.components.ad.reward.monitor.c.a(KSRewardVideoActivityProxy.this.mModel.getAdTemplate(), 0, -1, true);
            }
        }
    }

    private bs getTimerHelper() {
        if (this.mTimerHelper == null) {
            bs bsVar = new bs();
            this.mTimerHelper = bsVar;
            bsVar.startTiming();
        }
        return this.mTimerHelper;
    }

    private String getUniqueId() {
        return this.listenerKey;
    }

    private void handleNotifyVerify(boolean z10) {
        this.mAdOpenInteractionListener.setCallerContext((g) this.mCallerContext);
        ((g) this.mCallerContext).F(true);
        this.mModel.getAdTemplate().mRewardVerifyCalled = true;
        if (z10 || ((g) this.mCallerContext).qE == 0) {
            e.fJ().G(this.mModel.getAdTemplate());
        }
        com.kwad.sdk.core.adlog.c.i(this.mModel.getAdTemplate(), isNeoScan());
        if (!((g) this.mCallerContext).mAdTemplate.converted) {
            com.kwad.components.ad.reward.c.a.hg().hh().N(com.kwad.components.ad.reward.c.b.sN);
        }
        bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.7
            public AnonymousClass7() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.hm()) {
                    com.kwad.components.ad.reward.monitor.c.a(KSRewardVideoActivityProxy.this.mModel.getAdTemplate(), 0, -1, true);
                }
            }
        });
        if (com.kwad.sdk.core.response.b.a.cZ(this.mModel.ce())) {
            T t10 = this.mCallerContext;
            if (((g) t10).mAdTemplate.converted || ((g) t10).qv || ((g) t10).gf()) {
                return;
            }
            g.a(getActivity(), (g) this.mCallerContext);
        }
    }

    private boolean isLaunchTaskCompleted() {
        T t10 = this.mCallerContext;
        return ((g) t10).qO != null && ((g) t10).qO.isCompleted();
    }

    private boolean isNeoScan() {
        return this.mModel.hJ() != null && this.mModel.hJ().neoPageType == 1;
    }

    public static void launch(Activity activity, AdResultData adResultData, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, com.kwad.components.core.i.d dVar, int i10) {
        Intent intent;
        AdTemplate o10 = com.kwad.sdk.core.response.b.c.o(adResultData);
        com.kwad.components.ad.reward.monitor.c.i(true, o10);
        AdGlobalConfigInfo adGlobalConfigInfo = adResultData.adGlobalConfigInfo;
        com.kwad.sdk.utils.m.ez(o10);
        if (adGlobalConfigInfo != null && adGlobalConfigInfo.neoPageType == 1) {
            ksVideoPlayConfig.setShowLandscape(false);
        }
        if (ksVideoPlayConfig.isShowLandscape()) {
            com.kwad.sdk.service.b.a(KSRewardLandScapeVideoActivity.class, KSRewardLandScapeVideoActivityProxy.class);
            intent = new Intent(activity, (Class<?>) KSRewardLandScapeVideoActivity.class);
        } else {
            com.kwad.sdk.service.b.a(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
            intent = new Intent(activity, (Class<?>) KsRewardVideoActivity.class);
        }
        intent.setFlags(268435456);
        intent.putExtra("key_template_json", o10.toJson().toString());
        intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.nt().j(adResultData));
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        intent.putExtra("key_video_play_config_json", com.kwad.components.core.internal.api.e.a(ksVideoPlayConfig));
        intent.putExtra(KEY_REWARD_TYPE, i10);
        String uniqueId = o10.getUniqueId();
        com.kwad.components.ad.reward.e.f.a(uniqueId, rewardAdInteractionListener, dVar);
        com.kwad.components.ad.reward.e.f.K(uniqueId);
        try {
            activity.startActivity(intent);
            com.kwad.sdk.a.a.c.Bg().bk(true);
            com.kwad.components.ad.reward.monitor.c.c(true, o10, PageCreateStage.END_LAUNCH.getStage());
        } catch (Throwable th2) {
            com.kwad.components.ad.reward.monitor.c.a(true, o10, PageCreateStage.ERROR_START_ACTIVITY.getStage(), th2.getMessage());
            throw th2;
        }
    }

    public void markOpenNsCompleted() {
        T t10 = this.mCallerContext;
        if (((g) t10).qP != null) {
            ((g) t10).qP.markOpenNsCompleted();
        }
    }

    private boolean needHandledOnResume() {
        return ((g) this.mCallerContext).gg();
    }

    public boolean notifyPageDismiss(boolean z10) {
        com.kwad.components.ad.reward.model.c cVar;
        if (this.mPageDismissCalled || this.mCallerContext == 0 || (cVar = this.mModel) == null) {
            return false;
        }
        this.mPageDismissCalled = true;
        if (!com.kwad.sdk.core.response.b.a.cT(cVar.ce()) || !((g) this.mCallerContext).ge()) {
            com.kwad.sdk.core.adlog.c.m(this.mModel.getAdTemplate(), (int) Math.ceil(getTimerHelper().getTime() / 1000.0f));
        }
        if (z10) {
            if (this.mModel.hJ() == null || this.mModel.hJ().neoPageType != 1) {
                com.kwad.sdk.core.adlog.c.a(this.mModel.getAdTemplate(), 1, getTimerHelper().getTime(), ((g) this.mCallerContext).mReportExtData);
            }
        } else if (this.mModel.hJ() == null || this.mModel.hJ().neoPageType != 1) {
            com.kwad.sdk.core.adlog.c.a(this.mModel.getAdTemplate(), 6, getTimerHelper().getTime(), this.mModel.hI());
        }
        return true;
    }

    private void notifyRewardStep(int i10, int i11) {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || com.kwad.sdk.core.response.b.e.em(cVar.getAdTemplate()) || ((g) this.mCallerContext).qB.contains(Integer.valueOf(i11))) {
            return;
        }
        ((g) this.mCallerContext).qB.add(Integer.valueOf(i11));
        o.a(i10, i11, (g) this.mCallerContext, this.mModel);
        bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.6
            final /* synthetic */ int pQ;
            final /* synthetic */ int pR;

            public AnonymousClass6(int i102, int i112) {
                i10 = i102;
                i11 = i112;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                try {
                    if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.h(i10, i11)) {
                        com.kwad.components.ad.reward.monitor.c.a(KSRewardVideoActivityProxy.this.mModel.getAdTemplate(), i10, i11, false);
                    }
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        });
    }

    public void notifyRewardVerify() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || !((g) this.mCallerContext).mCheckExposureResult || com.kwad.sdk.core.response.b.e.em(cVar.getAdTemplate()) || ((g) this.mCallerContext).gh()) {
            return;
        }
        if (this.mModel.hD()) {
            T t10 = this.mCallerContext;
            if (((g) t10).qO == null || !((g) t10).qO.isCompleted()) {
                return;
            }
            handleNotifyVerify(true);
            return;
        }
        if (!this.mModel.hE()) {
            handleNotifyVerify(false);
            return;
        }
        T t11 = this.mCallerContext;
        if (((g) t11).qP == null || !((g) t11).qP.isCompleted()) {
            return;
        }
        handleNotifyVerify(true);
    }

    public void notifyRewardVerifyStepByStep() {
        if (this.mModel.hD()) {
            notifyRewardStep(2, 0);
            if (isLaunchTaskCompleted()) {
                notifyRewardStep(2, 2);
                return;
            }
            return;
        }
        if (!this.mModel.hE()) {
            if (this.mIsFinishVideoLookStep) {
                return;
            }
            this.mIsFinishVideoLookStep = true;
            notifyRewardStep(0, 0);
            return;
        }
        T t10 = this.mCallerContext;
        boolean z10 = ((g) t10).qP != null && ((g) t10).qP.isCompleted();
        notifyRewardStep(1, 0);
        if (z10) {
            notifyRewardStep(1, 1);
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.a(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
    }

    private void reportSubPageCreate(String str) {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        com.kwad.components.ad.reward.monitor.c.c(true, cVar != null ? cVar.getAdTemplate() : null, str);
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(@Nullable Intent intent) {
        com.kwad.components.ad.reward.model.c a10 = com.kwad.components.ad.reward.model.c.a(intent);
        this.mModel = a10;
        return a10 != null;
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        super.finish();
        this.mAdOpenInteractionListener.i(false);
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        return (cVar == null || !cVar.hG) ? R.layout.ksad_activity_reward_video_legacy : R.layout.ksad_activity_reward_neo;
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "KSRewardLandScapeVideoActivityProxy";
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor
    public boolean handledAdLiveOnResume() {
        return needHandledOnResume();
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        this.listenerKey = this.mModel.getAdTemplate().getUniqueId();
        this.mAdOpenInteractionListener.setAdTemplate(this.mModel.getAdTemplate());
        this.mAdOpenInteractionListener.N(getUniqueId());
        this.mPageEnterTime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.reward.monitor.c.a(true, this.mModel.getAdTemplate(), this.mPageEnterTime, this.mModel.hJ());
        com.kwad.components.ad.reward.monitor.c.g(true, this.mModel.getAdTemplate());
        com.kwad.components.core.s.c.sd().a(this);
        b.fv().a(this.mRewardVerifyListener);
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    @Override // com.kwad.components.ad.reward.g.b
    public boolean interceptPlayCardResume() {
        return needHandledOnResume();
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean needAdaptionScreen() {
        return true;
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.f
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.d.c.bG(this.mModel.getAdTemplate());
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        n nVar = this.mRewardPresenter;
        if (nVar == null) {
            super.onBackPressed();
            return;
        }
        BackPressHandleResult gI = nVar.gI();
        if (gI.equals(BackPressHandleResult.HANDLED)) {
            return;
        }
        if (gI.equals(BackPressHandleResult.HANDLED_CLOSE)) {
            super.onBackPressed();
            this.mAdOpenInteractionListener.i(false);
        } else if (this.mIsBackEnable) {
            this.mAdOpenInteractionListener.i(false);
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.proxy.f
    public void onCreateCaughtException(Throwable th2) {
        super.onCreateCaughtException(th2);
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        com.kwad.components.ad.reward.monitor.b.b(true, cVar != null ? cVar.getAdTemplate() : null);
    }

    @Override // com.kwad.components.core.l.b
    public Presenter onCreatePresenter() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null) {
            return null;
        }
        n nVar = new n(this, this.mContext, this.mRootContainer, cVar, (g) this.mCallerContext);
        this.mRewardPresenter = nVar;
        nVar.a(this);
        return this.mRewardPresenter;
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.components.core.proxy.a.c
    public void onCreateStageChange(PageCreateStage pageCreateStage) {
        super.onCreateStageChange(pageCreateStage);
        com.kwad.sdk.core.d.c.d(TAG, "onCreateStageChange: " + pageCreateStage.getStage());
        reportSubPageCreate(pageCreateStage.getStage());
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            b.fv().b(this.mRewardVerifyListener);
            super.onDestroy();
            this.mAdOpenInteractionListener.i(false);
            if (this.mCallerContext != 0) {
                i.gD().D(String.valueOf(((g) this.mCallerContext).mAdTemplate));
                com.kwad.components.ad.reward.e.f.M(getUniqueId());
            }
            com.kwad.components.ad.reward.model.c cVar = this.mModel;
            if (cVar != null) {
                String K = com.kwad.sdk.core.response.b.a.K(cVar.ce());
                if (!TextUtils.isEmpty(K)) {
                    com.kwad.sdk.core.videocache.c.a.bC(this.mContext.getApplicationContext()).eP(K);
                }
            }
            com.kwad.components.core.s.c.sd().b(this);
            this.listenerKey = null;
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @Override // com.kwad.components.core.s.c.b
    public void onPageClose() {
        finish();
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        T t10 = this.mCallerContext;
        if (t10 != 0) {
            ((g) t10).mPageEnterTime = -1L;
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
        reportSubPageCreate(PageCreateStage.END_CHILD_ON_PRE_CREATE.getStage());
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreDestroy() {
        super.onPreDestroy();
        com.kwad.components.core.webview.tachikoma.d.b.uj().uk();
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        try {
            super.onResume();
            com.kwad.components.ad.reward.model.c cVar = this.mModel;
            if (cVar != null) {
                AdTemplate adTemplate = cVar.getAdTemplate();
                com.kwad.sdk.core.local.a.Fk();
                com.kwad.sdk.core.local.a.cc(adTemplate);
            }
            if (!this.mReportedPageResume) {
                com.kwad.components.ad.reward.monitor.c.f(true, this.mModel.getAdTemplate());
                this.mReportedPageResume = true;
            }
            com.kwad.components.ad.reward.c.a.hg().O(this.mContext);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.a
    public void onUnbind() {
        this.mIsBackEnable = false;
        ((g) this.mCallerContext).F(false);
        ((g) this.mCallerContext).qz = false;
    }

    @Override // com.kwad.components.core.l.b
    public g onCreateCallerContext() {
        AdResultData hF = this.mModel.hF();
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        AdInfo ce2 = this.mModel.ce();
        g gVar = new g(this);
        gVar.mPageEnterTime = this.mPageEnterTime;
        gVar.f11687qd = this.mModel.hH() == 2;
        gVar.f11688qe = this.mAdOpenInteractionListener;
        gVar.mAdRewardStepListener = this.mAdRewardStepListener;
        gVar.mScreenOrientation = this.mModel.getScreenOrientation();
        gVar.mVideoPlayConfig = this.mModel.hG();
        gVar.mReportExtData = this.mModel.hI();
        gVar.mRootContainer = this.mRootContainer;
        gVar.a(hF);
        gVar.qZ = com.kwad.sdk.core.response.b.b.ei(ce2) ? LoadStrategy.FULL_TK : LoadStrategy.MULTI;
        gVar.a(this);
        if (com.kwad.sdk.core.response.b.a.aF(ce2)) {
            gVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(adTemplate, this.mModel.hI());
        }
        gVar.f11692qi = new RewardActionBarControl(gVar, this.mContext, adTemplate);
        gVar.b(this.mPlayEndPageListener);
        if (com.kwad.sdk.core.response.b.b.cH(adTemplate)) {
            j jVar = new j(gVar, this.mModel.hI(), null);
            gVar.f11693qj = jVar;
            jVar.a(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.5
                final /* synthetic */ g pP;

                public AnonymousClass5(g gVar2) {
                    gVar = gVar2;
                }

                @Override // com.kwad.components.ad.reward.c.d
                public final void a(com.kwad.components.ad.reward.c.b bVar) {
                    gVar.b(bVar);
                }
            });
        }
        if (com.kwad.sdk.core.response.b.a.as(ce2)) {
            gVar2.f11694qk = new com.kwad.components.ad.m.a().ag(true);
        }
        gVar2.qu = true;
        if (com.kwad.sdk.core.response.b.a.bJ(ce2)) {
            gVar2.f11691qh = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.ksad_playable_webview));
        }
        gVar2.qS = 0L;
        if (this.mModel.ce() != null) {
            gVar2.qS = com.kwad.sdk.core.response.b.a.bJ(this.mModel.ce()) ? com.kwad.sdk.core.response.b.a.ar(this.mModel.ce()) : com.kwad.sdk.core.response.b.a.am(this.mModel.ce());
        }
        gVar2.mTimerHelper = getTimerHelper();
        gVar2.f11689qf = new com.kwad.components.ad.reward.m.e(gVar2);
        gVar2.hG = this.mModel.hG;
        return gVar2;
    }
}
