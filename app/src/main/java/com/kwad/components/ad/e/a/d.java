package com.kwad.components.ad.e.a;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ag;

/* loaded from: classes.dex */
public final class d extends com.kwad.components.ad.e.kwai.a {
    private View ns;

    /* renamed from: com.kwad.components.ad.e.a.d$1 */
    final class AnonymousClass1 extends com.kwad.components.core.video.j {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            super.onVideoPlayStart();
            d.this.eT();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlaying() {
            super.onVideoPlaying();
            d.this.eT();
        }
    }

    public void eT() {
        if (this.ns.getVisibility() != 0) {
            return;
        }
        this.ns.setVisibility(8);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (ag.isNetworkConnected(this.ns.getContext())) {
            this.ns.setVisibility(8);
            return;
        }
        this.ns.setVisibility(0);
        AnonymousClass1 anonymousClass1 = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.d.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayStart() {
                super.onVideoPlayStart();
                d.this.eT();
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlaying() {
                super.onVideoPlaying();
                d.this.eT();
            }
        };
        this.mVideoPlayStateListener = anonymousClass1;
        this.ni.nj.a(anonymousClass1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ns = findViewById(R.id.ksad_video_network_unavailable);
    }
}
