package com.kwad.components.ad.interstitial.f;

import androidx.annotation.Nullable;
import com.kwad.components.core.video.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bt;

/* loaded from: classes2.dex */
public final class e extends b implements a.c {
    private static long lS = 1000;
    private c kY;

    @Nullable
    private a lT;
    private int lU;
    private AdTemplate mAdTemplate;

    public void D(int i10) {
        c cVar = this.kY;
        com.kwad.components.ad.interstitial.h.d dVar = cVar.kZ;
        if (dVar == null) {
            return;
        }
        if (i10 != 0) {
            dVar.b(true, i10);
        } else {
            if (cVar.dp()) {
                return;
            }
            this.kY.c(getContext(), this.mAdTemplate);
            dP();
            c cVar2 = this.kY;
            cVar2.a(true, -1, cVar2.co);
        }
    }

    private void dP() {
        com.kwad.sdk.core.video.videoview.a aVar = this.kY.co;
        if (aVar != null) {
            aVar.release();
        }
        this.kY.jz.dismiss();
        this.kY.X();
    }

    @Override // com.kwad.components.core.video.a.c
    public final void ap() {
    }

    @Override // com.kwad.components.core.video.a.c
    public final void aq() {
        if (this.kY.dp()) {
            return;
        }
        this.kY.c(getContext(), this.mAdTemplate);
        dP();
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.sdk.core.d.c.d("InterstitialPlayablePresenter", this + " onBind");
        c cVar = (c) Lj();
        this.kY = cVar;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        long j10 = eb2.adInsertScreenInfo.autoCloseTime;
        if (j10 > 0) {
            this.lU = (int) Math.min(com.kwad.components.ad.interstitial.b.b.b(eb2), j10);
        } else {
            this.lU = com.kwad.components.ad.interstitial.b.b.b(eb2);
        }
        com.kwad.components.ad.interstitial.h.d dVar = this.kY.kZ;
        if (dVar != null) {
            dVar.b(true, this.lU);
        }
        if (com.kwad.sdk.core.response.b.a.bc(eb2)) {
            this.lT = null;
            this.kY.a(this);
        } else {
            a aVar = new a(this, (byte) 0);
            this.lT = aVar;
            bt.a(aVar, null, 1000L);
        }
    }

    @Override // com.kwad.components.core.video.a.c
    public final void d(long j10) {
        D(this.lU - ((int) (j10 / 1000)));
    }

    @Override // com.kwad.components.ad.interstitial.f.b
    public final void dl() {
        super.dl();
        a aVar = this.lT;
        if (aVar != null) {
            aVar.s(false);
        }
    }

    @Override // com.kwad.components.ad.interstitial.f.b
    public final void dm() {
        super.dm();
        a aVar = this.lT;
        if (aVar != null) {
            aVar.s(true);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("InterstitialPlayablePresenter", this + " onUnbind");
        this.kY.b(this);
        a aVar = this.lT;
        if (aVar != null) {
            aVar.r(true);
            bt.c(this.lT);
            this.lT = null;
        }
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onVideoPlayStart() {
    }

    public class a implements Runnable {
        private int lV;
        private boolean lW;
        private boolean lX;

        private a() {
            this.lV = Integer.MIN_VALUE;
            this.lW = false;
            this.lX = false;
        }

        public final void r(boolean z10) {
            this.lX = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.lX) {
                return;
            }
            if (this.lW) {
                bt.a(this, null, e.lS);
                return;
            }
            if (this.lV == Integer.MIN_VALUE) {
                this.lV = e.this.lU;
            }
            if (this.lV < 0) {
                return;
            }
            com.kwad.sdk.core.d.c.d("InterstitialPlayablePresenter", e.this.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.lV);
            e.this.D(this.lV);
            this.lV = this.lV + (-1);
            bt.a(this, null, e.lS);
        }

        public final void s(boolean z10) {
            this.lW = z10;
        }

        public /* synthetic */ a(e eVar, byte b10) {
            this();
        }
    }
}
