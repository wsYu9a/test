package com.kwad.components.ad.reward.presenter;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;

/* loaded from: classes.dex */
public final class c extends a {
    private ComplianceTextView cq;
    private com.kwad.components.core.webview.a.d.e gG = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.reward.presenter.c.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (com.kwad.components.core.webview.a.j.b("ksad-video-top-bar", c.this.qt.mAdTemplate).equals(str)) {
                c.this.cq.setVisibility(0);
                c.this.cq.setAdTemplate(c.this.qt.mAdTemplate);
            }
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.c$1 */
    final class AnonymousClass1 extends com.kwad.components.core.webview.a.d.e {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (com.kwad.components.core.webview.a.j.b("ksad-video-top-bar", c.this.qt.mAdTemplate).equals(str)) {
                c.this.cq.setVisibility(0);
                c.this.cq.setAdTemplate(c.this.qt.mAdTemplate);
            }
        }
    }

    private boolean ht() {
        com.kwad.components.ad.reward.j jVar = this.qt;
        return jVar.pf ? com.kwad.components.ad.reward.j.b(jVar) : com.kwad.components.ad.reward.j.c(jVar);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
        if (ht()) {
            return;
        }
        this.cq.setVisibility(0);
        this.cq.setAdTemplate(this.qt.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cq = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
    }
}
