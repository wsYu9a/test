package com.kwad.components.ad.g.b;

import android.widget.ProgressBar;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public final class k extends com.kwad.components.ad.g.a.a {
    private ProgressBar oG;

    /* renamed from: com.kwad.components.ad.g.b.k$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            k.this.eW();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            k.this.eW();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            k.this.I(j10 != 0 ? (int) ((j11 * 100.0f) / j10) : 0);
        }
    }

    public void I(int i10) {
        this.oG.setProgress(i10);
        if (this.oG.getVisibility() == 0) {
            return;
        }
        this.oG.setVisibility(0);
    }

    public void eW() {
        if (this.oG.getVisibility() != 0) {
            return;
        }
        this.oG.setVisibility(8);
    }

    @Override // com.kwad.components.ad.g.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.oG.setProgress(0);
        this.oG.setVisibility(8);
        AnonymousClass1 anonymousClass1 = new l() { // from class: com.kwad.components.ad.g.b.k.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                k.this.eW();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i10, int i11) {
                k.this.eW();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j10, long j11) {
                k.this.I(j10 != 0 ? (int) ((j11 * 100.0f) / j10) : 0);
            }
        };
        this.mVideoPlayStateListener = anonymousClass1;
        this.f11530oe.f11531of.b((com.kwad.components.core.video.k) anonymousClass1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.oG = (ProgressBar) findViewById(R.id.ksad_video_progress);
    }
}
