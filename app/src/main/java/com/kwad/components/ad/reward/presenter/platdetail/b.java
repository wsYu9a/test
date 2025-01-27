package com.kwad.components.ad.reward.presenter.platdetail;

import android.graphics.Color;
import android.view.View;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements c {
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.b$1 */
    final class AnonymousClass1 implements a.b {
        final /* synthetic */ boolean tN;

        AnonymousClass1(boolean z) {
            z = z;
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            b.this.P(z);
        }
    }

    public void P(boolean z) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, new i().bj(z ? 85 : TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND).c(this.qt.mRootContainer.getTouchCoords()), this.qt.mReportExtData);
        this.qt.mAdOpenInteractionListener.bN();
    }

    private void b(View view, boolean z) {
        com.kwad.components.core.d.b.a.a(new a.C0172a(view.getContext()).I(this.mAdTemplate).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.1
            final /* synthetic */ boolean tN;

            AnonymousClass1(boolean z2) {
                z = z2;
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                b.this.P(z);
            }
        }).b(this.mApkDownloadHelper).ao(false).ap(3));
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        j jVar = this.qt;
        this.mAdTemplate = jVar.mAdTemplate;
        this.mApkDownloadHelper = jVar.mApkDownloadHelper;
        new f(this.mDetailVideoView, this);
        this.mDetailVideoView.setBackgroundColor(Color.parseColor(com.kwad.sdk.core.response.a.a.aR(d.cb(this.mAdTemplate)) ? "#B3000000" : "#4D000000"));
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
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
}
