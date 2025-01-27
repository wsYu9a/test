package com.kwad.components.ad.e.a;

import android.widget.ProgressBar;
import com.kwad.sdk.R;

/* loaded from: classes.dex */
public final class k extends com.kwad.components.ad.e.kwai.a {
    private ProgressBar nH;

    /* renamed from: com.kwad.components.ad.e.a.k$1 */
    final class AnonymousClass1 extends com.kwad.components.core.video.j {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            k.this.eY();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            k.this.eY();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            k.this.K(j2 != 0 ? (int) ((j3 * 100.0f) / j2) : 0);
        }
    }

    public void K(int i2) {
        this.nH.setProgress(i2);
        if (this.nH.getVisibility() == 0) {
            return;
        }
        this.nH.setVisibility(0);
    }

    public void eY() {
        if (this.nH.getVisibility() != 0) {
            return;
        }
        this.nH.setVisibility(8);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.nH.setProgress(0);
        this.nH.setVisibility(8);
        AnonymousClass1 anonymousClass1 = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.k.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                k.this.eY();
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i2, int i3) {
                k.this.eY();
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayProgress(long j2, long j3) {
                k.this.K(j2 != 0 ? (int) ((j3 * 100.0f) / j2) : 0);
            }
        };
        this.mVideoPlayStateListener = anonymousClass1;
        this.ni.nj.a(anonymousClass1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nH = (ProgressBar) findViewById(R.id.ksad_video_progress);
    }
}
