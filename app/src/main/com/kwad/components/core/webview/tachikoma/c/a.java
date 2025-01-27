package com.kwad.components.core.webview.tachikoma.c;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.s;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: classes3.dex */
public abstract class a extends Presenter implements j {
    protected b adD;
    protected i hw;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void as() {
        super.as();
        b bVar = (b) Lj();
        this.adD = bVar;
        a(bVar);
        if (this.hw == null) {
            this.hw = ii();
        }
        StyleTemplate styleTemplate = this.adD.Vh;
        if (styleTemplate != null) {
            this.hw.a(styleTemplate);
        }
        i iVar = this.hw;
        b bVar2 = this.adD;
        iVar.a(bVar2.mActivity, bVar2.mAdResultData, this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void az() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.adD.adE;
    }

    public i ii() {
        return new i(this.adD.yV, getContext());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.hw.jK();
        this.hw = null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(m mVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(t tVar) {
    }

    public void a(b bVar) {
    }

    public void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
    }

    public void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    public void a(WebCloseStatus webCloseStatus) {
        e eVar = this.adD.abM;
        if (eVar != null) {
            eVar.dismiss();
        }
    }
}
