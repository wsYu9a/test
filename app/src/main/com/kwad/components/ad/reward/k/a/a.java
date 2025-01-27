package com.kwad.components.ad.reward.k.a;

import com.kwad.components.ad.reward.g;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.core.webview.tachikoma.c.b {
    private g yT;

    public a(g gVar) {
        this.yT = gVar;
    }

    public final void b(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.c.a.hg().a(this.mAdTemplate, bVar);
    }

    public final g jD() {
        return this.yT;
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.b, com.kwad.sdk.mvp.a
    public final void release() {
        super.release();
        this.yT = null;
    }
}
