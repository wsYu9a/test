package com.kwad.components.ad.reward.presenter.platdetail;

import android.graphics.Color;
import android.view.View;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.widget.f;

/* loaded from: classes2.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements com.kwad.sdk.widget.c {
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.c$1 */
    public class AnonymousClass1 implements a.b {
        final /* synthetic */ boolean vU;

        public AnonymousClass1(boolean z10) {
            z10 = z10;
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            c.this.L(z10);
        }
    }

    public void L(boolean z10) {
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, "native_id", "videoPlayer", new com.kwad.sdk.core.adlog.c.b().cL(z10 ? 85 : 153).f(this.rO.mRootContainer.getTouchCoords()), this.rO.mReportExtData);
        this.rO.f11688qe.cg();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.mApkDownloadHelper = this.rO.mApkDownloadHelper;
        new f(this.mDetailVideoView, this);
        this.mDetailVideoView.setBackgroundColor(Color.parseColor(com.kwad.sdk.core.response.b.a.aY(e.eb(this.mAdTemplate)) ? "#B3000000" : "#4D000000"));
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (d.dQ(this.mAdTemplate)) {
            b(view, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mDetailVideoView.setClickListener(null);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }

    private void b(View view, boolean z10) {
        com.kwad.components.core.e.d.a.a(new a.C0427a(view.getContext()).au(this.mAdTemplate).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.c.1
            final /* synthetic */ boolean vU;

            public AnonymousClass1(boolean z102) {
                z10 = z102;
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                c.this.L(z10);
            }
        }).b(this.mApkDownloadHelper).ap(false).v(this.rO.qK).ao(3));
    }
}
