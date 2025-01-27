package com.kwad.components.ad.g.b;

import android.widget.ImageView;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* loaded from: classes2.dex */
public final class g extends com.kwad.components.ad.g.a.a {
    private ImageView oy;

    /* renamed from: com.kwad.components.ad.g.b.g$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            g.this.eT();
        }
    }

    public void eT() {
        KSImageLoader.loadImage(this.oy, com.kwad.sdk.core.response.b.a.X(com.kwad.sdk.core.response.b.e.eb(this.f11530oe.mAdTemplate)), this.f11530oe.mAdTemplate);
        this.oy.setVisibility(0);
    }

    @Override // com.kwad.components.ad.g.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        AnonymousClass1 anonymousClass1 = new l() { // from class: com.kwad.components.ad.g.b.g.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                g.this.eT();
            }
        };
        this.mVideoPlayStateListener = anonymousClass1;
        this.f11530oe.f11531of.b((com.kwad.components.core.video.k) anonymousClass1);
        this.oy.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.oy = (ImageView) findViewById(R.id.ksad_video_cover_image);
    }
}
