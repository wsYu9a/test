package com.kwad.components.ad.reward.presenter;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public final class d extends b {
    private ComplianceTextView dx;

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.dx.setVisibility(0);
        this.dx.setAdTemplate(this.rO.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dx = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
    }
}
