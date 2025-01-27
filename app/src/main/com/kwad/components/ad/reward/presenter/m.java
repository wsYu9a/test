package com.kwad.components.ad.reward.presenter;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes2.dex */
public final class m extends b {
    private long iy;

    /* renamed from: qe */
    @NonNull
    private com.kwad.components.ad.reward.e.b f11793qe;
    private com.kwad.components.core.video.l tX;
    private com.kwad.components.core.video.l tY = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.m.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.rO;
            if (gVar.qu && gVar.qz) {
                mVar.f11793qe.onVideoSkipToEnd(m.this.iy);
            } else {
                gVar.qU = true;
                mVar.f11793qe.onVideoPlayEnd();
            }
            AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(m.this.rO.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aO(eb2) && com.kwad.sdk.core.response.b.a.aN(eb2) == 1) {
                return;
            }
            f.u(m.this.rO);
            com.kwad.components.ad.reward.g gVar2 = m.this.rO;
            if (gVar2.qU) {
                com.kwad.components.ad.reward.l.j(gVar2);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.rO;
            gVar.qT = j11;
            if (gVar.qz) {
                return;
            }
            mVar.iy = j11;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            m.this.f11793qe.onVideoPlayStart();
            m.this.rO.qU = false;
        }
    };

    /* renamed from: ia */
    private final com.kwad.components.core.video.l f11792ia = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.m.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            m mVar = m.this;
            if (mVar.rO.qz) {
                mVar.f11793qe.onVideoSkipToEnd(m.this.iy);
            } else {
                mVar.f11793qe.onVideoPlayEnd();
            }
            AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(m.this.rO.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aO(eb2) && com.kwad.sdk.core.response.b.a.aN(eb2) == 1) {
                return;
            }
            f.u(m.this.rO);
            com.kwad.components.ad.reward.g gVar = m.this.rO;
            if (gVar.qU) {
                com.kwad.components.ad.reward.l.j(gVar);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            m.this.f11793qe.onVideoPlayError(i10, i11);
            m.this.hK();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.rO;
            gVar.qT = j11;
            gVar.qU = j10 - j11 < 800;
            if (gVar.qz) {
                return;
            }
            mVar.iy = j11;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            m.this.f11793qe.onVideoPlayStart();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.m$1 */
    public class AnonymousClass1 extends com.kwad.components.core.video.l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.rO;
            if (gVar.qu && gVar.qz) {
                mVar.f11793qe.onVideoSkipToEnd(m.this.iy);
            } else {
                gVar.qU = true;
                mVar.f11793qe.onVideoPlayEnd();
            }
            AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(m.this.rO.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aO(eb2) && com.kwad.sdk.core.response.b.a.aN(eb2) == 1) {
                return;
            }
            f.u(m.this.rO);
            com.kwad.components.ad.reward.g gVar2 = m.this.rO;
            if (gVar2.qU) {
                com.kwad.components.ad.reward.l.j(gVar2);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.rO;
            gVar.qT = j11;
            if (gVar.qz) {
                return;
            }
            mVar.iy = j11;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            m.this.f11793qe.onVideoPlayStart();
            m.this.rO.qU = false;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.m$2 */
    public class AnonymousClass2 extends com.kwad.components.core.video.l {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            m mVar = m.this;
            if (mVar.rO.qz) {
                mVar.f11793qe.onVideoSkipToEnd(m.this.iy);
            } else {
                mVar.f11793qe.onVideoPlayEnd();
            }
            AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(m.this.rO.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aO(eb2) && com.kwad.sdk.core.response.b.a.aN(eb2) == 1) {
                return;
            }
            f.u(m.this.rO);
            com.kwad.components.ad.reward.g gVar = m.this.rO;
            if (gVar.qU) {
                com.kwad.components.ad.reward.l.j(gVar);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            m.this.f11793qe.onVideoPlayError(i10, i11);
            m.this.hK();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.rO;
            gVar.qT = j11;
            gVar.qU = j10 - j11 < 800;
            if (gVar.qz) {
                return;
            }
            mVar.iy = j11;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            m.this.f11793qe.onVideoPlayStart();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.components.ad.reward.g gVar = this.rO;
        gVar.qT = 0L;
        gVar.qU = false;
        this.f11793qe = gVar.f11688qe;
        if (gVar.f11689qf.kh()) {
            this.tX = this.tY;
        } else {
            this.tX = this.f11792ia;
        }
        this.rO.f11689qf.a(this.tX);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.rO.f11689qf.b(this.tX);
    }
}
