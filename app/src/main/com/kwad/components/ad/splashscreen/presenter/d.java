package com.kwad.components.ad.splashscreen.presenter;

import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d extends e {

    /* renamed from: ci */
    private List<Integer> f11901ci;
    private final com.kwad.components.core.video.k mVideoPlayStateListener = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.splashscreen.presenter.d.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            d.this.lu();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            d.this.c(j11);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            d.this.lt();
        }
    };

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.d$1 */
    public class AnonymousClass1 extends com.kwad.components.core.video.l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            d.this.lu();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            d.this.c(j11);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            d.this.lt();
        }
    }

    public void c(long j10) {
        int ceil = (int) Math.ceil(j10 / 1000.0f);
        List<Integer> list = this.f11901ci;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f11901ci.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.EJ.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    public void lt() {
        com.kwad.sdk.core.adlog.c.bS(this.EJ.mAdTemplate);
    }

    public void lu() {
        com.kwad.sdk.core.adlog.c.bT(this.EJ.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.f11901ci = com.kwad.sdk.core.response.b.a.bo(com.kwad.sdk.core.response.b.e.eb(this.EJ.mAdTemplate));
        com.kwad.components.ad.splashscreen.d.a aVar = this.EJ.DT;
        if (aVar != null) {
            aVar.b(this.mVideoPlayStateListener);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.d.a aVar = this.EJ.DT;
        if (aVar != null) {
            aVar.a(this.mVideoPlayStateListener);
        }
    }
}
