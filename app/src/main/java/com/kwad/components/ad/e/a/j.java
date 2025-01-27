package com.kwad.components.ad.e.a;

import android.view.View;
import com.kwad.sdk.R;

/* loaded from: classes.dex */
public final class j extends com.kwad.components.ad.e.kwai.a {
    private View nF;

    /* renamed from: com.kwad.components.ad.e.a.j$1 */
    final class AnonymousClass1 extends com.kwad.components.core.video.j {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            j.this.eX();
        }
    }

    public void eX() {
        if (this.nF.getVisibility() == 0) {
            return;
        }
        this.nF.setVisibility(0);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.nF.setVisibility(8);
        AnonymousClass1 anonymousClass1 = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.j.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i2, int i3) {
                j.this.eX();
            }
        };
        this.mVideoPlayStateListener = anonymousClass1;
        this.ni.nj.a(anonymousClass1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nF = findViewById(R.id.ksad_video_error_container);
    }
}
