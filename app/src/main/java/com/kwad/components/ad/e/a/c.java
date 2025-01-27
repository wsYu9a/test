package com.kwad.components.ad.e.a;

import android.view.View;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c extends com.kwad.components.ad.e.kwai.a {
    private List<Integer> cI;
    private volatile boolean cJ = false;

    /* renamed from: com.kwad.components.ad.e.a.c$1 */
    final class AnonymousClass1 extends com.kwad.components.core.video.j {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            com.kwad.sdk.core.report.a.av(c.this.ni.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            c.this.c(j3);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            c.this.cJ = false;
            if (!c.this.ni.mAdTemplate.mPvReported) {
                c.this.ni.mR.eO();
            }
            com.kwad.sdk.core.report.i iVar = new com.kwad.sdk.core.report.i();
            View view = (View) c.this.ni.nd.getParent();
            if (view != null) {
                iVar.q(view.getHeight(), view.getWidth());
            }
            com.kwad.components.core.r.b.pK().a(c.this.ni.mAdTemplate, null, iVar);
            com.kwad.sdk.core.report.a.h(c.this.ni.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlaying() {
            if (c.this.cJ) {
                return;
            }
            c.this.cJ = true;
            com.kwad.components.core.m.a.pb().a(c.this.ni.mAdTemplate, System.currentTimeMillis(), 1);
        }
    }

    public void c(long j2) {
        int ceil = (int) Math.ceil(j2 / 1000.0f);
        List<Integer> list = this.cI;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.cI) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.report.a.a(this.ni.mAdTemplate, ceil, (JSONObject) null);
                this.cI.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.cI = com.kwad.sdk.core.response.a.a.bd(com.kwad.sdk.core.response.a.d.cb(this.ni.mAdTemplate));
        AnonymousClass1 anonymousClass1 = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.c.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                com.kwad.sdk.core.report.a.av(c.this.ni.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayProgress(long j2, long j3) {
                c.this.c(j3);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayStart() {
                c.this.cJ = false;
                if (!c.this.ni.mAdTemplate.mPvReported) {
                    c.this.ni.mR.eO();
                }
                com.kwad.sdk.core.report.i iVar = new com.kwad.sdk.core.report.i();
                View view = (View) c.this.ni.nd.getParent();
                if (view != null) {
                    iVar.q(view.getHeight(), view.getWidth());
                }
                com.kwad.components.core.r.b.pK().a(c.this.ni.mAdTemplate, null, iVar);
                com.kwad.sdk.core.report.a.h(c.this.ni.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlaying() {
                if (c.this.cJ) {
                    return;
                }
                c.this.cJ = true;
                com.kwad.components.core.m.a.pb().a(c.this.ni.mAdTemplate, System.currentTimeMillis(), 1);
            }
        };
        this.mVideoPlayStateListener = anonymousClass1;
        this.ni.nj.a(anonymousClass1);
    }
}
