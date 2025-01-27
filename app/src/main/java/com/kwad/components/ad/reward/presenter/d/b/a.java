package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    private TextView xo;
    private TextView xp;

    /* renamed from: com.kwad.components.ad.reward.presenter.d.b.a$1 */
    public class AnonymousClass1 implements a.b {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            a.this.iY();
            a.this.notifyAdClick();
        }
    }

    private void cy() {
        g gVar = this.rO;
        com.kwad.sdk.core.adlog.c.b(gVar.mAdTemplate, 17, gVar.mReportExtData);
    }

    private void iX() {
        String dP = com.kwad.sdk.core.response.b.d.dP(this.rO.mAdTemplate);
        if (this.rO.mScreenOrientation == 1) {
            this.xp.setVisibility(8);
            this.xo.setText(dP);
            this.xo.setVisibility(0);
            this.xo.setOnClickListener(this);
        } else {
            this.xo.setVisibility(8);
            this.xp.setText(dP);
            this.xp.setVisibility(0);
            this.xp.setOnClickListener(this);
        }
        cy();
    }

    public void iY() {
        com.kwad.sdk.core.adlog.c.b cL = new com.kwad.sdk.core.adlog.c.b().f(this.rO.mRootContainer.getTouchCoords()).cL(39);
        g gVar = this.rO;
        com.kwad.components.ad.reward.j.b.a(gVar.mAdTemplate, "native_id", "endTopBar", cL, gVar.mReportExtData);
    }

    public void notifyAdClick() {
        this.rO.f11688qe.cg();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void iZ() {
        if (this.rO.qH) {
            return;
        }
        iX();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.xo || view == this.xp) {
            com.kwad.components.core.e.d.a.a(new a.C0427a(view.getContext()).au(this.rO.mAdTemplate).b(this.rO.mApkDownloadHelper).ap(false).ao(1).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.d.b.a.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    a.this.iY();
                    a.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.xo = (TextView) findViewById(R.id.ksad_end_left_call_btn);
        this.xp = (TextView) findViewById(R.id.ksad_end_right_call_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.xo.setVisibility(8);
        this.xp.setVisibility(8);
    }
}
