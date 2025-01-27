package com.kwad.components.ad.splashscreen.b;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public final class f extends e {
    private ComplianceTextView cq;

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.cq.setVisibility(0);
        this.cq.setAdTemplate(this.Cg.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
        this.cq = complianceTextView;
        complianceTextView.setBackgroundColor(0);
    }
}
