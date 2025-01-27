package com.kwad.components.ad.splashscreen.b;

import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d extends e {
    private List<Integer> cI;
    private final com.kwad.components.core.video.i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.splashscreen.b.d.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            d.this.kL();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            d.this.c(j3);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            d.this.kK();
        }
    };

    /* renamed from: com.kwad.components.ad.splashscreen.b.d$1 */
    final class AnonymousClass1 extends com.kwad.components.core.video.j {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            d.this.kL();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            d.this.c(j3);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            d.this.kK();
        }
    }

    public void c(long j2) {
        int ceil = (int) Math.ceil(j2 / 1000.0f);
        List<Integer> list = this.cI;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.cI.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.a(this.Cg.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    public void kK() {
        com.kwad.sdk.core.report.a.h(this.Cg.mAdTemplate);
    }

    public void kL() {
        com.kwad.sdk.core.report.a.av(this.Cg.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.cI = com.kwad.sdk.core.response.a.a.bd(com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate));
        com.kwad.components.ad.splashscreen.d.a aVar = this.Cg.BG;
        if (aVar != null) {
            aVar.a(this.mVideoPlayStateListener);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.d.a aVar = this.Cg.BG;
        if (aVar != null) {
            aVar.b(this.mVideoPlayStateListener);
        }
    }
}
