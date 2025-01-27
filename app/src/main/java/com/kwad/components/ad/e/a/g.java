package com.kwad.components.ad.e.a;

import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* loaded from: classes.dex */
public final class g extends com.kwad.components.ad.e.kwai.a {
    private ImageView nz;

    /* renamed from: com.kwad.components.ad.e.a.g$1 */
    final class AnonymousClass1 extends com.kwad.components.core.video.j {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            g.this.eV();
        }
    }

    public void eV() {
        KSImageLoader.loadImage(this.nz, com.kwad.sdk.core.response.a.a.O(com.kwad.sdk.core.response.a.d.cb(this.ni.mAdTemplate)), this.ni.mAdTemplate);
        this.nz.setVisibility(0);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        AnonymousClass1 anonymousClass1 = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.g.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                g.this.eV();
            }
        };
        this.mVideoPlayStateListener = anonymousClass1;
        this.ni.nj.a(anonymousClass1);
        this.nz.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nz = (ImageView) findViewById(R.id.ksad_video_cover_image);
    }
}
