package com.kwad.components.ad.reward.h;

import com.kwad.components.core.webview.jshandler.ac;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class p extends ac {
    private WeakReference<com.kwad.components.ad.reward.j> qm;
    private long xa;

    public p(com.kwad.components.ad.reward.j jVar, long j2, com.kwad.sdk.core.webview.b bVar) {
        super(bVar);
        this.xa = -1L;
        this.xa = j2;
        if (jVar != null) {
            this.qm = new WeakReference<>(jVar);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.ac
    public final void a(com.kwad.sdk.core.report.i iVar) {
        super.a(iVar);
        WeakReference<com.kwad.components.ad.reward.j> weakReference = this.qm;
        if (weakReference != null && weakReference.get() != null) {
            iVar.S(this.qm.get().oN.getPlayDuration());
            return;
        }
        long j2 = this.xa;
        if (j2 > 0) {
            iVar.S(j2);
        }
    }
}
