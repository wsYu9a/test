package com.kwad.components.ad.g.b;

import android.view.View;
import com.kwad.components.core.video.l;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c extends com.kwad.components.ad.g.a.a {

    /* renamed from: ci */
    private List<Integer> f11533ci;
    private volatile boolean dP = false;

    /* renamed from: com.kwad.components.ad.g.b.c$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            com.kwad.sdk.core.adlog.c.bT(c.this.f11530oe.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            c.this.c(j11);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            c.this.dP = false;
            if (!c.this.f11530oe.mAdTemplate.mPvReported) {
                c.this.f11530oe.nN.eL();
            }
            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
            View view = (View) c.this.f11530oe.nZ.getParent();
            if (view != null) {
                bVar.v(view.getHeight(), view.getWidth());
            }
            com.kwad.components.core.s.b.sc().a(c.this.f11530oe.mAdTemplate, null, bVar);
            com.kwad.sdk.core.adlog.c.bS(c.this.f11530oe.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            if (c.this.dP) {
                return;
            }
            c.this.dP = true;
            com.kwad.components.core.o.a.ri().b(c.this.f11530oe.mAdTemplate, System.currentTimeMillis(), 1);
        }
    }

    @Override // com.kwad.components.ad.g.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.f11533ci = com.kwad.sdk.core.response.b.a.bo(com.kwad.sdk.core.response.b.e.eb(this.f11530oe.mAdTemplate));
        AnonymousClass1 anonymousClass1 = new l() { // from class: com.kwad.components.ad.g.b.c.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                com.kwad.sdk.core.adlog.c.bT(c.this.f11530oe.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j10, long j11) {
                c.this.c(j11);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                c.this.dP = false;
                if (!c.this.f11530oe.mAdTemplate.mPvReported) {
                    c.this.f11530oe.nN.eL();
                }
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                View view = (View) c.this.f11530oe.nZ.getParent();
                if (view != null) {
                    bVar.v(view.getHeight(), view.getWidth());
                }
                com.kwad.components.core.s.b.sc().a(c.this.f11530oe.mAdTemplate, null, bVar);
                com.kwad.sdk.core.adlog.c.bS(c.this.f11530oe.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                if (c.this.dP) {
                    return;
                }
                c.this.dP = true;
                com.kwad.components.core.o.a.ri().b(c.this.f11530oe.mAdTemplate, System.currentTimeMillis(), 1);
            }
        };
        this.mVideoPlayStateListener = anonymousClass1;
        this.f11530oe.f11531of.b((com.kwad.components.core.video.k) anonymousClass1);
    }

    public void c(long j10) {
        int ceil = (int) Math.ceil(j10 / 1000.0f);
        List<Integer> list = this.f11533ci;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f11533ci) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.f11530oe.mAdTemplate, ceil, (JSONObject) null);
                this.f11533ci.remove(num);
                return;
            }
        }
    }
}
