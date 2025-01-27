package com.kwad.components.ad.fullscreen.c.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private TextView iA;
    private String iB;
    private long iC;

    /* renamed from: ia */
    private l f11513ia = new l() { // from class: com.kwad.components.ad.fullscreen.c.a.b.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            b.this.g(j11);
        }
    };
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* renamed from: com.kwad.components.ad.fullscreen.c.a.b$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            b.this.g(j11);
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.c.a.b$2 */
    public class AnonymousClass2 implements a.b {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            b.this.notifyAdClick();
        }
    }

    private void cw() {
        this.iC = com.kwad.sdk.core.response.b.d.dN(this.mAdTemplate);
        String dO = com.kwad.sdk.core.response.b.d.dO(this.mAdTemplate);
        this.iB = dO;
        if (TextUtils.isEmpty(dO)) {
            return;
        }
        g gVar = this.rO;
        this.mApkDownloadHelper = gVar.mApkDownloadHelper;
        gVar.f11689qf.a(this.f11513ia);
    }

    private void cx() {
        if (this.iA.getVisibility() == 0) {
            return;
        }
        this.iA.setText(com.kwad.sdk.core.response.b.d.dO(this.mAdTemplate));
        this.iA.setVisibility(0);
        this.iA.setOnClickListener(this);
        cy();
    }

    private void cy() {
        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 18, this.rO.mReportExtData);
    }

    public void g(long j10) {
        if (j10 >= this.iC) {
            cx();
        }
    }

    public void notifyAdClick() {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().f(this.rO.mRootContainer.getTouchCoords()).cL(40), this.rO.mReportExtData);
        this.rO.f11688qe.cg();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        cw();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.iA) {
            com.kwad.components.core.e.d.a.a(new a.C0427a(view.getContext()).au(this.mAdTemplate).b(this.mApkDownloadHelper).an(40).am(1).ap(false).ah(this.rO.fT()).ao(1).a(new a.b() { // from class: com.kwad.components.ad.fullscreen.c.a.b.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    b.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.iA = (TextView) findViewById(R.id.ksad_detail_call_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.iA = null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (TextUtils.isEmpty(this.iB)) {
            return;
        }
        this.rO.f11689qf.b(this.f11513ia);
    }
}
