package com.kwad.components.ad.e.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.R;

/* loaded from: classes.dex */
public final class h extends com.kwad.components.ad.e.kwai.a implements View.OnClickListener {
    private ViewGroup nB;
    private TextView nC;

    /* renamed from: com.kwad.components.ad.e.a.h$1 */
    final class AnonymousClass1 extends com.kwad.components.core.video.j {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            h.this.eU();
        }
    }

    /* renamed from: com.kwad.components.ad.e.a.h$2 */
    final class AnonymousClass2 implements a.b {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            com.kwad.sdk.core.report.a.a(h.this.ni.mAdTemplate, 2, h.this.ni.nd.getTouchCoords());
        }
    }

    public void eU() {
        this.nC.setText(com.kwad.sdk.core.response.a.a.aw(com.kwad.sdk.core.response.a.d.cb(this.ni.mAdTemplate)));
        this.nB.setOnClickListener(this);
        this.nB.setVisibility(0);
    }

    private void eW() {
        com.kwad.components.core.d.b.a.a(new a.C0172a(this.nB.getContext()).I(this.ni.mAdTemplate).ap(2).a(new a.b() { // from class: com.kwad.components.ad.e.a.h.2
            AnonymousClass2() {
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(h.this.ni.mAdTemplate, 2, h.this.ni.nd.getTouchCoords());
            }
        }));
    }

    private void notifyAdClick() {
        this.ni.mR.l(this.nB);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        AnonymousClass1 anonymousClass1 = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.h.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                h.this.eU();
            }
        };
        this.mVideoPlayStateListener = anonymousClass1;
        this.ni.nj.a(anonymousClass1);
        this.nB.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        eW();
        notifyAdClick();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nB = (ViewGroup) findViewById(R.id.ksad_video_complete_h5_container);
        this.nC = (TextView) findViewById(R.id.ksad_h5_open);
    }
}
