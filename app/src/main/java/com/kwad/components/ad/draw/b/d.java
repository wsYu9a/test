package com.kwad.components.ad.draw.b;

import android.widget.TextView;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.al;

/* loaded from: classes2.dex */
public final class d extends com.kwad.components.ad.draw.a.a {
    private TextView dN;
    private k mVideoPlayStateListener = new l() { // from class: com.kwad.components.ad.draw.b.d.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            d.this.dN.setVisibility(0);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            d.this.dN.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            d.this.dN.setVisibility(8);
        }
    };

    /* renamed from: com.kwad.components.ad.draw.b.d$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            d.this.dN.setVisibility(0);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            d.this.dN.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            d.this.dN.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        if (al.isNetworkConnected(getContext())) {
            this.dN.setVisibility(8);
        } else {
            this.dN.setVisibility(0);
        }
        this.f11413df.f11415dg.b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dN = (TextView) findViewById(R.id.ksad_video_fail_tip);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f11413df.f11415dg.a(this.mVideoPlayStateListener);
    }
}
