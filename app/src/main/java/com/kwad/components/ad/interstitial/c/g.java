package com.kwad.components.ad.interstitial.c;

import androidx.annotation.Nullable;
import com.kwad.components.core.video.a;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;

/* loaded from: classes.dex */
public final class g extends b implements a.c {
    private static long ld = 1000;
    private c jt;

    @Nullable
    private a le;
    private int lf;
    private AdTemplate mAdTemplate;

    class a implements Runnable {
        private int lg;
        private boolean lh;
        private boolean li;

        private a() {
            this.lg = Integer.MIN_VALUE;
            this.lh = false;
            this.li = false;
        }

        /* synthetic */ a(g gVar, byte b2) {
            this();
        }

        public final void q(boolean z) {
            this.li = true;
        }

        public final void r(boolean z) {
            this.lh = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.li) {
                return;
            }
            if (!this.lh) {
                if (this.lg == Integer.MIN_VALUE) {
                    this.lg = g.this.lf;
                }
                if (this.lg < 0) {
                    return;
                }
                com.kwad.sdk.core.d.b.d("InterstitialPlayablePresenter", g.this.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.lg);
                g.this.H(this.lg);
                this.lg = this.lg + (-1);
            }
            bi.a(this, null, g.ld);
        }
    }

    public void H(int i2) {
        c cVar = this.jt;
        com.kwad.components.ad.interstitial.e.f fVar = cVar.ju;
        if (fVar == null) {
            return;
        }
        if (i2 != 0) {
            fVar.b(true, i2);
        } else {
            if (cVar.da()) {
                return;
            }
            this.jt.b(getContext(), this.mAdTemplate);
            dx();
            c cVar2 = this.jt;
            cVar2.a(true, -1, cVar2.eN);
        }
    }

    private void dx() {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        com.kwad.sdk.core.video.videoview.a aVar = this.jt.eN;
        if (aVar != null) {
            aVar.release();
        }
        this.jt.hU.dismiss();
        c cVar = this.jt;
        if (cVar.jy || (adInteractionListener = cVar.hN) == null) {
            return;
        }
        adInteractionListener.onAdClosed();
    }

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.sdk.core.d.b.d("InterstitialPlayablePresenter", this + " onBind");
        c cVar = (c) Bh();
        this.jt = cVar;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        long j2 = cb.adInsertScreenInfo.autoCloseTime;
        if (j2 > 0) {
            this.lf = (int) Math.min(com.kwad.components.ad.interstitial.kwai.b.b(cb), j2);
        } else {
            this.lf = com.kwad.components.ad.interstitial.kwai.b.b(cb);
        }
        com.kwad.components.ad.interstitial.e.f fVar = this.jt.ju;
        if (fVar != null) {
            fVar.b(true, this.lf);
        }
        if (com.kwad.sdk.core.response.a.a.aU(cb)) {
            this.le = null;
            this.jt.a(this);
        } else {
            a aVar = new a(this, (byte) 0);
            this.le = aVar;
            bi.a(aVar, null, 1000L);
        }
    }

    @Override // com.kwad.components.core.video.a.c
    public final void bt() {
        if (this.jt.da()) {
            return;
        }
        this.jt.b(getContext(), this.mAdTemplate);
        dx();
    }

    @Override // com.kwad.components.ad.interstitial.c.b
    public final void cT() {
        super.cT();
        a aVar = this.le;
        if (aVar != null) {
            aVar.r(false);
        }
    }

    @Override // com.kwad.components.ad.interstitial.c.b
    public final void cU() {
        super.cU();
        a aVar = this.le;
        if (aVar != null) {
            aVar.r(true);
        }
    }

    @Override // com.kwad.components.core.video.a.c
    public final void d(long j2) {
        H(this.lf - ((int) (j2 / 1000)));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.b.d("InterstitialPlayablePresenter", this + " onUnbind");
        this.jt.b(this);
        a aVar = this.le;
        if (aVar != null) {
            aVar.q(true);
            bi.b(this.le);
            this.le = null;
        }
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onVideoPlayStart() {
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onVideoPlaying() {
    }
}
