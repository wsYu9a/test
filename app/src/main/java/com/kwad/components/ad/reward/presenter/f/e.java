package com.kwad.components.ad.reward.presenter.f;

import com.kwad.components.ad.reward.g;
import com.kwad.components.core.webview.jshandler.ay;

/* loaded from: classes2.dex */
public final class e implements g.a {
    private ay cU;

    /* renamed from: yc */
    private boolean f11769yc;

    /* renamed from: yd */
    private boolean f11770yd;

    private void jt() {
        ay ayVar = this.cU;
        if (ayVar == null || !this.f11770yd) {
            return;
        }
        if (this.f11769yc) {
            ayVar.ty();
            return;
        }
        ayVar.tu();
        this.cU.tv();
        this.f11769yc = true;
    }

    public final void A(com.kwad.components.ad.reward.g gVar) {
        gVar.a(this);
    }

    public final void B(com.kwad.components.ad.reward.g gVar) {
        ay ayVar = this.cU;
        if (ayVar != null) {
            ayVar.tw();
            this.cU.tx();
        }
        gVar.b(this);
    }

    public final void ay() {
        jt();
    }

    public final void b(ay ayVar) {
        this.cU = ayVar;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void go() {
        this.f11770yd = true;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void gp() {
        this.f11770yd = true;
        jt();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void gq() {
        this.f11770yd = false;
        ay ayVar = this.cU;
        if (ayVar != null) {
            ayVar.tz();
        }
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void gr() {
        this.f11770yd = false;
    }

    public final void ju() {
        ay ayVar = this.cU;
        if (ayVar != null) {
            ayVar.tw();
            this.cU.tx();
        }
    }
}
