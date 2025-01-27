package com.kwad.components.ad.draw.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.l.b;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.h.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.m;

/* loaded from: classes2.dex */
public final class a extends b {

    /* renamed from: dh */
    private com.kwad.components.core.widget.a.b f11446dh;
    private long ep;
    private com.kwad.sdk.contentalliance.a.a.a eq;
    private boolean er;
    private boolean es;
    private int et;
    private final c eu;
    private Context mContext;

    /* renamed from: com.kwad.components.ad.draw.c.a$1 */
    public class AnonymousClass1 implements c.e {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.video.a.c.e
        public final void a(com.kwad.sdk.core.video.a.c cVar) {
            try {
                a.this.start(m.eB(a.this.mAdTemplate));
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.draw.c.a$2 */
    public class AnonymousClass2 implements com.kwad.sdk.core.h.c {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.h.c
        public final void bl() {
            if (a.this.eq == null) {
                a aVar = a.this;
                aVar.eq = com.kwad.sdk.contentalliance.a.a.a.bL(aVar.mAdTemplate);
                a.this.Js.a(a.this.eq);
            }
            if (a.this.er) {
                return;
            }
            a.this.resume();
        }

        @Override // com.kwad.sdk.core.h.c
        public final void bm() {
            a.this.pause();
        }
    }

    public a(@NonNull AdTemplate adTemplate, @NonNull com.kwad.components.core.widget.a.b bVar, @NonNull DetailVideoView detailVideoView) {
        super(adTemplate, detailVideoView);
        this.es = false;
        this.et = -1;
        this.eu = new com.kwad.sdk.core.h.c() { // from class: com.kwad.components.ad.draw.c.a.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.h.c
            public final void bl() {
                if (a.this.eq == null) {
                    a aVar = a.this;
                    aVar.eq = com.kwad.sdk.contentalliance.a.a.a.bL(aVar.mAdTemplate);
                    a.this.Js.a(a.this.eq);
                }
                if (a.this.er) {
                    return;
                }
                a.this.resume();
            }

            @Override // com.kwad.sdk.core.h.c
            public final void bm() {
                a.this.pause();
            }
        };
        this.ep = com.kwad.sdk.core.response.b.a.ab(e.eb(this.mAdTemplate));
        this.f11446dh = bVar;
        this.mContext = detailVideoView.getContext();
        bk();
        if (com.kwad.sdk.core.response.b.a.ca(e.eb(this.mAdTemplate))) {
            this.Js.setVolume(0.0f, 0.0f);
            this.es = true;
        }
        this.Js.a(new c.e() { // from class: com.kwad.components.ad.draw.c.a.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    a.this.start(m.eB(a.this.mAdTemplate));
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        });
    }

    private void bk() {
        this.Js.a(new b.a(this.mAdTemplate).dc(e.ed(this.mAdTemplate)).dd(h.b(e.ec(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).Cz(), this.mDetailVideoView);
        this.Js.prepareAsync();
        if (this.et != -1 || this.es) {
            setVideoSound(!this.es);
        }
    }

    public void start(long j10) {
        if (this.f11446dh.ad()) {
            this.Js.a(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, j10));
            this.Js.start();
        }
    }

    public final void bi() {
        long eB = m.eB(this.mAdTemplate);
        if (this.Js.sv() == null) {
            bk();
        }
        start(eB);
        this.f11446dh.a(this.eu);
    }

    public final void bj() {
        this.eq = null;
        this.f11446dh.b(this.eu);
        this.Js.release();
    }

    public final void g(boolean z10) {
        this.er = z10;
    }

    @Override // com.kwad.components.ad.l.b, com.kwad.components.ad.l.a
    public final void resume() {
        super.resume();
        com.kwad.components.core.s.a.av(this.mContext).aO(false);
    }

    public final void setVideoSound(boolean z10) {
        com.kwad.components.core.video.b bVar = this.Js;
        if (bVar == null) {
            return;
        }
        if (z10) {
            bVar.setVolume(1.0f, 1.0f);
            this.es = false;
        } else {
            bVar.setVolume(0.0f, 0.0f);
            this.es = true;
        }
        this.et = 1;
    }
}
