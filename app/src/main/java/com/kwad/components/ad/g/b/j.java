package com.kwad.components.ad.g.b;

import android.view.View;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public final class j extends com.kwad.components.ad.g.a.a {
    private View oE;

    /* renamed from: com.kwad.components.ad.g.b.j$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            j.this.eV();
        }
    }

    public void eV() {
        if (this.oE.getVisibility() == 0) {
            return;
        }
        this.oE.setVisibility(0);
    }

    @Override // com.kwad.components.ad.g.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.oE.setVisibility(8);
        AnonymousClass1 anonymousClass1 = new l() { // from class: com.kwad.components.ad.g.b.j.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i10, int i11) {
                j.this.eV();
            }
        };
        this.mVideoPlayStateListener = anonymousClass1;
        this.f11530oe.f11531of.b((com.kwad.components.core.video.k) anonymousClass1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.oE = findViewById(R.id.ksad_video_error_container);
    }
}
