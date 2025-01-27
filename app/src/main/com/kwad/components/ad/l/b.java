package com.kwad.components.ad.l;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes2.dex */
public class b extends a<k> {
    public com.kwad.components.core.video.b Js;
    private boolean Jt;
    private k Ju;
    protected DetailVideoView mDetailVideoView;

    /* renamed from: com.kwad.components.ad.l.b$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            b.this.mAdTemplate.setmCurPlayTime(-1L);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            try {
                super.onMediaPlayError(i10, i11);
                if (!b.this.Jt) {
                    b.this.mW();
                } else if (d.DY()) {
                    b.this.mW();
                }
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            b.this.mAdTemplate.setmCurPlayTime(j11);
        }
    }

    public b(@NonNull AdTemplate adTemplate, DetailVideoView detailVideoView) {
        super(adTemplate);
        this.Jt = false;
        this.Ju = new l() { // from class: com.kwad.components.ad.l.b.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                b.this.mAdTemplate.setmCurPlayTime(-1L);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i10, int i11) {
                try {
                    super.onMediaPlayError(i10, i11);
                    if (!b.this.Jt) {
                        b.this.mW();
                    } else if (d.DY()) {
                        b.this.mW();
                    }
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j10, long j11) {
                b.this.mAdTemplate.setmCurPlayTime(j11);
            }
        };
        this.mDetailVideoView = detailVideoView;
        this.Js = new com.kwad.components.core.video.b(this.mDetailVideoView, adTemplate);
        mU();
    }

    private void mU() {
        this.Js.c(this.Ju);
    }

    private void mV() {
        k kVar;
        com.kwad.components.core.video.b bVar = this.Js;
        if (bVar == null || (kVar = this.Ju) == null) {
            return;
        }
        bVar.d(kVar);
        this.Ju = null;
    }

    public void mW() {
        com.kwad.components.core.o.a.ri().f(this.mAdTemplate, 21008);
        this.Jt = true;
    }

    @Override // com.kwad.components.ad.l.a
    public long getPlayDuration() {
        com.kwad.components.core.video.b bVar = this.Js;
        if (bVar != null) {
            return bVar.getPlayDuration();
        }
        return 0L;
    }

    @Override // com.kwad.components.ad.l.a
    public void pause() {
        this.Js.pause();
    }

    @Override // com.kwad.components.ad.l.a
    @WorkerThread
    public void release() {
        super.release();
        this.Jt = false;
        mV();
        com.kwad.components.core.video.b bVar = this.Js;
        if (bVar != null) {
            bVar.clear();
            this.Js.release();
        }
    }

    @Override // com.kwad.components.ad.l.a
    public void resume() {
        this.Js.resume();
    }

    @Override // com.kwad.components.ad.l.a
    @MainThread
    /* renamed from: a */
    public final void b(k kVar) {
        com.kwad.components.core.video.b bVar;
        if (kVar == null || (bVar = this.Js) == null) {
            return;
        }
        bVar.c(kVar);
    }

    @Override // com.kwad.components.ad.l.a
    @MainThread
    /* renamed from: b */
    public final void a(k kVar) {
        if (kVar == null) {
            return;
        }
        this.Js.d(kVar);
    }
}
