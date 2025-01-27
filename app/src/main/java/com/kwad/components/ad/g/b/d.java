package com.kwad.components.ad.g.b;

import android.view.View;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.al;

/* loaded from: classes2.dex */
public final class d extends com.kwad.components.ad.g.a.a {
    private View oq;

    /* renamed from: com.kwad.components.ad.g.b.d$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            d.this.eQ();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            d.this.eQ();
        }
    }

    public void eQ() {
        if (this.oq.getVisibility() != 0) {
            return;
        }
        this.oq.setVisibility(8);
    }

    @Override // com.kwad.components.ad.g.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        if (al.isNetworkConnected(this.oq.getContext())) {
            this.oq.setVisibility(8);
            return;
        }
        this.oq.setVisibility(0);
        AnonymousClass1 anonymousClass1 = new l() { // from class: com.kwad.components.ad.g.b.d.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                d.this.eQ();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                d.this.eQ();
            }
        };
        this.mVideoPlayStateListener = anonymousClass1;
        this.f11530oe.f11531of.b((com.kwad.components.core.video.k) anonymousClass1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.oq = findViewById(R.id.ksad_video_network_unavailable);
    }
}
