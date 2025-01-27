package com.kwad.components.ad.e.a;

import android.view.View;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;

/* loaded from: classes.dex */
public final class i extends com.kwad.components.ad.e.kwai.a implements View.OnClickListener {
    private DetailVideoView mDetailVideoView;

    /* renamed from: com.kwad.components.ad.e.a.i$1 */
    final class AnonymousClass1 extends com.kwad.components.core.video.j {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            super.onVideoPlayStart();
            i.this.mDetailVideoView.setOnClickListener(i.this);
        }
    }

    /* renamed from: com.kwad.components.ad.e.a.i$2 */
    final class AnonymousClass2 implements a.b {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            com.kwad.sdk.core.report.a.a(i.this.ni.mAdTemplate, 2, i.this.ni.nd.getTouchCoords());
        }
    }

    private void eW() {
        com.kwad.components.core.d.b.a.a(new a.C0172a(this.mDetailVideoView.getContext()).I(this.ni.mAdTemplate).b(this.ni.mApkDownloadHelper).a(new a.b() { // from class: com.kwad.components.ad.e.a.i.2
            AnonymousClass2() {
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(i.this.ni.mAdTemplate, 2, i.this.ni.nd.getTouchCoords());
            }
        }));
    }

    private void notifyAdClick() {
        this.ni.mR.l(this.mDetailVideoView);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        AnonymousClass1 anonymousClass1 = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.i.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayStart() {
                super.onVideoPlayStart();
                i.this.mDetailVideoView.setOnClickListener(i.this);
            }
        };
        this.mVideoPlayStateListener = anonymousClass1;
        this.ni.nj.a(anonymousClass1);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.mDetailVideoView) {
            eW();
            notifyAdClick();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mDetailVideoView.setOnClickListener(null);
    }
}
