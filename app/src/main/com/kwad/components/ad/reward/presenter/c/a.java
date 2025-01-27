package com.kwad.components.ad.reward.presenter.c;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.m;
import com.kwad.components.ad.reward.model.EcOrderCardStyle;
import com.kwad.components.ad.reward.monitor.c;
import com.kwad.components.ad.reward.presenter.b;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.l;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import java.util.List;

/* loaded from: classes2.dex */
public final class a extends b {

    /* renamed from: ci */
    private List<Integer> f11747ci;
    private AdInfo mAdInfo;
    private l tX;
    private final i vx = new i();
    private long qK = 0;

    /* renamed from: hf */
    private Handler f11748hf = new Handler(Looper.getMainLooper());
    private boolean vy = true;
    private volatile boolean dP = false;
    private Runnable vz = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.1
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.vx.sV()) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.vx.sX();
                int sY = a.this.vx.sW().sY();
                a.this.rO.a(elapsedRealtime, a.this.vx.sW().sZ(), sY);
            } else if (a.this.vy) {
                a.this.rO.a(5000L, 5000L, 1);
            }
            com.kwad.components.core.o.a.ri().aD(a.this.mAdTemplate);
        }
    };
    private l tY = new l() { // from class: com.kwad.components.ad.reward.presenter.c.a.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.hR();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            a.this.vx.sU();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            a.this.c(j11);
            a.this.qK = j11;
            a.this.vx.sU();
            a.a(a.this, false);
            a.this.rO.qK = j11;
            if (a.this.dP) {
                return;
            }
            a.b(a.this, true);
            com.kwad.components.core.o.a.ri().b(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            c.b(a.this.rO.qu, a.this.mAdTemplate, a.this.rO.mPageEnterTime);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.il();
        }
    };

    /* renamed from: ia */
    private l f11749ia = new l() { // from class: com.kwad.components.ad.reward.presenter.c.a.3
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            a.this.hR();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            super.onMediaPlayError(i10, i11);
            c.a(a.this.rO.qu, a.this.rO.mAdTemplate, a.this.rO.qT, i10, i11);
            com.kwad.components.ad.reward.monitor.b.c(a.this.rO.qu, a.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            a.this.vx.sU();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            a.this.c(j11);
            a.this.qK = j11;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.il();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            a.this.vx.sU();
            a.a(a.this, false);
            if (a.this.dP) {
                return;
            }
            a.b(a.this, true);
            com.kwad.components.core.o.a.ri().b(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            c.b(a.this.rO.qu, a.this.mAdTemplate, a.this.rO.mPageEnterTime);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPaused() {
            super.onVideoPlayBufferingPaused();
            a.this.vx.sT();
            a.this.f11748hf.removeCallbacks(a.this.vz);
            a.this.f11748hf.postDelayed(a.this.vz, 5000L);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPlaying() {
            super.onVideoPlayBufferingPlaying();
            a.this.vx.sT();
            a.this.f11748hf.removeCallbacks(a.this.vz);
            a.this.f11748hf.postDelayed(a.this.vz, 5000L);
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.c.a$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.vx.sV()) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.vx.sX();
                int sY = a.this.vx.sW().sY();
                a.this.rO.a(elapsedRealtime, a.this.vx.sW().sZ(), sY);
            } else if (a.this.vy) {
                a.this.rO.a(5000L, 5000L, 1);
            }
            com.kwad.components.core.o.a.ri().aD(a.this.mAdTemplate);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.c.a$2 */
    public class AnonymousClass2 extends l {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.hR();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            a.this.vx.sU();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            a.this.c(j11);
            a.this.qK = j11;
            a.this.vx.sU();
            a.a(a.this, false);
            a.this.rO.qK = j11;
            if (a.this.dP) {
                return;
            }
            a.b(a.this, true);
            com.kwad.components.core.o.a.ri().b(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            c.b(a.this.rO.qu, a.this.mAdTemplate, a.this.rO.mPageEnterTime);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.il();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.c.a$3 */
    public class AnonymousClass3 extends l {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            a.this.hR();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            super.onMediaPlayError(i10, i11);
            c.a(a.this.rO.qu, a.this.rO.mAdTemplate, a.this.rO.qT, i10, i11);
            com.kwad.components.ad.reward.monitor.b.c(a.this.rO.qu, a.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            a.this.vx.sU();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            a.this.c(j11);
            a.this.qK = j11;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.il();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            a.this.vx.sU();
            a.a(a.this, false);
            if (a.this.dP) {
                return;
            }
            a.b(a.this, true);
            com.kwad.components.core.o.a.ri().b(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            c.b(a.this.rO.qu, a.this.mAdTemplate, a.this.rO.mPageEnterTime);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPaused() {
            super.onVideoPlayBufferingPaused();
            a.this.vx.sT();
            a.this.f11748hf.removeCallbacks(a.this.vz);
            a.this.f11748hf.postDelayed(a.this.vz, 5000L);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPlaying() {
            super.onVideoPlayBufferingPlaying();
            a.this.vx.sT();
            a.this.f11748hf.removeCallbacks(a.this.vz);
            a.this.f11748hf.postDelayed(a.this.vz, 5000L);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.c.a$4 */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            m.a(1, a.this.rO);
        }
    }

    private void checkExposure() {
        AdInfo adInfo = this.mAdInfo;
        long j10 = adInfo.adRewardInfo.callBackStrategyInfo.impressionCheckMs;
        if (j10 <= 0 || com.kwad.sdk.core.response.b.a.ag(adInfo) <= 5000) {
            return;
        }
        this.f11748hf.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.4
            public AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                m.a(1, a.this.rO);
            }
        }, j10);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        AdInfo eb2 = e.eb(this.mAdTemplate);
        this.mAdInfo = eb2;
        this.f11747ci = com.kwad.sdk.core.response.b.a.bo(eb2);
        if (this.rO.f11689qf.kh()) {
            this.tX = this.tY;
        } else {
            this.tX = this.f11749ia;
        }
        this.rO.f11689qf.a(this.tX);
        this.f11748hf.postDelayed(this.vz, 5000L);
    }

    public final void hR() {
        g gVar = this.rO;
        if (!gVar.qu || !gVar.qz) {
            com.kwad.sdk.core.adlog.c.g(this.mAdTemplate, gVar.mReportExtData);
        }
        this.vx.sU();
    }

    public final void il() {
        this.dP = false;
        EcOrderCardStyle createFromAdInfo = EcOrderCardStyle.createFromAdInfo(this.mAdInfo);
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        if (createFromAdInfo != null) {
            a.C0484a c0484a = new a.C0484a();
            c0484a.asB = String.valueOf(createFromAdInfo.getValue());
            bVar.b(c0484a);
        }
        if (!this.mAdTemplate.mPvReported) {
            checkExposure();
        }
        com.kwad.components.ad.reward.j.b.a(true, this.mAdTemplate, null, bVar);
        com.kwad.sdk.core.adlog.c.f(this.mAdTemplate, this.rO.mReportExtData);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f11748hf.removeCallbacksAndMessages(null);
        this.rO.f11689qf.b(this.tX);
        i.a sW = this.vx.sW();
        com.kwad.components.core.o.a.ri().a(this.rO.mAdTemplate, this.qK, sW.sZ(), sW.sY());
    }

    public void c(long j10) {
        int ceil = (int) Math.ceil(j10 / 1000.0f);
        List<Integer> list = this.f11747ci;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f11747ci) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, ceil, this.rO.mReportExtData);
                this.f11747ci.remove(num);
                return;
            }
        }
    }

    public static /* synthetic */ boolean a(a aVar, boolean z10) {
        aVar.vy = false;
        return false;
    }

    public static /* synthetic */ boolean b(a aVar, boolean z10) {
        aVar.dP = true;
        return true;
    }
}
