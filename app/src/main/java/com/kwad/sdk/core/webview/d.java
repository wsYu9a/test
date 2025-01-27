package com.kwad.sdk.core.webview;

import com.kwad.sdk.core.webview.a.c;

/* loaded from: classes3.dex */
public final class d {
    private long aIo;
    private boolean aIp;

    public static void d(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.b(aVar.getAdTemplate(), aVar.oz());
        }
    }

    public final void a(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), aVar.oz());
        }
        if (aVar != null) {
            this.aIo = System.currentTimeMillis();
        }
    }

    public final void b(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.k(aVar.getAdTemplate(), System.currentTimeMillis() - this.aIo);
        }
    }

    public final void c(c.a aVar) {
        if (aVar == null || this.aIp) {
            return;
        }
        this.aIp = true;
        long j10 = 0;
        if (this.aIo > 0) {
            j10 = System.currentTimeMillis() - this.aIo;
            this.aIo = -1L;
        }
        com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), aVar.oz(), j10);
    }
}
