package com.kwad.components.ad.reward.presenter.b;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.components.ad.reward.model.EcOrderCardStyle;
import com.kwad.components.ad.reward.n;
import com.kwad.components.core.r.b;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* loaded from: classes.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a {
    private List<Integer> cI;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private final g tJ = new g();
    private long mPlayTime = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean tK = true;
    private volatile boolean cJ = false;
    private Runnable tL = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.b.a.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.tJ.qE()) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.tJ.qG();
                int qH = a.this.tJ.qF().qH();
                a.this.qt.a(elapsedRealtime, a.this.tJ.qF().qI(), qH);
            } else if (a.this.tK) {
                a.this.qt.a(5000L, 5000L, 1);
            }
            com.kwad.components.core.m.a.pb().P(a.this.mAdTemplate);
        }
    };
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.b.a.2
        AnonymousClass2() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            a.this.hx();
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayPause() {
            super.onLivePlayPause();
            a.this.tJ.qD();
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            a.this.c(j2);
            a.this.mPlayTime = j2;
            a.this.tJ.qD();
            a.a(a.this, false);
            if (a.this.cJ) {
                return;
            }
            a.b(a.this, true);
            com.kwad.components.core.m.a.pb().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            com.kwad.components.ad.reward.monitor.a.b(a.this.qt.pf, a.this.mAdTemplate, a.this.qt.mPageEnterTime);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            a.this.hQ();
        }
    };
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.reward.presenter.b.a.3
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayBufferingPaused() {
            super.onVideoPlayBufferingPaused();
            a.this.tJ.qC();
            a.this.mHandler.removeCallbacks(a.this.tL);
            a.this.mHandler.postDelayed(a.this.tL, 5000L);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayBufferingPlaying() {
            super.onVideoPlayBufferingPlaying();
            a.this.tJ.qC();
            a.this.mHandler.removeCallbacks(a.this.tL);
            a.this.mHandler.postDelayed(a.this.tL, 5000L);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            a.this.hx();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            super.onVideoPlayError(i2, i3);
            com.kwad.components.ad.reward.monitor.a.a(a.this.qt.pf, a.this.qt.mAdTemplate, a.this.qt.pB, i2, i3);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayPaused() {
            super.onVideoPlayPaused();
            a.this.tJ.qD();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            a.this.c(j3);
            a.this.mPlayTime = j3;
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            super.onVideoPlayStart();
            a.this.hQ();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlaying() {
            super.onVideoPlaying();
            a.this.tJ.qD();
            a.a(a.this, false);
            if (a.this.cJ) {
                return;
            }
            a.b(a.this, true);
            com.kwad.components.core.m.a.pb().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            com.kwad.components.ad.reward.monitor.a.b(a.this.qt.pf, a.this.mAdTemplate, a.this.qt.mPageEnterTime);
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.b.a$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.tJ.qE()) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.tJ.qG();
                int qH = a.this.tJ.qF().qH();
                a.this.qt.a(elapsedRealtime, a.this.tJ.qF().qI(), qH);
            } else if (a.this.tK) {
                a.this.qt.a(5000L, 5000L, 1);
            }
            com.kwad.components.core.m.a.pb().P(a.this.mAdTemplate);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.b.a$2 */
    final class AnonymousClass2 extends AdLivePlayStateListenerAdapter {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            a.this.hx();
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayPause() {
            super.onLivePlayPause();
            a.this.tJ.qD();
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            a.this.c(j2);
            a.this.mPlayTime = j2;
            a.this.tJ.qD();
            a.a(a.this, false);
            if (a.this.cJ) {
                return;
            }
            a.b(a.this, true);
            com.kwad.components.core.m.a.pb().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            com.kwad.components.ad.reward.monitor.a.b(a.this.qt.pf, a.this.mAdTemplate, a.this.qt.mPageEnterTime);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            a.this.hQ();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.b.a$3 */
    final class AnonymousClass3 extends j {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayBufferingPaused() {
            super.onVideoPlayBufferingPaused();
            a.this.tJ.qC();
            a.this.mHandler.removeCallbacks(a.this.tL);
            a.this.mHandler.postDelayed(a.this.tL, 5000L);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayBufferingPlaying() {
            super.onVideoPlayBufferingPlaying();
            a.this.tJ.qC();
            a.this.mHandler.removeCallbacks(a.this.tL);
            a.this.mHandler.postDelayed(a.this.tL, 5000L);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            a.this.hx();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            super.onVideoPlayError(i2, i3);
            com.kwad.components.ad.reward.monitor.a.a(a.this.qt.pf, a.this.qt.mAdTemplate, a.this.qt.pB, i2, i3);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayPaused() {
            super.onVideoPlayPaused();
            a.this.tJ.qD();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            a.this.c(j3);
            a.this.mPlayTime = j3;
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            super.onVideoPlayStart();
            a.this.hQ();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlaying() {
            super.onVideoPlaying();
            a.this.tJ.qD();
            a.a(a.this, false);
            if (a.this.cJ) {
                return;
            }
            a.b(a.this, true);
            com.kwad.components.core.m.a.pb().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            com.kwad.components.ad.reward.monitor.a.b(a.this.qt.pf, a.this.mAdTemplate, a.this.qt.mPageEnterTime);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.b.a$4 */
    final class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            n.a(1, a.this.qt);
        }
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.tK = false;
        return false;
    }

    static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.cJ = true;
        return true;
    }

    public void c(long j2) {
        int ceil = (int) Math.ceil(j2 / 1000.0f);
        List<Integer> list = this.cI;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.cI) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.report.a.a(this.mAdTemplate, ceil, this.qt.mReportExtData);
                this.cI.remove(num);
                return;
            }
        }
    }

    private void checkExposure() {
        AdInfo adInfo = this.mAdInfo;
        long j2 = adInfo.adRewardInfo.callBackStrategyInfo.impressionCheckMs;
        if (j2 <= 0 || com.kwad.sdk.core.response.a.a.X(adInfo) <= 5000) {
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.b.a.4
            AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                n.a(1, a.this.qt);
            }
        }, j2);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        AdTemplate adTemplate = this.qt.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo cb = d.cb(adTemplate);
        this.mAdInfo = cb;
        this.cI = com.kwad.sdk.core.response.a.a.bd(cb);
        this.qt.oN.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        this.mHandler.postDelayed(this.tL, 5000L);
    }

    public final void hQ() {
        com.kwad.sdk.core.report.i iVar;
        this.cJ = false;
        EcOrderCardStyle createFromAdInfo = EcOrderCardStyle.createFromAdInfo(this.mAdInfo);
        if (createFromAdInfo != null) {
            iVar = new com.kwad.sdk.core.report.i();
            y.a aVar = new y.a();
            aVar.ajZ = String.valueOf(createFromAdInfo.getValue());
            iVar.a(aVar);
        } else {
            iVar = null;
        }
        if (!this.mAdTemplate.mPvReported) {
            checkExposure();
        }
        b.pK().a(this.mAdTemplate, null, iVar);
        com.kwad.sdk.core.report.a.g(this.mAdTemplate, this.qt.mReportExtData);
    }

    public final void hx() {
        com.kwad.components.ad.reward.j jVar = this.qt;
        if (!jVar.pf || !jVar.pk) {
            com.kwad.sdk.core.report.a.h(this.mAdTemplate, jVar.mReportExtData);
        }
        this.tJ.qD();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mHandler.removeCallbacksAndMessages(null);
        this.qt.oN.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        g.a qF = this.tJ.qF();
        com.kwad.components.core.m.a.pb().a(this.qt.mAdTemplate, this.mPlayTime, qF.qI(), qF.qH());
    }
}
