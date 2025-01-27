package com.kwad.components.ad.fullscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenVideoActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.x;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
@Keep
/* loaded from: classes2.dex */
public class KsFullScreenVideoActivityProxy extends com.kwad.components.core.l.b<com.kwad.components.ad.reward.g> implements OnAdLiveResumeInterceptor {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String KEY_VIDEO_PLAY_CONFIG_JSON = "key_video_play_config_json";
    private static final String TAG = "FullScreenVideo";
    private static final HashMap<String, c> sHashMap = new HashMap<>();
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private com.kwad.components.ad.fullscreen.c.b mFullScreenPresenter;
    private c mInteractionListener;
    private boolean mIsBackEnable;
    private boolean mPageDismissCalled;
    public long mPageEnterTime;
    private JSONObject mReportExtData;
    private AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    private bs mTimerHelper;
    private KsVideoPlayConfig mVideoPlayConfig;
    private b model;
    private boolean mReportedPageResume = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            KsFullScreenVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    private d mAdOpenInteractionListener = new d() { // from class: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.fullscreen.d, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void i(boolean z10) {
            if (KsFullScreenVideoActivityProxy.this.notifyPageDismiss()) {
                super.i(z10);
            }
        }
    };

    /* renamed from: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy$1 */
    public class AnonymousClass1 extends com.kwad.components.ad.reward.e.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            KsFullScreenVideoActivityProxy.this.mIsBackEnable = true;
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy$2 */
    public class AnonymousClass2 extends d {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.fullscreen.d, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void i(boolean z10) {
            if (KsFullScreenVideoActivityProxy.this.notifyPageDismiss()) {
                super.i(z10);
            }
        }
    }

    private static String getListenerKey(AdTemplate adTemplate) {
        return adTemplate == null ? "" : String.valueOf(com.kwad.sdk.core.response.b.e.eb(adTemplate).adBaseInfo.creativeId);
    }

    private bs getTimerHelper() {
        if (this.mTimerHelper == null) {
            bs bsVar = new bs();
            this.mTimerHelper = bsVar;
            bsVar.startTiming();
        }
        return this.mTimerHelper;
    }

    private void initVideoPlayConfig(@NonNull KsVideoPlayConfig ksVideoPlayConfig) {
        if (TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            return;
        }
        this.mReportExtData = null;
        JSONObject jSONObject = new JSONObject();
        this.mReportExtData = jSONObject;
        x.putValue(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
    }

    public static void launch(@NonNull Context context, @NonNull AdResultData adResultData, @NonNull KsVideoPlayConfig ksVideoPlayConfig, c cVar) {
        Intent intent;
        AdTemplate o10 = com.kwad.sdk.core.response.b.c.o(adResultData);
        com.kwad.components.ad.reward.monitor.c.i(false, o10);
        m.ez(o10);
        if (ksVideoPlayConfig.isShowLandscape()) {
            com.kwad.sdk.service.b.a(KsFullScreenLandScapeVideoActivity.class, KsFullScreenLandScapeVideoActivityProxy.class);
            intent = new Intent(context, (Class<?>) KsFullScreenLandScapeVideoActivity.class);
        } else {
            com.kwad.sdk.service.b.a(FeedDownloadActivity.class, KsFullScreenVideoActivityProxy.class);
            intent = new Intent(context, (Class<?>) FeedDownloadActivity.class);
        }
        intent.setFlags(268435456);
        intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.nt().j(adResultData));
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        intent.putExtra("key_video_play_config_json", com.kwad.components.core.internal.api.e.a(ksVideoPlayConfig));
        sHashMap.put(getListenerKey(o10), cVar);
        try {
            context.startActivity(intent);
            com.kwad.sdk.a.a.c.Bg().bk(true);
            reportSubPageCreate(PageCreateStage.END_LAUNCH.getStage(), o10);
        } catch (Throwable th2) {
            com.kwad.components.ad.reward.monitor.c.a(false, o10, PageCreateStage.ERROR_START_ACTIVITY.getStage(), th2.getMessage());
            throw th2;
        }
    }

    public boolean notifyPageDismiss() {
        if (this.mPageDismissCalled) {
            return false;
        }
        this.mPageDismissCalled = true;
        if (this.mAdTemplate != null && this.mAdInfo != null) {
            long time = getTimerHelper().getTime();
            com.kwad.sdk.a.a.c.Bg().Bj();
            com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, 6, time, this.mReportExtData);
            if (com.kwad.sdk.core.response.b.a.cT(this.mAdInfo) && !((com.kwad.components.ad.reward.g) this.mCallerContext).lm) {
                com.kwad.sdk.core.adlog.c.m(this.model.getAdTemplate(), (int) Math.ceil(time / 1000.0f));
            }
        }
        return true;
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.a(KsFullScreenVideoActivity.class, KsFullScreenVideoActivityProxy.class);
        com.kwad.sdk.service.b.a(FeedDownloadActivity.class, KsFullScreenVideoActivityProxy.class);
    }

    private static void reportSubPageCreate(String str, AdTemplate adTemplate) {
        com.kwad.components.ad.reward.monitor.c.c(false, adTemplate, str);
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(@Nullable Intent intent) {
        if (com.kwad.sdk.core.config.d.Eh()) {
            this.mVideoPlayConfig = com.kwad.components.core.internal.api.e.b(getIntent().getStringExtra("key_video_play_config_json"), true);
        } else {
            Serializable serializableExtra = getIntent().getSerializableExtra("key_video_play_config");
            if (serializableExtra instanceof KsVideoPlayConfig) {
                this.mVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
            }
        }
        AdResultData d10 = com.kwad.components.core.c.f.nt().d(getIntent().getIntExtra("key_ad_result_cache_idx", 0), true);
        this.mAdResultData = d10;
        if (d10 == null) {
            return false;
        }
        AdTemplate o10 = com.kwad.sdk.core.response.b.c.o(d10);
        this.mAdTemplate = o10;
        this.model = new b(o10);
        this.mAdOpenInteractionListener.setAdTemplate(this.mAdTemplate);
        return (this.mVideoPlayConfig == null || this.mAdTemplate == null) ? false : true;
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        super.finish();
        this.mAdOpenInteractionListener.i(false);
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        b bVar = this.model;
        return (bVar == null || !bVar.hG) ? R.layout.ksad_activity_fullscreen_video_legacy : R.layout.ksad_activity_fullscreen_tk;
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "KsFullScreenVideoActivityProxy";
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor
    public boolean handledAdLiveOnResume() {
        return ((com.kwad.components.ad.reward.g) this.mCallerContext).fR();
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mPageEnterTime = elapsedRealtime;
        com.kwad.components.ad.reward.monitor.c.a(false, this.mAdTemplate, elapsedRealtime);
        com.kwad.components.ad.reward.monitor.c.g(false, this.mAdTemplate);
        c cVar = sHashMap.get(getListenerKey(this.mAdTemplate));
        this.mInteractionListener = cVar;
        this.mAdOpenInteractionListener.a(cVar);
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
        this.mScreenOrientation = this.mVideoPlayConfig.isShowLandscape() ? 1 : 0;
        this.mAdTemplate.mInitVoiceStatus = this.mVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
        initVideoPlayConfig(this.mVideoPlayConfig);
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean needAdaptionScreen() {
        return true;
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.f
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.d.c.bG(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        com.kwad.components.ad.fullscreen.c.b bVar = this.mFullScreenPresenter;
        if ((bVar == null || !bVar.onBackPressed()) && this.mIsBackEnable) {
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.proxy.f
    public void onCreateCaughtException(Throwable th2) {
        super.onCreateCaughtException(th2);
        com.kwad.components.ad.reward.monitor.b.b(false, this.mAdTemplate);
    }

    @Override // com.kwad.components.core.l.b
    public Presenter onCreatePresenter() {
        getActivity();
        com.kwad.components.ad.fullscreen.c.b bVar = new com.kwad.components.ad.fullscreen.c.b(this, this.mRootContainer, this.model, (com.kwad.components.ad.reward.g) this.mCallerContext);
        this.mFullScreenPresenter = bVar;
        return bVar;
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.components.core.proxy.a.c
    public void onCreateStageChange(PageCreateStage pageCreateStage) {
        super.onCreateStageChange(pageCreateStage);
        reportSubPageCreate(pageCreateStage.getStage(), this.mAdTemplate);
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            this.mAdOpenInteractionListener.i(false);
            AdInfo adInfo = this.mAdInfo;
            if (adInfo != null) {
                String K = com.kwad.sdk.core.response.b.a.K(adInfo);
                if (!TextUtils.isEmpty(K)) {
                    com.kwad.sdk.core.videocache.c.a.bC(this.mContext.getApplicationContext()).eP(K);
                }
            }
            T t10 = this.mCallerContext;
            if (t10 != 0 && ((com.kwad.components.ad.reward.g) t10).f11689qf != null && ((com.kwad.components.ad.reward.g) t10).f11689qf.kh()) {
                ((com.kwad.components.ad.reward.g) this.mCallerContext).f11689qf.ki().removeInterceptor(this);
            }
            sHashMap.remove(getListenerKey(this.mAdTemplate));
            this.mInteractionListener = null;
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        try {
            super.onPause();
            getTimerHelper().Po();
            T t10 = this.mCallerContext;
            if (t10 != 0) {
                ((com.kwad.components.ad.reward.g) t10).mPageEnterTime = -1L;
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        try {
            super.onResume();
            getTimerHelper().Pn();
            if (this.mReportedPageResume) {
                return;
            }
            com.kwad.components.ad.reward.monitor.c.f(false, this.mAdTemplate);
            this.mReportedPageResume = true;
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @Override // com.kwad.components.core.l.b
    public com.kwad.components.ad.reward.g onCreateCallerContext() {
        com.kwad.components.ad.reward.g gVar = new com.kwad.components.ad.reward.g(this);
        gVar.a(this.mAdResultData);
        gVar.mPageEnterTime = this.mPageEnterTime;
        gVar.f11687qd = false;
        gVar.f11688qe = this.mAdOpenInteractionListener;
        gVar.mScreenOrientation = this.mScreenOrientation;
        gVar.mVideoPlayConfig = this.mVideoPlayConfig;
        gVar.mReportExtData = this.mReportExtData;
        gVar.mRootContainer = this.mRootContainer;
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            gVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate, this.mReportExtData);
        }
        gVar.f11692qi = new RewardActionBarControl(gVar, this.mContext, this.mAdTemplate);
        gVar.b(this.mPlayEndPageListener);
        if (com.kwad.sdk.core.response.b.b.cH(this.mAdTemplate)) {
            gVar.f11693qj = new j(gVar, this.mReportExtData, null);
        }
        if (com.kwad.sdk.core.response.b.a.bJ(this.mAdInfo)) {
            gVar.f11691qh = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.ksad_playable_webview));
        }
        gVar.qu = false;
        gVar.qS = com.kwad.sdk.core.response.b.a.bJ(this.mAdInfo) ? com.kwad.sdk.core.response.b.a.ar(this.mAdInfo) : com.kwad.sdk.core.response.b.a.am(this.mAdInfo);
        gVar.mTimerHelper = getTimerHelper();
        gVar.f11689qf = new com.kwad.components.ad.reward.m.e(gVar);
        return gVar;
    }
}
